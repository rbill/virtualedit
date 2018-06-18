package at.ac.tuwien.big.vfunc.basic.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.basic.AssignmentType;
import at.ac.tuwien.big.vfunc.basic.Editor;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.ValueCache;
import at.ac.tuwien.big.vfunc.basic.impl.BasicAssignment;
import at.ac.tuwien.big.vfunc.basic.impl.BasicExpression;
import at.ac.tuwien.big.vfunc.basic.impl.BasicInfiniteScope;
import at.ac.tuwien.big.vfunc.basic.impl.EditingStructure;
import at.ac.tuwien.big.vfunc.basic.impl.GeneralParseContainer;
import at.ac.tuwien.big.vfunc.basic.impl.SetScope;
import at.ac.tuwien.big.vfunc.basic.impl.VariableRecManager;
import at.ac.tuwien.big.vfunc.op.BasicFunction;
import at.ac.tuwien.big.vfunc.op.BasicOperationManager;
import at.ac.tuwien.big.virtmodel.vLang.AssignStatement;
import at.ac.tuwien.big.virtmodel.vLang.BasicAction;
import at.ac.tuwien.big.virtmodel.vLang.Block;
import at.ac.tuwien.big.virtmodel.vLang.CalculatedValue;
import at.ac.tuwien.big.virtmodel.vLang.DeleteAssignment;
import at.ac.tuwien.big.virtmodel.vLang.Expression;
import at.ac.tuwien.big.virtmodel.vLang.Filter;
import at.ac.tuwien.big.virtmodel.vLang.FixedValue;
import at.ac.tuwien.big.virtmodel.vLang.ForLoopStatement;
import at.ac.tuwien.big.virtmodel.vLang.ForStatement;
import at.ac.tuwien.big.virtmodel.vLang.FullFunction;
import at.ac.tuwien.big.virtmodel.vLang.FullFunctionAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FunctionAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FunctionCall;
import at.ac.tuwien.big.virtmodel.vLang.FunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.FunctionDomainScope;
import at.ac.tuwien.big.virtmodel.vLang.FunctionPar;
import at.ac.tuwien.big.virtmodel.vLang.FunctionParDef;
import at.ac.tuwien.big.virtmodel.vLang.FunctionScope;
import at.ac.tuwien.big.virtmodel.vLang.FunctionType;
import at.ac.tuwien.big.virtmodel.vLang.IfStatement;
import at.ac.tuwien.big.virtmodel.vLang.IfThenElse;
import at.ac.tuwien.big.virtmodel.vLang.Import;
import at.ac.tuwien.big.virtmodel.vLang.InfiniteScope;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionCall;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionType;
import at.ac.tuwien.big.virtmodel.vLang.LetStatement;
import at.ac.tuwien.big.virtmodel.vLang.ObjId;
import at.ac.tuwien.big.virtmodel.vLang.ObjParam;
import at.ac.tuwien.big.virtmodel.vLang.OclFunction;
import at.ac.tuwien.big.virtmodel.vLang.ParDef;
import at.ac.tuwien.big.virtmodel.vLang.ReturnStatement;
import at.ac.tuwien.big.virtmodel.vLang.RuleAssignment;
import at.ac.tuwien.big.virtmodel.vLang.SetDef;
import at.ac.tuwien.big.virtmodel.vLang.SetLiteral;
import at.ac.tuwien.big.virtmodel.vLang.SetOrFunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.SingleScope;
import at.ac.tuwien.big.virtmodel.vLang.SingleStatement;
import at.ac.tuwien.big.virtmodel.vLang.SingleValue;
import at.ac.tuwien.big.virtmodel.vLang.VLang;
import at.ac.tuwien.big.vmod.type.Symbol;

public class FileReader {

	InterpretationState parseState;
	
	public InterpretationState clonedState() {
		return parseState.cloneNew();
	}
	
	public FileReader() {
		parseState = new InterpretationState(new GeneralParseContainer(new BasicOperationManager()));
	}
	
	private EditingStructure getEditingStructure() {
		return parseState.getManager().getEditingStructure();
	}
	
	private List<BasicStatement> baseStatements = new ArrayList<BasicStatement>();
		
	public void parseFile(VLang file) {
		for (Import imp: file.getImports()) {
			System.err.println("Imports not yet supported!");
		}
		for (AssignStatement statement: file.getStatement()) {
			parseGStatement(statement, baseStatements);
		}
	}
	
	private void parseGStatement(AssignStatement statement, List<BasicStatement> baseStatements) {
		if (statement instanceof JavaFunctionDef) {
			//This is global
			parseStatement((JavaFunctionDef)statement);
		} //But these things are probably not, so they should be compiled and then executed		
		else if (statement instanceof SetOrFunctionDef) {
			parseStatement((SetOrFunctionDef)statement);
		} else if (statement instanceof BasicAction) {
			parseStatement((BasicAction)statement);
		} else if (statement instanceof DeleteAssignment) {
			parseStatement((DeleteAssignment)statement);
		} else if (statement instanceof RuleAssignment) {
			parseStatement((RuleAssignment)statement);
		} 
	}
	


	private void parseStatement(JavaFunctionDef statement) {
		BasicOperationManager bom = parseState.getLoader();
		switch(statement.getType()) {
		case CONSTRUCTOR:
			bom.setNewObjectClass(statement.getName(), statement.getJavaFunc());
			break;
		case FUNCCALL:
			bom.setFunctionClass(statement.getName(), statement.getJavaFunc());
			break;
		case OPERATION:
			bom.setOperationClass(statement.getName(), statement.getJavaFunc());
			break;
			
		}
	}
	
	private void compileCreateSet(String name, List<BasicStatement> statements) {
		statements.add((state)->{
			state.addSet(name);
		});
	}
	
	private void compileFunctionCall(String retVariable, SingleValue sv, List<BasicStatement> statements) {
		if (sv instanceof CalculatedValue) {
			compileFunctionCall(retVariable, (CalculatedValue)sv, statements);
		} else if (sv instanceof FixedValue) {
			compileValue((FixedValue)sv, retVariable, statements);
		}
		
	}
	
	private void compileFunctionCall(String retVariable, CalculatedValue sv, List<BasicStatement> statements) {
		if (sv instanceof FunctionCall) {
			compileFunctionCall(retVariable, (FunctionCall)sv, statements);
		} else if (sv instanceof IfThenElse) {
			compileFunctionCall(retVariable, (IfThenElse)sv, statements);
		}
		
	}
	
	private void compileFunctionCall(String retVariable, FunctionCall fv, List<BasicStatement> statements) {
		compileFunctionCall(retVariable, fv.getFunction().getName(),
				fv.getParams(), JavaFunctionType.FUNCCALL,
				statements);
	}
	

	public Object evaluateNow(FunctionPar par) {
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		String parName = "$$";
		BasicStatement.createDirectVar(subStatements, parName);
		compileFunctionCall(parName, par, subStatements);
		return parseState.executeNow(subStatements, parName)[0];
	}

	private void compileFunctionCall(String retVariable, String name, List<? extends FunctionPar> params, JavaFunctionType type, List<BasicStatement> statements) {
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();


		String[] parameters = new String[params.size()];
		for (int i = 0; i < params.size(); ++i) {
			FunctionPar par = params.get(i);
			String parName = "$par"+(i+1);
			parameters[i] = parName;
			BasicStatement.createDirectVar(subStatements, parName);
			compileFunctionCall(parName, par, subStatements);
			
		}
		switch(type) {
		case CONSTRUCTOR:
			BasicStatement.construct(subStatements, name, parameters, retVariable);
			break;
		case FUNCCALL:
			BasicStatement.callFunction(subStatements, name, parameters, retVariable);
			break;
		case OPERATION:
			System.err.println("Operation may not be called in function!");
			//BasicStatement.callFunction(subStatements, name, parameters, retVariable);
			break;
		}
		
		statements.add(new BasicStatement.SubFuncStatement(subStatements));
		
	}
	
	private void compileFunctionCall(String retVariable, FunctionAssignment fa, List<BasicStatement> statements) {
		if (fa instanceof FullFunctionAssignment) {
			compileFunctionCall(retVariable, (FullFunctionAssignment)fa, statements);
		} else if (fa instanceof at.ac.tuwien.big.virtmodel.vLang.Expression) {
			compileFunctionCall(retVariable, (at.ac.tuwien.big.virtmodel.vLang.Expression)fa, statements);
		}
	}
	
	private ISFunction convertFunctionCall(FullFunctionAssignment fa) {
		
		//Hier definiere ich eine Funktion
		ParDef parameters = fa.getParameters();
		String[] parList = new String[parameters.getParams().size()];
		int idx = 0;
		for (FunctionParDef fpd: parameters.getParams()) {
			String name = fpd.getName();
			String type = fpd.getType();
			parList[idx] = name;
			++idx;
		}
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		Expression expr = fa.getExpr();
		compileFunctionCall(VariableRecManager.RETURN_VAR, expr, subStatements);
		return new ISFunction(clonedState(), subStatements, parList);
	}
	
	public at.ac.tuwien.big.vfunc.basic.Expression<?, ?> toExpression(ISFunction isfunc) {
		java.util.function.Function<Object[],Object> jfunc = (pars)->isfunc.apply(pars);
		at.ac.tuwien.big.vfunc.basic.Expression expr = new BasicExpression<>(jfunc); 
		return expr;
	}
	
	private ISFunction convertFunctionCall(Expression fa) {
		
		
		//Hier definiere ich eine Funktion
		String[] parList = new String[0];
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		Expression expr = fa;
		compileFunctionCall(VariableRecManager.RETURN_VAR, expr, subStatements);
		return new ISFunction(clonedState(), subStatements, parList);
	}
	
	private ISFunction convertFunctionCall(FunctionAssignment fas) {
		if (fas instanceof Expression) {
			return convertFunctionCall((Expression)fas);
		} else {
			return convertFunctionCall((FullFunctionAssignment)fas);
		}
	}

	private void compileFunctionCall(String retVariable, FullFunctionAssignment fa, List<BasicStatement> statements) {
	
		statements.add((state)->state.set(retVariable, convertFunctionCall(fa)));
	}

	private void compileFunctionCall(String retVariable, Expression fa, List<BasicStatement> statements) {
		if (fa instanceof FullFunction) {
			compileFunctionCall(retVariable, (FullFunction)fa, statements);
		} else if (fa instanceof OclFunction) {
			compileFunctionCall(retVariable, (OclFunction)fa, statements);
		} else if (fa instanceof SingleValue) {
			compileFunctionCall(retVariable, (SingleValue)fa, statements);
		}
	}
	
	private void compileFunctionCall(String retVariable, OclFunction fa, List<BasicStatement> statements) {
		throw new UnsupportedOperationException("OCL is not yet supported!");
	}
	
	private void compileFunctionCall(String retVariable, FullFunction fa, List<BasicStatement> statements) {
		if (fa instanceof Block) {
			compileFunctionCall(retVariable, (Block)fa, statements);
		} 
	}
	
	private static final String RETURN_VAR = "$return";
	

	private void compileFunctionCall(String retVariable, Block bl, List<BasicStatement> statements) {
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		subStatements.add((state)->state.createDirectVar(RETURN_VAR));
		for (SingleStatement ss: bl.getStatements()) {
			compileStatement( (SingleStatement)ss, statements);
		}
		BasicStatement.setSuper(retVariable, RETURN_VAR, subStatements);
		BasicStatement.insertSub(statements, subStatements);
	}
	

	private void compileStatement(SingleStatement ss, List<BasicStatement> statements) {
		if (ss instanceof Block) {
			compileFunctionCall("$nowhere",(Block)ss, statements);
		} else if (ss instanceof ForLoopStatement) {
			compileStatement((ForLoopStatement)ss, statements);
		} else if (ss instanceof ForStatement) {
			compileStatement((ForStatement)ss, statements);
		} else if (ss instanceof IfStatement) {
			compileStatement( (IfStatement)ss, statements);
		} else if (ss instanceof LetStatement) {
			compileStatement((LetStatement)ss, statements);
		} else if (ss instanceof ReturnStatement) {
			compileStatement((ReturnStatement)ss, statements);
		}
	}
	
	private void compileStatement(ForLoopStatement ss, List<BasicStatement> blabla) {
		//TODO: Testen ...
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		BasicStatement.createDirectVar(subStatements, "$iterable");
		BasicStatement.createDirectVar(subStatements, "$iterator");
		BasicStatement.createDirectVar(subStatements, ss.getName());
		compileFunctionCall("$iterable", ss.getValue(), subStatements);
		subStatements.add((state)->state.set("$iterator", ((Iterable)state.getContent("$iterable")).iterator()));
		int startSize= subStatements.size();
		subStatements.add((state)->state.set("$cond", ((Iterator)state.getContent("$iterator")).hasNext()));
		subStatements.add((state)->state.set(ss.getName(), ((Iterator)state.getContent("$iterator")).next()));
		subStatements.add(new BasicStatement.CJmpStatement("$cond", 2));
		int jumpStatement = subStatements.size();
		subStatements.add(null);
		compileStatement(ss.getLoopExpr(), subStatements);
		subStatements.add(new BasicStatement.JmpStatement(startSize-subStatements.size()));
		BasicStatement.noOp(subStatements);
		int afterwards = subStatements.size();
		subStatements.set(jumpStatement, new BasicStatement.JmpStatement(afterwards-startSize));
		BasicStatement.insertSub(blabla, subStatements);
	}

	private void compileStatement(ForStatement ss, List<BasicStatement> stmts) {
		//TODO: Testen ...
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		BasicStatement.createDirectVar(subStatements, "$cond");
		compileStatement(ss.getInitVar(),subStatements);
		int startSize = subStatements.size();
		compileFunctionCall("$cond", ss.getCondition(), subStatements);
		subStatements.add(new BasicStatement.CJmpStatement("$cond", 2));
		int jumpStatement = subStatements.size();
		subStatements.add(null);
		compileStatement(ss.getLoopExpr(), subStatements);
		compileStatement(ss.getEndProcessing(), subStatements);
		subStatements.add(new BasicStatement.JmpStatement(startSize-subStatements.size()));
		BasicStatement.noOp(subStatements);
		int afterwards = subStatements.size();
		subStatements.set(jumpStatement, new BasicStatement.JmpStatement(afterwards-startSize));
		BasicStatement.insertSub(stmts, subStatements);
	}
	
	
	private void compileStatement(LetStatement ss, List<BasicStatement> statements) {
		compileFunctionCall(ss.getName(), ss.getValue(), statements);
	}
	
	private void compileStatement(ReturnStatement ss, List<BasicStatement> statements) {
		FunctionAssignment fa = ss.getValue();
		compileFunctionCall(RETURN_VAR, fa, statements);
	}
	
	
	private void compileFunctionCall(String retVariable, IfThenElse sv, List<BasicStatement> statements) {
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		BasicStatement.createDirectVar(subStatements, "$cond");
		BasicStatement.createDirectVar(subStatements, VariableRecManager.RETURN_VAR);
		compileFunctionCall("$cond",sv.getCondition(), subStatements);
		subStatements.add((state)->{
			List<BasicStatement> thenStatements = new ArrayList<>();
			compileFunctionCall(VariableRecManager.RETURN_VAR,sv.getThenExpr(),thenStatements);
			List<BasicStatement> elseStatements = new ArrayList<>();
			compileFunctionCall(VariableRecManager.RETURN_VAR,sv.getElseExpr(),elseStatements);
			state.ifThenElse("$cond", thenStatements, elseStatements);
		});
		BasicStatement.setSuper(retVariable, VariableRecManager.RETURN_VAR, subStatements);
		BasicStatement.insertSub(statements, subStatements);
		
	}
	

	private void compileStatement(String retVariable, IfStatement sv, List<BasicStatement> statements) {
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		BasicStatement.createDirectVar(subStatements, "$cond");
		compileFunctionCall("$cond",sv.getCondition(), subStatements);
		subStatements.add((state)->{
			List<BasicStatement> thenStatements = new ArrayList<>();
			compileStatement(sv.getThenStatement(),thenStatements);
			List<BasicStatement> elseStatements = new ArrayList<>();
			compileStatement(sv.getElseStatement(),elseStatements);
			state.ifThenElse("$cond", thenStatements, elseStatements);
		});
		BasicStatement.setSuper(retVariable, VariableRecManager.RETURN_VAR, subStatements);
		BasicStatement.insertSub(statements, subStatements);
	}
	
	private void compileFunctionCall(String retVariable, FunctionPar fp, List<BasicStatement> statements) {
		compileFunctionCall(retVariable, (SingleValue)fp, statements);
	}
	
	
	private void compileFunctionCall(String retVariable, JavaFunctionCall jfc, List<BasicStatement> statements) {
		JavaFunctionDef jfd = jfc.getFunction();
		String name = jfd.getName();
		compileFunctionCall(retVariable, name, jfc.getParams(), jfd.getType(), statements);
	}
	
	/*
	public Object evaluate(JavaFunctionCall jfc) {
		BasicOperationManager loader = parseState.getLoader();
		String javaName = jfc.getFunction().getName();
		Object[] evaluatedParams = new Object[jfc.getParams().size()];
		for (int i = 0; i < evaluatedParams.length; ++i) {
			evaluatedParams[i] = evaluate(jfc.getParams().get(i));
		}
		return loader.executeFunction(javaName, evaluatedParams);
	}
	

	private Object evaluate(CalculatedValue functionPar) {
		if (functionPar instanceof FunctionCall) {
			return evaluate((FunctionCall)functionPar);
		} else if (functionPar instanceof IfThenElse) {
			return evaluate((IfThenElse)functionPar);
		}
		System.err.println("Unknown CalculatedValue "+functionPar);
		return null;
	}
	
	private Object immediateEvaluate(FunctionAssignment fas) {
		if (fas instanceof at.ac.tuwien.big.virtmodel.vLang.Expression) {
			return immediateEvaluate((at.ac.tuwien.big.virtmodel.vLang.Expression)fas);
		} else if (fas instanceof FullFunctionAssignment) {
			return immediateEvaluate((FullFunctionAssignment)fas);
		}
		System.err.println("Unknown FunctionAssignment "+fas);
		return null;
	}
	

	private Object immediateEvaluate(at.ac.tuwien.big.virtmodel.vLang.Expression fas) {
		if (fas instanceof FullFunction) {
			return immediateEvaluate((FullFunction)fas);
		} else if (fas instanceof OclFunction) {
			return immediateEvaluate((OclFunction)fas);
		} else if (fas instanceof SingleValue) {
			return evaluate((SingleValue)fas);
		}
		System.err.println("Unknown Expression "+fas);
		return null;
	}
	

	private Object immediateEvaluate(FullFunction fas) {
		if (fas instanceof Block) {
			return immediateEvaluate((Block)fas);
		} 
		System.err.println("Unknown FullFunction "+fas);
		return null;
	}

	private Object immediateEvaluate(Block fas) {
		//Convert to interpreted function and execute ...
		 
		System.err.println("Unknown FullFunction "+fas);
		return null;
	}
	

	private Object immediateEvaluate(OclFunction fas) {
		asdf;
		System.err.println("Unknown Expression "+fas);
		return null;
	}

	private Object immediateEvaluate(FullFunctionAssignment fas) {
		if (fas instanceof at.ac.tuwien.big.virtmodel.vLang.Expression) {
			return immediateEvaluate((at.ac.tuwien.big.virtmodel.vLang.Expression)fas);
		} else if (fas instanceof FullFunctionAssignment) {
			return immediateEvaluate((FullFunctionAssignment)fas);
		}
		System.err.println("Unknown FullFunctionAssignment "+fas);
		return null;
	}
	
	private Object evaluate(IfThenElse functionPar) {
		FunctionAssignment cond = functionPar.getCondition();
		Object condition = immediateEvaluate(cond);
		if (condition instanceof Boolean) {
			Boolean b = (Boolean)condition;
			if (b) {
				return immediateEvaluate(functionPar.getThenExpr());
			} else {
				return immediateEvaluate(functionPar.getElseExpr());
			}
		} else {
			System.err.println("Wrong return type of condition: "+condition+" instead of boolean!");
			return null;
		}
	}
	
	private Object evaluate(FunctionCall functionPar) {
		asdf;
		return null;
	}*/
	
	private static Object toObject(ObjParam param) {
		String str = param.getString();
		if (str != null) {
			return str;
		}
		String name = param.getName();
		if (name != null) {
			List<Object> params = new ArrayList<>();
			for (ObjParam sparam: param.getParams()) {
				params.add(toObject(sparam));
			}
			return Symbol.buildFrom(name, params.toArray());
		}
		return param.getNumber();
	}
	
	private static Symbol toSymbol(ObjId objId) {
		List<Object> params = new ArrayList<>();
		for (ObjParam param: objId.getParams()) {
			params.add(toObject(param));
		}
		return Symbol.buildFrom(objId.getName(), params.toArray());
	}
	
	private Object evaluate(FixedValue functionPar) {
		ObjId objId = functionPar.getObjid();
		if (objId != null) {
			return toSymbol(objId);
		} 
		String str = functionPar.getString();
		if (str != null) {
			return str;
		}
		//Here we cannot decide whether 0 or <nothing> was provided, so we give it last
		return functionPar.getNumber();
	}
	/*
	private Object evaluate(SingleValue functionPar) {
		if (functionPar instanceof CalculatedValue) {
			return evaluate((CalculatedValue)functionPar);
		} else if (functionPar instanceof FixedValue) {
			return evaluate((FixedValue)functionPar);
		}
		System.err.println("Unknown SingleValue "+functionPar);
		return null;
	}

	private Object evaluate(FunctionPar functionPar) {
		if (functionPar instanceof SingleValue) {
			return evaluate((SingleValue)functionPar);
		}
		System.err.println("Unknown functionPar "+functionPar);
		return null;
	}*/
	
	public void compileValue(FixedValue value, String retVariable, List<BasicStatement> statements) {
		Object fixedEval = evaluate(value);
		statements.add((state)->state.set(retVariable, fixedEval));
	}
	
	private void compileSetLiterals(String name, SetLiteral literal, List<BasicStatement> statements) {
		final String INSIDERET = "$insideret";
		List<BasicStatement> subStatements = new ArrayList<>();
		for (FixedValue value: literal.getValues()) {
			BasicStatement.createDirectVar(subStatements, INSIDERET);
			compileValue(value, INSIDERET, subStatements);
			subStatements.add((state)->{
				Object addLiteral = state.getContent(INSIDERET);
				Object theSet = state.getContent(name);
				if (theSet instanceof Collection) {
					System.out.println("Have collection set");
					((Collection)theSet).add(addLiteral);
				} else if (theSet instanceof SetScope) {
					System.out.println("Have scope set");
					((SetScope)theSet).getValues().add(addLiteral);
				} else {
					System.err.println("Expected collection or set-scope, but got "+theSet+"!");
				}
			});
		}
		statements.add(new BasicStatement.SubFuncStatement(subStatements));
	}

	private void compileStatement(SetDef statement, List<BasicStatement> statements) {
		String name = statement.getName();
		SetDef sd = (SetDef)statement;
		SetLiteral literal = sd.getLiteral();
		compileCreateSet(name, statements);
		compileSetLiterals(name, literal, statements);
	}
	
	public Object evaluateSetLiteral(SetLiteral literal) {
		List<BasicStatement> bstmt = new ArrayList<BasicStatement>();
		compileSetLiterals(VariableRecManager.RETURN_VAR, literal, bstmt);
		Object[] ret = parseState.executeNow(bstmt, VariableRecManager.RETURN_VAR);
		return ret.length<1?null:ret[0];
	}

	private void compileStatement(FunctionDef statement, List<BasicStatement> statements) {
		String name = statement.getName();
		FunctionDef fd = (FunctionDef)statement;
		at.ac.tuwien.big.virtmodel.vLang.FunctionType ft = fd.getType();
		JavaFunctionCall call = fd.getInit();
		compileFunctionCall(name, call, statements);
		
		FunctionAssignment fa = fd.getFullAssignment();
		switch (ft) {
		case CONSTRAINT:
			
			break;
		case DERIVE:
			break;
		case FINITE:
			break;
		default:
			break;
		}
		statements.add((state)->{
			//Die Funktion ist ja schon da
			VFunction afunc = state.getContent(name, VFunction.class);
			if (afunc instanceof at.ac.tuwien.big.vfunc.basic.impl.BasicFunction) {
				at.ac.tuwien.big.vfunc.basic.impl.BasicFunction func = (at.ac.tuwien.big.vfunc.basic.impl.BasicFunction)afunc;
				ISFunction isfunc = convertFunctionCall(fa);
				at.ac.tuwien.big.vfunc.basic.Expression<?,?> expr = toExpression(isfunc);
				AssignmentType at = null;
				switch(ft) {
				case CONSTRAINT:
					at = AssignmentType.CONSTRAINT;
					break;
				case DERIVE:
					at = AssignmentType.SOFT;
					break;
				case FINITE:
					at = AssignmentType.HARD;
					break;
				}
				Class<?> sourceClass = Object.class; //TODO: ...
				getEditingStructure().addBasicExpression(func, (BasicInfiniteScope)BasicInfiniteScope.EVERYTHING(sourceClass), expr, at);
			} else {
				System.err.println("Could not initialize function "+name+": not a basic function");
			}
		});
	}
	
	private void compileStatement(SetOrFunctionDef statement, List<BasicStatement> statements) {
		if (statement instanceof SetDef) {
			compileStatement((SetDef)statement, statements);
		} else if (statement instanceof FunctionDef) {
			compileStatement((FunctionDef)statement, statements);
		}
	}
	
	
	
	public java.util.function.Function<Object,Boolean> convertFilter(Filter filter) {
		//Das hier ist ein FunctionAssignment, d.h. etwas was evaluiert wird ...
		if (filter instanceof FunctionAssignment) {
			//Hier brauche ich einen Interpreter ...
			//Wobei der Interpreter vom aktuellen Interpreterstate erben muss (!!)
			ISFunction generalFunc = convertFunctionCall((FunctionAssignment)filter);
			//Must take exactly a single parameter
			return (inputPar)->{
				Object output = generalFunc.apply(new Object[]{inputPar});
				if (output instanceof Boolean) {
					return ((Boolean)output);
				}
				System.err.println("Error: filter function returned "+output);
				return false;
			};
		} else {
			System.err.println("Cannot transform "+filter+" as filter");
			return (x)->true;
		}
	}
	
	private Collection<?> toCollection(SetLiteral setLiteral) {
		List<Object> ret = new ArrayList<Object>();
		for (FixedValue val: setLiteral.getValues()) {
			Object eval = evaluate(val);
			ret.add(eval);
		}
		return ret;
	}
	
	public Scope<?> convertScope(FunctionScope oriScope) {
		Filter filter = oriScope.getFilter();
		java.util.function.Function<Object,Boolean> filterFunc = (x)->true;
		if (filter != null) {
			filterFunc = convertFilter(filter);
		}
		if (oriScope instanceof FunctionDomainScope) {
			FunctionDomainScope fds = (FunctionDomainScope)oriScope;
			FunctionDef function = fds.getFunction();
			String functionName = function.getName();
			//The domain of the function
			
			//I think we can only make a dynamic thing anyway
			Object fun = parseState.getContent(functionName);
			if (fun instanceof VFunction) {
				VFunction vfun = (VFunction)fun;
				ValueCache cache = vfun.cache();
				return vfun.getScope();
			} else {
				System.err.println("Expected "+functionName+" to be a function, but was " +fun);
				return null;
			}
		} else if (oriScope instanceof InfiniteScope) {
			InfiniteScope is = (InfiniteScope)oriScope;
			return new BasicInfiniteScope<>(filterFunc);
		} else if (oriScope instanceof at.ac.tuwien.big.virtmodel.vLang.SetScope) {
			at.ac.tuwien.big.virtmodel.vLang.SetScope ss = (at.ac.tuwien.big.virtmodel.vLang.SetScope)oriScope;
			Collection<?> col = toCollection(ss.getSet());
			SetScope<?> retScope = new SetScope<>(col);
			return retScope;
		} else if (oriScope instanceof SingleScope) {
			SingleScope ss = (SingleScope)oriScope;
			SingleValue val = ss.getValue();
			//Shouldn't this be a fixed value!?
			if (val instanceof FixedValue) {
				Object singleThing = evaluate((FixedValue)val);
				return new SetScope<>(Collections.singleton(val));
			} else {
				System.err.println("I don't yet support non-fixed values for scopes and maybe never will");
				return null;
			}
		} else {
			System.err.println("Unknown scope "+oriScope);
			return null;
		}		
	}
	
	public void test() {
	}
	
	private void parseStatement(SetOrFunctionDef statement) {
		List<BasicStatement> statements = new ArrayList<>();
		compileStatement(statement, statements);
		parseState.executeNow(statements);
	}
	
	private AssignmentType convertType(FunctionType type) {
		switch(type) {
		case CONSTRAINT:
			return AssignmentType.CONSTRAINT;
		case DERIVE:
			return AssignmentType.SOFT;
		case FINITE:
			return AssignmentType.HARD;
			default: System.err.println("Unknown function type "+ type); return null;
		}
	}

	private void parseStatement(RuleAssignment statement) {
		FunctionScope scope = statement.getScope();
		Scope cvscope = convertScope(scope);
		FunctionDef function = statement.getFunction();
		FunctionAssignment assignment = statement.getAssignment();
		List<BasicStatement> statements = new ArrayList<>();
		
		statements.add((state)-> { 
			Editor editor = getEditingStructure().getEditor();
			at.ac.tuwien.big.vfunc.basic.Expression target = toExpression(convertFunctionCall(assignment));
			AssignmentType type = convertType(function.getType());
			VFunction existingFunction = parseState.getContent(function.getName(), VFunction.class);
			//BasicAssignment bas  = new BasicAssignment(existingFunction, cvscope, target, editor, type);
			if (existingFunction instanceof at.ac.tuwien.big.vfunc.basic.impl.BasicFunction) {
				getEditingStructure().addBasicExpression((at.ac.tuwien.big.vfunc.basic.impl.BasicFunction)existingFunction, cvscope, target, type);
			} else {
				System.err.println("Can only add things to basic function, but not "+existingFunction+"!");
			}
		});
		parseState.executeNow(statements);
	}

	private void parseStatement(DeleteAssignment statement) {
		FunctionDef function = statement.getFunction();
		FunctionScope scope = statement.getScope();
		Scope cvscope = convertScope(scope);
		List<BasicStatement> statements = new ArrayList<>();
		
		statements.add((state)-> { 
			Editor editor = getEditingStructure().getEditor();
			AssignmentType type = convertType(function.getType());
			VFunction existingFunction = parseState.getContent(function.getName(), VFunction.class);
			//BasicAssignment bas  = new BasicAssignment(existingFunction, cvscope, target, editor, type);
			if (existingFunction instanceof at.ac.tuwien.big.vfunc.basic.impl.BasicFunction) {
				getEditingStructure().removeDefinition((at.ac.tuwien.big.vfunc.basic.impl.BasicFunction)existingFunction, cvscope);
			} else {
				System.err.println("Can only remove things from function, but not "+existingFunction+"!");
			}
		});
	}
	

	private void parseStatement(BasicAction statement) {
		SetOrFunctionDef thing = statement.getThing();
		String calledFunc = statement.getCalledFunc();
		EList<FunctionPar> params = statement.getParams();
		String variable = thing.getName();
		Object content = parseState.getContent(variable);
		Object[] paramsAr = new Object[params.size()];
		for (int i = 0; i < params.size(); ++i) {
			paramsAr[i] = evaluateNow(params.get(i));
		}
		parseState.getLoader().executeOperation(content, calledFunc, paramsAr);
	}
}

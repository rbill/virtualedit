package at.ac.tuwien.big.vfunc.basic.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.impl.GeneralParseContainer;
import at.ac.tuwien.big.vfunc.basic.impl.ParseState;
import at.ac.tuwien.big.vfunc.basic.impl.SetScope;
import at.ac.tuwien.big.vfunc.basic.impl.VariableRecManager;
import at.ac.tuwien.big.vfunc.basic.io.BasicStatement.JmpStatement;
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
import at.ac.tuwien.big.virtmodel.vLang.SetOrFunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.SingleScope;
import at.ac.tuwien.big.virtmodel.vLang.SingleStatement;
import at.ac.tuwien.big.virtmodel.vLang.SingleValue;
import at.ac.tuwien.big.virtmodel.vLang.RuleAssignment;
import at.ac.tuwien.big.virtmodel.vLang.SetDef;
import at.ac.tuwien.big.virtmodel.vLang.SetLiteral;
import at.ac.tuwien.big.virtmodel.vLang.VLang;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;

public class FileReader {

	InterpretationState parseState;
	
	public InterpretationState clonedState() {
		return parseState.cloneNew();
	}
	
	public FileReader() {
		parseState = new InterpretationState(new GeneralParseContainer(new BasicOperationManager()));
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

	private void compileFunctionCall(String retVariable, FullFunctionAssignment fa, List<BasicStatement> statements) {
		if (true) throw new UnsupportedOperationException("Custom function calls are not yet supported!");
		List<BasicStatement> subStatements = new ArrayList<BasicStatement>();
		//Hier definiere ich eine Funktion
		ParDef parameters = fa.getParameters();
		for (FunctionParDef fpd: parameters.getParams()) {
			String name = fpd.getName();
			String type = fpd.getType();
		}
		Expression expr = fa.getExpr();
		compileFunctionCall("asdf", expr, subStatements);
		BasicStatement.insertSub(statements, subStatements);
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
	

	private void compileStatement(FunctionDef statement, List<BasicStatement> statements) {
		String name = statement.getName();
		FunctionDef fd = (FunctionDef)statement;
		at.ac.tuwien.big.virtmodel.vLang.FunctionType ft = fd.getType();
		JavaFunctionCall call = fd.getInit();
		compileFunctionCall(name, call);
		Object initZeugs = evaluateConstructor(jfc);
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
			
		}
	}
	
	public Scope<?> convertScope(FunctionScope oriScope) {
		Filter filter = oriScope.getFilter();
		java.util.function.Function<Object,Boolean> filterFunc = (x)->true;
		if (filter != null) {
			filterFunc = convertFilter(filter);
		}
		
		if (oriScope instanceof FunctionDomainScope) {
			FunctionDomainScope fds = (FunctionDomainScope)oriScope;
			
		} else if (oriScope instanceof InfiniteScope) {
			InfiniteScope is = (InfiniteScope)oriScope;
			
		} else if (oriScope instanceof SetScope) {
			SetScope ss = (SetScope)oriScope;
			
		} else if (oriScope instanceof SingleScope) {
			SingleScope ss = (SingleScope)oriScope;
			
		} else {
			System.err.println("Unknown scope "+oriScope);
			return null;
		}		
	}
	
	private void parseStatement(SetOrFunctionDef statement) {
		List<BasicStatement> statements = new ArrayList<>();
		compileStatement(statement, statements);
		parseState.executeNow(statements);
	}

	private void parseStatement(RuleAssignment statement) {
		FunctionScope scope = statement.getScope();
		FunctionDef function = statement.getFunction();
		FunctionAssignment assignment = statement.getAssignment();
		asdf;
	}

	private void parseStatement(DeleteAssignment statement) {
		FunctionDef function = statement.getFunction();
		FunctionScope scope = statement.getScope();
		asdf;
	}

	private void parseStatement(BasicAction statement) {
		SetOrFunctionDef thing = statement.getThing();
		String calledFunc = statement.getCalledFunc();
		EList<FunctionPar> params = statement.getParams();
		asdf;
	}
}

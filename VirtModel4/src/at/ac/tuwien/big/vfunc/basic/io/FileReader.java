package at.ac.tuwien.big.vfunc.basic.io;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.FunctionType;
import at.ac.tuwien.big.vfunc.basic.impl.GeneralParseContainer;
import at.ac.tuwien.big.vfunc.basic.impl.ParseState;
import at.ac.tuwien.big.vfunc.basic.impl.VariableRecManager;
import at.ac.tuwien.big.vfunc.op.BasicOperationManager;
import at.ac.tuwien.big.virtmodel.vLang.AssignStatement;
import at.ac.tuwien.big.virtmodel.vLang.BasicAction;
import at.ac.tuwien.big.virtmodel.vLang.Block;
import at.ac.tuwien.big.virtmodel.vLang.CalculatedValue;
import at.ac.tuwien.big.virtmodel.vLang.DeleteAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FixedValue;
import at.ac.tuwien.big.virtmodel.vLang.FullFunction;
import at.ac.tuwien.big.virtmodel.vLang.FullFunctionAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FunctionAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FunctionCall;
import at.ac.tuwien.big.virtmodel.vLang.FunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.FunctionPar;
import at.ac.tuwien.big.virtmodel.vLang.IfThenElse;
import at.ac.tuwien.big.virtmodel.vLang.Import;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionCall;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.ObjId;
import at.ac.tuwien.big.virtmodel.vLang.ObjParam;
import at.ac.tuwien.big.virtmodel.vLang.OclFunction;
import at.ac.tuwien.big.virtmodel.vLang.SetOrFunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.SingleValue;
import at.ac.tuwien.big.virtmodel.vLang.RuleAssignment;
import at.ac.tuwien.big.virtmodel.vLang.SetDef;
import at.ac.tuwien.big.virtmodel.vLang.SetLiteral;
import at.ac.tuwien.big.virtmodel.vLang.VLang;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;

public class FileReader {

	ParseState<?, ?> parseState;
	
	public FileReader() {
		parseState = new ParseState<>(new GeneralParseContainer(new BasicOperationManager()),
				new VariableRecManager(null));
	}
	
	public void parseFile(VLang file) {
		for (Import imp: file.getImports()) {
			System.err.println("Imports not yet supported!");
		}
		for (AssignStatement statement: file.getStatement()) {
			parseGStatement(statement);
		}
	}
	
	private void parseGStatement(AssignStatement statement) {
		if (statement instanceof BasicAction) {
			parseStatement((BasicAction)statement);
		} else if (statement instanceof DeleteAssignment) {
			parseStatement((DeleteAssignment)statement);
		} else if (statement instanceof JavaFunctionDef) {
			parseStatement((JavaFunctionDef)statement);
		} else if (statement instanceof RuleAssignment) {
			parseStatement((RuleAssignment)statement);
		} else if (statement instanceof SetOrFunctionDef) {
			parseStatement((SetOrFunctionDef)statement);
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
	
	private void createSet(String name) {
		parseState.addSet(name);
	}
	
	private void createFunction(String name) {
		
	}
	
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
		asdf; 
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
	}
	
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
	}

	private void parseStatement(SetOrFunctionDef statement) {
		String name = statement.getName();
		if (statement instanceof SetDef) {
			SetDef sd = (SetDef)statement;
			SetLiteral literal = sd.getLiteral();
			createSet(name);
			assignSetLiteral(name, literal);
		} else if (statement instanceof FunctionDef) {
			FunctionDef fd = (FunctionDef)statement;
			at.ac.tuwien.big.virtmodel.vLang.FunctionType ft = fd.getType();
			JavaFunctionCall call = fd.getInit();
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
		// TODO Auto-generated method stub
		
	}

	private void parseStatement(RuleAssignment statement) {
		// TODO Auto-generated method stub
		
	}

	private void parseStatement(DeleteAssignment statement) {
		// TODO Auto-generated method stub
		
	}

	private void parseStatement(BasicAction statement) {
		// TODO Auto-generated method stub
		
	}
}

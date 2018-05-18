package at.ac.tuwien.big.vfunc.basic.io;

import java.util.List;

import at.ac.tuwien.big.vfunc.basic.impl.VariableType;
import at.ac.tuwien.big.vfunc.basic.impl.VariableTypeContent;

public interface BasicStatement {
	
	public void execute(InterpretationState state);
	
	public static class MovStatement implements BasicStatement {
		private String trg;
		private String src;
		
		public MovStatement(String trg, String src) {
			this.src = src;
			this.trg = trg;
		}
		
		@Override
		public void execute(InterpretationState state) {
			state.set(trg, state.getContent(src));
			state.adv();
		}
	}
	
	public static class SuperMovStatement implements BasicStatement {
		private String supertrg;
		private String src;
		
		public SuperMovStatement(String supertrg, String src) {
			this.src = src;
			this.supertrg = supertrg;
		}
		
		@Override
		public void execute(InterpretationState state) {
			Object value = state.getContent(src);
			VariableType variableType = state.curPosition.variables.getParent().get(supertrg);
			if (variableType != null) {
				VariableTypeContent vtc = variableType.getContent();
				if (vtc == null) {
					variableType.setContent(vtc = new VariableTypeContent());
				}
				vtc.setValue(value);
			} else {
				System.err.println("Wanting to write into nonexistant variable!");
			}
			state.adv();
		}
	}
	
	public static class SetStatement implements BasicStatement {
		private String trg;
		private Object obj;
		

		public SetStatement(String trg, Object obj) {
			this.trg = trg;
			this.obj = obj;
		}
		
		@Override
		public void execute(InterpretationState state) {
			state.set(trg, obj);
		}
	}
	
	public static class JmpStatement implements BasicStatement {
		private int relativePosition;
		
		public JmpStatement(InterpretationState.Position current, BasicStatement reach) {
			int trgIndex = current.subThings.indexOf(reach);
			int diff = trgIndex-current.position;
			this.relativePosition = diff;
		}
		
		public JmpStatement(int relativePosition) {
			this.relativePosition = relativePosition;
		}
		
		
		@Override
		public void execute(InterpretationState state) {
			state.jmp(relativePosition);
		}
	}
	
	public static class CJmpStatement implements BasicStatement {
		private int relativePosition;
		private String variable;
		
		public CJmpStatement(String variable, InterpretationState.Position current, BasicStatement reach) {
			this.variable = variable;
			int trgIndex = current.subThings.indexOf(reach);
			int diff = trgIndex-current.position;
			this.relativePosition = diff;
		}
		
		public CJmpStatement(String variable, int relativePosition) {
			this.variable = variable;
			this.relativePosition = relativePosition;
		}
		
		
		@Override
		public void execute(InterpretationState state) {
			Object content = state.getContent(variable);
			if (content instanceof Boolean) {
				Boolean b = (Boolean)content;
				if (b) {
					state.jmp(relativePosition);
				} else {
					state.adv();
				}
			}
			System.err.println("Could not find correct value of "+variable+": should be boolean, was "+content);
			state.adv();
		}
	}

	public static class JavaFunctionCallStatement implements BasicStatement {
		String functionName;
		String[] inputVariables;
		String outputVariableOrNull;
		
		public JavaFunctionCallStatement(String functionName, String[] inputVariables, String outputVariableOrNull) {
			this.functionName = functionName;
			this.inputVariables = inputVariables;
			this.outputVariableOrNull = outputVariableOrNull;
		}

		@Override
		public void execute(InterpretationState state) {
			Object result;
			try {
				result = state.execute(functionName, inputVariables);
				if (outputVariableOrNull != null) {
					state.set(outputVariableOrNull, result);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			state.adv();
		}
	}
	
	public static class JavaOperationCallStatement implements BasicStatement {
		String operationName;
		String functionVariableName;
		String[] inputVariables;
		
		public JavaOperationCallStatement(String functionVariableName, String operationName, String[] inputVariables) {
			this.functionVariableName = functionVariableName;
			this.inputVariables = inputVariables;
			this.operationName= operationName;
		}

		@Override
		public void execute(InterpretationState state) {
			state.executeOperation(functionVariableName, operationName, inputVariables);
			state.adv();
		}
	}
	

	public static class JavaConstructorStatement implements BasicStatement {
		String constructorName;
		String[] inputVariables;
		String outputVariableOrNull;
		

		public JavaConstructorStatement(String constructorName, String[] inputVariables, String outputVariableOrNull) {
			this.constructorName = constructorName;
			this.inputVariables = inputVariables;
			this.outputVariableOrNull = outputVariableOrNull;
		}

		@Override
		public void execute(InterpretationState state) {
			Object result;
			try {
				result = state.executeConstructor(constructorName, inputVariables);
				if (outputVariableOrNull != null) {
					state.set(outputVariableOrNull, result);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			state.adv();
		}
	}
	
	public static class SubFuncStatement implements BasicStatement {
		private List<? extends BasicStatement> subFunc;
		
		public SubFuncStatement(List<? extends BasicStatement> subFunc) {
			this.subFunc = subFunc;
		}

		@Override
		public void execute(InterpretationState state) {
			state.callFunction(subFunc);			
		}
	}

	public static void createDirectVar(List<BasicStatement> subStatements, String parName) {
		subStatements.add((state)->state.createDirectVar(parName));
	}

	public static void construct(List<BasicStatement> subStatements, String name, String[] parameters,
			String retVariable) {
		subStatements.add(new JavaConstructorStatement(name, parameters, retVariable));
	}

	public static void callFunction(List<BasicStatement> subStatements, String name, String[] parameters,
			String retVariable) {
		subStatements.add(new JavaFunctionCallStatement(name, parameters, retVariable));		
	}

	public static void insertSub(List<BasicStatement> statements, List<BasicStatement> subStatements) {
		statements.add(new SubFuncStatement(subStatements));
	}

	public static void setSuper(String superTarget, String subSource, List<BasicStatement> subStatements) {
		subStatements.add(new SuperMovStatement(superTarget, subSource));
	}

	public static void noOp(List<BasicStatement> statements) {
		statements.add((state)->{});
	}

}

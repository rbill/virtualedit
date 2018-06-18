package at.ac.tuwien.big.vfunc.basic.io;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import at.ac.tuwien.big.vfunc.basic.MyCloneable;
import at.ac.tuwien.big.vfunc.basic.impl.GeneralParseContainer;
import at.ac.tuwien.big.vfunc.basic.impl.VariableRecManager;
import at.ac.tuwien.big.vfunc.basic.impl.VariableTypeContent;
import at.ac.tuwien.big.vfunc.op.BasicOperationManager;
import at.ac.tuwien.big.vfunc.op.SimpleBasicFunction;

public class InterpretationState implements MyCloneable<InterpretationState>{
	
	private GeneralParseContainer manager;
	
	public InterpretationState(GeneralParseContainer manager) {
		this.manager = manager;
	}
	
	public Object[] executeNow(List<? extends BasicStatement> statements, String... returnParam) {
		Position oldPos = curPosition;
		Stack<Position> oldStack = positionStack;
		curPosition = null;
		positionStack = new Stack<Position>();
		positionStack.addAll(oldStack);
		if (oldPos != null) {
			positionStack.add(oldPos);
		}
		Object[] ret = new Object[returnParam.length];
		try {
			curPosition = new Position(null, statements);
			executionLoop();
			for (int i = 0; i < returnParam.length; ++i) {
				ret[i] = getContent(returnParam[i]);
			}
			return ret;
		} finally {
			curPosition = oldPos;
			positionStack = oldStack;
		}
	}
	
	static class Position implements MyCloneable<Position> {
		int position;
		List<? extends BasicStatement> subThings;
		private boolean isReturnStack;
		VariableRecManager variables;
		Position parent;
		
		private Map<String, Label> labels = new HashMap<>();
		
		private Position() {
			
		}
		
		public Position(Position parent) {
			this.parent = parent;
			if (parent != null) {
				variables = new VariableRecManager(parent.variables);
			} else {
				variables = new VariableRecManager(null);
			}
			/*if (parent instanceof Block) {
				subThings = ((Block)parent).getStatements();
			} else if (parent instanceof ForLoopStatement) {
				List<SingleStatement> nsubThings = new ArrayList<>();
				subThings = nsubThings;
				ForLoopStatement fls = (ForLoopStatement)parent;
				nsubThings.add(fls.getValue());
				nsubThings.add(fls.getLoopExpr());
			} else if (parent instanceof ForStatement) {
				ForStatement fs = (ForStatement)parent;
				nsubThings.add(fs.getInitVar());
			} else if (parent instanceof IfStatement) {
				
			} else if (parent instanceof LetStatement) {
				
			} else if (parent instanceof ReturnStatement) {
				
			}*/
		}
		
		public Position(Position parent, List<? extends BasicStatement> statements) {
			this(parent);
			this.subThings = statements;
		}
		
		public void setIsReturn(boolean isReturn) {
			this.isReturnStack = isReturn;
		}
		
		public boolean isReturn() {
			return isReturnStack;
		}
		
		public boolean mayAdvance() {
			return position<subThings.size()-1;
		}
		
		public void setPos(int newPos) {
			this.position = newPos;
			isReturnStack = false;
		}
		
		public void advance() {
			++position;
			isReturnStack = false;
		}

		public BasicStatement getCurrentStatement() {
			return subThings.get(position);
		}
		
		@Override
		public Position initClone() {
			Position ret = new Position();
			ret.isReturnStack = isReturnStack;
			ret.subThings = subThings; //This is assumed to be static, so I don't need to clone it!
			return ret;
		}
		
		@Override		
		public void finishClone(Position previous, Map<Object,Object> map) {
			variables = cloneSub(previous.variables, map);
			labels = cloneSub(previous.labels, map);
		}
	}
	
	@Override
	public InterpretationState initClone() {
		InterpretationState ret = new InterpretationState(manager);
		return ret;
	}
	
	@Override
	public void finishClone(InterpretationState previous, Map<Object,Object> map) {
		positionStack = cloneSub(previous.positionStack, map);
		curPosition = cloneSub(curPosition,map);
	}
	
	private class Label implements MyCloneable<Label> {
		private String name;
		private Position pos;
		private int index;
		
		public Label(String name, Position pos, int index) {
			this.name = name;
			this.pos = pos;
			this.index = index;
		}
		
		public boolean jumpTo() {
			if (curPosition == pos) {
				curPosition.setPos(index);
				return true;
			} else {
				if (!positionStack.isEmpty()) {
					curPosition = positionStack.pop();
					return jumpTo();
				}
				return false;
			}
		}

		@Override
		public Label initClone() {
			return new Label(name, null, index);
		}
		
		@Override
		public void finishClone(Label previous, Map<Object,Object> map) {
			this.pos = cloneSub(previous.pos, map);
		}
	}
	
	private Stack<Position> positionStack = new Stack<>();
	Position curPosition;
	


	public GeneralParseContainer getManager() {
		return manager;
	}
	
	public BasicOperationManager getLoader() {
		return manager.loader();
	}
	
	
	/**Basic actions*/
	
	/**Return when you want to continue execution*/
	public boolean adv() {
		if (curPosition == null) {
			return false;
		}
		if (!curPosition.mayAdvance()) {
			curPosition = positionStack.isEmpty()?null:positionStack.pop();
			return adv();
		} else {
			curPosition.advance();
			return true;
		}
	}
	
	public boolean ret() {
		while (!positionStack.isEmpty() && !positionStack.peek().isReturn()) {
			positionStack.pop();
		}
		if (positionStack.isEmpty()) {
			return false;
		}
		curPosition = positionStack.pop();
		return adv();
	}
	
	public void callFunction(List<? extends BasicStatement> func) {
		if (curPosition != null) {
			curPosition.setIsReturn(true);
			positionStack.push(curPosition);
		}
		curPosition = new Position(curPosition,func);
	}
	
	public void setVar(String varName, Object content) {
		if (curPosition != null) {
			curPosition.variables.set(varName, content);
		}
	}
	
	public boolean jmp(int relativeIndex) {
		if (curPosition != null) {
			int newPos = curPosition.position+relativeIndex;
			if (newPos < 0 || newPos >= curPosition.subThings.size()) {
				return false;
			}
			curPosition.setPos(newPos);
			return true;
		}
		return false;
	}
	
	public void makeLabel(String label) {
		if (curPosition != null) {
			curPosition.labels.put(label, new Label(label, curPosition, curPosition.position));
		}
	}
	
	public boolean jmp(String label) {
		if (curPosition != null) {
			Label lab = curPosition.labels.get(label);
			if (lab != null) {
				return lab.jumpTo();
			} else {
				if (!positionStack.isEmpty()) {
					curPosition = positionStack.pop();
					return jmp(label);
				}
				return false;
			}
		}
		return false;
	}

	
	public void executeStatement() {
		if (curPosition != null) {
			BasicStatement currentStatement = curPosition.getCurrentStatement();
			currentStatement.execute(this);
		}
	}
	
	public void executionLoop() {
		while (curPosition != null) {
			executeStatement();
		}
	}
	
	
	
	
	/**Access operations*/

	private VariableRecManager recManager() {
		if (curPosition != null) {
			return curPosition.variables;
		}
		return null;
	}
	
	public void addFunction(String variable, String newFunctionType, Object... newParam) {
		BasicOperationManager loader = getLoader();
		Object content = loader.createNew(newFunctionType, newParam);
		VariableTypeContent vtc = new VariableTypeContent();
		vtc.setValue(content);
		add(variable, vtc);
	}


	public void addSet(String variable) {
		Object content = new HashSet<>();
		VariableTypeContent vtc = new VariableTypeContent();
		vtc.setValue(content);
		add(variable, vtc);
	}
	
	public Object getContent(String variable) {
		VariableTypeContent value = recManager().getValue(variable);
		if (value == null) {
			System.err.println("Variable "+variable+" not declared!");
			return null;
		}
		return value.getAssignExpression();
	}
	
	
	public void add(String variable, VariableTypeContent initValue) {
		recManager().createDirect(variable);
		if (initValue != null) {
			recManager().setValue(variable, initValue);
		}
	}
	
	private Object[] getObjs(String... variableNames) {
		Object[] objs = new Object[variableNames.length];
		for (int i = 0; i < variableNames.length; ++i) {
			objs[i] = getContent(variableNames[i]);
		}
		return objs;
	}
	
	public Object[] executeForeign(SuperBasicFunction sbf, String[] variableNames) {
		Object[] objs = getObjs(variableNames);
		return sbf.execute(objs);
	}
	

	public Object execute(String functionName, String[] variableNames) throws NoSuchMethodException {
		SimpleBasicFunction sbf = getLoader().getFunction(functionName);
		Object[] objs = getObjs(variableNames);
		return sbf.process(objs);
	}
	

	public Object executeConstructor(String constructorName, String[] variableNames) throws NoSuchMethodException {
		Object[] objs = getObjs(variableNames);
		return getLoader().createNew(constructorName, objs);
	}
	


	public void executeOperation(String functionVariableName, String operationName, String[] variableNames) {
		Object[] objs = getObjs(variableNames);
		BasicOperationManager bom = getLoader();
		Object theFunction = getContent(functionVariableName);
		bom.executeOperation(theFunction, operationName, objs);
	}
	
	
	public void set(String functionName, String[] inputVariables, String outputVariable) throws NoSuchMethodException {
		Object returnValue = execute(functionName, inputVariables);
		set(outputVariable, returnValue);
	}
	
	public void setForeign(SuperBasicFunction sbf, String[] inputVariables, String[] outputVariables) {
		Object[] returnValue = executeForeign(sbf, inputVariables);
		if (returnValue == null) {
			if (outputVariables.length>0) {
				System.err.println("Function did not return a value when it was supposed to!");
			}
			return;
		}
		int minLen = Math.min(returnValue.length, outputVariables.length);
		for (int i = 0; i < minLen; ++i) {
			set(outputVariables[i], returnValue[i]);
		}
	}
		
	public void reset(String variable, VariableTypeContent newValue) {
		recManager().setValue(variable, newValue);
	}
	
	public void set(String variable, Object newContent) {
		recManager().set(variable, newContent);
	}

	public void createDirectVar(String parName) {
		recManager().createDirect(parName);
	}

	public void ifThenElse(String condVar, List<BasicStatement> thenStatements, List<BasicStatement> elseStatements) {
		Object var = getContent(condVar);
		if (var instanceof Boolean) {
			if ((Boolean)var) {
				callFunction(thenStatements);
			} else {
				callFunction(elseStatements);
			}
		} else {
			System.err.println("Expected boolean for "+condVar+", got "+var+"!");
		}
		
	}

	public<T> T getContent(String name, Class<T> class1) {
		Object ret = getContent(name);
		if (ret != null && !class1.isInstance(ret)) {
			System.err.println("Expected "+name+" to be of type "+class1+", but was "+ret);
			return null;
		}
		return (T)ret;
	}
}

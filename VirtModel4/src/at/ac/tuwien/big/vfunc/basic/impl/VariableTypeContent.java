package at.ac.tuwien.big.vfunc.basic.impl;

public class VariableTypeContent {
	//Just contain information about both
	
	private boolean isAssigned;
	
	//Function parameter information
	private int parameterIndex;

	public void setFunction(int parameterIndex) {
		this.isAssigned = false;
		this.parameterIndex = parameterIndex;
	}
	
	//Value information
	private Object assignExpression;
	
	public void setValue(Object assignExpression) {
		this.isAssigned = true;
		this.assignExpression = assignExpression;
	}
	
	public boolean isAssigned() {
		return isAssigned;
	}
	
	public Object getAssignExpression() {
		return assignExpression;
	}
	
	public int getParameterIndex() {
		return parameterIndex;
	}
	

}

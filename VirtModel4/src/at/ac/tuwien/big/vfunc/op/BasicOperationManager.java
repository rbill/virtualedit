package at.ac.tuwien.big.vfunc.op;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.big.util.ClassUtil;
import at.ac.tuwien.big.vfunc.basic.AnyParameterModifier;

public class BasicOperationManager {
	
	private BasicObjectLoader<BasicOperation<?>> operationsLoader = new BasicObjectLoader<BasicOperation<?>>();
	private BasicObjectLoader<SimpleBasicFunction> functionLoader = new BasicObjectLoader<>();
	private Map<String, Class<?>> newInstanceClasses = new HashMap<String, Class<?>>();

	public void setOperationClass(String name, String className) {
		operationsLoader.assign(name, className);
	}
	
	public void setFunctionClass(String name, String className) {
		functionLoader.assign(name, className);
	}
	
	public void setNewObjectClass(String name, String className) {
		try {
			newInstanceClasses.put(name, Class.forName(className));
		} catch (ClassNotFoundException e) {
			System.err.println("Could not set "+name+" = "+className+": "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void executeOperation(Object theFunction, String opName, Object... params) {
		BasicOperation<?> operation = operationsLoader.getObject(opName);
		if (operation == null) {
			System.err.println("Operation "+opName+" not found!");
		} else {
			Class<?> reqCl = operation.getRequiredClass();
			if (reqCl.isInstance(theFunction)) {
				((BasicOperation)operation).process(theFunction, params);
			}
		}
	}

	/*public void executeFunction(String opName, AnyParameterModifier modifier) {
		BasicFunction function = functionLoader.getObject(opName);
		if (function == null) {
			System.err.println("Function "+opName+" not found!");
		} else {
			function.process(modifier);
		}
	}*/
	
	public SimpleBasicFunction getFunction(String opName) throws NoSuchMethodException {
		SimpleBasicFunction function = functionLoader.getObject(opName);
		if (function == null) {
			System.err.println("Function "+opName+" not found!");
			throw new NoSuchMethodException("Function "+opName+" not found!");
		} else {
			return function;
		} 
	}

	public Object executeFunction(String opName, Object... params) {
		try {
			SimpleBasicFunction function = getFunction(opName);
			return function.process(params);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		}

	}

	public Object createNew(String newFunctionType, Object[] newParam) {
		Class<?> cl = newInstanceClasses.get(newFunctionType);
		if (cl == null) {
			System.err.println("Don't know how to create "+newFunctionType+"!");
			return null;
		}
		return ClassUtil.instanciate(cl, newParam);
		
	}
}

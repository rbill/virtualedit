package at.ac.tuwien.big.vfunc.nbasic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ScopeState {
	
	private ScopeState parent;
	private Map<VariableName, BasicValuedChangeNotifyer> storedValues = new HashMap<>();
	private Map<String, Function<List<Object>, ?>> javaFunctions = new HashMap<>();
	
	
	private ScopeState(ScopeState parent) {
		this.parent = parent;
	}
	
	public ScopeState() {
		
	}
	
	public ScopeState push() {
		return new ScopeState(this);
	}
	
	public void putVar(VariableName<?> varName, BasicValuedChangeNotifyer<?> cn) {
		storedValues.put(varName, cn);
	}
	
	public BasicValuedChangeNotifyer<?> getVar(VariableName<?> varName) {
		BasicValuedChangeNotifyer<?> ret = storedValues.get(varName);
		if (ret == null) {
			if (parent != null) {
				ret = parent.getVar(varName);
			} else {
				throw new RuntimeException("Variable "+varName+" not defined!");
			}
		}
		return ret;
	}
	
	public void putJFunc(String varName,  Function<List<Object>, ?> cn) {
		javaFunctions.put(varName, cn);
	}
	
	public  Function<List<Object>, ?> getJFunc(String varName) {
		 Function<List<Object>, ?> ret = javaFunctions.get(varName);
		if (ret == null) {
			if (parent != null) {
				ret = parent.getJFunc(varName);
			} else {
				throw new RuntimeException("Java Function "+varName+" not defined!");
			}
		}
		return ret;
	}
	
	

}

package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Map;

public class VariableName<Target> extends NoChangeNotifyer<Target>{
	
	private static Map<String, VariableName<?>> map;
	
	private VariableName(String name) {
		this.name = name;
	}
	
	public static VariableName get(String name) {
		return map.computeIfAbsent(name, x->new VariableName<>(x));
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

}

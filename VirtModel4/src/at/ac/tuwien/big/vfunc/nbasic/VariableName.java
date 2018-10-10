package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Map;

public class VariableName<Target> extends NoChangeNotifyer<Target>{
	
	private static Map<String, VariableName<?>> map;
	
	public static VariableName get(String name) {
		return map.computeIfAbsent(name, x->new VariableName<>(x));
	}
	
	private BasicMetaInfo bmi = new BasicMetaInfo();
	
	private String name;
	
	private VariableName(String name) {
		this.name = name;
	}
	
	@Override
	public MetaInfo getMetaInfo() {
		return this.bmi;
	}

	public String getName() {
		return this.name;
	}

}

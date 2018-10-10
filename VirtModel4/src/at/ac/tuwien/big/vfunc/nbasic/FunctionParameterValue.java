package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class FunctionParameterValue<Target> extends NoChangeNotifyer<Target> {
	
	
	public String name;
	private BasicMetaInfo bmi = new BasicMetaInfo();
	
	
	public FunctionParameterValue(String name) {
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

package at.ac.tuwien.big.vfunc.nbasic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class FunctionParameterValue<Target> extends NoChangeNotifyer<Target> {
	
	
	public FunctionParameterValue(String name) {
		this.name = name;
	}
	
	
	public String name; 
	
	public String getName() {
		return name;
	}

}

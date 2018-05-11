package at.ac.tuwien.big.verocl.parameterdesc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

public class PointDesc {
	
	public static final PointDesc EMPTY = new PointDesc();


	public static final PointDesc SINGLESTRING = new PointDesc();

	public static final PointDesc SINGLEINT = new PointDesc();
	
	public static final PointDesc SINGLELONG = new PointDesc();
	
	public static final PointDesc FULLBASIC = new PointDesc();
	
	static {
		SINGLESTRING.addParameterDesc(new SingleParameterDesc("uri", String.class));
		FULLBASIC.addParameterDesc(new SingleParameterDesc("uri", String.class));
		SINGLEINT.addParameterDesc(new SingleParameterDesc("index", Integer.class));
		FULLBASIC.addParameterDesc(new SingleParameterDesc("index", Integer.class));
		SINGLELONG.addParameterDesc(new SingleParameterDesc("time", Long.class));
		FULLBASIC.addParameterDesc(new SingleParameterDesc("time", Long.class));
	}
	
	
	private List<SingleParameterDesc> parameterDescs = new ArrayList<SingleParameterDesc>();
	private List<EAttribute> attrList = null;
	
	public void addParameterDesc(SingleParameterDesc desc) {
		parameterDescs.add(desc);
	}
	
	public List<SingleParameterDesc> getParameterDescs() {
		return parameterDescs;
	}

	public int getIndex(String name) {
		int ret = 0;
		for (SingleParameterDesc desc: parameterDescs) {
			if (desc.getName().equals(name)) {
				return ret;
			}
			++ret;
		}
		return -1;
	}

	public List<? extends EStructuralFeature> getESFList() {
		if (attrList == null) {
			attrList = new ArrayList<EAttribute>();
			for (SingleParameterDesc spd: parameterDescs) {
				EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
				attr.setName(spd.getName());
				attr.setEType(EcorePackage.eINSTANCE.getEInt());
				attr.setLowerBound(0);
				attr.setUpperBound(1);
				attrList.add(attr);
			}
		}
		return attrList;
	}
	
	

}

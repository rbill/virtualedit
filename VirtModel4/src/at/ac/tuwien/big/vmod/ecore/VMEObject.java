package at.ac.tuwien.big.vmod.ecore;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
//import org.eclipse.ocl.copied.BasicTuple;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.PivotFactoryImpl;
import org.eclipse.ocl.pivot.internal.SequenceTypeImpl;
import org.eclipse.ocl.pivot.internal.values.SequenceValueImpl;
import org.eclipse.ocl.pivot.values.OrderedSet;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.util.Tuple;

import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.Points;
import at.ac.tuwien.big.verocl.parameterdesc.SingleParameterDesc;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiPointImpl;
import at.ac.tuwien.big.verocl.parameterdesc.impl.SinglePointImpl;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public interface VMEObject extends EObject {
	
	public void setEClass(EClass newClass);
	
	public Symbol getUUID();
	
	public default VMEObject project(Points mp) {
		MultiPoint curProj = getProjectionOrNull();
		if (curProj == null) {
			return withPoints(mp);
		} else {
			return withPoints(curProj.intersectWithOrSame(mp));
		}
	}
	
	public VMEObject withPoints(Points mp);
	
	/*public default VMEObject projectTuple(Iterable<? extends Tuple<?, ? extends EStructuralFeature>> tuples) {
		MultiPoint point = getProjectionOrNull();
		PointDesc desc = point.getDesc();
		MultiPointImpl newProj = new MultiPointImpl(desc);
		for (Tuple<?, ? extends EStructuralFeature> tuple: tuples) {
			//Jedes feature, welches wohl nahezu wirklcih eines ist, enth?lt einen Parameter mit demselben Namen ...
			Object[] obj = new Object[desc.getParameterDescs().size()];
			int i = 0;
			for (SingleParameterDesc spc: desc.getParameterDescs()) {
				String name = spc.getName();
				obj[i] = tuple.getValue(name);
				++i;
			}
			newProj.addValue(obj);
		}
		return project(newProj);
	}
	
	public default VMEObject projectTuple(Tuple<?, ? extends EStructuralFeature> tuple) {
		return projectTuple(Collections.singleton(tuple));
	}*/
	
	/*public default Tuple<EOperation,EStructuralFeature> getTuple(SinglePoint point, Object value, org.eclipse.ocl.ecore.TupleType tt) {
		PointDesc desc = point.getDesc();
		List<? extends EStructuralFeature> esfList = desc.getESFList();
		Map<EStructuralFeature,Object> objectMap = new HashMap<EStructuralFeature, Object>();
		Object[] objs = point.getValues();
		for (EStructuralFeature prop: tt.getEAllStructuralFeatures()) {
			String name = prop.getName();
			int idx = desc.getIndex(name);
			if (idx != -1) {
				Object obj = objs[idx];
				objectMap.put(prop, obj);
			}
		}
		BasicTuple ret = new BasicTuple(tt,objectMap);
		return ret;
	}*/
	
	public default SequenceValue explodeTuple(EStructuralFeature feat) {
		Map<SinglePoint,Object> map = explode(feat);
		
		
		List<Tuple<EOperation,EStructuralFeature>> retList = new ArrayList<>();
		org.eclipse.ocl.pivot.SequenceType st = PivotFactoryImpl.eINSTANCE.createSequenceType();
		
		org.eclipse.ocl.pivot.TupleType tt = PivotFactoryImpl.eINSTANCE.createTupleType();
		PointDesc desc = getProjectionOrNull().getDesc();
		for (SingleParameterDesc spd: desc.getParameterDescs()) {
			Property prop = PivotFactoryImpl.eINSTANCE.createProperty();
			prop.setName(spd.getName());
			//prop.setType(PivotPackage.Literals.);
			prop.setType(PivotFactory.eINSTANCE.createIntegerLiteralExp().getType());
			tt.getOwnedProperties().add(prop);
		}
		st.setElementType(tt);
		SequenceValue sv = (SequenceValue) st.createInstance();
		for (Tuple<EOperation,EStructuralFeature> retElement: retList) {
			sv.append(retElement);
		}
		return sv;
	}
	
	
	/**Explode where you unify over the same values*/
	public default Map<MultiPoint,Object> restrictedExplode(EStructuralFeature feat, MultiPoint curMp) {
		Map<Object,MultiPointImpl> retRev = new HashMap<>();
		Map<SinglePoint,Object> exploded = explode(feat);
		for (Entry<SinglePoint,Object> entry: exploded.entrySet()) {
			if (curMp != null && !curMp.contains(entry.getKey())) {
				continue;
			}
			MultiPointImpl cur = retRev.get(entry.getValue());
			if (cur == null) {
				retRev.put(entry.getValue(), new MultiPointImpl(entry.getKey().getDesc(),entry.getKey()));
			} else {
				cur.addValue(entry.getKey());
			}
		}
		Map<MultiPoint,Object> ret = IteratorUtils.reverseHashMap(retRev);
		return ret;
	}
	
	public default Map<SinglePoint,Object> explode(EStructuralFeature feat) {
		MultiPoint allVals = getProjectionOrNull();
		Map<SinglePoint,Object> ret = new HashMap<SinglePoint, Object>();
		if (allVals == null) {
			ret.put(new SinglePointImpl(PointDesc.EMPTY), eGet(feat));
		} else {
			for (SinglePoint spi: allVals) {
				ret.put(spi, project(spi).eGet(feat));
			}
		}
		return ret;
	}
	
	public default Map<SinglePoint,VMEObject> explode() {
		MultiPoint allVals = getProjectionOrNull();
		Map<SinglePoint,VMEObject> ret = new HashMap<SinglePoint, VMEObject>();
		if (allVals == null) {
			ret.put(new SinglePointImpl(PointDesc.EMPTY), this);
		} else {
			for (SinglePoint spi: allVals.getPoints()) {
				//SinglePoint spi = new SinglePointImpl(allVals.getDesc(),o);
				ret.put(spi, project(spi));
			}
		}
		return ret;
	}
	
	

	public void initProjection(MultiPoint projection);
	
	public MultiPoint getProjectionOrNull();
	
	public default String stringValueObj(Object obj) {
		if (obj == null) {
			return "null";
		}
		if (obj instanceof VMEObject) {
			return ((VMEObject) obj).getUUID().toString();
		} else {
			return String.valueOf(obj);
		}
	}
	

	public default String fullStringValueObj(int curTabs, Object obj, MultiPoint mp) {
		if (obj == null) {
			return "null";
		}
		if (obj instanceof VMEObject) {
			return ((VMEObject) obj).fullString(curTabs, true, mp);
		} else {
			return String.valueOf(obj);
		}
	}

	

	public default String unionStringValueObj(int curTabs, Object obj) {
		if (obj == null) {
			return "null";
		}
		if (obj instanceof VMEObject) {
			return ((VMEObject) obj).unionString(curTabs, true);
		} else {
			return String.valueOf(obj);
		}
	}
	
	
	
	public default String objStringValue(Object obj) {
		if (obj instanceof Collection) {
			return IteratorUtils.<Object>buildString((Collection)obj, (x)->stringValueObj(x), "[", "]", ", ");
		} else {
			return stringValueObj(obj);
		}
	}
	
	public default String fullObjStringValue(int curTabs, Object obj, MultiPoint curMp) {
		if (obj instanceof Collection) {
			return IteratorUtils.<Object>buildString((Collection)obj, (x)->fullStringValueObj(curTabs,x,curMp), "[", "]", ", ");
		} else {
			return fullStringValueObj(curTabs,obj, curMp);
		}
	}

	public default String unionObjStringValue(int curTabs, Object obj) {
		if (obj instanceof Collection) {
			return IteratorUtils.<Object>buildString((Collection)obj, (x)->unionStringValueObj(curTabs,x), "[", "]", ", ");
		} else {
			return unionStringValueObj(curTabs,obj);
		}
	}
	
	public default String stringValue(EStructuralFeature feat) {
		Object obj = eGet(feat);
		return objStringValue(obj);
	}
	
	public default String fullStringValue(int curTabs, EStructuralFeature feat, MultiPoint curMp) {
		Object obj = eGet(feat);
		return fullObjStringValue(curTabs, obj, curMp);
	}

	public default String unionStringValue(int curTabs, EStructuralFeature feat) {
		Object obj = eGet(feat);
		return unionObjStringValue(curTabs, obj);
	}
	

	public default String explodedStringValue(EStructuralFeature feat, MultiPoint curMp) {
		Map<MultiPoint, Object> mp = restrictedExplode(feat,curMp);
		StringBuilder ret = new StringBuilder();
		ret.append("<<");
		boolean first = true;
		for (Entry<MultiPoint,Object> entr: mp.entrySet()) {
			if (first) {first = false;} else {ret.append("; ");}
			ret.append(IteratorUtils.buildString(entr.getKey().getValues(),(x)->java.util.Arrays.toString(x),"{","}",", "));
			ret.append(" = ");
			ret.append(objStringValue(entr.getValue()));
		}
		ret.append(">>");
		return ret.toString();
	}
	
	public default String semiExplodedStringValue(EStructuralFeature feat, MultiPoint curMp) {
		if (feat.isMany()) {
			Object obj = eGet(feat);
			return objStringValue(obj);
		} 
		Map<MultiPoint, Object> mp = restrictedExplode(feat, curMp);
		if (mp.isEmpty()) {
			return "null";
		} else if (mp.size() == 1) {
			return stringValue(feat);
		}
		StringBuilder ret = new StringBuilder();
		ret.append("<<");
		boolean first = true;
		for (Entry<MultiPoint,Object> entr: mp.entrySet()) {
			if (first) {first = false;} else {ret.append("; ");}
			ret.append(IteratorUtils.buildString(entr.getKey().getValues(),(x)->java.util.Arrays.toString(x),"{","}",", "));
			ret.append(" = ");
			ret.append(objStringValue(entr.getValue()));
		}
		ret.append(">>");
		return ret.toString();
	}
	

	public default String unionStringValue(EStructuralFeature feat) {
		if (feat.isMany()) {
			Object obj = eGet(feat);
			return objStringValue(obj);
		} 
		return stringValue(feat);
	}
	

	public default String unionFullStringValue(int curTabs, EStructuralFeature feat) {
		if (feat.isMany()) {
			Object obj = eGet(feat);
			return unionObjStringValue(curTabs, obj);
		} 
		return unionStringValue(curTabs,feat);
	}
	
	public default String semiExplodedFullStringValue(int curTabs, EStructuralFeature feat, MultiPoint curMp) {
		if (feat.isMany()) {
			Object obj = eGet(feat);
			return fullObjStringValue(curTabs, obj, curMp);
		} 
		Map<MultiPoint, Object> mp = restrictedExplode(feat, curMp);
		if (mp.isEmpty()) {
			return "null";
		} else if (mp.size() == 1) {
			return fullStringValue(curTabs,feat, curMp);
		}
		StringBuilder ret = new StringBuilder();
		ret.append("<<");
		boolean first = true;
		for (Entry<MultiPoint,Object> entr: mp.entrySet()) {
			if (first) {first = false;} else {ret.append("; ");}
			ret.append(IteratorUtils.buildString(entr.getKey().getValues(),(x)->java.util.Arrays.toString(x),"{","}",", "));
			ret.append(" = ");
			ret.append(fullObjStringValue(curTabs,entr.getValue(), curMp));
		}
		ret.append(">>");
		return ret.toString();
		
	}
	
	
	public default String explodedString() {
		StringBuilder ret = new StringBuilder();
		EClass cl =  eClass();
		if (cl == null) {
			return "?NoClass?";
		}
		ret.append(cl.getName());
		StringBuilder middle = new StringBuilder();
		
		middle.append(" {\n");
		boolean hadId = false;
		for (EAttribute attr: cl.getEAllAttributes()) {
			if (!hadId && ("name".contentEquals(attr.getName()) || attr.isID())) {
				hadId = true;
				ret.append(" "+explodedStringValue(attr, null));
				continue;
			}
			middle.append("\t"+attr.getName()+" = "+explodedStringValue(attr, null)+"\n");
		}
		for (EReference attr: cl.getEAllReferences()) {
			middle.append("\t"+attr.getName()+" = "+explodedStringValue(attr, null)+"\n");
		}
		middle.append("\n}");
		ret.append(middle);
		return ret.toString();
	}
	
	public static void tabnl(StringBuilder builder, int num) {
		builder.append("\n");
		for (int i = 0; i < num; ++i) {
			builder.append('\t');
		}
	}

	public default String fullString() {
		return fullString(0, true, null);
	}
	
	public default String unionString() {
		return unionString(0, true);
	}
	
	public default String unionString(int curTabs, boolean expandContainments) {
		++curTabs;
		StringBuilder ret = new StringBuilder();
		EClass cl =  eClass();
		if (cl == null) {
			return "?NoClass?";
		}
		ret.append(cl.getName());
		StringBuilder middle = new StringBuilder();
		
		middle.append(" {");
		tabnl(middle,curTabs);
		boolean hadId = false;
		for (EAttribute attr: cl.getEAllAttributes()) {
			if (!this.eIsSet(attr)) {
				continue;
			}
			if (!hadId && ("name".contentEquals(attr.getName()) || attr.isID())) {
				hadId = true;
				ret.append(" "+stringValue(attr));
				continue;
			}
			middle.append(attr.getName()+" = "+unionStringValue(attr));
			tabnl(middle, curTabs);
		}
		for (EReference attr: cl.getEAllReferences()) {
			if (!this.eIsSet(attr)) {
				continue;
			}
			middle.append(attr.getName()+" = ");
			if (expandContainments && attr.isContainment()) {
				middle.append(unionFullStringValue(curTabs,attr));
			} else {
				middle.append(unionStringValue(attr));
				tabnl(middle, curTabs);
			}
		}
		--curTabs;
		tabnl(middle, curTabs);
		middle.append("}");
		tabnl(middle, curTabs);
		ret.append(middle);
		return ret.toString();
	}
	
	public default String fullString(int curTabs, boolean expandContainments, MultiPoint mp) {
		++curTabs;
		StringBuilder ret = new StringBuilder();
		EClass cl =  eClass();
		if (cl == null) {
			return "?NoClass?";
		}
		ret.append(cl.getName());
		StringBuilder middle = new StringBuilder();
		
		middle.append(" {");
		tabnl(middle,curTabs);
		boolean hadId = false;
		for (EAttribute attr: cl.getEAllAttributes()) {
			if (!this.eIsSet(attr)) {
				continue;
			}
			if (!hadId && ("name".contentEquals(attr.getName()) || attr.isID())) {
				hadId = true;
				ret.append(" "+stringValue(attr));
				continue;
			}
			middle.append(attr.getName()+" = "+semiExplodedStringValue(attr, mp));
			tabnl(middle, curTabs);
		}
		for (EReference attr: cl.getEAllReferences()) {
			if (!this.eIsSet(attr)) {
				continue;
			}
			middle.append(attr.getName()+" = ");
			if (expandContainments && attr.isContainment()) {
				middle.append(semiExplodedFullStringValue(curTabs,attr, mp));
			} else {
				middle.append(semiExplodedStringValue(attr, mp));
				tabnl(middle, curTabs);
			}
		}
		--curTabs;
		tabnl(middle, curTabs);
		middle.append("}");
		tabnl(middle, curTabs);
		ret.append(middle);
		return ret.toString();
	}

	

	public default String getString() {
		StringBuilder ret = new StringBuilder();
		EClass cl =  eClass();
		if (cl == null) {
			return "?NoClass?";
		}
		ret.append(cl.getName());
		StringBuilder middle = new StringBuilder();
		
		middle.append(" {\n");
		boolean hadId = false;
		for (EAttribute attr: cl.getEAllAttributes()) {
			if (!hadId && ("name".contentEquals(attr.getName()) || attr.isID())) {
				hadId = true;
				ret.append(" "+stringValue(attr));
				continue;
			}
			middle.append("\t"+attr.getName()+" = "+stringValue(attr)+"\n");
		}
		for (EReference attr: cl.getEAllReferences()) {
			middle.append("\t"+attr.getName()+" = "+stringValue(attr)+"\n");
		}
		middle.append("\n}");
		ret.append(middle);
		return ret.toString();
	}

	public boolean contExists();


}

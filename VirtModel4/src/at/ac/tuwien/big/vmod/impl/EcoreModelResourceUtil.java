package at.ac.tuwien.big.vmod.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.verocl.parameterdesc.MultiModelPoint;
import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.type.CountType;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.ValueType;
import at.ac.tuwien.big.vmod.type.impl.CountTypeImpl;
import at.ac.tuwien.big.vmod.type.impl.FunctionTypeImpl;
import at.ac.tuwien.big.vmod.type.impl.IterableTypeImpl;
import at.ac.tuwien.big.vmod.type.impl.ModelResourceTypeImpl;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;

public class EcoreModelResourceUtil {
	

	
	public static FunctionType getFunctionType(EStructuralFeature feature) {
		FunctionTypeImpl ret = new FunctionTypeImpl();
		ret.setDomain(ValueType.Symbol);
		FunctionTypeImpl vlist = new FunctionTypeImpl();
		vlist.setDomain(ValueType.Treepos);
		FunctionTypeImpl vbag = new FunctionTypeImpl();
		//TODO: Set real domain
		vbag.setDomain(ValueType.Unspecified);
		vbag.makeIterable();
		CountTypeImpl countType = new CountTypeImpl();
		countType.setEditable(true);
		vbag.setRange(countType);
		vlist.setRange(vbag);
		vlist.makeIterable();
		ret.setRange(vlist);
		ret.makeIterable();
		return ret;
	}
	

	public static<T> Function<Symbol, Function<Treepos, Function<T, ? extends Counter>>> getFeatureValueFunc(
			ModelResource resource, String feature) {
		Function cfung = ((Function)resource.getElement("associations"));
		return (Function)cfung.get(feature);
	}
	

	public static<T> ParametizedFunction<Symbol, ParametizedFunction<Treepos, ParametizedFunction<Object, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> getProjectedFeatureValueFunc(
			ParametizedModelResource<? extends MultiPoint,? extends SinglePoint> resource, String feature) {
		ParametizedFunction cfung = ((ParametizedFunction)resource.getElement("associations"));
		return (ParametizedFunction)cfung.get(feature);
	}

	public static Function<Symbol, ? extends Counter> getObjectFunc(ModelResource resource) {
		return (Function)((Function)resource.getElement("instances"));
	}
	


	public static ParametizedFunction<Symbol, ? extends ParametizedCounter<MultiPoint,SinglePoint>,MultiPoint,SinglePoint	> getProjectedObjectFunc(
			ParametizedModelResource<? extends MultiPoint, ? extends  SinglePoint> resource) {
		ParametizedFunction cfung = ((ParametizedFunction)resource.getElement("instances"));
		return cfung;
	}


	public static Function<Symbol, Function<String, ? extends Counter>> getClassFunc(ModelResource resource) {
		return (Function)((Function)resource.getElement("classes"));
	}
	


	public static<T> ParametizedFunction<Symbol, ParametizedFunction<String, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> getProjectedClassFunc(
			ParametizedModelResource<MultiPoint,SinglePoint> resource) {
		ParametizedFunction cfung = ((ParametizedFunction)resource.getElement("classes"));
		return cfung;
	}



	public static Function<Symbol, Function<Symbol, ? extends Counter>> getContainerFunc(ModelResource resource) {
		return (Function)((Function)resource.getElement("containments"));
	}
	


	public static<T> ParametizedFunction<Symbol, ParametizedFunction<Symbol, ? extends ParametizedCounter<MultiPoint,SinglePoint>,MultiPoint,SinglePoint>, MultiPoint,SinglePoint> getProjectedContainerFunc(
			ParametizedModelResource<MultiPoint,SinglePoint> resource) {
		ParametizedFunction cfung = ((ParametizedFunction)resource.getElement("containments"));
		return cfung;
	}

	
	public static ModelResourceType getModelResource(Resource forEcore) {
		ModelResourceTypeImpl type = new ModelResourceTypeImpl();
		
		FunctionTypeImpl instancesType = new FunctionTypeImpl();
		instancesType.setDomain(ValueType.Symbol);
		CountTypeImpl simpleCount = new CountTypeImpl();
		simpleCount.setEditable(true);
		instancesType.setRange(simpleCount);
		instancesType.makeIterable();
		
		type.addType("instances", instancesType);
		
		
		FunctionTypeImpl classesType = new FunctionTypeImpl();
		classesType.setDomain(ValueType.Symbol);
		FunctionTypeImpl typeBag = new FunctionTypeImpl();
		typeBag.setDomain(ValueType.String);
		typeBag.setRange(simpleCount);
		typeBag.makeIterable();
		classesType.setRange(typeBag);
		classesType.makeIterable();
		type.addType("classes", classesType);
				
		
		FunctionTypeImpl associationsType = new FunctionTypeImpl();
		associationsType.setDomain(ValueType.Symbol);
		associationsType.makeIterable();
		//List
		
		
		type.addType("associations", associationsType);
		
		FunctionTypeImpl containmentType = new FunctionTypeImpl();
		containmentType.setDomain(ValueType.Symbol);
		
		FunctionTypeImpl ctypeBag = new FunctionTypeImpl();
		ctypeBag.setDomain(ValueType.Symbol);
		ctypeBag.setRange(simpleCount);
		ctypeBag.makeIterable();
		containmentType.setRange(ctypeBag);
		containmentType.makeIterable();
		type.addType("containments", containmentType);
		
		
		for (EObject eobj: (Iterable<EObject>)()->forEcore.getAllContents()) {
			if (eobj instanceof EStructuralFeature) {
				EStructuralFeature esf = (EStructuralFeature)eobj;
				FunctionType esfFunc = getFunctionType(esf);
				associationsType.addType(MyEcoreUtil.getName(esf), esfFunc);
			}
		}
		return type;
		
	}



}

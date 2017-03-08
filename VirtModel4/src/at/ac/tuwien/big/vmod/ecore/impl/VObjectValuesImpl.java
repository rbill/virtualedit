package at.ac.tuwien.big.vmod.ecore.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.EcoreFuncUtil;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VObjectValues;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;

public class VObjectValuesImpl implements VObjectValues {
	
	Function<Symbol, ? extends Counter> objectFunction;
	Function<Symbol, Function<String, ? extends Counter>> classFunction;
	Function<Symbol, Function<Symbol, ? extends Counter>> containerFunction;
	VEcoreFile ecoreFile;
	VModelView modelView;
	
	public static Map<Symbol,Symbol> contained = new HashMap<>();
	public static Map<Symbol,Set<Symbol>> containing = new WeakHashMap<>();
	
	public Set<Symbol> getContained(Symbol inObj) {
		Set<Symbol> ret = containing.get(inObj);
		if (ret == null) {
			containing.put(inObj, ret = new HashSet<>());
		}
		return ret;
	}
	
	public static final Symbol MODEL_ROOT = new SymbolImpl("MODEL_ROOT");
	
	public VObjectValuesImpl(Function<Symbol, ? extends Counter> objectFunction, 
			Function<Symbol, Function<Symbol, ? extends Counter>> containerFunction,
			Function<Symbol, Function<String, ? extends Counter>> classFunction, 
			VModelView modelView,
			VEcoreFile ecoreFile) {
		this.objectFunction = objectFunction;
		this.classFunction = classFunction;
		this.containerFunction = containerFunction;
		this.ecoreFile = ecoreFile;
		this.modelView = modelView;
	}

	@Override
	public Iterator<Symbol> iterator() {
		return Function.getExistingValues(objectFunction).iterator();
	}

	@Override
	public EClass getClass(Symbol objectId) {
		return EcoreFuncUtil.getClass(classFunction.getValue(objectId), ecoreFile);
	}

	@Override
	public void setClass(Symbol objectId, EClass classId) {
		EcoreFuncUtil.setClass(classFunction.getValue(objectId), classId);
		System.out.println("Set class of "+objectId+ " to "+classId);
	}

	@Override
	public boolean exists(Symbol objectId) {
		return objectFunction.getValue(objectId).exists();
	}

	@Override
	public void add(Symbol objectId) {
		if (objectFunction.getValue(objectId).setMin(1)) {
			//getContained(objectId).forEach((x)->VObjectValuesImpl.this.add(x)); //Strange bug when doing this recursively ... why?
		}
	}

	@Override
	public void remove(Symbol objectId) {
		if (objectFunction.getValue(objectId).setMax(0)) {
			//getContained(objectId).forEach((x)->VObjectValuesImpl.this.remove(x));
		}
	}

	@Override
	public void nullifyClear() {
		objectFunction.clear();
	}
	
	@Override
	public void makeContainedInRoot(Symbol containedObject) {
		Function.setToVal(containerFunction.getValue(containedObject), MODEL_ROOT);
		add(containedObject);
		Symbol prevCont = contained.remove(containedObject);
		if (prevCont != null) {
			getContained(prevCont).remove(containedObject);
		}
	} 
	
	@Override
	public void makeUncontainedInRoot(Symbol containedObject) {
		Function.removeVal(containerFunction.getValue(containedObject), MODEL_ROOT);
		if (Function.isEmpty(containerFunction.getValue(containedObject))) {
			remove(containedObject);
		}
	}

	@Override
	public void setContainer(Symbol containedObject, Symbol containingObject, String featureName) {
		System.out.println("Object "+containedObject+" is contained via "+featureName+" in "+containingObject);
		Function.setToVal(containerFunction.getValue(containedObject), Symbol.buildFrom("Feature",containingObject,featureName));
		Symbol curCont = contained.get(containingObject);
		if (containedObject == curCont) {
			System.err.println("INverse add?!");
		}
		Symbol prevCont = contained.put(containedObject,containingObject);
		if (prevCont != null) {
			getContained(prevCont).remove(containedObject);
		}
		getContained(containingObject).add(containedObject);
		add(containedObject);
	}
	
	@Override
	public void informContainer(Symbol containedObject, EReference feature, Symbol containingObject) {
		setContainer(containedObject,containingObject,EcoreFuncUtil.featureName(feature));
	}
	
	@Override
	public void informNoContainer(Symbol containedObject, EReference feature, Symbol containingObject) {
		Function.removeVal(containerFunction.getValue(containedObject), Symbol.buildFrom("Feature",containingObject,EcoreFuncUtil.featureName(feature)));
		contained.remove(containedObject, containingObject);
		getContained(containingObject).remove(containedObject);
		if (Function.isEmpty(containerFunction.getValue(containedObject))) {
			remove(containedObject);
		}
	}

	@Override
	public Symbol getContainerFull(Symbol objectId) {
		return Function.getAnyVal(containerFunction.getValue(objectId));
	}

	@Override
	public Function<String, ? extends Counter> getClassFunc(Symbol id) {
		return classFunction.getValue(id);
	}

}

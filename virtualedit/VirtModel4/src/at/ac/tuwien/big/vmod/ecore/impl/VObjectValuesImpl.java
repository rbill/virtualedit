package at.ac.tuwien.big.vmod.ecore.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
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
	}

	@Override
	public boolean exists(Symbol objectId) {
		return objectFunction.getValue(objectId).exists();
	}

	@Override
	public void add(Symbol objectId) {
		objectFunction.getValue(objectId).setMin(1);
	}

	@Override
	public void remove(Symbol objectId) {
		objectFunction.getValue(objectId).setMax(0);
	}

	@Override
	public void nullifyClear() {
		objectFunction.clear();
	}
	
	@Override
	public void makeContainedInRoot(Symbol containedObject) {
		Function.setToVal(containerFunction.getValue(containedObject), MODEL_ROOT);
		add(containedObject);
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
		contained.put(containedObject,containingObject);
		add(containedObject);
	}
	
	@Override
	public void informContainer(Symbol containedObject, EReference feature, Symbol containingObject) {
		setContainer(containedObject,containingObject,EcoreFuncUtil.featureName(feature));
	}
	
	@Override
	public void informNoContainer(Symbol containedObject, EReference feature, Symbol containingObject) {
		Function.removeVal(containerFunction.getValue(containedObject), Symbol.buildFrom("Feature",containingObject,EcoreFuncUtil.featureName(feature)));
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

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
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class VObjectValuesImpl extends VAbstractObjectValuesImpl implements VObjectValues {
	
	Function<Symbol, ? extends Counter> objectFunction;
	Function<Symbol, Function<String, ? extends Counter>> classFunction;
	Function<Symbol, Function<Symbol, ? extends Counter>> containerFunction;
	VModelView modelView;
	
	public static final Symbol MODEL_ROOT = new SymbolImpl("MODEL_ROOT");
	
	public VObjectValuesImpl(Function<Symbol, ? extends Counter> objectFunction, 
			Function<Symbol, Function<Symbol, ? extends Counter>> containerFunction,
			Function<Symbol, Function<String, ? extends Counter>> classFunction, 
			VModelView modelView,
			VEcoreFile ecoreFile) {
		super(ecoreFile);
		this.objectFunction = objectFunction;
		this.classFunction = classFunction;
		this.containerFunction = containerFunction;
		this.modelView = modelView;
	}

	@Override
	protected Function<Symbol, ? extends Counter> objectFunction() {
		return objectFunction;
	}

	@Override
	protected Function<Symbol, Function<String, ? extends Counter>> classFunction() {
		return classFunction;
	}

	@Override
	protected Function<Symbol, Function<Symbol, ? extends Counter>> containerFunction() {
		return containerFunction;
	}

	@Override
	protected VModelView modelView() {
		return modelView;
	}


}

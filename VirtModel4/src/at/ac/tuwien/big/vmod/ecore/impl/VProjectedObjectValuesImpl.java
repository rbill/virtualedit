package at.ac.tuwien.big.vmod.ecore.impl;

import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VProjectedModelView;
import at.ac.tuwien.big.vmod.ecore.VProjectedObjectValues;
import at.ac.tuwien.big.vmod.impl.ParametizedCounter;
import at.ac.tuwien.big.vmod.impl.ParametizedFunction;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;

public class VProjectedObjectValuesImpl extends VAbstractObjectValuesImpl implements VProjectedObjectValues {
	
	ParametizedFunction<Symbol, ? extends Counter, MultiPoint, SinglePoint> objectFunction;
	ParametizedFunction<Symbol, ParametizedFunction<String, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> classFunction;
	ParametizedFunction<Symbol, ParametizedFunction<Symbol, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint,SinglePoint>, MultiPoint, SinglePoint> containerFunction;
	VProjectedModelView modelView;
	
	public static final Symbol MODEL_ROOT = new SymbolImpl("MODEL_ROOT");
	
	public VProjectedObjectValuesImpl(ParametizedFunction<Symbol, ? extends Counter, MultiPoint, SinglePoint> objectFunction, 
			ParametizedFunction<Symbol, ParametizedFunction<Symbol, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint,SinglePoint>, MultiPoint, SinglePoint> containerFunction,
			ParametizedFunction<Symbol, ParametizedFunction<String, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> classFunction, 
			VProjectedModelView  modelView,
			VEcoreFile ecoreFile) {
		super(ecoreFile);
		this.objectFunction = objectFunction;
		this.classFunction = classFunction;
		this.containerFunction = containerFunction;
		this.modelView = modelView;
	}

	@Override
	protected ParametizedFunction<Symbol, ? extends Counter, MultiPoint, SinglePoint> objectFunction() {
		return objectFunction;
	}

	@Override
	protected ParametizedFunction<Symbol, ParametizedFunction<String, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> classFunction() {
		return classFunction;
	}

	@Override
	protected ParametizedFunction<Symbol, ParametizedFunction<Symbol, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint,SinglePoint>, MultiPoint, SinglePoint> containerFunction() {
		return containerFunction;
	}

	@Override
	protected VProjectedModelView  modelView() {
		return modelView;
	}

	@Override
	public VProjectedObjectValues project(MultiPoint t) {
		return new VProjectedObjectValuesImpl(objectFunction.project(t),
				containerFunction.project(t), classFunction.project(t), modelView.project(t), ecoreFile);
	}


}

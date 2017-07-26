package at.ac.tuwien.big.vmod.ecore.impl;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.VFakeEList;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VProjectedFakeEList;
import at.ac.tuwien.big.vmod.ecore.VProjectedFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VProjectedModelView;
import at.ac.tuwien.big.vmod.impl.ParametizedCounter;
import at.ac.tuwien.big.vmod.impl.ParametizedFunction;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;

public class VProjectedFeatureValuesImpl<T> implements VProjectedFeatureValues<T> {
	
	private ParametizedFunction<Symbol, ParametizedFunction<Treepos, ParametizedFunction<T, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> featureFunc;
	private EStructuralFeature baseFeature;
	private boolean isContainment;
	private EReference inverse;
	private Filter<T> instanceFilter;
	private VProjectedModelView  modelView;
	
	public VProjectedFeatureValuesImpl(EStructuralFeature baseFeature, 
			ParametizedFunction<Symbol, ParametizedFunction<Treepos, ParametizedFunction<T, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> featureVals,
			VProjectedModelView  modelView
			) {
		this.featureFunc = featureVals;
		this.baseFeature = baseFeature;
		this.instanceFilter = VFakeEList.NO_FILTER;
		this.modelView = modelView;
		
		if (baseFeature instanceof EReference) {
			EReference er = (EReference)baseFeature;
			this.isContainment = er.isContainment();
			this.inverse = er.getEOpposite();
		}
	}
	
	public VProjectedFeatureValuesImpl(VProjectedFeatureValuesImpl<T> copyFrom, MultiPoint newProjection) {
		this.featureFunc = copyFrom.featureFunc.project(newProjection);
		this.baseFeature = copyFrom.baseFeature;
		this.isContainment = copyFrom.isContainment;
		this.inverse = copyFrom.inverse;
		this.instanceFilter = copyFrom.instanceFilter;
		this.modelView = copyFrom.modelView.project(newProjection);
	}

	@Override
	public List<?> getEcoreValue(Symbol uuid) {
		List ret = getValueValue(uuid);
		if (baseFeature instanceof EReference) {
			ret = modelView.wrapObjects(ret);
		} 
		return ret;
	}
	
	@Override
	public List<?> getValueValue(Symbol uuid) {
		ParametizedFunction<Treepos, ParametizedFunction<T, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> list = featureFunc.getValue(uuid);
		List ret = new VProjectedFakeEList<>(uuid, list, instanceFilter, modelView, isContainment, baseFeature);
		return ret;
	}

	@Override
	public void clear() {
		featureFunc.clear();
	}

	@Override
	public ParametizedFunction<Symbol, ParametizedFunction<Treepos, ParametizedFunction<T, ? extends ParametizedCounter<MultiPoint,SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint>, MultiPoint, SinglePoint> getFunction() {
		return featureFunc;
	}

	@Override
	public VProjectedFeatureValues<T> project(MultiPoint v) {
		return new VProjectedFeatureValuesImpl<>(this, v);
	}

}

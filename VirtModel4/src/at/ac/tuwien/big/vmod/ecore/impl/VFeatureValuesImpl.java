package at.ac.tuwien.big.vmod.ecore.impl;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.VFakeEList;
import at.ac.tuwien.big.vmod.ecore.VFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;

public class VFeatureValuesImpl<T> implements VFeatureValues<T> {
	
	private Function<Symbol, Function<Treepos, Function<T, ? extends Counter>>> featureFunc;
	private EStructuralFeature baseFeature;
	private boolean isContainment;
	private EReference inverse;
	private Filter<T> instanceFilter;
	private VModelView modelView;
	
	public VFeatureValuesImpl(EStructuralFeature baseFeature, Function<Symbol, Function<Treepos, Function<T, ? extends Counter>>> featureVals,
			VModelView modelView
			) {
		this.featureFunc = featureVals;
		this.baseFeature = baseFeature;
		this.instanceFilter = VFakeEList.NO_FILTER;
		this.modelView = modelView;
		
		if (baseFeature instanceof EReference) {
			EReference er = (EReference)baseFeature;
			this.isContainment = er.isContainment();
			this.inverse = er.getEOpposite();
			if (!this.isContainment) {
				//TODO: Warum geht das nicht?
				/*this.instanceFilter = (x)->{
					if (x instanceof VMEObject) {
						Symbol sym = ((VMEObject)x).getUUID();
						return modelView.getInstances().contExists(sym);
					}
					return true;
				};*/
			}
		}
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
		Function<Treepos, Function<T, ? extends Counter>> list = featureFunc.getValue(uuid);
		List ret = new VFakeEList<>(uuid, list, instanceFilter, modelView, isContainment, baseFeature);
		return ret;
	}

	@Override
	public void clear() {
		featureFunc.clear();
	}

	@Override
	public Function<Symbol, Function<Treepos, Function<T, ? extends Counter>>> getFunction() {
		return featureFunc;
	}

}

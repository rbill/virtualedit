package at.ac.tuwien.big.vmod.ecore;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.impl.ParametizedCounter;
import at.ac.tuwien.big.vmod.impl.ParametizedFunction;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;

public class VProjectedFakeEList<T,V extends Iterable<U>,U> extends VFakeEList<T> implements Projected<VProjectedFakeEList<T, V, U>,V> {


	private VProjectedFakeEList(VProjectedFakeEList<T,V,U> copy, boolean useInverse) {
		super(copy,useInverse);
	}
	
	private VProjectedFakeEList(VProjectedFakeEList<T,V,U> copy, boolean useInverse, V v) {
		super(copy,useInverse);
		if (useInverse) {
			this.inverseFunction = (Function)((ParametizedFunction)this.inverseFunction).project(v);
		}
		this.mainFunction = (Function)((ParametizedFunction)this.mainFunction).project(v);
	}
	
	public VProjectedFakeEList<T,V,U> noInverse() {
		if (inverseFunction == null) {
			return this;
		}
		return new VProjectedFakeEList<>(this,false);
	}
	
	

	public VProjectedFakeEList(Symbol myValue, ParametizedFunction<Treepos, ? extends ParametizedFunction<T, ? extends ParametizedCounter<V, U>,V,U>,V,U> function, Filter<T> instanceFilter, VModelView model, EStructuralFeature thisRefNoOpposite, boolean isContainment) {
		super(myValue,function,instanceFilter,model,thisRefNoOpposite,isContainment);
	}
	
	public VProjectedFakeEList(Symbol myValue, ParametizedFunction<Treepos, ? extends ParametizedFunction<T, ? extends ParametizedCounter<V, U>,V,U>,V,U> function, Filter<T> instanceFilter, VModelView model, boolean isContainment, EStructuralFeature thisRef) {
		super(myValue,function,instanceFilter,model,isContainment,thisRef);
		this.basicList = new VProjectedFakeEList<T,V,U>(myValue, function, instanceFilter, model, thisRef, isContainment);
	}
	
	public VProjectedFakeEList<T, V, U> project(V v) {
		return new VProjectedFakeEList<>(this, true, v);
	}
}

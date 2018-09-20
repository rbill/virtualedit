package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocalImpl;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;

public class SingleESFAttributeHandler<T,U> extends BasicChangeNotifyerWithLocalImpl implements SingleAttributeHandler<T> {
	
	private EStructuralFeature feature;
	private EObject base;
	private Function<U,T> convertThere;
	private Function<T,U> convertBack;
	
	public SingleESFAttributeHandler(EObject base, EStructuralFeature esf, Function<U,T> convertThere, Function<T,U> convertBack) {
		this.base = base;
		this.feature = esf;
		this.convertBack = convertBack;
		this.convertThere = convertThere;
	}

	@Override
	public T get() {
		return this.convertThere.apply((U)this.base.eGet(this.feature));
	}

	@Override
	public AbstractFunc<?, T, ? extends QueryResult<?, T>> getTreeposFuncOrNull() {
		return null;
	}

	@Override
	public boolean isSet() {
		return this.base.eIsSet(this.feature);
	}

	@Override
	public void set(T newObj) {
		Object cur = this.base.eGet(this.feature);
		if (!Objects.equals(newObj, cur)) { 
			this.base.eSet(this.feature, this.convertBack.apply(newObj));
			changed();
		}
	}

	@Override
	public void unset() {
		boolean wasSet = isSet();
		this.base.eUnset(this.feature);
		if (wasSet) {
			changed();
		}
	}


}

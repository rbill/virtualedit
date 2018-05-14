package at.ac.tuwien.big.vfunc.basic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import at.ac.tuwien.big.vfunc.basic.impl.BasicChange;

public class SelfUpdatingValue<Src,Trg> implements ChangeListenable<SelfUpdatingValue<Src,Trg>, Src, Trg>, Notifyer<SelfUpdatingValue<Src,Trg>, Src, Trg> {
	
	/*Diese BasicFunction wird wohl eine implementierung dieser interpretierten Funktionen*/
	private BasicFunctionForUpdate<Src, Trg> baseFunc;
	private Set<Notifyer<?, ?, ?>> usedResources = new HashSet<>();
	private Trg value;
	private Src src;
	
	public SelfUpdatingValue(BasicFunctionForUpdate<Src, Trg> func, Src src) {
		this.baseFunc = func;
		this.src = src;
	}
	
	private void recalc() {
		usedResources.forEach(x->x.removeChangeListener(this));
		usedResources.clear();
		Trg oldValue = value;
		value = baseFunc.getValue(src, usedResources);
		if (!Objects.equals(value, oldValue)) {
			changed(new BasicChange<>(this,src,oldValue,value));
		}
	}

	@Override
	public List<WeakReference<ChangeListenable<? super SelfUpdatingValue<Src, Trg>, ? super Src, ? super Trg>>> getChangeListeners() {
		List<WeakReference<ChangeListenable<? super SelfUpdatingValue<Src, Trg>, ? super Src, ? super Trg>>> ret = new ArrayList<>();
		usedResources.forEach(x->ret.add(new WeakReference((ChangeListenable)x)));
		return ret;
	}

	@Override
	public void changed(Change<? extends SelfUpdatingValue<Src, Trg>, ? extends Src, ? extends Trg> change) {
		recalc();
	}
	
	@Override
	public void finalize() throws Throwable {
		super.finalize();
		usedResources.forEach(x->{if (x != null){x.removeChangeListener(this);}});
	}

}

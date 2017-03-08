package at.ac.tuwien.big.vmodel.general.impl;

public class SimpleDeltaIntegerValueEditableViewListening<U1,U2> extends at.ac.tuwien.big.vmodel.general.impl.SimpleDeltaIntegerValueEditableView<U1,U2> implements at.ac.tuwien.big.virtmod.structure.VListeningProperty<SimpleDeltaIntegerValueEditableViewListener<U1,U2>> {

	java.util.WeakHashMap<SimpleDeltaIntegerValueEditableViewListener<U1,U2>,Boolean> $listeners = new java.util.WeakHashMap<>();

	public void addIncompleteListener(at.ac.tuwien.big.virtmod.structure.VListener listener ) {
		$listeners.put(listener.fullyImplement(SimpleDeltaIntegerValueEditableViewListener.class),true);
	}

	public void addListener(SimpleDeltaIntegerValueEditableViewListener<U1,U2> listener ) {
		$listeners.put(listener,true);
	}

	public void removeListeners(at.ac.tuwien.big.virtmod.structure.VObject vobj) {
		$listeners.keySet().removeIf((x)->{
			if(java.util.Objects.equals(x.getContainingObject(),vobj)) {
				x.destroy();
				return true;
			}
			return false;
		});
	}

	public java.lang.String toString() {
		java.lang.String ret = super.toString();
		$listeners.keySet().forEach((x)->{try {x.ontoString(this);} catch (Exception e) {e.printStackTrace();}});

		$listeners.keySet().forEach((x)->{try {x.onchange(this);} catch (Exception e) {e.printStackTrace();}});
		return ret;
	}

	public boolean selfClear() {
		boolean ret = super.selfClear();
		$listeners.keySet().forEach((x)->{try {x.onselfClear(this);} catch (Exception e) {e.printStackTrace();}});

		$listeners.keySet().forEach((x)->{try {x.onchange(this);} catch (Exception e) {e.printStackTrace();}});
		return ret;
	}

	public void add(int value) {
		super.add(value);
		$listeners.keySet().forEach((x)->{try {x.onadd(this,value);} catch (Exception e) {e.printStackTrace();}});

		$listeners.keySet().forEach((x)->{try {x.onchange(this);} catch (Exception e) {e.printStackTrace();}});
	}

}

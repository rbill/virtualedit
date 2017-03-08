package at.ac.tuwien.big.virtmod.structure.test;

public class SimplePropertyListening<T> extends at.ac.tuwien.big.virtmod.structure.test.SimpleProperty<T> implements at.ac.tuwien.big.virtmod.structure.VListeningProperty<SimplePropertyListener<T>> {

	java.util.WeakHashMap<SimplePropertyListener<T>,Boolean> $listeners = new java.util.WeakHashMap<>();

	public void addIncompleteListener(at.ac.tuwien.big.virtmod.structure.VListener listener ) {
		$listeners.put(listener.fullyImplement(SimplePropertyListener.class),true);
	}

	public void addListener(SimplePropertyListener<T> listener ) {
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

	public void set(T newVal) {
		super.set(newVal);
		$listeners.keySet().forEach((x)->{try {x.onset(this,newVal);} catch (Exception e) {e.printStackTrace();}});

		$listeners.keySet().forEach((x)->{try {x.onchange(this);} catch (Exception e) {e.printStackTrace();}});
	}


}

package at.ac.tuwien.big.virtmod.structure.test;

import at.ac.tuwien.big.helper.annotation.VProp;
import at.ac.tuwien.big.virtmod.structure.VListener;
import at.ac.tuwien.big.virtmod.structure.VListeningProperty;
import at.ac.tuwien.big.virtmod.structure.VObject;
import at.ac.tuwien.big.virtmod.structure.VProperty;
import at.ac.tuwien.big.virtmod.structure.property.SingleSetVProperty;

@VProp
public class SimpleProperty<T> implements SingleSetVProperty<T>{
	
	private T value;

	@Override
	public T get() {
		return value;
	}

	@Override 
	public void set(T newVal) { 
		this.value = newVal;
	}
	 
	public static interface SimplePropertyListenerIface<T> extends VListener {
		public void onbeforeset(SimpleProperty<T> prop, T newVal);
		
		public void onset(SimpleProperty<T> prop, T newVal);
	}
	
	public static class SimplePropertyListenerB<T> implements SimplePropertyListenerIface<T>  {

		public void onbeforeset(SimpleProperty<T> prop, T newVal) {
			System.out.println("Wanting to Set Property of " + prop + " from "+prop.get()+" to "+newVal);
		}
		
		public void onset(SimpleProperty<T> prop, T newVal) {
			System.out.println("Have Set Property of " + prop + " to "+newVal);
		}
		
		@Override
		public VObject getContainingObject() {
			return null;
		}

		@Override
		public void destroy() {
		}
		
	}
	
	public static void main(String[] args) {
		SimpleProperty<Integer> base = new SimpleProperty<Integer>();
		base.set(5);
		System.out.println("Value of base: " + base.get());
		VListeningProperty prop = base.toListeningProperty();
		SimplePropertyListenerB<Integer> listener = new SimplePropertyListenerB<Integer>();
		prop.addListener(listener);
		SingleSetVProperty setProp = (SingleSetVProperty)prop;
		setProp.set(6);
		VListener baseL = new VListener() {
			
			public void onset(SimpleProperty prop, Object newVal) {
				System.out.println("Normal Listener called with setting "+prop+ " value to " + newVal);
			}

			@Override
			public VObject getContainingObject() {
				return null;
			}

			@Override
			public void destroy() {
			}
		};
		SimplePropertyListenerIface list = (SimplePropertyListenerIface)baseL.fullyImplement(SimplePropertyListenerIface.class)
		; 
		setProp.set(7);
		prop.addListener(list);
		VListener baseL2 = new VListener() {
			
			public void onset(SimpleProperty prop, long $opid, Object newVal) {
				System.out.println("Opid Listener called with setting "+prop + " value to " + newVal+" and opid "+$opid);
			}

			@Override
			public VObject getContainingObject() {
				return null;
			}

			@Override
			public void destroy() {
			}
		};
		VListener list2 = baseL2.fullyImplement(SimplePropertyListenerIface.class);
		prop.addListener(list2);
		setProp.set(8);
		
		System.out.println("Value of prop: "+setProp.get());
		System.out.println("Value of base: "+base.get());
		System.out.println("Doing nothing with " + listener+","+list+","+baseL+","+baseL2+","+list2);
	}
	

}

package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import at.ac.tuwien.big.virtmod.basic.ContainState;
import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.basic.VEditableInvertibleFunc;
import at.ac.tuwien.big.virtmod.basic.ValueList;
import at.ac.tuwien.big.virtmod.basic.ValueState;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public class SimpleEditableInvertibleFunc<T,U> extends SimpleAbstractFunc<T, U, ValueList<U>> implements VEditableInvertibleFunc<T, U> {

	private Map<U, ValueList<T>> inverseMap = new HashMap<>();
	
	private Map<T, ValueList<U>> mapSimple = new HashMap<>();	
	private Map<U, ValueList<T>> inverseMapSimple = new HashMap<>();
	
	
	protected Map<U, ValueList<T>> inverseMap() {
		return inverseMap;
	}
	
	protected Map<U, ValueList<T>> simpleInverseMap() {
		return inverseMapSimple;
	}
	
	protected Map<T, ValueList<U>> simpleMap() {
		return mapSimple;
	}
	
	//ValueList müssen auch inverse sein ...
	
	
	public boolean addDefault(T value) {
		return addSet(value);
	}
	
	
	private VEditableInvertibleFunc<U, T> inverse;
	private VEditableInvertibleFunc<U, T> simpleInverse;
	private VEditableInvertibleFunc<T, U> simple;
	
	{
		this.inverse = null;
	}
	
	protected VEditableInvertibleFunc<U, T> simpleInverse() {
		if (simpleInverse == null) {
			SimpleEditableInvertibleFunc<T,U> This = (SimpleEditableInvertibleFunc<T,U>)this;

			this.simpleInverse = new SimpleEditableInvertibleFunc<U,T>() {
				@Override
				protected Map<T, ValueList<U>> inverseMap() {
					return This.simpleMap();
				}
				
				@Override
				protected Map<U, ValueList<T>> map() {
					return This.simpleInverseMap();
				}
				
				@Override
				protected Map<U, ValueList<T>> simpleMap() {
					return This.simpleInverseMap();
				}
				

				@Override
				protected Map<T, ValueList<U>> simpleInverseMap() {
					return This.simpleMap();
				}
				
				public VEditableInvertibleFunc<T, U> inverse() {
					return This.simple();
				}
				
				public VEditableInvertibleFunc<T, U> simpleInverse() {
					return This.simple();
				}
				
				public VEditableInvertibleFunc<U, T> simple() {
					return This.simpleInverse();
				}				
				@Override
				protected ValueList<T> createValueList(U forValue) {
					return new SimpleValueList<T>(); 
				}
			};
		}
		return simpleInverse;
	}
	
	@Override
	public VEditableInvertibleFunc<U, T> inverse() {
		if (inverse == null) {
			SimpleEditableInvertibleFunc<T,U> This = (SimpleEditableInvertibleFunc<T,U>)this;
			inverse = new SimpleEditableInvertibleFunc<U,T>() {
				@Override
				protected Map<T, ValueList<U>> inverseMap() {
					return This.map();
				}
				
				@Override
				protected Map<U, ValueList<T>> map() {
					return This.inverseMap();
				}
				
				@Override
				protected Map<U, ValueList<T>> simpleMap() {
					return This.simpleInverseMap();
				}
				

				@Override
				protected Map<T, ValueList<U>> simpleInverseMap() {
					return This.simpleMap();
				}
				
				public VEditableInvertibleFunc<T, U> inverse() {
					return This;
				}
				
				public VEditableInvertibleFunc<T, U> simpleInverse() {
					return This.simple();
				}
				
				public VEditableInvertibleFunc<U, T> simple() {
					return This.simpleInverse();
				}
			};
		}
		return inverse;
	}
		
	@Override
	public VEditableInvertibleFunc<T, U> simple() {
		if (simple == null) {
			SimpleEditableInvertibleFunc<T,U> This = (SimpleEditableInvertibleFunc<T,U>)this;
			this.simple = new SimpleEditableInvertibleFunc<T,U>() {

				@Override
				protected Map<U, ValueList<T>> inverseMap() {
					return This.simpleInverseMap();
				}
				
				@Override
				protected Map<T, ValueList<U>> map() {
					return This.simpleMap();
				}
				
				public VEditableInvertibleFunc<U, T> inverse() {
					return This.simpleInverse();
				}
				
				public VEditableInvertibleFunc<U, T> simpleInverse() {
					return This.simpleInverse();
				}
				
				public VEditableInvertibleFunc<T,U> simple() {
					return this;
				}
				
				@Override
				protected ValueList<U> createValueList(T forValue) {
					return new SimpleValueList<U>(); 
				}
			};
		}
		return simple;
	}
	
	@Override
	public Iterator<T> iterator() {
		return IteratorUtils.convert(allValues().iterator(), (x)->x.getKey());
	}
	
	@Override
	public void ensure(T forValue, ContainState state) {
		ValueList<U> curValues = getValues(forValue);
		if (state == ContainState.CONTAINS) {
			if (curValues.isEmpty()) {
				curValues.add(getEditState().advEditId(), getDefaultValue(forValue));
			}
		} else {
			if (!curValues.isEmpty()) {
				curValues.removeClear();
			}
		}
	}
	
	protected U getDefaultValue(T forValue) {
		return null;
	}
	
	public ValueList<U> getBaseList(T forValue) {
		ValueList<U> ret = simpleMap().get(forValue);
		if (ret == null) {
			simpleMap().put(forValue, ret = new SimpleValueList<U>());
		}
		return ret;
	}
	
	@Override
	protected ValueList<U> createValueList(T forValue) {
		return new InvertibleValueList<U,T>(this.inverseSimple(),forValue,getBaseList(forValue)); 
	}
	
	@Override
	public boolean addSet(T entry) {
		boolean ret = contains(entry);
		if (!ret) {
			ensure(entry,ContainState.CONTAINS);
		}
		return !ret;
	}
	
	public static void main(String[] args) {
		SimpleEditableInvertibleFunc<Integer, String> test = new SimpleEditableInvertibleFunc<Integer, String>();
		test.insert("I", 1);
		test.insert("II", 2);
		test.insert("III", 3);
		test.insert("V", 5);
		test.insert("X", 10);
		System.out.println(test.getValues(1));
		System.out.println(test.inverse().getValues("I"));
		test.insert("I", 2);
		System.out.println(test.getValues(1));
		System.out.println(test.inverse().getValues("I"));
		test.remove("I", 1);
		System.out.println(test.getValues(1));
		System.out.println(test.inverse().getValues("I"));
	}
}

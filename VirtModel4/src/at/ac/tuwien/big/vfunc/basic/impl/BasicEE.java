package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import at.ac.tuwien.big.vfunc.basic.AnyParameterModifier;
import at.ac.tuwien.big.vfunc.basic.FourParameterModifier;
import at.ac.tuwien.big.vfunc.basic.OneParameterModifier;
import at.ac.tuwien.big.vfunc.basic.ThreeParameterModifier;
import at.ac.tuwien.big.vfunc.basic.TwoParameterModifier;

public class BasicEE implements AnyParameterModifier {
	
	private Object[] objects;

	public void set(int index, Object obj)  {
		if (objects.length<index) {
			objects = Arrays.copyOf(objects, index+1);
		}
		objects[index] = obj;
	}
	
	public Object get(int index) {
		return index<objects.length?objects[index]:null;
	}
	

	@Override
	public boolean has(int nmb) {
		return nmb>=0 && nmb < objects.length;
	}

	@Override
	public boolean maySet(int nmb) {
		return has(nmb);
	}

	
	public BasicEE(Object... objects) {
		this.objects = objects;
	}
	
	public BasicEE extract(int... indices) {
		Object[] ret = new Object[indices.length];
		for (int i = 0; i < indices.length; ++i) {
			ret[i] = objects[indices[i]];
		}
		return new BasicEE(ret);
	}
	
	public BasicEE clone() {
		return new BasicEE(Arrays.copyOf(objects, objects.length));
	}
	
	public BasicEE clone(int index) {
		return new BasicEE(Arrays.copyOf(objects, Math.max(index+1,objects.length)));
	}
	
	public BasicEE augment(int index, Object newObj) {
		int newLength = Math.max(index+1, objects.length);
		BasicEE ret = new BasicEE(Arrays.copyOf(objects, newLength));
		ret.set(index, newObj);
		return ret;
	}
	

	public BasicEE augment(int index, Object newObj, int index2, Object newObj2) {
		int newLength = Math.max(Math.max(index,index2)+1, objects.length);
		BasicEE ret = new BasicEE(Arrays.copyOf(objects, newLength));
		ret.set(index, newObj);
		ret.set(index2, newObj2);
		return ret;
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(objects);
	}
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof BasicEE) && Arrays.equals(objects,((BasicEE)other).objects);
	}
	
	private class EEAnyParamterModifier implements AnyParameterModifier {
		private int[] indices;
		private Object[] supplied;
		private boolean[] known;
		private List<Supplier<?>> suppliers;
		
		public EEAnyParamterModifier(List<Supplier<?>> suppliers, int... indices) {
			this.indices = indices;
		}
		
		public EEAnyParamterModifier(int... indices) {
			this(Collections.emptyList(),indices);
		}
		
		public Object get(int nmb) {
			int idx = indices[nmb];
			if (idx >= 0) {
				return BasicEE.this.get(idx);
			} else {
				int subIndex = -(idx+1);
				if (!known[subIndex]) {
					known[subIndex] = true;
					supplied[subIndex] = suppliers.get(idx);
				}
				return supplied[subIndex];
			}
		}
		
		public void set(int nmb, Object obj) {
			int idx = indices[nmb];
			if (idx >= 0) {
				BasicEE.this.set(idx, obj);
			} else {
				throw new RuntimeException("May not set index " + nmb+" because it is from a supplier!");
			}
		}
		
		public boolean checkWriteability(boolean... mustBeAbleToWrite)  {
			if (indices.length < mustBeAbleToWrite.length) {
				//Not enough to read
				return false;
			}
			for (int i = 0; i < mustBeAbleToWrite.length; ++i) {
				if (mustBeAbleToWrite[i] && indices[i]<0) {
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean has(int nmb) {
			return nmb<indices.length;
		}

		@Override
		public boolean maySet(int nmb) {
			return nmb<indices.length && indices[nmb]>=0;
		}


		
	}
	
	public AnyParameterModifier anyParameterModifier(int... indices) {
		return new EEAnyParamterModifier(indices);
	}
	
	public OneParameterModifier getModifier(int index) {
		return anyParameterModifier(index);
	}
	

	public TwoParameterModifier getModifier(int index, int index2) {
		return anyParameterModifier(index, index2);
	}
	
	public ThreeParameterModifier getModifier(int index, int index2, int index3) {
		return anyParameterModifier(index, index2, index3);
	}
	
	public FourParameterModifier getModifier(int index, int index2, int index3, int index4) {
		return anyParameterModifier(index, index2, index3, index4);
	}
	

	/**Indices: +: Evaluation Environment: -: Supplier-1*/
	public static<Source> BiFunction<BasicEE, List<Supplier<?>>, BasicEE> getEEModifier(Consumer<? super AnyParameterModifier> modifier, int... indices) {
		int max = -1;
		for (int ind = 0; ind < indices.length; ++ind) {
			max = Math.max(max, indices[ind]); 
		}
		int fmax = max;
		BiFunction<BasicEE, List<Supplier<?>>, BasicEE> eeModifier = 
				(oldEE, suppliers)->{
					
					BasicEE newEE = oldEE.clone(fmax);
					modifier.accept(newEE.anyParameterModifier(suppliers, indices));
					return newEE;
				};
		return eeModifier;
	}
	
	public AnyParameterModifier anyParameterModifier(List<Supplier<?>> suppliers, int... indices) {
		return new EEAnyParamterModifier(suppliers,indices);
	}

	

}

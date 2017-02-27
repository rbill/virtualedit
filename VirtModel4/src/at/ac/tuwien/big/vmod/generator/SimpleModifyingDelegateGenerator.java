package at.ac.tuwien.big.vmod.generator;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.DelegateBuilt;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.impl.DelegateCounter;
import at.ac.tuwien.big.vmod.impl.DelegateFunction;
import at.ac.tuwien.big.vmod.impl.DelegateModelResource;
import at.ac.tuwien.big.vmod.impl.ParentLocationImpl;
import at.ac.tuwien.big.vmod.type.CountType;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.Symbol;

public interface SimpleModifyingDelegateGenerator extends DelegateGenerator {

	@Override
	public default Object generate(Object self, Object key) {
		if (self instanceof Function) {
			if (self instanceof DelegateBuilt) {
				return generate((Function)self,key,((DelegateBuilt<Function>)self).getBase().getValue(key));
			} else {
				return ((Function)self).getValue(key);
			}
		} else if (self instanceof ModelResource) {
			//It's rather similar ...
			ModelResource mr = (ModelResource)self;
			if (mr instanceof DelegateBuilt) {
				DelegateBuilt db = (DelegateBuilt)mr;
				ModelResource baseRes = (ModelResource)db.getBase();
				Object base = baseRes.getElement((Symbol)key);
				GeneralType type = null;
				if (base instanceof GeneralElement) {
					type = ((GeneralElement) base).getType();
				}
				Object ret = null;
				if (type == null) {
					
					System.err.println("Don't know how to transform "+base);
					return base;
				} else {
					//Das result soll auch vom Typ sein
					if (type instanceof FunctionType) {
						boolean userEdit = false;
						if (self instanceof DelegateFunction) {
							userEdit = ((DelegateFunction)self).isUserEdit();
						}
						if (self instanceof DelegateModelResource) {
							userEdit = ((DelegateModelResource)self).isUserEdit();
						}
						Function retFunc = 
								new DelegateFunction<>((FunctionType)type, (Function)base, this, userEdit);
						ret = retFunc;
					} else if (type instanceof CountType) {
						boolean userEdit = true;
						if (self instanceof DelegateFunction) {
							userEdit = ((DelegateFunction) self).isUserEdit();
						}
						if (self instanceof DelegateModelResource) {
							userEdit = ((DelegateModelResource)self).isUserEdit();
						}
						Counter retCount = new DelegateCounter((CountType)type, (Counter)base, userEdit);
						ret = retCount;
					} else {
						System.err.println("Don't know how to create "+type);
					}
				}
				if (ret instanceof GeneralElement) {
					GeneralElement ge = (GeneralElement)ret;
					ParentLocation pl = new ParentLocationImpl(mr,key,ge);
					ge.setParentLoc(pl);
				}
				return ret;
			}
			return mr.getElement((Symbol)key);
		} else {
			System.err.println("Can't handle things which are neither a function nor a model resource");
		}
		return null;
	}
	
	public default Counter generate(Function self, Object key, Counter valueBase) {
		return valueBase;
	}
	
	public default IterablePosition generate(Function self, Object key, IterablePosition valueBase) {
		return valueBase;
	}
	
	public default TreeposIterablePosition generate(Function self, Object key, TreeposIterablePosition valueBase) {
		return valueBase;
	}
	

	
	public default Object generate(Function self, Object key, Object valueBase) {
		boolean userEdit = false;
		if (self instanceof DelegateFunction) {
			userEdit = ((DelegateFunction)self).isUserEdit();
		}
		if (valueBase instanceof Function) {
			return new DelegateFunction<>(self.getType(), (Function)valueBase, this, userEdit); //??
		}
		if (valueBase instanceof Counter) {
			return generate(self,key,(Counter)valueBase);
		}
		if (valueBase instanceof TreeposIterablePosition) {
			return generate(self,key,(TreeposIterablePosition)valueBase);
		} else if (valueBase instanceof IterablePosition) {
			return generate(self,key,(IterablePosition)valueBase);
		} 
		System.err.println("Unknown thing to handle: "+valueBase);
		return valueBase;
	}

	
}

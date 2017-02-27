package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.UnionGenerator;
import at.ac.tuwien.big.vmod.type.CountType;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.Symbol;

public class GenericUnionGenerator implements UnionGenerator {

	@Override
	public Object generate(Object self, Object key) {
		if (self instanceof Function) {
			return UnionGenerator.super.generate((Function)self, key);
		} else if (self instanceof ModelResource) {
			//It's rather similar ...
			ModelResource mr = (ModelResource)self;
			if (mr instanceof DeltaBuilt) {
				DeltaBuilt db = (DeltaBuilt)mr;
				ModelResource baseRes = (ModelResource)db.getBase();
				ModelResource editRes = (ModelResource)db.getEdit();
				Object base = baseRes.getElement((Symbol)key);
				Object edit = editRes.getElement((Symbol)key);
				GeneralType type = null;
				if (base instanceof GeneralElement) {
					type = ((GeneralElement) base).getType();
				}
				if (edit instanceof GeneralElement && type == null) {
					type = ((GeneralElement)edit).getType();
				}
				Object ret = null;
				if (type == null) {
					
					System.err.println("Don't know how to transform "+base+" and "+edit);
					return edit;
				} else {
					//Das result soll auch vom Typ sein
					if (type instanceof FunctionType) {
						boolean userEdit = true;
						if (self instanceof UnionFunction) {
							userEdit = ((UnionFunction)self).isUserEdit();
						}
						if (self instanceof UnionModelResource) {
							userEdit = ((UnionModelResource)self).isUserEdit();
						}
						Function retFunc = 
								new UnionFunction<>((FunctionType)type, (Function)base, (Function)edit, this, userEdit);
						ret = retFunc;
					} else if (type instanceof CountType) {
						boolean userEdit = true;
						if (self instanceof UnionFunction) {
							userEdit = ((UnionFunction) self).isUserEdit();
						}
						if (self instanceof UnionModelResource) {
							userEdit = ((UnionModelResource)self).isUserEdit();
						}
						Counter retCount = new UnionCounter((CountType)type, (Counter)base, (Counter)edit, userEdit);
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
	

	@Override
	public Object generate(Function self, Object key, Object valueBase, Object valueEdit) {
		FunctionType type = self.getType();
		GeneralType rangeType = type.getType(SimpleGenerator.getMetainfo(key));
		if (rangeType == null || rangeType == GeneralType.NO_TYPE) {
			rangeType = type.getRange();
		}
		//Generate something of that type
		Object ret = null;
		if (rangeType instanceof FunctionType) {
			boolean userEdit = true;
			if (self instanceof UnionFunction) {
				userEdit = ((UnionFunction)self).isUserEdit();
			} else {
				System.err.println("Wrong type: "+self);
			}
			Function retFunc = 
					new UnionFunction<>((FunctionType)rangeType, (Function)valueBase, (Function)valueEdit, this, userEdit);
			ret = retFunc;
		} else if (rangeType instanceof CountType) {
			boolean userEdit = true;
			if (self instanceof UnionFunction) {
				userEdit = ((UnionFunction) self).isUserEdit();
			}  else {
				System.err.println("Wrong type: "+self);
			}
			Counter retCount = new UnionCounter((CountType)rangeType, (Counter)valueBase, (Counter)valueEdit, userEdit);
			ret = retCount;
		} else {
			System.err.println("Don't know how to create "+rangeType);
		}
		if (ret instanceof GeneralElement) {
			GeneralElement ge = (GeneralElement)ret;
			ParentLocation pl = new ParentLocationImpl(self,key,ge);
			ge.setParentLoc(pl);
		}
		return ret;
	}

}

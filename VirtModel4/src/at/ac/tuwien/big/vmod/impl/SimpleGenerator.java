package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.type.CountType;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.ValueType;

public class SimpleGenerator<T,U> implements Generator<GeneralElement,T,U>{
	
	
	public Object generateOfType(GeneralType rangeType) {
		Object ret = null;
		if (rangeType instanceof FunctionType) {
			Function retFunc = new SimpleFunction<>((FunctionType)rangeType, this);
			ret = retFunc;
		} else if (rangeType instanceof CountType) {
			Counter retCount = new SimpleCounter((CountType)rangeType);
			ret = retCount;
		} else {
			System.err.println("Don't know how to create "+rangeType);
		}
		return ret;
	}
	
	public static String getMetainfo(Object key) {
		if (key instanceof Symbol) {
			return ((Symbol) key).getName();
		}
		return String.valueOf(key);
	}

	@Override
	public U generate(GeneralElement self, T key) {
		U ret = null;
		if (self instanceof Function) {
			Function selfF = (Function)self;
			FunctionType type = selfF.getType();
			GeneralType rangeType = type.getType(getMetainfo(key));
			if (rangeType == null || rangeType == GeneralType.NO_TYPE) {
				rangeType = type.getRange();
			}			
			//Generate something of that type
			ret = (U)generateOfType(rangeType);
			
		} else if (self instanceof ModelResource) {
			ModelResource mr = (ModelResource)self;
			ModelResourceType type = (ModelResourceType)mr.getType();
			String keyV = String.valueOf(key);
			if (key instanceof Symbol) {
				keyV = ((Symbol)key).getName();
			}
			GeneralType rangeType = type.getType(keyV);
			ret = (U)generateOfType(rangeType);
		}
		if (ret == null) {
			System.err.println("Don't know how to create "+key+" for "+self);
		} 
		if (ret instanceof GeneralElement) {
			GeneralElement ge = (GeneralElement)ret;
			ParentLocation pl = new ParentLocationImpl(self,key,ge);
			ge.setParentLoc(pl);
		}
		return ret;
	}

}

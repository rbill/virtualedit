package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.FunctionMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.Intersectable;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.type.CountType;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;

public class ParametizedGenerator<T,U, V extends Iterable<W>, W> implements Generator<GeneralElement, T, U> {
	
	public ParametizedGenerator() {
		
	}
	
	//TODO: Projection vielleicht nicht verwenden?!
	public ParametizedGenerator(V projection, Projector<V, W> projector) {
		this.projection = projection;
	}
	
	private V projection;
	private Projector<V,W> projector;
	
	public void intersectWith(V other) {
		if (projection == null) {
			projection = other;
		} else {
			projection = projector.project(projection, other);
		}
	}
	

	public ParametizedGenerator<T,U,V,W> clone() {
		return new ParametizedGenerator<>(projection,projector);
	}
	
	
	public Object generateOfType(GeneralType rangeType, Projector<V, W> projector, V curParam, FunctionMap<W, ?> curFuncMap) {
		Object ret = null;
		if (projection != null) {
			curParam = projector.project(projection,curParam);
		}
		if (rangeType instanceof FunctionType) {
			
			Function retFunc = new ParametizedFunction<>((FunctionType)rangeType, curParam, projector,(FunctionMap<W, ? extends Function<T,U>>)curFuncMap, this);
			ret = retFunc;
		} else if (rangeType instanceof CountType) {
			Counter retCount = new ParametizedCounter<V,W>((CountType)rangeType,curParam,projector,(FunctionMap<W,? extends Counter>)curFuncMap);
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
		if (self instanceof ParametizedFunction) {
			ParametizedFunction selfF = (ParametizedFunction)self;
			FunctionType type = selfF.getType();
			GeneralType rangeType = type.getType(getMetainfo(key));
			if (rangeType == null || rangeType == GeneralType.NO_TYPE) {
				rangeType = type.getRange();
			}
			
			//Generate something of that type
			ret = (U)generateOfType(rangeType, selfF.getProjector(), (V)selfF.getParam(), selfF.getSubFunc(key));
			
		} else if (self instanceof ParametizedModelResource) {
			ParametizedModelResource mr = (ParametizedModelResource)self;
			ModelResourceType type = (ModelResourceType)mr.getType();
			String keyV = String.valueOf(key);
			if (key instanceof Symbol) {
				keyV = ((Symbol)key).getName();
			}
			GeneralType rangeType = type.getType(keyV);
			
			ret = (U)generateOfType(rangeType, mr.getProjector(), (V)mr.getParam(), mr.getSubFunc((Symbol)key));
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

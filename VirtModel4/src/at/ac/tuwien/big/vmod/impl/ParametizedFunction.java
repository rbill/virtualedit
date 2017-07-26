package at.ac.tuwien.big.vmod.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import at.ac.tuwien.big.generalutil.Pair;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.FunctionMap;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.IterableType;

public class ParametizedFunction<T,U,V extends Iterable<W>,W> extends ParametizedElement<ParametizedFunction<T,U,V,W>,
V, W, FunctionType> implements Function<T, U> {
	
	private ParametizedGenerator<T, U,V,W> generator;

	public ParametizedFunction(FunctionType type, V curParam, Projector<V, W> projector,
			FunctionMap<W, ? extends GeneralElement> subFunc,
			ParametizedGenerator<T, U,V,W> generator) {
		super(type, curParam, projector, subFunc);
		this.generator = generator;
	}

	@Override
	public ParametizedFunction<T, U, V, W> clone() {
		return new ParametizedFunction<T, U, V, W>(type, getParam(), getProjector(), getSubFunc(), generator);
	}
	
	@Override
	public FunctionType getType() {
		return super.getType();
	}

	@Override
	public U getValue(T key) {
		//Merge things
		//Was passiert, wenn es nichts mehr gibt?
		//Der generator muss aus den Sub-Werten was basteln ...
		
		//Das sub braucht das auf jeden Fall, aber wie generiere ich das Sub sonst?
		return generator.generate(this, key);
	}

	@Override
	public U getValueOrNull(T o) {
		//Check if all sub are null
		boolean isNull = true;
		for (Function<T, U> sf: this.<Function<T,U>>getSubValues()) {
			U val = sf.getValue(o);
			if (val != null) {
				isNull = false;
			}
		}
		if (!isNull) {
			return getValue(o);
		} else {
			return null;
		}
	}

	@Override
	public IterablePosition<T> getIterableOrNull() {
		boolean isNull = true;
		List<Pair<W,Object>> startingPositions = new ArrayList<>();
		getSubValues();
		for (Entry<W,Function<T, U>> entry: this.<Function<T,U>>getSubEntries()) {
			Function<T,U> sf = entry.getValue();
			Object val = sf.getIterableOrNull();
			if (val != null) {
				isNull = false;
				startingPositions.add(new Pair<>(entry.getKey(),val));
			}
		}
		if (isNull) {
			return null;
		}

		IterableType type = getType().getIterableTypeOrNull();
		if (type == null) {
			return null;
		}
		if (type.isTreeposIterator())  {
			IterablePosition<T> ret = (IterablePosition) new ParametizedTreeposIterablePosition(this, type, (List)startingPositions);
			//ret.setParentLoc(new ParentLocationImpl(this, type, ret));
			return ret;
		} else {
			IterablePosition<T> ret = new ParametizedIterablePosition<T, W>(this, type, (List)startingPositions);
			return ret;
		}
	}

	public FunctionMap<W, ?> getSubFunc(T key) {
		FunctionMap<W,?> newSubFunc = new FunctionMap<W,Object>() {

			@Override
			public Object getValue(W skey) {
				//Da muss der jeweils echte Funktions-Unterwert geliefert werden
				return ((Function<T,U>)getSubFunc().getValue(skey)).getValue(key);
			}
			
		};
		return newSubFunc;
	}

}

package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.util.MyHashMapImpl;
import at.ac.tuwien.big.util.MyMap;
import at.ac.tuwien.big.util.TreeposMap;
import at.ac.tuwien.big.util.TreeposMapImpl;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.generator.Generator;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.IterableType;

public class SimpleFunction<T,U> extends SimpleGeneralElement<FunctionType> implements Function<T, U> {
	
	private MyMap<T, U> map;
	private Generator<? super SimpleFunction<T,U>,? super T,? extends U> generator;
	private IterableType itType;

	public SimpleFunction(FunctionType type, Generator<? super SimpleFunction<T,U>,? super T,? extends U> generator) {
		super(type);
		IterableType itType = type.getIterableTypeOrNull();
		if (itType != null && itType.isTreeposIterator()) {
			map = (MyMap)new TreeposMapImpl<U>();
		} else {
			map = new MyHashMapImpl<>();
		}
		this.itType = itType;
		if (type.isAutocreate()) {
			this.generator = generator;
		}
	}

	@Override
	public U getValue(T key) {
		U ret = map.get(key);
		if (ret == null && generator != null) {
			ret = generator.generate(this, key);
			map.put(key, ret);
		}
		return ret;
	}
	
	@Override
	public U getValueOrNull(T key) {
		U ret = map.get(key);
		return ret;
	}

	@Override
	public IterablePosition getIterableOrNull() {
		if (itType != null) {
			if (itType.isTreeposIterator()) {
				return new StartTreeposIterablePosition(this, itType, (TreeposMap)map);
			} else {
				return new StartIterablePosition<T, IterableType>(this, itType, map);
			}
		}
		return null;
	}
	
	public String toString() {
		return String.valueOf(map);
	}

}

package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.generator.DelegateGenerator;
import at.ac.tuwien.big.vmod.generator.UnionGenerator;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.IterableType;

public class DelegateFunction<T,U,V> extends SimpleDelegateGeneralElement<FunctionType, Function<T, V>> implements Function<T,U> {
	
	private DelegateGenerator<? super DelegateFunction<T,U,V>, T, U, V> generator;

	public DelegateFunction(FunctionType type, Function<T, V> base, DelegateGenerator<? super DelegateFunction<T,U,V>, T, U, V> generator, boolean isUserEdit) {
		super(type, base, isUserEdit);
		this.generator = generator;
	}

	@Override
	public U getValue(T key) {
		return generator.generate(this, key);
	}
	

	@Override
	public U getValueOrNull(T key) {
		V baseVal = getBase().getValueOrNull(key);
		if (baseVal == null) {
			return null;
		}
		return generator.generate(this, key);
	}

	@Override
	public IterablePosition getIterableOrNull() {
		IterablePosition baseIter = getBase().getIterableOrNull();
		if (baseIter instanceof TreeposIterablePosition) {
			return new DelegateTreeposIterablePosition(this,getType().getIterableTypeOrNull(), (TreeposIterablePosition)baseIter, isUserEdit()); 
		}
		return new DelegateIterablePosition(this,getType().getIterableTypeOrNull(), baseIter, isUserEdit());
	}

}

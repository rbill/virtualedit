package at.ac.tuwien.big.vmod.impl;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.TreeposIterablePosition;
import at.ac.tuwien.big.vmod.generator.UnionGenerator;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.SymbolRegistry;
import at.ac.tuwien.big.vmod.type.FunctionType;
import at.ac.tuwien.big.vmod.type.IterableType;
import at.ac.tuwien.big.vmod.type.Symbol;

public class UnionFunction<T,U,V,W> extends SimpleUnionGeneralElement<FunctionType, Function<T, V>, Function<T,W>> implements Function<T,U> {
	
	private UnionGenerator<? super UnionFunction<T,U,V,W>, T, U, V, W> generator;

	public UnionFunction(FunctionType type, Function<T, V> base, Function<T, W> edit, UnionGenerator<? super UnionFunction<T,U,V,W>, T, U, V, W> generator, boolean isUserEdit) {
		super(type, base, edit, isUserEdit);
		this.generator = generator;
	}

	@Override
	public U getValue(T key) {
		return generator.generate(this, key);
	}
	
	

	@Override
	public U getValueOrNull(T key) {
		V baseVal = getBase().getValueOrNull(key);
		W editVal = getEdit().getValueOrNull(key);
		if (baseVal == null && editVal == null) {
			return null;
		}
		return generator.generate(this, key);
	}

	@Override
	public IterablePosition getIterableOrNull() {
		IterablePosition baseIter = getBase().getIterableOrNull();
		IterablePosition editIter = getEdit().getIterableOrNull();
		if (baseIter == null) {
			return editIter;
		}
		if (editIter == null) {
			return baseIter;
		}
		if (baseIter instanceof TreeposIterablePosition && editIter instanceof TreeposIterablePosition) {
			TreeposIterablePosition baseIterT = (TreeposIterablePosition)baseIter;
			TreeposIterablePosition editIterT = (TreeposIterablePosition)editIter;
			return new UnionTreeposIterablePosition(this,(IterableType)getType().getIterableTypeOrNull(), null,
					baseIterT, null, null, editIterT, null, isUserEdit());
		}
		return new UnionIterablePosition(getType().getIterableTypeOrNull(), baseIter, editIter, isUserEdit());
	}

}

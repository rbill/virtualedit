package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.generalutil.Pair;

public abstract class ParameterHandlerObject<This extends ParameterHandlerObject<This,Target,FuncSource>, Target, FuncSource> implements BiFunction<FuncSource, List<Supplier<?>>, Target> {

	private final BiFunction<? super This,Pair<FuncSource,List<Supplier<?>>>,? extends Target> func;
	
	public ParameterHandlerObject(BiFunction<? super This,Pair<FuncSource,List<Supplier<?>>>,? extends Target> func) {
		this.func = func;
	}
	
	public Object getParameter(List<Supplier<?>> supplierList, int index) {
		if (supplierList.size() <= index) {
			return null;
		}
		return supplierList.get(index).get();
	}
	
	public Target evaluate(FuncSource src, List<Supplier<?>> supplierList) {
		return func.apply((This)this, new Pair<>(src,supplierList));
	}
	
	public Target apply(FuncSource src, List<Supplier<?>> suppliers) {
		return evaluate(src, suppliers);
	}
	
	
}

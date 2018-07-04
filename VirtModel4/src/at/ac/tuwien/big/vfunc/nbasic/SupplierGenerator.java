package at.ac.tuwien.big.vfunc.nbasic;

import java.util.function.Function;

public interface SupplierGenerator extends Function<Object,Object> {

	public Function<Object,Object> getSupplier(Object obj);
	
	public default Object getSuppliedOrNull(Object obj) {
		Function<Object,Object> func = getSupplier(obj);
		if (func != null) {
			return func.apply(obj);
		}
		return null;
	}
	
	public default Object apply(Object from) {
		return getSuppliedOrNull(from);
	}
}

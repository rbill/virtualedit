package at.ac.tuwien.big.vfunc.nbasic;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.function.Function;

public class BasicReplacer implements Replacer {
	
	private Replacer parent;
	private IdentityHashMap<Object, Object> map = new IdentityHashMap<Object, Object>();
	public SupplierGenerator supplierGenerator;
	
	private BasicReplacer(BasicReplacer parent) {
		this.parent = parent;
		this.supplierGenerator = parent.supplierGenerator;
	}
	
	private BasicReplacer(SupplierGenerator generator) {
		this.supplierGenerator = generator;
	}

	public static BasicReplacer get(SupplierGenerator from) {
		return new BasicReplacer(from);
	}
	
	public void addParameters(List<? extends FunctionParameterValue<?>> fpvs, List<? extends BasicValuedChangeNotifyer<?>> values) {
		if (fpvs.size() != values.size()) {
			throw new RuntimeException("Incorrect parameter number: " +fpvs.size()+" VS "+values.size());
		}
		for (int i = 0; i < fpvs.size(); ++i) {
			map.put(fpvs.get(i), values.get(i));
		}
	}
	
	public void add(Object from, Object to) {
		map.put(from, to);
	}
	
	@Override
	public Replacer push() {
		return new BasicReplacer(this);
	}

	@Override
	public Object get(Object from) {
		Object ret = map.get(from);
		if (ret == null && parent != null) {
			ret = parent.get(from);
		}
		if (ret == null) {
			ret = supplierGenerator.getSuppliedOrNull(from);
			if (ret != null) {
				map.put(from, ret);
			}
		}
		return ret;
	}

	@Override
	public<T> Object get(T from, Function<? super T, ?> supplier) {
		Object ret = get(from);
		if (ret == null) {
			map.put(from, ret = supplier.apply(from));
		}
		return ret;
	}

}

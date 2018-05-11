package at.ac.tuwien.big.vfunc.basic;

import at.ac.tuwien.big.vfunc.basic.impl.BasicEE;

public interface AnyParameterModifier extends FourParameterModifier {

	public Object get(int nmb);
	
	public void set(int nmb, Object obj);
	
	public boolean has(int nmb);
	
	public boolean maySet(int nmb);
	
	@Override
	public default Object getParam3() {
		return get(3);
	}

	@Override
	public default Object getParam2() {
		return get(2);
	}

	@Override
	public default Object getParam1() {
		return get(1);
	}

	@Override
	public default Object getSource() {
		return get(0);
	}

	@Override
	public default void setParam2(Object param2) {
		set(2,param2);
	}

	@Override
	public default void setParam1(Object param) {
		set(1,param);
	}

	@Override
	public default void setSource(Object source) {
		set(0,source);
	}

	@Override
	public default void setParam3(Object param2) {
		set(3,param2);
	}
}

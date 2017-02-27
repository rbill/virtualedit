package at.ac.tuwien.big.vmodel.general;

public interface AbstractParameterInvertibleFunc<X, Y, Z> extends ParameterInvertibleFunc<X, Y, Z, VFunc<Y, Z>, VFunc<X, Z>> {

	public DoubleParameterVFunc<X, Y, Z> baseFunc();
	
	@Override
	public default VFunc<Y, Z> get(X val) {
		return baseFunc().onParameter1Func().get(val);
	}


	@Override
	public default boolean isSelfEmpty() {
		return baseFunc().isSelfEmpty();
	}

	@Override
	public default boolean selfClear() {
		return baseFunc().selfClear();
	}
	
	public default ParameterInvertibleFunc<Y,X,Z,VFunc<X,Z>,VFunc<Y,Z>> parameterInvert() {
		return new ParameterInvertibleFunc<Y,X,Z,VFunc<X,Z>,VFunc<Y,Z>>() {

			@Override
			public  boolean isSelfEmpty() {
				return baseFunc().isSelfEmpty();
			}

			@Override
			public boolean selfClear() {
				return baseFunc().selfClear();
			}
			
			@Override
			public VFunc<X, Z> get(Y y) {
				return baseFunc().onParameter2Func().get(y);
			}


			@Override
			public ParameterInvertibleFunc<X, Y, Z, VFunc<Y,Z>, VFunc<X,Z>> parameterInvert() {
				return AbstractParameterInvertibleFunc.this;
			}
		};
	}

}

package at.ac.tuwien.big.vmodel.general;

public interface SimpleAbstractParameterInvertibleFuncBase<X, Y, Z extends StaticElement, K extends OwnedFunc<Y,Z>,
	L extends OwnedFunc<X,Z>> extends AbstractParameterInvertibleFuncBase<X, Y, Z, K, L> {


	@Override
	public default VFunc<Y, Z> get(X x) {
		OwnedFunc<Y, Z> base = base1Func().get(x);
		return new VFunc<Y, Z>() {

			@Override
			public boolean isSelfEmpty() {
				return base.isSelfEmpty();
			}

			@Override
			public boolean selfClear() {
				return base.selfClear();
			}

			@Override
			public Z get(Y y) {
			
			}
		};
	}

	
	
}

package at.ac.tuwien.big.vmodel.general;

public interface AbstractDelegatingVAssoc<X,Y,E extends IntegerValueElement,F extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,E>>> extends VAssoc<X,Y,E>, AbstractParameterInvertibleFuncBase<X,Y,E,F>
{
	

}

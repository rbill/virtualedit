package at.ac.tuwien.big.vmodel.general;

public interface AbstractDelegatingVBag<X, E extends EditableIntegerValueElement> extends VBag<X, E>, DelegatingFunc<VEntryIterableFunc<X,E>,X,E>  {

}

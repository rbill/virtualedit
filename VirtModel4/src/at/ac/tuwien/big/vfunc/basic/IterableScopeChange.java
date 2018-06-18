package at.ac.tuwien.big.vfunc.basic;

import java.util.Collection;
import java.util.Objects;

public interface IterableScopeChange<This,Src> extends FilteredScopeChange<This,Src> {
	
	@Override
	public default boolean wasAdded(Object src) {
		return priv_contains(getAdded(),src);
	}
	
	@Override
	public default boolean wasDeleted(Object src) {
		return priv_contains(getDeleted(),src);
	}
	
	static <Src> boolean priv_contains(Iterable<? extends Src> iterable, Src src) {
		if (iterable instanceof Collection) {
			return ((Collection)iterable).contains(src);
		} else {
			for (Src asrc: iterable) {
				if (Objects.equals(src, asrc)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public Iterable<? extends Src> getAdded();
	
	public Iterable<? extends Src> getDeleted();
	

}

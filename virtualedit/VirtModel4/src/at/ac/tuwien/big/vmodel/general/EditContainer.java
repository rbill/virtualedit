package at.ac.tuwien.big.vmodel.general;

import java.util.Collection;

public interface EditContainer<T> {
	
	public Collection<Edit<? super T>> getPendingEdits();

	public Collection<Edit<? super T>> getScheduledEdits();
	
	public Collection<Edit<? super T>> getEditLog();
}


package at.ac.tuwien.big.vmodel.general;

import java.util.Collection;
import java.util.List;

public interface EditPropagationList {
	
	public List<EditWish<?,?>> getAllEdits();
	
	public Collection<List<EditWish<?,?>>> getPossiblePropagations();

}

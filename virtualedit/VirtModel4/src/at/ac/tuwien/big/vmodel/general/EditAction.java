package at.ac.tuwien.big.vmodel.general;

public interface EditAction<F, R extends Edit<? super F>> {
	
	public void propagate(F editable, R edit);
	
	public void precommit(F editable, R edit);
	
	public void commit(F editable, R edit);
	

}

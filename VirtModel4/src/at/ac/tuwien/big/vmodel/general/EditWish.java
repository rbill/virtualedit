package at.ac.tuwien.big.vmodel.general;

public interface EditWish<T, U> {
	
	public Edit<T> spawnDirectEdit(T target);
	
	public Class<T> targetEditableClass();
	
	public Class<U> targetApplicationClass();
	
	public boolean mayDirectlyApply(U target);
	
	public EditPropagationList calcPropagation(U target);
	
	

	public boolean mayMerge(Edit<?> predecessor);
	
	/**Merges the edit s.t. the first return is the new predecessor, the second the new this
	 * EditPerformers must be updated accordingly
	 * */
	public EditWish<? super T, ?>[] merge(Edit<?> predecessor);
	

	public boolean localEquals(EditWish<?,?> anotherEdit);	

	/**Edits conflict if the operation order modifies the result*/
	public boolean conflictsWith(EditWish<?,?> otherEdit);
	
	/**Returns true when this edit does not do anything*/
	public boolean isNull(U target);
}

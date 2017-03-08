package at.ac.tuwien.big.vmodel.general;

public interface OwnedFunc<T, U> extends VFunc<T, U> {
	
	/**May only be called by owning function*/
	public void set(T t, U u);
	
	public U getOrNull(T t);
	
	public static interface OnCreatedListener<T,U> {
		public U onCreated(OwnedFunc<T,U> func, T t, U u);
	}
	
	//public void setOnCreatedListener(OnCreatedListener<T,U> listener);


}

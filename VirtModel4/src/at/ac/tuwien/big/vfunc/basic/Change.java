package at.ac.tuwien.big.vfunc.basic;

public interface Change<This,Source,Target> {
	
	public This getThis();
	
	public Source source();
	
	public Target oldValue();
	
	public Target newValue();

}

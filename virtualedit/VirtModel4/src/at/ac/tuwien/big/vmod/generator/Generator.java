package at.ac.tuwien.big.vmod.generator;

public interface Generator<This,T,U> {
	
	public U generate(This self, T key);

}

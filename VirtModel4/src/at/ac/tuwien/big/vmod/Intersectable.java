package at.ac.tuwien.big.vmod;

public interface Intersectable<This extends Intersectable<This,W>, W> extends Iterable<W> {
	
	public This intersect(This other);

}

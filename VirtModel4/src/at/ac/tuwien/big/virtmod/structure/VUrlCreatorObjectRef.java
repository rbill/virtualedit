package at.ac.tuwien.big.virtmod.structure;

public interface VUrlCreatorObjectRef extends VObjectRef {
	
	public void createUrl(StringBuilder url) throws CannotCreateUrlException;
	
	public default String getUri() throws CannotCreateUrlException {
		StringBuilder ret = new StringBuilder();
		createUrl(ret);
		return ret.toString();
	}

}

package at.ac.tuwien.big.virtmod.structure;

public class CannotResolveUriException extends Exception {
	private String uri;
	
	
	public CannotResolveUriException(String uri) {
		super("Cannot resolve uri " + uri);
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}

}

package at.ac.tuwien.big.verocl.parameterdesc;

public class PseudoModelRefImpl implements PseudoModelRef {

	private String uri;
	private Object[] values;
	
	public PseudoModelRefImpl(String uri, Object... values) {
		this.uri = uri;
		this.values = values;
	}
	
	@Override
	public String getURI() {
		return uri;
	}

	@Override
	public Object[] getValues() {
		return values;
	}

}

package interparse.interparse;

import java.io.Serializable;

public class PageParseConfiguration implements Serializable {
	
	private Tokenizer tokenizer;
	
	public PageParseConfiguration(Tokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}
	
	public Tokenizer getTokenizer() {
		return tokenizer;
	}

}

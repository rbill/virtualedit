package interparse.interparse;

import java.io.Serializable;
import java.util.List;

public interface Tokenizer extends Serializable {
	
	public List<String> getTokens(String completeString);

}

package interparse.interparse;

import java.io.Serializable;

public interface IStemmer extends Serializable {

	public String stemWord(String fromString);
}

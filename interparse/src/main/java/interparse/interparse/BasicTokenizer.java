package interparse.interparse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicTokenizer implements Tokenizer {

	@Override
	public List<String> getTokens(String fullString) {
		List<StringBuilder> ret = new ArrayList<>();
		StringBuilder cur = new StringBuilder();
		ret.add(cur);
		for (int i = 0; i < fullString.length(); ++i) {
			char c = fullString.charAt(i);
			if (Character.isAlphabetic(c) || Character.isDigit(c)) {
				cur.append(c);
			} else {
				if (cur.length() > 0) {
					cur = new StringBuilder();
					ret.add(cur);
				}
			}
		}
		ret.removeIf(x->x.length() == 0);
		List<String> rret  = ret.stream().map(x->x.toString()).collect(Collectors.toList());
		return rret;
	}
}

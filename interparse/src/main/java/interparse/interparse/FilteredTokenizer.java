package interparse.interparse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class FilteredTokenizer implements Tokenizer {
	
	private Function<String, List<String>> filter;
	private Tokenizer basicTokenizer;
	
	public FilteredTokenizer(Tokenizer basic, Function<String, List<String>> filter) {
		this.basicTokenizer = basic;
		this.filter = filter;
	}

	@Override
	public List<String> getTokens(String completeString) {
		List<String> ret = new ArrayList<String>();
		List<String> pre = basicTokenizer.getTokens(completeString);
		for (String str: pre) {
			ret.addAll(filter.apply(str));
		}
		return ret;
	}
	
	public static FilteredTokenizer GERMAN_STEM(Tokenizer tk) {
		return STEM(tk, new Cistem()); 
	}
	
	public static class StemFunction implements Function<String, List<String>>, Serializable {

		private IStemmer stemmer;
		
		public StemFunction(IStemmer stemmer) {
			this.stemmer = stemmer;
		}
		
		@Override
		public List<String> apply(String t) {
			String stemmed = stemmer.stemWord(t);
			if (stemmed != null && !"".equals(stemmed)) {
				return Collections.singletonList(stemmed);
			}
			return Collections.emptyList();
		}
		
	}
	
	public static FilteredTokenizer STEM(Tokenizer tk, IStemmer stemmer) {
		return new FilteredTokenizer(tk,new StemFunction(stemmer));
	}
	
	
}

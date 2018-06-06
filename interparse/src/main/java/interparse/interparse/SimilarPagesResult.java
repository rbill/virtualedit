package interparse.interparse;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

public class SimilarPagesResult {
	
	public Map<Page.SimilarityType, SingleAlgorithmResult> algorithmResults = new HashMap<Page.SimilarityType, SingleAlgorithmResult>();
	public Page page;
	
	
	public SimilarPagesResult(Page page, Map<Page.SimilarityType, SingleAlgorithmResult> algorithmResults) {
		this.page = page;
		this.algorithmResults = algorithmResults;
	}
	
	public JsonObject toJsonObject() {
		JsonObject job = new JsonObject();
		String url = page.getUrl();
		job.addProperty("url", url);
		JsonObject sjob = new JsonObject();
		algorithmResults.forEach((st,sar)->{
			sjob.add(st.name(), sar.toJsonObject());
		});
		job.add("similarities", sjob);
		JsonObject links = new JsonObject();
		Map<Page, Integer> theLinks = page.getLinks();
		theLinks.forEach((k,v)->{
			links.addProperty(k.getUrl(), v);
		});
		job.add("links", links);
		return job;
	}

}

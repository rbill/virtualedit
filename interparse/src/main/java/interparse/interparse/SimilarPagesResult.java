package interparse.interparse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class SimilarPagesResult {
	
	public Map<Page.SimilarityType, SingleAlgorithmResult> algorithmResults = new HashMap<Page.SimilarityType, SingleAlgorithmResult>();
	public Page page;
	
	
	public SimilarPagesResult(Page page, Map<Page.SimilarityType, SingleAlgorithmResult> algorithmResults) {
		this.page = page;
		this.algorithmResults = algorithmResults;
	}
	
	public JsonObject toJsonObject() {
		JsonObjectBuilder job = Json.createObjectBuilder();
		String url = page.getUrl();
		job.add("url", url);
		JsonObjectBuilder sjob = Json.createObjectBuilder();
		algorithmResults.forEach((st,sar)->{
			sjob.add(st.name(), sar.toJsonObject());
		});
		job.add("similarities", sjob.build());
		JsonObjectBuilder links = Json.createObjectBuilder();
		Map<Page, Integer> theLinks = page.getLinks();
		theLinks.forEach((k,v)->{
			links.add(k.getUrl(), v);
		});
		job.add("links", links.build());
		return job.build();
	}

}

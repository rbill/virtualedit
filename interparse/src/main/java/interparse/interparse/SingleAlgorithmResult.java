package interparse.interparse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

public class SingleAlgorithmResult {
	
	private Map<String, SingleLinkResult> similarities = new HashMap<>();
	private List<SingleLinkResult> highestSimilarities = new ArrayList<>();
	
	private double recall;
	private int linkCount;
	
	public SingleAlgorithmResult(Map<String, SingleLinkResult> similarities) {
		this.similarities = similarities;
		//Calculate recall
		linkCount = 0;
		for (SingleLinkResult slr: similarities.values()) {
			if (slr.hasRealLink) {
				++linkCount;
			}
		}
		highestSimilarities = new ArrayList<>(similarities.values());
		highestSimilarities.sort((x,y)->-Double.compare(x.similarity, y.similarity));
		int foundLinks = 0;
		for (int i = 0; i < linkCount; ++i) {
			if (highestSimilarities.get(i).hasRealLink) {
				++foundLinks;
			}
		}
		recall = ((double)foundLinks)/Math.max(1.0, linkCount);
	}
	
	public double getRecall() {
		return recall;
	}
	
	public int getLinkCount() {
		return linkCount;
	}
	
	public JsonValue toJsonObject() {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("recall", recall);
		JsonObjectBuilder sjob = Json.createObjectBuilder();
		similarities.forEach((k,v)->{
			sjob.add(k, v.toJsonObject());
		});
		job.add("similarities", sjob);
		return job.build();
	}

}

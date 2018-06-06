package interparse.interparse;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class SingleAlgorithmResult {
	
	private Map<String, SingleLinkResult> similarities = new HashMap<>();
	private List<SingleLinkResult> highestSimilarities = new ArrayList<>();
	
	private List<SingleLinkResult> worstLinks = new ArrayList<>();
	
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
		worstLinks = new ArrayList<>();
		highestSimilarities.sort((x,y)->-Double.compare(x.similarity, y.similarity));
		int foundLinks = 0;
		for (int i = 0; i < linkCount; ++i) {
			if (highestSimilarities.get(i).hasRealLink) {
				++foundLinks;
			}
		}
		for (int i = highestSimilarities.size()-1; i >= 0; --i) {
			if (highestSimilarities.get(i).hasRealLink) {
				worstLinks.add(highestSimilarities.get(i));
				if (worstLinks.size() == linkCount) {
					break;
				}
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
	
	public JsonElement toJsonObject() {
		JsonObject job = new JsonObject();
		job.addProperty("recall", recall);
		JsonArray sjob = new JsonArray();
		for (int i = 0; i < linkCount; ++i) {
			sjob.add(highestSimilarities.get(i).toJsonObject());
		}
		/*similarities.forEach((k,v)->{
			sjob.add(k, v.toJsonObject());
		});*/
		job.add("bestsimilarities", sjob);
		
		JsonArray wjob = new JsonArray();
		for (SingleLinkResult slr: worstLinks) {
			wjob.add(slr.toJsonObject());
		}
		job.add("worstlinks", wjob);
		return job;
	}

}

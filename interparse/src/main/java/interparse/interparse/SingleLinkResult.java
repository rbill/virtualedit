package interparse.interparse;

import javax.json.Json;
import javax.json.JsonObject;

public class SingleLinkResult {
	public final String url;
	public final double similarity;
	public final boolean hasRealLink;
	
	public SingleLinkResult(String url, double similarity, boolean hasRealLink) {
		this.url = url;
		this.similarity = similarity;
		this.hasRealLink = hasRealLink;
	}
	
	public JsonObject toJsonObject() {
		JsonObject ret = Json.createObjectBuilder().add("url", url).add("similarity", similarity).add("realLink", hasRealLink).build();
		return ret;
	}

}

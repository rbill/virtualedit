package interparse.interparse;


import com.google.gson.JsonObject;

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
		JsonObject ret = new JsonObject();
		ret.addProperty("url", url);
		ret.addProperty("similarity", similarity);
		ret.addProperty("realLink", hasRealLink);
		return ret;
	}

}

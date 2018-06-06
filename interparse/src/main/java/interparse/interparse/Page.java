package interparse.interparse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uk.ac.york.cs.ecss.learn.learnable.manager.ClassificationMap;
import uk.ac.york.cs.ecss.learn.learnable.manager.IOPair;
import uk.ac.york.cs.ecss.learn.learnable.manager.ValueDescManager;
import uk.ac.york.cs.ecss.learn.learnformat.MyInputDesc;

public class Page implements Serializable {
	
	private String url;
	//Leider nicht serializable
	private Map<Page, Integer> numberLinks = new HashMap<>();
		
	private String completeContent;
	private List<String> allLinks = new ArrayList<String>();
	
	private List<String> token = new ArrayList<>();
	private Map<String, Integer> tokenCount = new HashMap<String, Integer>();

	private Map<String, Double> tokenTFIDF = new HashMap<String, Double>();
	private Map<String, Integer> twoGramCount = new HashMap<>();
	private Map<String, Double> twoGramTFIDF = new HashMap<String, Double>();
	
	private Map<String, Integer> threeGramCount = new HashMap<>();
	private Map<String, Double> threeGramTFIDF = new HashMap<String, Double>();
	

	private Map<String, Double> tokenCountNrml = new HashMap<>();
	private Map<String, Double> twoGramCountNrml = new HashMap<>();
	private Map<String, Double> threeGramCountNrml = new HashMap<>();
	
	public double getTokenSimilarity(Page other) {
		return getSimilarity(tokenTFIDF, other.tokenTFIDF);
	}
	
	private Map<String, Double> getMap(SimilarityType forType) {
		switch(forType) {
		case TOKENCOS:
		case TOKENML:
			return tokenTFIDF;
		case THREEGRAMCOS:
		case THREEGRAMML:
			return threeGramTFIDF;
		case TWOGRAMCOS:
		case TWOGRAMML:
			return twoGramTFIDF;
		}
		return Collections.emptyMap();
	}
	
	private static ClassificationMap outputClassifier = new ClassificationMap();
	static {
		outputClassifier.addNew("result", 2);
	}
	
	public IOPair getIOPair(PageReaderManger prm, SimilarityType type, Page other) {
		boolean hasLink = numberLinks.getOrDefault(other,0)>0;
		Map<String,Double> firstMap = getMap(type);
		Map<String,Double> secondMap = other.getMap(type);
		ValueDescManager vdm = prm.getVDM(type);
		ClassificationMap cm = vdm.getClassificationMap();
		SvmState state  = new SvmState();
		SvmState sub1 = state.push("1_");
		firstMap.forEach((k,v)->{sub1.add(k, v);});
		SvmState sub2 = state.push("2_");
		secondMap.forEach((k,v)->{sub2.add(k, v);});
		MyInputDesc input = state.getInput(vdm);
		double[] output = new double[]{hasLink?1.0:0.0, hasLink?0.0:1.0};
		IOPair iop = new IOPair(1.0, input.input, input.inputAvailability, output, new boolean[]{true,true}, cm, outputClassifier);
		return iop;
	}
	
	public enum SimilarityType {
		TOKENCOS, TWOGRAMCOS, THREEGRAMCOS, TOKENML, TWOGRAMML, THREEGRAMML;
		
		public static SimilarityType[] ML = new SimilarityType[]{TOKENML, TWOGRAMML, THREEGRAMML};
		
	}
	
	/*public void ensureVDM(SimilarityType type, PageReaderManger prm) {
		SvmState state = new SvmState();
		augmentVDM(type, state.push("1_"));
		augmentVDM(type, state.push("2_"));
		ValueDescManager vdm = prm.getVDM(type);
		state.augmentVDM(vdm);
	}*/
	
	public double getSimilarity(Page other, SimilarityType type, PageReaderManger prm) {
		switch (type) {
		case TOKENCOS:
			return getTokenSimilarity(other);
		case TWOGRAMCOS:
			return getTwoGramSimilarity(other);
		case THREEGRAMCOS:
			return getThreeGramSimilarity(other);
		case TOKENML:
		case TWOGRAMML:
		case THREEGRAMML:
			SvmState state = new SvmState();
			augmentState(type, state.push("1_"));
			other.augmentState(type, state.push("2_"));
			ValueDescManager vdm = prm.getVDM(type);
			//state.augmentVDM(vdm);
			MyInputDesc input = state.getInput(vdm);
			return prm.getWeka(type).guess(input)[0];
		default:
			System.err.println("Similarity type "+type+" NYI!");
			return 0.0;
		}
	}
	
	private static class PageSimilarity {
		private final Page page;
		private final double similarity;
		
		public PageSimilarity(Page page, double similarity) {
			this.page = page;
			this.similarity = similarity;
		}
	}
	
	private Map<SimilarityType,Double> storedRecall = new HashMap<Page.SimilarityType, Double>();
	private Map<SimilarityType, List<String>> bestPages = new HashMap<Page.SimilarityType, List<String>>();
	
	
	public List<String> getBestPages(SimilarityType type, PageReaderManger prm) {
		getRecall(type, prm);
		return bestPages.getOrDefault(type, Collections.emptyList());
	}

	private static JsonObject getJsonObject(JsonObject from, String name) {
		JsonElement ret = from.get(name);
		if (ret != null && ret.isJsonObject()) {
			return ret.getAsJsonObject();
		} else if (ret != null) {
			System.err.println("Wanted JsonObject, but got "+ret);
		}
		return new JsonObject();
	}
	
	public Double getNumber(JsonObject object, String name) {
		JsonElement ret = object.get(name);
		if (ret == null) {
			return null;
		}
		try {
			return ret.getAsDouble();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public synchronized double getRecall(SimilarityType type, PageReaderManger prm) {
		if (storedRecall == null) {
			System.err.println("Recall empty?!");
			storedRecall = new HashMap<Page.SimilarityType, Double>();
		}
		return storedRecall.computeIfAbsent(type, typ->{
			return refreshRecall(typ, prm);
		});
	}
	
	public double refreshRecall(SimilarityType type, PageReaderManger prm) {
		SimilarityType typ = type;
		JsonObject metaInfo = PageReader.instance().getMetaInfo(getUrl());
		JsonObject similarity = getJsonObject(metaInfo,"similarities");
		
		JsonObject thisSimilarity = getJsonObject(similarity,type.name());
		Double curRecall = null;
		Double curWeight = null;
		List<String> pageList = new ArrayList<>();
		{
			curRecall = getNumber(thisSimilarity,"recall");
			curWeight = getNumber(thisSimilarity,"weight");
			JsonElement bestPagesEl = thisSimilarity.get("bestpages");
			if (bestPagesEl != null && bestPagesEl.isJsonArray()) {
				JsonArray bestPagesAr = bestPagesEl.getAsJsonArray();
				for (JsonElement sub: bestPagesAr) {
					if (sub.isJsonPrimitive()) {
						try {
							String str = sub.getAsString();
							pageList.add(str);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.err.println("Required string, but got "+sub+" for best page!");
					}
				}
			}
		}
		bestPages.put(typ, pageList);
		if (curRecall == null || curWeight == null) {
			int linkCount = numberLinks.size();
			List<PageSimilarity> allSimilarities = new ArrayList<Page.PageSimilarity>();
			prm.getPages().values().parallelStream().forEach(x->{
				if (x != this) {
					PageSimilarity ps = new PageSimilarity(x, getSimilarity(x, typ, prm));
					synchronized (allSimilarities) {
						allSimilarities.add(ps);	
					}
				}
			});
			allSimilarities.sort((x,y)->-Double.compare(x.similarity, y.similarity));
			int found = 0;
			for (int i = 0; i < linkCount; ++i) {
				Page page = allSimilarities.get(i).page;
				pageList.add(page.getUrl());
				if (numberLinks.containsKey(page)) {
					++found;
				}
			}
			bestPages.put(type, pageList);
			
			JsonArray jab = new JsonArray();
			for (String spage: pageList) {
				jab.add(spage);
			}

			thisSimilarity.add("bestpages", jab);
			double recall = ((double)found)/linkCount;
			if (linkCount == 0) {
				recall = 1.0; //Well, it is undefined
			}
			curRecall = recall;
			double rcallWeight = linkCount;
			//Wtf - but Json.createValue(double) doesn't seem to work?!
			thisSimilarity.addProperty("recall", recall);
			thisSimilarity.addProperty("weight", rcallWeight);
			
			similarity.add(type.name(), thisSimilarity);
			metaInfo.add("similarities", similarity);
			
			PageReader.instance().setMetaInfo(getUrl(), metaInfo);
		} else {
			System.out.println("Have metainfo for "+type+"/"+getUrl());
		}
		
		
		
		return curRecall;
	}
	
	public void printRecalls(PageReaderManger prm) {
		for (SimilarityType type: new SimilarityType[]{SimilarityType.TOKENCOS,SimilarityType.TWOGRAMCOS,SimilarityType.THREEGRAMCOS}) {
			System.out.println("Recall for page " + url+", similarity "+type+": "+getRecall(type, prm));
		}
	}
	
	public double getSimilarity(Map<?,Double> thisMap, Map<?,Double> otherMap) {
		double thisSize = 0.0;
		double otherSize = 0.0;
		double sumSize = 0.0;
		for (Entry<?, Double> entr: thisMap.entrySet()) {
			double tv = entr.getValue();
			double ov = otherMap.getOrDefault(entr.getKey(),0.0);
			thisSize+= tv*tv;
			sumSize+= tv*ov;
		}
		for (Double v: otherMap.values()) {
			double ov = v;
			otherSize+= ov*ov;
		}
		return sumSize/Math.sqrt(thisSize*otherSize);
	}
	
	public double getTwoGramSimilarity(Page other) {
		return getSimilarity(twoGramTFIDF, other.twoGramTFIDF);
	}
	
	public double getThreeGramSimilarity(Page other) {
		return getSimilarity(threeGramTFIDF, other.threeGramTFIDF);
	}
	
	public Page(String url, Document doc, PageReaderManger prm) {
		this.url = url;
		this.prm = prm;
		Element mainContent = doc.getElementById("mw-content-text");
		setCompleteContent(getContent(mainContent));
		allLinks = GetPages.getContentLinks(doc, url);
		allLinks.removeIf(x->{
			String root = GetPages.getRoot(x);
			return root.contains(":"); 
		});
	}
	
	public void getContent(Node node, StringBuilder builder) {
		if (node instanceof Element) {
			List<Node> childNodes = ((Element)node).childNodes();
			for (Node snode: childNodes) {
				getContent(snode, builder);
			}
		} else if (node instanceof TextNode) {
			builder.append(((TextNode)node).text());
		}
	}
	
	public String getContent(Node node) {
		StringBuilder builder = new StringBuilder();
		getContent(node, builder);
		return builder.toString();
	}
	
	private PageParseConfiguration ppc() {
		return prm.ppc();
	}

	private PageReaderManger prm;
	
	public void setCompleteContent(String cc) {
		this.completeContent = cc;
		this.token = ppc().getTokenizer().getTokens(completeContent); 
		tokenCount.clear();
		token.forEach((tk)->{
			tokenCount.merge(tk,1,(v1,v2)->v1+v2);
		});
		twoGramCount = getNGrams(completeContent, 2);
		threeGramCount = getNGrams(completeContent, 3);
		//TODO: Max-Normalisierung oder normale normalisierung? - In vorlesung wurde normale normalisierung verwendet, also auch hier
		tokenCountNrml = nrml(tokenCount);
		twoGramCountNrml = nrml(twoGramCount);
		threeGramCountNrml = nrml(threeGramCount);
	}
	
	public Map<String,Integer> getNGrams(String base, int number) {
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (int i = 0; i <= base.length()-number; ++i) {
			ret.merge(base.substring(i, i+number), 1, (v1,v2)->v1+v2);
		}
		return ret;
	}
	
	public Map<String, Double> nrml(Map<String,Integer> map) {
		int sum = 0;
		for (Integer v: map.values()) {
			sum+= v;
		}
		double fsum = Math.max(1,sum);
		Map<String, Double> ret = new HashMap<String, Double>();
		map.forEach((k,v)->{
			ret.put(k, v/fsum);
		});
		return ret;
	}
	
	public static boolean EXCLUDE_SELF = true;

	public void finishCalcLinks() {
		this.numberLinks = prm.getLinkCount(allLinks);
		if (EXCLUDE_SELF) {
			numberLinks.remove(this);
		}
	}

	public Map<String, Integer> getTerms() {
		return tokenCount;
	}
	
	public Map<String, Integer> get2Grams() {
		return twoGramCount;
	}
	
	public Map<String, Integer> get3Grams() {
		return threeGramCount;
	}
	
	public static<T> void multiply(Map<T,Double> target, Map<T, Double> mult1, Map<T,Double> mult2) {
		target.clear();
		mult1.forEach((k,v)->{
			target.put(k, v*mult2.getOrDefault(k, 0.0));
		});
	}

	public void calcIDF(Map<String, Double> tokenidf, Map<String, Double> twogramidf,  Map<String, Double> threegramidf) {
		multiply(tokenTFIDF, tokenCountNrml, tokenidf);
		multiply(twoGramTFIDF, twoGramCountNrml, twogramidf);
		multiply(threeGramTFIDF, threeGramCountNrml, threegramidf);
	}

	public String getUrl() {
		return url;
	}

	public Map<Page,Integer> getLinks() {
		return this.numberLinks;
	}

	public void augmentState(Map<String, Double> tokenidf, SvmState state) {
		tokenidf.forEach((k,v)->{
			state.add(k, v);
		});
	}
	public void augmentState(SimilarityType similarityType, SvmState state) {
		switch(similarityType) {
		case THREEGRAMCOS:
		case THREEGRAMML:
			augmentState(threeGramTFIDF, state); break;
		case TOKENCOS:
		case TOKENML:
			augmentState(tokenTFIDF, state); break;
		case TWOGRAMCOS:
		case TWOGRAMML:
			augmentState(twoGramTFIDF, state); break;
		}
	}

	public double getRecallWeight() {
		return getLinks().size();
	}
}

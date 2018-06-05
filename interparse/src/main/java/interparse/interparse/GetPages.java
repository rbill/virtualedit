package interparse.interparse;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetPages {
	/*
	 * public static class ListCollecter { private List<String>
	 * collectedCategories = new Arra }
	 */

	public static Document getDocument(String url) throws IOException {
		return PageReader.instance().getHtml(url);
	}

	public static List<String> getLinks(String url) {
		try {
			return getLinks(PageReader.instance().getHtml(url), url);
		} catch (IOException e) {
			System.err.println("Could not get URL " + url + ": " + e.getMessage());
			return Collections.emptyList();
		}
	}

	public static List<String> getContentLinks(String url) {
		try {
			return getContentLinks(PageReader.instance().getHtml(url), url);
		} catch (IOException e) {
			System.err.println("Could not get URL " + url + ": " + e.getMessage());
			return Collections.emptyList();
		}
	}

	private static Function<String, Boolean> mainFilter = (url) -> {
		String root = getRoot(url);
		String[] spl = root.split(":");
		for (int i = 0; i < spl.length-1; ++i) {
			if (!"Kategorie".equals(spl[i].trim())) {
				return false;
			}
		}
		if (!url.startsWith("https://de.wikipedia.org/wiki/") && !url.startsWith("http://de.wikipedia.org/wiki/")) {
			return false;
		}
		return true;
	};

	public static List<String> getContentLinks(Document doc, String url ) {
		Element contentId = doc.getElementById("mw-content-text");
		return getLinks(contentId, url, mainFilter);
	}
	
	public static String getAbsolutePart(String url) {
		url = removeAnchorPar(url);
		//Assume the url is absolute
		int firstSlash = url.indexOf('/', url.indexOf("://")+"://".length());
		if (firstSlash == -1) {
			return url;
		} else {
			return url.substring(0, firstSlash);
		} 
	}
	

	public static String getRelativePart(String url) {
		url = removeAnchorPar(url);
		//Assume the url is absolute
		int lastSlash = url.lastIndexOf('/');
		if (lastSlash == -1) {
			return url+"/";
		} else {
			return url.substring(0, lastSlash+1);
		} 
	}

	public static List<String> getLinks(Element doc, String baseUrl) {
		return getLinks(doc,baseUrl, null);
	}
			
	
	public static List<String> getLinks(Element doc, String baseUrl, Function<String,Boolean> filter) {
		Elements elementsByTag = doc.getElementsByTag("a");
		List<String> ret = new ArrayList<String>();
		String absolutePart = getAbsolutePart(baseUrl);
		String relativePart = getRelativePart(baseUrl);
		for (Element el : elementsByTag) {
			String href = el.attr("href");
			if (href.contains("://")) {
				//Absolute
				ret.add(href);
			} else if (href.startsWith("/")) {
				//absolute
				ret.add(absolutePart+href);
			} else {
				ret.add(relativePart+href);
			}
		}
		if (filter != null) {
			ret.removeIf(x->(!filter.apply(x)));
		}
		return ret;
	}

	public static String removeAnchorPar(String url) {
		if (url.lastIndexOf('#') != -1) {
			url = url.substring(0, url.lastIndexOf('#'));
		}
		if (url.lastIndexOf('?') != -1) {
			url = url.substring(0, url.lastIndexOf('?'));
		}
		url = url.replace("http://", "https://");
		return url;
	}

	public static String getRoot(String url) {
		url = removeAnchorPar(url);
		if (url.lastIndexOf('/') != -1) {
			url = url.substring(url.lastIndexOf('/') + 1);
		}
		return url;
	}

	public static List<String>[] sortLinks(List<String> foundLinks, List<String> possibleLinks) {
		Set<String> possible = new HashSet<>();
		possibleLinks.forEach(x -> possible.add(getRoot(x)));
		List<String> retTrue = new ArrayList<String>();
		List<String> retFalse = new ArrayList<String>();
		for (String fl : foundLinks) {
			String root = getRoot(fl);
			if (possible.contains(root)) {
				retTrue.add(fl);
			} else {
				retFalse.add(fl);
			}
		}
		return new List[] { retTrue, retFalse };
	}

	public static List<String> getRestrictedLinks(List<String> foundLinks, List<String> possibleLinks,
			Function<String, Boolean> additionalFilter) {
		if (additionalFilter == null) {
			additionalFilter = (x) -> true;
		}
		List<String> ret = new ArrayList<String>();
		Set<String> possible = new HashSet<>();
		possibleLinks.forEach(x -> possible.add(getRoot(x)));
		for (String fl : foundLinks) {
			String root = getRoot(fl);
			if (possible.contains(root) && additionalFilter.apply(fl)) {
				ret.add(fl);
			}
		}
		return ret;
	}

}

package interparse.interparse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.jsoup.nodes.Document;

import interparse.interparse.Page.SimilarityType;
import uk.ac.york.cs.ecss.fileutil.FilesManager;
import uk.ac.york.cs.ecss.learn.learnable.manager.IOPair;
import uk.ac.york.cs.ecss.learn.learnable.manager.SIManager;
import uk.ac.york.cs.ecss.learn.learnable.manager.ValueDescManager;
import uk.ac.york.cs.ecss.learn.learnable.manager.ShapedValues.FileInputOutputStream;
import uk.ac.york.cs.ecss.learn.learnable.manager.weka.WekaInterface;
import uk.ac.york.cs.ecss.learn.learnformat.MyInputDesc;
import uk.ac.york.cs.ecss.ml.server.JobManager;
import uk.ac.york.cs.ecss.ml.server.JobPriority;

public class PageReaderManger implements Serializable {

	private FinishingSet categorySet = new FinishingSet(new File("cache/categories"));
	private FinishingSet pageSet = new FinishingSet(new File("cache/pages"));

	private PageParseConfiguration ppc;

	public PageReaderManger(File prmFile) {
		this.targetFile = prmFile;
		this.ppc = new PageParseConfiguration(FilteredTokenizer.GERMAN_STEM(new BasicTokenizer()));

		File precat = new File("cache/precat");
		if (precat.exists()) {
			try {
				List<String> strings = Files.readAllLines(precat.toPath());
				strings.forEach(x -> {
					String[] dec = x.split(":", 2);
					this.categoryPreSet.put(dec[1].trim(), Decision.valueOf(dec[0]));
				});
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Error reading precat: " + e.getMessage());
			}
		}

		File rootFile = new File(prmFile.getAbsolutePath() + "_folder" + File.separator + "ml");
		rootFile.mkdirs();
		for (SimilarityType type : new SimilarityType[] { SimilarityType.TOKENML, SimilarityType.TWOGRAMML,
				SimilarityType.THREEGRAMML }) {
			mlInfos.put(type, new MLInfo(new File(rootFile.getAbsolutePath() + File.separator + type.name())));
		}
	}

	public double rateML(SimilarityType type, Page first, Page second) {
		MLInfo mli = mlInfos.get(type);
		ValueDescManager vdm = mli.vdm;
		SvmState state = new SvmState();
		// first.augmentVDM(type,state.push("1_"));
		// second.augmentVDM(type,state.push("2_"));
		MyInputDesc mid = state.getInput(vdm);
		try {
			double[] output = mli.sv.guess(mid);
			return output[0];
		} catch (Exception e) {
			System.err.println("Could not guess similarity between " + first.getUrl() + " and " + second.getUrl() + ": "
					+ e.getMessage());
			return 0.0;
		}
	}

	private static class MLInfo {
		public MLInfo(File file) {
			FilesManager fmanager;
			try {
				SIManager simanager = new SIManager(file);
				fmanager = FilesManager.getManager(file);
				vdm = new ValueDescManager(simanager, fmanager.getIOStream(Collections.emptyList()));
				vdm.read();
				sv = new WekaInterface(JobManager.INSTANCE);
				sv.setIOPair(fmanager.getIOStream(Collections.singletonList("model")),
						fmanager.getIOStream(Collections.singletonList("iopair")));
				sv.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ValueDescManager vdm;
		WekaInterface sv;
	}

	private Map<SimilarityType, MLInfo> mlInfos = new HashMap<>();
	{

	}

	public PageParseConfiguration ppc() {
		return ppc;
	}

	private Map<String, Page> pagesToPageUrl = new HashMap<>();
	private Map<String, Integer> numberContainingTerm = new HashMap<String, Integer>();
	private Map<String, Integer> numberContainingTerm2gram = new HashMap<String, Integer>();
	private Map<String, Integer> numberContainingTerm3gram = new HashMap<String, Integer>();

	private Map<SimilarityType, Set<String>> commonTerms = new HashMap<>();

	public <T> void collectOccurrence(Map<T, Integer> intoMap, Map<T, Integer> fromMap) {
		fromMap.forEach((k, v) -> {
			if (v > 0) {
				intoMap.merge(k, 1, (v1, v2) -> v1 + v2);
			}
		});
	}

	public Set<String> getCommonTerms(Map<String, Double> idf, int maxCount) {
		List<Entry<String, Double>> entries = new ArrayList<>(idf.entrySet());
		entries.sort((x, y) -> Double.compare(x.getValue(), y.getValue())); // Low
																			// value
																			// =
																			// more
																			// common
		Set<String> ret = new HashSet<String>();
		entries.subList(0, Math.min(maxCount, entries.size())).forEach(x -> ret.add(x.getKey()));
		return ret;
	}

	private final int MAX_TERM_COUNT = 5000;

	public synchronized void finish() {
		if (finished) {
			return;
		}
		numberContainingTerm = new HashMap<String, Integer>();
		numberContainingTerm2gram = new HashMap<String, Integer>();
		numberContainingTerm3gram = new HashMap<String, Integer>();
		for (Page page : pagesToPageUrl.values()) {
			page.finishCalcLinks();
			collectOccurrence(numberContainingTerm, page.getTerms());
			collectOccurrence(numberContainingTerm2gram, page.get2Grams());
			collectOccurrence(numberContainingTerm3gram, page.get3Grams());
		}
		double numDoc = pagesToPageUrl.size();
		Map<String, Double> idf = calcIdf(numberContainingTerm, numDoc);
		Map<String, Double> twogramidf = calcIdf(numberContainingTerm2gram, numDoc);
		Map<String, Double> threegramidf = calcIdf(numberContainingTerm3gram, numDoc);

		commonTerms.put(SimilarityType.TOKENML, getCommonTerms(idf, MAX_TERM_COUNT));
		commonTerms.put(SimilarityType.TWOGRAMML, getCommonTerms(twogramidf, MAX_TERM_COUNT));
		commonTerms.put(SimilarityType.THREEGRAMML, getCommonTerms(threegramidf, MAX_TERM_COUNT));

		for (Page page : pagesToPageUrl.values()) {
			page.calcIDF(idf, twogramidf, threegramidf);
		}

		addVdm(SimilarityType.TOKENML);
		addVdm(SimilarityType.TWOGRAMML);
		addVdm(SimilarityType.THREEGRAMML);
		for (Page page : pagesToPageUrl.values()) {
			for (SimilarityType type : SimilarityType.ML) {

			}
		}

	}

	private void addVdm(SimilarityType type) {
		Set<String> map = commonTerms.get(type);
		ValueDescManager tokenManager = mlInfos.get(type).vdm;
		SvmState state = new SvmState();
		SvmState[] states = new SvmState[] { state.push("1_"), state.push("2_") };
		for (SvmState sstate : states) {
			map.forEach((k) -> {
				sstate.add(k, 1.0);
			});
		}
		state.augmentVDM(tokenManager);
		try {
			tokenManager.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Double> calcIdf(Map<String, Integer> numberContainingTerm, double numDoc) {
		Map<String, Double> idf = new HashMap<>();
		numberContainingTerm.forEach((k, v) -> {
			idf.put(k, Math.log(numDoc / v));
		});
		return idf;
	}

	public Map<Page, Integer> getLinkCount(List<String> links) {
		Map<Page, Integer> ret = new HashMap<Page, Integer>();
		for (String link : links) {
			String baseLink = GetPages.removeAnchorPar(link);
			Page pg = pagesToPageUrl.get(baseLink);
			if (pg != null) {
				ret.merge(pg, 1, (v1, v2) -> v1 + v2);
			}
		}
		return ret;
	}

	public void addCategoryReal(String categoryUrl) {
		categorySet.addToQueue(categoryUrl);
	}

	private static enum Decision {
		YES, NO, UNKNOWN;
	}

	private Map<String, Decision> categoryPreSet = new HashMap<String, PageReaderManger.Decision>();

	public List<String> getUnknown(int maxNumb) {
		List<String> ret = new ArrayList<String>();
		synchronized (categoryPreSet) {
			for (Entry<String, Decision> entr : categoryPreSet.entrySet()) {
				if (entr.getValue() == Decision.UNKNOWN) {
					ret.add(entr.getKey());
					if (ret.size() >= maxNumb) {
						return ret;
					}
				}
			}
		}
		return ret;
	}

	public void addCategory(String categoryUrl) {
		if (!categorySet.contains(categoryUrl) && !categoryPreSet.containsKey(categoryUrl)) {
			synchronized (categoryPreSet) {
				File outputFile = new File("cache/precat");
				try {
					FileOutputStream fos = new FileOutputStream(outputFile, true);
					categoryPreSet.put(categoryUrl, Decision.UNKNOWN);
					fos.write((Decision.UNKNOWN + ":" + categoryUrl + "\n").getBytes());
					fos.flush();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Could not update precat: " + e.getMessage());
				}
			}
		}
	}

	public void addPage(String pageUrl) {
		pageSet.addToQueue(pageUrl);
	}

	private static Set<String> ignored = new HashSet<>();

	public void processCategory(String url) {
		System.out.println("Processing category " + url);
		url = GetPages.removeAnchorPar(url);
		List<String> list = GetPages.getContentLinks(url);
		for (String str : list) {
			String root = GetPages.getRoot(str);
			String[] namespaces = root.split(":");
			String mainThing = namespaces[namespaces.length - 1];
			if (namespaces.length > 1) {
				// Maybe a category
				if (namespaces[0].equals("Kategorie")) {
					addCategory(str);
				} else {
					if (ignored.add(str)) {
						System.err.println("Ignoring unknown non-category " + str);
					}
				}
			} else {
				addPage(str);
			}
		}
	}

	public Page getOrCreatePage(String url) {
		url = GetPages.removeAnchorPar(url);
		synchronized (GetPages.class) {
			return pagesToPageUrl.computeIfAbsent(url, x -> {
				Document doc;
				try {
					doc = GetPages.getDocument(x);
					Page page = new Page(x, doc, this);
					return page;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			});
		}
	}

	public void processPage(String url) {
		synchronized (GetPages.class) {
			System.out.println("Processing page " + url);
			try {
				url = GetPages.removeAnchorPar(url);
				Document doc = GetPages.getDocument(url);
				Page page = new Page(url, doc, this);
				pagesToPageUrl.put(url, page);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Could not load page " + url + ": " + e.getMessage());
			}
		}
	}

	public boolean process() {
		String category = categorySet.poll();
		boolean ret = false;
		if (category != null) {
			processCategory(category);
			ret = true;
			return ret;
		}
		String page = pageSet.poll();
		if (page != null) {
			processPage(page);
			ret = true;
		}
		return ret;
	}

	String onlyOneProcessAll = "onlyOneProcessAll";

	private boolean processingRunning = false;

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		processingRunning = false;
		finished = false;
	}

	public void processAll() {
		if (processingRunning) {
			return;
		}
		synchronized (onlyOneProcessAll) {
			processingRunning = true;
			long[] nextSerialization = new long[] { new java.util.Date().getTime() + 300000 };
			boolean processed = false;
			while ((processed = process()) || (!getUnknown(2).isEmpty())) {
				long curDate = new java.util.Date().getTime();
				if (processed && targetFile != null && curDate > nextSerialization[0]) {
					// serializeTo(targetFile);
					nextSerialization[0] = new java.util.Date().getTime() + 300000;
				}
			}
			File outputFile = new File("cache/precat");
			try {
				FileOutputStream fos = new FileOutputStream(outputFile, true);
				categoryPreSet.forEach((k, v) -> {
					try {
						fos.write((v + ":" + k + "\n").getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				fos.flush();
				fos.close();
				System.out.println("Finished preset");
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Could not add preset: " + e.getMessage());
			}
			finish();
			if (targetFile != null) {
				serializeTo(targetFile);
			}
			//trainAll();
			finished = true;
			processingRunning = false;
		}
	}

	private void serializeTo(File file) {
		if (true)
			return;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not serialize object: " + e.getMessage());
		} catch (StackOverflowError e) {
			e.printStackTrace();
			System.err.println("Stackoverflow when serializing object: " + e.getMessage());
		}
	}

	private File targetFile;
	private boolean finished = false;

	public List<IOPair> getIOPairs(SimilarityType type, int count) {
		// TODO: Slow! But should be ok
		int totalCount = 0;
		List<Page> pagesList = new ArrayList<>(pagesToPageUrl.values());
		for (Page page : pagesToPageUrl.values()) {
			totalCount += page.getLinks().size();
		}
		Random random = new Random();
		List<IOPair> ret = new ArrayList<>();
		for (int i = 0; i < count / 3; ++i) { // More links which are ok
			int randomInt = random.nextInt(totalCount);
			subLoop: for (Page page : pagesToPageUrl.values()) {
				if (randomInt < page.getLinks().size()) {
					for (Page linkedTo : page.getLinks().keySet()) {
						if (randomInt <= 0) {
							ret.add(page.getIOPair(this, type, linkedTo));
							System.out.println("Added IOPair " + ret.size() + "/" + count);
							break subLoop;
						}
						--randomInt;
					}
				}
				randomInt -= page.getLinks().size();
			}
		}
		for (int i = count / 3; i < count; ++i) { // Random links
			int randomInt = random.nextInt(pagesList.size());
			int randomInt2 = random.nextInt(pagesList.size() - 1);
			if (randomInt2 >= randomInt) {
				// Not randomInt
				++randomInt2;
			}
			Page first = pagesList.get(randomInt);
			Page second = pagesList.get(randomInt2);
			System.out.println("Added IOPair " + ret.size() + "/" + count);
			ret.add(first.getIOPair(this, type, second));
		}
		Collections.shuffle(ret);
		return ret;
	}

	public void train(SimilarityType type) {
		List<IOPair> iop = getIOPairs(type, 1000);
		WekaInterface weka = getWeka(type);
		weka.addTrainings(iop);
		weka.startProcessing(JobPriority.HIGH);
	}
	/*
	 * public void ensureVDM(SimilarityType type) {
	 * pagesToPageUrl.values().forEach(x-> x.ensureVDM(type, this));
	 * ValueDescManager vdm = getVDM(type);
	 * 
	 * }
	 */

	public void trainAll() {
		for (int i = 0; i < 100; ++i) {
			// Ensure that you have the similarities
			for (SimilarityType type : SimilarityType.ML) {
				// ensureVDM(type); - don't do that!
				train(type);
			}
			for (SimilarityType type : SimilarityType.ML) {
				WekaInterface weka = getWeka(type);
				weka.waitForProcessing();
			}
		}
	}

	public Map<String, Page> getPages() {
		return pagesToPageUrl;
	}

	public void useCategory(String url, Boolean use) {
		if (use) {
			categoryPreSet.put(url, Decision.YES);
			addCategoryReal(url);
		} else {
			categoryPreSet.put(url, Decision.NO);
			categorySet.remove(url);
		}
		File outputFile = new File("cache/precat");
		try {
			Decision decision = use ? Decision.YES : Decision.NO;
			FileOutputStream fos = new FileOutputStream(outputFile, true);
			categoryPreSet.put(url, decision);
			fos.write((decision + ":" + url + "\n").getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not update precat: " + e.getMessage());
		}
	}

	private static SimilarityType[] SUPPORTED_SIMILARITIES = new SimilarityType[] { SimilarityType.TOKENCOS,
			SimilarityType.TWOGRAMCOS, SimilarityType.THREEGRAMCOS };

	
	private static boolean suspend;
	
	public SingleAlgorithmResult getSimilarities(Page page, SimilarityType st) {
		Map<String, SingleLinkResult> similarities = new HashMap<String, SingleLinkResult>();
		pagesToPageUrl.values().parallelStream().forEach((otherPage) -> {
			SingleLinkResult slr = new SingleLinkResult(otherPage.getUrl(), page.getSimilarity(otherPage, st, this),
					page.getLinks().getOrDefault(otherPage, 0) > 0);
			synchronized (similarities) {
				similarities.put(otherPage.getUrl(), slr);
			}
		});
		SingleAlgorithmResult ret = new SingleAlgorithmResult(similarities);
		return ret;
	}

	public synchronized SimilarPagesResult getMostSimilarPages(Page page) {

		Map<SimilarityType, SingleAlgorithmResult> algorithmResults = new HashMap<Page.SimilarityType, SingleAlgorithmResult>();
		suspend = true;
		Arrays.asList(SimilarityType.values()).parallelStream().forEach((st)->{
			SingleAlgorithmResult sim = getSimilarities(page, st);
			synchronized (algorithmResults) {
				algorithmResults.put(st, sim);
			}
		});
		suspend = false;
		SimilarPagesResult spr = new SimilarPagesResult(page, algorithmResults);
		return spr;
	}

	public ValueDescManager getVDM(SimilarityType type) {
		return mlInfos.get(type).vdm;
	}

	public WekaInterface getWeka(SimilarityType type) {
		return mlInfos.get(type).sv;
	}

	public static void main(String[] args) {
		Object test = JobManager.INSTANCE;
		new File("cache").mkdirs();
		File prmFile = new File("cache/prm");
		PageReaderManger prm = null;
		if (prmFile.exists()) {
			try {
				FileInputStream fis = new FileInputStream(prmFile);
				ObjectInputStream ois = new ObjectInputStream(fis);
				prm = (PageReaderManger) ois.readObject();
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Could not read prm: " + e.getMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("Could not create class: " + e.getMessage());
			} catch (StackOverflowError e) {
				e.printStackTrace();
				System.err.println("Could not create class: " + e.getMessage());
			}
			if (prm == null) {
				prm = new PageReaderManger(prmFile);
			}
		} else {
			prm = new PageReaderManger(prmFile);
		}
		try {
			new CustomServer(prm).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		prm.addCategoryReal("https://de.wikipedia.org/wiki/Kategorie:Politische_Partei");
		prm.processAll();
		PageReaderManger fprm = prm;
		Map<SimilarityType, double[]> similarityRecalls = new HashMap<Page.SimilarityType, double[]>();
		/*for (SimilarityType type : SimilarityType.values()) {
			if (!type.name().endsWith("COS")) {
				System.out.println("Calculating similarity for " + type);
				double[] ar = new double[3];
				similarityRecalls.put(type, ar);
				for (Page page : prm.pagesToPageUrl.values()) {
					double recall = page.getRecall(type, prm);
					double weight = page.getRecallWeight();
					ar[0] += recall * recall * weight;
					ar[1] += recall * weight;
					ar[2] += weight;
				}
			}
		}
		similarityRecalls.forEach((k, v) -> {
			double avgRecall = v[1] / v[2];
			double variance = v[0] / v[2] - avgRecall * avgRecall;
			System.out.println("Recall for " + k + ": " + avgRecall + " +/- " + variance);
		});*/
		new Thread(() -> {

			Arrays.asList(SimilarityType.values()).parallelStream().forEach((type) -> {
				System.out.println("Calculating similarity for " + type);
				double[] ar = new double[3];
				List<Page> pages = new ArrayList<>();
				synchronized (similarityRecalls) {
					similarityRecalls.put(type, ar);
					pages = new ArrayList<>(fprm.pagesToPageUrl.values());
				}
				Collections.shuffle(pages);
				for (Page page : pages) {
					while (suspend) {
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					double recall = page.getRecall(type, fprm);
					double weight = page.getRecallWeight();
					ar[0] += recall * recall * weight;
					ar[1] += recall * weight;
					ar[2] += weight;
				}
			});
			try (FileOutputStream fos = new FileOutputStream("similarityOutput.csv",true)) {
			similarityRecalls.forEach((k, v) -> {
				double avgRecall = v[1] / v[2];
				double variance = v[0] / v[2] - avgRecall * avgRecall;
				String str = "Recall for " + k + ": " + avgRecall + " +/- " + variance;
				System.out.println(str);
				try {
					fos.write((str+"\n").getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			Arrays.asList(SimilarityType.values()).parallelStream().forEach((type) -> {
				if (type.name().endsWith("COS")) {return;}
				double[] ar = new double[3];
				List<Page> pages = new ArrayList<>();
				synchronized (similarityRecalls) {
					similarityRecalls.put(type, ar);
					pages = new ArrayList<>(fprm.pagesToPageUrl.values());
				}
				Collections.shuffle(pages);
				for (Page page : pages) {
					while (suspend) {
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					double recall = page.refreshRecall(type, fprm);
					double weight = page.getRecallWeight();
					ar[0] += recall * recall * weight;
					ar[1] += recall * weight;
					ar[2] += weight;
				}
			});
		}).start();

	}

}

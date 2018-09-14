package interparse.interparse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nanohttpd.protocols.http.IHTTPSession;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.request.Method;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;
import org.nanohttpd.util.IHandler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import interparse.interparse.Page.SimilarityType;

public class CustomServer extends NanoHTTPD {

	private static Map<String, PageReaderManger> prms = new HashMap<>();
	
	private List<String> existingPages;
	private File indexFile = new File("allprms");
	{
	
	}
	
	public static byte[] getBytesFromInputStream(InputStream is) {
		try {
	    ByteArrayOutputStream os = new ByteArrayOutputStream(); 
	    byte[] buffer = new byte[0xFFFF];
	    for (int len = is.read(buffer); len != -1; len = is.read(buffer)) { 
	        os.write(buffer, 0, len);
	    }
	    return os.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	PageReaderManger manager;
	
	public CustomServer() {
		super(3211);
		try {
			File allFile = new File(indexFile.getAbsolutePath()+File.separator+"all");
			if (allFile.exists()) {
				existingPages = Files.readAllLines(allFile.toPath());
				for (String ep: existingPages) {
					File prmFile = new File(indexFile.getAbsolutePath()+File.separator+ep);
					File meta = new File(prmFile.getAbsolutePath()+File.separator+"meta");
					prmFile.mkdirs();
					prmFile = new File(prmFile.getAbsolutePath()+File.pathSeparator+"prm");
					
					if (meta.exists()) {
						List<String> metaContent = Files.readAllLines(meta.toPath());
						PageReaderManger prm = new PageReaderManger(prmFile, metaContent.get(0), metaContent.get(1));
						prms.put(ep, prm);
					}
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		addHTTPInterceptor(new IHandler<IHTTPSession, Response>() {

			@Override
			public Response handle(IHTTPSession input) {
				Method method = input.getMethod();
				if (method == Method.GET) {
					if (input.getUri().endsWith(".html")) {
						byte[] textContent = null;
						try {
							textContent = Files.readAllBytes(new File("html"+input.getUri()).toPath());
						} catch (IOException e) {
							e.printStackTrace();
						}
						return Response.newFixedLengthResponse(Status.OK,"text/html",textContent);
					} else {
						if (input.getUri().endsWith("unknown"))  {
							return Response.newFixedLengthResponse(Status.OK,"application/json",toJSON(manager.getUnknown(100)));
						} else if (input.getUri().endsWith("getsimilarity")){
							manager.finish();
							String url = input.getParms().get("url");
							Page page = manager.getOrCreatePage(url);
							SimilarPagesResult spr = manager.getMostSimilarPages(page);
							JsonObject jo = spr.toJsonObject();
							return Response.newFixedLengthResponse(Status.OK,"application/json",jo.toString());
						} 
					}
				} else if (method == Method.POST) {
					if (input.getUri().endsWith("setstate")) {
						String url = input.getParms().get("url");
						Boolean use = Boolean.valueOf(input.getParms().get("use"));
						String type = input.getParms().getOrDefault("type","usecategory");
						if ("".equals(type)) {
							type = "usecategory";
						}
						if ("usecategory".equals(type)) {
							manager.useCategory(url, use);
						} else if ("page".equals(type)) {
							manager.addPage(url);
							manager.processAll();
						} else if ("category".equals(type)) {
							manager.addCategoryReal(url);
							manager.processAll();
						}
					} else if (input.getUri().endsWith("restartProcessing")) {
						manager.processAll();
					}  else if (input.getUri().endsWith("train")) {
						manager.trainAll();
					} else if (input.getUri().endsWith("init")){
						Map<String, String> params = input.getParms();
						/*byte[] bytes = getBytesFromInputStream(input.getInputStream());
						JsonElement parse = new JsonParser().parse(new String(bytes));
						String prefix = parse.getAsJsonObject().get("prefix").getAsString();
						String category = parse.getAsJsonObject().get("category").getAsString();
						String fullStartCategories = parse.getAsJsonObject().get("startcategories").getAsString();*/
						
						String prefix = params.get("prefix");
						String category = params.get("category");
						String fullStartCategories = params.get("startcategories");
						
						String epBuilder = prefix+category;
						StringBuilder eps = new StringBuilder();
						for (char c: epBuilder.toCharArray()) {
							if (Character.isAlphabetic(c) || Character.isDigit(c)) {
								eps.append(c);
							}
						}
						manager = prms.computeIfAbsent(eps.toString(), ep->{
							File prmFile = new File(indexFile.getAbsolutePath()+File.separator+ep);
							prmFile.mkdirs();
							prmFile = new File(prmFile.getAbsolutePath()+File.separator+"prm");
							PageReaderManger prm = new PageReaderManger(prmFile, prefix, category);
							try {
								FileOutputStream fos = new FileOutputStream(indexFile+File.separator+"all",true);
								fos.write((ep+"\n").getBytes());
								fos.flush();
								fos.close();
							} catch (IOException e) {e.printStackTrace();}
							try {
								prmFile.mkdirs();
								File meta = new File(prmFile.getParentFile().getAbsolutePath()+File.separator+"meta");
								FileOutputStream fos = new FileOutputStream(meta,true);
								fos.write((prefix+"\n"+category+"\n").getBytes());
								fos.flush();
								fos.close();
							} catch (IOException e) {e.printStackTrace();}
							prms.put(ep, prm);
							
							new Thread(
									()->{
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e2) {
											e2.printStackTrace();
										}
										prm.processAll();
										List<Page> pages = new ArrayList<>();
										Map<SimilarityType, double[]> similarityRecalls = new HashMap<Page.SimilarityType, double[]>();
										pages = new ArrayList<>(prm.pagesToPageUrl.values());
										Arrays.asList(SimilarityType.values()).parallelStream().forEach((type) -> {
											System.out.println("Calculating similarity for " + type);
											double[] ar = new double[3];
											synchronized (similarityRecalls) {
												similarityRecalls.put(type, ar);
											}
										});
											Collections.shuffle(pages);
											for (Page page : pages) {
												while (PageReaderManger.suspend) {
													try {
														Thread.sleep(10000);
													} catch (InterruptedException e) {
														e.printStackTrace();
													}
												}
												Arrays.asList(SimilarityType.values()).parallelStream().forEach((type) -> {
													
													double recall = page.getRecall(type, prm);
													double weight = page.getRecallWeight();
													double[] ar = null;
													synchronized (similarityRecalls) {
														ar = similarityRecalls.get(type);
														ar[0] += recall * recall * weight;
														ar[1] += recall * weight;
														ar[2] += weight;
													}
												});
												if (PageReaderManger.running) {
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
												}
										}
										/*
										
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
										});*/
									}
									
									
									).start();
							return prm;
						});
						for (String str: fullStartCategories.split("\n")) {
							if (str.trim().isEmpty()) {continue;}
							manager.addCategoryReal(str);
						}
						manager.processAll();
						return Response.newFixedLengthResponse(Status.OK,"application/json","{}");
					}
					return Response.newFixedLengthResponse(Status.OK,"application/json","{}");
				}
				return Response.newFixedLengthResponse(Status.NOT_FOUND,"application/json","{}");
			}
		});

	}
	
	
	private static String toJSON(List<String> list) {
		StringBuilder ret = new StringBuilder("[");
		for (int i = 0; i < list.size(); ++i) {
			if (i>0){ret.append(",");}
			ret.append("\""+list.get(i)+"\"");
		}
		ret.append("]");
		return ret.toString();
	}
	

}

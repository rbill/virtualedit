package interparse.interparse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PageReader {
	
	private static final PageReader instance = new PageReader();
	
	public static final PageReader instance() {
		return instance;
	}
	
	private PageReader() {
		rootDir = new File("cache");
		rootDir.mkdirs();
		try {
			readIndex();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private File rootDir;
	
	private Jsoup jsoup;
	
	private Map<String,File> cachedFiles = new HashMap<>();
	
	private static class FileIndex {
		
		public FileIndex(String url, int index) {
			this.url = url;
			this.index = index;
		}
		
		private int index;
		private String url;
	}
	
	private int maxIndex = 0;
	
	private List<FileIndex> fileIndices = new ArrayList<>();
	
	private File getIndexFile() throws IOException {
		return new File(rootDir.getCanonicalPath()+File.separator+"index.txt");
	}
	
	public void readIndex() throws IOException {
		File index = getIndexFile();
		if (index.exists()) {
			List<String> lines = Files.readAllLines(index.toPath());
			for (String line: lines) {
				if (line.trim().isEmpty()) {return;}
				String[] spl = line.split(":",2);
				FileIndex fin = new FileIndex(spl[1].trim(), Integer.valueOf(spl[0].trim()));
				fileIndices.add(fin);
				cachedFiles.put(fin.url, new File(rootDir.getAbsolutePath()+File.separator+fin.index+".html"));
				maxIndex = Math.max(fin.index, maxIndex);
			}
		}
	}
	
	public Document getHtml(String url) throws IOException {
		url = GetPages.removeAnchorPar(url);
		InputStream is = get(url);
		return Jsoup.parse(is, "UTF-8", url);
	}
	
	public final long waitTime = 10000; //10 s
	public long minWait = 0;
	
	private Map<String, JsonObject> metaInfo = new HashMap<String, JsonObject>();
	
	public JsonObject getMetaInfo(String url) {
		return metaInfo.computeIfAbsent(url, u->{
			try {
				File file = getJsonFile(url);
				if (file.exists()) {
					JsonParser parser = Json.createParser(new FileInputStream(file));
					JsonObject obj = parser.getObject();
					parser.close();
					return obj;
				}
				return Json.createObjectBuilder().build();
			} catch (Exception e) {
				System.err.println("Can't read metainfo for "+url+": "+e.getMessage());
				return Json.createObjectBuilder().build();
			}
		});
	}
	
	public File getJsonFile(String url) {
		url = GetPages.removeAnchorPar(url);
		File file = new File(getOrCreateFile(url).getAbsolutePath()+".meta");
		return file;
	}
	
	public void setMetaInfo(String url, JsonObject json) {
		metaInfo.put(url, json);
		File file = getJsonFile(url);
		System.out.println("Writing metainfo for " + url+" to "+file);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(json.toString().getBytes());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			System.err.println("Could not write info for "+url+": "+e.getMessage());
		}
	}


	public File getOrCreateFile(String url) {
		File cached = cachedFiles.get(url);
		if (cached == null || cached.length() < 500) {
			long curTime = new Date().getTime();
			if (minWait > curTime) {
				try {
					Thread.sleep(minWait-curTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			minWait = curTime + waitTime;
			Response res = null;
			for (int i = 0; i < 20; ++i) {
				try {
					System.out.println("Downloading "+url);
					res = Jsoup.connect(url).execute();
					System.out.println("Downloaded "+url);
					break;
				} catch (Exception e) {
					System.err.println("Cannot retrieve "+url+": "+e.getMessage());
				}
				try {
					Thread.sleep((i+1)*(i+1)*1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int index;
			if (cached == null) {
				FileIndex newIndex = new FileIndex(url, ++maxIndex);
				index = newIndex.index;
				cached = getFile(newIndex.index);
			} else {
				index = Integer.valueOf(cached.getName().split("[.]")[0]);
			}
			try {
				{
					FileOutputStream fos = new FileOutputStream(cached);
					fos.write(res.bodyAsBytes());
					fos.flush();
					fos.close();
				}
				
				FileOutputStream fos = new FileOutputStream(getIndexFile(),true);
				fos.write((index+":"+url+"\n").getBytes());
				fos.flush();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("cannot create file for url "+url+": "+e.getMessage());
			}
			
			cachedFiles.put(url, cached);
		}
		return cached;
	}
	
	public File getFile(int index) {
		File cached = new File(rootDir.getAbsolutePath()+File.separator+index+".html");	
		return cached;
	}
	 
	public InputStream get(String url) throws IOException {
		url = GetPages.removeAnchorPar(url);
		File cached = getOrCreateFile(url);
		try {
			return new FileInputStream(cached);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
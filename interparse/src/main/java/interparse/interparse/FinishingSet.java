package interparse.interparse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.rowset.serial.SerialArray;

public class FinishingSet implements Serializable {
	
	private enum State {
		FINISHED, QUEUE, RUNNING, FAILED;
	}
	
	private Map<String, State> finishedSet = new HashMap<>();
	
	private Set<String> queueSet = new HashSet<>();
	
	private File file;
	
	public FinishingSet(File file) {
		this.file = file;
		if (this.file.exists()) {
		List<String> allLines;
		try {
			allLines = Files.readAllLines(file.toPath());
			allLines.forEach((line)->{
				if (line.isEmpty()) {return;}
				String[] spl = line.split(":",2);
				State state = State.valueOf(spl[0]);
				String url = spl[1];
				finishedSet.put(url, state);
			});
			finishedSet.forEach((url,state)->{
				if (state == State.QUEUE) {
					queueSet.add(url);
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	
	private synchronized void make(String url, State newState) {
		finishedSet.put(url,newState);
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			fos.write((newState.toString()+":"+url+"\n").getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			System.err.println("Error writing file: "+e.getMessage());
		}
	}
	
	public synchronized boolean addToQueue(String url) {
		if (finishedSet.containsKey(url)) {
			return false;
		}
		System.out.println("Adding url "+url+" to queue");
		make(url, State.QUEUE);
		return queueSet.add(url);
	}
	
	public synchronized void failed(String url) {
		finishedSet.put(url, State.FAILED);
	}
	

	public synchronized void finished(String url) {
		finishedSet.put(url, State.FINISHED);
	}
	
	public synchronized String poll() {
		if (queueSet.isEmpty()) {
			return null;
		}
		Iterator<String> iter = queueSet.iterator();
		String ret = iter.next();
		iter.remove();
		finishedSet.put(ret, State.RUNNING);
		System.out.println("Remaining: "+queueSet.size());
		return ret;
	}

	public synchronized boolean contains(String categoryUrl) {
		return finishedSet.containsKey(categoryUrl);
	}

	public synchronized void remove(String url) {
		queueSet.remove(url);
		finishedSet.remove(url);
	}

}

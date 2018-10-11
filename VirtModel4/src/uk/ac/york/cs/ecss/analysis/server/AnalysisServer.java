package uk.ac.york.cs.ecss.analysis.server;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import org.nanohttpd.protocols.http.IHTTPSession;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.request.Method;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.util.IHandler;

public class AnalysisServer extends NanoHTTPD {
	
	private static final int DEFAULT_SERVER_PORT = 7070;
	private static final String DEFAULT_XTEXT_INTERMEDIATE_RESULTS_TXT_LOCATION = "../../data/analysis/xtext-intermediate.results.txt";
	public static final int SECONDS_BETWEEN_OUTPUT = 10;
	public static final DateFormat DATE_FORMAT;
	static {
		DATE_FORMAT = DateFormat.getDateTimeInstance();
	}

	public static class JobDesc {
		public String[] param;
		
		public JobDesc(String... param) {
			this.param = param;
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof JobDesc)) {
				return false;
			}
			JobDesc jd = (JobDesc)o;
			return Arrays.equals(param, jd.param);
		}
		
		@Override
		public int hashCode() {
			return Arrays.hashCode(param);
		}
		
		public String toString() {
			StringBuilder ret = new StringBuilder();
			boolean first = true;
			for (String str: param) {
				if (first) {first = false;} else {ret.append(",");}
				ret.append(str);
			}
			return ret.toString();
		}
	}
	
	public Map<JobDesc,JobDesc> realJobs = new HashMap<JobDesc, JobDesc>();
	public Set<JobDesc> pending = new HashSet<>();
	public Queue<JobDesc> remaining = new LinkedList<>();
	public Map<JobDesc,String> results = new HashMap<>();
	
	public void teardown() {
		super.teardown();
		serverThread.stop();
		System.out.println("Stopped server.");
	}
	
	public synchronized void resetPending() {
		remaining.addAll(pending);
		pending.clear();
	}
	
	public synchronized JobDesc getDesc() {
		if (remaining.isEmpty()) {
			resetPending();
		}
		if (remaining.isEmpty()) {
			return null;
		}
		JobDesc ret = remaining.poll();
		pending.add(ret);
		return ret;
	}
	
	public JobDesc getReal(JobDesc desc) {
		JobDesc ret = realJobs.get(desc);
		if (ret == null) {
			ret = desc;
			realJobs.put(desc, desc);
		}
		return ret;
	}
	
	public synchronized void addDone(JobDesc desc, String result, boolean output) {
//		if (output) {
//			System.out.println("Finished job "+desc);
//		} else {
//			System.out.println("Read job "+desc);
//		}
	
		JobDesc real = getReal(desc);
		pending.remove(real);
		results.put(desc, result);
	}
	
	public synchronized void addRemaining(JobDesc desc) {
		JobDesc real = getReal(desc);
		if (!results.containsKey(real)) {
			remaining.add(desc);
		}
	}

	public synchronized void addError(JobDesc desc) {
		System.err.println("Error in job "+desc);
		JobDesc real = getReal(desc);
		if (!results.containsKey(real)) {
			pending.remove(real);
			remaining.add(real);
		}
	}
	
	private List<String> names;
	private File matrixFile;
	private FileOutputStream logOutputStream;
	Map<String,Integer> existingInts = new HashMap<String, Integer>();
	Map<Integer,String> existingFiles = new HashMap<>();
	Map<String,Integer> newInts = new HashMap<String, Integer>();
	long startTime = 0;
	int startDone = 0;
	long lastOutputTime = 0;
	private Thread serverThread;

	public Thread getServerThread() {
		return serverThread;
	}

	public void initializeMatrix() {
		//Read matrix content
		try {
			
			if ( !matrixFile.exists() ) {
				Files.createFile(matrixFile.toPath());
			}

			try (BufferedReader reader = new BufferedReader(new FileReader(matrixFile))) {
				String s;
				while ((s = reader.readLine()) != null) {
					if (s.contains(":")) {
						String[] numStr = s.split("\\:",2);
						int index = Integer.valueOf(numStr[0]);
						//So that the state is always correct (hopefully)
						existingInts.remove(existingFiles.get(index));
						existingInts.put(numStr[1], index);
						existingFiles.put(index, numStr[1]);
					} else {
						String[] values = s.split("[,=]",3);
						String firstFile = values[0].endsWith("xtext")?values[0]:existingFiles.get(Integer.valueOf(values[0]));
						String secondFile = values[1].endsWith("xtext")?values[1]:existingFiles.get(Integer.valueOf(values[1]));
						if (firstFile != null && secondFile != null) {
							addDone(new JobDesc(firstFile,secondFile), values[2], false);
						}
					}
				}
				//Hope file.getName is unique
				{
					names.addAll(existingFiles.values());
					Collections.sort(names);
					{
						int i = 0;
						for (String name: names) {
							newInts.put(name, i);
							++i;
						}
					}
					for (int i = 0; i < names.size(); ++i) {
						for (int j = i+1; j < names.size(); ++j) {
							JobDesc desc = new JobDesc(names.get(i),names.get(j));
							addRemaining(desc);
						}
					}
					List<JobDesc> noShuffle =  new ArrayList<JobDesc>(remaining);
					Collections.shuffle(noShuffle);
					remaining.clear();
					remaining.addAll(noShuffle);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("File: "+matrixFile.getAbsolutePath());
			this.logOutputStream = new FileOutputStream(matrixFile,true);
			StringBuilder builder = new StringBuilder();
			for (Entry<String,Integer> entr: newInts.entrySet()) {
				builder.append(entr.getValue());
				builder.append(":");
				builder.append(entr.getKey());
				builder.append("\n");
			}
			logOutputStream.write(builder.toString().getBytes());
			logOutputStream.flush();
			lastOutputTime = startTime = System.currentTimeMillis();
			startDone = results.size();
		} catch (FileNotFoundException e) {
			System.out.println("In directory: "+new File(".").getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public long getETA() {
		long curTime = System.currentTimeMillis();
		int curDone = results.size();
		if (remaining.size()+pending.size() == 0) {
			return curTime;
		}
		if (curDone == startDone) {
			//A year
			return curTime+86400L*365*100;
		}
		long endTime = (long)( 				
				curTime+((double)(remaining.size()+pending.size()))*(curTime-startTime)/
				(curDone-startDone));
		return endTime;
	}
	
	public AnalysisServer() {
		this(new ArrayList<String>());
	}
	
	public AnalysisServer(List<String> names) {
		this(names, new File(DEFAULT_XTEXT_INTERMEDIATE_RESULTS_TXT_LOCATION), DEFAULT_SERVER_PORT);
	}
	
	/**
	 * 
	 * @param names
	 * @param matrixFile xtext intermediate results file location
	 * @param port server port
	 */
	public AnalysisServer(List<String> names, File matrixFile, int port) {
		super(port);
		this.names = names;
		this.matrixFile = matrixFile;
		initializeMatrix();
		serverThread = establishServerThread();
		serverThread.start();
		setHTTPHandler(new IHandler<IHTTPSession, Response>() {
			
			@Override
			public Response handle(IHTTPSession input) {
				Method method = input.getMethod();
				try {
				switch(method) {
				case GET: /**Retrieve new job*/
					JobDesc ret = getDesc();
					return Response.newFixedLengthResponse(""+ret);
				case POST: 
					List<String> job = input.getParameters().get("job");
					List<String> result = input.getParameters().get("result");
					if (job.isEmpty()) {
						System.err.println("Empty job given!");
					} else {
						if (result.isEmpty()) {
							System.err.println("Empty result given!");
						} else {
							List<String> allJobs = new ArrayList<>();
							//Don't know wheter it will be separated
							for (String str: job) {
								allJobs.addAll(Arrays.asList(str.split("\\,")));
							}
							JobDesc newDesc = new JobDesc(allJobs.toArray(new String[allJobs.size()]));
							try {
								logOutputStream.write((newDesc+"="+result.get(0)+"\n").getBytes());
								logOutputStream.flush();
							} catch (Exception e) {
								System.err.println("Error when writing to log: "+e.getMessage());
								e.printStackTrace();
							}
							addDone(newDesc, result.get(0), true);
						}
					}
					JobDesc ret2 = getDesc();
					return Response.newFixedLengthResponse(""+ret2);
				case DELETE:
					List<String> job2 = input.getParameters().get("job");
					if (job2.isEmpty()) {
						System.err.println("Empty job given!");
					} else {
						List<String> allJobs = new ArrayList<>();
						//Don't know wheter it will be separated
						for (String str: job2) {
							allJobs.addAll(Arrays.asList(str.split("\\,")));
						}
						JobDesc newDesc = new JobDesc(allJobs.toArray(new String[allJobs.size()]));
						addError(newDesc);
					}
					return Response.newFixedLengthResponse("Deleted");
				default:
					System.err.println("Other method "+method+" not supported!");
					break;
				}
				return null;
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
				return null;
			}
			}
		});
		System.out.println("Started server. Exit with CTRL+C.");
	}

	private Thread establishServerThread() {
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				DecimalFormat df = new DecimalFormat("#.##");
				for(;;) {
					try {
						Thread.sleep(SECONDS_BETWEEN_OUTPUT*1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(AnalysisServer.this) {
						long eta = getETA();
						int done = results.size();
						int total = results.size()+pending.size()+remaining.size();
						double percentN = 100.0*((double)done)/total;
						String percent = df.format(percentN);
						System.out.println("Estimated end: "+DATE_FORMAT.format(new Date(eta))+", done "+done+"/"+total+ " ("+percent+"%)");
						if (done==total) {
							//Warum bricht er nicht ab?
							return;
						}
					}
					
				}
				
			}
			
		});
	}
	
	public static void main(String[] args) throws IOException {
		AnalysisServer ms = new AnalysisServer(new ArrayList<String>(), new File(DEFAULT_XTEXT_INTERMEDIATE_RESULTS_TXT_LOCATION),DEFAULT_SERVER_PORT);
		ms.start();
		
	}

}

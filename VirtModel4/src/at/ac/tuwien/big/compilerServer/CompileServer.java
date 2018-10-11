package at.ac.tuwien.big.compilerServer;

/*
 * #%L
 * NanoHttpd-Core
 * %%
 * Copyright (C) 2012 - 2016 nanohttpd
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the nanohttpd nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import at.ac.tuwien.big.vfunc.nbasic.constraint.Compile;
import at.ac.tuwien.big.xmlintelledit.intelledit.scope.BasicEntry;

import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.Base64;
import org.eclipse.xtext.util.Files;
import org.nanohttpd.protocols.http.IHTTPSession;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.util.IHandler;

public class CompileServer extends NanoHTTPD {
	
	private static final int PORT = 5678;
	private static CompileServer server = new CompileServer();
	
	static {
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CompileServer() {
		super(PORT);
		addHTTPInterceptor(new IHandler<IHTTPSession, Response>() {
			
			@Override
			public Response handle(IHTTPSession input) {
				List<Map.Entry<String, String>> ctc = new ArrayList<Map.Entry<String,String>>();
				Map<String,String> files = new HashMap<>();
				try {
					input.parseBody(files);
				} catch (IOException | ResponseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<String> allClasses = new ArrayList<>();
				for (int i = 1; ; ++i) {
					List<String> list = input.getParameters().get("classes"+i);
					if (list == null || list.isEmpty()) {
						break;
					}
					allClasses.addAll(list);
				}
				
				for (String allClass: allClasses) {
					String[] spl = allClass.split("\\=",2);
					Map.Entry<String, String> entry = new BasicEntry<>(spl[0], spl[1]);
					ctc.add(entry);
				}
				Map<String,List<byte[]>> bytes = new HashMap<>();
				Map<String,Class<?>> retMap = Compile.compile(ctc, bytes);
				StringBuilder ret = new StringBuilder();
				for (Entry<String,List<byte[]>> entr: bytes.entrySet()) {
					List<byte[]> bl = entr.getValue();
					for (int i = 0; i < bl.size(); ++i) {
						ret.append(entr.getKey()+":"+i+"="+encodeBase64(bl.get(i))+"\n");
					}
				}
				return Response.newFixedLengthResponse(ret.toString());
			}
		});
	}
	
	public static Map<String,Class<?>> getCompiledClasses(List<? extends Map.Entry<String, String>> classInfo) {
		HttpPost post = new HttpPost("http://localhost:"+PORT+"/compile");
		List<NameValuePair> params = new ArrayList<>();
		int index = 1;
		for (Entry<String,String> entr: classInfo) {
			params.add(new BasicNameValuePair("classes"+index, entr.getKey()+"="+entr.getValue()));
			++index;
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpClient client = HttpClients.createDefault();
		try {
			HttpResponse response = client.execute(post);
			String totalString = Files.readStreamIntoString(response.getEntity().getContent());
			String[] spl = totalString.split("\n");
			Map<String,List<byte[]>> bytes = new HashMap<String, List<byte[]>>();
			for (int i = 0; i < spl.length; ++i) {
				String[] ss = spl[i].split("=",2);
				if (ss.length == 1) {continue;}
				String namePlusIndex = ss[0];
				String[] npispl = namePlusIndex.split("\\:");
				int idx = 0;
				if (npispl.length>1) {
					idx = Integer.valueOf(npispl[1]);
				}
				String key = npispl[0];
				List<byte[]> bl = bytes.computeIfAbsent(key, x->new ArrayList<>());
				while (bl.size() <= idx) {
					bl.add(null);
				}
				bl.set(idx, decodeBase64(ss[1]));
			}
			Map<String,Class<?>> ret = Compile.fromClassMap(bytes);
			return ret;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyMap();
		
	}
	
	public static String encodeBase64(byte[] bt) {
		return Base64.encode(bt);
	}
	
	public static byte[] decodeBase64(String b64) {
		return Base64.decode(b64);
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(;;) {
			Thread.sleep(10000);
		}
	}
}

package interparse.interparse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.nanohttpd.protocols.http.IHTTPSession;

import javax.json.Json;
import javax.json.JsonObject;
import org.nanohttpd.protocols.http.NanoHTTPD;
import org.nanohttpd.protocols.http.request.Method;
import org.nanohttpd.protocols.http.response.IStatus;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;
import org.nanohttpd.util.IHandler;

public class CustomServer extends NanoHTTPD {

	public CustomServer(PageReaderManger manager) {
		super(3210);
		
		addHTTPInterceptor(new IHandler<IHTTPSession, Response>() {

			@Override
			public Response handle(IHTTPSession input) {
				Method method = input.getMethod();
				if (method == Method.GET) {
					if (input.getUri().endsWith(".html")) {
						byte[] textContent = null;
						try {
							textContent = Files.readAllBytes(new File("html/index.html").toPath());
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

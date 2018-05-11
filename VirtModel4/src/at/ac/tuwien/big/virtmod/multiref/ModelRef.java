package at.ac.tuwien.big.virtmod.multiref;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

import at.ac.tuwien.big.verocl.ParameterDesc;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.SingleParameterDesc;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.verocl.parameterdesc.impl.SinglePointImpl;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class ModelRef implements Iterable<ModelRef> {
	
	/**Puts in the extension in the first index of extRef*/
	public static String withoutExt(String path, String[] extRef) {
		int lind = path.lastIndexOf('.');
		int sepPathInd = path.lastIndexOf(File.separator);
		if (lind < sepPathInd || lind < path.lastIndexOf('/')) {
			lind = -1;
		}
		if (lind != -1) {
			if (extRef != null && extRef.length > 0) {
				extRef[0] = path.substring(lind+1);
			}
			return path.substring(0,lind);
			
		}
		if (extRef != null && extRef.length > 0) {
			extRef[0] = "";
		}
		return path;
	}
	
	public static File withoutExt(File file, String[] extRef) {
		return new File(withoutExt(file.getPath(),extRef));
	}
	
	
	public static ModelRef modelRefOrNull(int[] index, ResourceSet rs, String baseUri, String ext, PointDesc desc) {
		try {
			if (!URIConverter.INSTANCE.exists(URIConverter.INSTANCE.normalize(URI.createURI(baseUri+"."+ext)), Collections.emptyMap())) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		String uri;
		uri = URIConverter.INSTANCE.normalize(URI.createURI(baseUri+"."+ext)).toString();
		Object[] objs = new Object[desc.getParameterDescs().size()];
		for (int i = 0; i < objs.length; ++i) {
			SingleParameterDesc d = desc.getParameterDescs().get(i);
			if (d.getType() == String.class) {
				objs[i] = uri; //TODO: ... This doesn't respect anything!
			} else if (d.getType() == Integer.class) {
				objs[i] = index[0];
			} else if (d.getType() == Long.class) {
				try {
					//TODO: ...
					String fileString = URI.createURI(uri).toFileString();
					File file = new File(fileString);
					if (file.exists()) {
						objs[i] = file.lastModified();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		SinglePointImpl points = new SinglePointImpl(desc,objs);
		ModelRef ret = new ModelRef(index[0]++,uri, points);
		points.initModelRef(ret);
		//Check sub-things
		for (int i = 1; ; ++i) {
			String newPath = baseUri + "_"+i;
			ModelRef sub = modelRefOrNull(index,rs, newPath, ext, desc);
			if (sub == null) {
				break;
			}
			ret.next.add(sub);
		}
		
		return ret;
	}
	
	


	public static ModelRef intModelRefs(ResourceSet rs, File baseFile) {
		int[] index = new int[]{1};
		return realFakeDir(index, rs, baseFile, PointDesc.FULLBASIC);
	}
	
	/**Reads in a tree of files starting from the base files. The files start with the base file, 
	 * but then have added .1, .2, .1.2, .1.1.3 etc. 
	 * @param baseFile
	 * @param desc Should be empty. No points are assigned currently
	 * @return
	 */
	public static ModelRef realFakeDir(int[] index, ResourceSet rs, File baseFile, PointDesc desc) {
		String[] extRef = new String[1];
		File withoutExt = withoutExt(baseFile,extRef);
		//Assume it is something like 1.2. ...
		return modelRefOrNull(index,rs, URI.createFileURI(withoutExt.getPath()).toString(), extRef[0], desc);
	}
	

	/**Reads in a tree of files starting from the base files. The files start with the base file, 
	 * but then have added .1, .2, .1.2, .1.1.3 etc. 
	 * Uses an empty point desc
	 */
	public static ModelRef realFakeDir(int[] index, ResourceSet rs, File baseFile) {
		return realFakeDir(index,rs, baseFile, PointDesc.FULLBASIC);
	}
	
	public ModelRef(int index, String uri, SinglePoint points) {
		this.uri = uri;
		this.points = points;
		this.index = index;
		if (points instanceof SinglePointImpl) {
			((SinglePointImpl)points).initModelRef(this);
		}
	}
	
	public ModelRef(int index, Resource res, SinglePoint points) {
		this(index,res.getURI().toString(),points);
		this.res = res;
	}

	public ModelRef(int index, URI uri, SinglePoint points) {
		this(index,uri.toString(),points);
	}

	public int getIndex() {
		return index;
	}
	
	private int index;
	private String uri;
	private SinglePoint points;
	private List<ModelRef> next = new ArrayList<>();
	private Resource res;
	
	public Resource loadResource(ResourceSet rs) {
		if (res == null) {
			res = rs.getResource(URI.createURI(uri), true);
		}
		return res;
	}
	
	public void setResource(Resource res) {
		this.res = res;
	}
	
	public void addNext(ModelRef next) {
		this.next.add(next);
	}
	
	public List<ModelRef> getNext() {
		return next;
	}
	
	public String getURI() {
		return uri;
	}
	
	public SinglePoint getPoints() {
		return points;
	}

	@Override
	public Iterator<ModelRef> iterator() {
		//Get all
		Set<ModelRef> all = new HashSet<ModelRef>();
		augment(all);
		return all.iterator();
	}
	
	private void augment(Set<ModelRef> set) {
		if (set.add(this))  {
			for (ModelRef ref: getNext()) {
				ref.augment(set);
			}
		}
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("ModelRef("+uri+"): "+points);
		if (!next.isEmpty()) {
			ret.append(" --> {");
			boolean first = true;
			for (ModelRef ref: next) {
				if (first) {first = false;} else {ret.append(", ");}
				ret.append(ref.uri);
			}
			ret.append("}");
		}
		return ret.toString();
	}
}

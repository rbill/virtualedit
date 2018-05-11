package at.ac.tuwien.big.virtmod.multiref;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import at.ac.tuwien.big.multimodeldesc.mMDesc.MMDesc;
import at.ac.tuwien.big.multimodeldesc.mMDesc.MMDescFactory;
import at.ac.tuwien.big.multimodeldesc.mMDesc.MMDescPackage;
import at.ac.tuwien.big.multimodeldesc.mMDesc.ModelView;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.SingleParameterDesc;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.verocl.parameterdesc.impl.SinglePointImpl;

public class ConvertMMDesc {

	static {
		MMDescPackage pkg = MMDescPackage.eINSTANCE;
		MMDescFactory fact = MMDescFactory.eINSTANCE;
	}
	
	public static class MMDescWrapper {
		private PointDesc desc;
		private List<ModelRef> rootRefs = new ArrayList<ModelRef>();
		private List<ModelRef> shownRefs = new ArrayList<>();
		
		public PointDesc getDesc() {
			return desc;
		}
		
		public List<ModelRef> getShown() {
			return shownRefs;
		}
		
		public List<ModelRef> getAllRefs() {
			Set<ModelRef> haveRefs = new HashSet<>();
			List<ModelRef> ret = new ArrayList<ModelRef>();
			Stack<ModelRef> refStack = new Stack<ModelRef>();
			refStack.addAll(rootRefs);
			Collections.reverse(refStack);
			while (!refStack.isEmpty()) {
				ModelRef ref = refStack.pop();
				ret.add(ref);
				List<ModelRef> invList = new ArrayList<>(ref.getNext());
				Collections.reverse(invList);
				for (ModelRef next: invList) {
					if (haveRefs.add(next)) {
						refStack.add(next);
					}
				}
			}
			return ret;
		}
		
		public List<ModelRef> getRootRefs() {
			return rootRefs;
		}
		
		public void updateShown(MMDesc base) {
			ModelView view = base.getView();
			if (view == null) {
				//View is all
				this.shownRefs = new ArrayList<>(getAllRefs());
			} else {
				Map<String, ModelRef> mrefs = new HashMap<>();
				for (ModelRef mref: getAllRefs()) {
					mrefs.put(mref.getURI(), mref);
				}
				List<ModelRef> newShown = new ArrayList<ModelRef>();
				for (at.ac.tuwien.big.multimodeldesc.mMDesc.ModelRef ref: view.getViewed()) {
					ModelRef other = mrefs.get(ref.getUri());
					if (other == null) {
						System.err.println("Could not find to view "+ref.getUri()+"!");
					} else {
						newShown.add(other);
					}
				}
				
				this.shownRefs = newShown;
			}
		}
		
		private ModelRef convertModelRef(at.ac.tuwien.big.multimodeldesc.mMDesc.ModelRef ref) {
			List<String> dataString = ref.getData();
			Object[] data  = new Object[Math.max(dataString.size(), desc.getParameterDescs().size())];
			PointDesc desc = getDesc();
			List<SingleParameterDesc> l = desc.getParameterDescs();
			for (int i = 0; i < dataString.size(); ++i) {
				Object str = dataString.get(i);
				if (i < l.size()) {
					SingleParameterDesc sp = l.get(i);
					if (sp.getType() == Integer.class) {
						str = (str==null||"".equals(str))?0:Integer.valueOf(str.toString());
					}
				}
				data[i] = str;
			}
			SinglePointImpl point = new SinglePointImpl(getDesc(), data);
			ModelRef ret = new ModelRef(ref.getId(),ref.getUri(), point);
			point.initModelRef(ret);
			for (at.ac.tuwien.big.multimodeldesc.mMDesc.ModelRef sref: ref.getNext()) {
				ModelRef add = convertModelRef(sref);
				ret.addNext(add);
			}
			return ret;
		}
		 
		public void convertFrom(MMDesc base) {
			at.ac.tuwien.big.multimodeldesc.mMDesc.PointDesc pd = base.getPointDesc();
			this.desc = new PointDesc();
			int index = 0;
			for (String type: pd.getType()) {
				Class<?> cl = ("String".equals(type)?String.class:("Integer".equals(type)?Integer.class:("Long".equals(type)?Long.class:null)));
				if (cl == null) {
					throw new RuntimeException("Unknown type " + type);
				}
				if (index == 0) {

					desc.addParameterDesc(new SingleParameterDesc("uri", cl));	
				} else {
					desc.addParameterDesc(new SingleParameterDesc("p"+index, cl));
				}
				++index;
			}
			for (at.ac.tuwien.big.multimodeldesc.mMDesc.ModelRef curRef: base.getModels()) {
				ModelRef conv = convertModelRef(curRef);
				this.rootRefs.add(conv);
			}
			updateShown(base);			
		}
	}
	
	public static MMDescWrapper convertMMDesc(MMDesc desc) {
		MMDescWrapper ret = new MMDescWrapper();
		ret.convertFrom(desc);
		return ret;
	}

}

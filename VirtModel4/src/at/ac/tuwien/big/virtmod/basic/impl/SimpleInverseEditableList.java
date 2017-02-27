package at.ac.tuwien.big.virtmod.basic.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.ListEditState;
import at.ac.tuwien.big.virtmod.basic.SimpleEntry;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditableList.FakeEntry;
import at.ac.tuwien.big.virtmod.ecore.Feature;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VListFeature;
import at.ac.tuwien.big.virtmod.ecore.VListFeaturePropertyValue;

public class SimpleInverseEditableList implements AbstractEditableList<String> {
	
	private SimpleEditableList<String> base;
	private VListFeature<String> inverse;
	private String myValue;
	
	public SimpleInverseEditableList(SimpleEditableList<String> base, VListFeature<String> inverse, String myValue) {
		this.base = base;
		this.inverse = inverse;
		this.myValue = myValue;
	}
	

	@Override
	public ListEditState getEditState() {
		return base.getEditState();
	}	
	
	private TreeposList wrap(TreeposList retList, String forValue) {
		return new TreeposList() {
			
			@Override
			public boolean removeSpecificEdit(long editId, Treepos pos) {
				return check(retList.removeSpecificEdit(editId, pos));
			}
			
			private boolean check(boolean ret) {
				if (ret && isEmpty()) {
					VListFeaturePropertyValue<String> fpv = inverse.getValue(forValue);
					VEditableList<String> inverse = fpv.getDelegate();
					inverse.removeAll(myValue);
				}
				return ret;
			}
			
			@Override
			public boolean removePosition(Treepos pos) {
				return check(retList.removePosition(pos));
			}
			
			@Override
			public boolean removeEdit(long editId) {
				return check(retList.removeEdit(editId));
			}
			
			@Override
			public Iterable<Entry<Long, Treepos>> getEntries() {
				return retList.getEntries();
			}
			
			@Override
			public Treepos getAtEditOrNull(long editId) {
				return retList.getAtEditOrNull(editId);
			}
			
			@Override
			public void clear() {
				clear();
				check(true);
			}
			
			@Override
			public void add(long editId, Treepos pos) {
				retList.add(editId, pos);
				VListFeaturePropertyValue<String> fpv = inverse.getValue(forValue);
				VEditableList<String> inverse = fpv.getDelegate();
				if (!inverse.contains(myValue)) {
					inverse.addDefault(myValue);
				}
			}
		};
	}
	
	@Override
	public TreeposList getIndices(String forValue) {
		//DIe sind ja editierbar ...
		return wrap(base.getIndices(forValue),forValue);
	}

	@Override
	public Iterable<Entry<String, TreeposList>> treeposForValues() {
		
		return ()->new Iterator<Entry<String, TreeposList>>(){
			Iterator<Entry<String, TreeposList>> baseIter = base.treeposForValues().iterator();

			@Override
			public boolean hasNext() {
				return baseIter.hasNext();
			}

			@Override
			public Entry<String, TreeposList> next() {
				Entry<String, TreeposList> entr = baseIter.next();
				return new SimpleEntry(entr.getKey(), wrap(entr.getValue(), entr.getKey()));
			}
			
		};
	}

	@Override
	public boolean containsSpecific(Treepos pos, String value, long editId) {
		return base.containsSpecific(pos, value, editId);
	}

	@Override
	public int size() {
		return base.size();
	}

	@Override
	public boolean contains(String entry) {
		return base.contains(entry);
	}

	@Override
	public Iterator<String> iterator() {
		return base.iterator();
	}


	@Override
	public void clear() {
		for (Entry<String,?> str: treeposForValues())  {
			inverse.getValue(str.getKey()).getDelegate().removeAll(myValue);
		}
		base.clear();
	}

	@Override
	public void clean() {
		base.clean();
	}






}

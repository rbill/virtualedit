package at.ac.tuwien.big.vmodel.ecore;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;


public interface VObjectValues extends Iterable<String> {

	public String getClass(String objectId);

	public void setClass(String objectId, String classId);
	
	public boolean exists(String objectId);
	
	public void add(String objectId);
	
	public void remove(String objectId);
	
	public default Filter<String> objectExistsFilter() {
		return (x)->exists(x);
	}

	public Iterable<? extends ElementSourceInfo> getSource(String uuid);

	public void selfClear();

	public void nullifyClear();
}

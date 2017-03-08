package at.ac.tuwien.big.virtmod.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.virtmod.basic.VEditableList;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public interface FeaturePropertyValue<T>  {
		
	public EList<T> getDelegateList();
	
	public default boolean isSet() {
		return !getDelegateList().isEmpty();
	}
	
	public default void unset() {
		getDelegateList().clear();
	}
	
	public default void set(T val) {
		getDelegateList().clear();
		if (val != null) {
			getDelegateList().add(val);
		}
	}
	
	public static void setToValue(List l, Object newValue) {
		if (newValue instanceof Collection) {
			PatchUtil.applyPatch(l,new ArrayList<>((Collection)newValue));
		} else {
			List<?> searchList = new ArrayList<>(l);
			if (searchList.contains(newValue)) {
				int idx = searchList.indexOf(newValue);
				int listsize = searchList.size();
				for (int i = idx+1; i < listsize; ++i) {
					l.remove(idx+1);
				}
				for (int i = 0; i < idx-1; ++i) {
					l.remove(0);
				}
			} else {
				try {
					l.clear();
					if (newValue != null) {
						((List)l).add(newValue);
					}
				} catch (Exception e) {
					throw e;
				}
			}
		}
	}

	public default void setToValue(Object newValue) {
		setToValue(getDelegateList(),newValue);
	}
	
}

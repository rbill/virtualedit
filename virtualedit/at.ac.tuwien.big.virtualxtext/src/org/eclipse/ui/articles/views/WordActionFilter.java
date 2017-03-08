package org.eclipse.ui.articles.views;

import org.eclipse.ui.IActionFilter;

import at.ac.tuwien.big.virtualxtext.ResourceRef;

public class WordActionFilter implements IActionFilter {

	public static final String NAME = "name";
	
	private static WordActionFilter singleton;

	public static WordActionFilter getSingleton() {
		if (singleton == null)
			singleton = new WordActionFilter();
		return singleton;
	}
		
	/**
	 * @see IActionFilter#testAttribute(Object, String, String)
	 */
	public boolean testAttribute(Object target, String name, String value) {
		if (name.equals(NAME)) {
			ResourceRef le = (ResourceRef)target;
			return value.equals(le.toString());
		}	
		return false;
	}
}


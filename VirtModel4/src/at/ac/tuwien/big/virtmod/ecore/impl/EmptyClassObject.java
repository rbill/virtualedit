package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.Collections;
import java.util.Set;

import at.ac.tuwien.big.virtmod.ecore.ClassObject;

public class EmptyClassObject implements ClassObject {

	@Override
	public Set<String> getDirectObjects(String forClass) {
		return Collections.emptySet();
	}

	@Override
	public Set<String> getDirectClasses(String forObject) {
		return Collections.emptySet();
	}

	@Override
	public void addClass(String object, String cl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeClass(String object, String cl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addObject(String object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeObject(String object) {
		throw new UnsupportedOperationException();
	}

}

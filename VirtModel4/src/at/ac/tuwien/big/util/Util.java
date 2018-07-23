package at.ac.tuwien.big.util;

public class Util {
	
	public static<T> T as(Object o, Class<T> cl) {
		if (cl.isInstance(o)) {
			return (T)o;
		}
		throw new RuntimeException("Expected class " + cl.getCanonicalName()+" for "+o+"!");
	}
 
	public static<T> T unsupportedIfNot(T object) {
		if (object == null) {
			new Exception().printStackTrace();
			throw new UnsupportedOperationException("Need existing object for this operation!");
		}
		return object;
	}
	
}

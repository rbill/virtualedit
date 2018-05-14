package at.ac.tuwien.big.vfunc.op;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BasicObjectLoader<U> {

	private Map<String, String> name2ClassMap = new HashMap<>();
	private Map<String, U> name2ObjectMap = new HashMap<>();
	
	public void assign(String name, String fullClass) {
		name2ClassMap.put(name, fullClass);
	}
	
	public U getObject(String name) {
		return name2ObjectMap.computeIfAbsent(name, (nm)->{
			try {
				Class<?> cl = Class.forName(nm);
				Constructor<?> constructor = cl.getConstructor();
				try {
					return (U)constructor.newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				System.err.println("Class "+nm+" not found!");
			}catch (NoSuchMethodException e) {
				System.err.println("Every assigned class must have a no-args constructor");
			} catch (ClassCastException e) {
				System.err.println("Object loader returned wrong class");
			}
			return null;
		});
	}
}

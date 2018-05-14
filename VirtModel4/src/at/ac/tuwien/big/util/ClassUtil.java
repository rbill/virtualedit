package at.ac.tuwien.big.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ClassUtil {

	
	private static Map<Class<?>, Map<Class<?>, Integer>> mapHierarchy = new HashMap<>();
	
	public static Map<Class<?>, Integer> getHierarchy(Class<?> forClass) {
		return mapHierarchy.computeIfAbsent(forClass, x->{
			Map<Class<?>, Integer> totalMap = new HashMap<>();
			totalMap.put(x, 0);
			Class<?> sc = x.getSuperclass();
			if (sc != null)  {
				getHierarchy(sc).forEach((k,v)->totalMap.merge(k, v+1, (v1,v2)->Math.min(v1, v2)));
			}
			for (Class<?> iface: x.getInterfaces()) {
				getHierarchy(iface).forEach((k,v)->totalMap.merge(k, v+1, (v1,v2)->Math.min(v1, v2)));
			}
			return totalMap;
		});
	}
	
	/**Does not check for size, assumes equal*/
	private static int getCosts(List<Class<?>> wantClasses, List<Class<?>> haveClasses)  {
		int ret = 0;
		for (int i = 0; i < wantClasses.size(); ++i) {
			Class<?> have = haveClasses.get(i);
			if (have == null) {continue;}
			Class<?> want = wantClasses.get(i);
			Integer costs = getHierarchy(want).get(have);
			if (costs == null) {
				//Doesn't exist
				return Integer.MAX_VALUE;
			}
			ret+= costs;
		}
		return ret;
	}
	
	public static<U> U getCorrect(Map<List<Class<?>>, U> requiredThings,Object ... initArray) {
		List<Class<?>> myClasses = new ArrayList<>();
		for (int i = 0; i < initArray.length; ++i) {
			myClasses.add(initArray[i] == null?null:initArray[i].getClass());
		}
		U ret = null;
		int bestCosts = Integer.MAX_VALUE;
		for (Entry<List<Class<?>>, U> entr: requiredThings.entrySet()) {
			int costs = getCosts(entr.getKey(), myClasses);
			if (costs < bestCosts)  {
				ret = entr.getValue();
				bestCosts = costs;
			}
		} 
		return ret;
	}
	
	private static Map<Class<?>, Map<List<Class<?>>, Constructor<?>>> classToConstructorsMap = new HashMap<>();
	
	public static Map<List<Class<?>>, Constructor<?>>  getConstructors(Class<?> forClass) {
		return classToConstructorsMap.computeIfAbsent(forClass, (cl)->{
			Map<List<Class<?>>, Constructor<?>> map = new HashMap<>();
			for (Constructor<?> ctr: cl.getConstructors()) {
				List<Class<?>> classList = new ArrayList<>(Arrays.asList(ctr.getParameterTypes()));
				map.put(classList, ctr);
			}
			return map;
		});
	}
	
	public static Object instanciate(Class<?> cl, Object... parameters) {
		Constructor constr = getCorrect(getConstructors(cl), parameters);
		if (constr == null) {
			return null;
		}
		try {
			return constr.newInstance(parameters);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}

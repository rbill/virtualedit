package at.ac.tuwien.big.virtmod.structure;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

public interface VProperty {
	
	public static WeakHashMap<Class<?>, Class<?>[]> proxyClassForClass = new WeakHashMap<>();

	
	public default VListeningProperty toListeningProperty() {
		
		Class<?>[] classlist =  proxyClassForClass.get(getClass());
		if (classlist == null) {
			List<Class<?>> allInt = new ArrayList<>();
			allInt.add(VListeningProperty.class);
			Class<?> cur = getClass();
			while (cur != null) {
				intLoop: for (Class<?> intFace: cur.getInterfaces()) {
					for (Class<?> c: allInt) {
						if (c.isAssignableFrom(intFace)) {
							continue intLoop;
						}
					}
					allInt.add(intFace);
				}
				cur = cur.getSuperclass();
			}
			classlist = allInt.toArray(new Class<?>[]{});
		}
		
		return (VListeningProperty)Proxy.newProxyInstance(getClass().getClassLoader(),
				classlist,
				new InvocationHandler() {
			
					private WeakHashMap<VListener, Boolean> listeners = new WeakHashMap<>();
					
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//TODO: Distribute Listeners based on their capabilities
						if ("addListener".equals(method.getName())) {
							//We have a listener as first argument
							if (args[0] == null) {
								new Exception().printStackTrace();
								System.out.println("Adding null listener?!");
							} else {
								System.out.println("Adding non-null listener: " + args[0]);
							}
							listeners.put((VListener)args[0], true);
							return null;
						}
						if ("removeListeners".equals(method.getName())) {
							VObject obj = (VObject)args[0];
							listeners.keySet().removeIf((x)->{
								if (Objects.equals(x.getContainingObject(),obj)) {
									x.destroy();
									return true;
								}
								return false;
							});
							return null;
						}
						if (args == null) {
							args = new Object[]{};
						}
						if (method.getName().startsWith("get")) {
							Object ret = method.invoke(VProperty.this, args);
							return ret;
						}
						List<Class<?>> allClasses = new ArrayList<Class<?>>(args.length+1);
						allClasses.add(VProperty.this.getClass());
						allClasses.addAll(Arrays.asList(method.getParameterTypes()));
						Class<?>[] allClassAr = allClasses.toArray(new Class<?>[]{});
						for (VListener before: listeners.keySet()) {
							if (before != null) {	
								try {
									Method callMethod = before.getClass().getMethod("onbefore"+method.getName(),
										allClassAr);
									Object[] fullArgs = new Object[args.length+1];
									fullArgs[0] = VProperty.this;
									for (int i = 0; i < args.length; ++i) {
										fullArgs[i+1] = args[i];
									}
									if (callMethod != null) {
										callMethod.invoke(before, fullArgs);
									}
								} catch (NoSuchMethodException e) {
									//This may happen, just ignore it
								} catch (Exception e) {
									System.err.println(e.getMessage());
									e.printStackTrace();
								}
								try {
									Method callMethod = before.getClass().getMethod("onbeforechange");
									if (callMethod != null) {
										callMethod.invoke(before, VProperty.this);
									}
								} catch (NoSuchMethodException e) {
									//This may happen, just ignore it
								} catch (Exception e) {
									System.err.println(e.getMessage());
									e.printStackTrace();
								}
							} 
						}
						Object ret = method.invoke(VProperty.this, args);
						for (VListener after: listeners.keySet()) {
							if (after != null) {	
								try {
									Method callMethod = after.getClass().getMethod("on"+method.getName(),
											allClassAr);
									Object[] fullArgs = new Object[args.length+1];
									fullArgs[0] = VProperty.this;
									for (int i = 0; i < args.length; ++i) {
										fullArgs[i+1] = args[i];
									}
									if (callMethod != null) {
										callMethod.invoke(after, fullArgs);
									}
								} catch (NoSuchMethodException e) {
									//This may happen, just ignore it
								} catch (Exception e) {
									System.err.println(e.getMessage());
									e.printStackTrace();
								}
								try {
									Method callMethod = after.getClass().getMethod("onchange");
									if (callMethod != null) {
										callMethod.invoke(after, VProperty.this);
									}
								} catch (NoSuchMethodException e) {
									//This may happen, just ignore it
								} catch (Exception e) {
									System.err.println(e.getMessage());
									e.printStackTrace();
								}
							} 
						}
						return ret;
					}
				});
	}
}

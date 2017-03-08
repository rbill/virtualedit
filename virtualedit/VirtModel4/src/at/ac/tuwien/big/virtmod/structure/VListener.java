package at.ac.tuwien.big.virtmod.structure;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public interface VListener {
	
	public VObject getContainingObject();
	
	public static class SingleMethodInfo {
		public SingleMethodInfo(MethodHandle handle, boolean addOpId, boolean removeOpId) {
			this.handle = handle;
			this.addOpId = addOpId;
			this.removeOpId = removeOpId;
		}
		
		public final MethodHandle handle;
		public final boolean addOpId;
		public final boolean removeOpId;
	}
	
	public static class MethodInfo {
		public final Map<Method, SingleMethodInfo> mainmap = new HashMap<>();
		public final Map<Method, MethodHandle> map = new HashMap<>();
		private boolean useOpId;
		private boolean useSingleMethodInfo;
	}
	
	public static final Map<Class<?>, Map<Class<?>, MethodInfo>> fromToMap = new HashMap<>();
	
	public static MethodInfo getMap(Class<?> from, Class<?> to) {
		synchronized(VListener.class) {
			Map<Class<?>, MethodInfo> toMap = fromToMap.get(from);
			if (toMap == null) {
				fromToMap.put(from,  toMap = new HashMap<>());
			}
			MethodInfo returnInfo= toMap.get(to);
			if (returnInfo == null) {
				toMap.put(to, returnInfo = new MethodInfo());
				Map<Method,MethodHandle> returnMap = returnInfo.map;
				Map<Method,SingleMethodInfo> returnInfoMap = returnInfo.mainmap;
				for (Method wantMethod:  to.getMethods()) {
					if (!wantMethod.getName().startsWith("on") || wantMethod.getParameterCount() < 1 ||
							!VProperty.class.isAssignableFrom(wantMethod.getParameters()[0].getType())) {
						continue;
					}
					try {
						boolean haveOpId = false;
						boolean mayWantOpId = wantMethod.getParameterCount()>1 && wantMethod.getParameters()[1].getType() == long.class;
						MethodHandle handle = null;
						Method haveMethod = null;
						Method haveMethodWithAdditionalLong = null;
						Method haveMethodWithoutAdditionalLong = null;
						try {
							haveMethod = from.getMethod(wantMethod.getName(), wantMethod.getParameterTypes());
						} catch (NoSuchMethodException e) {
							
						}
						if (mayWantOpId) {
							//Without opid;
							Class<?>[] typesWithOpid = wantMethod.getParameterTypes();
							Class<?>[] typesWithoutOpid = new Class<?>[typesWithOpid.length-1];
							typesWithoutOpid[0] = typesWithOpid[0];
							for (int i = 2; i < typesWithOpid.length; ++i) {
								typesWithoutOpid[i-1] = typesWithOpid[i];
							}
							try {
								haveMethodWithoutAdditionalLong = from.getMethod(wantMethod.getName(), typesWithoutOpid);
							} catch (NoSuchMethodException e) {
								
							}
							/*if (!"$opid".equals(haveMethodDifferentOpId.getParameters()[1].getName())) {
								haveMethod = null;
							}*/
						} 
						{
							//With opid;
							Class<?>[] typesWithNoOpid = wantMethod.getParameterTypes();
							Class<?>[] typesWithAdditionalOpid = new Class<?>[typesWithNoOpid.length+1];
							typesWithAdditionalOpid[0] = typesWithNoOpid[0];
							typesWithAdditionalOpid[1] = long.class;
							for (int i = 1; i < typesWithNoOpid.length; ++i) {
								typesWithAdditionalOpid[i+1] = typesWithNoOpid[i];
							}
							try {
								haveMethodWithAdditionalLong = from.getMethod(wantMethod.getName(), typesWithAdditionalOpid);
								//Unfortunately names are deleted ...
								/*if (!"$opid".equals(haveMethodDifferentOpId.getParameters()[1].getName())) {
									System.out.println("ParmeterName: "+haveMethodDifferentOpId.getParameters()[1].getName());
									
									haveMethodDifferentOpId = null;
								}*/
							} catch (NoSuchMethodException e) {
								
							}
						}
						
						if (haveMethod != null) {
							//Everything fine ...
							haveMethod.setAccessible(true);
							handle = MethodHandles.lookup().unreflect(haveMethod);
						}
						
						boolean needRemoveOpId = false;
						
						if (handle == null && haveMethodWithoutAdditionalLong != null) {
							haveMethodWithoutAdditionalLong.setAccessible(true);
							needRemoveOpId = true;
							handle = MethodHandles.lookup().unreflect(haveMethodWithoutAdditionalLong);
						}

						boolean needAddOpId = false;
						if (handle == null && haveMethodWithAdditionalLong != null) {
							haveMethodWithAdditionalLong.setAccessible(true);
							needAddOpId = true;
							handle = MethodHandles.lookup().unreflect(haveMethodWithAdditionalLong);
						}
						
						
						
						if (handle != null) {
							returnMap.put(wantMethod, handle);
							returnInfoMap.put(wantMethod, new SingleMethodInfo(handle, needAddOpId, needRemoveOpId));
							returnInfo.useOpId|= needAddOpId;
							returnInfo.useSingleMethodInfo|= needRemoveOpId || needAddOpId;
						}						
					}  catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			return returnInfo;
		}
	}
	
	public static class SimpleInvocationHandler implements InvocationHandler {
		protected VListener This;
		
		public SimpleInvocationHandler(VListener This, MethodInfo info) {
			this.This = This;
			methodHandles = info;
		}
		
		protected MethodInfo methodHandles; 
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if ("destroy".equals(method) || "getContainingObject".equals(method)  || method.getDeclaringClass() == Object.class) {
				return method.invoke(This,args);
			}
			MethodHandle handle = methodHandles.map.get(method);
			if (handle != null) {
				if (args == null) {
					return handle.invokeWithArguments(This);
				} else {
					Object[] complete = new Object[args.length+1];
					complete[0] = This;
					for (int i = 0; i <args.length; ++i) {
						complete[i+1] = args[i];
					}
					return handle.invokeWithArguments(complete);
				}
				
			}
			return null;
		}
	}
	
	public static class SingleMethodInvocationHandler extends SimpleInvocationHandler {
		
		public SingleMethodInvocationHandler(VListener This, MethodInfo info) {
			super(This, info);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if ("destroy".equals(method) || "getContainingObject".equals(method)  || method.getDeclaringClass() == Object.class) {
				return method.invoke(This,args);
			}
			SingleMethodInfo handleInfo = methodHandles.mainmap.get(method);
			if (handleInfo != null) {
				return invokeWith(handleInfo, This, args);
			}
			return null;
		}
		
		public Object invokeWith(SingleMethodInfo handleInfo, Object proxy, Object[] args) throws Throwable {
			if (args == null) {
				return handleInfo.handle.invokeWithArguments(This);
			} else {
				Object[] complete = new Object[handleInfo.removeOpId?args.length:args.length+1];
				complete[0] = This;
				complete[1] = args[1];
				if (handleInfo.removeOpId) {
					for (int i = 2; i <args.length; ++i) {
						complete[i] = args[i];
					}
				} else {
					for (int i = 1; i <args.length; ++i) {
						complete[i+1] = args[i];
					}
				}						
				return handleInfo.handle.invokeWithArguments(complete);
				
			}
		}
	}
	
	public static class OpIdMethodInvocationHandler extends SingleMethodInvocationHandler {
		
		private long $opid;
		
		public synchronized long $advopid() {
			return $opid++;
		}
		
		public OpIdMethodInvocationHandler(VListener This, MethodInfo info) {
			super(This, info);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if ("destroy".equals(method) || "getContainingObject".equals(method) || method.getDeclaringClass() == Object.class) {
				return method.invoke(This,args);
			}
			SingleMethodInfo handleInfo = methodHandles.mainmap.get(method);
			if (handleInfo != null) {
				if (!handleInfo.addOpId) {
					return super.invokeWith(handleInfo, This, args);
				}

				long opid = $advopid();
				if (args == null) {
					return handleInfo.handle.invokeWithArguments(This,opid);
				} else {
					Object[] complete = new Object[args.length+2];
					complete[0] = This;
					complete[1] = args[0];
					complete[2] = opid;
					for (int i = 1; i <args.length; ++i) {
						complete[i+2] = args[i];
					}					
					return handleInfo.handle.invokeWithArguments(complete);
					
				}
				
			}
			return null;
		}
	}
	
	public default<L> L fullyImplement(Class<L> l) {
		if (l.isAssignableFrom(getClass())) {
			return (L)this;
		}
		MethodInfo info = getMap(getClass(), l);
		if (info.useOpId) {
			return (L)Proxy.newProxyInstance(getClass().getClassLoader(),
					new Class[]{l}, new OpIdMethodInvocationHandler(this, info));
		} else if (info.useSingleMethodInfo) {
			return (L)Proxy.newProxyInstance(getClass().getClassLoader(),
					new Class[]{l}, new SingleMethodInvocationHandler(this, info));
		} else {
			return (L)Proxy.newProxyInstance(getClass().getClassLoader(),
					new Class[]{l}, new SimpleInvocationHandler(this, info));
		}
		
	}

	public void destroy();

}

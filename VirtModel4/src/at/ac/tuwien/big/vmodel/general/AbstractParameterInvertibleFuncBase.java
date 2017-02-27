package at.ac.tuwien.big.vmodel.general;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;

import at.ac.tuwien.big.virtmod.basic.Editstate;
import at.ac.tuwien.big.virtmod.structure.GlobalSource;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.vmodel.general.OwnedFunc.OnCreatedListener;
import at.ac.tuwien.big.vmodel.general.impl.FakeEntry;
import at.tuwien.big.virtmod.datatype.IteratorUtils;

public interface AbstractParameterInvertibleFuncBase<X, Y, Z extends StaticElement,F extends VEntryIterableFunc<X,? extends VEntryIterableFunc<Y,Z>>> extends ParameterInvertibleFunc<X, Y, Z>, 
	DelegatingFunc<F,X,VEntryIterableFunc<Y,Z>> {
	
	
	public default ParameterInvertibleFunc<Y,X,Z> parameterInvert() {
		return new ParameterInvertibleFunc<Y, X, Z>() {
			
			public String toString() {
				return "Inverse of ("+String.valueOf(AbstractParameterInvertibleFuncBase.this)+")";
			}

			@Override
			public Iterable<? extends Entry<? extends Y, ? extends VEntryIterableFunc<X, Z>>> getEntries() {
				Iterable<Entry<Y,VEntryIterableFunc<X, Z>>> ret = 
						()->new Iterator<Entry<Y,VEntryIterableFunc<X,Z>>>() {
							
							Iterator<? extends Entry<? extends X, ? extends VEntryIterableFunc<Y,Z>>> biter = base1Func().getEntries().iterator();
							Y next = null;
							Set<Y> haveReturned = new HashSet<>();
							VEntryIterableFunc<Y,Z> cur = null;
							Iterator<? extends Y> curKeys = null;

							@Override
							public boolean hasNext() {
								mainLoop: while (next == null) {
									while (curKeys == null || !curKeys.hasNext()) {
										if (!biter.hasNext()) {
											return false;
										}
										curKeys = biter.next().getValue().getKeys().iterator();
									}
									while (curKeys.hasNext()) {
										Y next = curKeys.next();
										if (next != null && haveReturned.add(next)) {
											this.next = next;
											break mainLoop;
										}
									}
								}
								return next != null;
							}

							@Override
							public Entry<Y, VEntryIterableFunc<X, Z>> next() {
								if (hasNext()) {
									try {
										Y nextRet = next;
										return new FakeEntry<>(next, get(nextRet));
									} finally {
										next = null;
									}
								}
								throw new NoSuchElementException();
							}
				};
				return ret;
			}

			@Override
			public VEntryIterableFunc<X, Z> get(Y y) {
				return new VEntryIterableFunc<X,Z>() {

					public String toString() {
						return "Inverse of " + String.valueOf(AbstractParameterInvertibleFuncBase.this);
					}
					
					@Override
					public Z get(X x2) {
						return AbstractParameterInvertibleFuncBase.this.get(x2).get(y);
					}

					@Override
					public boolean isSelfEmpty() {
						return false;
					}

					@Override
					public boolean selfClear() {
						return false;
					}

					@Override
					public Editstate getEditState() {
						return AbstractParameterInvertibleFuncBase.this.getEditState();
					}

					@Override
					public VContainer store() {
						return AbstractParameterInvertibleFuncBase.this.store();
					}

					@Override
					public void destroy() {
					}

					@Override
					public Iterable<? extends Entry<? extends X, ? extends Z>> getEntries() {
						return IteratorUtils.convert(AbstractParameterInvertibleFuncBase.this.getEntries(),(x)->new FakeEntry<>(x.getKey(),
								get(x.getKey())));
					}
					
				};
			}

			@Override
			public boolean isSelfEmpty() {
				return AbstractParameterInvertibleFuncBase.this.isSelfEmpty();
			}

			@Override
			public boolean selfClear() {
				return AbstractParameterInvertibleFuncBase.this.selfClear();
			}

			@Override
			public Editstate getEditState() {
				return AbstractParameterInvertibleFuncBase.this.getEditState();
			}

			@Override
			public VContainer store() {
				return AbstractParameterInvertibleFuncBase.this.store();
			}

			@Override
			public void destroy() {				
			}

			@Override
			public Z get(Y x, X y) {
				return AbstractParameterInvertibleFuncBase.this.get(y,x);
			}

			@Override
			public ParameterInvertibleFunc<X, Y, Z> parameterInvert() {
				return AbstractParameterInvertibleFuncBase.this;
			}
		};
		
	};
	
	public static Class<?>[] getInterfaces(Class<?> cl) {
		Class<?> [] retAr = interfaces.get(cl);
		if (retAr == null) {
			Class<?> fcl = cl;
			List<Class<?>> ret = new ArrayList<>();
			Set<Class<?>> cls = new HashSet<>();
			//ret.add(cl);
			cls.add(cl);
			while (cl != null) {
				for (Class<?> iface: cl.getInterfaces()) {
					if (cls.add(iface)) {
						ret.add(iface);
					}
				}
				cl = cl.getSuperclass();
			}
			
			interfaces.put(fcl, retAr = ret.toArray(new Class<?>[ret.size()]));
		}
		return retAr;
	}
/*	
	public default <A,B,R extends VFunc<? super B,? extends Z>, S extends VFunc<? super A,? extends Z>>
		ParameterInvertibleFunc<A, B, Z, R, S> rebase(R firstBase, S secondBase) {
		AbstractParameterInvertibleFuncBase<X, Y, Z, K, L> $This = this;
		Class<?>[] ifaces = getInterfaces(this.getClass()); 
		ParameterInvertibleFunc[] both = new ParameterInvertibleFunc[2];
		
		both[0] = (ParameterInvertibleFunc<A, B, Z, R, S>) Proxy.newProxyInstance(getClass().getClassLoader(),
				ifaces, new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (args.length == 0) {
							if ("base1Func".equals(method.getName())) {
								return firstBase;
							} else if ("base2Func".equals(method.getName())) {
								return secondBase;
							} else if ("parameterInvert".equals(method.getName())) {
								return both[1];
							}
						}
						Lookup lookup = MethodHandles.lookup();
						MethodHandle handle = lookup.findVirtual($This.getClass(), method.getName(), MethodType.methodType(method.getReturnType(),method.getParameterTypes()));
						return handle.bindTo(proxy).invoke(args);
					}
				});
		both[1] = (ParameterInvertibleFunc<A, B, Z, R, S>) Proxy.newProxyInstance(getClass().getClassLoader(),
				ifaces, new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (args.length == 0) {
							if ("base1Func".equals(method.getName())) {
								return secondBase;
							} else if ("base2Func".equals(method.getName())) {
								return firstBase;
							} else if ("parameterInvert".equals(method.getName())) {
								return both[0];
							}
						}
						Lookup lookup = MethodHandles.lookup();
						MethodHandle handle = lookup.findVirtual($This.getClass(), method.getName(), MethodType.methodType(method.getReturnType(),method.getParameterTypes()));
						return handle.bindTo(proxy).invoke(args);
					}
				});
		return both[0];
	}
	
	public static WeakHashMap<Object, ParameterInvertibleFunc> invertedFuncs = new WeakHashMap<Object, ParameterInvertibleFunc>();*/

	/*@Override
	public default ParameterInvertibleFunc<Y, X, Z, L, K> parameterInvert() {
		ParameterInvertibleFunc ret = invertedFuncs.get(this);
		AbstractParameterInvertibleFuncBase<X, Y, Z, K, L> $This = this;
		Class<?>[] ifaces = getInterfaces(this.getClass()); 
		if (ret == null) {
			invertedFuncs.put(this, ret = (ParameterInvertibleFunc) Proxy.newProxyInstance(getClass().getClassLoader(),
				ifaces, new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (args.length == 0) {
							if ("base1Func".equals(method.getName())) {
								return $This.base2Func();
							} else if ("base2Func".equals(method.getName())) {
								return $This.base1Func();
							} else if ("parameterInvert".equals(method.getName())) {
								return $This;
							}
						}
						Lookup lookup = MethodHandles.lookup();
						MethodHandle handle = lookup.findVirtual($This.getClass(), method.getName(), MethodType.methodType(method.getReturnType(),method.getParameterTypes()));
						return handle.bindTo(proxy).invoke(args);
					}
				}));
		}
		return ret;
	}*/
	

/*
	@Override
	public default K get(X x) {
		//Stimmt auch hier nicht ... 
		OwnedFunc<Y, Z> base = base1Func().get(x);
		Class<?>[] interfaces = getInterfaces(base.getClass());
		return (K)Proxy.newProxyInstance(getClass().getClassLoader(), interfaces, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (method.getName().equals("get") && args.length == 1) {
					Z ret = base.getOrNull((Y)args[0]);
					if (ret == null) {
						base.set((Y)args[0], ret = base2Func().get((Y)args[0]).get(x));
					}
					return ret;
				}
				return method.invoke(base, args);
			}
		});
	}*/
}

package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import VObjectModel.Identifier;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicMapFunc;
import at.ac.tuwien.big.vfunc.nbasic.FunctionListWrapper;
import at.ac.tuwien.big.vfunc.nbasic.ecore.BasicCache.CacheType;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.TreePosList;
import at.ac.tuwien.big.vfunc.wrapper.BasicListWrapper;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;

public class SingleVMEObject extends AbstractVMEObject {

	private Map<EStructuralFeature, AttributeHandler<?>> attributeHandlers = new HashMap<>();
	private WeakHashMap<TreePosList<?>, BasicListenable> handlers = new WeakHashMap<>();
	private EClass myClass;

	public List<ContainmentThing> containments = new ArrayList<>();

	public SingleVMEObject(EObjectManager manager, Identifier id, EClass eclass) {
		super(manager, id);
		this.myClass = eclass;
	}

	/** Requirement: feature.isMany() */
	public <T> void setBasicFeature(EStructuralFeature feature, List<T> objectList) {
		BasicMapFunc<Treepos, T> bmf = new BasicMapFunc<>(Treepos.class);
		TreePosList<T> tpl = new TreePosList<>(bmf);
		ListSynchronizer<T> synchronizer = new ListSynchronizer<T>(tpl, objectList);
		synchronizer.synchronize();
		BasicListenable src = new BasicListenable() {

			@Override
			public void changed(BasicChangeNotifyer bcm) {
				synchronizer.reverseSynchronize();
			}
		};
		tpl.addBasicChangeListener(src);
		handlers.put(tpl, src);
		MultiAttributeHandler<T> ah = new BasicListAttributeHandler<T, T>(tpl);
		setBasicFeature(feature, ah);
	}

	public <T, U> void setBasicSingletonFeature(EStructuralFeature myFeature, EObject otherObject,
			EStructuralFeature otherFeature, Function<T, U> convertThere, Function<U, T> convertBack) {
		if (otherFeature.isMany()) {
			List<U> list = (List<U>) otherObject.eGet(otherFeature);
			MultiAttributeHandler<T> handler = new BasicListAttributeHandler(list, convertThere, convertBack);
			setBasicFeature(myFeature, handler);
		} else {
			if (myFeature.isMany()) {
				System.err.println("Cannot convert a single-feature to a multi-feature!");
			} else {
				SingleESFAttributeHandler<T, U> handler = new SingleESFAttributeHandler<T, U>(otherObject, otherFeature,
						convertBack, convertThere);
				setBasicFeature(myFeature, handler);
			}
		}
	}

	private static <T> AttributeHandler<T> wrapFor(EStructuralFeature feature, MultiAttributeHandler<T> ah) {
		if (feature.isMany()) {
			return ah;
		} else {
			return new MultiSingleAttributeHandler<>(ah);
		}
	}

	public void setBasicSingletonFeature(EStructuralFeature feature, Object value) {
		BasicMapFunc<Treepos, Object> bmf = new BasicMapFunc<Treepos, Object>(Treepos.class);
		MultiAttributeHandler multiHandler = FunctionMultiAttributeHandler.getTreeposHandler(bmf);
		AttributeHandler handler;
		if (feature.isMany()) {
			handler = multiHandler;
			multiHandler.setSingle(value);
		} else {
			MultiSingleAttributeHandler shandler = new MultiSingleAttributeHandler<>(multiHandler);
			handler = shandler;
			shandler.set(value);
		}
		setBasicFeature(feature, handler);
	}

	/* Requirement: feature.isMany() */
	public void setBasicFeature(EStructuralFeature feature, AbstractFunc<Treepos, ?, ?> func) {
		FunctionMultiAttributeHandler<Treepos, ?> treeposHandler = FunctionMultiAttributeHandler
				.getTreeposHandler(func);
		setBasicFeature(feature, treeposHandler);
	}

	public void setBasicFeature(EStructuralFeature feature, MultiAttributeHandler<?> handler) {
		setBasicFeature(feature, wrapFor(feature, handler));
	}

	public void setBasicFeature(EStructuralFeature feature, AttributeHandler<?> handler) {
		attributeHandlers.put(feature, handler);
		if (feature instanceof EReference) {
			EReference ref = (EReference)feature;
			handler.addLocalBasicChangeListener(
					new BasicListenable() {
						
						List<Object> lastList = new ArrayList<>();
						
						@Override
						public void changed(BasicChangeNotifyer bcm) {
							List<Object> remaining = new ArrayList<>();
							List<Object> missing = new ArrayList<>();
							for (Object obj: handler.readOnlyValues()) {
								if (!remaining.remove(obj)) {
									missing.add(obj);
								}
							}
							if (!remaining.isEmpty()  || !missing.isEmpty()) {
								//Remove remaining
								remaining.forEach(x->{
									if (x instanceof SingleVMEObject) {
										SingleVMEObject svo = (SingleVMEObject)x;
										svo.containments.remove(new ContainmentThing(SingleVMEObject.this, ref));
									} else {
										System.err.println("Cannot remove containment from "+x+"!");
									}
								});
								
								//Add for each missing
								missing.forEach(x->{
									if (x instanceof SingleVMEObject) {
										SingleVMEObject svo = (SingleVMEObject)x;
										svo.containments.add(new ContainmentThing(SingleVMEObject.this, ref));
									} else {
										System.err.println("Cannot add containment to "+x+"!");
									}
								});
							}
						}
					}
					);
		}
	}

	@Override
	public EClass eClass() {
		return myClass;
	}

	@Override
	public EObject eContainer() {
		for (ContainmentThing thing: containments) {
			return thing.container;
		}
		return null;
	}

	@Override
	public InternalEObject eInternalContainer() {
		for (ContainmentThing thing: containments) {
			return (InternalEObject)thing.container;
		}
		return null;
	}

	@Override
	public int eContainerFeatureID() {
		EReference ref = eContainmentFeature();
		if (ref == null) {
			return -1;
		}
		return ref.getFeatureID();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		for (ContainmentThing thing: containments) {
			return thing.containmentFeature;
		}
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		for (ContainmentThing thing: containments) {
			return thing.containmentFeature;
		}
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		AttributeHandler<?> handler = attributeHandlers.get(feature);
		if (handler == null) {
			return feature.isMany() ? Collections.emptyList() : null;
		}
		return handler.getObject();
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return eGet(feature);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {

		AttributeHandler<?> handler = attributeHandlers.get(feature);
		if (handler instanceof SingleAttributeHandler) {
			((SingleAttributeHandler) handler).set(newValue);
		} else if (handler instanceof MultiAttributeHandler) {
			MultiAttributeHandler mah = (MultiAttributeHandler) handler;
			if (newValue instanceof Collection) {
				((MultiAttributeHandler) handler).setValues((Collection) newValue);
			} else {
				System.err.println("Expected collection instead of " + newValue + " for " + feature.getName() + "!");
			}
		} else if (handler != null) {
			System.err.println("Wrong handler for " + feature.getName() + ": " + hashCode());
		}

	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		AttributeHandler<?> handler = attributeHandlers.get(feature);
		if (handler != null) {
			return handler.isSet();
		}
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		AttributeHandler<?> handler = attributeHandlers.get(feature);
		if (handler != null) {
			handler.unset();
		}

	}

}

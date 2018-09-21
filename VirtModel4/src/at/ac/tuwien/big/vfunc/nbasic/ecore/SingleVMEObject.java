package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
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
import VObjectModel.JavaValue;
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
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;

public class SingleVMEObject extends AbstractVMEObject {


	private Map<EStructuralFeature, AttributeHandler<?>> attributeHandlers = new HashMap<>();
	private WeakHashMap<TreePosList<?>, BasicListenable> handlers = new WeakHashMap<>();
 
	private EClass myClass;

	public SingleVMEObject(EObjectManager manager, EObjectCreator creator, Identifier id, EClass eclass) {
		super(manager, creator, id, Arrays.asList(((JavaValue)id.getIdentifierreforcmp().get(0)).getValue()));
		this.myClass = eclass;
	}

	@Override
	public EClass eClass() {
		return this.myClass;
	}

	@Override
	public AttributeHandler<?> getHandler(EStructuralFeature feature) {
		return this.attributeHandlers.get(feature);
	}

	/* Requirement: feature.isMany() */
	public void setBasicFeature(EStructuralFeature feature, AbstractFunc<Treepos, ?, ?> func) {
		FunctionMultiAttributeHandler<Treepos, ?> treeposHandler = FunctionMultiAttributeHandler
				.getTreeposHandler(func);
		setBasicFeature(feature, treeposHandler);
	}
	
	public void setBasicFeature(EStructuralFeature feature, AttributeHandler<?> handler) {
		this.attributeHandlers.put(feature, handler);
		if (feature instanceof EReference) {
			EReference ref = (EReference)feature;
			if (ref.isContainment()) {
				BasicListenable bl = new BasicListenable() {
					
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
				};
			handler.addLocalBasicChangeListener(
					bl
					);
			//Initial processing
			bl.changed(handler);
			}
		}
	}
	/** Requirement: feature.isMany() */
	public <T> void setBasicFeature(EStructuralFeature feature, List<T> objectList) {
		BasicMapFunc<Treepos, T> bmf = new BasicMapFunc<>(Treepos.class);
		TreePosList<T> tpl = new TreePosList<>(bmf);
		ListSynchronizer<T> synchronizer = new ListSynchronizer<>(tpl, objectList);
		synchronizer.synchronize();
		BasicListenable src = new BasicListenable() {

			@Override
			public void changed(BasicChangeNotifyer bcm) {
				synchronizer.reverseSynchronize();
			}
		};
		tpl.addBasicChangeListener(src);
		this.handlers.put(tpl, src);
		MultiAttributeHandler<T> ah = new BasicListAttributeHandler<T, T>(tpl);
		setBasicFeature(feature, ah);
	}

	public void setBasicFeature(EStructuralFeature feature, MultiAttributeHandler<?> handler) {
		setBasicFeature(feature, wrapFor(feature, handler));
	}
	
	
	public <T, U> void setBasicSingletonFeature(EStructuralFeature myFeature, EObject otherObject,
			EStructuralFeature otherFeature) {
		if (otherFeature instanceof EReference) {
			//You need to convert them
			setBasicSingletonFeature(myFeature, otherObject, otherFeature, this.convertToVirtual, this.convertFromVirtual);
		} else {
			//Don't need to convert them as they are values
			setBasicSingletonFeature(myFeature, otherObject, otherFeature, BasicListAttributeHandler.IDENTIY(), BasicListAttributeHandler.IDENTIY());
		}
	}

	private <T, U> void setBasicSingletonFeature(EStructuralFeature myFeature, EObject otherObject,
			EStructuralFeature otherFeature, Function<T, U> convertThere, Function<U, T> convertBack) {
		if (otherFeature.isMany()) {
			List<U> list = (List<U>) otherObject.eGet(otherFeature);
			MultiAttributeHandler<T> handler = new BasicListAttributeHandler(list, convertThere, convertBack);
			List<T> changedList = handler.exposeList();
			setBasicFeature(myFeature, changedList);
		} else {
			
			BasicMapFunc<Treepos, T> bmf = new BasicMapFunc<>(Treepos.class);
			TreePosList<T> tpl = new TreePosList<>(bmf);
			SingleESFAttributeHandler<T, U> attrHandler = new SingleESFAttributeHandler<>(otherObject, otherFeature, convertBack, convertThere);
			BasicListenable src = new BasicListenable() {

				@Override
				public void changed(BasicChangeNotifyer bcm) {
					if (tpl.isEmpty()) {
						attrHandler.unset();
					} else {
						attrHandler.set(tpl.get(0));
					}
				}
			};
			PatchUtil.applyPatch(tpl, new ArrayList<>(attrHandler.readOnlyValues()));
			tpl.addBasicChangeListener(src);
			this.handlers.put(tpl, src);
			MultiAttributeHandler<T> ah = new BasicListAttributeHandler<T, T>(tpl);
			setBasicFeature(myFeature, ah);
		}
	}
	
	public void setBasicSingletonFeature(EStructuralFeature feature, Object value) {
		BasicMapFunc<Treepos, Object> bmf = new BasicMapFunc<>(Treepos.class);
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
	
	public void setEClass(EClass grade2) {
		this.myClass = grade2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getIdentificator()+":\n");
		TreeSet<EStructuralFeature> fSet = new TreeSet<>((x,y)->{
			return (x.getEContainingClass().getName()+"."+x.getName()).compareTo(
					y.getEContainingClass().getName()+"."+y.getName()
					);
			
		});
		fSet.addAll(this.attributeHandlers.keySet());
		fSet.forEach(x->{
			builder.append("\t"+x.getEContainingClass().getName()+"."+x.getName()+": ");
			builder.append(printFeatureValues(x));
			builder.append("\n");
		});
		return builder.toString();
	}

}

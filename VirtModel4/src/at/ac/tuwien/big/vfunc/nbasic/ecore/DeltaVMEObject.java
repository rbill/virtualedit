package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.Serializable;
import java.util.ArrayList;
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

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vfunc.basic.impl.BasicUnionScope;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicDeltaFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicDerivationReason;
import at.ac.tuwien.big.vfunc.nbasic.BasicFiniteUnionFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicMapFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicMetaInfo;
import at.ac.tuwien.big.vfunc.nbasic.DeltaVMEObjectStore;
import at.ac.tuwien.big.vfunc.nbasic.DeltaVMEObjectStore.DeltaStoreInfo;
import at.ac.tuwien.big.vfunc.nbasic.FunctionListWrapper;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;
import at.ac.tuwien.big.vfunc.nbasic.ecore.BasicCache.CacheType;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatus;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.TreePosList;
import at.ac.tuwien.big.vfunc.wrapper.BasicListWrapper;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.TreeposList;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleEditState;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;

public class DeltaVMEObject extends AbstractVMEObject {

	private static class DeltaInfo<T> {
		BasicFiniteUnionFunc<Treepos, T> unionFunc;
		BasicDeltaFunc<Treepos, T> deltaFunc;
		MultiAttributeHandler<T> multiHandler;
		AttributeHandler<T,?> attributeHandler;
		
		public void clear() {
			if (this.deltaFunc != null) {
				this.deltaFunc.clearCustom();
			}
		}

		public void mergeFrom(DeltaInfo<T> di) {
			this.deltaFunc.mergeDelta(di.deltaFunc);
		}
	}
	private static<T> BasicMapFunc<Treepos, T> getBasicMapFunc(boolean isDerived) {
		BasicMapFunc<Treepos, T> bmf = new BasicMapFunc<>(Treepos.class);
		if (isDerived) {
			bmf.setBasicMetaInfoCreater((src)->new BasicMetaInfo(new BasicDerivationReason(DerivationStatus.DERIVED)));
		}
		return bmf;
	}
	
	private DeltaVMEObjectStore store;
	
	private Map<EStructuralFeature, DeltaInfo<?>> attributeHandlerInfos = new HashMap<>();
	
	
	
	private WeakHashMap<TreePosList<?>, BasicListenable> handlers = new WeakHashMap<>();
	
	private EClass myClass;

	private Function<EObject, Identifier> convertToIdentifier = (eobj)->{
		if (eobj  instanceof VMEObject) {
			return ((VMEObject)eobj).getIdentificator();
		}
		return getManager().getFakeVirtual(eobj).getIdentificator();
	};

	private Function<Identifier, EObject> convertFromIdentifierToNormal = (id)->{
		EObject ret = getManager().getObject(id);
		if (ret instanceof VMEObject) {
			return getManager().getInvVirtual((VMEObject)ret);
		}
		return ret;
	};
	private Function<Identifier, EObject> convertFromIdentifier = (id)->{
		EObject ret = getManager().getObject(id);
		return ret;
	};

	public DeltaVMEObject(EObjectManager manager, EObjectCreator creator, Identifier id, EClass eclass, DeltaVMEObjectStore store, List<?> parameters) {
		super(manager, creator, id, parameters);
		this.myClass = eclass;
		this.store = store;
	}

	public DeltaVMEObject(EObjectManager manager, EObjectCreator creator, Identifier id, EClass eclass, List<?> parameters) {
		this(manager,creator,id,eclass,manager.getDeltaStore(id), parameters);
	}

	public void addBaseFunction(EStructuralFeature feat, AbstractFunc<Treepos, ?, ?> func) {
		DeltaInfo<?> info = getDeltaInfo(feat);
		((BasicFiniteUnionFunc)info.unionFunc).addBase(func);
	}

	/* Requirement: feature.isMany() */
	public void addBasicFeature(EStructuralFeature feature, AbstractFunc<Treepos, ?, ?> func) {
		addBaseFunction(feature, func);
		
	}
	
	public <T> void addBasicFeature(EStructuralFeature feature, List<T> objectList, boolean isDerived) {
		int prefix = getCurPrefix(feature);
		addBasicFeature(feature, objectList, prefix, isDerived);
	}
	
	/** Requirement: feature.isMany() */
	public <T> void addBasicFeature(EStructuralFeature feature, List<T> objectList, int prefix, boolean isDerived) {
		BasicMapFunc<Treepos, T> bmf = getBasicMapFunc(isDerived);
		TreePosList<T> tpl = (prefix==0)?new TreePosList(bmf):new TreePosList<>(bmf, prefix);
		ListSynchronizer<?,?> synchronizer; 
		if (feature instanceof EReference) {
			synchronizer = new ListSynchronizer(tpl, objectList,  this.convertFromIdentifier, this.convertToIdentifier);
		} else {
			synchronizer = new ListSynchronizer<>(tpl, objectList, BasicListAttributeHandler.IDENTIY(), BasicListAttributeHandler.IDENTIY());
		}
		synchronizer.synchronize();
		BasicListenable src = new BasicListenable() {

			@Override
			public void changed(BasicChangeNotifyer bcm) {
				synchronizer.reverseSynchronize();
			}
		};
		tpl.addBasicChangeListener(src);
		this.handlers.put(tpl, src);
		addBasicFeature(feature, bmf);
		
	}
	
	public <T> List<T> addBasicListFeature(EStructuralFeature feature, boolean isDerived) {
		int prefix = getCurPrefix(feature);
		return addBasicListFeature(feature, prefix, isDerived);
	}

	public <T> List<T> addBasicListFeature(EStructuralFeature feature, int prefix, boolean isDerived) {
		BasicMapFunc<Treepos, T> bmf = getBasicMapFunc(isDerived);
		TreePosList<T> tpl = (prefix==0)?new TreePosList(bmf):new TreePosList<>(bmf, prefix);
		addBasicFeature(feature, bmf);
		return tpl;
	}
	
	public <T, U> void addBasicSingletonFeature(EStructuralFeature myFeature, EObject otherObject,
			EStructuralFeature otherFeature, boolean isDerived) {
		if (otherFeature instanceof EReference) {
			//You need to convert them
			if (otherFeature.isMany()) {
				addBasicSingletonFeature(myFeature, otherObject, otherFeature, this.convertToVirtual, this.convertFromVirtual, isDerived);	
			} else {
				addBasicSingletonFeature(myFeature, otherObject, otherFeature, this.convertToVirtual, this.convertFromVirtual, isDerived);
			}
		} else {
			//Don't need to convert them as they are values
			addBasicSingletonFeature(myFeature, otherObject, otherFeature, BasicListAttributeHandler.IDENTIY(), BasicListAttributeHandler.IDENTIY(), isDerived);
		}
	}
	
	
	private <T, U> void addBasicSingletonFeature(EStructuralFeature myFeature, EObject otherObject,
			EStructuralFeature otherFeature, Function<T, U> convertThere, Function<U, T> convertBack, boolean isDerived) {
		if (otherFeature.isMany()) {
			//TODO: Does not work maybe?
			List<U> list = (List<U>) otherObject.eGet(otherFeature);
			MultiAttributeHandler<T> handler = new BasicListAttributeHandler(list, convertThere, convertBack);
			List<T> changedList = handler.exposeList();
			
			addBasicFeature(myFeature, changedList,isDerived);
		} else {
		
			BasicMapFunc<Treepos, ?> bmf = getBasicMapFunc(isDerived);
			TreePosList<?> tpl = new TreePosList<>(bmf);
			SingleESFAttributeHandler<T,U> attrHandler = new SingleESFAttributeHandler<>(otherObject, otherFeature, convertBack, convertThere);
			
			BasicListenable src = new BasicListenable() {

				@Override
				public void changed(BasicChangeNotifyer bcm) {
					if (tpl.isEmpty()) {
						attrHandler.unset();
					} else {
						if (myFeature instanceof EReference) {
							attrHandler.set((T)DeltaVMEObject.this.convertFromIdentifier.apply((Identifier)tpl.get(0)));
						} else {
							((SingleESFAttributeHandler)attrHandler).set(tpl.get(0));
						}
					}
				}
			};
			List target = new ArrayList<>();
			for (T val: attrHandler.readOnlyValues()) {
				if (myFeature instanceof EReference) {
					target.add(this.convertToIdentifier.apply((EObject)val));
				} else {
					target.add(val);
				}
			}
			PatchUtil.applyPatch((TreePosList)tpl, target);
			tpl.addBasicChangeListener(src);
			
			addBasicFeature(myFeature, bmf);
		}
	}
	public void copyDeltaStore(DeltaVMEObject dreplaced) {
		dreplaced.attributeHandlerInfos.forEach((esf,di)->{
			DeltaInfo mydi = getDeltaInfo(esf);
			mydi.mergeFrom(di);
		});
		
	}
	
	@Override
	public EClass eClass() {
		return this.myClass;
	}

	private int getCurPrefix(EStructuralFeature feature) {
		DeltaInfo<?> info = getDeltaInfo(feature);
		int prefix = ((BasicFiniteUnionFunc)info.unionFunc).getBases().size()*2+1;
		return prefix;
	}

	public<T> DeltaInfo<T> getDeltaInfo(EStructuralFeature feat) {
		DeltaInfo<?> mah = this.attributeHandlerInfos.computeIfAbsent(feat,(ft)->{
			DeltaInfo<T> ret = new DeltaInfo<>();
			DeltaStoreInfo<T> sstore = (DeltaStoreInfo<T>) this.store.getInfo(feat);
			ret.unionFunc = new BasicFiniteUnionFunc<>(Treepos.class, new ArrayList<>());
			ret.deltaFunc = new BasicDeltaFunc<>(Treepos.class, ret.unionFunc, sstore.getValueFunc(), sstore.getScopeFunc());
			if (feat instanceof EReference) {
				ret.multiHandler = FunctionMultiAttributeHandler.getTreeposHandler((AbstractFunc)ret.deltaFunc, this.convertFromIdentifier, this.convertToIdentifier);
			} else {
				ret.multiHandler = FunctionMultiAttributeHandler.getTreeposHandler(ret.deltaFunc, BasicListAttributeHandler.IDENTIY(), BasicListAttributeHandler.IDENTIY());
			}
			ret.attributeHandler = wrapFor(feat, ret.multiHandler);
			
			if (feat instanceof EReference) {
				EReference ref = (EReference)feat;
				if (ref.isContainment()) {
					BasicListenable bl = new BasicListenable() {
						
						List<Object> lastList = new ArrayList<>();
						
						@Override
						public void changed(BasicChangeNotifyer bcm) {
							List<Object> remaining = new ArrayList<>(this.lastList);
							List<Object> missing = new ArrayList<>();
							for (Object obj: ret.attributeHandler.readOnlyValues()) {
								if (!remaining.remove(obj)) {
									missing.add(obj);
								}
							}
							this.lastList = new ArrayList<>(ret.attributeHandler.readOnlyValues());
							if (!remaining.isEmpty()  || !missing.isEmpty()) {
								//Remove remaining
								remaining.forEach(x->{
									if (x instanceof DeltaVMEObject) {
										DeltaVMEObject svo = (DeltaVMEObject)x;
										svo.containments.remove(new ContainmentThing(DeltaVMEObject.this, ref));
									} else {
										System.err.println("Cannot remove containment from "+x+"!");
									}
								});
								
								//Add for each missing
								missing.forEach(x->{
									if (x instanceof DeltaVMEObject) {
										DeltaVMEObject svo = (DeltaVMEObject)x;
										svo.containments.add(new ContainmentThing(DeltaVMEObject.this, ref));
									} else {
										System.err.println("Cannot add containment to "+x+"!");
									}
								});
							}
						}
					};
				ret.attributeHandler.addLocalBasicChangeListener(
						bl
						);
				//Initial processing
				bl.changed(ret.attributeHandler);
				}
			}
			
			return ret;	
		});
		return (DeltaInfo)mah;
	}

	public Collection<? extends BasicDerivationStatus> getDerivationStatus(EStructuralFeature esf) {
		AttributeHandler<?,?> handler = getHandler(esf);
		if (handler == null) {
			return Collections.emptyList();
		}
		return handler.getDerivationStatus();
	}


	
	@Override
	public AttributeHandler<?,?> getHandler(EStructuralFeature feature) {
		return getDeltaInfo(feature).attributeHandler;
	}
	
	public void partialPushdown() {
		for (EStructuralFeature feat: eClass().getEAllStructuralFeatures()) {
			AttributeHandler<?, ?> handler = getHandler(feat);
			AbstractFunc<?, ?, ? extends QueryResult<?, ?>> tf = handler.getTreeposFuncOrNull();
			if (tf instanceof BasicDeltaFunc)  {
				BasicDeltaFunc bdf = (BasicDeltaFunc)tf;
				bdf.partialPushdown();
			}
		}
	}
	
	
	
	
	public void partialReset() {
		for (EStructuralFeature feat: eClass().getEAllStructuralFeatures()) {
			AttributeHandler<?, ?> handler = getHandler(feat);
			AbstractFunc<?, ?, ? extends QueryResult<?, ?>> tf = handler.getTreeposFuncOrNull();
			if (tf instanceof BasicDeltaFunc)  {
				BasicDeltaFunc bdf = (BasicDeltaFunc)tf;
				bdf.partialReset();
			}
		}
	}

	public void removeBaseFunction(EStructuralFeature feat, AbstractFunc<Treepos, ?, ?> func) {
		DeltaInfo<?> info = getDeltaInfo(feat);
		((BasicFiniteUnionFunc)info.unionFunc).removeBase(func);
	}

	/* Requirement: feature.isMany() */
	public void removeBasicFeature(EStructuralFeature feature, AbstractFunc<Treepos, ?, ?> func) {
		removeBaseFunction(feature, func);
		
	}

	@Override
	public void resetCustom() {
		for (EStructuralFeature esf: eClass().getEAllStructuralFeatures()) {
			AttributeHandler<?, ?> handler = getHandler(esf);
			if (handler != null) {
				
			}
			DeltaInfo<?> dinfo = this.attributeHandlerInfos.get(esf);
			if (dinfo != null) {
				dinfo.clear();
			}
		} 
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
		fSet.addAll(this.attributeHandlerInfos.keySet());
		fSet.forEach(x->{
			builder.append("\t"+x.getEContainingClass().getName()+"."+x.getName()+": ");
			builder.append(printFeatureValues(x));
			builder.append("\n");
		});
		return builder.toString();
	}

}

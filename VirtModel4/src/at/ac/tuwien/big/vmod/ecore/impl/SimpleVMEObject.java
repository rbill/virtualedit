package at.ac.tuwien.big.vmod.ecore.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.Points;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;
import at.ac.tuwien.big.verocl.parameterdesc.impl.MultiPointImpl;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.ecore.FeaturePropertyValue;
import at.ac.tuwien.big.virtmod.ecore.VEObject;
import at.ac.tuwien.big.virtmod.ecore.impl.FakeEListImpl;
import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.VFakeEList;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VProjectedModelView;
import at.ac.tuwien.big.vmod.impl.ParametizedFunction;
import at.ac.tuwien.big.vmod.modelview.ModelView;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.impl.FilteredList;

public class SimpleVMEObject extends MinimalEObjectImpl implements VMEObject, InternalEObject {
	private Function<String, ? extends Counter> classFunc;
	private Map<EStructuralFeature, List<?>> myValues = new HashMap<>();
	private Symbol id;
	private VModelView model;
	private EClass myClass;
	//private MultiPoint projection = null;
	
	public Object toStringer = new Object(){
		public String toString() {
			StringBuilder ret = new StringBuilder();
			for (Entry<EStructuralFeature,List<?>> feat: myValues.entrySet()) {
				ret.append(feat.getKey().getName()+": "+feat.getValue());
				ret.append("\n");
			}
			return ret.toString();
		}
		
	};
	
	public SimpleVMEObject(VModelView view, Symbol id, MultiPoint projection) {
		this.id = id;
		this.model = view;
		this.classFunc = view.getInstances().getClassFunc(id);
		
		this.myValues = new HashMap<>();
		//this.projection = projection;
		//if (projection != null) {
		//	this.classFunc = ((ParametizedFunction<String,? extends Counter,MultiPoint,?>)classFunc).project(projection);
		//}
	}
	
	@Override
	public MultiPoint getProjectionOrNull() {
		if (model instanceof VProjectedModelView) {
			return ((VProjectedModelView) model).getProjection();
		}
		return null;
	}
	
	public SimpleVMEObject(VModelView view, Symbol id) {
		this(view,id,null);
	}

	@Override
	public void setEClass(EClass newClass) {
		model.getInstances().setClass(id, newClass);
		this.myClass = null;
	}

	@Override
	public Symbol getUUID() {
		return id;
	}

	public boolean equals(Object o) {
		return (o instanceof VMEObject) && Objects.equals(getUUID(),((VMEObject)o).getUUID());
	}
	
	public int hashCode() {
		return Objects.hashCode(getUUID());
	}

	public VModelView getModel() {
		return model;
	}
	
	private List<?> getValues(EStructuralFeature feat) {
		List<?> ret = myValues.get(feat);
		if (ret == null) {
			EClass cl = eClass();
			try {
				ret = model.getFeatureValues(feat.getEContainingClass().getName(), feat.getName()).getEcoreValue(getUUID());
				
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.err.println("NPE when getting values for "+ feat);
				throw e;
			}
			myValues.put(feat, ret );
		}
		return ret;
	}
	

	/*@Override
	public List<GlobalSource<?>> getSources(EStructuralFeature forFeature) {
		List<Object> values = getValues(forFeature);
		if (values instanceof SourcedList) {
			return ((SourcedList) values).getSources();
		}
		return null;
	}*/

	@Override
	public EClass eClass() {
		if (this.myClass == null) {
			EClass myClass = model.getInstances().getClass(getUUID());
			this.myClass = myClass;
		}
		return myClass;
	}


	@Override
	public EObject eContainer() {
		return model.getContainingObject(id);
	}
	
	public InternalEObject eInternalContainer() {
	   return (InternalEObject)model.getContainingObject(id);
	}
	
	

	  @Override
	  public int eContainerFeatureID()
	  {
		  super.eContainerFeatureID();
		  EStructuralFeature feat = eContainingFeature();
		  if (feat == null) {
			  return -1;
		  }
		  if (feat instanceof EReference) {
			  EReference ref = (EReference)feat;
			  EReference op = ref.getEOpposite();
			  if (op != null) {
				  return op.getFeatureID();
			  }
		  }
		  return -feat.getFeatureID()-1;
	  }
	  
	  	
	  protected void eBasicSetContainerFeatureID(int newContainerFeatureID)
	  {
	    
	  }
	
	  @Override
	  protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID)
	  {
		  System.out.println("Set container to "+newContainer);
	  }

	protected void eBasicSetContainer(InternalEObject newContainer) {
		//???
		System.out.println("Set container to "+newContainer);
		
	}
	
	@Override
	public NotificationChain eSetResource(Resource.Internal resource, NotificationChain notifications) {
		System.out.println("Object with id "+id+" has now resource "+resource );
		return super.eSetResource(resource, notifications);
		
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return model.getContainingFeature(id);
	}

	@Override
	public EReference eContainmentFeature() {
		return model.getContainingFeature(id);
	}
	

	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		List<?> values = getValues(feature);
		if (feature.isMany()) {
			return values;
		} else {
			if (values.isEmpty()) {
				return null;
			}
			values.isEmpty();
			return values.iterator().next();
		}
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		List<?> values = getValues(feature);
		if (feature.isMany()) {
			return values;
		} else {
			if (values.isEmpty()) {
				return null;
			}
			return values.iterator().next();
		}
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		FeaturePropertyValue.setToValue(getValues(feature),newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return !getValues(feature).isEmpty();
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		getValues(feature).clear();
	}

	public String toString() {
		EClass cl = eClass();
		return (cl==null?"??":cl.getName())+" with id "+id;
	}

	@Override
	public VMEObject project(Points mp) {
		SimpleVMEObject ret = new SimpleVMEObject(model, id);
		MultiPoint curProj = getProjectionOrNull();
		if (curProj == null) {
			if (mp instanceof MultiPoint) {
				ret.initProjection((MultiPoint)mp);
			} else { 
				if (mp instanceof SinglePoint) {
					ret.initProjection(new MultiPointImpl(mp.getDesc(),((SinglePoint) mp)));
				} else {
					throw new IllegalArgumentException("mp must be MultiPoint or SinglePoint");
				}
			}
		} else {
			ret.initProjection(curProj.intersectWithOrSame(mp));
		}
		return ret;
	}

	public void initProjection(MultiPoint mp) {
		if (model instanceof VProjectedModelView) {
			model = ((VProjectedModelView)model).project(mp);
			//Tatsächlich vermutlich nicht notwendig, da wenn es initialisiert wird die myValues immer leer sind
			myValues.clear();
		}
	}


}

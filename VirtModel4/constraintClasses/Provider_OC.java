package constraintClasses;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;
import at.ac.tuwien.big.vfunc.nbasic.constraint.ListRepeater;
import org.eclipse.emf.ecore.EcoreFactory;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;
import at.ac.tuwien.big.vfunc.nbasic.constraint.CEobjectManager;
import org.eclipse.emf.ecore.EStructuralFeature;
import at.ac.tuwien.big.vfunc.nbasic.constraint.OclDerivationEvaluable;
import at.ac.tuwien.big.vfunc.nbasic.constraint.OclDerivationEvaluableState;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import java.util.List;
import java.util.ArrayList;
import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;

public class Provider_OC extends SampleAnyProvider{
	public static final EClass $Provider_OC_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	CEobjectManager.getFakePackage().getEClassifiers().add($Provider_OC_CLASS);
	CEobjectManager.addSupplier($Provider_OC_CLASS,()->new Provider_OC());
	$Provider_OC_CLASS.getESuperTypes().add(SampleAnyProvider.$SampleAnyProvider_CLASS);
	$Provider_OC_CLASS.setName("Provider");
	}
	public static final EReference $prov = EcoreFactory.eINSTANCE.createEReference();
	static {
		$prov.setName("prov");
		$prov.setLowerBound(1);
		$prov.setEType(router.RouterPackage.eINSTANCE.getProvider());
		$Provider_OC_CLASS.getEReferences().add($prov);
	}
	protected router.Provider prov;
	public router.Provider getProv() {
		return this.prov;
	}
	public void setProv(router.Provider newValue) {
		this.prov = newValue;
		this.isSet_prov = true;
	checkInitDerived();
	}
	public Provider_OC() {}
		private void recalcname_deriv() {
			name_deriv.clear();
			name_deriv.addAll(name_deriv_0);
			setName(name_deriv.isEmpty()?null:name_deriv.get(0));
		}
		public java.lang.String getname_deriv() {
			if (name_deriv.isEmpty()) {return null;} else {return name_deriv.get(0);}
		}
	@Override
	public Object eGet(EStructuralFeature feature) {
		if (feature == $prov) {
		return getProv();
		} else  {
		return super.eGet(feature);
		}
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		if (feature == $prov) {
		setProv((router.Provider)newValue);
		} else  {
		super.eSet(feature, newValue);
		}
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		if (feature == $prov) {
		setProv(null);
		} else  {
		super.eUnset(feature);
		}
	}

	@Override
	public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
		if (feature == $prov) {
		
		} else  {
		super.addListener(feature,refreshMyself);
		}
	}

	@Override
	public EClass eClass() {
		return $Provider_OC_CLASS;
	}
		org.eclipse.emf.common.util.EList<java.lang.String> name_deriv = new org.eclipse.emf.common.util.BasicEList<>();
			org.eclipse.emf.common.util.EList<java.lang.String> name_deriv_0 = new org.eclipse.emf.common.util.BasicEList<>();
			private NewValueListenable<Object> name_deriv_0_listener = new NewValueListenable<Object>() {
				@Override
				public void changed(Object oldValue, Object newValue) {
				//System.out.println("Changed Der from "+oldValue+" to " +newValue);

					List l = cmanager.convertOclTupleList(newValue);
					l.removeIf((x)->(x == null || !(x instanceof java.lang.String)));
					name_deriv_0 = new BasicEList<>(l);
					recalcname_deriv();
				}
			};
			OclDerivationEvaluableState name_deriv_0_listener_state;
		static {
		MyResource.putDerivation($Provider_OC_CLASS,$SomeDevice_name,"prov.name");
		}
			OclDerivationEvaluableState check_speedEnough_listener_state;
			 static OclDerivationEvaluable check_speedEnough_listener_evaluable  = new OclDerivationEvaluable("self.speed >= prov.speed", null);
			static {
				MyResource.addEvaluable($Provider_OC_CLASS,check_speedEnough_listener_evaluable);
			}
		private NewValueListenable<Object> check_speedEnough_listener = new NewValueListenable<Object>() {
			@Override
			public void changed(Object oldValue, Object newValue) {
			//System.out.println("Changed Inv from "+oldValue+" to " +newValue);

				List l = cmanager.convertOclTupleList(newValue);
				l.removeIf((x)->(x == null || !(x instanceof Boolean) || !((Boolean)x)));
				check_speedEnough = !l.isEmpty();
			}
		};
		boolean check_speedEnough = false;
	private boolean $derivDone = false;
	boolean isSet_prov = false;
	private void checkInitDerived(){
		if (this.$derivDone) {return;}
		if (!this.isSet_prov) {return;}
		initDerivedProt();
		}
	public void initDerived(){
		this.prov = (router.Provider)parameters.get(0);
		initDerivedProt();
	}
	protected void initDerivedProt(){
		if (this.$derivDone) {return;}
		this.$derivDone = true;
		super.initDerivedProt();
		{
			OclDerivationEvaluable evaluable = new OclDerivationEvaluable("prov.name", null);
			name_deriv_0_listener_state = evaluable.getState(this.res, this);
			name_deriv_0_listener_state.addChangeListener(name_deriv_0_listener);
			name_deriv_0_listener_state.initParam();
			name_deriv_0_listener_state.refresh();
		}
		{
			OclDerivationEvaluable evaluable = check_speedEnough_listener_evaluable;
			check_speedEnough_listener_state = evaluable.getState(this.res, this);
			check_speedEnough_listener_state.addChangeListener(check_speedEnough_listener);
			check_speedEnough_listener_state.initParam();
			check_speedEnough_listener_state.refresh();
		}
	}
}
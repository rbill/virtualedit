package constraintClasses;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import at.ac.tuwien.big.vfunc.nbasic.constraint.OclDerivationEvaluable;
import at.ac.tuwien.big.vfunc.nbasic.constraint.OclDerivationEvaluableState;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import java.util.List;
import java.util.ArrayList;
import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;

public class CitizenPupils_OC extends SamplePupil{
	public static final EClass $CitizenPupils_OC_CLASS = EcoreFactory.eINSTANCE.createEClass();
	static {
	$CitizenPupils_OC_CLASS.getESuperTypes().add(SamplePupil.$SamplePupil_CLASS);
	$CitizenPupils_OC_CLASS.setName("CitizenPupils");
	}
	public static final EReference $cit = EcoreFactory.eINSTANCE.createEReference();
	static {
		$cit.setName("cit");
		$cit.setChangeable(false);
		$cit.setEType(Citizen.CitizenPackage.eINSTANCE.getBurger());
		$CitizenPupils_OC_CLASS.getEReferences().add($cit);
	}
	protected Citizen.Burger cit;
	public Citizen.Burger getCit() {
		return this.cit;
	}
	public void setCit(Citizen.Burger newValue) {
		 throw new UnsupportedOperationException("Setting pars not supported!");
	}
	public CitizenPupils_OC() {}
		private void recalcinclass_deriv() {
			inclass_deriv.clear();
			inclass_deriv.addAll(inclass_deriv_0);
		}
		public java.lang.String getinclass_deriv() {
			if (inclass_deriv.isEmpty()) {return null;} else {return inclass_deriv.get(0);}
		}
		private void recalcname_deriv() {
			name_deriv.clear();
			name_deriv.addAll(name_deriv_0);
		}
		public java.lang.String getname_deriv() {
			if (name_deriv.isEmpty()) {return null;} else {return name_deriv.get(0);}
		}
	@Override
	public Object eGet(EStructuralFeature feature) {
		if (feature == $cit) {
		return getCit();
		} else  {
		return super.eGet(feature);
		}
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		if (feature == $cit) {
		setCit((Citizen.Burger)newValue);
		} else  {
		super.eSet(feature, newValue);
		}
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		if (feature == $cit) {
		setCit(null);
		} else  {
		super.eUnset(feature);
		}
	}

	@Override
	public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {
		if (feature == $cit) {
		
		} else  {
		super.addListener(feature,refreshMyself);
		}
	}

	@Override
	public EClass eClass() {
		return $CitizenPupils_OC_CLASS;
	}
		org.eclipse.emf.common.util.EList<java.lang.String> inclass_deriv = new org.eclipse.emf.common.util.BasicEList<>();
			org.eclipse.emf.common.util.EList<java.lang.String> inclass_deriv_0 = new org.eclipse.emf.common.util.BasicEList<>();
			private NewValueListenable<Object> inclass_deriv_0_listener = new NewValueListenable<Object>() {
				@Override
				public void changed(Object oldValue, Object newValue) {System.out.println("Changed Der from "+oldValue+" to " +newValue);

					List l = cmanager.convertOclTupleList(newValue);
					l.removeIf((x)->(x == null || !(x instanceof java.lang.String)));
					inclass_deriv_0 = new BasicEList<>(l);
					recalcinclass_deriv();
				}
			};
			OclDerivationEvaluableState inclass_deriv_0_listener_state;
		org.eclipse.emf.common.util.EList<java.lang.String> name_deriv = new org.eclipse.emf.common.util.BasicEList<>();
			org.eclipse.emf.common.util.EList<java.lang.String> name_deriv_0 = new org.eclipse.emf.common.util.BasicEList<>();
			private NewValueListenable<Object> name_deriv_0_listener = new NewValueListenable<Object>() {
				@Override
				public void changed(Object oldValue, Object newValue) {System.out.println("Changed Der from "+oldValue+" to " +newValue);

					List l = cmanager.convertOclTupleList(newValue);
					l.removeIf((x)->(x == null || !(x instanceof java.lang.String)));
					name_deriv_0 = new BasicEList<>(l);
					recalcname_deriv();
				}
			};
			OclDerivationEvaluableState name_deriv_0_listener_state;
			OclDerivationEvaluableState check_nameCorrect_listener_state;
		private NewValueListenable<Object> check_nameCorrect_listener = new NewValueListenable<Object>() {
			@Override
			public void changed(Object oldValue, Object newValue) {System.out.println("Changed Inv from "+oldValue+" to " +newValue);

				List l = cmanager.convertOclTupleList(newValue);
				l.removeIf((x)->(x == null || !(x instanceof Boolean) || !((Boolean)x)));
				check_nameCorrect = !l.isEmpty();
			}
		};
		boolean check_nameCorrect = false;
	public void initDerived(){
		super.initDerived();
		this.cit = (Citizen.Burger)parameters.get(0);
		{
			OclDerivationEvaluable evaluable = new OclDerivationEvaluable("cit.address", null);
			inclass_deriv_0_listener_state = evaluable.getState(this.res, this);
			inclass_deriv_0_listener_state.addChangeListener(inclass_deriv_0_listener);
			inclass_deriv_0_listener_state.initParam();
			inclass_deriv_0_listener_state.refresh();
		}
		{
			OclDerivationEvaluable evaluable = new OclDerivationEvaluable("cit.name + 'ASDF'", null);
			name_deriv_0_listener_state = evaluable.getState(this.res, this);
			name_deriv_0_listener_state.addChangeListener(name_deriv_0_listener);
			name_deriv_0_listener_state.initParam();
			name_deriv_0_listener_state.refresh();
		}
		{
			OclDerivationEvaluable evaluable = new OclDerivationEvaluable("self.name = 'blablaASDF'", null);
			check_nameCorrect_listener_state = evaluable.getState(this.res, this);
			check_nameCorrect_listener_state.addChangeListener(check_nameCorrect_listener);
			check_nameCorrect_listener_state.initParam();
			check_nameCorrect_listener_state.refresh();
		}
	}
}
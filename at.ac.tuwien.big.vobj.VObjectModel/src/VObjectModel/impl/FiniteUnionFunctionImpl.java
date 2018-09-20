/**
 */
package VObjectModel.impl;

import VObjectModel.FiniteUnionFunction;
import VObjectModel.Function;
import VObjectModel.VObjectModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Finite Union Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.FiniteUnionFunctionImpl#getBaseFunc <em>Base Func</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FiniteUnionFunctionImpl extends MinimalEObjectImpl.Container implements FiniteUnionFunction {
	/**
	 * The cached value of the '{@link #getBaseFunc() <em>Base Func</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseFunc()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> baseFunc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FiniteUnionFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.FINITE_UNION_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getBaseFunc() {
		if (baseFunc == null) {
			baseFunc = new EObjectResolvingEList<Function>(Function.class, this, VObjectModelPackage.FINITE_UNION_FUNCTION__BASE_FUNC);
		}
		return baseFunc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.FINITE_UNION_FUNCTION__BASE_FUNC:
				return getBaseFunc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VObjectModelPackage.FINITE_UNION_FUNCTION__BASE_FUNC:
				getBaseFunc().clear();
				getBaseFunc().addAll((Collection<? extends Function>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.FINITE_UNION_FUNCTION__BASE_FUNC:
				getBaseFunc().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.FINITE_UNION_FUNCTION__BASE_FUNC:
				return baseFunc != null && !baseFunc.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FiniteUnionFunctionImpl

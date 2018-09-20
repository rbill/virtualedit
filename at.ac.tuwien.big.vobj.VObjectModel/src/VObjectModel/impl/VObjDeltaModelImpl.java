/**
 */
package VObjectModel.impl;

import VObjectModel.Function;
import VObjectModel.Identifier;
import VObjectModel.StoredFuncs;
import VObjectModel.VObjDeltaModel;
import VObjectModel.VObjectModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VObj Delta Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.VObjDeltaModelImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link VObjectModel.impl.VObjDeltaModelImpl#getStoredfuncs <em>Storedfuncs</em>}</li>
 *   <li>{@link VObjectModel.impl.VObjDeltaModelImpl#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VObjDeltaModelImpl extends MinimalEObjectImpl.Container implements VObjDeltaModel {
	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getStoredfuncs() <em>Storedfuncs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoredfuncs()
	 * @generated
	 * @ordered
	 */
	protected EList<StoredFuncs> storedfuncs;

	/**
	 * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> identifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VObjDeltaModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.VOBJ_DELTA_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this, VObjectModelPackage.VOBJ_DELTA_MODEL__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StoredFuncs> getStoredfuncs() {
		if (storedfuncs == null) {
			storedfuncs = new EObjectContainmentEList<StoredFuncs>(StoredFuncs.class, this, VObjectModelPackage.VOBJ_DELTA_MODEL__STOREDFUNCS);
		}
		return storedfuncs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifier> getIdentifiers() {
		if (identifiers == null) {
			identifiers = new EObjectContainmentEList<Identifier>(Identifier.class, this, VObjectModelPackage.VOBJ_DELTA_MODEL__IDENTIFIERS);
		}
		return identifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.VOBJ_DELTA_MODEL__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
			case VObjectModelPackage.VOBJ_DELTA_MODEL__STOREDFUNCS:
				return ((InternalEList<?>)getStoredfuncs()).basicRemove(otherEnd, msgs);
			case VObjectModelPackage.VOBJ_DELTA_MODEL__IDENTIFIERS:
				return ((InternalEList<?>)getIdentifiers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.VOBJ_DELTA_MODEL__FUNCTIONS:
				return getFunctions();
			case VObjectModelPackage.VOBJ_DELTA_MODEL__STOREDFUNCS:
				return getStoredfuncs();
			case VObjectModelPackage.VOBJ_DELTA_MODEL__IDENTIFIERS:
				return getIdentifiers();
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
			case VObjectModelPackage.VOBJ_DELTA_MODEL__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case VObjectModelPackage.VOBJ_DELTA_MODEL__STOREDFUNCS:
				getStoredfuncs().clear();
				getStoredfuncs().addAll((Collection<? extends StoredFuncs>)newValue);
				return;
			case VObjectModelPackage.VOBJ_DELTA_MODEL__IDENTIFIERS:
				getIdentifiers().clear();
				getIdentifiers().addAll((Collection<? extends Identifier>)newValue);
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
			case VObjectModelPackage.VOBJ_DELTA_MODEL__FUNCTIONS:
				getFunctions().clear();
				return;
			case VObjectModelPackage.VOBJ_DELTA_MODEL__STOREDFUNCS:
				getStoredfuncs().clear();
				return;
			case VObjectModelPackage.VOBJ_DELTA_MODEL__IDENTIFIERS:
				getIdentifiers().clear();
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
			case VObjectModelPackage.VOBJ_DELTA_MODEL__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case VObjectModelPackage.VOBJ_DELTA_MODEL__STOREDFUNCS:
				return storedfuncs != null && !storedfuncs.isEmpty();
			case VObjectModelPackage.VOBJ_DELTA_MODEL__IDENTIFIERS:
				return identifiers != null && !identifiers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VObjDeltaModelImpl

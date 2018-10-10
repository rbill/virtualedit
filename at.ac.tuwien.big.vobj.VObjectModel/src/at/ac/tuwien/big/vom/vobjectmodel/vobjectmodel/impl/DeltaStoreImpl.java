/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delta Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaStoreImpl#getAddMap <em>Add Map</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaStoreImpl#getFilterScope <em>Filter Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeltaStoreImpl extends MinimalEObjectImpl.Container implements DeltaStore {
	/**
	 * The cached value of the '{@link #getAddMap() <em>Add Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddMap()
	 * @generated
	 * @ordered
	 */
	protected BasicFunction addMap;

	/**
	 * The cached value of the '{@link #getFilterScope() <em>Filter Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterScope()
	 * @generated
	 * @ordered
	 */
	protected BasicFunction filterScope;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeltaStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.DELTA_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunction getAddMap() {
		if (addMap != null && addMap.eIsProxy()) {
			InternalEObject oldAddMap = (InternalEObject)addMap;
			addMap = (BasicFunction)eResolveProxy(oldAddMap);
			if (addMap != oldAddMap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.DELTA_STORE__ADD_MAP, oldAddMap, addMap));
			}
		}
		return addMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunction basicGetAddMap() {
		return addMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddMap(BasicFunction newAddMap) {
		BasicFunction oldAddMap = addMap;
		addMap = newAddMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.DELTA_STORE__ADD_MAP, oldAddMap, addMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunction getFilterScope() {
		if (filterScope != null && filterScope.eIsProxy()) {
			InternalEObject oldFilterScope = (InternalEObject)filterScope;
			filterScope = (BasicFunction)eResolveProxy(oldFilterScope);
			if (filterScope != oldFilterScope) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.DELTA_STORE__FILTER_SCOPE, oldFilterScope, filterScope));
			}
		}
		return filterScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunction basicGetFilterScope() {
		return filterScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilterScope(BasicFunction newFilterScope) {
		BasicFunction oldFilterScope = filterScope;
		filterScope = newFilterScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.DELTA_STORE__FILTER_SCOPE, oldFilterScope, filterScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.DELTA_STORE__ADD_MAP:
				if (resolve) return getAddMap();
				return basicGetAddMap();
			case VObjectModelPackage.DELTA_STORE__FILTER_SCOPE:
				if (resolve) return getFilterScope();
				return basicGetFilterScope();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VObjectModelPackage.DELTA_STORE__ADD_MAP:
				setAddMap((BasicFunction)newValue);
				return;
			case VObjectModelPackage.DELTA_STORE__FILTER_SCOPE:
				setFilterScope((BasicFunction)newValue);
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
			case VObjectModelPackage.DELTA_STORE__ADD_MAP:
				setAddMap((BasicFunction)null);
				return;
			case VObjectModelPackage.DELTA_STORE__FILTER_SCOPE:
				setFilterScope((BasicFunction)null);
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
			case VObjectModelPackage.DELTA_STORE__ADD_MAP:
				return addMap != null;
			case VObjectModelPackage.DELTA_STORE__FILTER_SCOPE:
				return filterScope != null;
		}
		return super.eIsSet(featureID);
	}

} //DeltaStoreImpl

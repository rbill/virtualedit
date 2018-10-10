/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delta Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaFunctionImpl#getWrapped <em>Wrapped</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaFunctionImpl#getDeltastore <em>Deltastore</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeltaFunctionImpl extends MinimalEObjectImpl.Container implements DeltaFunction {
	/**
	 * The cached value of the '{@link #getWrapped() <em>Wrapped</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWrapped()
	 * @generated
	 * @ordered
	 */
	protected Function wrapped;

	/**
	 * The cached value of the '{@link #getDeltastore() <em>Deltastore</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeltastore()
	 * @generated
	 * @ordered
	 */
	protected DeltaStore deltastore;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeltaFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.DELTA_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getWrapped() {
		if (wrapped != null && wrapped.eIsProxy()) {
			InternalEObject oldWrapped = (InternalEObject)wrapped;
			wrapped = (Function)eResolveProxy(oldWrapped);
			if (wrapped != oldWrapped) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.DELTA_FUNCTION__WRAPPED, oldWrapped, wrapped));
			}
		}
		return wrapped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetWrapped() {
		return wrapped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrapped(Function newWrapped) {
		Function oldWrapped = wrapped;
		wrapped = newWrapped;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.DELTA_FUNCTION__WRAPPED, oldWrapped, wrapped));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaStore getDeltastore() {
		return deltastore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeltastore(DeltaStore newDeltastore, NotificationChain msgs) {
		DeltaStore oldDeltastore = deltastore;
		deltastore = newDeltastore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.DELTA_FUNCTION__DELTASTORE, oldDeltastore, newDeltastore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltastore(DeltaStore newDeltastore) {
		if (newDeltastore != deltastore) {
			NotificationChain msgs = null;
			if (deltastore != null)
				msgs = ((InternalEObject)deltastore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.DELTA_FUNCTION__DELTASTORE, null, msgs);
			if (newDeltastore != null)
				msgs = ((InternalEObject)newDeltastore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.DELTA_FUNCTION__DELTASTORE, null, msgs);
			msgs = basicSetDeltastore(newDeltastore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.DELTA_FUNCTION__DELTASTORE, newDeltastore, newDeltastore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.DELTA_FUNCTION__DELTASTORE:
				return basicSetDeltastore(null, msgs);
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
			case VObjectModelPackage.DELTA_FUNCTION__WRAPPED:
				if (resolve) return getWrapped();
				return basicGetWrapped();
			case VObjectModelPackage.DELTA_FUNCTION__DELTASTORE:
				return getDeltastore();
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
			case VObjectModelPackage.DELTA_FUNCTION__WRAPPED:
				setWrapped((Function)newValue);
				return;
			case VObjectModelPackage.DELTA_FUNCTION__DELTASTORE:
				setDeltastore((DeltaStore)newValue);
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
			case VObjectModelPackage.DELTA_FUNCTION__WRAPPED:
				setWrapped((Function)null);
				return;
			case VObjectModelPackage.DELTA_FUNCTION__DELTASTORE:
				setDeltastore((DeltaStore)null);
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
			case VObjectModelPackage.DELTA_FUNCTION__WRAPPED:
				return wrapped != null;
			case VObjectModelPackage.DELTA_FUNCTION__DELTASTORE:
				return deltastore != null;
		}
		return super.eIsSet(featureID);
	}

} //DeltaFunctionImpl

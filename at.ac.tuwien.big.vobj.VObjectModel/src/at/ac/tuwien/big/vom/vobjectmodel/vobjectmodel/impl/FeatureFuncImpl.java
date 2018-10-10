/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Func</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl#getDeltastore <em>Deltastore</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl#getClassref <em>Classref</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl#getNsref <em>Nsref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureFuncImpl extends MinimalEObjectImpl.Container implements FeatureFunc {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassref() <em>Classref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassref()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassref() <em>Classref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassref()
	 * @generated
	 * @ordered
	 */
	protected String classref = CLASSREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsref() <em>Nsref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsref()
	 * @generated
	 * @ordered
	 */
	protected static final String NSREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsref() <em>Nsref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsref()
	 * @generated
	 * @ordered
	 */
	protected String nsref = NSREF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureFuncImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.FEATURE_FUNC;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.FEATURE_FUNC__DELTASTORE, oldDeltastore, newDeltastore);
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
				msgs = ((InternalEObject)deltastore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.FEATURE_FUNC__DELTASTORE, null, msgs);
			if (newDeltastore != null)
				msgs = ((InternalEObject)newDeltastore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.FEATURE_FUNC__DELTASTORE, null, msgs);
			msgs = basicSetDeltastore(newDeltastore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.FEATURE_FUNC__DELTASTORE, newDeltastore, newDeltastore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.FEATURE_FUNC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassref() {
		return classref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassref(String newClassref) {
		String oldClassref = classref;
		classref = newClassref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.FEATURE_FUNC__CLASSREF, oldClassref, classref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsref() {
		return nsref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsref(String newNsref) {
		String oldNsref = nsref;
		nsref = newNsref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.FEATURE_FUNC__NSREF, oldNsref, nsref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.FEATURE_FUNC__DELTASTORE:
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
			case VObjectModelPackage.FEATURE_FUNC__DELTASTORE:
				return getDeltastore();
			case VObjectModelPackage.FEATURE_FUNC__NAME:
				return getName();
			case VObjectModelPackage.FEATURE_FUNC__CLASSREF:
				return getClassref();
			case VObjectModelPackage.FEATURE_FUNC__NSREF:
				return getNsref();
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
			case VObjectModelPackage.FEATURE_FUNC__DELTASTORE:
				setDeltastore((DeltaStore)newValue);
				return;
			case VObjectModelPackage.FEATURE_FUNC__NAME:
				setName((String)newValue);
				return;
			case VObjectModelPackage.FEATURE_FUNC__CLASSREF:
				setClassref((String)newValue);
				return;
			case VObjectModelPackage.FEATURE_FUNC__NSREF:
				setNsref((String)newValue);
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
			case VObjectModelPackage.FEATURE_FUNC__DELTASTORE:
				setDeltastore((DeltaStore)null);
				return;
			case VObjectModelPackage.FEATURE_FUNC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VObjectModelPackage.FEATURE_FUNC__CLASSREF:
				setClassref(CLASSREF_EDEFAULT);
				return;
			case VObjectModelPackage.FEATURE_FUNC__NSREF:
				setNsref(NSREF_EDEFAULT);
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
			case VObjectModelPackage.FEATURE_FUNC__DELTASTORE:
				return deltastore != null;
			case VObjectModelPackage.FEATURE_FUNC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VObjectModelPackage.FEATURE_FUNC__CLASSREF:
				return CLASSREF_EDEFAULT == null ? classref != null : !CLASSREF_EDEFAULT.equals(classref);
			case VObjectModelPackage.FEATURE_FUNC__NSREF:
				return NSREF_EDEFAULT == null ? nsref != null : !NSREF_EDEFAULT.equals(nsref);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", classref: ");
		result.append(classref);
		result.append(", nsref: ");
		result.append(nsref);
		result.append(')');
		return result.toString();
	}

} //FeatureFuncImpl

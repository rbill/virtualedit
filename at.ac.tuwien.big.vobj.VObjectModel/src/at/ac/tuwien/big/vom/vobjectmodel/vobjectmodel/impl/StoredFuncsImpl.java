/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stored Funcs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.StoredFuncsImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.StoredFuncsImpl#getFeaturefunc <em>Featurefunc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StoredFuncsImpl extends MinimalEObjectImpl.Container implements StoredFuncs {
	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier identifier;

	/**
	 * The cached value of the '{@link #getFeaturefunc() <em>Featurefunc</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturefunc()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureFunc> featurefunc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoredFuncsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.STORED_FUNCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifier(Identifier newIdentifier, NotificationChain msgs) {
		Identifier oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.STORED_FUNCS__IDENTIFIER, oldIdentifier, newIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(Identifier newIdentifier) {
		if (newIdentifier != identifier) {
			NotificationChain msgs = null;
			if (identifier != null)
				msgs = ((InternalEObject)identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.STORED_FUNCS__IDENTIFIER, null, msgs);
			if (newIdentifier != null)
				msgs = ((InternalEObject)newIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.STORED_FUNCS__IDENTIFIER, null, msgs);
			msgs = basicSetIdentifier(newIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.STORED_FUNCS__IDENTIFIER, newIdentifier, newIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureFunc> getFeaturefunc() {
		if (featurefunc == null) {
			featurefunc = new EObjectContainmentEList<FeatureFunc>(FeatureFunc.class, this, VObjectModelPackage.STORED_FUNCS__FEATUREFUNC);
		}
		return featurefunc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.STORED_FUNCS__IDENTIFIER:
				return basicSetIdentifier(null, msgs);
			case VObjectModelPackage.STORED_FUNCS__FEATUREFUNC:
				return ((InternalEList<?>)getFeaturefunc()).basicRemove(otherEnd, msgs);
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
			case VObjectModelPackage.STORED_FUNCS__IDENTIFIER:
				return getIdentifier();
			case VObjectModelPackage.STORED_FUNCS__FEATUREFUNC:
				return getFeaturefunc();
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
			case VObjectModelPackage.STORED_FUNCS__IDENTIFIER:
				setIdentifier((Identifier)newValue);
				return;
			case VObjectModelPackage.STORED_FUNCS__FEATUREFUNC:
				getFeaturefunc().clear();
				getFeaturefunc().addAll((Collection<? extends FeatureFunc>)newValue);
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
			case VObjectModelPackage.STORED_FUNCS__IDENTIFIER:
				setIdentifier((Identifier)null);
				return;
			case VObjectModelPackage.STORED_FUNCS__FEATUREFUNC:
				getFeaturefunc().clear();
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
			case VObjectModelPackage.STORED_FUNCS__IDENTIFIER:
				return identifier != null;
			case VObjectModelPackage.STORED_FUNCS__FEATUREFUNC:
				return featurefunc != null && !featurefunc.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StoredFuncsImpl

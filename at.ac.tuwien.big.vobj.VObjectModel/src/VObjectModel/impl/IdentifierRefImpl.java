/**
 */
package VObjectModel.impl;

import VObjectModel.Identifier;
import VObjectModel.IdentifierRef;
import VObjectModel.IdentifierRefOrCmp;
import VObjectModel.VObjectModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.IdentifierRefImpl#getIdentifierreforcmp <em>Identifierreforcmp</em>}</li>
 *   <li>{@link VObjectModel.impl.IdentifierRefImpl#getS_identifier <em>Sidentifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifierRefImpl extends IdentifierRefOrCmpImpl implements IdentifierRef {
	/**
	 * The cached value of the '{@link #getIdentifierreforcmp() <em>Identifierreforcmp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierreforcmp()
	 * @generated
	 * @ordered
	 */
	protected IdentifierRefOrCmp identifierreforcmp;

	/**
	 * The cached value of the '{@link #getS_identifier() <em>Sidentifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS_identifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier s_identifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.IDENTIFIER_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierRefOrCmp getIdentifierreforcmp() {
		if (identifierreforcmp != null && identifierreforcmp.eIsProxy()) {
			InternalEObject oldIdentifierreforcmp = (InternalEObject)identifierreforcmp;
			identifierreforcmp = (IdentifierRefOrCmp)eResolveProxy(oldIdentifierreforcmp);
			if (identifierreforcmp != oldIdentifierreforcmp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP, oldIdentifierreforcmp, identifierreforcmp));
			}
		}
		return identifierreforcmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierRefOrCmp basicGetIdentifierreforcmp() {
		return identifierreforcmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierreforcmp(IdentifierRefOrCmp newIdentifierreforcmp) {
		IdentifierRefOrCmp oldIdentifierreforcmp = identifierreforcmp;
		identifierreforcmp = newIdentifierreforcmp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP, oldIdentifierreforcmp, identifierreforcmp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getS_identifier() {
		return s_identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetS_identifier(Identifier newS_identifier, NotificationChain msgs) {
		Identifier oldS_identifier = s_identifier;
		s_identifier = newS_identifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER, oldS_identifier, newS_identifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setS_identifier(Identifier newS_identifier) {
		if (newS_identifier != s_identifier) {
			NotificationChain msgs = null;
			if (s_identifier != null)
				msgs = ((InternalEObject)s_identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER, null, msgs);
			if (newS_identifier != null)
				msgs = ((InternalEObject)newS_identifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER, null, msgs);
			msgs = basicSetS_identifier(newS_identifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER, newS_identifier, newS_identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER:
				return basicSetS_identifier(null, msgs);
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
			case VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP:
				if (resolve) return getIdentifierreforcmp();
				return basicGetIdentifierreforcmp();
			case VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER:
				return getS_identifier();
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
			case VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP:
				setIdentifierreforcmp((IdentifierRefOrCmp)newValue);
				return;
			case VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER:
				setS_identifier((Identifier)newValue);
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
			case VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP:
				setIdentifierreforcmp((IdentifierRefOrCmp)null);
				return;
			case VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER:
				setS_identifier((Identifier)null);
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
			case VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP:
				return identifierreforcmp != null;
			case VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER:
				return s_identifier != null;
		}
		return super.eIsSet(featureID);
	}

} //IdentifierRefImpl

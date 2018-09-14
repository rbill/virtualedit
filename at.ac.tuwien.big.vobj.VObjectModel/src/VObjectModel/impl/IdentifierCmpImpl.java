/**
 */
package VObjectModel.impl;

import VObjectModel.Identifier;
import VObjectModel.IdentifierCmp;
import VObjectModel.VObjectModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Cmp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.IdentifierCmpImpl#getS_identifier <em>Sidentifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifierCmpImpl extends IdentifierRefOrCmpImpl implements IdentifierCmp {
	/**
	 * The cached value of the '{@link #getS_identifier() <em>Sidentifier</em>}' reference.
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
	protected IdentifierCmpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.IDENTIFIER_CMP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getS_identifier() {
		if (s_identifier != null && s_identifier.eIsProxy()) {
			InternalEObject oldS_identifier = (InternalEObject)s_identifier;
			s_identifier = (Identifier)eResolveProxy(oldS_identifier);
			if (s_identifier != oldS_identifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER, oldS_identifier, s_identifier));
			}
		}
		return s_identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetS_identifier() {
		return s_identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setS_identifier(Identifier newS_identifier) {
		Identifier oldS_identifier = s_identifier;
		s_identifier = newS_identifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER, oldS_identifier, s_identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER:
				if (resolve) return getS_identifier();
				return basicGetS_identifier();
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
			case VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER:
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
			case VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER:
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
			case VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER:
				return s_identifier != null;
		}
		return super.eIsSet(featureID);
	}

} //IdentifierCmpImpl

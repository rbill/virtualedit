/**
 */
package VObjectModel.impl;

import VObjectModel.Identifier;
import VObjectModel.IdentifierCmp;
import VObjectModel.IdentifierRef;
import VObjectModel.IdentifierRefOrCmp;
import VObjectModel.VObjectModelPackage;

import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
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
	protected IdentifierRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierRefOrCmp basicGetIdentifierreforcmp() {
		return this.identifierreforcmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetS_identifier() {
		return this.s_identifier;
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP:
				return this.identifierreforcmp != null;
			case VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER:
				return this.s_identifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof IdentifierRef) {
			return Objects.equals(this.s_identifier, ((IdentifierRef)o).getS_identifier());
		} else if (o instanceof IdentifierCmp) {
			return Objects.equals(this.s_identifier, ((IdentifierRef)o).getS_identifier());
		}
		return false;
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
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.IDENTIFIER_REF;
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
	public IdentifierRefOrCmp getIdentifierreforcmp() {
		if (this.identifierreforcmp != null && this.identifierreforcmp.eIsProxy()) {
			InternalEObject oldIdentifierreforcmp = (InternalEObject)this.identifierreforcmp;
			this.identifierreforcmp = (IdentifierRefOrCmp)eResolveProxy(oldIdentifierreforcmp);
			if (this.identifierreforcmp != oldIdentifierreforcmp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP, oldIdentifierreforcmp, this.identifierreforcmp));
			}
		}
		return this.identifierreforcmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Identifier getS_identifier() {
		if (this.s_identifier != null && this.s_identifier.eIsProxy()) {
			InternalEObject oldS_identifier = (InternalEObject)this.s_identifier;
			this.s_identifier = (Identifier)eResolveProxy(oldS_identifier);
			if (this.s_identifier != oldS_identifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER, oldS_identifier, this.s_identifier));
			}
		}
		return this.s_identifier;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public int hashCode() {
		return (this.s_identifier==null)?0:this.s_identifier.hashCode();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifierreforcmp(IdentifierRefOrCmp newIdentifierreforcmp) {
		IdentifierRefOrCmp oldIdentifierreforcmp = this.identifierreforcmp;
		this.identifierreforcmp = newIdentifierreforcmp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_REF__IDENTIFIERREFORCMP, oldIdentifierreforcmp, this.identifierreforcmp));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS_identifier(Identifier newS_identifier) {
		Identifier oldS_identifier = this.s_identifier;
		this.s_identifier = newS_identifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_REF__SIDENTIFIER, oldS_identifier, this.s_identifier));
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		Identifier s_identifier2 = getS_identifier();
		if (s_identifier2.getName() != null) {
			return "@"+s_identifier2.getName();
		} else {
			return String.valueOf(s_identifier2);
		}
	}

} //IdentifierRefImpl

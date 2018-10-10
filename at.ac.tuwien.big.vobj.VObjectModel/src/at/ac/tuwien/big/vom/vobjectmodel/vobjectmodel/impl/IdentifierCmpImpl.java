/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Cmp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierCmpImpl#getS_identifier <em>Sidentifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifierCmpImpl extends IdentifierRefOrCmpImpl implements IdentifierCmp {
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
	protected IdentifierCmpImpl() {
		super();
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER, oldS_identifier, newS_identifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER:
				return s_identifier != null;
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
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.IDENTIFIER_CMP;
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
	public Identifier getS_identifier() {
		return s_identifier;
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
	public void setS_identifier(Identifier newS_identifier) {
		if (newS_identifier != s_identifier) {
			NotificationChain msgs = null;
			if (s_identifier != null)
				msgs = ((InternalEObject)s_identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER, null, msgs);
			if (newS_identifier != null)
				msgs = ((InternalEObject)newS_identifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER, null, msgs);
			msgs = basicSetS_identifier(newS_identifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_CMP__SIDENTIFIER, newS_identifier, newS_identifier));
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return String.valueOf(getS_identifier());
	}
} //IdentifierCmpImpl

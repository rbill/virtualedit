/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierParam;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierParamImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierParamImpl#getIdentifierPars <em>Identifier Pars</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifierParamImpl extends MinimalEObjectImpl.Container implements IdentifierParam {
	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier identifier;

	/**
	 * The cached value of the '{@link #getIdentifierPars() <em>Identifier Pars</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierPars()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> identifierPars;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.IDENTIFIER_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getIdentifier() {
		if (identifier != null && identifier.eIsProxy()) {
			InternalEObject oldIdentifier = (InternalEObject)identifier;
			identifier = (Identifier)eResolveProxy(oldIdentifier);
			if (identifier != oldIdentifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER, oldIdentifier, identifier));
			}
		}
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(Identifier newIdentifier) {
		Identifier oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifier> getIdentifierPars() {
		if (identifierPars == null) {
			identifierPars = new EObjectResolvingEList<Identifier>(Identifier.class, this, VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER_PARS);
		}
		return identifierPars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER:
				if (resolve) return getIdentifier();
				return basicGetIdentifier();
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER_PARS:
				return getIdentifierPars();
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
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER:
				setIdentifier((Identifier)newValue);
				return;
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER_PARS:
				getIdentifierPars().clear();
				getIdentifierPars().addAll((Collection<? extends Identifier>)newValue);
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
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER:
				setIdentifier((Identifier)null);
				return;
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER_PARS:
				getIdentifierPars().clear();
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
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER:
				return identifier != null;
			case VObjectModelPackage.IDENTIFIER_PARAM__IDENTIFIER_PARS:
				return identifierPars != null && !identifierPars.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IdentifierParamImpl

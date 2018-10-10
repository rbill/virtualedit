/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Pair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.ValuePairImpl#getKey <em>Key</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.ValuePairImpl#getValue <em>Value</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.ValuePairImpl#getIdentifierValue <em>Identifier Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValuePairImpl extends MinimalEObjectImpl.Container implements ValuePair {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final Object KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected Object key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIdentifierValue() <em>Identifier Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierValue()
	 * @generated
	 * @ordered
	 */
	protected Identifier identifierValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValuePairImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.VALUE_PAIR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(Object newKey) {
		Object oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.VALUE_PAIR__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.VALUE_PAIR__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getIdentifierValue() {
		if (identifierValue != null && identifierValue.eIsProxy()) {
			InternalEObject oldIdentifierValue = (InternalEObject)identifierValue;
			identifierValue = (Identifier)eResolveProxy(oldIdentifierValue);
			if (identifierValue != oldIdentifierValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VObjectModelPackage.VALUE_PAIR__IDENTIFIER_VALUE, oldIdentifierValue, identifierValue));
			}
		}
		return identifierValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetIdentifierValue() {
		return identifierValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierValue(Identifier newIdentifierValue) {
		Identifier oldIdentifierValue = identifierValue;
		identifierValue = newIdentifierValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.VALUE_PAIR__IDENTIFIER_VALUE, oldIdentifierValue, identifierValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.VALUE_PAIR__KEY:
				return getKey();
			case VObjectModelPackage.VALUE_PAIR__VALUE:
				return getValue();
			case VObjectModelPackage.VALUE_PAIR__IDENTIFIER_VALUE:
				if (resolve) return getIdentifierValue();
				return basicGetIdentifierValue();
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
			case VObjectModelPackage.VALUE_PAIR__KEY:
				setKey(newValue);
				return;
			case VObjectModelPackage.VALUE_PAIR__VALUE:
				setValue(newValue);
				return;
			case VObjectModelPackage.VALUE_PAIR__IDENTIFIER_VALUE:
				setIdentifierValue((Identifier)newValue);
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
			case VObjectModelPackage.VALUE_PAIR__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case VObjectModelPackage.VALUE_PAIR__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case VObjectModelPackage.VALUE_PAIR__IDENTIFIER_VALUE:
				setIdentifierValue((Identifier)null);
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
			case VObjectModelPackage.VALUE_PAIR__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case VObjectModelPackage.VALUE_PAIR__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case VObjectModelPackage.VALUE_PAIR__IDENTIFIER_VALUE:
				return identifierValue != null;
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
		result.append(" (key: ");
		result.append(key);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ValuePairImpl

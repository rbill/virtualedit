/**
 */
package VObjectModel.impl;

import VObjectModel.EcoreDef;
import VObjectModel.VObjectModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.EcoreDefImpl#getFactoryPackage <em>Factory Package</em>}</li>
 *   <li>{@link VObjectModel.impl.EcoreDefImpl#getPackagePackage <em>Package Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EcoreDefImpl extends MinimalEObjectImpl.Container implements EcoreDef {
	/**
	 * The default value of the '{@link #getFactoryPackage() <em>Factory Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String FACTORY_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFactoryPackage() <em>Factory Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryPackage()
	 * @generated
	 * @ordered
	 */
	protected String factoryPackage = FACTORY_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackagePackage() <em>Package Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackagePackage() <em>Package Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePackage()
	 * @generated
	 * @ordered
	 */
	protected String packagePackage = PACKAGE_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.ECORE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactoryPackage() {
		return factoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactoryPackage(String newFactoryPackage) {
		String oldFactoryPackage = factoryPackage;
		factoryPackage = newFactoryPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.ECORE_DEF__FACTORY_PACKAGE, oldFactoryPackage, factoryPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackagePackage() {
		return packagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackagePackage(String newPackagePackage) {
		String oldPackagePackage = packagePackage;
		packagePackage = newPackagePackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.ECORE_DEF__PACKAGE_PACKAGE, oldPackagePackage, packagePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.ECORE_DEF__FACTORY_PACKAGE:
				return getFactoryPackage();
			case VObjectModelPackage.ECORE_DEF__PACKAGE_PACKAGE:
				return getPackagePackage();
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
			case VObjectModelPackage.ECORE_DEF__FACTORY_PACKAGE:
				setFactoryPackage((String)newValue);
				return;
			case VObjectModelPackage.ECORE_DEF__PACKAGE_PACKAGE:
				setPackagePackage((String)newValue);
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
			case VObjectModelPackage.ECORE_DEF__FACTORY_PACKAGE:
				setFactoryPackage(FACTORY_PACKAGE_EDEFAULT);
				return;
			case VObjectModelPackage.ECORE_DEF__PACKAGE_PACKAGE:
				setPackagePackage(PACKAGE_PACKAGE_EDEFAULT);
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
			case VObjectModelPackage.ECORE_DEF__FACTORY_PACKAGE:
				return FACTORY_PACKAGE_EDEFAULT == null ? factoryPackage != null : !FACTORY_PACKAGE_EDEFAULT.equals(factoryPackage);
			case VObjectModelPackage.ECORE_DEF__PACKAGE_PACKAGE:
				return PACKAGE_PACKAGE_EDEFAULT == null ? packagePackage != null : !PACKAGE_PACKAGE_EDEFAULT.equals(packagePackage);
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
		result.append(" (factoryPackage: ");
		result.append(factoryPackage);
		result.append(", packagePackage: ");
		result.append(packagePackage);
		result.append(')');
		return result.toString();
	}

} //EcoreDefImpl

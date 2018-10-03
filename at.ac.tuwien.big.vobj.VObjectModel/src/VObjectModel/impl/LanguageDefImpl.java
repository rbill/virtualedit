/**
 */
package VObjectModel.impl;

import VObjectModel.LanguageDef;
import VObjectModel.VObjectModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.LanguageDefImpl#getLangStandaloneSetup <em>Lang Standalone Setup</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LanguageDefImpl extends MinimalEObjectImpl.Container implements LanguageDef {
	/**
	 * The default value of the '{@link #getLangStandaloneSetup() <em>Lang Standalone Setup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLangStandaloneSetup()
	 * @generated
	 * @ordered
	 */
	protected static final String LANG_STANDALONE_SETUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLangStandaloneSetup() <em>Lang Standalone Setup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLangStandaloneSetup()
	 * @generated
	 * @ordered
	 */
	protected String langStandaloneSetup = LANG_STANDALONE_SETUP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.LANGUAGE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLangStandaloneSetup() {
		return langStandaloneSetup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLangStandaloneSetup(String newLangStandaloneSetup) {
		String oldLangStandaloneSetup = langStandaloneSetup;
		langStandaloneSetup = newLangStandaloneSetup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.LANGUAGE_DEF__LANG_STANDALONE_SETUP, oldLangStandaloneSetup, langStandaloneSetup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.LANGUAGE_DEF__LANG_STANDALONE_SETUP:
				return getLangStandaloneSetup();
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
			case VObjectModelPackage.LANGUAGE_DEF__LANG_STANDALONE_SETUP:
				setLangStandaloneSetup((String)newValue);
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
			case VObjectModelPackage.LANGUAGE_DEF__LANG_STANDALONE_SETUP:
				setLangStandaloneSetup(LANG_STANDALONE_SETUP_EDEFAULT);
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
			case VObjectModelPackage.LANGUAGE_DEF__LANG_STANDALONE_SETUP:
				return LANG_STANDALONE_SETUP_EDEFAULT == null ? langStandaloneSetup != null : !LANG_STANDALONE_SETUP_EDEFAULT.equals(langStandaloneSetup);
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
		result.append(" (langStandaloneSetup: ");
		result.append(langStandaloneSetup);
		result.append(')');
		return result.toString();
	}

} //LanguageDefImpl

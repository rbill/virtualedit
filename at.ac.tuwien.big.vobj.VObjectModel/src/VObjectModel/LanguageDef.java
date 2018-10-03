/**
 */
package VObjectModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.LanguageDef#getLangStandaloneSetup <em>Lang Standalone Setup</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getLanguageDef()
 * @model
 * @generated
 */
public interface LanguageDef extends EObject {
	/**
	 * Returns the value of the '<em><b>Lang Standalone Setup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lang Standalone Setup</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lang Standalone Setup</em>' attribute.
	 * @see #setLangStandaloneSetup(String)
	 * @see VObjectModel.VObjectModelPackage#getLanguageDef_LangStandaloneSetup()
	 * @model
	 * @generated
	 */
	String getLangStandaloneSetup();

	/**
	 * Sets the value of the '{@link VObjectModel.LanguageDef#getLangStandaloneSetup <em>Lang Standalone Setup</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lang Standalone Setup</em>' attribute.
	 * @see #getLangStandaloneSetup()
	 * @generated
	 */
	void setLangStandaloneSetup(String value);

} // LanguageDef

/**
 */
package VObjectModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stored Funcs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.StoredFuncs#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link VObjectModel.StoredFuncs#getFeaturefunc <em>Featurefunc</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getStoredFuncs()
 * @model
 * @generated
 */
public interface StoredFuncs extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference.
	 * @see #setIdentifier(Identifier)
	 * @see VObjectModel.VObjectModelPackage#getStoredFuncs_Identifier()
	 * @model containment="true"
	 * @generated
	 */
	Identifier getIdentifier();

	/**
	 * Sets the value of the '{@link VObjectModel.StoredFuncs#getIdentifier <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' containment reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(Identifier value);

	/**
	 * Returns the value of the '<em><b>Featurefunc</b></em>' containment reference list.
	 * The list contents are of type {@link VObjectModel.FeatureFunc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featurefunc</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featurefunc</em>' containment reference list.
	 * @see VObjectModel.VObjectModelPackage#getStoredFuncs_Featurefunc()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureFunc> getFeaturefunc();

} // StoredFuncs

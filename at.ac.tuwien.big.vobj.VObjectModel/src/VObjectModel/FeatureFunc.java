/**
 */
package VObjectModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Func</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.FeatureFunc#getDeltastore <em>Deltastore</em>}</li>
 *   <li>{@link VObjectModel.FeatureFunc#getName <em>Name</em>}</li>
 *   <li>{@link VObjectModel.FeatureFunc#getClassref <em>Classref</em>}</li>
 *   <li>{@link VObjectModel.FeatureFunc#getNsref <em>Nsref</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getFeatureFunc()
 * @model
 * @generated
 */
public interface FeatureFunc extends EObject {
	/**
	 * Returns the value of the '<em><b>Deltastore</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deltastore</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deltastore</em>' containment reference.
	 * @see #setDeltastore(DeltaStore)
	 * @see VObjectModel.VObjectModelPackage#getFeatureFunc_Deltastore()
	 * @model containment="true"
	 * @generated
	 */
	DeltaStore getDeltastore();

	/**
	 * Sets the value of the '{@link VObjectModel.FeatureFunc#getDeltastore <em>Deltastore</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deltastore</em>' containment reference.
	 * @see #getDeltastore()
	 * @generated
	 */
	void setDeltastore(DeltaStore value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see VObjectModel.VObjectModelPackage#getFeatureFunc_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link VObjectModel.FeatureFunc#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Classref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classref</em>' attribute.
	 * @see #setClassref(String)
	 * @see VObjectModel.VObjectModelPackage#getFeatureFunc_Classref()
	 * @model
	 * @generated
	 */
	String getClassref();

	/**
	 * Sets the value of the '{@link VObjectModel.FeatureFunc#getClassref <em>Classref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classref</em>' attribute.
	 * @see #getClassref()
	 * @generated
	 */
	void setClassref(String value);

	/**
	 * Returns the value of the '<em><b>Nsref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nsref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nsref</em>' attribute.
	 * @see #setNsref(String)
	 * @see VObjectModel.VObjectModelPackage#getFeatureFunc_Nsref()
	 * @model
	 * @generated
	 */
	String getNsref();

	/**
	 * Sets the value of the '{@link VObjectModel.FeatureFunc#getNsref <em>Nsref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nsref</em>' attribute.
	 * @see #getNsref()
	 * @generated
	 */
	void setNsref(String value);

} // FeatureFunc

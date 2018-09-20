/**
 */
package VObjectModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.Identifier#getIdentifierreforcmp <em>Identifierreforcmp</em>}</li>
 *   <li>{@link VObjectModel.Identifier#getName <em>Name</em>}</li>
 *   <li>{@link VObjectModel.Identifier#getCreatorid <em>Creatorid</em>}</li>
 *   <li>{@link VObjectModel.Identifier#getHc <em>Hc</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getIdentifier()
 * @model
 * @generated
 */
public interface Identifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifierreforcmp</b></em>' containment reference list.
	 * The list contents are of type {@link VObjectModel.AnyValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifierreforcmp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifierreforcmp</em>' containment reference list.
	 * @see VObjectModel.VObjectModelPackage#getIdentifier_Identifierreforcmp()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnyValue> getIdentifierreforcmp();

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
	 * @see VObjectModel.VObjectModelPackage#getIdentifier_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link VObjectModel.Identifier#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Creatorid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creatorid</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creatorid</em>' containment reference.
	 * @see #setCreatorid(CreatorId)
	 * @see VObjectModel.VObjectModelPackage#getIdentifier_Creatorid()
	 * @model containment="true"
	 * @generated
	 */
	CreatorId getCreatorid();

	/**
	 * Sets the value of the '{@link VObjectModel.Identifier#getCreatorid <em>Creatorid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creatorid</em>' containment reference.
	 * @see #getCreatorid()
	 * @generated
	 */
	void setCreatorid(CreatorId value);

	/**
	 * Returns the value of the '<em><b>Hc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hc</em>' attribute.
	 * @see #setHc(int)
	 * @see VObjectModel.VObjectModelPackage#getIdentifier_Hc()
	 * @model required="true"
	 * @generated
	 */
	int getHc();

	/**
	 * Sets the value of the '{@link VObjectModel.Identifier#getHc <em>Hc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hc</em>' attribute.
	 * @see #getHc()
	 * @generated
	 */
	void setHc(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean equals(Identifier id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init();

} // Identifier

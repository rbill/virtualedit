/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Creator Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCreatorId()
 * @model
 * @generated
 */
public interface CreatorId extends EObject {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCreatorId_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

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
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCreatorId_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CreatorId

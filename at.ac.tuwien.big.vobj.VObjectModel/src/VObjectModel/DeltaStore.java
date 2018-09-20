/**
 */
package VObjectModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delta Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.DeltaStore#getAddMap <em>Add Map</em>}</li>
 *   <li>{@link VObjectModel.DeltaStore#getFilterScope <em>Filter Scope</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getDeltaStore()
 * @model
 * @generated
 */
public interface DeltaStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Add Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Map</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Map</em>' reference.
	 * @see #setAddMap(BasicFunction)
	 * @see VObjectModel.VObjectModelPackage#getDeltaStore_AddMap()
	 * @model
	 * @generated
	 */
	BasicFunction getAddMap();

	/**
	 * Sets the value of the '{@link VObjectModel.DeltaStore#getAddMap <em>Add Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Map</em>' reference.
	 * @see #getAddMap()
	 * @generated
	 */
	void setAddMap(BasicFunction value);

	/**
	 * Returns the value of the '<em><b>Filter Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Scope</em>' reference.
	 * @see #setFilterScope(BasicFunction)
	 * @see VObjectModel.VObjectModelPackage#getDeltaStore_FilterScope()
	 * @model
	 * @generated
	 */
	BasicFunction getFilterScope();

	/**
	 * Sets the value of the '{@link VObjectModel.DeltaStore#getFilterScope <em>Filter Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Scope</em>' reference.
	 * @see #getFilterScope()
	 * @generated
	 */
	void setFilterScope(BasicFunction value);

} // DeltaStore

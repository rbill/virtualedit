/**
 */
package VObjectModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VObj Delta Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.VObjDeltaModel#getFunctions <em>Functions</em>}</li>
 *   <li>{@link VObjectModel.VObjDeltaModel#getStoredfuncs <em>Storedfuncs</em>}</li>
 *   <li>{@link VObjectModel.VObjDeltaModel#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getVObjDeltaModel()
 * @model
 * @generated
 */
public interface VObjDeltaModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link VObjectModel.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see VObjectModel.VObjectModelPackage#getVObjDeltaModel_Functions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Storedfuncs</b></em>' containment reference list.
	 * The list contents are of type {@link VObjectModel.StoredFuncs}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storedfuncs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storedfuncs</em>' containment reference list.
	 * @see VObjectModel.VObjectModelPackage#getVObjDeltaModel_Storedfuncs()
	 * @model containment="true"
	 * @generated
	 */
	EList<StoredFuncs> getStoredfuncs();

	/**
	 * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link VObjectModel.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' containment reference list.
	 * @see VObjectModel.VObjectModelPackage#getVObjDeltaModel_Identifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Identifier> getIdentifiers();

} // VObjDeltaModel

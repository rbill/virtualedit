/**
 */
package VObjectModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Finite Union Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.FiniteUnionFunction#getBaseFunc <em>Base Func</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getFiniteUnionFunction()
 * @model
 * @generated
 */
public interface FiniteUnionFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Func</b></em>' reference list.
	 * The list contents are of type {@link VObjectModel.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Func</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Func</em>' reference list.
	 * @see VObjectModel.VObjectModelPackage#getFiniteUnionFunction_BaseFunc()
	 * @model
	 * @generated
	 */
	EList<Function> getBaseFunc();

} // FiniteUnionFunction

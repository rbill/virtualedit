/**
 */
package Citizen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Citizen.Alle#getCitizens <em>Citizens</em>}</li>
 * </ul>
 *
 * @see Citizen.CitizenPackage#getAlle()
 * @model
 * @generated
 */
public interface Alle extends EObject {
	/**
	 * Returns the value of the '<em><b>Citizens</b></em>' containment reference list.
	 * The list contents are of type {@link Citizen.Burger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Citizens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Citizens</em>' containment reference list.
	 * @see Citizen.CitizenPackage#getAlle_Citizens()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Burger> getCitizens();

} // Alle

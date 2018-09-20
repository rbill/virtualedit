/**
 */
package Citizen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Citizen.CitizenPackage
 * @generated
 */
public interface CitizenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CitizenFactory eINSTANCE = Citizen.impl.CitizenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Alle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alle</em>'.
	 * @generated
	 */
	Alle createAlle();

	/**
	 * Returns a new object of class '<em>Burger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Burger</em>'.
	 * @generated
	 */
	Burger createBurger();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CitizenPackage getCitizenPackage();

} //CitizenFactory

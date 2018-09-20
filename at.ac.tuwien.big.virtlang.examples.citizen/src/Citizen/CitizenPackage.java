/**
 */
package Citizen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Citizen.CitizenFactory
 * @model kind="package"
 * @generated
 */
public interface CitizenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Citizen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/Citizen";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Citizen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CitizenPackage eINSTANCE = Citizen.impl.CitizenPackageImpl.init();

	/**
	 * The meta object id for the '{@link Citizen.impl.AlleImpl <em>Alle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Citizen.impl.AlleImpl
	 * @see Citizen.impl.CitizenPackageImpl#getAlle()
	 * @generated
	 */
	int ALLE = 0;

	/**
	 * The feature id for the '<em><b>Citizens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLE__CITIZENS = 0;

	/**
	 * The number of structural features of the '<em>Alle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Alle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Citizen.impl.BurgerImpl <em>Burger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Citizen.impl.BurgerImpl
	 * @see Citizen.impl.CitizenPackageImpl#getBurger()
	 * @generated
	 */
	int BURGER = 1;

	/**
	 * The feature id for the '<em><b>Svnr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURGER__SVNR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURGER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURGER__ADDRESS = 2;

	/**
	 * The number of structural features of the '<em>Burger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURGER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Burger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURGER_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Citizen.Alle <em>Alle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alle</em>'.
	 * @see Citizen.Alle
	 * @generated
	 */
	EClass getAlle();

	/**
	 * Returns the meta object for the containment reference list '{@link Citizen.Alle#getCitizens <em>Citizens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Citizens</em>'.
	 * @see Citizen.Alle#getCitizens()
	 * @see #getAlle()
	 * @generated
	 */
	EReference getAlle_Citizens();

	/**
	 * Returns the meta object for class '{@link Citizen.Burger <em>Burger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Burger</em>'.
	 * @see Citizen.Burger
	 * @generated
	 */
	EClass getBurger();

	/**
	 * Returns the meta object for the attribute '{@link Citizen.Burger#getSvnr <em>Svnr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Svnr</em>'.
	 * @see Citizen.Burger#getSvnr()
	 * @see #getBurger()
	 * @generated
	 */
	EAttribute getBurger_Svnr();

	/**
	 * Returns the meta object for the attribute '{@link Citizen.Burger#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Citizen.Burger#getName()
	 * @see #getBurger()
	 * @generated
	 */
	EAttribute getBurger_Name();

	/**
	 * Returns the meta object for the attribute '{@link Citizen.Burger#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see Citizen.Burger#getAddress()
	 * @see #getBurger()
	 * @generated
	 */
	EAttribute getBurger_Address();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CitizenFactory getCitizenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Citizen.impl.AlleImpl <em>Alle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Citizen.impl.AlleImpl
		 * @see Citizen.impl.CitizenPackageImpl#getAlle()
		 * @generated
		 */
		EClass ALLE = eINSTANCE.getAlle();

		/**
		 * The meta object literal for the '<em><b>Citizens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLE__CITIZENS = eINSTANCE.getAlle_Citizens();

		/**
		 * The meta object literal for the '{@link Citizen.impl.BurgerImpl <em>Burger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Citizen.impl.BurgerImpl
		 * @see Citizen.impl.CitizenPackageImpl#getBurger()
		 * @generated
		 */
		EClass BURGER = eINSTANCE.getBurger();

		/**
		 * The meta object literal for the '<em><b>Svnr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BURGER__SVNR = eINSTANCE.getBurger_Svnr();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BURGER__NAME = eINSTANCE.getBurger_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BURGER__ADDRESS = eINSTANCE.getBurger_Address();

	}

} //CitizenPackage

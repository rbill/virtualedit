/**
 */
package VObjectModel.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>VObjectModel</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class VObjectModelTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new VObjectModelTests("VObjectModel Tests");
		suite.addTestSuite(IdentifierTest.class);
		suite.addTestSuite(IdentifierRefOrCmpTest.class);
		suite.addTestSuite(IdentifierRefTest.class);
		suite.addTestSuite(IdentifierCmpTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjectModelTests(String name) {
		super(name);
	}

} //VObjectModelTests

/**
 */
package VObjectModel.tests;

import VObjectModel.IdentifierCmp;
import VObjectModel.VObjectModelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifier Cmp</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IdentifierCmpTest extends IdentifierRefOrCmpTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IdentifierCmpTest.class);
	}

	/**
	 * Constructs a new Identifier Cmp test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCmpTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Identifier Cmp test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IdentifierCmp getFixture() {
		return (IdentifierCmp)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VObjectModelFactory.eINSTANCE.createIdentifierCmp());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //IdentifierCmpTest

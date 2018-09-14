/**
 */
package VObjectModel.tests;

import VObjectModel.IdentifierRef;
import VObjectModel.VObjectModelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifier Ref</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IdentifierRefTest extends IdentifierRefOrCmpTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IdentifierRefTest.class);
	}

	/**
	 * Constructs a new Identifier Ref test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierRefTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Identifier Ref test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IdentifierRef getFixture() {
		return (IdentifierRef)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VObjectModelFactory.eINSTANCE.createIdentifierRef());
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

} //IdentifierRefTest

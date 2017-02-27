/**
 */
package simplejava.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import simplejava.SimpleStatement;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Simple Statement</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleStatementTest extends TestCase {

	/**
	 * The fixture for this Simple Statement test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleStatement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimpleStatementTest.class);
	}

	/**
	 * Constructs a new Simple Statement test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleStatementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Simple Statement test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SimpleStatement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Simple Statement test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleStatement getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createSimpleStatement());
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

} //SimpleStatementTest

/**
 */
package simplejava.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import simplejava.SimpleJava;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Simple Java</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleJavaTest extends TestCase {

	/**
	 * The fixture for this Simple Java test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleJava fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimpleJavaTest.class);
	}

	/**
	 * Constructs a new Simple Java test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleJavaTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Simple Java test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SimpleJava fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Simple Java test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleJava getFixture() {
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
		setFixture(SimplejavaFactory.eINSTANCE.createSimpleJava());
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

} //SimpleJavaTest

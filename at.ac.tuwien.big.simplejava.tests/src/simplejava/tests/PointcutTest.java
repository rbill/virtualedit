/**
 */
package simplejava.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import simplejava.Pointcut;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PointcutTest extends TestCase {

	/**
	 * The fixture for this Pointcut test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Pointcut fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PointcutTest.class);
	}

	/**
	 * Constructs a new Pointcut test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointcutTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Pointcut test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Pointcut fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Pointcut test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Pointcut getFixture() {
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
		setFixture(SimplejavaFactory.eINSTANCE.createPointcut());
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

} //PointcutTest

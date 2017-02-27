/**
 */
package simplejava.tests;

import junit.textui.TestRunner;

import simplejava.BinaryPointcutCondition;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Binary Pointcut Condition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BinaryPointcutConditionTest extends PointcutConditionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BinaryPointcutConditionTest.class);
	}

	/**
	 * Constructs a new Binary Pointcut Condition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryPointcutConditionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Binary Pointcut Condition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BinaryPointcutCondition getFixture() {
		return (BinaryPointcutCondition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createBinaryPointcutCondition());
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

} //BinaryPointcutConditionTest

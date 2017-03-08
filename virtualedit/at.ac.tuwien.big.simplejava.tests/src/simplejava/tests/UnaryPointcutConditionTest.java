/**
 */
package simplejava.tests;

import junit.textui.TestRunner;

import simplejava.SimplejavaFactory;
import simplejava.UnaryPointcutCondition;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Unary Pointcut Condition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnaryPointcutConditionTest extends PointcutConditionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UnaryPointcutConditionTest.class);
	}

	/**
	 * Constructs a new Unary Pointcut Condition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryPointcutConditionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Unary Pointcut Condition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected UnaryPointcutCondition getFixture() {
		return (UnaryPointcutCondition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createUnaryPointcutCondition());
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

} //UnaryPointcutConditionTest

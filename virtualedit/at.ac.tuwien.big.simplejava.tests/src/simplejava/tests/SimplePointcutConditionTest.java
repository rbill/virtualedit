/**
 */
package simplejava.tests;

import junit.textui.TestRunner;

import simplejava.SimplePointcutCondition;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Simple Pointcut Condition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimplePointcutConditionTest extends PointcutConditionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimplePointcutConditionTest.class);
	}

	/**
	 * Constructs a new Simple Pointcut Condition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePointcutConditionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Simple Pointcut Condition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SimplePointcutCondition getFixture() {
		return (SimplePointcutCondition)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createSimplePointcutCondition());
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

} //SimplePointcutConditionTest

/**
 */
package simplejava.tests;

import junit.textui.TestRunner;

import simplejava.IntegerExpression;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Expression</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntegerExpressionTest extends ConstantExpressionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerExpressionTest.class);
	}

	/**
	 * Constructs a new Integer Expression test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerExpressionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Expression test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IntegerExpression getFixture() {
		return (IntegerExpression)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createIntegerExpression());
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

} //IntegerExpressionTest

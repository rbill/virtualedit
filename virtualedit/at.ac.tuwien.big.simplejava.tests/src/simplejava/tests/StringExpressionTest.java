/**
 */
package simplejava.tests;

import junit.textui.TestRunner;

import simplejava.SimplejavaFactory;
import simplejava.StringExpression;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Expression</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringExpressionTest extends ConstantExpressionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StringExpressionTest.class);
	}

	/**
	 * Constructs a new String Expression test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringExpressionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this String Expression test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected StringExpression getFixture() {
		return (StringExpression)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createStringExpression());
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

} //StringExpressionTest

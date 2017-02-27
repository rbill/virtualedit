/**
 */
package simplejava.tests;

import junit.textui.TestRunner;

import simplejava.NullExpression;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Null Expression</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NullExpressionTest extends ConstantExpressionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NullExpressionTest.class);
	}

	/**
	 * Constructs a new Null Expression test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullExpressionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Null Expression test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NullExpression getFixture() {
		return (NullExpression)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createNullExpression());
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

} //NullExpressionTest

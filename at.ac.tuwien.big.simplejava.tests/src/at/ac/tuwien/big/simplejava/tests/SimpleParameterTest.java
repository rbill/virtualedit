/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.simplejava.tests;

import at.ac.tuwien.big.simplejava.SimpleParameter;
import at.ac.tuwien.big.simplejava.SimplejavaFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Simple Parameter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleParameterTest extends ParameterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimpleParameterTest.class);
	}

	/**
	 * Constructs a new Simple Parameter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleParameterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Simple Parameter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SimpleParameter getFixture() {
		return (SimpleParameter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createSimpleParameter());
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

} //SimpleParameterTest

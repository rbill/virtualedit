/**
 */
package simplejava.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import simplejava.ForeignAttribute;
import simplejava.SimplejavaFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Foreign Attribute</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForeignAttributeTest extends TestCase {

	/**
	 * The fixture for this Foreign Attribute test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForeignAttribute fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ForeignAttributeTest.class);
	}

	/**
	 * Constructs a new Foreign Attribute test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignAttributeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Foreign Attribute test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ForeignAttribute fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Foreign Attribute test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForeignAttribute getFixture() {
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
		setFixture(SimplejavaFactory.eINSTANCE.createForeignAttribute());
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

} //ForeignAttributeTest

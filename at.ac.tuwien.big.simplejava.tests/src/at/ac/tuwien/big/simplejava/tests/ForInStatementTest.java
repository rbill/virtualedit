/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.simplejava.tests;

import at.ac.tuwien.big.simplejava.ForInStatement;
import at.ac.tuwien.big.simplejava.SimplejavaFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>For In Statement</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ForInStatementTest extends StatementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ForInStatementTest.class);
	}

	/**
	 * Constructs a new For In Statement test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForInStatementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this For In Statement test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ForInStatement getFixture() {
		return (ForInStatement)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SimplejavaFactory.eINSTANCE.createForInStatement());
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

} //ForInStatementTest

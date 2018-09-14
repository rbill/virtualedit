/**
 */
package VObjectModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see VObjectModel.VObjectModelPackage
 * @generated
 */
public interface VObjectModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VObjectModelFactory eINSTANCE = VObjectModel.impl.VObjectModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier</em>'.
	 * @generated
	 */
	Identifier createIdentifier();

	/**
	 * Returns a new object of class '<em>Identifier Ref Or Cmp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Ref Or Cmp</em>'.
	 * @generated
	 */
	IdentifierRefOrCmp createIdentifierRefOrCmp();

	/**
	 * Returns a new object of class '<em>Identifier Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Ref</em>'.
	 * @generated
	 */
	IdentifierRef createIdentifierRef();

	/**
	 * Returns a new object of class '<em>Identifier Cmp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Identifier Cmp</em>'.
	 * @generated
	 */
	IdentifierCmp createIdentifierCmp();

	/**
	 * Returns a new object of class '<em>Creator Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Creator Id</em>'.
	 * @generated
	 */
	CreatorId createCreatorId();

	/**
	 * Returns a new object of class '<em>Any Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any Value</em>'.
	 * @generated
	 */
	AnyValue createAnyValue();

	/**
	 * Returns a new object of class '<em>Java Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Value</em>'.
	 * @generated
	 */
	JavaValue createJavaValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VObjectModelPackage getVObjectModelPackage();

} //VObjectModelFactory

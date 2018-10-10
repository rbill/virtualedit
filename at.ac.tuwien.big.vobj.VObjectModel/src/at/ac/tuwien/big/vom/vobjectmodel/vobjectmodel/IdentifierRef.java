/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getIdentifierreforcmp <em>Identifierreforcmp</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getS_identifier <em>Sidentifier</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getIdentifierRef()
 * @model
 * @generated
 */
public interface IdentifierRef extends IdentifierRefOrCmp {
	/**
	 * Returns the value of the '<em><b>Identifierreforcmp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifierreforcmp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifierreforcmp</em>' reference.
	 * @see #setIdentifierreforcmp(IdentifierRefOrCmp)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getIdentifierRef_Identifierreforcmp()
	 * @model
	 * @generated
	 */
	IdentifierRefOrCmp getIdentifierreforcmp();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getIdentifierreforcmp <em>Identifierreforcmp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifierreforcmp</em>' reference.
	 * @see #getIdentifierreforcmp()
	 * @generated
	 */
	void setIdentifierreforcmp(IdentifierRefOrCmp value);

	/**
	 * Returns the value of the '<em><b>Sidentifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sidentifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sidentifier</em>' reference.
	 * @see #setS_identifier(Identifier)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getIdentifierRef_S_identifier()
	 * @model
	 * @generated
	 */
	Identifier getS_identifier();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getS_identifier <em>Sidentifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sidentifier</em>' reference.
	 * @see #getS_identifier()
	 * @generated
	 */
	void setS_identifier(Identifier value);

} // IdentifierRef

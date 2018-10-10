/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Cmp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp#getS_identifier <em>Sidentifier</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getIdentifierCmp()
 * @model
 * @generated
 */
public interface IdentifierCmp extends IdentifierRefOrCmp {
	/**
	 * Returns the value of the '<em><b>Sidentifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sidentifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sidentifier</em>' containment reference.
	 * @see #setS_identifier(Identifier)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getIdentifierCmp_S_identifier()
	 * @model containment="true"
	 * @generated
	 */
	Identifier getS_identifier();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp#getS_identifier <em>Sidentifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sidentifier</em>' containment reference.
	 * @see #getS_identifier()
	 * @generated
	 */
	void setS_identifier(Identifier value);

} // IdentifierCmp

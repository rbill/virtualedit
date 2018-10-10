/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Ref Or Cmp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getIdentifierRefOrCmp()
 * @model
 * @generated
 */
public interface IdentifierRefOrCmp extends AnyValue {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' reference.
	 * @see #setIdentifier(Identifier)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getIdentifierRefOrCmp_Identifier()
	 * @model derived="true"
	 * @generated
	 */
	Identifier getIdentifier();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp#getIdentifier <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(Identifier value);

} // IdentifierRefOrCmp

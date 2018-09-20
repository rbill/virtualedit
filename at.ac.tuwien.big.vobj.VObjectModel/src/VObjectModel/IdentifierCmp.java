/**
 */
package VObjectModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Cmp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.IdentifierCmp#getS_identifier <em>Sidentifier</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getIdentifierCmp()
 * @model
 * @generated
 */
public interface IdentifierCmp extends IdentifierRefOrCmp {
	/**
	 * Returns the value of the '<em><b>Sidentifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sidentifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sidentifier</em>' containment reference.
	 * @see #setS_identifier(Identifier)
	 * @see VObjectModel.VObjectModelPackage#getIdentifierCmp_S_identifier()
	 * @model containment="true"
	 * @generated
	 */
	Identifier getS_identifier();

	/**
	 * Sets the value of the '{@link VObjectModel.IdentifierCmp#getS_identifier <em>Sidentifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sidentifier</em>' containment reference.
	 * @see #getS_identifier()
	 * @generated
	 */
	void setS_identifier(Identifier value);

} // IdentifierCmp

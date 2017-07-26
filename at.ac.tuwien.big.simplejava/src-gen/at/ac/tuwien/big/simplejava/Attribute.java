/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.simplejava;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.simplejava.Attribute#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Parameter
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(GenericExpression)
   * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getAttribute_Expression()
   * @model containment="true"
   * @generated
   */
  GenericExpression getExpression();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simplejava.Attribute#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(GenericExpression value);

} // Attribute

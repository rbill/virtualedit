/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.simplejava;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.simplejava.UnaryExpression#getType <em>Type</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simplejava.UnaryExpression#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends GenericExpression
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getUnaryExpression_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simplejava.UnaryExpression#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(GenericExpression)
   * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getUnaryExpression_Source()
   * @model containment="true"
   * @generated
   */
  GenericExpression getSource();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simplejava.UnaryExpression#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(GenericExpression value);

} // UnaryExpression

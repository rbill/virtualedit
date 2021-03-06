/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.FunctionCall#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends CalculatedValue, FunctionPars
{
  /**
   * Returns the value of the '<em><b>Function</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' reference.
   * @see #setFunction(FunctionDef)
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getFunctionCall_Function()
   * @model
   * @generated
   */
  FunctionDef getFunction();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionCall#getFunction <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(FunctionDef value);

} // FunctionCall

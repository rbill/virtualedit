/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDef#getType <em>Type</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDef#getInit <em>Init</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDef#getFullAssignment <em>Full Assignment</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getFunctionDef()
 * @model
 * @generated
 */
public interface FunctionDef extends SetOrFunctionDef
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link at.ac.tuwien.big.virtmodel.vLang.FunctionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionType
   * @see #setType(FunctionType)
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getFunctionDef_Type()
   * @model
   * @generated
   */
  FunctionType getType();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDef#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionType
   * @see #getType()
   * @generated
   */
  void setType(FunctionType value);

  /**
   * Returns the value of the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(JavaFunctionCall)
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getFunctionDef_Init()
   * @model containment="true"
   * @generated
   */
  JavaFunctionCall getInit();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDef#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(JavaFunctionCall value);

  /**
   * Returns the value of the '<em><b>Full Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Full Assignment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Full Assignment</em>' containment reference.
   * @see #setFullAssignment(FunctionAssignment)
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getFunctionDef_FullAssignment()
   * @model containment="true"
   * @generated
   */
  FunctionAssignment getFullAssignment();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDef#getFullAssignment <em>Full Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Full Assignment</em>' containment reference.
   * @see #getFullAssignment()
   * @generated
   */
  void setFullAssignment(FunctionAssignment value);

} // FunctionDef
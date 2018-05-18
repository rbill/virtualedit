/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Par Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.ParDef#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getParDef()
 * @model
 * @generated
 */
public interface ParDef extends EObject
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.virtmodel.vLang.FunctionParDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getParDef_Params()
   * @model containment="true"
   * @generated
   */
  EList<FunctionParDef> getParams();

} // ParDef
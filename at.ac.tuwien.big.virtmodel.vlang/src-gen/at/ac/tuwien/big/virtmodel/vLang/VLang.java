/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VLang</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.VLang#getImports <em>Imports</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.VLang#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getVLang()
 * @model
 * @generated
 */
public interface VLang extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.virtmodel.vLang.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getVLang_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Statement</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.virtmodel.vLang.AssignStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statement</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statement</em>' containment reference list.
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getVLang_Statement()
   * @model containment="true"
   * @generated
   */
  EList<AssignStatement> getStatement();

} // VLang

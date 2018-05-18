/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Obj Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.ObjId#getName <em>Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.ObjId#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getObjId()
 * @model
 * @generated
 */
public interface ObjId extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getObjId_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.virtmodel.vLang.ObjId#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.virtmodel.vLang.ObjParam}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage#getObjId_Params()
   * @model containment="true"
   * @generated
   */
  EList<ObjParam> getParams();

} // ObjId
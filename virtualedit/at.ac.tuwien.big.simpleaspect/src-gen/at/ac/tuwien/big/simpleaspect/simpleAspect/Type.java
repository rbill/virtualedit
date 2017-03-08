/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.simpleaspect.simpleAspect;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.Type#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.Type#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.Type#isIsVoid <em>Is Void</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.simpleaspect.simpleAspect.SimpleAspectPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see at.ac.tuwien.big.simpleaspect.simpleAspect.SimpleAspectPackage#getType_TypeName()
   * @model
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simpleaspect.simpleAspect.Type#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' attribute.
   * @see #setTypeRef(String)
   * @see at.ac.tuwien.big.simpleaspect.simpleAspect.SimpleAspectPackage#getType_TypeRef()
   * @model
   * @generated
   */
  String getTypeRef();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simpleaspect.simpleAspect.Type#getTypeRef <em>Type Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' attribute.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(String value);

  /**
   * Returns the value of the '<em><b>Is Void</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Void</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Void</em>' attribute.
   * @see #setIsVoid(boolean)
   * @see at.ac.tuwien.big.simpleaspect.simpleAspect.SimpleAspectPackage#getType_IsVoid()
   * @model
   * @generated
   */
  boolean isIsVoid();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simpleaspect.simpleAspect.Type#isIsVoid <em>Is Void</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Void</em>' attribute.
   * @see #isIsVoid()
   * @generated
   */
  void setIsVoid(boolean value);

} // Type

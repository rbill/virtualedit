/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.simpleaspect.simpleAspect;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pointcut Type Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.PointcutTypeFilter#getClassType <em>Class Type</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.simpleaspect.simpleAspect.SimpleAspectPackage#getPointcutTypeFilter()
 * @model
 * @generated
 */
public interface PointcutTypeFilter extends EObject
{
  /**
   * Returns the value of the '<em><b>Class Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class Type</em>' attribute.
   * @see #setClassType(String)
   * @see at.ac.tuwien.big.simpleaspect.simpleAspect.SimpleAspectPackage#getPointcutTypeFilter_ClassType()
   * @model
   * @generated
   */
  String getClassType();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simpleaspect.simpleAspect.PointcutTypeFilter#getClassType <em>Class Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class Type</em>' attribute.
   * @see #getClassType()
   * @generated
   */
  void setClassType(String value);

} // PointcutTypeFilter

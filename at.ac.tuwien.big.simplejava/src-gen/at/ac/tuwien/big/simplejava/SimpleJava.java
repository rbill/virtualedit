/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.simplejava;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Java</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.simplejava.SimpleJava#getPackage <em>Package</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simplejava.SimpleJava#getImports <em>Imports</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simplejava.SimpleJava#getClazz <em>Clazz</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getSimpleJava()
 * @model
 * @generated
 */
public interface SimpleJava extends EObject
{
  /**
   * Returns the value of the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' containment reference.
   * @see #setPackage(PackageDeclaration)
   * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getSimpleJava_Package()
   * @model containment="true"
   * @generated
   */
  PackageDeclaration getPackage();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simplejava.SimpleJava#getPackage <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' containment reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(PackageDeclaration value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link at.ac.tuwien.big.simplejava.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getSimpleJava_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Clazz</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clazz</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clazz</em>' containment reference.
   * @see #setClazz(ClassDeclaration)
   * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getSimpleJava_Clazz()
   * @model containment="true"
   * @generated
   */
  ClassDeclaration getClazz();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simplejava.SimpleJava#getClazz <em>Clazz</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clazz</em>' containment reference.
   * @see #getClazz()
   * @generated
   */
  void setClazz(ClassDeclaration value);

} // SimpleJava

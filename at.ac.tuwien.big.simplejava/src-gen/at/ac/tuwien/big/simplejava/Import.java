/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.simplejava;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.simplejava.Import#getImported <em>Imported</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
  /**
   * Returns the value of the '<em><b>Imported</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imported</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imported</em>' attribute.
   * @see #setImported(String)
   * @see at.ac.tuwien.big.simplejava.SimplejavaPackage#getImport_Imported()
   * @model
   * @generated
   */
  String getImported();

  /**
   * Sets the value of the '{@link at.ac.tuwien.big.simplejava.Import#getImported <em>Imported</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imported</em>' attribute.
   * @see #getImported()
   * @generated
   */
  void setImported(String value);

} // Import

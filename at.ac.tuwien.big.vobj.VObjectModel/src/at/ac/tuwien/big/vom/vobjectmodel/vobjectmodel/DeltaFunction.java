/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delta Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getWrapped <em>Wrapped</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getDeltastore <em>Deltastore</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getDeltaFunction()
 * @model
 * @generated
 */
public interface DeltaFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Wrapped</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrapped</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrapped</em>' reference.
	 * @see #setWrapped(Function)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getDeltaFunction_Wrapped()
	 * @model
	 * @generated
	 */
	Function getWrapped();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getWrapped <em>Wrapped</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrapped</em>' reference.
	 * @see #getWrapped()
	 * @generated
	 */
	void setWrapped(Function value);

	/**
	 * Returns the value of the '<em><b>Deltastore</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deltastore</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deltastore</em>' containment reference.
	 * @see #setDeltastore(DeltaStore)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getDeltaFunction_Deltastore()
	 * @model containment="true"
	 * @generated
	 */
	DeltaStore getDeltastore();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getDeltastore <em>Deltastore</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deltastore</em>' containment reference.
	 * @see #getDeltastore()
	 * @generated
	 */
	void setDeltastore(DeltaStore value);

} // DeltaFunction

/**
 */
package VObjectModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.ValuePair#getKey <em>Key</em>}</li>
 *   <li>{@link VObjectModel.ValuePair#getValue <em>Value</em>}</li>
 *   <li>{@link VObjectModel.ValuePair#getIdentifierValue <em>Identifier Value</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getValuePair()
 * @model
 * @generated
 */
public interface ValuePair extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(Object)
	 * @see VObjectModel.VObjectModelPackage#getValuePair_Key()
	 * @model
	 * @generated
	 */
	Object getKey();

	/**
	 * Sets the value of the '{@link VObjectModel.ValuePair#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(Object value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see VObjectModel.VObjectModelPackage#getValuePair_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link VObjectModel.ValuePair#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Identifier Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Value</em>' reference.
	 * @see #setIdentifierValue(Identifier)
	 * @see VObjectModel.VObjectModelPackage#getValuePair_IdentifierValue()
	 * @model
	 * @generated
	 */
	Identifier getIdentifierValue();

	/**
	 * Sets the value of the '{@link VObjectModel.ValuePair#getIdentifierValue <em>Identifier Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier Value</em>' reference.
	 * @see #getIdentifierValue()
	 * @generated
	 */
	void setIdentifierValue(Identifier value);

} // ValuePair

/**
 */
package VObjectModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.JavaValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getJavaValue()
 * @model
 * @generated
 */
public interface JavaValue extends AnyValue {
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
	 * @see VObjectModel.VObjectModelPackage#getJavaValue_Value()
	 * @model
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link VObjectModel.JavaValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

} // JavaValue

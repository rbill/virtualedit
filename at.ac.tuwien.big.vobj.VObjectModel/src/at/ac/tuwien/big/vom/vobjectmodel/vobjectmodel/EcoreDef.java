/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ecore Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getFactoryPackage <em>Factory Package</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getPackagePackage <em>Package Package</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getEcoreDef()
 * @model
 * @generated
 */
public interface EcoreDef extends EObject {
	/**
	 * Returns the value of the '<em><b>Factory Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory Package</em>' attribute.
	 * @see #setFactoryPackage(String)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getEcoreDef_FactoryPackage()
	 * @model
	 * @generated
	 */
	String getFactoryPackage();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getFactoryPackage <em>Factory Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory Package</em>' attribute.
	 * @see #getFactoryPackage()
	 * @generated
	 */
	void setFactoryPackage(String value);

	/**
	 * Returns the value of the '<em><b>Package Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Package</em>' attribute.
	 * @see #setPackagePackage(String)
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getEcoreDef_PackagePackage()
	 * @model
	 * @generated
	 */
	String getPackagePackage();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getPackagePackage <em>Package Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Package</em>' attribute.
	 * @see #getPackagePackage()
	 * @generated
	 */
	void setPackagePackage(String value);

} // EcoreDef

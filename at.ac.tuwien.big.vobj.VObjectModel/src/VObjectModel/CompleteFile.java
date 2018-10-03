/**
 */
package VObjectModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.CompleteFile#getVirtModels <em>Virt Models</em>}</li>
 *   <li>{@link VObjectModel.CompleteFile#getInputModels <em>Input Models</em>}</li>
 *   <li>{@link VObjectModel.CompleteFile#getDeltamodel <em>Deltamodel</em>}</li>
 *   <li>{@link VObjectModel.CompleteFile#getLastModelText <em>Last Model Text</em>}</li>
 *   <li>{@link VObjectModel.CompleteFile#getCurrentModelText <em>Current Model Text</em>}</li>
 *   <li>{@link VObjectModel.CompleteFile#getXtextlanguage <em>Xtextlanguage</em>}</li>
 *   <li>{@link VObjectModel.CompleteFile#getEcoredef <em>Ecoredef</em>}</li>
 *   <li>{@link VObjectModel.CompleteFile#getRootObjects <em>Root Objects</em>}</li>
 * </ul>
 *
 * @see VObjectModel.VObjectModelPackage#getCompleteFile()
 * @model
 * @generated
 */
public interface CompleteFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Virt Models</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virt Models</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virt Models</em>' attribute list.
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_VirtModels()
	 * @model
	 * @generated
	 */
	EList<String> getVirtModels();

	/**
	 * Returns the value of the '<em><b>Input Models</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Models</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Models</em>' attribute list.
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_InputModels()
	 * @model
	 * @generated
	 */
	EList<String> getInputModels();

	/**
	 * Returns the value of the '<em><b>Deltamodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deltamodel</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deltamodel</em>' containment reference.
	 * @see #setDeltamodel(VObjDeltaModel)
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_Deltamodel()
	 * @model containment="true"
	 * @generated
	 */
	VObjDeltaModel getDeltamodel();

	/**
	 * Sets the value of the '{@link VObjectModel.CompleteFile#getDeltamodel <em>Deltamodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deltamodel</em>' containment reference.
	 * @see #getDeltamodel()
	 * @generated
	 */
	void setDeltamodel(VObjDeltaModel value);

	/**
	 * Returns the value of the '<em><b>Last Model Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Model Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Model Text</em>' attribute.
	 * @see #setLastModelText(String)
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_LastModelText()
	 * @model
	 * @generated
	 */
	String getLastModelText();

	/**
	 * Sets the value of the '{@link VObjectModel.CompleteFile#getLastModelText <em>Last Model Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Model Text</em>' attribute.
	 * @see #getLastModelText()
	 * @generated
	 */
	void setLastModelText(String value);

	/**
	 * Returns the value of the '<em><b>Current Model Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Model Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Model Text</em>' attribute.
	 * @see #setCurrentModelText(String)
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_CurrentModelText()
	 * @model
	 * @generated
	 */
	String getCurrentModelText();

	/**
	 * Sets the value of the '{@link VObjectModel.CompleteFile#getCurrentModelText <em>Current Model Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Model Text</em>' attribute.
	 * @see #getCurrentModelText()
	 * @generated
	 */
	void setCurrentModelText(String value);

	/**
	 * Returns the value of the '<em><b>Xtextlanguage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xtextlanguage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xtextlanguage</em>' containment reference.
	 * @see #setXtextlanguage(LanguageDef)
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_Xtextlanguage()
	 * @model containment="true"
	 * @generated
	 */
	LanguageDef getXtextlanguage();

	/**
	 * Sets the value of the '{@link VObjectModel.CompleteFile#getXtextlanguage <em>Xtextlanguage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xtextlanguage</em>' containment reference.
	 * @see #getXtextlanguage()
	 * @generated
	 */
	void setXtextlanguage(LanguageDef value);

	/**
	 * Returns the value of the '<em><b>Ecoredef</b></em>' containment reference list.
	 * The list contents are of type {@link VObjectModel.EcoreDef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecoredef</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecoredef</em>' containment reference list.
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_Ecoredef()
	 * @model containment="true"
	 * @generated
	 */
	EList<EcoreDef> getEcoredef();

	/**
	 * Returns the value of the '<em><b>Root Objects</b></em>' containment reference list.
	 * The list contents are of type {@link VObjectModel.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Objects</em>' containment reference list.
	 * @see VObjectModel.VObjectModelPackage#getCompleteFile_RootObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<Identifier> getRootObjects();

} // CompleteFile

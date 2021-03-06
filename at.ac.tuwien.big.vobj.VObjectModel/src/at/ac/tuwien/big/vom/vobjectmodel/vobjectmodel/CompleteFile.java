/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getVirtModels <em>Virt Models</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getInputModels <em>Input Models</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getDeltamodel <em>Deltamodel</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getLastModelText <em>Last Model Text</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getCurrentModelText <em>Current Model Text</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getXtextlanguage <em>Xtextlanguage</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getEcoredef <em>Ecoredef</em>}</li>
 *   <li>{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getRootObjects <em>Root Objects</em>}</li>
 * </ul>
 *
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile()
 * @model
 * @generated
 */
public interface CompleteFile extends AnyRoot {
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
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_VirtModels()
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
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_InputModels()
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
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_Deltamodel()
	 * @model containment="true"
	 * @generated
	 */
	VObjDeltaModel getDeltamodel();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getDeltamodel <em>Deltamodel</em>}' containment reference.
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
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_LastModelText()
	 * @model
	 * @generated
	 */
	String getLastModelText();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getLastModelText <em>Last Model Text</em>}' attribute.
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
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_CurrentModelText()
	 * @model
	 * @generated
	 */
	String getCurrentModelText();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getCurrentModelText <em>Current Model Text</em>}' attribute.
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
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_Xtextlanguage()
	 * @model containment="true"
	 * @generated
	 */
	LanguageDef getXtextlanguage();

	/**
	 * Sets the value of the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getXtextlanguage <em>Xtextlanguage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xtextlanguage</em>' containment reference.
	 * @see #getXtextlanguage()
	 * @generated
	 */
	void setXtextlanguage(LanguageDef value);

	/**
	 * Returns the value of the '<em><b>Ecoredef</b></em>' containment reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecoredef</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecoredef</em>' containment reference list.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_Ecoredef()
	 * @model containment="true"
	 * @generated
	 */
	EList<EcoreDef> getEcoredef();

	/**
	 * Returns the value of the '<em><b>Root Objects</b></em>' reference list.
	 * The list contents are of type {@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Objects</em>' reference list.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#getCompleteFile_RootObjects()
	 * @model
	 * @generated
	 */
	EList<Identifier> getRootObjects();

} // CompleteFile

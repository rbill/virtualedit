/**
 */
package VObjectModel.impl;

import VObjectModel.CompleteFile;
import VObjectModel.EcoreDef;
import VObjectModel.Identifier;
import VObjectModel.LanguageDef;
import VObjectModel.VObjDeltaModel;
import VObjectModel.VObjectModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getVirtModels <em>Virt Models</em>}</li>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getInputModels <em>Input Models</em>}</li>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getDeltamodel <em>Deltamodel</em>}</li>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getLastModelText <em>Last Model Text</em>}</li>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getCurrentModelText <em>Current Model Text</em>}</li>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getXtextlanguage <em>Xtextlanguage</em>}</li>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getEcoredef <em>Ecoredef</em>}</li>
 *   <li>{@link VObjectModel.impl.CompleteFileImpl#getRootObjects <em>Root Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompleteFileImpl extends MinimalEObjectImpl.Container implements CompleteFile {
	/**
	 * The cached value of the '{@link #getVirtModels() <em>Virt Models</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtModels()
	 * @generated
	 * @ordered
	 */
	protected EList<String> virtModels;

	/**
	 * The cached value of the '{@link #getInputModels() <em>Input Models</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputModels()
	 * @generated
	 * @ordered
	 */
	protected EList<String> inputModels;

	/**
	 * The cached value of the '{@link #getDeltamodel() <em>Deltamodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeltamodel()
	 * @generated
	 * @ordered
	 */
	protected VObjDeltaModel deltamodel;

	/**
	 * The default value of the '{@link #getLastModelText() <em>Last Model Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModelText()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_MODEL_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastModelText() <em>Last Model Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModelText()
	 * @generated
	 * @ordered
	 */
	protected String lastModelText = LAST_MODEL_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentModelText() <em>Current Model Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentModelText()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENT_MODEL_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentModelText() <em>Current Model Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentModelText()
	 * @generated
	 * @ordered
	 */
	protected String currentModelText = CURRENT_MODEL_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getXtextlanguage() <em>Xtextlanguage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXtextlanguage()
	 * @generated
	 * @ordered
	 */
	protected LanguageDef xtextlanguage;

	/**
	 * The cached value of the '{@link #getEcoredef() <em>Ecoredef</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoredef()
	 * @generated
	 * @ordered
	 */
	protected EList<EcoreDef> ecoredef;

	/**
	 * The cached value of the '{@link #getRootObjects() <em>Root Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> rootObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.COMPLETE_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getVirtModels() {
		if (virtModels == null) {
			virtModels = new EDataTypeUniqueEList<String>(String.class, this, VObjectModelPackage.COMPLETE_FILE__VIRT_MODELS);
		}
		return virtModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getInputModels() {
		if (inputModels == null) {
			inputModels = new EDataTypeUniqueEList<String>(String.class, this, VObjectModelPackage.COMPLETE_FILE__INPUT_MODELS);
		}
		return inputModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjDeltaModel getDeltamodel() {
		return deltamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeltamodel(VObjDeltaModel newDeltamodel, NotificationChain msgs) {
		VObjDeltaModel oldDeltamodel = deltamodel;
		deltamodel = newDeltamodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.COMPLETE_FILE__DELTAMODEL, oldDeltamodel, newDeltamodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeltamodel(VObjDeltaModel newDeltamodel) {
		if (newDeltamodel != deltamodel) {
			NotificationChain msgs = null;
			if (deltamodel != null)
				msgs = ((InternalEObject)deltamodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.COMPLETE_FILE__DELTAMODEL, null, msgs);
			if (newDeltamodel != null)
				msgs = ((InternalEObject)newDeltamodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.COMPLETE_FILE__DELTAMODEL, null, msgs);
			msgs = basicSetDeltamodel(newDeltamodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.COMPLETE_FILE__DELTAMODEL, newDeltamodel, newDeltamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastModelText() {
		return lastModelText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModelText(String newLastModelText) {
		String oldLastModelText = lastModelText;
		lastModelText = newLastModelText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.COMPLETE_FILE__LAST_MODEL_TEXT, oldLastModelText, lastModelText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCurrentModelText() {
		return currentModelText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentModelText(String newCurrentModelText) {
		String oldCurrentModelText = currentModelText;
		currentModelText = newCurrentModelText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.COMPLETE_FILE__CURRENT_MODEL_TEXT, oldCurrentModelText, currentModelText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageDef getXtextlanguage() {
		return xtextlanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXtextlanguage(LanguageDef newXtextlanguage, NotificationChain msgs) {
		LanguageDef oldXtextlanguage = xtextlanguage;
		xtextlanguage = newXtextlanguage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE, oldXtextlanguage, newXtextlanguage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXtextlanguage(LanguageDef newXtextlanguage) {
		if (newXtextlanguage != xtextlanguage) {
			NotificationChain msgs = null;
			if (xtextlanguage != null)
				msgs = ((InternalEObject)xtextlanguage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE, null, msgs);
			if (newXtextlanguage != null)
				msgs = ((InternalEObject)newXtextlanguage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE, null, msgs);
			msgs = basicSetXtextlanguage(newXtextlanguage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE, newXtextlanguage, newXtextlanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EcoreDef> getEcoredef() {
		if (ecoredef == null) {
			ecoredef = new EObjectContainmentEList<EcoreDef>(EcoreDef.class, this, VObjectModelPackage.COMPLETE_FILE__ECOREDEF);
		}
		return ecoredef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifier> getRootObjects() {
		if (rootObjects == null) {
			rootObjects = new EObjectContainmentEList<Identifier>(Identifier.class, this, VObjectModelPackage.COMPLETE_FILE__ROOT_OBJECTS);
		}
		return rootObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.COMPLETE_FILE__DELTAMODEL:
				return basicSetDeltamodel(null, msgs);
			case VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE:
				return basicSetXtextlanguage(null, msgs);
			case VObjectModelPackage.COMPLETE_FILE__ECOREDEF:
				return ((InternalEList<?>)getEcoredef()).basicRemove(otherEnd, msgs);
			case VObjectModelPackage.COMPLETE_FILE__ROOT_OBJECTS:
				return ((InternalEList<?>)getRootObjects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.COMPLETE_FILE__VIRT_MODELS:
				return getVirtModels();
			case VObjectModelPackage.COMPLETE_FILE__INPUT_MODELS:
				return getInputModels();
			case VObjectModelPackage.COMPLETE_FILE__DELTAMODEL:
				return getDeltamodel();
			case VObjectModelPackage.COMPLETE_FILE__LAST_MODEL_TEXT:
				return getLastModelText();
			case VObjectModelPackage.COMPLETE_FILE__CURRENT_MODEL_TEXT:
				return getCurrentModelText();
			case VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE:
				return getXtextlanguage();
			case VObjectModelPackage.COMPLETE_FILE__ECOREDEF:
				return getEcoredef();
			case VObjectModelPackage.COMPLETE_FILE__ROOT_OBJECTS:
				return getRootObjects();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VObjectModelPackage.COMPLETE_FILE__VIRT_MODELS:
				getVirtModels().clear();
				getVirtModels().addAll((Collection<? extends String>)newValue);
				return;
			case VObjectModelPackage.COMPLETE_FILE__INPUT_MODELS:
				getInputModels().clear();
				getInputModels().addAll((Collection<? extends String>)newValue);
				return;
			case VObjectModelPackage.COMPLETE_FILE__DELTAMODEL:
				setDeltamodel((VObjDeltaModel)newValue);
				return;
			case VObjectModelPackage.COMPLETE_FILE__LAST_MODEL_TEXT:
				setLastModelText((String)newValue);
				return;
			case VObjectModelPackage.COMPLETE_FILE__CURRENT_MODEL_TEXT:
				setCurrentModelText((String)newValue);
				return;
			case VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE:
				setXtextlanguage((LanguageDef)newValue);
				return;
			case VObjectModelPackage.COMPLETE_FILE__ECOREDEF:
				getEcoredef().clear();
				getEcoredef().addAll((Collection<? extends EcoreDef>)newValue);
				return;
			case VObjectModelPackage.COMPLETE_FILE__ROOT_OBJECTS:
				getRootObjects().clear();
				getRootObjects().addAll((Collection<? extends Identifier>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.COMPLETE_FILE__VIRT_MODELS:
				getVirtModels().clear();
				return;
			case VObjectModelPackage.COMPLETE_FILE__INPUT_MODELS:
				getInputModels().clear();
				return;
			case VObjectModelPackage.COMPLETE_FILE__DELTAMODEL:
				setDeltamodel((VObjDeltaModel)null);
				return;
			case VObjectModelPackage.COMPLETE_FILE__LAST_MODEL_TEXT:
				setLastModelText(LAST_MODEL_TEXT_EDEFAULT);
				return;
			case VObjectModelPackage.COMPLETE_FILE__CURRENT_MODEL_TEXT:
				setCurrentModelText(CURRENT_MODEL_TEXT_EDEFAULT);
				return;
			case VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE:
				setXtextlanguage((LanguageDef)null);
				return;
			case VObjectModelPackage.COMPLETE_FILE__ECOREDEF:
				getEcoredef().clear();
				return;
			case VObjectModelPackage.COMPLETE_FILE__ROOT_OBJECTS:
				getRootObjects().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.COMPLETE_FILE__VIRT_MODELS:
				return virtModels != null && !virtModels.isEmpty();
			case VObjectModelPackage.COMPLETE_FILE__INPUT_MODELS:
				return inputModels != null && !inputModels.isEmpty();
			case VObjectModelPackage.COMPLETE_FILE__DELTAMODEL:
				return deltamodel != null;
			case VObjectModelPackage.COMPLETE_FILE__LAST_MODEL_TEXT:
				return LAST_MODEL_TEXT_EDEFAULT == null ? lastModelText != null : !LAST_MODEL_TEXT_EDEFAULT.equals(lastModelText);
			case VObjectModelPackage.COMPLETE_FILE__CURRENT_MODEL_TEXT:
				return CURRENT_MODEL_TEXT_EDEFAULT == null ? currentModelText != null : !CURRENT_MODEL_TEXT_EDEFAULT.equals(currentModelText);
			case VObjectModelPackage.COMPLETE_FILE__XTEXTLANGUAGE:
				return xtextlanguage != null;
			case VObjectModelPackage.COMPLETE_FILE__ECOREDEF:
				return ecoredef != null && !ecoredef.isEmpty();
			case VObjectModelPackage.COMPLETE_FILE__ROOT_OBJECTS:
				return rootObjects != null && !rootObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (virtModels: ");
		result.append(virtModels);
		result.append(", inputModels: ");
		result.append(inputModels);
		result.append(", lastModelText: ");
		result.append(lastModelText);
		result.append(", currentModelText: ");
		result.append(currentModelText);
		result.append(')');
		return result.toString();
	}

} //CompleteFileImpl

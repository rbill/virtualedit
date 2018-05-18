/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang.impl;

import at.ac.tuwien.big.virtmodel.vLang.FunctionAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.FunctionType;
import at.ac.tuwien.big.virtmodel.vLang.JavaFunctionCall;
import at.ac.tuwien.big.virtmodel.vLang.VLangPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.FunctionDefImpl#getType <em>Type</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.FunctionDefImpl#getInit <em>Init</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.FunctionDefImpl#getFullAssignment <em>Full Assignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionDefImpl extends SetOrFunctionDefImpl implements FunctionDef
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final FunctionType TYPE_EDEFAULT = FunctionType.FINITE;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected FunctionType type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInit()
   * @generated
   * @ordered
   */
  protected JavaFunctionCall init;

  /**
   * The cached value of the '{@link #getFullAssignment() <em>Full Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFullAssignment()
   * @generated
   * @ordered
   */
  protected FunctionAssignment fullAssignment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionDefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VLangPackage.Literals.FUNCTION_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(FunctionType newType)
  {
    FunctionType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.FUNCTION_DEF__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaFunctionCall getInit()
  {
    return init;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInit(JavaFunctionCall newInit, NotificationChain msgs)
  {
    JavaFunctionCall oldInit = init;
    init = newInit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VLangPackage.FUNCTION_DEF__INIT, oldInit, newInit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInit(JavaFunctionCall newInit)
  {
    if (newInit != init)
    {
      NotificationChain msgs = null;
      if (init != null)
        msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VLangPackage.FUNCTION_DEF__INIT, null, msgs);
      if (newInit != null)
        msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VLangPackage.FUNCTION_DEF__INIT, null, msgs);
      msgs = basicSetInit(newInit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.FUNCTION_DEF__INIT, newInit, newInit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionAssignment getFullAssignment()
  {
    return fullAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFullAssignment(FunctionAssignment newFullAssignment, NotificationChain msgs)
  {
    FunctionAssignment oldFullAssignment = fullAssignment;
    fullAssignment = newFullAssignment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT, oldFullAssignment, newFullAssignment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFullAssignment(FunctionAssignment newFullAssignment)
  {
    if (newFullAssignment != fullAssignment)
    {
      NotificationChain msgs = null;
      if (fullAssignment != null)
        msgs = ((InternalEObject)fullAssignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT, null, msgs);
      if (newFullAssignment != null)
        msgs = ((InternalEObject)newFullAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT, null, msgs);
      msgs = basicSetFullAssignment(newFullAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT, newFullAssignment, newFullAssignment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VLangPackage.FUNCTION_DEF__INIT:
        return basicSetInit(null, msgs);
      case VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT:
        return basicSetFullAssignment(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VLangPackage.FUNCTION_DEF__TYPE:
        return getType();
      case VLangPackage.FUNCTION_DEF__INIT:
        return getInit();
      case VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT:
        return getFullAssignment();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VLangPackage.FUNCTION_DEF__TYPE:
        setType((FunctionType)newValue);
        return;
      case VLangPackage.FUNCTION_DEF__INIT:
        setInit((JavaFunctionCall)newValue);
        return;
      case VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT:
        setFullAssignment((FunctionAssignment)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VLangPackage.FUNCTION_DEF__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case VLangPackage.FUNCTION_DEF__INIT:
        setInit((JavaFunctionCall)null);
        return;
      case VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT:
        setFullAssignment((FunctionAssignment)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VLangPackage.FUNCTION_DEF__TYPE:
        return type != TYPE_EDEFAULT;
      case VLangPackage.FUNCTION_DEF__INIT:
        return init != null;
      case VLangPackage.FUNCTION_DEF__FULL_ASSIGNMENT:
        return fullAssignment != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //FunctionDefImpl
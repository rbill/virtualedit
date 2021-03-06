/**
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.simpleaspect.simpleAspect.impl;

import at.ac.tuwien.big.simpleaspect.simpleAspect.PointcutMethodFilter;
import at.ac.tuwien.big.simpleaspect.simpleAspect.SimpleAspectPackage;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pointcut Method Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#isIsPublic <em>Is Public</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#isIsPrivate <em>Is Private</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#isAnyReturn <em>Any Return</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#isAnyClass <em>Any Class</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#getClassType <em>Class Type</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#isAnyMethod <em>Any Method</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#isAnyParameter <em>Any Parameter</em>}</li>
 *   <li>{@link at.ac.tuwien.big.simpleaspect.simpleAspect.impl.PointcutMethodFilterImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PointcutMethodFilterImpl extends MinimalEObjectImpl.Container implements PointcutMethodFilter
{
  /**
   * The default value of the '{@link #isIsPublic() <em>Is Public</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPublic()
   * @generated
   * @ordered
   */
  protected static final boolean IS_PUBLIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsPublic() <em>Is Public</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPublic()
   * @generated
   * @ordered
   */
  protected boolean isPublic = IS_PUBLIC_EDEFAULT;

  /**
   * The default value of the '{@link #isIsPrivate() <em>Is Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPrivate()
   * @generated
   * @ordered
   */
  protected static final boolean IS_PRIVATE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsPrivate() <em>Is Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsPrivate()
   * @generated
   * @ordered
   */
  protected boolean isPrivate = IS_PRIVATE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsStatic()
   * @generated
   * @ordered
   */
  protected static final boolean IS_STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsStatic()
   * @generated
   * @ordered
   */
  protected boolean isStatic = IS_STATIC_EDEFAULT;

  /**
   * The default value of the '{@link #isAnyReturn() <em>Any Return</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyReturn()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_RETURN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyReturn() <em>Any Return</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyReturn()
   * @generated
   * @ordered
   */
  protected boolean anyReturn = ANY_RETURN_EDEFAULT;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected Type returnType;

  /**
   * The default value of the '{@link #isAnyClass() <em>Any Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyClass()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_CLASS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyClass() <em>Any Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyClass()
   * @generated
   * @ordered
   */
  protected boolean anyClass = ANY_CLASS_EDEFAULT;

  /**
   * The default value of the '{@link #getClassType() <em>Class Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassType()
   * @generated
   * @ordered
   */
  protected static final String CLASS_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClassType() <em>Class Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassType()
   * @generated
   * @ordered
   */
  protected String classType = CLASS_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isAnyMethod() <em>Any Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyMethod()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_METHOD_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyMethod() <em>Any Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyMethod()
   * @generated
   * @ordered
   */
  protected boolean anyMethod = ANY_METHOD_EDEFAULT;

  /**
   * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodName()
   * @generated
   * @ordered
   */
  protected static final String METHOD_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodName()
   * @generated
   * @ordered
   */
  protected String methodName = METHOD_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isAnyParameter() <em>Any Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyParameter()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_PARAMETER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyParameter() <em>Any Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyParameter()
   * @generated
   * @ordered
   */
  protected boolean anyParameter = ANY_PARAMETER_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected EList<Type> parameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PointcutMethodFilterImpl()
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
    return SimpleAspectPackage.Literals.POINTCUT_METHOD_FILTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsPublic()
  {
    return isPublic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsPublic(boolean newIsPublic)
  {
    boolean oldIsPublic = isPublic;
    isPublic = newIsPublic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PUBLIC, oldIsPublic, isPublic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsPrivate()
  {
    return isPrivate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsPrivate(boolean newIsPrivate)
  {
    boolean oldIsPrivate = isPrivate;
    isPrivate = newIsPrivate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PRIVATE, oldIsPrivate, isPrivate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsStatic()
  {
    return isStatic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsStatic(boolean newIsStatic)
  {
    boolean oldIsStatic = isStatic;
    isStatic = newIsStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_STATIC, oldIsStatic, isStatic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyReturn()
  {
    return anyReturn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyReturn(boolean newAnyReturn)
  {
    boolean oldAnyReturn = anyReturn;
    anyReturn = newAnyReturn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_RETURN, oldAnyReturn, anyReturn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnType(Type newReturnType, NotificationChain msgs)
  {
    Type oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE, oldReturnType, newReturnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(Type newReturnType)
  {
    if (newReturnType != returnType)
    {
      NotificationChain msgs = null;
      if (returnType != null)
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE, newReturnType, newReturnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyClass()
  {
    return anyClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyClass(boolean newAnyClass)
  {
    boolean oldAnyClass = anyClass;
    anyClass = newAnyClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_CLASS, oldAnyClass, anyClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClassType()
  {
    return classType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassType(String newClassType)
  {
    String oldClassType = classType;
    classType = newClassType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__CLASS_TYPE, oldClassType, classType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyMethod()
  {
    return anyMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyMethod(boolean newAnyMethod)
  {
    boolean oldAnyMethod = anyMethod;
    anyMethod = newAnyMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_METHOD, oldAnyMethod, anyMethod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMethodName()
  {
    return methodName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodName(String newMethodName)
  {
    String oldMethodName = methodName;
    methodName = newMethodName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__METHOD_NAME, oldMethodName, methodName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyParameter()
  {
    return anyParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyParameter(boolean newAnyParameter)
  {
    boolean oldAnyParameter = anyParameter;
    anyParameter = newAnyParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_PARAMETER, oldAnyParameter, anyParameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Type> getParameter()
  {
    if (parameter == null)
    {
      parameter = new EObjectContainmentEList<Type>(Type.class, this, SimpleAspectPackage.POINTCUT_METHOD_FILTER__PARAMETER);
    }
    return parameter;
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
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__PARAMETER:
        return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PUBLIC:
        return isIsPublic();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PRIVATE:
        return isIsPrivate();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_STATIC:
        return isIsStatic();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_RETURN:
        return isAnyReturn();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE:
        return getReturnType();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_CLASS:
        return isAnyClass();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__CLASS_TYPE:
        return getClassType();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_METHOD:
        return isAnyMethod();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__METHOD_NAME:
        return getMethodName();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_PARAMETER:
        return isAnyParameter();
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__PARAMETER:
        return getParameter();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PUBLIC:
        setIsPublic((Boolean)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PRIVATE:
        setIsPrivate((Boolean)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_STATIC:
        setIsStatic((Boolean)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_RETURN:
        setAnyReturn((Boolean)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE:
        setReturnType((Type)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_CLASS:
        setAnyClass((Boolean)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__CLASS_TYPE:
        setClassType((String)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_METHOD:
        setAnyMethod((Boolean)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__METHOD_NAME:
        setMethodName((String)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_PARAMETER:
        setAnyParameter((Boolean)newValue);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__PARAMETER:
        getParameter().clear();
        getParameter().addAll((Collection<? extends Type>)newValue);
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
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PUBLIC:
        setIsPublic(IS_PUBLIC_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PRIVATE:
        setIsPrivate(IS_PRIVATE_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_STATIC:
        setIsStatic(IS_STATIC_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_RETURN:
        setAnyReturn(ANY_RETURN_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE:
        setReturnType((Type)null);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_CLASS:
        setAnyClass(ANY_CLASS_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__CLASS_TYPE:
        setClassType(CLASS_TYPE_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_METHOD:
        setAnyMethod(ANY_METHOD_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__METHOD_NAME:
        setMethodName(METHOD_NAME_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_PARAMETER:
        setAnyParameter(ANY_PARAMETER_EDEFAULT);
        return;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__PARAMETER:
        getParameter().clear();
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
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PUBLIC:
        return isPublic != IS_PUBLIC_EDEFAULT;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_PRIVATE:
        return isPrivate != IS_PRIVATE_EDEFAULT;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__IS_STATIC:
        return isStatic != IS_STATIC_EDEFAULT;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_RETURN:
        return anyReturn != ANY_RETURN_EDEFAULT;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE:
        return returnType != null;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_CLASS:
        return anyClass != ANY_CLASS_EDEFAULT;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__CLASS_TYPE:
        return CLASS_TYPE_EDEFAULT == null ? classType != null : !CLASS_TYPE_EDEFAULT.equals(classType);
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_METHOD:
        return anyMethod != ANY_METHOD_EDEFAULT;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__METHOD_NAME:
        return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__ANY_PARAMETER:
        return anyParameter != ANY_PARAMETER_EDEFAULT;
      case SimpleAspectPackage.POINTCUT_METHOD_FILTER__PARAMETER:
        return parameter != null && !parameter.isEmpty();
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
    result.append(" (isPublic: ");
    result.append(isPublic);
    result.append(", isPrivate: ");
    result.append(isPrivate);
    result.append(", isStatic: ");
    result.append(isStatic);
    result.append(", anyReturn: ");
    result.append(anyReturn);
    result.append(", anyClass: ");
    result.append(anyClass);
    result.append(", classType: ");
    result.append(classType);
    result.append(", anyMethod: ");
    result.append(anyMethod);
    result.append(", methodName: ");
    result.append(methodName);
    result.append(", anyParameter: ");
    result.append(anyParameter);
    result.append(')');
    return result.toString();
  }

} //PointcutMethodFilterImpl

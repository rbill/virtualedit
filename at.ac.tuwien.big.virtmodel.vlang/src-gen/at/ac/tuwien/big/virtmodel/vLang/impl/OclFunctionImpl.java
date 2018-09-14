/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang.impl;

import at.ac.tuwien.big.virtmodel.vLang.OclFunction;
import at.ac.tuwien.big.virtmodel.vLang.VLangPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.OclFunctionImpl#getOclFunc <em>Ocl Func</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OclFunctionImpl extends BasicExpressionImpl implements OclFunction
{
  /**
   * The default value of the '{@link #getOclFunc() <em>Ocl Func</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOclFunc()
   * @generated
   * @ordered
   */
  protected static final String OCL_FUNC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOclFunc() <em>Ocl Func</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOclFunc()
   * @generated
   * @ordered
   */
  protected String oclFunc = OCL_FUNC_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OclFunctionImpl()
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
    return VLangPackage.Literals.OCL_FUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOclFunc()
  {
    return oclFunc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOclFunc(String newOclFunc)
  {
    String oldOclFunc = oclFunc;
    oclFunc = newOclFunc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.OCL_FUNCTION__OCL_FUNC, oldOclFunc, oclFunc));
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
      case VLangPackage.OCL_FUNCTION__OCL_FUNC:
        return getOclFunc();
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
      case VLangPackage.OCL_FUNCTION__OCL_FUNC:
        setOclFunc((String)newValue);
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
      case VLangPackage.OCL_FUNCTION__OCL_FUNC:
        setOclFunc(OCL_FUNC_EDEFAULT);
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
      case VLangPackage.OCL_FUNCTION__OCL_FUNC:
        return OCL_FUNC_EDEFAULT == null ? oclFunc != null : !OCL_FUNC_EDEFAULT.equals(oclFunc);
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
    result.append(" (oclFunc: ");
    result.append(oclFunc);
    result.append(')');
    return result.toString();
  }

} //OclFunctionImpl

/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang.impl;

import at.ac.tuwien.big.virtmodel.vLang.FunctionAssignment;
import at.ac.tuwien.big.virtmodel.vLang.FunctionDef;
import at.ac.tuwien.big.virtmodel.vLang.FunctionScope;
import at.ac.tuwien.big.virtmodel.vLang.RuleAssignment;
import at.ac.tuwien.big.virtmodel.vLang.VLangPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.RuleAssignmentImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.RuleAssignmentImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.RuleAssignmentImpl#isIsFinite <em>Is Finite</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.RuleAssignmentImpl#isIsDerive <em>Is Derive</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.RuleAssignmentImpl#isIsConstraint <em>Is Constraint</em>}</li>
 *   <li>{@link at.ac.tuwien.big.virtmodel.vLang.impl.RuleAssignmentImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleAssignmentImpl extends AssignStatementImpl implements RuleAssignment
{
  /**
   * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunction()
   * @generated
   * @ordered
   */
  protected FunctionDef function;

  /**
   * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScope()
   * @generated
   * @ordered
   */
  protected FunctionScope scope;

  /**
   * The default value of the '{@link #isIsFinite() <em>Is Finite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsFinite()
   * @generated
   * @ordered
   */
  protected static final boolean IS_FINITE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsFinite() <em>Is Finite</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsFinite()
   * @generated
   * @ordered
   */
  protected boolean isFinite = IS_FINITE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsDerive() <em>Is Derive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDerive()
   * @generated
   * @ordered
   */
  protected static final boolean IS_DERIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsDerive() <em>Is Derive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDerive()
   * @generated
   * @ordered
   */
  protected boolean isDerive = IS_DERIVE_EDEFAULT;

  /**
   * The default value of the '{@link #isIsConstraint() <em>Is Constraint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsConstraint()
   * @generated
   * @ordered
   */
  protected static final boolean IS_CONSTRAINT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsConstraint() <em>Is Constraint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsConstraint()
   * @generated
   * @ordered
   */
  protected boolean isConstraint = IS_CONSTRAINT_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignment()
   * @generated
   * @ordered
   */
  protected FunctionAssignment assignment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleAssignmentImpl()
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
    return VLangPackage.Literals.RULE_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDef getFunction()
  {
    if (function != null && function.eIsProxy())
    {
      InternalEObject oldFunction = (InternalEObject)function;
      function = (FunctionDef)eResolveProxy(oldFunction);
      if (function != oldFunction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VLangPackage.RULE_ASSIGNMENT__FUNCTION, oldFunction, function));
      }
    }
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDef basicGetFunction()
  {
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunction(FunctionDef newFunction)
  {
    FunctionDef oldFunction = function;
    function = newFunction;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__FUNCTION, oldFunction, function));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionScope getScope()
  {
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetScope(FunctionScope newScope, NotificationChain msgs)
  {
    FunctionScope oldScope = scope;
    scope = newScope;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__SCOPE, oldScope, newScope);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScope(FunctionScope newScope)
  {
    if (newScope != scope)
    {
      NotificationChain msgs = null;
      if (scope != null)
        msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VLangPackage.RULE_ASSIGNMENT__SCOPE, null, msgs);
      if (newScope != null)
        msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VLangPackage.RULE_ASSIGNMENT__SCOPE, null, msgs);
      msgs = basicSetScope(newScope, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__SCOPE, newScope, newScope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsFinite()
  {
    return isFinite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsFinite(boolean newIsFinite)
  {
    boolean oldIsFinite = isFinite;
    isFinite = newIsFinite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__IS_FINITE, oldIsFinite, isFinite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsDerive()
  {
    return isDerive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsDerive(boolean newIsDerive)
  {
    boolean oldIsDerive = isDerive;
    isDerive = newIsDerive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__IS_DERIVE, oldIsDerive, isDerive));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsConstraint()
  {
    return isConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsConstraint(boolean newIsConstraint)
  {
    boolean oldIsConstraint = isConstraint;
    isConstraint = newIsConstraint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__IS_CONSTRAINT, oldIsConstraint, isConstraint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionAssignment getAssignment()
  {
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignment(FunctionAssignment newAssignment, NotificationChain msgs)
  {
    FunctionAssignment oldAssignment = assignment;
    assignment = newAssignment;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT, oldAssignment, newAssignment);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignment(FunctionAssignment newAssignment)
  {
    if (newAssignment != assignment)
    {
      NotificationChain msgs = null;
      if (assignment != null)
        msgs = ((InternalEObject)assignment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT, null, msgs);
      if (newAssignment != null)
        msgs = ((InternalEObject)newAssignment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT, null, msgs);
      msgs = basicSetAssignment(newAssignment, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT, newAssignment, newAssignment));
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
      case VLangPackage.RULE_ASSIGNMENT__SCOPE:
        return basicSetScope(null, msgs);
      case VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT:
        return basicSetAssignment(null, msgs);
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
      case VLangPackage.RULE_ASSIGNMENT__FUNCTION:
        if (resolve) return getFunction();
        return basicGetFunction();
      case VLangPackage.RULE_ASSIGNMENT__SCOPE:
        return getScope();
      case VLangPackage.RULE_ASSIGNMENT__IS_FINITE:
        return isIsFinite();
      case VLangPackage.RULE_ASSIGNMENT__IS_DERIVE:
        return isIsDerive();
      case VLangPackage.RULE_ASSIGNMENT__IS_CONSTRAINT:
        return isIsConstraint();
      case VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT:
        return getAssignment();
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
      case VLangPackage.RULE_ASSIGNMENT__FUNCTION:
        setFunction((FunctionDef)newValue);
        return;
      case VLangPackage.RULE_ASSIGNMENT__SCOPE:
        setScope((FunctionScope)newValue);
        return;
      case VLangPackage.RULE_ASSIGNMENT__IS_FINITE:
        setIsFinite((Boolean)newValue);
        return;
      case VLangPackage.RULE_ASSIGNMENT__IS_DERIVE:
        setIsDerive((Boolean)newValue);
        return;
      case VLangPackage.RULE_ASSIGNMENT__IS_CONSTRAINT:
        setIsConstraint((Boolean)newValue);
        return;
      case VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT:
        setAssignment((FunctionAssignment)newValue);
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
      case VLangPackage.RULE_ASSIGNMENT__FUNCTION:
        setFunction((FunctionDef)null);
        return;
      case VLangPackage.RULE_ASSIGNMENT__SCOPE:
        setScope((FunctionScope)null);
        return;
      case VLangPackage.RULE_ASSIGNMENT__IS_FINITE:
        setIsFinite(IS_FINITE_EDEFAULT);
        return;
      case VLangPackage.RULE_ASSIGNMENT__IS_DERIVE:
        setIsDerive(IS_DERIVE_EDEFAULT);
        return;
      case VLangPackage.RULE_ASSIGNMENT__IS_CONSTRAINT:
        setIsConstraint(IS_CONSTRAINT_EDEFAULT);
        return;
      case VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT:
        setAssignment((FunctionAssignment)null);
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
      case VLangPackage.RULE_ASSIGNMENT__FUNCTION:
        return function != null;
      case VLangPackage.RULE_ASSIGNMENT__SCOPE:
        return scope != null;
      case VLangPackage.RULE_ASSIGNMENT__IS_FINITE:
        return isFinite != IS_FINITE_EDEFAULT;
      case VLangPackage.RULE_ASSIGNMENT__IS_DERIVE:
        return isDerive != IS_DERIVE_EDEFAULT;
      case VLangPackage.RULE_ASSIGNMENT__IS_CONSTRAINT:
        return isConstraint != IS_CONSTRAINT_EDEFAULT;
      case VLangPackage.RULE_ASSIGNMENT__ASSIGNMENT:
        return assignment != null;
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
    result.append(" (isFinite: ");
    result.append(isFinite);
    result.append(", isDerive: ");
    result.append(isDerive);
    result.append(", isConstraint: ");
    result.append(isConstraint);
    result.append(')');
    return result.toString();
  }

} //RuleAssignmentImpl

/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.vLang.util;

import at.ac.tuwien.big.virtmodel.vLang.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.virtmodel.vLang.VLangPackage
 * @generated
 */
public class VLangAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VLangPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VLangAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = VLangPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VLangSwitch<Adapter> modelSwitch =
    new VLangSwitch<Adapter>()
    {
      @Override
      public Adapter caseVLang(VLang object)
      {
        return createVLangAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseAssignStatement(AssignStatement object)
      {
        return createAssignStatementAdapter();
      }
      @Override
      public Adapter caseSetOrFunctionDef(SetOrFunctionDef object)
      {
        return createSetOrFunctionDefAdapter();
      }
      @Override
      public Adapter caseFunctionDef(FunctionDef object)
      {
        return createFunctionDefAdapter();
      }
      @Override
      public Adapter caseJavaFunctionDef(JavaFunctionDef object)
      {
        return createJavaFunctionDefAdapter();
      }
      @Override
      public Adapter caseBasicAction(BasicAction object)
      {
        return createBasicActionAdapter();
      }
      @Override
      public Adapter caseSetDef(SetDef object)
      {
        return createSetDefAdapter();
      }
      @Override
      public Adapter caseSetLiteral(SetLiteral object)
      {
        return createSetLiteralAdapter();
      }
      @Override
      public Adapter caseRuleAssignment(RuleAssignment object)
      {
        return createRuleAssignmentAdapter();
      }
      @Override
      public Adapter caseDeleteAssignment(DeleteAssignment object)
      {
        return createDeleteAssignmentAdapter();
      }
      @Override
      public Adapter caseFunctionScope(FunctionScope object)
      {
        return createFunctionScopeAdapter();
      }
      @Override
      public Adapter caseInfiniteScope(InfiniteScope object)
      {
        return createInfiniteScopeAdapter();
      }
      @Override
      public Adapter caseFilter(Filter object)
      {
        return createFilterAdapter();
      }
      @Override
      public Adapter caseFunctionDomainScope(FunctionDomainScope object)
      {
        return createFunctionDomainScopeAdapter();
      }
      @Override
      public Adapter caseSetScope(SetScope object)
      {
        return createSetScopeAdapter();
      }
      @Override
      public Adapter caseSingleScope(SingleScope object)
      {
        return createSingleScopeAdapter();
      }
      @Override
      public Adapter caseSingleValue(SingleValue object)
      {
        return createSingleValueAdapter();
      }
      @Override
      public Adapter caseFixedValue(FixedValue object)
      {
        return createFixedValueAdapter();
      }
      @Override
      public Adapter caseFunctionAssignment(FunctionAssignment object)
      {
        return createFunctionAssignmentAdapter();
      }
      @Override
      public Adapter caseFullFunctionAssignment(FullFunctionAssignment object)
      {
        return createFullFunctionAssignmentAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseOclFunction(OclFunction object)
      {
        return createOclFunctionAdapter();
      }
      @Override
      public Adapter caseFullFunction(FullFunction object)
      {
        return createFullFunctionAdapter();
      }
      @Override
      public Adapter caseBlock(Block object)
      {
        return createBlockAdapter();
      }
      @Override
      public Adapter caseSingleStatement(SingleStatement object)
      {
        return createSingleStatementAdapter();
      }
      @Override
      public Adapter caseLetStatement(LetStatement object)
      {
        return createLetStatementAdapter();
      }
      @Override
      public Adapter caseReturnStatement(ReturnStatement object)
      {
        return createReturnStatementAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseForStatement(ForStatement object)
      {
        return createForStatementAdapter();
      }
      @Override
      public Adapter caseForLoopStatement(ForLoopStatement object)
      {
        return createForLoopStatementAdapter();
      }
      @Override
      public Adapter caseMaybeValue(MaybeValue object)
      {
        return createMaybeValueAdapter();
      }
      @Override
      public Adapter caseParDef(ParDef object)
      {
        return createParDefAdapter();
      }
      @Override
      public Adapter caseFunctionParDef(FunctionParDef object)
      {
        return createFunctionParDefAdapter();
      }
      @Override
      public Adapter caseCalculatedValue(CalculatedValue object)
      {
        return createCalculatedValueAdapter();
      }
      @Override
      public Adapter caseIfThenElse(IfThenElse object)
      {
        return createIfThenElseAdapter();
      }
      @Override
      public Adapter caseFunctionCall(FunctionCall object)
      {
        return createFunctionCallAdapter();
      }
      @Override
      public Adapter caseJavaFunctionCall(JavaFunctionCall object)
      {
        return createJavaFunctionCallAdapter();
      }
      @Override
      public Adapter caseFunctionPars(FunctionPars object)
      {
        return createFunctionParsAdapter();
      }
      @Override
      public Adapter caseFunctionPar(FunctionPar object)
      {
        return createFunctionParAdapter();
      }
      @Override
      public Adapter caseObjId(ObjId object)
      {
        return createObjIdAdapter();
      }
      @Override
      public Adapter caseObjParam(ObjParam object)
      {
        return createObjParamAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.VLang <em>VLang</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.VLang
   * @generated
   */
  public Adapter createVLangAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.AssignStatement <em>Assign Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.AssignStatement
   * @generated
   */
  public Adapter createAssignStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.SetOrFunctionDef <em>Set Or Function Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.SetOrFunctionDef
   * @generated
   */
  public Adapter createSetOrFunctionDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDef <em>Function Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionDef
   * @generated
   */
  public Adapter createFunctionDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.JavaFunctionDef <em>Java Function Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.JavaFunctionDef
   * @generated
   */
  public Adapter createJavaFunctionDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.BasicAction <em>Basic Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.BasicAction
   * @generated
   */
  public Adapter createBasicActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.SetDef <em>Set Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.SetDef
   * @generated
   */
  public Adapter createSetDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.SetLiteral <em>Set Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.SetLiteral
   * @generated
   */
  public Adapter createSetLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.RuleAssignment <em>Rule Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.RuleAssignment
   * @generated
   */
  public Adapter createRuleAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.DeleteAssignment <em>Delete Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.DeleteAssignment
   * @generated
   */
  public Adapter createDeleteAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionScope <em>Function Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionScope
   * @generated
   */
  public Adapter createFunctionScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.InfiniteScope <em>Infinite Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.InfiniteScope
   * @generated
   */
  public Adapter createInfiniteScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.Filter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.Filter
   * @generated
   */
  public Adapter createFilterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionDomainScope <em>Function Domain Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionDomainScope
   * @generated
   */
  public Adapter createFunctionDomainScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.SetScope <em>Set Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.SetScope
   * @generated
   */
  public Adapter createSetScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.SingleScope <em>Single Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.SingleScope
   * @generated
   */
  public Adapter createSingleScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.SingleValue <em>Single Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.SingleValue
   * @generated
   */
  public Adapter createSingleValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FixedValue <em>Fixed Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FixedValue
   * @generated
   */
  public Adapter createFixedValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionAssignment <em>Function Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionAssignment
   * @generated
   */
  public Adapter createFunctionAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FullFunctionAssignment <em>Full Function Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FullFunctionAssignment
   * @generated
   */
  public Adapter createFullFunctionAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.OclFunction <em>Ocl Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.OclFunction
   * @generated
   */
  public Adapter createOclFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FullFunction <em>Full Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FullFunction
   * @generated
   */
  public Adapter createFullFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.Block
   * @generated
   */
  public Adapter createBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.SingleStatement <em>Single Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.SingleStatement
   * @generated
   */
  public Adapter createSingleStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.LetStatement <em>Let Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.LetStatement
   * @generated
   */
  public Adapter createLetStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.ReturnStatement
   * @generated
   */
  public Adapter createReturnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.ForStatement
   * @generated
   */
  public Adapter createForStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.ForLoopStatement <em>For Loop Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.ForLoopStatement
   * @generated
   */
  public Adapter createForLoopStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.MaybeValue <em>Maybe Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.MaybeValue
   * @generated
   */
  public Adapter createMaybeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.ParDef <em>Par Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.ParDef
   * @generated
   */
  public Adapter createParDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionParDef <em>Function Par Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionParDef
   * @generated
   */
  public Adapter createFunctionParDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.CalculatedValue <em>Calculated Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.CalculatedValue
   * @generated
   */
  public Adapter createCalculatedValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.IfThenElse <em>If Then Else</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.IfThenElse
   * @generated
   */
  public Adapter createIfThenElseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionCall
   * @generated
   */
  public Adapter createFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.JavaFunctionCall <em>Java Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.JavaFunctionCall
   * @generated
   */
  public Adapter createJavaFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionPars <em>Function Pars</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionPars
   * @generated
   */
  public Adapter createFunctionParsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.FunctionPar <em>Function Par</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.FunctionPar
   * @generated
   */
  public Adapter createFunctionParAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.ObjId <em>Obj Id</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.ObjId
   * @generated
   */
  public Adapter createObjIdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.virtmodel.vLang.ObjParam <em>Obj Param</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see at.ac.tuwien.big.virtmodel.vLang.ObjParam
   * @generated
   */
  public Adapter createObjParamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //VLangAdapterFactory
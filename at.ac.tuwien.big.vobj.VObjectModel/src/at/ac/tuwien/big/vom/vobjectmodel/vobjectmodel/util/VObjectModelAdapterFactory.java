/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.util;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage
 * @generated
 */
public class VObjectModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VObjectModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjectModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = VObjectModelPackage.eINSTANCE;
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
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
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
	protected VObjectModelSwitch<Adapter> modelSwitch =
		new VObjectModelSwitch<Adapter>() {
			@Override
			public Adapter caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			@Override
			public Adapter caseIdentifierRefOrCmp(IdentifierRefOrCmp object) {
				return createIdentifierRefOrCmpAdapter();
			}
			@Override
			public Adapter caseIdentifierRef(IdentifierRef object) {
				return createIdentifierRefAdapter();
			}
			@Override
			public Adapter caseIdentifierCmp(IdentifierCmp object) {
				return createIdentifierCmpAdapter();
			}
			@Override
			public Adapter caseCreatorId(CreatorId object) {
				return createCreatorIdAdapter();
			}
			@Override
			public Adapter caseAnyValue(AnyValue object) {
				return createAnyValueAdapter();
			}
			@Override
			public Adapter caseJavaValue(JavaValue object) {
				return createJavaValueAdapter();
			}
			@Override
			public Adapter caseVObjDeltaModel(VObjDeltaModel object) {
				return createVObjDeltaModelAdapter();
			}
			@Override
			public Adapter caseBasicFunction(BasicFunction object) {
				return createBasicFunctionAdapter();
			}
			@Override
			public Adapter caseFunction(Function object) {
				return createFunctionAdapter();
			}
			@Override
			public Adapter caseValuePair(ValuePair object) {
				return createValuePairAdapter();
			}
			@Override
			public Adapter caseFiniteUnionFunction(FiniteUnionFunction object) {
				return createFiniteUnionFunctionAdapter();
			}
			@Override
			public Adapter caseDeltaFunction(DeltaFunction object) {
				return createDeltaFunctionAdapter();
			}
			@Override
			public Adapter caseStoredFuncs(StoredFuncs object) {
				return createStoredFuncsAdapter();
			}
			@Override
			public Adapter caseFeatureFunc(FeatureFunc object) {
				return createFeatureFuncAdapter();
			}
			@Override
			public Adapter caseDeltaStore(DeltaStore object) {
				return createDeltaStoreAdapter();
			}
			@Override
			public Adapter caseCompleteFile(CompleteFile object) {
				return createCompleteFileAdapter();
			}
			@Override
			public Adapter caseLanguageDef(LanguageDef object) {
				return createLanguageDefAdapter();
			}
			@Override
			public Adapter caseEcoreDef(EcoreDef object) {
				return createEcoreDefAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp <em>Identifier Ref Or Cmp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp
	 * @generated
	 */
	public Adapter createIdentifierRefOrCmpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef <em>Identifier Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef
	 * @generated
	 */
	public Adapter createIdentifierRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp <em>Identifier Cmp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp
	 * @generated
	 */
	public Adapter createIdentifierCmpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId <em>Creator Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId
	 * @generated
	 */
	public Adapter createCreatorIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.AnyValue <em>Any Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.AnyValue
	 * @generated
	 */
	public Adapter createAnyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue <em>Java Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue
	 * @generated
	 */
	public Adapter createJavaValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel <em>VObj Delta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel
	 * @generated
	 */
	public Adapter createVObjDeltaModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction <em>Basic Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction
	 * @generated
	 */
	public Adapter createBasicFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair <em>Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair
	 * @generated
	 */
	public Adapter createValuePairAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FiniteUnionFunction <em>Finite Union Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FiniteUnionFunction
	 * @generated
	 */
	public Adapter createFiniteUnionFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction <em>Delta Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction
	 * @generated
	 */
	public Adapter createDeltaFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs <em>Stored Funcs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs
	 * @generated
	 */
	public Adapter createStoredFuncsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc <em>Feature Func</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc
	 * @generated
	 */
	public Adapter createFeatureFuncAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore <em>Delta Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore
	 * @generated
	 */
	public Adapter createDeltaStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile <em>Complete File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile
	 * @generated
	 */
	public Adapter createCompleteFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef <em>Language Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef
	 * @generated
	 */
	public Adapter createLanguageDefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef <em>Ecore Def</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef
	 * @generated
	 */
	public Adapter createEcoreDefAdapter() {
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
	public Adapter createEObjectAdapter() {
		return null;
	}

} //VObjectModelAdapterFactory

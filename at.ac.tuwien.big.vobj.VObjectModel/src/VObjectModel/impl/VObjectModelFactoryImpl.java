/**
 */
package VObjectModel.impl;

import VObjectModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VObjectModelFactoryImpl extends EFactoryImpl implements VObjectModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VObjectModelFactory init() {
		try {
			VObjectModelFactory theVObjectModelFactory = (VObjectModelFactory)EPackage.Registry.INSTANCE.getEFactory(VObjectModelPackage.eNS_URI);
			if (theVObjectModelFactory != null) {
				return theVObjectModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VObjectModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjectModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VObjectModelPackage.IDENTIFIER: return createIdentifier();
			case VObjectModelPackage.IDENTIFIER_REF_OR_CMP: return createIdentifierRefOrCmp();
			case VObjectModelPackage.IDENTIFIER_REF: return createIdentifierRef();
			case VObjectModelPackage.IDENTIFIER_CMP: return createIdentifierCmp();
			case VObjectModelPackage.CREATOR_ID: return createCreatorId();
			case VObjectModelPackage.ANY_VALUE: return createAnyValue();
			case VObjectModelPackage.JAVA_VALUE: return createJavaValue();
			case VObjectModelPackage.VOBJ_DELTA_MODEL: return createVObjDeltaModel();
			case VObjectModelPackage.BASIC_FUNCTION: return createBasicFunction();
			case VObjectModelPackage.VALUE_PAIR: return createValuePair();
			case VObjectModelPackage.FINITE_UNION_FUNCTION: return createFiniteUnionFunction();
			case VObjectModelPackage.DELTA_FUNCTION: return createDeltaFunction();
			case VObjectModelPackage.STORED_FUNCS: return createStoredFuncs();
			case VObjectModelPackage.FEATURE_FUNC: return createFeatureFunc();
			case VObjectModelPackage.DELTA_STORE: return createDeltaStore();
			case VObjectModelPackage.COMPLETE_FILE: return createCompleteFile();
			case VObjectModelPackage.LANGUAGE_DEF: return createLanguageDef();
			case VObjectModelPackage.ECORE_DEF: return createEcoreDef();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier createIdentifier() {
		IdentifierImpl identifier = new IdentifierImpl();
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierRefOrCmp createIdentifierRefOrCmp() {
		IdentifierRefOrCmpImpl identifierRefOrCmp = new IdentifierRefOrCmpImpl();
		return identifierRefOrCmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierRef createIdentifierRef() {
		IdentifierRefImpl identifierRef = new IdentifierRefImpl();
		return identifierRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierCmp createIdentifierCmp() {
		IdentifierCmpImpl identifierCmp = new IdentifierCmpImpl();
		return identifierCmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreatorId createCreatorId() {
		CreatorIdImpl creatorId = new CreatorIdImpl();
		return creatorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyValue createAnyValue() {
		AnyValueImpl anyValue = new AnyValueImpl();
		return anyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaValue createJavaValue() {
		JavaValueImpl javaValue = new JavaValueImpl();
		return javaValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjDeltaModel createVObjDeltaModel() {
		VObjDeltaModelImpl vObjDeltaModel = new VObjDeltaModelImpl();
		return vObjDeltaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunction createBasicFunction() {
		BasicFunctionImpl basicFunction = new BasicFunctionImpl();
		return basicFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValuePair createValuePair() {
		ValuePairImpl valuePair = new ValuePairImpl();
		return valuePair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FiniteUnionFunction createFiniteUnionFunction() {
		FiniteUnionFunctionImpl finiteUnionFunction = new FiniteUnionFunctionImpl();
		return finiteUnionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaFunction createDeltaFunction() {
		DeltaFunctionImpl deltaFunction = new DeltaFunctionImpl();
		return deltaFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoredFuncs createStoredFuncs() {
		StoredFuncsImpl storedFuncs = new StoredFuncsImpl();
		return storedFuncs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureFunc createFeatureFunc() {
		FeatureFuncImpl featureFunc = new FeatureFuncImpl();
		return featureFunc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeltaStore createDeltaStore() {
		DeltaStoreImpl deltaStore = new DeltaStoreImpl();
		return deltaStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteFile createCompleteFile() {
		CompleteFileImpl completeFile = new CompleteFileImpl();
		return completeFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageDef createLanguageDef() {
		LanguageDefImpl languageDef = new LanguageDefImpl();
		return languageDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreDef createEcoreDef() {
		EcoreDefImpl ecoreDef = new EcoreDefImpl();
		return ecoreDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjectModelPackage getVObjectModelPackage() {
		return (VObjectModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VObjectModelPackage getPackage() {
		return VObjectModelPackage.eINSTANCE;
	}

} //VObjectModelFactoryImpl

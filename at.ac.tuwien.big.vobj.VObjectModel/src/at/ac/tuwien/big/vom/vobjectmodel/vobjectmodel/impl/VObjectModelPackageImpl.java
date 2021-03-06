/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.AnyRoot;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.AnyValue;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FiniteUnionFunction;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierParam;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VObjectModelPackageImpl extends EPackageImpl implements VObjectModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierRefOrCmpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierCmpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass creatorIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vObjDeltaModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valuePairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finiteUnionFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deltaFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storedFuncsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureFuncEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deltaStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass languageDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anyRootEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VObjectModelPackageImpl() {
		super(eNS_URI, VObjectModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link VObjectModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VObjectModelPackage init() {
		if (isInited) return (VObjectModelPackage)EPackage.Registry.INSTANCE.getEPackage(VObjectModelPackage.eNS_URI);

		// Obtain or create and register package
		VObjectModelPackageImpl theVObjectModelPackage = (VObjectModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VObjectModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VObjectModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theVObjectModelPackage.createPackageContents();

		// Initialize created meta-data
		theVObjectModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVObjectModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VObjectModelPackage.eNS_URI, theVObjectModelPackage);
		return theVObjectModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifier() {
		return identifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifier_Identifierreforcmp() {
		return (EReference)identifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifier_Name() {
		return (EAttribute)identifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifier_Creatorid() {
		return (EReference)identifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifier_Hc() {
		return (EAttribute)identifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIdentifier__HashCode() {
		return identifierEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIdentifier__Equals__Identifier() {
		return identifierEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIdentifier__Init() {
		return identifierEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierParam() {
		return identifierParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierParam_Identifier() {
		return (EReference)identifierParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierParam_IdentifierPars() {
		return (EReference)identifierParamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierRefOrCmp() {
		return identifierRefOrCmpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierRefOrCmp_Identifier() {
		return (EReference)identifierRefOrCmpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierRef() {
		return identifierRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierRef_Identifierreforcmp() {
		return (EReference)identifierRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierRef_S_identifier() {
		return (EReference)identifierRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierCmp() {
		return identifierCmpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierCmp_S_identifier() {
		return (EReference)identifierCmpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreatorId() {
		return creatorIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreatorId_Namespace() {
		return (EAttribute)creatorIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreatorId_Name() {
		return (EAttribute)creatorIdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnyValue() {
		return anyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaValue() {
		return javaValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaValue_Value() {
		return (EAttribute)javaValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVObjDeltaModel() {
		return vObjDeltaModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVObjDeltaModel_Functions() {
		return (EReference)vObjDeltaModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVObjDeltaModel_Storedfuncs() {
		return (EReference)vObjDeltaModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVObjDeltaModel_Identifiers() {
		return (EReference)vObjDeltaModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVObjDeltaModel_IdentifierPars() {
		return (EReference)vObjDeltaModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicFunction() {
		return basicFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicFunction_Values() {
		return (EReference)basicFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValuePair() {
		return valuePairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValuePair_Key() {
		return (EAttribute)valuePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValuePair_Value() {
		return (EAttribute)valuePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValuePair_IdentifierValue() {
		return (EReference)valuePairEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFiniteUnionFunction() {
		return finiteUnionFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFiniteUnionFunction_BaseFunc() {
		return (EReference)finiteUnionFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeltaFunction() {
		return deltaFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeltaFunction_Wrapped() {
		return (EReference)deltaFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeltaFunction_Deltastore() {
		return (EReference)deltaFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoredFuncs() {
		return storedFuncsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoredFuncs_Identifier() {
		return (EReference)storedFuncsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoredFuncs_Featurefunc() {
		return (EReference)storedFuncsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureFunc() {
		return featureFuncEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureFunc_Deltastore() {
		return (EReference)featureFuncEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureFunc_Name() {
		return (EAttribute)featureFuncEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureFunc_Classref() {
		return (EAttribute)featureFuncEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureFunc_Nsref() {
		return (EAttribute)featureFuncEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeltaStore() {
		return deltaStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeltaStore_AddMap() {
		return (EReference)deltaStoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeltaStore_FilterScope() {
		return (EReference)deltaStoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteFile() {
		return completeFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteFile_VirtModels() {
		return (EAttribute)completeFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteFile_InputModels() {
		return (EAttribute)completeFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteFile_Deltamodel() {
		return (EReference)completeFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteFile_LastModelText() {
		return (EAttribute)completeFileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompleteFile_CurrentModelText() {
		return (EAttribute)completeFileEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteFile_Xtextlanguage() {
		return (EReference)completeFileEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteFile_Ecoredef() {
		return (EReference)completeFileEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteFile_RootObjects() {
		return (EReference)completeFileEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLanguageDef() {
		return languageDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLanguageDef_LangStandaloneSetup() {
		return (EAttribute)languageDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreDef() {
		return ecoreDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreDef_FactoryPackage() {
		return (EAttribute)ecoreDefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcoreDef_PackagePackage() {
		return (EAttribute)ecoreDefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnyRoot() {
		return anyRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjectModelFactory getVObjectModelFactory() {
		return (VObjectModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		identifierEClass = createEClass(IDENTIFIER);
		createEReference(identifierEClass, IDENTIFIER__IDENTIFIERREFORCMP);
		createEAttribute(identifierEClass, IDENTIFIER__NAME);
		createEReference(identifierEClass, IDENTIFIER__CREATORID);
		createEAttribute(identifierEClass, IDENTIFIER__HC);
		createEOperation(identifierEClass, IDENTIFIER___HASH_CODE);
		createEOperation(identifierEClass, IDENTIFIER___EQUALS__IDENTIFIER);
		createEOperation(identifierEClass, IDENTIFIER___INIT);

		identifierParamEClass = createEClass(IDENTIFIER_PARAM);
		createEReference(identifierParamEClass, IDENTIFIER_PARAM__IDENTIFIER);
		createEReference(identifierParamEClass, IDENTIFIER_PARAM__IDENTIFIER_PARS);

		identifierRefOrCmpEClass = createEClass(IDENTIFIER_REF_OR_CMP);
		createEReference(identifierRefOrCmpEClass, IDENTIFIER_REF_OR_CMP__IDENTIFIER);

		identifierRefEClass = createEClass(IDENTIFIER_REF);
		createEReference(identifierRefEClass, IDENTIFIER_REF__IDENTIFIERREFORCMP);
		createEReference(identifierRefEClass, IDENTIFIER_REF__SIDENTIFIER);

		identifierCmpEClass = createEClass(IDENTIFIER_CMP);
		createEReference(identifierCmpEClass, IDENTIFIER_CMP__SIDENTIFIER);

		creatorIdEClass = createEClass(CREATOR_ID);
		createEAttribute(creatorIdEClass, CREATOR_ID__NAMESPACE);
		createEAttribute(creatorIdEClass, CREATOR_ID__NAME);

		anyValueEClass = createEClass(ANY_VALUE);

		javaValueEClass = createEClass(JAVA_VALUE);
		createEAttribute(javaValueEClass, JAVA_VALUE__VALUE);

		vObjDeltaModelEClass = createEClass(VOBJ_DELTA_MODEL);
		createEReference(vObjDeltaModelEClass, VOBJ_DELTA_MODEL__FUNCTIONS);
		createEReference(vObjDeltaModelEClass, VOBJ_DELTA_MODEL__STOREDFUNCS);
		createEReference(vObjDeltaModelEClass, VOBJ_DELTA_MODEL__IDENTIFIERS);
		createEReference(vObjDeltaModelEClass, VOBJ_DELTA_MODEL__IDENTIFIER_PARS);

		basicFunctionEClass = createEClass(BASIC_FUNCTION);
		createEReference(basicFunctionEClass, BASIC_FUNCTION__VALUES);

		functionEClass = createEClass(FUNCTION);

		valuePairEClass = createEClass(VALUE_PAIR);
		createEAttribute(valuePairEClass, VALUE_PAIR__KEY);
		createEAttribute(valuePairEClass, VALUE_PAIR__VALUE);
		createEReference(valuePairEClass, VALUE_PAIR__IDENTIFIER_VALUE);

		finiteUnionFunctionEClass = createEClass(FINITE_UNION_FUNCTION);
		createEReference(finiteUnionFunctionEClass, FINITE_UNION_FUNCTION__BASE_FUNC);

		deltaFunctionEClass = createEClass(DELTA_FUNCTION);
		createEReference(deltaFunctionEClass, DELTA_FUNCTION__WRAPPED);
		createEReference(deltaFunctionEClass, DELTA_FUNCTION__DELTASTORE);

		storedFuncsEClass = createEClass(STORED_FUNCS);
		createEReference(storedFuncsEClass, STORED_FUNCS__IDENTIFIER);
		createEReference(storedFuncsEClass, STORED_FUNCS__FEATUREFUNC);

		featureFuncEClass = createEClass(FEATURE_FUNC);
		createEReference(featureFuncEClass, FEATURE_FUNC__DELTASTORE);
		createEAttribute(featureFuncEClass, FEATURE_FUNC__NAME);
		createEAttribute(featureFuncEClass, FEATURE_FUNC__CLASSREF);
		createEAttribute(featureFuncEClass, FEATURE_FUNC__NSREF);

		deltaStoreEClass = createEClass(DELTA_STORE);
		createEReference(deltaStoreEClass, DELTA_STORE__ADD_MAP);
		createEReference(deltaStoreEClass, DELTA_STORE__FILTER_SCOPE);

		completeFileEClass = createEClass(COMPLETE_FILE);
		createEAttribute(completeFileEClass, COMPLETE_FILE__VIRT_MODELS);
		createEAttribute(completeFileEClass, COMPLETE_FILE__INPUT_MODELS);
		createEReference(completeFileEClass, COMPLETE_FILE__DELTAMODEL);
		createEAttribute(completeFileEClass, COMPLETE_FILE__LAST_MODEL_TEXT);
		createEAttribute(completeFileEClass, COMPLETE_FILE__CURRENT_MODEL_TEXT);
		createEReference(completeFileEClass, COMPLETE_FILE__XTEXTLANGUAGE);
		createEReference(completeFileEClass, COMPLETE_FILE__ECOREDEF);
		createEReference(completeFileEClass, COMPLETE_FILE__ROOT_OBJECTS);

		languageDefEClass = createEClass(LANGUAGE_DEF);
		createEAttribute(languageDefEClass, LANGUAGE_DEF__LANG_STANDALONE_SETUP);

		ecoreDefEClass = createEClass(ECORE_DEF);
		createEAttribute(ecoreDefEClass, ECORE_DEF__FACTORY_PACKAGE);
		createEAttribute(ecoreDefEClass, ECORE_DEF__PACKAGE_PACKAGE);

		anyRootEClass = createEClass(ANY_ROOT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		identifierEClass.getESuperTypes().add(this.getAnyRoot());
		identifierRefOrCmpEClass.getESuperTypes().add(this.getAnyValue());
		identifierRefEClass.getESuperTypes().add(this.getIdentifierRefOrCmp());
		identifierCmpEClass.getESuperTypes().add(this.getIdentifierRefOrCmp());
		javaValueEClass.getESuperTypes().add(this.getAnyValue());
		basicFunctionEClass.getESuperTypes().add(this.getFunction());
		completeFileEClass.getESuperTypes().add(this.getAnyRoot());

		// Initialize classes, features, and operations; add parameters
		initEClass(identifierEClass, Identifier.class, "Identifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifier_Identifierreforcmp(), this.getAnyValue(), null, "identifierreforcmp", null, 0, -1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentifier_Name(), ecorePackage.getEString(), "name", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdentifier_Creatorid(), this.getCreatorId(), null, "creatorid", null, 0, 1, Identifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentifier_Hc(), ecorePackage.getEInt(), "hc", null, 1, 1, Identifier.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getIdentifier__HashCode(), ecorePackage.getEInt(), "hashCode", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getIdentifier__Equals__Identifier(), ecorePackage.getEBoolean(), "equals", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIdentifier(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getIdentifier__Init(), null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(identifierParamEClass, IdentifierParam.class, "IdentifierParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierParam_Identifier(), this.getIdentifier(), null, "identifier", null, 1, 1, IdentifierParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdentifierParam_IdentifierPars(), this.getIdentifier(), null, "identifierPars", null, 0, -1, IdentifierParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierRefOrCmpEClass, IdentifierRefOrCmp.class, "IdentifierRefOrCmp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierRefOrCmp_Identifier(), this.getIdentifier(), null, "identifier", null, 0, 1, IdentifierRefOrCmp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(identifierRefEClass, IdentifierRef.class, "IdentifierRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierRef_Identifierreforcmp(), this.getIdentifierRefOrCmp(), null, "identifierreforcmp", null, 0, 1, IdentifierRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdentifierRef_S_identifier(), this.getIdentifier(), null, "s_identifier", null, 0, 1, IdentifierRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierCmpEClass, IdentifierCmp.class, "IdentifierCmp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierCmp_S_identifier(), this.getIdentifier(), null, "s_identifier", null, 0, 1, IdentifierCmp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(creatorIdEClass, CreatorId.class, "CreatorId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreatorId_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, CreatorId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreatorId_Name(), ecorePackage.getEString(), "name", null, 0, 1, CreatorId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(anyValueEClass, AnyValue.class, "AnyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(javaValueEClass, JavaValue.class, "JavaValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaValue_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, JavaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vObjDeltaModelEClass, VObjDeltaModel.class, "VObjDeltaModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVObjDeltaModel_Functions(), this.getFunction(), null, "functions", null, 0, -1, VObjDeltaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVObjDeltaModel_Storedfuncs(), this.getStoredFuncs(), null, "storedfuncs", null, 0, -1, VObjDeltaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVObjDeltaModel_Identifiers(), this.getIdentifier(), null, "identifiers", null, 0, -1, VObjDeltaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVObjDeltaModel_IdentifierPars(), this.getIdentifierParam(), null, "identifierPars", null, 0, -1, VObjDeltaModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicFunctionEClass, BasicFunction.class, "BasicFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicFunction_Values(), this.getValuePair(), null, "values", null, 0, -1, BasicFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valuePairEClass, ValuePair.class, "ValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValuePair_Key(), ecorePackage.getEJavaObject(), "key", null, 0, 1, ValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValuePair_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, ValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuePair_IdentifierValue(), this.getIdentifier(), null, "identifierValue", null, 0, 1, ValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finiteUnionFunctionEClass, FiniteUnionFunction.class, "FiniteUnionFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFiniteUnionFunction_BaseFunc(), this.getFunction(), null, "baseFunc", null, 0, -1, FiniteUnionFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deltaFunctionEClass, DeltaFunction.class, "DeltaFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeltaFunction_Wrapped(), this.getFunction(), null, "wrapped", null, 0, 1, DeltaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeltaFunction_Deltastore(), this.getDeltaStore(), null, "deltastore", null, 0, 1, DeltaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storedFuncsEClass, StoredFuncs.class, "StoredFuncs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStoredFuncs_Identifier(), this.getIdentifier(), null, "identifier", null, 0, 1, StoredFuncs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStoredFuncs_Featurefunc(), this.getFeatureFunc(), null, "featurefunc", null, 0, -1, StoredFuncs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureFuncEClass, FeatureFunc.class, "FeatureFunc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureFunc_Deltastore(), this.getDeltaStore(), null, "deltastore", null, 0, 1, FeatureFunc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureFunc_Name(), ecorePackage.getEString(), "name", null, 0, 1, FeatureFunc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureFunc_Classref(), ecorePackage.getEString(), "classref", null, 0, 1, FeatureFunc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureFunc_Nsref(), ecorePackage.getEString(), "nsref", null, 0, 1, FeatureFunc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deltaStoreEClass, DeltaStore.class, "DeltaStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeltaStore_AddMap(), this.getBasicFunction(), null, "addMap", null, 0, 1, DeltaStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeltaStore_FilterScope(), this.getBasicFunction(), null, "filterScope", null, 0, 1, DeltaStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completeFileEClass, CompleteFile.class, "CompleteFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompleteFile_VirtModels(), ecorePackage.getEString(), "virtModels", null, 0, -1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompleteFile_InputModels(), ecorePackage.getEString(), "inputModels", null, 0, -1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteFile_Deltamodel(), this.getVObjDeltaModel(), null, "deltamodel", null, 0, 1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompleteFile_LastModelText(), ecorePackage.getEString(), "lastModelText", null, 0, 1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompleteFile_CurrentModelText(), ecorePackage.getEString(), "currentModelText", null, 0, 1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteFile_Xtextlanguage(), this.getLanguageDef(), null, "xtextlanguage", null, 0, 1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteFile_Ecoredef(), this.getEcoreDef(), null, "ecoredef", null, 0, -1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteFile_RootObjects(), this.getIdentifier(), null, "rootObjects", null, 0, -1, CompleteFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(languageDefEClass, LanguageDef.class, "LanguageDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLanguageDef_LangStandaloneSetup(), ecorePackage.getEString(), "langStandaloneSetup", null, 0, 1, LanguageDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecoreDefEClass, EcoreDef.class, "EcoreDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEcoreDef_FactoryPackage(), ecorePackage.getEString(), "factoryPackage", null, 0, 1, EcoreDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcoreDef_PackagePackage(), ecorePackage.getEString(), "packagePackage", null, 0, 1, EcoreDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(anyRootEClass, AnyRoot.class, "AnyRoot", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //VObjectModelPackageImpl

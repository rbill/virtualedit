/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface VObjectModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vobjectmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/VObjectModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vobjectmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VObjectModelPackage eINSTANCE = at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierImpl <em>Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifier()
	 * @generated
	 */
	int IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Identifierreforcmp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__IDENTIFIERREFORCMP = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Creatorid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__CREATORID = 2;

	/**
	 * The feature id for the '<em><b>Hc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__HC = 3;

	/**
	 * The number of structural features of the '<em>Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Hash Code</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER___HASH_CODE = 0;

	/**
	 * The operation id for the '<em>Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER___EQUALS__IDENTIFIER = 1;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER___INIT = 2;

	/**
	 * The number of operations of the '<em>Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.AnyValueImpl <em>Any Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.AnyValueImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getAnyValue()
	 * @generated
	 */
	int ANY_VALUE = 5;

	/**
	 * The number of structural features of the '<em>Any Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Any Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefOrCmpImpl <em>Identifier Ref Or Cmp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefOrCmpImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifierRefOrCmp()
	 * @generated
	 */
	int IDENTIFIER_REF_OR_CMP = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF_OR_CMP__IDENTIFIER = ANY_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifier Ref Or Cmp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF_OR_CMP_FEATURE_COUNT = ANY_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Identifier Ref Or Cmp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF_OR_CMP_OPERATION_COUNT = ANY_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefImpl <em>Identifier Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifierRef()
	 * @generated
	 */
	int IDENTIFIER_REF = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF__IDENTIFIER = IDENTIFIER_REF_OR_CMP__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Identifierreforcmp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF__IDENTIFIERREFORCMP = IDENTIFIER_REF_OR_CMP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sidentifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF__SIDENTIFIER = IDENTIFIER_REF_OR_CMP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Identifier Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF_FEATURE_COUNT = IDENTIFIER_REF_OR_CMP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Identifier Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_REF_OPERATION_COUNT = IDENTIFIER_REF_OR_CMP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierCmpImpl <em>Identifier Cmp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierCmpImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifierCmp()
	 * @generated
	 */
	int IDENTIFIER_CMP = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CMP__IDENTIFIER = IDENTIFIER_REF_OR_CMP__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Sidentifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CMP__SIDENTIFIER = IDENTIFIER_REF_OR_CMP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identifier Cmp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CMP_FEATURE_COUNT = IDENTIFIER_REF_OR_CMP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Identifier Cmp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_CMP_OPERATION_COUNT = IDENTIFIER_REF_OR_CMP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CreatorIdImpl <em>Creator Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CreatorIdImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getCreatorId()
	 * @generated
	 */
	int CREATOR_ID = 4;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATOR_ID__NAMESPACE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATOR_ID__NAME = 1;

	/**
	 * The number of structural features of the '<em>Creator Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATOR_ID_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Creator Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATOR_ID_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.JavaValueImpl <em>Java Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.JavaValueImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getJavaValue()
	 * @generated
	 */
	int JAVA_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VALUE__VALUE = ANY_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VALUE_FEATURE_COUNT = ANY_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VALUE_OPERATION_COUNT = ANY_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjDeltaModelImpl <em>VObj Delta Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjDeltaModelImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getVObjDeltaModel()
	 * @generated
	 */
	int VOBJ_DELTA_MODEL = 7;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOBJ_DELTA_MODEL__FUNCTIONS = 0;

	/**
	 * The feature id for the '<em><b>Storedfuncs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOBJ_DELTA_MODEL__STOREDFUNCS = 1;

	/**
	 * The feature id for the '<em><b>Identifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOBJ_DELTA_MODEL__IDENTIFIERS = 2;

	/**
	 * The number of structural features of the '<em>VObj Delta Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOBJ_DELTA_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>VObj Delta Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOBJ_DELTA_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 9;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.BasicFunctionImpl <em>Basic Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.BasicFunctionImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getBasicFunction()
	 * @generated
	 */
	int BASIC_FUNCTION = 8;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION__VALUES = FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Basic Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_FUNCTION_OPERATION_COUNT = FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.ValuePairImpl <em>Value Pair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.ValuePairImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getValuePair()
	 * @generated
	 */
	int VALUE_PAIR = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PAIR__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PAIR__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Identifier Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PAIR__IDENTIFIER_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Value Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PAIR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Value Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PAIR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FiniteUnionFunctionImpl <em>Finite Union Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FiniteUnionFunctionImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getFiniteUnionFunction()
	 * @generated
	 */
	int FINITE_UNION_FUNCTION = 11;

	/**
	 * The feature id for the '<em><b>Base Func</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_UNION_FUNCTION__BASE_FUNC = 0;

	/**
	 * The number of structural features of the '<em>Finite Union Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_UNION_FUNCTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Finite Union Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_UNION_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaFunctionImpl <em>Delta Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaFunctionImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getDeltaFunction()
	 * @generated
	 */
	int DELTA_FUNCTION = 12;

	/**
	 * The feature id for the '<em><b>Wrapped</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_FUNCTION__WRAPPED = 0;

	/**
	 * The feature id for the '<em><b>Deltastore</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_FUNCTION__DELTASTORE = 1;

	/**
	 * The number of structural features of the '<em>Delta Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_FUNCTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Delta Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.StoredFuncsImpl <em>Stored Funcs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.StoredFuncsImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getStoredFuncs()
	 * @generated
	 */
	int STORED_FUNCS = 13;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_FUNCS__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Featurefunc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_FUNCS__FEATUREFUNC = 1;

	/**
	 * The number of structural features of the '<em>Stored Funcs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_FUNCS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Stored Funcs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORED_FUNCS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl <em>Feature Func</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getFeatureFunc()
	 * @generated
	 */
	int FEATURE_FUNC = 14;

	/**
	 * The feature id for the '<em><b>Deltastore</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FUNC__DELTASTORE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FUNC__NAME = 1;

	/**
	 * The feature id for the '<em><b>Classref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FUNC__CLASSREF = 2;

	/**
	 * The feature id for the '<em><b>Nsref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FUNC__NSREF = 3;

	/**
	 * The number of structural features of the '<em>Feature Func</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FUNC_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Feature Func</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FUNC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaStoreImpl <em>Delta Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaStoreImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getDeltaStore()
	 * @generated
	 */
	int DELTA_STORE = 15;

	/**
	 * The feature id for the '<em><b>Add Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_STORE__ADD_MAP = 0;

	/**
	 * The feature id for the '<em><b>Filter Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_STORE__FILTER_SCOPE = 1;

	/**
	 * The number of structural features of the '<em>Delta Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_STORE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Delta Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_STORE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CompleteFileImpl <em>Complete File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CompleteFileImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getCompleteFile()
	 * @generated
	 */
	int COMPLETE_FILE = 16;

	/**
	 * The feature id for the '<em><b>Virt Models</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__VIRT_MODELS = 0;

	/**
	 * The feature id for the '<em><b>Input Models</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__INPUT_MODELS = 1;

	/**
	 * The feature id for the '<em><b>Deltamodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__DELTAMODEL = 2;

	/**
	 * The feature id for the '<em><b>Last Model Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__LAST_MODEL_TEXT = 3;

	/**
	 * The feature id for the '<em><b>Current Model Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__CURRENT_MODEL_TEXT = 4;

	/**
	 * The feature id for the '<em><b>Xtextlanguage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__XTEXTLANGUAGE = 5;

	/**
	 * The feature id for the '<em><b>Ecoredef</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__ECOREDEF = 6;

	/**
	 * The feature id for the '<em><b>Root Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE__ROOT_OBJECTS = 7;

	/**
	 * The number of structural features of the '<em>Complete File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Complete File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.LanguageDefImpl <em>Language Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.LanguageDefImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getLanguageDef()
	 * @generated
	 */
	int LANGUAGE_DEF = 17;

	/**
	 * The feature id for the '<em><b>Lang Standalone Setup</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEF__LANG_STANDALONE_SETUP = 0;

	/**
	 * The number of structural features of the '<em>Language Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEF_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Language Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.EcoreDefImpl <em>Ecore Def</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.EcoreDefImpl
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getEcoreDef()
	 * @generated
	 */
	int ECORE_DEF = 18;

	/**
	 * The feature id for the '<em><b>Factory Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DEF__FACTORY_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Package Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DEF__PACKAGE_PACKAGE = 1;

	/**
	 * The number of structural features of the '<em>Ecore Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DEF_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Ecore Def</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_DEF_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier
	 * @generated
	 */
	EClass getIdentifier();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getIdentifierreforcmp <em>Identifierreforcmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifierreforcmp</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getIdentifierreforcmp()
	 * @see #getIdentifier()
	 * @generated
	 */
	EReference getIdentifier_Identifierreforcmp();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getName()
	 * @see #getIdentifier()
	 * @generated
	 */
	EAttribute getIdentifier_Name();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getCreatorid <em>Creatorid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Creatorid</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getCreatorid()
	 * @see #getIdentifier()
	 * @generated
	 */
	EReference getIdentifier_Creatorid();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getHc <em>Hc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hc</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#getHc()
	 * @see #getIdentifier()
	 * @generated
	 */
	EAttribute getIdentifier_Hc();

	/**
	 * Returns the meta object for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#hashCode()
	 * @generated
	 */
	EOperation getIdentifier__HashCode();

	/**
	 * Returns the meta object for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#equals(at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#equals(at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier)
	 * @generated
	 */
	EOperation getIdentifier__Equals__Identifier();

	/**
	 * Returns the meta object for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#init() <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier#init()
	 * @generated
	 */
	EOperation getIdentifier__Init();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp <em>Identifier Ref Or Cmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Ref Or Cmp</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp
	 * @generated
	 */
	EClass getIdentifierRefOrCmp();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRefOrCmp#getIdentifier()
	 * @see #getIdentifierRefOrCmp()
	 * @generated
	 */
	EReference getIdentifierRefOrCmp_Identifier();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef <em>Identifier Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Ref</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef
	 * @generated
	 */
	EClass getIdentifierRef();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getIdentifierreforcmp <em>Identifierreforcmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifierreforcmp</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getIdentifierreforcmp()
	 * @see #getIdentifierRef()
	 * @generated
	 */
	EReference getIdentifierRef_Identifierreforcmp();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getS_identifier <em>Sidentifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sidentifier</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierRef#getS_identifier()
	 * @see #getIdentifierRef()
	 * @generated
	 */
	EReference getIdentifierRef_S_identifier();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp <em>Identifier Cmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Cmp</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp
	 * @generated
	 */
	EClass getIdentifierCmp();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp#getS_identifier <em>Sidentifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sidentifier</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.IdentifierCmp#getS_identifier()
	 * @see #getIdentifierCmp()
	 * @generated
	 */
	EReference getIdentifierCmp_S_identifier();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId <em>Creator Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Creator Id</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId
	 * @generated
	 */
	EClass getCreatorId();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getNamespace()
	 * @see #getCreatorId()
	 * @generated
	 */
	EAttribute getCreatorId_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CreatorId#getName()
	 * @see #getCreatorId()
	 * @generated
	 */
	EAttribute getCreatorId_Name();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.AnyValue <em>Any Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Value</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.AnyValue
	 * @generated
	 */
	EClass getAnyValue();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue <em>Java Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Value</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue
	 * @generated
	 */
	EClass getJavaValue();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.JavaValue#getValue()
	 * @see #getJavaValue()
	 * @generated
	 */
	EAttribute getJavaValue_Value();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel <em>VObj Delta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VObj Delta Model</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel
	 * @generated
	 */
	EClass getVObjDeltaModel();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel#getFunctions()
	 * @see #getVObjDeltaModel()
	 * @generated
	 */
	EReference getVObjDeltaModel_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel#getStoredfuncs <em>Storedfuncs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Storedfuncs</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel#getStoredfuncs()
	 * @see #getVObjDeltaModel()
	 * @generated
	 */
	EReference getVObjDeltaModel_Storedfuncs();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel#getIdentifiers <em>Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifiers</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel#getIdentifiers()
	 * @see #getVObjDeltaModel()
	 * @generated
	 */
	EReference getVObjDeltaModel_Identifiers();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction <em>Basic Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Function</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction
	 * @generated
	 */
	EClass getBasicFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction#getValues()
	 * @see #getBasicFunction()
	 * @generated
	 */
	EReference getBasicFunction_Values();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair <em>Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Pair</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair
	 * @generated
	 */
	EClass getValuePair();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair#getKey()
	 * @see #getValuePair()
	 * @generated
	 */
	EAttribute getValuePair_Key();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair#getValue()
	 * @see #getValuePair()
	 * @generated
	 */
	EAttribute getValuePair_Value();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair#getIdentifierValue <em>Identifier Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier Value</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair#getIdentifierValue()
	 * @see #getValuePair()
	 * @generated
	 */
	EReference getValuePair_IdentifierValue();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FiniteUnionFunction <em>Finite Union Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finite Union Function</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FiniteUnionFunction
	 * @generated
	 */
	EClass getFiniteUnionFunction();

	/**
	 * Returns the meta object for the reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FiniteUnionFunction#getBaseFunc <em>Base Func</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Base Func</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FiniteUnionFunction#getBaseFunc()
	 * @see #getFiniteUnionFunction()
	 * @generated
	 */
	EReference getFiniteUnionFunction_BaseFunc();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction <em>Delta Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delta Function</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction
	 * @generated
	 */
	EClass getDeltaFunction();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getWrapped <em>Wrapped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wrapped</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getWrapped()
	 * @see #getDeltaFunction()
	 * @generated
	 */
	EReference getDeltaFunction_Wrapped();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getDeltastore <em>Deltastore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deltastore</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaFunction#getDeltastore()
	 * @see #getDeltaFunction()
	 * @generated
	 */
	EReference getDeltaFunction_Deltastore();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs <em>Stored Funcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stored Funcs</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs
	 * @generated
	 */
	EClass getStoredFuncs();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs#getIdentifier()
	 * @see #getStoredFuncs()
	 * @generated
	 */
	EReference getStoredFuncs_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs#getFeaturefunc <em>Featurefunc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Featurefunc</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs#getFeaturefunc()
	 * @see #getStoredFuncs()
	 * @generated
	 */
	EReference getStoredFuncs_Featurefunc();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc <em>Feature Func</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Func</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc
	 * @generated
	 */
	EClass getFeatureFunc();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getDeltastore <em>Deltastore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deltastore</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getDeltastore()
	 * @see #getFeatureFunc()
	 * @generated
	 */
	EReference getFeatureFunc_Deltastore();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getName()
	 * @see #getFeatureFunc()
	 * @generated
	 */
	EAttribute getFeatureFunc_Name();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getClassref <em>Classref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classref</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getClassref()
	 * @see #getFeatureFunc()
	 * @generated
	 */
	EAttribute getFeatureFunc_Classref();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getNsref <em>Nsref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nsref</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc#getNsref()
	 * @see #getFeatureFunc()
	 * @generated
	 */
	EAttribute getFeatureFunc_Nsref();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore <em>Delta Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delta Store</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore
	 * @generated
	 */
	EClass getDeltaStore();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore#getAddMap <em>Add Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Add Map</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore#getAddMap()
	 * @see #getDeltaStore()
	 * @generated
	 */
	EReference getDeltaStore_AddMap();

	/**
	 * Returns the meta object for the reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore#getFilterScope <em>Filter Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Filter Scope</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore#getFilterScope()
	 * @see #getDeltaStore()
	 * @generated
	 */
	EReference getDeltaStore_FilterScope();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile <em>Complete File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete File</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile
	 * @generated
	 */
	EClass getCompleteFile();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getVirtModels <em>Virt Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Virt Models</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getVirtModels()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EAttribute getCompleteFile_VirtModels();

	/**
	 * Returns the meta object for the attribute list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getInputModels <em>Input Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Input Models</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getInputModels()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EAttribute getCompleteFile_InputModels();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getDeltamodel <em>Deltamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deltamodel</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getDeltamodel()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EReference getCompleteFile_Deltamodel();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getLastModelText <em>Last Model Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Model Text</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getLastModelText()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EAttribute getCompleteFile_LastModelText();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getCurrentModelText <em>Current Model Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Model Text</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getCurrentModelText()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EAttribute getCompleteFile_CurrentModelText();

	/**
	 * Returns the meta object for the containment reference '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getXtextlanguage <em>Xtextlanguage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Xtextlanguage</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getXtextlanguage()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EReference getCompleteFile_Xtextlanguage();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getEcoredef <em>Ecoredef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ecoredef</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getEcoredef()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EReference getCompleteFile_Ecoredef();

	/**
	 * Returns the meta object for the containment reference list '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getRootObjects <em>Root Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Objects</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.CompleteFile#getRootObjects()
	 * @see #getCompleteFile()
	 * @generated
	 */
	EReference getCompleteFile_RootObjects();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef <em>Language Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Def</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef
	 * @generated
	 */
	EClass getLanguageDef();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef#getLangStandaloneSetup <em>Lang Standalone Setup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang Standalone Setup</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.LanguageDef#getLangStandaloneSetup()
	 * @see #getLanguageDef()
	 * @generated
	 */
	EAttribute getLanguageDef_LangStandaloneSetup();

	/**
	 * Returns the meta object for class '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef <em>Ecore Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Def</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef
	 * @generated
	 */
	EClass getEcoreDef();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getFactoryPackage <em>Factory Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Package</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getFactoryPackage()
	 * @see #getEcoreDef()
	 * @generated
	 */
	EAttribute getEcoreDef_FactoryPackage();

	/**
	 * Returns the meta object for the attribute '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getPackagePackage <em>Package Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Package</em>'.
	 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.EcoreDef#getPackagePackage()
	 * @see #getEcoreDef()
	 * @generated
	 */
	EAttribute getEcoreDef_PackagePackage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VObjectModelFactory getVObjectModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierImpl <em>Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifier()
		 * @generated
		 */
		EClass IDENTIFIER = eINSTANCE.getIdentifier();

		/**
		 * The meta object literal for the '<em><b>Identifierreforcmp</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER__IDENTIFIERREFORCMP = eINSTANCE.getIdentifier_Identifierreforcmp();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER__NAME = eINSTANCE.getIdentifier_Name();

		/**
		 * The meta object literal for the '<em><b>Creatorid</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER__CREATORID = eINSTANCE.getIdentifier_Creatorid();

		/**
		 * The meta object literal for the '<em><b>Hc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER__HC = eINSTANCE.getIdentifier_Hc();

		/**
		 * The meta object literal for the '<em><b>Hash Code</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IDENTIFIER___HASH_CODE = eINSTANCE.getIdentifier__HashCode();

		/**
		 * The meta object literal for the '<em><b>Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IDENTIFIER___EQUALS__IDENTIFIER = eINSTANCE.getIdentifier__Equals__Identifier();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IDENTIFIER___INIT = eINSTANCE.getIdentifier__Init();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefOrCmpImpl <em>Identifier Ref Or Cmp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefOrCmpImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifierRefOrCmp()
		 * @generated
		 */
		EClass IDENTIFIER_REF_OR_CMP = eINSTANCE.getIdentifierRefOrCmp();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_REF_OR_CMP__IDENTIFIER = eINSTANCE.getIdentifierRefOrCmp_Identifier();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefImpl <em>Identifier Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierRefImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifierRef()
		 * @generated
		 */
		EClass IDENTIFIER_REF = eINSTANCE.getIdentifierRef();

		/**
		 * The meta object literal for the '<em><b>Identifierreforcmp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_REF__IDENTIFIERREFORCMP = eINSTANCE.getIdentifierRef_Identifierreforcmp();

		/**
		 * The meta object literal for the '<em><b>Sidentifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_REF__SIDENTIFIER = eINSTANCE.getIdentifierRef_S_identifier();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierCmpImpl <em>Identifier Cmp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.IdentifierCmpImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getIdentifierCmp()
		 * @generated
		 */
		EClass IDENTIFIER_CMP = eINSTANCE.getIdentifierCmp();

		/**
		 * The meta object literal for the '<em><b>Sidentifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_CMP__SIDENTIFIER = eINSTANCE.getIdentifierCmp_S_identifier();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CreatorIdImpl <em>Creator Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CreatorIdImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getCreatorId()
		 * @generated
		 */
		EClass CREATOR_ID = eINSTANCE.getCreatorId();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATOR_ID__NAMESPACE = eINSTANCE.getCreatorId_Namespace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATOR_ID__NAME = eINSTANCE.getCreatorId_Name();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.AnyValueImpl <em>Any Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.AnyValueImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getAnyValue()
		 * @generated
		 */
		EClass ANY_VALUE = eINSTANCE.getAnyValue();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.JavaValueImpl <em>Java Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.JavaValueImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getJavaValue()
		 * @generated
		 */
		EClass JAVA_VALUE = eINSTANCE.getJavaValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_VALUE__VALUE = eINSTANCE.getJavaValue_Value();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjDeltaModelImpl <em>VObj Delta Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjDeltaModelImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getVObjDeltaModel()
		 * @generated
		 */
		EClass VOBJ_DELTA_MODEL = eINSTANCE.getVObjDeltaModel();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOBJ_DELTA_MODEL__FUNCTIONS = eINSTANCE.getVObjDeltaModel_Functions();

		/**
		 * The meta object literal for the '<em><b>Storedfuncs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOBJ_DELTA_MODEL__STOREDFUNCS = eINSTANCE.getVObjDeltaModel_Storedfuncs();

		/**
		 * The meta object literal for the '<em><b>Identifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOBJ_DELTA_MODEL__IDENTIFIERS = eINSTANCE.getVObjDeltaModel_Identifiers();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.BasicFunctionImpl <em>Basic Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.BasicFunctionImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getBasicFunction()
		 * @generated
		 */
		EClass BASIC_FUNCTION = eINSTANCE.getBasicFunction();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_FUNCTION__VALUES = eINSTANCE.getBasicFunction_Values();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Function
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.ValuePairImpl <em>Value Pair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.ValuePairImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getValuePair()
		 * @generated
		 */
		EClass VALUE_PAIR = eINSTANCE.getValuePair();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_PAIR__KEY = eINSTANCE.getValuePair_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_PAIR__VALUE = eINSTANCE.getValuePair_Value();

		/**
		 * The meta object literal for the '<em><b>Identifier Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_PAIR__IDENTIFIER_VALUE = eINSTANCE.getValuePair_IdentifierValue();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FiniteUnionFunctionImpl <em>Finite Union Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FiniteUnionFunctionImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getFiniteUnionFunction()
		 * @generated
		 */
		EClass FINITE_UNION_FUNCTION = eINSTANCE.getFiniteUnionFunction();

		/**
		 * The meta object literal for the '<em><b>Base Func</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINITE_UNION_FUNCTION__BASE_FUNC = eINSTANCE.getFiniteUnionFunction_BaseFunc();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaFunctionImpl <em>Delta Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaFunctionImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getDeltaFunction()
		 * @generated
		 */
		EClass DELTA_FUNCTION = eINSTANCE.getDeltaFunction();

		/**
		 * The meta object literal for the '<em><b>Wrapped</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_FUNCTION__WRAPPED = eINSTANCE.getDeltaFunction_Wrapped();

		/**
		 * The meta object literal for the '<em><b>Deltastore</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_FUNCTION__DELTASTORE = eINSTANCE.getDeltaFunction_Deltastore();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.StoredFuncsImpl <em>Stored Funcs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.StoredFuncsImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getStoredFuncs()
		 * @generated
		 */
		EClass STORED_FUNCS = eINSTANCE.getStoredFuncs();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORED_FUNCS__IDENTIFIER = eINSTANCE.getStoredFuncs_Identifier();

		/**
		 * The meta object literal for the '<em><b>Featurefunc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORED_FUNCS__FEATUREFUNC = eINSTANCE.getStoredFuncs_Featurefunc();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl <em>Feature Func</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.FeatureFuncImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getFeatureFunc()
		 * @generated
		 */
		EClass FEATURE_FUNC = eINSTANCE.getFeatureFunc();

		/**
		 * The meta object literal for the '<em><b>Deltastore</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_FUNC__DELTASTORE = eINSTANCE.getFeatureFunc_Deltastore();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_FUNC__NAME = eINSTANCE.getFeatureFunc_Name();

		/**
		 * The meta object literal for the '<em><b>Classref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_FUNC__CLASSREF = eINSTANCE.getFeatureFunc_Classref();

		/**
		 * The meta object literal for the '<em><b>Nsref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_FUNC__NSREF = eINSTANCE.getFeatureFunc_Nsref();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaStoreImpl <em>Delta Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.DeltaStoreImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getDeltaStore()
		 * @generated
		 */
		EClass DELTA_STORE = eINSTANCE.getDeltaStore();

		/**
		 * The meta object literal for the '<em><b>Add Map</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_STORE__ADD_MAP = eINSTANCE.getDeltaStore_AddMap();

		/**
		 * The meta object literal for the '<em><b>Filter Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA_STORE__FILTER_SCOPE = eINSTANCE.getDeltaStore_FilterScope();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CompleteFileImpl <em>Complete File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.CompleteFileImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getCompleteFile()
		 * @generated
		 */
		EClass COMPLETE_FILE = eINSTANCE.getCompleteFile();

		/**
		 * The meta object literal for the '<em><b>Virt Models</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETE_FILE__VIRT_MODELS = eINSTANCE.getCompleteFile_VirtModels();

		/**
		 * The meta object literal for the '<em><b>Input Models</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETE_FILE__INPUT_MODELS = eINSTANCE.getCompleteFile_InputModels();

		/**
		 * The meta object literal for the '<em><b>Deltamodel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_FILE__DELTAMODEL = eINSTANCE.getCompleteFile_Deltamodel();

		/**
		 * The meta object literal for the '<em><b>Last Model Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETE_FILE__LAST_MODEL_TEXT = eINSTANCE.getCompleteFile_LastModelText();

		/**
		 * The meta object literal for the '<em><b>Current Model Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETE_FILE__CURRENT_MODEL_TEXT = eINSTANCE.getCompleteFile_CurrentModelText();

		/**
		 * The meta object literal for the '<em><b>Xtextlanguage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_FILE__XTEXTLANGUAGE = eINSTANCE.getCompleteFile_Xtextlanguage();

		/**
		 * The meta object literal for the '<em><b>Ecoredef</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_FILE__ECOREDEF = eINSTANCE.getCompleteFile_Ecoredef();

		/**
		 * The meta object literal for the '<em><b>Root Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETE_FILE__ROOT_OBJECTS = eINSTANCE.getCompleteFile_RootObjects();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.LanguageDefImpl <em>Language Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.LanguageDefImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getLanguageDef()
		 * @generated
		 */
		EClass LANGUAGE_DEF = eINSTANCE.getLanguageDef();

		/**
		 * The meta object literal for the '<em><b>Lang Standalone Setup</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_DEF__LANG_STANDALONE_SETUP = eINSTANCE.getLanguageDef_LangStandaloneSetup();

		/**
		 * The meta object literal for the '{@link at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.EcoreDefImpl <em>Ecore Def</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.EcoreDefImpl
		 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjectModelPackageImpl#getEcoreDef()
		 * @generated
		 */
		EClass ECORE_DEF = eINSTANCE.getEcoreDef();

		/**
		 * The meta object literal for the '<em><b>Factory Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_DEF__FACTORY_PACKAGE = eINSTANCE.getEcoreDef_FactoryPackage();

		/**
		 * The meta object literal for the '<em><b>Package Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECORE_DEF__PACKAGE_PACKAGE = eINSTANCE.getEcoreDef_PackagePackage();

	}

} //VObjectModelPackage

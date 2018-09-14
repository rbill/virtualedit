/**
 */
package VObjectModel;

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
 * @see VObjectModel.VObjectModelFactory
 * @model kind="package"
 * @generated
 */
public interface VObjectModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "VObjectModel";

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
	String eNS_PREFIX = "VObjectModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VObjectModelPackage eINSTANCE = VObjectModel.impl.VObjectModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link VObjectModel.impl.IdentifierImpl <em>Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see VObjectModel.impl.IdentifierImpl
	 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifier()
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
	 * The feature id for the '<em><b>Creatorid</b></em>' reference.
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
	 * The meta object id for the '{@link VObjectModel.impl.AnyValueImpl <em>Any Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see VObjectModel.impl.AnyValueImpl
	 * @see VObjectModel.impl.VObjectModelPackageImpl#getAnyValue()
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
	 * The meta object id for the '{@link VObjectModel.impl.IdentifierRefOrCmpImpl <em>Identifier Ref Or Cmp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see VObjectModel.impl.IdentifierRefOrCmpImpl
	 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifierRefOrCmp()
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
	 * The meta object id for the '{@link VObjectModel.impl.IdentifierRefImpl <em>Identifier Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see VObjectModel.impl.IdentifierRefImpl
	 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifierRef()
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
	 * The feature id for the '<em><b>Sidentifier</b></em>' containment reference.
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
	 * The meta object id for the '{@link VObjectModel.impl.IdentifierCmpImpl <em>Identifier Cmp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see VObjectModel.impl.IdentifierCmpImpl
	 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifierCmp()
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
	 * The feature id for the '<em><b>Sidentifier</b></em>' reference.
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
	 * The meta object id for the '{@link VObjectModel.impl.CreatorIdImpl <em>Creator Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see VObjectModel.impl.CreatorIdImpl
	 * @see VObjectModel.impl.VObjectModelPackageImpl#getCreatorId()
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
	 * The meta object id for the '{@link VObjectModel.impl.JavaValueImpl <em>Java Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see VObjectModel.impl.JavaValueImpl
	 * @see VObjectModel.impl.VObjectModelPackageImpl#getJavaValue()
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
	 * Returns the meta object for class '{@link VObjectModel.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier</em>'.
	 * @see VObjectModel.Identifier
	 * @generated
	 */
	EClass getIdentifier();

	/**
	 * Returns the meta object for the containment reference list '{@link VObjectModel.Identifier#getIdentifierreforcmp <em>Identifierreforcmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Identifierreforcmp</em>'.
	 * @see VObjectModel.Identifier#getIdentifierreforcmp()
	 * @see #getIdentifier()
	 * @generated
	 */
	EReference getIdentifier_Identifierreforcmp();

	/**
	 * Returns the meta object for the attribute '{@link VObjectModel.Identifier#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see VObjectModel.Identifier#getName()
	 * @see #getIdentifier()
	 * @generated
	 */
	EAttribute getIdentifier_Name();

	/**
	 * Returns the meta object for the reference '{@link VObjectModel.Identifier#getCreatorid <em>Creatorid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Creatorid</em>'.
	 * @see VObjectModel.Identifier#getCreatorid()
	 * @see #getIdentifier()
	 * @generated
	 */
	EReference getIdentifier_Creatorid();

	/**
	 * Returns the meta object for the attribute '{@link VObjectModel.Identifier#getHc <em>Hc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hc</em>'.
	 * @see VObjectModel.Identifier#getHc()
	 * @see #getIdentifier()
	 * @generated
	 */
	EAttribute getIdentifier_Hc();

	/**
	 * Returns the meta object for the '{@link VObjectModel.Identifier#hashCode() <em>Hash Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Hash Code</em>' operation.
	 * @see VObjectModel.Identifier#hashCode()
	 * @generated
	 */
	EOperation getIdentifier__HashCode();

	/**
	 * Returns the meta object for the '{@link VObjectModel.Identifier#equals(VObjectModel.Identifier) <em>Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equals</em>' operation.
	 * @see VObjectModel.Identifier#equals(VObjectModel.Identifier)
	 * @generated
	 */
	EOperation getIdentifier__Equals__Identifier();

	/**
	 * Returns the meta object for the '{@link VObjectModel.Identifier#init() <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see VObjectModel.Identifier#init()
	 * @generated
	 */
	EOperation getIdentifier__Init();

	/**
	 * Returns the meta object for class '{@link VObjectModel.IdentifierRefOrCmp <em>Identifier Ref Or Cmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Ref Or Cmp</em>'.
	 * @see VObjectModel.IdentifierRefOrCmp
	 * @generated
	 */
	EClass getIdentifierRefOrCmp();

	/**
	 * Returns the meta object for the reference '{@link VObjectModel.IdentifierRefOrCmp#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see VObjectModel.IdentifierRefOrCmp#getIdentifier()
	 * @see #getIdentifierRefOrCmp()
	 * @generated
	 */
	EReference getIdentifierRefOrCmp_Identifier();

	/**
	 * Returns the meta object for class '{@link VObjectModel.IdentifierRef <em>Identifier Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Ref</em>'.
	 * @see VObjectModel.IdentifierRef
	 * @generated
	 */
	EClass getIdentifierRef();

	/**
	 * Returns the meta object for the reference '{@link VObjectModel.IdentifierRef#getIdentifierreforcmp <em>Identifierreforcmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifierreforcmp</em>'.
	 * @see VObjectModel.IdentifierRef#getIdentifierreforcmp()
	 * @see #getIdentifierRef()
	 * @generated
	 */
	EReference getIdentifierRef_Identifierreforcmp();

	/**
	 * Returns the meta object for the containment reference '{@link VObjectModel.IdentifierRef#getS_identifier <em>Sidentifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sidentifier</em>'.
	 * @see VObjectModel.IdentifierRef#getS_identifier()
	 * @see #getIdentifierRef()
	 * @generated
	 */
	EReference getIdentifierRef_S_identifier();

	/**
	 * Returns the meta object for class '{@link VObjectModel.IdentifierCmp <em>Identifier Cmp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Cmp</em>'.
	 * @see VObjectModel.IdentifierCmp
	 * @generated
	 */
	EClass getIdentifierCmp();

	/**
	 * Returns the meta object for the reference '{@link VObjectModel.IdentifierCmp#getS_identifier <em>Sidentifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sidentifier</em>'.
	 * @see VObjectModel.IdentifierCmp#getS_identifier()
	 * @see #getIdentifierCmp()
	 * @generated
	 */
	EReference getIdentifierCmp_S_identifier();

	/**
	 * Returns the meta object for class '{@link VObjectModel.CreatorId <em>Creator Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Creator Id</em>'.
	 * @see VObjectModel.CreatorId
	 * @generated
	 */
	EClass getCreatorId();

	/**
	 * Returns the meta object for the attribute '{@link VObjectModel.CreatorId#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see VObjectModel.CreatorId#getNamespace()
	 * @see #getCreatorId()
	 * @generated
	 */
	EAttribute getCreatorId_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link VObjectModel.CreatorId#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see VObjectModel.CreatorId#getName()
	 * @see #getCreatorId()
	 * @generated
	 */
	EAttribute getCreatorId_Name();

	/**
	 * Returns the meta object for class '{@link VObjectModel.AnyValue <em>Any Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Value</em>'.
	 * @see VObjectModel.AnyValue
	 * @generated
	 */
	EClass getAnyValue();

	/**
	 * Returns the meta object for class '{@link VObjectModel.JavaValue <em>Java Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Value</em>'.
	 * @see VObjectModel.JavaValue
	 * @generated
	 */
	EClass getJavaValue();

	/**
	 * Returns the meta object for the attribute '{@link VObjectModel.JavaValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see VObjectModel.JavaValue#getValue()
	 * @see #getJavaValue()
	 * @generated
	 */
	EAttribute getJavaValue_Value();

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
		 * The meta object literal for the '{@link VObjectModel.impl.IdentifierImpl <em>Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see VObjectModel.impl.IdentifierImpl
		 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifier()
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
		 * The meta object literal for the '<em><b>Creatorid</b></em>' reference feature.
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
		 * The meta object literal for the '{@link VObjectModel.impl.IdentifierRefOrCmpImpl <em>Identifier Ref Or Cmp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see VObjectModel.impl.IdentifierRefOrCmpImpl
		 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifierRefOrCmp()
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
		 * The meta object literal for the '{@link VObjectModel.impl.IdentifierRefImpl <em>Identifier Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see VObjectModel.impl.IdentifierRefImpl
		 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifierRef()
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
		 * The meta object literal for the '<em><b>Sidentifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_REF__SIDENTIFIER = eINSTANCE.getIdentifierRef_S_identifier();

		/**
		 * The meta object literal for the '{@link VObjectModel.impl.IdentifierCmpImpl <em>Identifier Cmp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see VObjectModel.impl.IdentifierCmpImpl
		 * @see VObjectModel.impl.VObjectModelPackageImpl#getIdentifierCmp()
		 * @generated
		 */
		EClass IDENTIFIER_CMP = eINSTANCE.getIdentifierCmp();

		/**
		 * The meta object literal for the '<em><b>Sidentifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFIER_CMP__SIDENTIFIER = eINSTANCE.getIdentifierCmp_S_identifier();

		/**
		 * The meta object literal for the '{@link VObjectModel.impl.CreatorIdImpl <em>Creator Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see VObjectModel.impl.CreatorIdImpl
		 * @see VObjectModel.impl.VObjectModelPackageImpl#getCreatorId()
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
		 * The meta object literal for the '{@link VObjectModel.impl.AnyValueImpl <em>Any Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see VObjectModel.impl.AnyValueImpl
		 * @see VObjectModel.impl.VObjectModelPackageImpl#getAnyValue()
		 * @generated
		 */
		EClass ANY_VALUE = eINSTANCE.getAnyValue();

		/**
		 * The meta object literal for the '{@link VObjectModel.impl.JavaValueImpl <em>Java Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see VObjectModel.impl.JavaValueImpl
		 * @see VObjectModel.impl.VObjectModelPackageImpl#getJavaValue()
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

	}

} //VObjectModelPackage

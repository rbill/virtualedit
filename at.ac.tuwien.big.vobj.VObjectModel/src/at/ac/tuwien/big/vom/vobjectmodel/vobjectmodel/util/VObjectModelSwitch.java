/**
 */
package at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.util;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage
 * @generated
 */
public class VObjectModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VObjectModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VObjectModelSwitch() {
		if (modelPackage == null) {
			modelPackage = VObjectModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case VObjectModelPackage.IDENTIFIER: {
				Identifier identifier = (Identifier)theEObject;
				T result = caseIdentifier(identifier);
				if (result == null) result = caseAnyRoot(identifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.IDENTIFIER_PARAM: {
				IdentifierParam identifierParam = (IdentifierParam)theEObject;
				T result = caseIdentifierParam(identifierParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.IDENTIFIER_REF_OR_CMP: {
				IdentifierRefOrCmp identifierRefOrCmp = (IdentifierRefOrCmp)theEObject;
				T result = caseIdentifierRefOrCmp(identifierRefOrCmp);
				if (result == null) result = caseAnyValue(identifierRefOrCmp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.IDENTIFIER_REF: {
				IdentifierRef identifierRef = (IdentifierRef)theEObject;
				T result = caseIdentifierRef(identifierRef);
				if (result == null) result = caseIdentifierRefOrCmp(identifierRef);
				if (result == null) result = caseAnyValue(identifierRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.IDENTIFIER_CMP: {
				IdentifierCmp identifierCmp = (IdentifierCmp)theEObject;
				T result = caseIdentifierCmp(identifierCmp);
				if (result == null) result = caseIdentifierRefOrCmp(identifierCmp);
				if (result == null) result = caseAnyValue(identifierCmp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.CREATOR_ID: {
				CreatorId creatorId = (CreatorId)theEObject;
				T result = caseCreatorId(creatorId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.ANY_VALUE: {
				AnyValue anyValue = (AnyValue)theEObject;
				T result = caseAnyValue(anyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.JAVA_VALUE: {
				JavaValue javaValue = (JavaValue)theEObject;
				T result = caseJavaValue(javaValue);
				if (result == null) result = caseAnyValue(javaValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.VOBJ_DELTA_MODEL: {
				VObjDeltaModel vObjDeltaModel = (VObjDeltaModel)theEObject;
				T result = caseVObjDeltaModel(vObjDeltaModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.BASIC_FUNCTION: {
				BasicFunction basicFunction = (BasicFunction)theEObject;
				T result = caseBasicFunction(basicFunction);
				if (result == null) result = caseFunction(basicFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.VALUE_PAIR: {
				ValuePair valuePair = (ValuePair)theEObject;
				T result = caseValuePair(valuePair);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.FINITE_UNION_FUNCTION: {
				FiniteUnionFunction finiteUnionFunction = (FiniteUnionFunction)theEObject;
				T result = caseFiniteUnionFunction(finiteUnionFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.DELTA_FUNCTION: {
				DeltaFunction deltaFunction = (DeltaFunction)theEObject;
				T result = caseDeltaFunction(deltaFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.STORED_FUNCS: {
				StoredFuncs storedFuncs = (StoredFuncs)theEObject;
				T result = caseStoredFuncs(storedFuncs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.FEATURE_FUNC: {
				FeatureFunc featureFunc = (FeatureFunc)theEObject;
				T result = caseFeatureFunc(featureFunc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.DELTA_STORE: {
				DeltaStore deltaStore = (DeltaStore)theEObject;
				T result = caseDeltaStore(deltaStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.COMPLETE_FILE: {
				CompleteFile completeFile = (CompleteFile)theEObject;
				T result = caseCompleteFile(completeFile);
				if (result == null) result = caseAnyRoot(completeFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.LANGUAGE_DEF: {
				LanguageDef languageDef = (LanguageDef)theEObject;
				T result = caseLanguageDef(languageDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.ECORE_DEF: {
				EcoreDef ecoreDef = (EcoreDef)theEObject;
				T result = caseEcoreDef(ecoreDef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VObjectModelPackage.ANY_ROOT: {
				AnyRoot anyRoot = (AnyRoot)theEObject;
				T result = caseAnyRoot(anyRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierParam(IdentifierParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier Ref Or Cmp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier Ref Or Cmp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierRefOrCmp(IdentifierRefOrCmp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierRef(IdentifierRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier Cmp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier Cmp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierCmp(IdentifierCmp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Creator Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Creator Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreatorId(CreatorId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyValue(AnyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaValue(JavaValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VObj Delta Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VObj Delta Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVObjDeltaModel(VObjDeltaModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicFunction(BasicFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunction(Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Pair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValuePair(ValuePair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Finite Union Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Finite Union Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFiniteUnionFunction(FiniteUnionFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delta Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delta Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeltaFunction(DeltaFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stored Funcs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stored Funcs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoredFuncs(StoredFuncs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Func</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Func</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureFunc(FeatureFunc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delta Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delta Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeltaStore(DeltaStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteFile(CompleteFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageDef(LanguageDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecore Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecore Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcoreDef(EcoreDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyRoot(AnyRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //VObjectModelSwitch

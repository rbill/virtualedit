package at.ac.tuwien.big.vmodel.deltageneration.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vmodel.ecore.VEObject;
import at.ac.tuwien.big.vmodel.ecore.VModelView;

public class AddGettersAndSetters extends CachingEObjectModification {
	
	private EObject cloneBasicOnlyMultiplicity1(String myId, EObject attrType, VModelView deltaModel, int type, int index) {
		EObject typeClone = createObject(myId, attrType.eClass(), type, index, deltaModel);
		for (EStructuralFeature esf: attrType.eClass().getEAllStructuralFeatures()) {
			typeClone.eSet(esf, attrType.eGet(esf));
		}
		return typeClone;
	}

	@Override
	public void modify(String uuid, EObject eobj, VModelView baseModel, VModelView editModel, VModelView deltaModel) {
		//only on Attributes 
		EStructuralFeature attributes = eobj.eClass().getEStructuralFeature("attribute");
		if (!(attributes instanceof EReference)) {
			System.err.println("Trying to add getters and setters on class without attributes ("+eobj+")!");
			return;
		}
		EStructuralFeature methods = eobj.eClass().getEStructuralFeature("method");
		if (!(methods instanceof EReference)) {
			System.err.println("Trying to add getters and setters on class without methods ("+eobj+")!");
			return;
		}  
		//Look for existing methods
		Map<String,EObject> existingMethods = new HashMap<>();
		EClass methodClass = deltaModel.getEcore().getClass("Method");

		EStructuralFeature methodContent = methodClass.getEStructuralFeature("content");
		EStructuralFeature methodTypeAttr = methodClass.getEStructuralFeature("returnType");
		EStructuralFeature methodParameterAttr = methodClass.getEStructuralFeature("parameter");
		EStructuralFeature methodNameAttr = methodClass.getEStructuralFeature("name");
		{
			
			for (EObject seobj: ((Collection<EObject>)eobj.eGet(methods))) {
				String name = (String)seobj.eGet(methodNameAttr);
				existingMethods.put(name, seobj);
			}
		}
		EClass methodBlockClass = deltaModel.getEcore().getClass("MethodBlock");
		EClass parameterClass = deltaModel.getEcore().getClass("Parameter");
		EClass typeClass = deltaModel.getEcore().getClass("Type");
		EStructuralFeature typeNameAttr = typeClass.getEStructuralFeature("typeName");
		EStructuralFeature typeRefAttr = typeClass.getEStructuralFeature("typeRef"); 
		
		Collection<EObject> curAttributes = (Collection)eobj.eGet(attributes);
		Collection<EObject> curMethods = (Collection)eobj.eGet(methods);
		EStructuralFeature nameAttr = null;
		EStructuralFeature attrTypeAttr = null;
		for (EObject attr: curAttributes) {
			EClass cl = attr.eClass();
			//Check if getter and Setter
			if (nameAttr == null) {
				nameAttr = cl.getEStructuralFeature("name");
			}
			if (attrTypeAttr == null) {
				attrTypeAttr = cl.getEStructuralFeature("type");
			}
			String name = (String)attr.eGet(nameAttr);
			if (name != null && !name.trim().isEmpty()) {
				//Check if methods are there
				String baseName = Character.toUpperCase(name.charAt(0))+name.substring(1);
				String getName = "get"+baseName;
				String setName = "set"+baseName;
				
				EObject attrType = (EObject)attr.eGet(attrTypeAttr);
				
				String myId = (attr instanceof VEObject)?((VEObject)attr).getUUID():(uuid+"-"+name);
				
				EObject getMethod = existingMethods.get(getName);
				if (getMethod == null) {
					//Create getMethod
					getMethod = createObject(myId, methodClass, 0, 0, deltaModel);
					getMethod.eSet(methodNameAttr, getName);
					//Return type must be equal to attrType
					getMethod.eSet(methodTypeAttr, cloneBasicOnlyMultiplicity1(myId,attrType,deltaModel,0,2));
					//Let's leave it like that for now ...
					curMethods.add(getMethod);
					EObject methodBody = createObject(myId, methodBlockClass, 0, 1, deltaModel);
					System.out.println("Created get method body "+((VEObject)methodBody).getUUID());
					getMethod.eSet(methodContent,methodBody);
				}
				EObject setMethod = existingMethods.get(setName);
				if (setMethod == null) {
					//Create setMethod
					setMethod = createObject(myId, methodClass, 1, 0, deltaModel);
					setMethod.eSet(methodNameAttr, setName);
					//You need a parameter for that
					EObject setParameter = createObject(myId, parameterClass, 1, 1, deltaModel);
					((Collection)setMethod.eGet(methodParameterAttr)).add(setParameter);
					//The parameter has the type return type
					setParameter.eSet(nameAttr, "newVal");
					
					setParameter.eSet(attrTypeAttr, cloneBasicOnlyMultiplicity1(myId,attrType,deltaModel,1,3));
					System.out.println("AttrType: "+attrType+", get: "+setParameter.eGet(attrTypeAttr));
					curMethods.add(setMethod);
					EObject methodBody = createObject(myId, methodBlockClass, 1, 2, deltaModel);
					System.out.println("Created set method body "+((VEObject)methodBody).getUUID());
					setMethod.eSet(methodContent,methodBody);
				}
			}
		}
		
	}

}

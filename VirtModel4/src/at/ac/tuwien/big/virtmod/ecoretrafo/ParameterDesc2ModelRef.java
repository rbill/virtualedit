package at.ac.tuwien.big.virtmod.ecoretrafo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.pivot.values.OrderedSet;
import org.sat4j.tools.AllMUSes;

import at.ac.tuwien.big.autoedit.test.OclExtractor;
import at.ac.tuwien.big.verocl.ParameterDesc;
import at.ac.tuwien.big.verocl.SimpleParameterValue;
import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.SingleParameterDesc;
import at.ac.tuwien.big.virtmod.multiref.ModelRef;
import parameterdesc.Parameter;
import parameterdesc.ParameterType;

public class ParameterDesc2ModelRef {
	
	public static EAttribute addSimpleAttribute(EClass toClass, String name, EDataType type) {
		return addSimpleAttribute(toClass,name,type,false);
	}
	
	public static EReference addSimpleReference(EClass fromClass, EClass toClass, String name) {
		return addSimpleReference(fromClass, toClass,name,-1);
	}
	
	public static EReference addSimpleReference(EClass fromClass, EClass toClass, String name, int bound) {
		return addSimpleReference(fromClass, toClass, name, bound==-1?0:bound, bound);
	}
	
	public static EReference addSimpleReference(EClass fromClass, EClass toClass, String name, int lowerBound, int upperBound) {
		EcoreFactory fact = EcoreFactory.eINSTANCE;
		EReference ret = fact.createEReference();
		ret.setName(name);
		ret.setEType(toClass);
		ret.setLowerBound(lowerBound);
		ret.setUpperBound(upperBound);
		fromClass.getEStructuralFeatures().add(ret);
		return ret;
	}
	
	public static enum ReferenceType {
		OneToOne(1,1,1,1), OneToZeroOne(1,1,0,1), ZeroOneToOne(0,1,1,1), OneToN(1,1,0,-1), ZeroOneToN(0,1,0,-1), NToN(0,-1,0,-1), NToOne(0,-1,1,1), NToZeroOne(0,-1,0,1);
		public final int lowerFromTo;
		public final int upperFromTo;
		public final int lowerToFrom;
		public final int upperToFrom;
		
		private ReferenceType(int lft, int uft, int ltf, int utf) {
			this.lowerFromTo = lft;
			this.upperFromTo = uft;
			this.lowerToFrom = ltf;
			this.upperToFrom = utf;
		}
	}
	
	public static EReference addDualReference(EClass fromClass, EClass toClass, String fromToName, String toFromName, int lowerBoundFromTo, int upperBoundFromTo, int lowerBoundToFrom, int upperBoundToFrom) {
		EReference ret = addSimpleReference(fromClass, toClass, fromToName, lowerBoundFromTo, upperBoundFromTo);
		EReference opposite = addSimpleReference(toClass, fromClass, toFromName, lowerBoundToFrom, upperBoundToFrom);
		ret.setEOpposite(opposite);
		return ret;
	}
	
	public static EReference addDualReference(EClass fromClass, EClass toClass, String fromToName, String toFromName, ReferenceType type) {
		return addDualReference(fromClass, toClass, fromToName, toFromName, type.lowerFromTo, type.upperFromTo, type.lowerToFrom, type.upperToFrom);
	}
	
	public static EAttribute addSimpleAttribute(EClass toClass, String name, EDataType type, boolean isOptional) {
		EcoreFactory fact = EcoreFactory.eINSTANCE;
		EAttribute attr = fact.createEAttribute();
		attr.setName(name);
		attr.setEType(type);
		attr.setUpperBound(1);
		toClass.getEStructuralFeatures().add(attr);
		if (isOptional) {
			attr.setLowerBound(0);
		} else {
			attr.setLowerBound(1);
		}
		return attr;
	}
	
	private Map<String,Enumerator> storedParameters = new HashMap<>();
	
	private void addParameterAttribute(EClass toClass, EObject eobj) {
		String name = (String)eobj.eGet(eobj.eClass().getEStructuralFeature("name"));
		Object type = eobj.eGet(eobj.eClass().getEStructuralFeature("type"));
		if (type instanceof Enumerator) {
			Enumerator enu = (Enumerator)type;
			addParameterAttribute(toClass, name,enu);
		}
	}
	
	private void addParameterAttribute(EClass toClass, String name, Enumerator enu) {
		
		storedParameters.put(name, enu);
		if ("INTEGER".equals(enu.getLiteral())) {
			addSimpleAttribute(toClass, name, EcorePackage.eINSTANCE.getEBigInteger());
		} else {
			throw new UnsupportedOperationException("I don't support" + enu.getLiteral());
		}
	}
	
	public Resource transform(Resource parameterDesc, URI targetUri) {
		EcoreFactory fact = EcoreFactory.eINSTANCE;
		EClass modelRef = fact.createEClass();
		modelRef.setName("ModelRef");
		addDualReference(modelRef, modelRef, "next","previous",ReferenceType.NToN);
		EDataType eString = EcorePackage.eINSTANCE.getEString();
		addSimpleAttribute(modelRef, "uri", eString);
		EClass parameterDescCl = fact.createEClass();
		parameterDescCl.setName("ParameterDesc");
		addDualReference(modelRef, parameterDescCl, "parameter", "model", ReferenceType.OneToOne);
		for (EObject eobj: (Iterable<EObject>)()->parameterDesc.getAllContents()) {
			if ("Parameter".equals(eobj.eClass().getName())) {
				addParameterAttribute(parameterDescCl,eobj);
			}
		}
		Resource ret = parameterDesc.getResourceSet().createResource(targetUri);
		EPackage epkg = fact.createEPackage();
		epkg.setName("modelref");
		epkg.setNsURI(targetUri.toString());
		epkg.setNsPrefix("modelref");
		List<EClassifier> classifiers = epkg.getEClassifiers();
		classifiers.add(modelRef);
		classifiers.add(parameterDescCl);
		ret.getContents().add(epkg);
		return ret;
	}	
			
	
	public static EClass createEClass(String name, EClass... superType) {
		EClass ret = EcoreFactory.eINSTANCE.createEClass();
		ret.setName(name);
		for (EClass supType: superType) {
			ret.getESuperTypes().add(supType);
		}
		return ret;
	}
	
	public EOperation createOperation(EClass forClass, String name, EClassifier returnType) {
		return createOperation(forClass, name, returnType, false);
	}
	
	public EOperation createOperation(EClass forClass, String name, EStructuralFeature feature) {
		EcoreFactory fact = EcoreFactory.eINSTANCE;
		EOperation ret = fact.createEOperation();
		ret.setName(name);
		ret.setEType(feature.getEType());
		ret.setLowerBound(feature.getLowerBound());
		ret.setUpperBound(feature.getUpperBound());
		forClass.getEOperations().add(ret);
		return ret;
	}
	
	public EOperation createOperation(EClass forClass, String name, EClassifier returnType, boolean returnList) {
		EcoreFactory fact = EcoreFactory.eINSTANCE;
		EOperation ret = fact.createEOperation();
		ret.setName(name);
		ret.setEType(returnType);
		if (returnList) {
			ret.setUpperBound(-1);
			ret.setLowerBound(0);
		} else {
			ret.setUpperBound(1);
			ret.setLowerBound(1);
		}
		forClass.getEOperations().add(ret);
		return ret;
	}
	
	public SingleParameterDesc getParameterDesc(String name, Enumerator enu) {
		Class<?> typeCl = null;
		if ("INTEGER".equals(enu.getLiteral())) {
			typeCl = Integer.class;
		}
		return new SingleParameterDesc(name, typeCl);
	}
	
	public SingleParameterDesc getParameterDesc(EObject eobj) {
		String name = (String)eobj.eGet(eobj.eClass().getEStructuralFeature("name"));
		Object type = eobj.eGet(eobj.eClass().getEStructuralFeature("type"));
		if (type instanceof Enumerator) {
			Enumerator enu = (Enumerator)type;
			return getParameterDesc(name, enu);
		}
		return null;
	}
	
	
	public EParameter addParameter(EOperation op, String name, EClassifier type) {
		return addParameter(op, name, type, false);
	}
	
	public EParameter addParameter(EOperation op, String name, EClassifier type, boolean isList) {
		EParameter par = EcoreFactory.eINSTANCE.createEParameter();
		par.setName(name);
		par.setEType(type);
		if (isList) {
			par.setUpperBound(-1);
			par.setLowerBound(0);
		} else {
			par.setUpperBound(1);
			par.setLowerBound(1);
		}
		op.getEParameters().add(par);
		return par;
	}
	
	public Set<EClass> getTopClasses(Set<? extends EClassifier> allClassifiers) {
		Set<EClass> allClasses = new HashSet<EClass>();
		for (EClassifier cl: allClassifiers) {
			if (cl instanceof EClass) {
				allClasses.add((EClass)cl);
			}
		}
		Set<EClass> noTop = new HashSet<EClass>();
		for (EClass cl: allClasses) {
			if (cl.getESuperTypes().isEmpty()) {
				noTop.add(cl);
			}
		}
		return noTop;
	}
	
	public EDataType getDataType(Class<?> cl) {
		if (cl == Integer.class) {
			return EcorePackage.eINSTANCE.getEBigInteger();
		} else {
			throw new RuntimeException("Unknown class " + cl);
		}
	}
	
	
	/**Macht aus dem Ecore ein parametrisiertes*/
	public void adaptEcoreModel(Resource baseEcore) {
		//1. Schaue mal, welche Classifiers alle vorkommen
		Set<EClassifier> occurringClassifiers = new HashSet<>();
		Set<EClass> allClasses = new HashSet<>();
		EPackage mainPkg = null;
		for (EObject eobj: (Iterable<EObject>)()->baseEcore.getAllContents()) {
			if (eobj instanceof EClass) {
				EClass cl = (EClass)eobj;
				allClasses.add(cl);
				for (EStructuralFeature feat: cl.getEStructuralFeatures()) {
					occurringClassifiers.add(feat.getEType());
				}
				occurringClassifiers.add(cl);
			}
			if (mainPkg == null && eobj instanceof EPackage) {
				mainPkg = (EPackage)eobj;
			}
		}
		//2. Jetzt baue die Hierarchie von SMParam/SMParamType
		EClass smParam = createEClass("SMParam");
		Map<String,Enumerator> orderedStrings = new TreeMap<>();
		orderedStrings.putAll(storedParameters);;
		for (Entry<String,Enumerator> entry: orderedStrings.entrySet()) {
			addParameterAttribute(smParam, entry.getKey(), entry.getValue());
		}
		Map<EClassifier,EClass[]> smParamForClassifier = new HashMap<EClassifier, EClass[]>();
		if (mainPkg != null) {
			mainPkg.getEClassifiers().add(smParam);
		} else {
			baseEcore.getContents().add(smParam);
		}
		for (EClassifier cl: occurringClassifiers) {
			EClass[] cls = new EClass[2];
			smParamForClassifier.put(cl, cls);
			{
				EClass smParamCustom = cls[0] = createEClass("SMParamSingle_"+cl.getName(), smParam);
				if (mainPkg != null) {
					mainPkg.getEClassifiers().add(smParamCustom);
				} else {
					baseEcore.getContents().add(smParamCustom);
				}
				if (cl instanceof EDataType) {
					addSimpleAttribute(smParamCustom, "value", (EDataType)cl);
				} else if (cl instanceof EClass) {
					addSimpleReference(smParamCustom, (EClass)cl, "value", 0, 1);
				} else {
					throw new RuntimeException("Cannot add structural feature of type " + cl);
				}
			}
			{
				EClass smParamCustom = cls[1] = createEClass("SMParamMulti_"+cl.getName(), smParam);
				if (mainPkg != null) {
					mainPkg.getEClassifiers().add(smParamCustom);
				} else {
					baseEcore.getContents().add(smParamCustom);
				}
				if (cl instanceof EDataType) {
					addSimpleAttribute(smParamCustom, "value", (EDataType)cl, true);
				} else if (cl instanceof EClass) {
					addSimpleReference(smParamCustom, (EClass)cl, "value", 0, -1);
				} else {
					throw new RuntimeException("Cannot add structural feature of type " + cl);
				}
			}
		}
		
		//Add operations
		EcoreFactory fact = EcoreFactory.eINSTANCE;
		Set<EClass> topClasses = getTopClasses(allClasses);
		for (EClass topClass: topClasses) {
			//Create tuple
			{
				EOperation createTuple = createOperation(topClass, "createParameter", smParam);
				for (Entry<String,Enumerator> entry: orderedStrings.entrySet()) {
					SingleParameterDesc dsc = getParameterDesc(entry.getKey(), entry.getValue());
					addParameter(createTuple, dsc.getName(), getDataType(dsc.getType()));
				}
			}
		}
		
		//Jede Klasse hat eine Projektions-Operation
		for (EClass cl: allClasses) {
			//Simple projection
			EOperation baseProject = createOperation(cl, "project", cl);
			addParameter(baseProject, "pars", smParam, true);
			//Projection per feature
			for (EStructuralFeature feat: cl.getEStructuralFeatures()) {
				EOperation featureProject = createOperation(cl, "project_"+feat.getName(), feat);
				addParameter(featureProject, "pars", smParam, true);
			}
			
			//Explosion
			EClass[] retPar = smParamForClassifier.get(cl);
			EOperation explodeOperation = createOperation(cl, "explode", retPar[0], true); //Hier möchte ich ja, dass innen nur eines ist
			for (EStructuralFeature feat: cl.getEStructuralFeatures()) {
				EClass[] fretPar = smParamForClassifier.get(feat.getEType());
				EOperation explodeFeatOperation = createOperation(cl, "explode_"+feat.getName(), feat.isMany()?fretPar[1]:fretPar[0], true);
				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		//ResourceSet rs = new ResourceSetImpl();
		Resource ecoreRes = OclExtractor.getEcore("C:\\Users\\Robert\\Documents\\eclipseMars\\eclipseEcore2ASP\\workspaceVirt\\at.ac.tuwien.big.parameterdesc\\model\\parameterdesc.ecore");
		
		Resource res = OclExtractor.getXMI("testmodel/parameterdesc.xmi", ecoreRes);
		ParameterDesc2ModelRef mr = new ParameterDesc2ModelRef();
		Resource trg = mr.transform(res, URI.createFileURI("testmodel/modelref.xmi"));
		try {
			trg.save(new HashMap<>());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Resource test = OclExtractor.getEcore("model/router.ecore");
		mr.adaptEcoreModel(test);
		try {
			test.save(new FileOutputStream("testmodel/router_modified.ecore"), new HashMap<>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.tools.ToolProvider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.joor.Reflect;

import VObjectModel.VObjectModelFactory;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.ConstantValue;
import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.ecore.ObjectCreatorCreator;
import at.ac.tuwien.big.virtlang.virtLang.ClassRef;
import at.ac.tuwien.big.virtlang.virtLang.Definition;
import at.ac.tuwien.big.virtlang.virtLang.Expression;
import at.ac.tuwien.big.virtlang.virtLang.FeatureAssignment;
import at.ac.tuwien.big.virtlang.virtLang.Fixation;
import at.ac.tuwien.big.virtlang.virtLang.Invariant;
import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;
import at.ac.tuwien.big.virtlang.virtLang.ParameterType;
import at.ac.tuwien.big.virtlang.virtLang.UseModel;
import at.ac.tuwien.big.virtlang.virtLang.VirtLangFactory;
import at.ac.tuwien.big.xmlintelledit.intelledit.scope.BasicEntry;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

//Xtend wäre besser, aber irgendwie geht das nicht ...
public class ObjectCreatorGenerator {
	
	public static File generateRoot;
	
	public static String getClassName(ClassRef ref) {
		return "Sample"+ref.getClassname();
	}
	
	public static String getClassName(EClass cl) {
		ClassRef ref = VirtLangFactory.eINSTANCE.createClassRef();
		EPackage epkg = cl.getEPackage();
		UseModel fakeUseModel = VirtLangFactory.eINSTANCE.createUseModel();
		fakeUseModel.setUrl(epkg.getNsURI());
		fakeUseModel.setName(epkg.getName());
		ref.setNs(fakeUseModel);
		ref.setClassname(cl.getName());
		return getClassName(ref);
	}
	
	public static String getClassName(ObjectCreator creator) {
		return creator.getName()+"_OC";
	}
	
	private static String getExpressionString(Expression expr) {
		return ObjectCreatorCreator.getExprString(expr);
	}
	private EObjectManager emanager;
	
	private CEobjectManager cmanager;
	private int indent = 0;
	
	private ClassGenerationManager cgm;
	
	private Map<Object, Class<? extends SampleEObject>> storedClasses = new HashMap<>();
	
	public ObjectCreatorGenerator(CEobjectManager manager, ClassGenerationManager cgm) {
		this.emanager = manager.getEObjectManager();
		this.cmanager = manager;
		this.cgm = cgm;
	}
	
	public void appendFirstPart(String line, StringBuilder... builders) {
		for (StringBuilder builder: builders) {
			for (int i = 0; i < this.indent; ++i) {
				builder.append("\t");
			}
			builder.append(line);
		}
	}
	
	public void appendLine(String line, StringBuilder... builders) {
		for (StringBuilder builder: builders) {
			for (int i = 0; i < this.indent; ++i) {
				builder.append("\t");
			}
			builder.append(line);
			builder.append("\n");
		}
	}
	
	public void appendLines(StringBuilder builder, String... lines) {
		for (String line: lines) {
			for (int i = 0; i < this.indent; ++i) {
				builder.append("\t");
			}
			builder.append(line);
			builder.append("\n");
		}
	}
	
	public String generate(ClassRef cr) {
		return generate(this.emanager.getEClass(cr));
	}
	
	public String generate(EClass cl) {
		StringBuilder ret = new StringBuilder();
		String myClass = getClassName(cl);
		String myPkg = "constraintClasses";
		appendLines(ret,
				"package "+myPkg+";","",
				"import org.eclipse.emf.ecore.EClass;",
				"import "+EList.class.getName()+";",
				"import "+BasicEList.class.getName()+";",
				"import org.eclipse.emf.ecore.EReference;",
				"import org.eclipse.emf.ecore.EAttribute;",
				"import org.eclipse.emf.ecore.EStructuralFeature;",
				"import "+ConstantValue.class.getName()+ ";",
				"import "+NotifyingList.class.getName()+ ";",
				"import "+PatchUtil.class.getName()+ ";",
				"import "+BasicListenable.class.getName()+ ";",
				"import org.eclipse.emf.ecore.EcoreFactory;",
				"import java.util.List;",
				"import java.util.Collection;",
				"import java.util.Collections;",
				"import java.util.ArrayList;",
				"import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;","",
				"public class "+myClass+" extends "+SampleEObject.class.getName()+" implements "+this.cgm.getJavaType(cl, false)+" {" 
				);
		pushIndent();
		String myEClassType = this.cgm.getEClass(cl);
		String myEClass = "$"+myClass+"_CLASS"; //TODO: Duplication
		appendLines(ret, "public static final EClass "+myEClass+" = "+myEClassType+";");
		Map<EStructuralFeature, String> featNames = new HashMap<>();
		for (EStructuralFeature feat: cl.getEAllStructuralFeatures()) {
			String featType = (feat instanceof EReference)?"EReference":"EAttribute";
			String featName = "$"+feat.getEContainingClass().getName()+"_"+feat.getName();
			featNames.put(feat, featName);
			String featRef = this.cgm.getEStructuralFeature(feat);
			String getFunctionName = "get"+this.cgm.toFirstUpper(feat.getName());
			String setFunctionName = "set"+this.cgm.toFirstUpper(feat.getName());
			String simpleType = this.cgm.getSimpleJavaType(feat);
			String complexType = this.cgm.getNotifyingJavaType(feat);
			String simpleFeatName = feat.getName();
			appendLines(ret, "public static final "+featType+" "+featName+" = "+featRef+";");
			appendLines(ret, "private "+complexType+" "+simpleFeatName+" = "+this.cgm.getNotifyingJavaTypeInitalizer(feat)+";");
			appendLines(ret, "public "+simpleType+" "+getFunctionName+"() {");
			appendLines(ret, "\treturn this."+(feat.isMany()?simpleFeatName:(simpleFeatName+".value()"))+";");
			appendLines(ret, "}");
			appendLines(ret, "public void "+setFunctionName+"("+simpleType+" newValue) {");
				if (feat.isMany()) {
					appendLines(ret, "\tPatchUtil.applyPatch(this."+simpleFeatName+",newValue);");
				} else {
					appendLines(ret, "\tthis."+simpleFeatName+".setValue(newValue);");
				}
			appendLines(ret, "}");
		}
		popIndent();
		List<String> generated = generateSetGet(cl.getEAllStructuralFeatures(), false, featNames, Collections.emptyList());
		String eGet = generated.get(0);
		String eSet = generated.get(1);
		String eUnset = generated.get(2);
		String addListener = generated.get(3);
		ret.append(eGet);
		ret.append(eSet);
		ret.append(eUnset);
		ret.append(addListener);
		appendLines(ret, "@Override","public EClass eClass() {","\treturn "+myEClass+";","}");
		appendLines(ret, "public void initDerived() {","","","}");
		appendLines(ret, "}");
		return ret.toString();
	}

	public String generate(ObjectCreator creator, Set<EClass> additionalClasses) {
		StringBuilder ret = new StringBuilder();
		String myClass = getClassName(creator);
		String myPkg = "constraintClasses";
		String superClass = getClassName(creator.getClassName());
		appendLines(ret,
				"package "+myPkg+";","",
				"import org.eclipse.emf.ecore.EClass;",
				"import org.eclipse.emf.ecore.EReference;",
				"import "+EList.class.getName()+";",
				"import "+BasicEList.class.getName()+";",
				"import org.eclipse.emf.ecore.EcoreFactory;",
				"import org.eclipse.emf.ecore.EStructuralFeature;",				
				"import "+OclDerivationEvaluable.class.getCanonicalName()+";",
				"import "+OclDerivationEvaluableState.class.getCanonicalName()+";",
				"import "+BasicListenable.class.getName()+ ";",
				"import java.util.List;",
				"import java.util.ArrayList;",
				"import at.ac.tuwien.big.vfunc.nbasic.NewValueListenable;","",
				"public class "+myClass+" extends "+superClass + "{" 
				);
		pushIndent();
		//Currently ignore variables
		String myEClass = "$"+myClass+"_CLASS";
		String superEClass =  superClass+".$"+superClass+"_CLASS";
		appendLines(ret, "public static final EClass "+myEClass+" = EcoreFactory.eINSTANCE.createEClass();");
		appendLines(ret, "static {",myEClass+".getESuperTypes().add("+superEClass+");",
				myEClass+".setName(\""+creator.getName()+"\");",
				"}");
		
		EClass myEcl = getEClass(creator.getClassName());
		additionalClasses.add(myEcl);
		
		EList<ParameterType> pars = creator.getPars();
		List<EStructuralFeature> addFeatures = new ArrayList<>();
		Map<EStructuralFeature, String> featNames = new HashMap<>();
		
		for (ParameterType pt: pars) {
			String parName = "$"+pt.getName();
			String simpleFeatName = pt.getName();
			EClass parClass = getEClass(pt.getType());
			appendLines(ret,
					"public static final EReference "+parName+" = EcoreFactory.eINSTANCE.createEReference();",
					"static {",
					
					"\t"+parName+".setName(\""+pt.getName()+"\");",
					"\t"+parName+".setChangeable(false);",
					"\t"+parName+".setEType("+this.cgm.getEClass(parClass)+");",
					"\t"+myEClass+".getEReferences().add("+parName+");",
					"}",
					"protected "+this.cgm.getEClassTypeRef(parClass,false)+" "+simpleFeatName+";"
					);
			//Additionally actually ...
			{
				EReference ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setName(pt.getName());
				ref.setChangeable(false);
				ref.setEType(parClass);
				addFeatures.add(ref);
				featNames.put(ref, parName);
			}

			EClass ecl = getEClass(pt.getType());
			additionalClasses.add(ecl);
			String simpleType = this.cgm.getEClassTypeRef(ecl,false);
			String getFunctionName = "get"+this.cgm.toFirstUpper(pt.getName());
			String setFunctionName = "set"+this.cgm.toFirstUpper(pt.getName());
			appendLines(ret, "public "+simpleType+" "+getFunctionName+"() {");
			appendLines(ret, "\treturn this."+simpleFeatName+";");
			appendLines(ret, "}");
			appendLines(ret, "public void "+setFunctionName+"("+simpleType+" newValue) {","\t throw new UnsupportedOperationException(\"Setting pars not supported!\");");
				
			appendLines(ret, "}");
		}
		StringBuilder varDef = new StringBuilder();
		//Constructor
		appendLines(ret, "public "+myClass+"() {}");
		
		StringBuilder initDerived = new StringBuilder();
		//Derived init
		appendLines(initDerived, "public void initDerived(){");
		pushIndent();
		appendLines(initDerived, "super.initDerived();");
		{	int index = 0;
			for (ParameterType pt: pars) {
				String parName = pt.getName();
				String parType = this.cgm.getEClassTypeRef(getEClass(pt.getType()),false);
				appendLines(initDerived, "this."+parName+" = ("+parType+")parameters.get("+index+");");
			}
		}
		//Check which things are fixed
		Set<FeatureAssignment> fixed = new HashSet<>();
		Map<String, FeatureAssignment> namedAssignmetn = new HashMap<>();
		for (Fixation fix: creator.getFix()) {
			fixed.add(fix.getFeature());
			namedAssignmetn.put(fix.getFeature().getName(), fix.getFeature());
		}
		Map<FeatureAssignment, List<Definition>> definitions = new HashMap<>();
		for (Definition def: creator.getDef()) {
			String name = def.getName();
			FeatureAssignment fas = namedAssignmetn.get(name);
			if (fas == null) {continue;}
			definitions.computeIfAbsent(fas, x->new ArrayList<>()).add(def);
		}
		//At first, A variable for each
		for (FeatureAssignment fixedThing: fixed) {
			String name = fixedThing.getName();
			EStructuralFeature fixedFeature = myEcl.getEStructuralFeature(name);
			if (fixedFeature != null) {
				String varName = fixedFeature.getName()+"_deriv";
				String listJavaClass = this.cgm.getJavaType(fixedFeature.getEType(), true);
				String correctJavaClass = this.cgm.getSimpleJavaType(fixedFeature);
				String nonListJavaClass = this.cgm.getJavaType(fixedFeature.getEType(), false);
				String initialisation = this.cgm.getJavaTypeInitializer(fixedFeature.getEType(), true);
				appendLines(varDef, listJavaClass+" "+varName+" = "+initialisation+";");
				String recalcName = "recalc"+varName; 
				appendLines(ret,"private void "+recalcName+"() {");
				List<Definition> subFeatures = definitions.getOrDefault(fixedThing, Collections.emptyList());
				pushIndent();
				appendLines(ret,varName+".clear();");
				for (int index = 0; index <  subFeatures.size(); ++index) {
					String newVarName = varName+"_"+index;
					appendLines(varDef, listJavaClass+" "+newVarName+" = "+initialisation+";");
					generateOclListenable(varDef, newVarName, recalcName, nonListJavaClass);
					appendLines(ret,varName+".addAll("+newVarName+");");	
				}
				popIndent();
				appendLines(ret, "}");
				for (int index = 0; index <  subFeatures.size(); ++index) {
					String newVarName = varName+"_"+index;
				}
				
				//The function itself is a bit simpler
				appendLines(ret, "public "+correctJavaClass+" get"+varName+"() {");
				pushIndent();
				if (fixedFeature.isMany()) {
					//List type is correct, but maybe we would have needed a basicEList?
					appendLines(ret, "return "+varName+";");
				} else {
					appendLines(ret, "if ("+varName+".isEmpty()) {return null;} else {return "+varName+".get(0);}");
				}
				popIndent();
				appendLines(ret, "}");
				for (int index = 0; index <  subFeatures.size(); ++index) {
					String newVarName = varName+"_"+index;
					String newVarNameListener = newVarName+"_listener";
					appendLines(initDerived,"{");
					pushIndent();
					String state = newVarNameListener+"_state";
					Definition def = subFeatures.get(index);
					generateEvaluableContent(initDerived, def.getExpr(), newVarNameListener, state);
					appendLines(varDef, "OclDerivationEvaluableState "+state+";");
					popIndent();
					appendLines(initDerived,"}");
				}
			} else {
				System.err.println("I can't assign nonexistant feature "+name+" in class "+myEcl.getName());
			}
		}
		
		for (Invariant inv: creator.getInv()) {
			String iname = inv.getName();
			String cname = "check_"+iname;
			String newVarNameListener = cname+"_listener";
			Expression expr = inv.getExpr();
			appendLines(initDerived,"{");
			pushIndent();
			String state = newVarNameListener+"_state";
			generateEvaluableContent(initDerived, expr, newVarNameListener, state);
			appendLines(varDef, "OclDerivationEvaluableState "+state+";");
			popIndent();
			appendLines(initDerived,"}");
			//TODO: ...
			generateOclInvListenable(varDef, cname);
			appendLines(varDef, "boolean "+cname+" = false;");
			
			
		}
		
		popIndent();
		
		List<String> generated = generateSetGet(addFeatures,true, featNames, addFeatures);
		String eGet = generated.get(0);
		String eSet = generated.get(1);
		String eUnset = generated.get(2);
		String addListener = generated.get(3);
		ret.append(eGet);
		ret.append(eSet);
		ret.append(eUnset);
		ret.append(addListener);
		appendLines(ret, "@Override","public EClass eClass() {","\treturn "+myEClass+";","}");
		appendLines(initDerived, "}");
		//You can ignore derivations for all non-fixed attributes
		ret.append(varDef);
		ret.append(initDerived);
		popIndent();
		ret.append("}");
		return ret.toString();
	}
	
	public void generateEvaluableContent(StringBuilder initDerived, Expression expr, String newVarNameListener, String stateVar) {
		appendLines(initDerived,"OclDerivationEvaluable evaluable = new OclDerivationEvaluable(\""+getExpressionString(expr)+"\", null);",
				stateVar+" = evaluable.getState(this.res, this);",
				stateVar+".addChangeListener("+newVarNameListener+");",stateVar+".initParam();",stateVar+".refresh();");
		
	}
	
	public void generateOclInvListenable(StringBuilder varDef, String newVarName) {

		String newVarNameListener = newVarName+"_listener";
		//A specific listener
		appendLines(varDef, "private NewValueListenable<Object> "+newVarNameListener+" = new NewValueListenable<Object>() {");
		pushIndent();
		appendLines(varDef, "@Override","public void changed(Object oldValue, Object newValue) {System.out.println(\"Changed Inv from \"+oldValue+\" to \" +newValue);\n");
		pushIndent();
		appendLines(varDef, "List l = cmanager.convertOclTupleList(newValue);");
		appendLines(varDef, "l.removeIf((x)->(x == null || !(x instanceof Boolean) || !((Boolean)x)));");
		appendLines(varDef, newVarName+" = !l.isEmpty();");
		popIndent();
		appendLines(varDef, "}");
		popIndent();
		appendLines(varDef, "};");
	}


	public void generateOclListenable(StringBuilder varDef, String newVarName, String recalcName, String nonListJavaClass) {

		String newVarNameListener = newVarName+"_listener";
		//A specific listener
		appendLines(varDef, "private NewValueListenable<Object> "+newVarNameListener+" = new NewValueListenable<Object>() {");
		pushIndent();
		appendLines(varDef, "@Override","public void changed(Object oldValue, Object newValue) {System.out.println(\"Changed Der from \"+oldValue+\" to \" +newValue);\n");
		pushIndent();
		appendLines(varDef, "List l = cmanager.convertOclTupleList(newValue);");
		appendLines(varDef, "l.removeIf((x)->(x == null || !(x instanceof "+nonListJavaClass+")));");
		appendLines(varDef, newVarName+" = new BasicEList<>(l);");
		appendLines(varDef, recalcName+"();");
		popIndent();
		appendLines(varDef, "}");
		popIndent();
		appendLines(varDef, "};");
	}
	
	public List<String> generateSetGet(List<EStructuralFeature> features, boolean userSuper, Map<EStructuralFeature,String> featNames, Collection<EStructuralFeature> parameters) {
		Map<EStructuralFeature,List<String>> contents = new HashMap<>();
		
		
		for (EStructuralFeature feat: features) {
			String getFunctionName = "get"+this.cgm.toFirstUpper(feat.getName());
			String setFunctionName = "set"+this.cgm.toFirstUpper(feat.getName());
			String simpleType = this.cgm.getSimpleJavaType(feat);
			String getContent = "return "+getFunctionName+"();";
			String setContent = setFunctionName+"(("+ (simpleType)+ ")newValue);";
			String defaultContent = feat.isMany()?"Collections.emptyList()":"null";
			String unsetContent ; //;
			if (feat.isMany()) {
				unsetContent = "this."+feat.getName()+".clear();";
			} else {
				unsetContent = "set"+this.cgm.toFirstUpper(feat.getName())+"("+defaultContent+");";
			}
			String listenerContent = feat.getName()+".addBasicChangeListener(refreshMyself);";
			if (parameters.contains(feat)) {
				listenerContent = "";
			}
			contents.put(feat, new ArrayList<>(Arrays.asList(getContent, setContent, unsetContent, listenerContent)));
		}
		
		StringBuilder eSet = new StringBuilder();
		StringBuilder eUnset = new StringBuilder();
		StringBuilder eGet = new StringBuilder();
		StringBuilder listener = new StringBuilder();
		appendLines(eSet, "@Override","public void eSet(EStructuralFeature feature, Object newValue) {");
		appendLines(eGet, "@Override","public Object eGet(EStructuralFeature feature) {");
		appendLines(eUnset, "@Override","public void eUnset(EStructuralFeature feature) {");
		appendLines(listener, "@Override","public void addListener(EStructuralFeature feature, BasicListenable refreshMyself) {");
		
		pushIndent();
		String nothingFoundSet = "System.err.println(\"Unknown feature\" + feature);";
		String nothingFoundGet = "System.err.println(\"Unknown feature\" + feature);"+"\n\t\treturn feature.isMany()?Collections.emptyList():null;\n";
		String nothingFoundUnset = "System.err.println(\"Unknown feature\" + feature);";
		String nothingFoundListener = "System.err.println(\"Unknown feature\" + feature);";
		if (userSuper) {
			nothingFoundGet = "return super.eGet(feature);";
			nothingFoundSet = "super.eSet(feature, newValue);";
			nothingFoundUnset = "super.eUnset(feature);";
			nothingFoundListener = "super.addListener(feature,refreshMyself);";
		}
		{
			boolean first = true;
			for (EStructuralFeature feat: features) {
				if (first) {first = false;} else {appendFirstPart("} else ", eSet, eGet, eUnset, listener);}
				String featName = featNames.get(feat);
				List<String> list = contents.get(feat);
				appendLine("if (feature == "+featName+") {", eSet, eGet, eUnset, listener);
				appendLines(eGet, list.get(0));
				appendLines(eSet, list.get(1));
				appendLines(eUnset, list.get(2));
				appendLines(listener, list.get(3));
			}
			
			appendLine((first?"":"} else ")+" {\n\t\t"+nothingFoundSet, eSet);
			appendLine((first?"":"} else ")+" {\n\t\t"+nothingFoundGet, eGet);
			appendLine((first?"":"} else ")+" {\n\t\t"+nothingFoundUnset, eUnset);
			appendLine((first?"":"} else ")+" {\n\t\t"+nothingFoundListener, listener);
			appendLine("}",eSet,eGet,eUnset, listener);
		}
		popIndent();
		appendLine("}\n", eGet, eSet, eUnset, listener);
		return Arrays.asList(eGet.toString(), eSet.toString(), eUnset.toString(), listener.toString());
	}
	
	public EClass getEClass(ClassRef ref) {
		return this.emanager.getEClass(ref);
	}
	
	public Class<? extends SampleEObject> getOrCreate(EClass cl) {
		Set<EClass> additionalClasses = new HashSet<>();
		Class<? extends SampleEObject> ret = this.storedClasses.computeIfAbsent(cl, x->{
			String content = generate(cl);
			for (EReference ref: cl.getEAllReferences()) {
				additionalClasses.add(ref.getEReferenceType());
			}
			
			String fullName = "constraintClasses."+getClassName(cl);
			//writeFile(content,fullName);
			try {
				Class<? extends SampleEObject> r= (Class<? extends SampleEObject>) Compile.compile(Arrays.asList(new BasicEntry(fullName, content))).get(fullName);
				//r = (Class<? extends SampleEObject>) getClass().getClassLoader().loadClass(r.getCanonicalName());
				return r;
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error converting class " + fullName + ":" + e.getMessage());
				System.err.println("Generated content was: \n" + content);
				return null;
			}
		});
		for (EClass scl: additionalClasses) {
			getOrCreate(scl);
		}
		return ret;
	}
	
	public Class<? extends SampleEObject> getOrCreate(ObjectCreator creator) {
		return this.storedClasses.computeIfAbsent(creator, x->{
			Set<EClass> additionalClasses = new HashSet<>();
			String content = generate(creator, additionalClasses);
			//Here I can do it earlier
			for (EClass cl: additionalClasses) {
				getOrCreate(cl);
			}
			String fullName = "constraintClasses."+getClassName(creator);
			//writeFile(content,fullName);
			try {
				Class<? extends SampleEObject> r= (Class<? extends SampleEObject>) Compile.compile(Arrays.asList(new BasicEntry(fullName, content))).get(fullName);
				//r = (Class<? extends SampleEObject>) getClass().getClassLoader().loadClass(r.getCanonicalName());
				return r;
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error converting class " + fullName + ":" + e.getMessage());
				System.err.println("Generated content was: \n" + content);
				return null;
			}
			
		});
	}
	 
	private void popIndent() {
		--this.indent;
	}
	
	private void pushIndent() {
		++this.indent;
	}
	

	public void writeFile(String content, String fullName) {
		if (generateRoot != null) {
			String sep = fullName.replace('.', File.separatorChar)+".java";
			Path path = generateRoot.toPath().resolve(sep);
			path.getParent().toFile().mkdirs();
			try {
				System.out.println("Generated "+path);
				Files.write(path, content.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

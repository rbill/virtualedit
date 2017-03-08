package at.ac.tuwien.big.helper.processor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.swing.ViewportLayout;
import javax.tools.Diagnostic.Kind;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import javax.lang.model.element.Name;

import at.ac.tuwien.big.helper.annotation.VMethod;
import at.ac.tuwien.big.helper.annotation.VProp;

@SupportedAnnotationTypes(value={"*"})
@SupportedSourceVersion(SourceVersion.RELEASE_5)
public class Processor extends AbstractProcessor {

	private Filer filer;
	private Messager messager;
	
		
	//private ManagerManager manager = new ManagerManager();
	
	@Override
	public void init(ProcessingEnvironment env) {
		filer = env.getFiler();
		messager = env.getMessager();
	}
	
	public static final String vListener = "at.ac.tuwien.big.virtmod.structure.VListener";
	public static final String changeListener = "at.ac.tuwien.big.virtmod.structure.ChangeListener";
	public static final String vListening = "at.ac.tuwien.big.virtmod.structure.VListeningProperty";
	
	@Override
	public boolean process(Set<? extends TypeElement> arg0, RoundEnvironment env) {
		messager.printMessage(Kind.NOTE, "Starting processing");
		for (Element elem: env.getElementsAnnotatedWith(VProp.class)) {
			try {
			VProp[] props =  elem.getAnnotationsByType(VProp.class);
			VProp prop = props[0];
			TypeElement el = (TypeElement)elem;
			
			StringBuilder listenerBuilder = new StringBuilder();
			StringBuilder listeningBuilder = new StringBuilder();
			StringBuilder delegateListeningBuilder = new StringBuilder();
			StringBuilder delegateListeningImplBuilder = new StringBuilder();
			Name name = el.getQualifiedName();
			Name simpleName = el.getSimpleName();
			String listenerName = name+"Listener";
			String listenerSimpleName = simpleName+"Listener";
			String listeningName = name+"Listening";
			String listeningSimpleName = simpleName+"Listening";
			String delegateListeningName = name+"DelegateListening";
			String delegateListeningSimpleName = simpleName+"DelegateListening";			
			String delegateListeningImplName = name+"DelegateListeningImpl";
			String delegateListeningImplSimpleName = simpleName+"DelegateListeningImpl";
			CharSequence pkg = name.subSequence(0, name.length()-1-simpleName.length());
			

			TypeMirror superClass = el.getSuperclass();
			VProp[] annots = superClass.getAnnotationsByType(VProp.class);
			String delegateExtends = "";
			String listenerExtends = "";
			if (annots.length > 0) {
				delegateExtends = " extends "+superClass;
				listenerExtends = delegateExtends+"Listener";
			}
			 
			
						
			String extendsName = String.valueOf(name);
			String fullExtendsList = "";
			String afterExtendsList = "";
			boolean haveExtends = false;
			String typeEl = "";
			if (!el.getTypeParameters().isEmpty()) {
				extendsName = extendsName+"<"+listeningSimpleName+">";
				haveExtends = true;
			}
			if (haveExtends){
				StringBuilder builder = new StringBuilder();
				StringBuilder afterBuilder = new StringBuilder();
				boolean first = true;
				for (TypeParameterElement tpe: el.getTypeParameters()) {
					if (first) {first = false;} else {builder.append(","); afterBuilder.append(",");}
					builder.append(tpe);
					afterBuilder.append(String.valueOf(tpe).split(" ")[0]);
				}
				if (!"".equals(builder.toString().trim())) {
					fullExtendsList = "<"+builder.toString()+">";
				} else {
					fullExtendsList = "";
				}
				
				int firstTypeInd = fullExtendsList.indexOf(" extends "+simpleName+"<");
				if (firstTypeInd != -1) {
					typeEl = fullExtendsList.substring(0,firstTypeInd);
					typeEl = typeEl.substring(typeEl.lastIndexOf("<")+1);
				}
				fullExtendsList = fullExtendsList.replace(" extends "+simpleName+"<", " extends "+listeningSimpleName+"<");
				afterExtendsList = "<"+afterBuilder+">";
			}
			
			
			listenerBuilder.append("package "+pkg+";\n\n");
			listenerBuilder.append("public interface "+listenerSimpleName+fullExtendsList+ listenerExtends+  " extends "+vListener+", \n\t\t\t"+changeListener+"<"
					+  simpleName+afterExtendsList+"> {\n\n");

			
			
			listeningBuilder.append("package " + pkg+";\n\n");
			listeningBuilder.append("public class " + listeningSimpleName+fullExtendsList+
						" extends "+name+afterExtendsList+" implements "+vListening+"<"+listenerSimpleName+fullExtendsList+"> {\n\n");
			listeningBuilder.append("\tjava.util.WeakHashMap<"+listenerSimpleName+afterExtendsList+",Boolean> $listeners = new java.util.WeakHashMap<>();\n\n");
			listeningBuilder.append("\tpublic void addIncompleteListener("+vListener+" listener ) {\n"
					+ "\t\t$listeners.put(listener.fullyImplement("+listenerSimpleName+".class),true);\n"
					+ "\t}\n\n");
			listeningBuilder.append("\tpublic void addListener("+listenerSimpleName+afterExtendsList+" listener ) {\n"
					+ "\t\t$listeners.put(listener,true);\n"
					+ "\t}\n\n");
			listeningBuilder.append("\tpublic void removeListeners(at.ac.tuwien.big.virtmod.structure.VObject vobj) {\n"
					+ "\t\t$listeners.keySet().removeIf((x)->{\n"
					+ "\t\t\tif(java.util.Objects.equals(x.getContainingObject(),vobj)) {\n"
					+ "\t\t\t\tx.destroy();\n"
					+ "\t\t\t\treturn true;\n"
					+ "\t\t\t}\n"
					+ "\t\t\treturn false;\n"
					+ "\t\t});\n"
					+ "\t}\n\n");
			
			if (prop.includeOpId()) {
				listeningBuilder.append("\tprivate long $opid = 0;\n\n"
						+ "\tprivate synchronized long $advopid() {\n"
						+ "\t\treturn $opid++;\n\t}\n\n"
						+ "");
				
			}
			
			delegateListeningBuilder.append("package " + pkg+";\n\n");
			
			Set<String> allInterfaces = new HashSet<String>();
			
			for (TypeMirror mirror: el.getInterfaces()) {
				//Hope for primitive type?? - no, rather: DeclaredType
				System.out.println("Have mirror "+mirror + " of class "+mirror.getClass());
			}
			
			
			delegateListeningBuilder.append("public interface " + delegateListeningSimpleName+" implements "+allInterfaces+" {\n\n");
			
			delegateListeningImplBuilder.append("package " + pkg+";\n\n");
			delegateListeningImplBuilder.append("public class "+delegateListeningImplSimpleName+" implements " + delegateListeningName+" {\n\n");
			
			
			//Was anderes ist nicht erlaubt
			
			for (TypeMirror mirror: el.getInterfaces()) {
				//Hope for primitive type?? - no, rather: DeclaredType
				System.out.println("Have mirror "+mirror + " of class "+mirror.getClass());
			}
			
			for (Element enclosing: el.getEnclosedElements()) {
				if (enclosing instanceof ExecutableElement) {
					ExecutableElement method = (ExecutableElement)enclosing;
					VMethod vmethod = method.getAnnotation(VMethod.class);
					if (vmethod != null && !vmethod.use()) {
						continue;
					}
					TypeMirror ThisType = method.getReceiverType();
					TypeMirror returnType = method.getReturnType();
					Name methodName = method.getSimpleName();
					if ((vmethod == null && (methodName.charAt(0) == '<' || String.valueOf(methodName).startsWith("get") || method.getModifiers().contains(Modifier.STATIC)
								|| method.getModifiers().contains(Modifier.PRIVATE) || String.valueOf(methodName).startsWith("is")))) {
						continue;
					}
					
					
					StringBuilder realMethod = new StringBuilder("\tpublic ");
					
					StringBuilder beforeChangeMethod = new StringBuilder();
					StringBuilder afterChangeMethod = new StringBuilder();
					afterChangeMethod.append("void on");
					beforeChangeMethod.append(afterChangeMethod);
					beforeChangeMethod.append("before");
					StringBuilder commonchangeMethod = new StringBuilder();
					realMethod.append(returnType+" "+methodName+"(");
					commonchangeMethod.append(methodName+"("+simpleName+afterExtendsList+" $This");
					if (prop.includeOpId()) {
						commonchangeMethod.append(", long $opid");
					}
					StringBuilder varList = new StringBuilder();
					{
						boolean first = true;
						for (VariableElement vel: method.getParameters()) {
							if (first) {first = false;} else {realMethod.append(", ");varList.append(",");}
							commonchangeMethod.append(", ");
							String varEl = vel.asType()+" " +vel.getSimpleName();
							commonchangeMethod.append(varEl);
							realMethod.append(varEl);
							varList.append(vel.getSimpleName());
						}
					}
					Set<Integer> bla = new HashSet<Integer>();
					commonchangeMethod.append(")");
					realMethod.append(")");
					{
						boolean first = true;
						for (TypeMirror mirror: method.getThrownTypes()) {
							if (first){realMethod.append(" throws ");} else {realMethod.append(",");}
							realMethod.append(mirror);
						}
					}
					realMethod.append(" {\n");
					if (prop.includeOpId()) {
						realMethod.append("\t\tlong opid = $advopid();\n");
					}
					String commonRMPartStart = "\t\t$listeners.keySet().forEach((x)->{try {x.on";
					StringBuilder commonRMPartEnd = new StringBuilder(methodName);
					commonRMPartEnd.append("(this");
					if (prop.includeOpId()) {
						commonRMPartEnd.append(",opid");
					}
					if (!method.getParameters().isEmpty()) {
						commonRMPartEnd.append(",");
					}
					commonRMPartEnd.append(varList);
					commonRMPartEnd.append(");} catch (Exception e) {e.printStackTrace();}});\n");
					if (prop.includeBefore()) {
						realMethod.append(commonRMPartStart+"before"+commonRMPartEnd+"\n");
					} 
					String maybeRet = (returnType.getKind() == TypeKind.VOID)?"":(returnType+" ret = "); 
					realMethod.append("\t\t"+maybeRet+"super."+methodName+"("+varList+");\n");
					realMethod.append(commonRMPartStart+commonRMPartEnd+"\n");
					realMethod.append("\t\t$listeners.keySet().forEach((x)->{try {x.onchange(this);} catch (Exception e) {e.printStackTrace();}});\n");
					if (returnType.getKind() != TypeKind.VOID) {
						realMethod.append("\t\treturn ret;\n");
					}
					realMethod.append("\t}\n\n");
					listeningBuilder.append(realMethod);
					if (prop.includeBefore()) {
						listenerBuilder.append("\tpublic default " +beforeChangeMethod+commonchangeMethod+" {}\n\n");	
					}
					listenerBuilder.append("\tpublic default " +afterChangeMethod+commonchangeMethod+" {}\n\n");
					
					
					
				}
			}
			if (prop.includeChange()) {
				listenerBuilder.append("\tpublic default void onchange("+simpleName+afterExtendsList+" changed) {}\n\n");
			}
			listenerBuilder.append("}\n");
			listeningBuilder.append("}\n");
			delegateListeningBuilder.append("}\n");
			delegateListeningImplBuilder.append("}\n");
			System.out.println("\n\nListener:\n"+listenerBuilder);
			System.out.println("\n\nListening:\n"+listeningBuilder);
			System.out.println("\n\nDelegateListening:\n"+delegateListeningBuilder);
			System.out.println("\n\nDelegateListeningImpl:\n"+delegateListeningImplBuilder);
			
			try {
				FileObject listener = filer.createResource(StandardLocation.SOURCE_OUTPUT, pkg, listenerSimpleName+".java");
				OutputStream os = listener.openOutputStream();
				os.write(listenerBuilder.toString().getBytes());
				os.flush();
				os.close();
				
				
				FileObject listening = filer.createResource(StandardLocation.SOURCE_OUTPUT, pkg, listeningSimpleName+".java");
				os = listening .openOutputStream();
				os.write(listeningBuilder.toString().getBytes());
				os.flush();
				os.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (Exception e) {
				messager.printMessage(Kind.ERROR, e.getMessage());
			}
		}
		return false;
	}
	
}
package at.ac.tuwien.big.vmod.registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.tools.FileObject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.w3c.dom.EntityReference;

import at.ac.tuwien.big.simpleaspect.simpleAspect.Advice;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Aspect;
import at.ac.tuwien.big.simpleaspect.simpleAspect.AspectExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Assignment;
import at.ac.tuwien.big.simpleaspect.simpleAspect.BinaryPointcutCondition;
import at.ac.tuwien.big.simpleaspect.simpleAspect.BooleanExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.ConstantExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.ConstructorCall;
import at.ac.tuwien.big.simpleaspect.simpleAspect.ForInStatement;
import at.ac.tuwien.big.simpleaspect.simpleAspect.ForStatement;
import at.ac.tuwien.big.simpleaspect.simpleAspect.ForeignAttribute;
import at.ac.tuwien.big.simpleaspect.simpleAspect.GenericExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.IfStatement;
import at.ac.tuwien.big.simpleaspect.simpleAspect.IntegerExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Method;
import at.ac.tuwien.big.simpleaspect.simpleAspect.MethodBlock;
import at.ac.tuwien.big.simpleaspect.simpleAspect.MethodCall;
import at.ac.tuwien.big.simpleaspect.simpleAspect.NullExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Parameter;
import at.ac.tuwien.big.simpleaspect.simpleAspect.ParanthesisOrBinaryExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Pointcut;
import at.ac.tuwien.big.simpleaspect.simpleAspect.PointcutCondition;
import at.ac.tuwien.big.simpleaspect.simpleAspect.PointcutMethodFilter;
import at.ac.tuwien.big.simpleaspect.simpleAspect.PointcutRef;
import at.ac.tuwien.big.simpleaspect.simpleAspect.PointcutTypeFilter;
import at.ac.tuwien.big.simpleaspect.simpleAspect.ReturnStatement;
import at.ac.tuwien.big.simpleaspect.simpleAspect.SimplePointcutCondition;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Statement;
import at.ac.tuwien.big.simpleaspect.simpleAspect.StringExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.Type;
import at.ac.tuwien.big.simpleaspect.simpleAspect.UnaryExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.UnaryPointcutCondition;
import at.ac.tuwien.big.simpleaspect.simpleAspect.VariableDeclaration;
import at.ac.tuwien.big.simpleaspect.simpleAspect.VariableExpression;
import at.ac.tuwien.big.simpleaspect.simpleAspect.WhileStatement;
import at.ac.tuwien.big.simplejava.SimplejavaPackage;
import at.ac.tuwien.big.virtmod.ecore.VEObject;
import at.ac.tuwien.big.virtmod.ecore.impl.ESFFeatureValueList;
import at.ac.tuwien.big.vmod.ecore.VFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VObjectValues;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl.MultiTransformationExecutor;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl.TransformationExecutor;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;

public class SimpleJavaGenerator implements TransformatorGeneratorGenerator {
	
	private static class ParametizedAdvice {
		public final Advice advice;
		public final List<VariableExpression> parameters;
		public ParametizedAdvice(Advice advice, List<VariableExpression> parameters) {
			this.advice = advice;
			this.parameters = parameters;
		}
		
		public ParametizedAdvice(Advice advice) {
			this.advice = advice;
			this.parameters = Collections.emptyList();
		}
	}
	
	public TransformationExecutor aspectToExecutor(Aspect a) {
		List<ForeignAttribute> foreignAttributes = a.getAttributes();
		List<Method> methods = a.getMethods();
		List<Pointcut> pointcuts = a.getPointcuts();
		List<Advice> advices = a.getAdvices();
		//Das sind attribute, die dazugebastelt werden!
		//Blöderweise existieren die da noch nicht ...
		return new TransformationExecutor() {
			
			private boolean sameType(Type returnType, EObject returnTypeObj) {
				if (returnType.getTypeName() == null && returnType.getTypeRef() == null) {
				if (returnTypeObj.eGet(SimplejavaPackage.eINSTANCE.getType_TypeName()) != null) {
					return false;
				}
			} else {
				if (returnType.getTypeName() != null) {
					if (!Objects.equals(returnTypeObj.eGet(SimplejavaPackage.eINSTANCE.getType_TypeName()),returnType.getTypeName())) {
						return false;
					}
				} else {
					EObject returnTypeTypeRef = (EObject)returnTypeObj.eGet(SimplejavaPackage.eINSTANCE.getType_TypeRef());
					if (returnTypeTypeRef == null || !Objects.equals(returnTypeTypeRef.eGet(SimplejavaPackage.eINSTANCE.getClassDeclaration_Name())
							,returnType.getTypeRef())) {
						return false;
					}
				}
				}
				return true;
			}
			
			public String getName(EObject eobj) {
				Object ret = eobj.eGet(eobj.eClass().getEStructuralFeature("name"));
				if (ret == null)  {
					return null;
				}
				return String.valueOf(ret);
			}
			
			public void getMatches(VModelView view, PointcutCondition cond, List<EObject> candidates, List<EObject> matches) {
				if (cond instanceof BinaryPointcutCondition) {
					BinaryPointcutCondition bpc = (BinaryPointcutCondition)cond;
					String type = bpc.getType();
					switch(type) {
					case "&&":
						List<EObject> match1 = new ArrayList<>();
						getMatches(view, bpc.getFirst(), candidates, match1);
						getMatches(view, bpc.getSecond(), match1, matches);
						break;
					case "||":
						getMatches(view, bpc.getFirst(), candidates, matches);
						getMatches(view, bpc.getSecond(), candidates, matches);
						break;
					default:
						throw new UnsupportedOperationException("Don't know type " + type);
					}
				} else if (cond instanceof SimplePointcutCondition) {
					SimplePointcutCondition spc = (SimplePointcutCondition)cond;
					
					switch(spc.getType()) {
					case "call":
					{
						PointcutMethodFilter mc = (PointcutMethodFilter)spc.getCondition();
						String classType = mc.getClassType();
						String methodName = mc.getMethodName();
						Type returnType = mc.getReturnType();
						List<Type> parameterType = mc.getParameter();
						if (true) throw new UnsupportedOperationException();
					}
						break;
					case "execution":
						{
							PointcutMethodFilter mc = (PointcutMethodFilter)spc.getCondition();
							String classType = mc.getClassType();
							String methodName = mc.getMethodName();
							Type returnType = mc.getReturnType();
							List<Type> parameterType = mc.getParameter();
							List<Object> toAdd = new ArrayList<>();
							mainloop: for (EObject o: candidates) {
								if (!SimplejavaPackage.eINSTANCE.getMethod().isSuperTypeOf(o.eClass())) {
									continue;
								}
								String candName = getName(o);
								if (candName == null) {
									continue;
								}
								System.out.println("Have name: "+candName);
								if (!mc.isAnyMethod() && !Objects.equals(methodName,candName)) {
									continue;
								}
								EObject cd = o.eContainer();
								if (!mc.isAnyClass() && !Objects.equals(classType, getName(cd))) {
									continue;
								}
								if (!mc.isAnyReturn()) {
									EObject returnTypeObj = (EObject)o.eGet(SimplejavaPackage.eINSTANCE.getMethod_ReturnType());
									if (!sameType(returnType,returnTypeObj)) {
										continue;
									}
								}
								if (!mc.isAnyParameter()) {
									Collection c = MyEcoreUtil.getAsCollection(o, SimplejavaPackage.eINSTANCE.getMethod_Parameter());
									if (parameterType.size() != c.size()) {
										continue;
									}
									Iterator<Type> type1 = parameterType.iterator();
									Iterator<Object> type2 = c.iterator();
									while (type2.hasNext() && type1.hasNext())  {
										Type type_ = type1.next();
										EObject type2_ = (EObject)type2.next();
										if (!sameType(type_,type2_)) {
											continue mainloop;
										}
									}
								}
								matches.add(o);
							}
						}
						break;
					case "within":
						PointcutTypeFilter tw = (PointcutTypeFilter)spc.getCondition();
						if (true) throw new UnsupportedOperationException();
						break;
					case "handler":
						PointcutTypeFilter th = (PointcutTypeFilter)spc.getCondition();
						if (true) throw new UnsupportedOperationException();
						break;
					}
					
				} else if (cond instanceof UnaryPointcutCondition) {
					SimplePointcutCondition spc = (SimplePointcutCondition)cond;
					List<EObject> match1 = new ArrayList<>();
					getMatches(view, (PointcutCondition)spc.getCondition(), candidates, match1);
					List<EObject> toAdd = new ArrayList<>(candidates);
					toAdd.removeAll(match1);
					matches.addAll(toAdd);
				}
			}
			
			Map<String,Map<String,EObject>> addedParameters = new HashMap<>();

			@Override
			public void executeOn(VModelView view) {
				VObjectValues vals = view.getInstances();
				Map<String,Symbol> classnameToSymbol = new HashMap<>();
				Iterable<Symbol> cdinst = vals.getInstances("ClassDeclaration");
				VFeatureValues namevals = view.getFeatureValues("ClassDeclaration", "name");
				for (Symbol sym: cdinst) {
					for (Object name: namevals.getValueValue(sym)) {
						classnameToSymbol.put(String.valueOf(name), sym);
					}
				}
				VFeatureValues parameterType = view.getFeatureValues("Parameter","type");
				VFeatureValues parameterName = view.getFeatureValues("Parameter", "name");
				VFeatureValues typeName = view.getFeatureValues("Type","typeName");
				VFeatureValues typeRef = view.getFeatureValues("Type","typeRef");
				for (ForeignAttribute attr: foreignAttributes) {
					//Add this attribute
					//Das ist vermutlich ein Xtext-Zeugs, kein Virtual-zeugs ...
					//TODO: Das ist nicht qualifiziert ...
					Collection<Symbol> syms = new ArrayList<>();
					if (attr.getInType() != null) {
						Symbol sym = classnameToSymbol.get(attr.getInType());
						if (sym != null) {
							syms.add(sym);
						}
					} else {
						syms.addAll(classnameToSymbol.values());
					}
					
					for (Symbol sym: syms) {
						String name = null;
						for (Entry<String,Symbol> entr: classnameToSymbol.entrySet()) {
							if (entr.getValue().equals(sym)) {
								name = entr.getKey();
								break;
							}
						}
						Map<String,EObject> nameToAttr = this.addedParameters.get(name);
						if (nameToAttr == null) {
							this.addedParameters.put(name, nameToAttr = new HashMap<>());
						}
						
						EObject eobj = view.getEObject(sym);
						Collection c = (Collection)view.getEObject(sym).eGet(SimplejavaPackage.eINSTANCE.getClassDeclaration_Attribute());
						
						//Create attribute, derived from aspect
						Symbol newAttribute = Symbol.buildFrom("addAttr", sym, attr.getName());
												
						EObject parameter = view.createEObject(newAttribute,SimplejavaPackage.eINSTANCE.getSimpleParameter());
						c.add(parameter);
						Type typeAttr = attr.getType();
						String curTypeName = null;
						String curTypeRef = null; 
						if (typeAttr != null) {
							curTypeName = typeAttr.getTypeName();
							curTypeRef = typeAttr.getTypeRef();
						}
						nameToAttr.put(attr.getName(), parameter);
						Symbol newAttributeType = Symbol.buildFrom(view.getMainProvider().getSymbolName(), "attrType", sym, attr.getName());
						EObject type = view.createEObject(newAttributeType, SimplejavaPackage.eINSTANCE.getType());
						parameterType.setSingleValue(newAttribute,newAttributeType);
						parameterName.setSingleValue(newAttribute, attr.getName());
						Symbol typeRefSym = classnameToSymbol.get(curTypeRef);
						if (typeRefSym != null) {
							typeRef.setSingleValue(newAttributeType, typeRefSym);
						}
						if (curTypeName != null) {
							typeName.setSingleValue(newAttributeType, curTypeName);
						}
						parameter.eSet(SimplejavaPackage.eINSTANCE.getParameter_Type(), type);	
					}
				}
				Map<Pointcut,List<ParametizedAdvice>> advicesPerPointcut = new HashMap<>();
				List<Pointcut> pointcutList = new ArrayList<>();
				//Select everything ...
				for (Pointcut p: pointcuts) {
					pointcutList.add(p);
					advicesPerPointcut.put(p, new ArrayList<>());
				}
				for (Advice advice: advices) {
					EObject pcRefOrPc = advice.getPointcut();
					if (pcRefOrPc instanceof Pointcut) {
						Pointcut pc = (Pointcut)pcRefOrPc;
						
						pointcutList.add(pc);
						advicesPerPointcut.put(pc, Arrays.asList(new ParametizedAdvice(advice)));
					} else {
						PointcutRef ref = (PointcutRef)pcRefOrPc;
						advicesPerPointcut.get(ref.getPointcut()).add(new ParametizedAdvice(advice,ref.getParameterValue()));
					}
				}
				
				List<EObject> candidates = new ArrayList<>();
				//ClassDeclaration or Method for now
				for (Symbol sym: cdinst) {
					candidates.add(view.getEObject(sym));
				}
				List<EObject> methods = view.allInstances(SimplejavaPackage.eINSTANCE.getMethod());
				candidates.addAll(methods);
				
				ModelCorrespondance corr = ModelCorrespondance.IDENTITY;
				SimpleModelCorrespondance subCorr = new SimpleModelCorrespondance();
				Map<Symbol,InstanceCreator> creationMap = new HashMap<>();
				
				//evaluiere jeden pointcut ... - ignoriere Parameter im Moment
				for (Pointcut pointcut: pointcutList) {
					PointcutCondition cond = pointcut.getCondition();
					List<EObject> matches = new ArrayList<>();
					getMatches(view,cond,candidates,matches);
					List<ParametizedAdvice> advices = advicesPerPointcut.get(pointcut);
					for (EObject match: matches) {
						int adviceId = 0;
						for (ParametizedAdvice padv: advices) {
							Advice advice = padv.advice;
							String type = advice.getType();
							//(type='before' | type='after' | type='around')
							MethodBlock code = advice.getCode();
							//Ignore parameters for now ...
							EObject originalBlock = (EObject)match.eGet(SimplejavaPackage.eINSTANCE.getMethod_Content());
							VMEObject vmeo = (VMEObject)match;
							Symbol prefix = Symbol.buildFrom(view.getMainProvider().getSymbolName(),
									vmeo.getUUID(), a.getName(), String.valueOf(pointcut.getName()),adviceId);
							InstanceCreator tc = creationMap.get(prefix);
							if (tc == null) {
								creationMap.put(prefix, tc = view.getTransformationCreater(prefix, corr, subCorr));
							}
							try {
							EObject toSimpleJavaBlock = convertBlock(match,code,match,originalBlock,tc);
							switch(type) {
							case "before":
								 {
									 List l = (List) originalBlock.eGet(SimplejavaPackage.eINSTANCE.getMethodBlock_Statements());
									 l.add(0,toSimpleJavaBlock);
									 System.out.println("List after before:" + l);
								 }
								 break;
							case "after":
							{
								List l = (List) originalBlock.eGet(SimplejavaPackage.eINSTANCE.getMethodBlock_Statements());
								l.add(toSimpleJavaBlock);
								System.out.println("List after after:" + l);
							}
								 break;
							case "around":
							{
								match.eSet(SimplejavaPackage.eINSTANCE.getMethod_Content(),toSimpleJavaBlock);
								break;
							}
							}
							} catch (Exception e) {
								e.printStackTrace();
							}
							++adviceId;
						}
					}
				}
				
				
			}
			
			private EObject convertIf(EObject originalMatch, IfStatement statement, EObject match, EObject originalBlock, InstanceCreator transformationCreater) {
				EObject ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getIfStatement());
				ret.eSet(SimplejavaPackage.eINSTANCE.getIfStatement_Then(), convertBlock(originalMatch, statement.getThen(), match, originalBlock, transformationCreater));
				if (statement.getElse() != null) {
					ret.eSet(SimplejavaPackage.eINSTANCE.getIfStatement_Else(), convertBlock(originalMatch, statement.getElse(), match, originalBlock, transformationCreater));	
				}
				ret.eSet(SimplejavaPackage.eINSTANCE.getIfStatement_Condition(), convertIfCond(originalMatch, statement.getCondition(),ret,originalBlock,transformationCreater));
				return ret;
			}
			
			private EObject convertIfCond(EObject originalMatch, ParanthesisOrBinaryExpression expr, EObject match, EObject originalBlock, InstanceCreator transformationCreater) {
				GenericExpression source = expr.getSource();
				GenericExpression argument = expr.getArgument();
				String type = expr.getType();
				EObject ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getParanthesisOrBinaryExpression());
				if (source != null) {
					ret.eSet(SimplejavaPackage.eINSTANCE.getParanthesisOrBinaryExpression_Source(), convertExpression(originalMatch, source,ret,originalBlock,transformationCreater));
				}
				if (argument != null) {
					ret.eSet(SimplejavaPackage.eINSTANCE.getParanthesisOrBinaryExpression_Argument(), convertExpression(originalMatch, argument,ret,originalBlock,transformationCreater));
				}
				ret.eSet(SimplejavaPackage.eINSTANCE.getParanthesisOrBinaryExpression_Type(), type);
				return ret;
			}
			
			private EObject convertExpression(EObject originalMatch, GenericExpression source, EObject match, EObject originalBlock, InstanceCreator transformationCreater) {
				if (source instanceof ConstantExpression) {
					return convertConstantExpression(originalMatch,(ConstantExpression)source, match, originalBlock, transformationCreater);
				} else if (source instanceof MethodCall) {
					return convertMethodCall(originalMatch,(MethodCall)source,match,originalBlock,transformationCreater);					
				} else if (source instanceof ParanthesisOrBinaryExpression) {
					return convertIfCond(originalMatch,(ParanthesisOrBinaryExpression)source, match, originalBlock, transformationCreater);
				} else if (source instanceof UnaryExpression) {
					throw new UnsupportedOperationException();
				} else if (source instanceof VariableExpression) {
					return convertVariableExpression(originalMatch,(VariableExpression)source, match, originalBlock, transformationCreater);
				}
				throw new UnsupportedOperationException();
			}
			
			
			private EObject convertVariableExpression(EObject originalMatch, VariableExpression source, EObject match,
					EObject originalBlock, InstanceCreator transformationCreater) {
				EObject ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getVariableExpression());
				at.ac.tuwien.big.simpleaspect.simpleAspect.Parameter par = source.getVariable();
				Type type = par.getType();
				if (true) throw new UnsupportedOperationException();
				// TODO Auto-generated method stub
				return null;
			}

			private EObject convertConstantExpression(EObject originalMatch, ConstantExpression source, EObject match, EObject originalBlock,
					InstanceCreator transformationCreater) {
				EObject ret = null;
				if (source instanceof BooleanExpression) {
					transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getBooleanExpression());
					ret.eSet(SimplejavaPackage.eINSTANCE.getBooleanExpression_Value(), ((BooleanExpression)source).isValue());
				} else if (source instanceof IntegerExpression) {
					ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getIntegerExpression());
					ret.eSet(SimplejavaPackage.eINSTANCE.getIntegerExpression_Value(), ((IntegerExpression)source).getValue());
				} else if (source instanceof NullExpression) {
					ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getNullExpression());
				} else if (source instanceof StringExpression) {
					ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getStringExpression());
					ret.eSet(SimplejavaPackage.eINSTANCE.getStringExpression_Value(), ((StringExpression)source).getValue());
				} else if (source instanceof AspectExpression) {
					AspectExpression expr = (AspectExpression)source;
					ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getStringExpression());
					String val;
					if ("METHOD_NAME".equals(expr.getValue())) {
						val = (String)originalMatch.eGet(originalMatch.eClass().getEStructuralFeature("name"));
					} else if ("CLASS_NAME".equals(expr.getValue())) {
						val = (String)originalMatch.eContainer().eGet(originalMatch.eContainer().eClass().getEStructuralFeature("name"));
					} else {
						throw new UnsupportedOperationException("Not supported: " + expr.getValue());
					}
					if (val == null) {
						ret.eSet(SimplejavaPackage.eINSTANCE.getStringExpression_Value(), "????");
					} else {
						ret.eSet(SimplejavaPackage.eINSTANCE.getStringExpression_Value(), val);
					}
					
				}
				if (ret == null) {
					throw new UnsupportedOperationException();
				}
				return ret;
			}

			private EObject convertStatement(EObject originalMatch, Statement statement, EObject match, EObject originalBlock, InstanceCreator transformationCreater) {
				if (statement instanceof MethodBlock) {
					return convertBlock(originalMatch,(MethodBlock)statement, match, originalBlock, transformationCreater);
				} else if (statement instanceof VariableDeclaration) {
					throw new UnsupportedOperationException();
				} else if (statement instanceof Assignment ) {
					throw new UnsupportedOperationException();
				} else if (statement instanceof IfStatement) {
					return convertIf(originalMatch,(IfStatement)statement, match, originalBlock, transformationCreater);
				} else if (statement instanceof ForStatement) {
					throw new UnsupportedOperationException();
				} else if (statement instanceof ForInStatement) {
					throw new UnsupportedOperationException();
				} else if (statement instanceof WhileStatement) {
					throw new UnsupportedOperationException();
				} else if (statement instanceof ReturnStatement) {
					throw new UnsupportedOperationException();
				} else if (statement instanceof MethodCall) {
					return convertMethodCall(originalMatch,(MethodCall)statement,match,originalBlock,transformationCreater);
				} else if (statement instanceof ConstructorCall) {
					return convertConstructorCall(originalMatch,(ConstructorCall)statement,match,originalBlock,transformationCreater);
				}
				throw new UnsupportedOperationException();
				
			}

			private EObject convertParameter(EObject originalMatch, Parameter par, EObject match, EObject originalBlock,
					InstanceCreator transformationCreater) {
				EObject ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getParameter());
				throw new UnsupportedOperationException();
			}
			
						
			private EObject convertMethodCall(EObject originalMatch, MethodCall statement, EObject match, EObject originalBlock,
					InstanceCreator transformationCreater) {
				EObject ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getMethodCall());
				ret.eSet(SimplejavaPackage.eINSTANCE.getMethodCall_MethodName(), statement.getMethodName());
				List parameters = new ArrayList<>();
				for (GenericExpression expr: statement.getParameter()) {
					parameters.add(convertExpression(originalMatch,expr, ret, originalBlock, transformationCreater));
				}
				((Collection)ret.eGet(SimplejavaPackage.eINSTANCE.getMethodCall_Parameter())).addAll(parameters);
				//TODO: Implement the rest of the method
				
				Object obj = statement.getObject();
				if (obj instanceof Parameter) {
					ret.eSet(SimplejavaPackage.eINSTANCE.getMethodCall_Object(),convertParameter(originalMatch,(Parameter)statement,match,originalBlock,transformationCreater));
					throw new UnsupportedOperationException();
				} else if (obj instanceof ForeignAttribute) {
					ForeignAttribute fa = (ForeignAttribute)obj;
					String inType = fa.getInType();
					if (inType == null) {
						inType = (String)originalMatch.eContainer().eGet(originalMatch.eContainer().eClass().getEStructuralFeature("name"));						
					}
					String attr = fa.getName();
					EObject targetPar = addedParameters.getOrDefault(inType,Collections.emptyMap()).get(attr);
					if (targetPar != null) {
						
						ret.eSet(SimplejavaPackage.eINSTANCE.getMethodCall_Object(),targetPar);
					}
				}
				/* 
				(((object=[Parameter|QualifiedName]|thisObject?='this') '.')? (method=[Method|ID] | methodName=('equals'|'hashCode'))
						| (methodName='System.out.println')
					)
						 '(' (parameter+=GenericExpression (',' parameter+= GenericExpression)* )? ')' ';'
				;*/
				return ret;
			}
			

			private EObject convertConstructorCall(EObject originalMatch, ConstructorCall statement, EObject match, EObject originalBlock,
					InstanceCreator transformationCreater) {
				EObject ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getConstructorCall());
				//ret.eSet(SimplejavaPackage.eINSTANCE.getMethodCall_MethodName(), statement.getMethodName());
				List parameters = new ArrayList<>();
				for (GenericExpression expr: statement.getParameter()) {
					parameters.add(convertExpression(originalMatch,expr, ret, originalBlock, transformationCreater));
				}
				((Collection)ret.eGet(SimplejavaPackage.eINSTANCE.getConstructorCall_Parameter())).addAll(parameters);
				//TODO: Implement the rest of the method
				/* 
				(((object=[Parameter|QualifiedName]|thisObject?='this') '.')? (method=[Method|ID] | methodName=('equals'|'hashCode'))
						| (methodName='System.out.println')
					)
						 '(' (parameter+=GenericExpression (',' parameter+= GenericExpression)* )? ')' ';'
				;*/
				return ret;
			}

			private EObject convertBlock(EObject originalMatch, MethodBlock code, EObject match, EObject originalBlock,
					InstanceCreator transformationCreater) {
				if (code.isGenerated()) {
					return originalBlock;
				}
				EObject ret = transformationCreater.createInstance(match, SimplejavaPackage.eINSTANCE.getMethodBlock());
				List toAdd = new ArrayList<>();
				for (Statement statement: code.getStatements()) {
					toAdd.add(convertStatement(originalMatch,statement,ret,originalBlock,transformationCreater));
				}
				List l = (List)ret.eGet(SimplejavaPackage.eINSTANCE.getMethodBlock_Statements());
				l.addAll(toAdd);
				return ret;
			}
			
		};
	}
	

	@Override
	public TransformationExecutor getExecutor(Resource res) {
		List<Aspect> aspects = new ArrayList<>();
		for (EObject eobj: res.getContents()) {
			if (eobj instanceof Aspect) {
				Aspect a = (Aspect)eobj;
				if (a != null) {
					aspects.add(a);
				}
			}
		}
		if (aspects.isEmpty()) {
			return null;
		}
		MultiTransformationExecutor ret = new MultiTransformationExecutor();
		for (Aspect a: aspects) {
			ret.addExecutor(aspectToExecutor(a));
		}
		return ret;
	}

}

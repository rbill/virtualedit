package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import VObjectModel.VObjDeltaModel;
import VObjectModel.VObjectModelPackage;
import VObjectModel.impl.VObjDeltaModelImpl;

public class ClassGenerationManager {
	
	private static class PackageInfo {
		private String packageClassPrefix;
		private String packageClassName;
	}
	
	private static final PackageInfo NO_INFO = new PackageInfo();
	static {
		NO_INFO.packageClassName = "?";
		NO_INFO.packageClassPrefix="??";
	}
	
	private Map<EPackage,PackageInfo> knownPackages = new HashMap<>();
	
	public String getPrefix(EPackage pkg) {
		return knownPackages.getOrDefault(pkg, NO_INFO).packageClassPrefix;
	}
	
	public String getPackageClass(EPackage pkg) {
		return getPrefix(pkg)+"."+knownPackages.getOrDefault(pkg, NO_INFO).packageClassName;
	}
	
	
	public String getPrefixed(EPackage pkg, String str) {
		return getPrefix(pkg)+"."+str;
	}
	
	public String getEClass(EClass cl) {
		String ret = getPackageClass(cl.getEPackage())+".eINSTANCE.get"+toFirstUpper(cl.getName())+"()";
		return ret;
	}
	
	private static String toFirstUpper(String str) {
		if (str.length() <= 1) {
			return str.toUpperCase();
		}
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}

	public String getEStructuralFeature(EStructuralFeature esf) {
		String ret = getPackageClass(esf.getEContainingClass().getEPackage())+".eINSTANCE.get"+toFirstUpper(esf.getName())+"_"+
				toFirstUpper(esf.getName())+"()";
		return ret;
	}
	
	public String getType(EStructuralFeature feature) {
		if (feature instanceof EReference) {
			return getEStructuralFeature(feature)+".getEType()";
		} else {
			return getEStructuralFeature(feature)+".getEDataType()";
		}
	}
	
	public String getNotifyingJavaType(EStructuralFeature ecl) {
		return getNotifyingJavaType(ecl.getEType(), ecl.isMany());
	}
	
	public String getSimpleJavaType(EStructuralFeature ecl) {
		return getJavaType(ecl.getEType(), ecl.isMany());
	}
	
	public String getJavaType(EClassifier ecl, boolean isMulti) {
		String ret = ecl.getInstanceClass().getName();
		if (isMulti) {
			ret=  "List<"+ret+">";
		}
		return ret;
	}
	
	public String getNotifyingJavaType(EClassifier ecl, boolean isMulti) {
		String ret = ecl.getInstanceClass().getName();
		if (isMulti) {
			ret= "NotifyingList<"+ret+">";
		} else {
			ret="ConstantValue<"+ret+">";
		}
		return ret;
	}
	
	

	public String getJavaTypeInitializer(EClassifier ecl, boolean isMulti) {
		String ret = String.valueOf(ecl.getDefaultValue());
		if (isMulti) {
			ret=  "new ArrayList<>()";
		}
		return ret;
	}
	
	public String getNotifyingJavaTypeInitalizer(EClassifier ecl, boolean isMulti) {
		String ret = ecl.getInstanceClass().getName();
		if (isMulti) {
			ret= "NotifyingList<>("+getJavaTypeInitializer(ecl, isMulti)+")";
		} else {
			ret="new ConstantValue<>("+getJavaTypeInitializer(ecl, isMulti)+")";
		}
		return ret;
	}
	
	public String getEClassTypeRef(EClass cl, boolean isImpl) {
		String prefix = getPrefix(cl.getEPackage());
		if (isImpl) {
			prefix = prefix+".impl";
		}
		prefix = prefix+"."+cl.getName();
		if (isImpl) {
			prefix = prefix+"Impl";
		}
		return prefix;
	}
	
	/**Must be in the code!*/
	public void knowPackage(EPackage pkg) {
		String pkgClass = pkg.getClass().getName();
		pkgClass = pkgClass.substring(0,pkgClass.lastIndexOf('.'));
		PackageInfo pkgInfo =new PackageInfo();
		pkgInfo.packageClassPrefix = pkgClass;
		pkgInfo.packageClassName = pkg.getClass().getSimpleName();
		knownPackages.put(pkg, pkgInfo);
	}
	
	public static void main(String[] args) {
		VObjectModelPackage.eINSTANCE.getBasicFunction_Values().getEType();
		System.out.println("pkg: "+VObjectModelPackage.class.getName());
		System.out.println("basic: "+VObjDeltaModel.class.getName());
		System.out.println("impl: "+VObjDeltaModelImpl.class.getName());
	}

}

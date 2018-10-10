package at.ac.tuwien.big.vfunc.nbasic.constraint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjDeltaModel;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelPackage;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.impl.VObjDeltaModelImpl;

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
	
	public static void main(String[] args) {
		VObjectModelPackage.eINSTANCE.getBasicFunction_Values().getEType();
		System.out.println("pkg: "+VObjectModelPackage.class.getName());
		System.out.println("basic: "+VObjDeltaModel.class.getName());
		System.out.println("impl: "+VObjDeltaModelImpl.class.getName());
	}
	
	static String toFirstUpper(String str) {
		if (str.length() <= 1) {
			return str.toUpperCase();
		}
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
	
	private Map<EPackage,PackageInfo> knownPackages = new HashMap<>();
	
	
	public String getEClass(EClass cl) {
		String ret = getPackageClass(cl.getEPackage())+".eINSTANCE.get"+toFirstUpper(cl.getName())+"()";
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
	
	public String getEStructuralFeature(EStructuralFeature esf) {
		String ret = getPackageClass(esf.getEContainingClass().getEPackage())+".eINSTANCE.get"+toFirstUpper(esf.getEContainingClass().getName())+"_"+
				toFirstUpper(esf.getName())+"()";
		return ret;
	}

	public PackageInfo getInfo(EPackage pkg) {
		return this.knownPackages.computeIfAbsent(pkg, p->{
			return knowPackage(pkg);
		});
	}
	
	public String getJavaType(EClassifier ecl, boolean isMulti) {
		String ret = ecl.getInstanceClass().getName();
		if (isMulti) {
			ret=  EList.class.getName()+"<"+ret+">";
		}
		return ret;
	}
	
	public String getJavaTypeInitializer(EClassifier ecl, boolean isMulti) {
		String ret = String.valueOf(ecl.getDefaultValue());
		if (isMulti) {
			ret=  "new "+BasicEList.class.getName()+"<>()";
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
	
	public String getNotifyingJavaType(EStructuralFeature ecl) {
		return getNotifyingJavaType(ecl.getEType(), ecl.isMany());
	}

	public String getNotifyingJavaTypeInitalizer(EClassifier ecl, boolean isMulti) {
		String ret = ecl.getInstanceClass().getName();
		if (isMulti) {
			ret= "new NotifyingList<>("+getJavaTypeInitializer(ecl, isMulti)+")";
		} else {
			ret="new ConstantValue<>("+getJavaTypeInitializer(ecl, isMulti)+")";
		}
		return ret;
	}

	
	public String getNotifyingJavaTypeInitalizer(EStructuralFeature feat) {
		return getNotifyingJavaTypeInitalizer(feat.getEType(), feat.isMany());
	}
	
	

	public String getPackageClass(EPackage pkg) {
		return getPrefix(pkg)+"."+getInfo(pkg).packageClassName;
	}
	
	public String getPrefix(EPackage pkg) {
		return getInfo(pkg).packageClassPrefix;
	}
	
	public String getPrefixed(EPackage pkg, String str) {
		return getPrefix(pkg)+"."+str;
	}
	
	public String getSimpleJavaType(EStructuralFeature ecl) {
		return getJavaType(ecl.getEType(), ecl.isMany());
	}
	
	public String getType(EStructuralFeature feature) {
		if (feature instanceof EReference) {
			return getEStructuralFeature(feature)+".getEType()";
		} else {
			return getEStructuralFeature(feature)+".getEDataType()";
		}
	}
	
	/**Must be in the code!*/
	public PackageInfo knowPackage(EPackage pkg) {
		String pkgClass = pkg.getClass().getName();
		pkgClass = pkgClass.substring(0,pkgClass.lastIndexOf('.'));
		PackageInfo pkgInfo =new PackageInfo();
		pkgInfo.packageClassPrefix = pkgClass;
		if (pkgInfo.packageClassPrefix.endsWith(".impl")) {
			pkgInfo.packageClassPrefix = pkgInfo.packageClassPrefix.substring(0, pkgInfo.packageClassPrefix.length()-".impl".length());
		}
		pkgInfo.packageClassName = pkg.getClass().getSimpleName();
		if (pkgInfo.packageClassName.endsWith("Impl")) {
			pkgInfo.packageClassName = pkgInfo.packageClassName.substring(0, pkgInfo.packageClassName.length()-"Impl".length());
		}
		this.knownPackages.put(pkg, pkgInfo);
		return pkgInfo;
	}

}

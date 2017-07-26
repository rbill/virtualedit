package at.ac.tuwien.big.vmod.ecore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;

public class EcoreFuncUtil {
	
	public static String className(EClass cl) {
		return cl.getName();
	}
	
	public static void setClass(Function<String,? extends Counter> func, EClass cl) {
		List<EClass> allClasses = new ArrayList<>(cl.getEAllSuperTypes());
		allClasses.add(cl);
		List<String> str = new ArrayList<>();
		allClasses.forEach((x)->str.add(className(x)));
		Function.setToCol(func, str);
	}
	
	
	public static EClass getClass(Function<String,? extends Counter> func, VEcoreFile helper) {
		Collection<String> existingValues = Function.getExistingValues(func);
		Stack<EClass> candiate = new Stack<>();
		for (String ev: existingValues) {
			EClass cl = helper.getClass(ev);
			if (!candiate.contains(cl)) {
				candiate.add(cl);
			}
		}
		List<EClass> ret = new ArrayList<>();
		while (!candiate.isEmpty()) {
			EClass cl = candiate.pop();
			ret.add(cl);
			Collection<EClass> superFeature = cl.getEAllSuperTypes();
			ret.removeAll(superFeature);
			candiate.removeAll(superFeature);
		}
		if (ret.isEmpty()) {
			
			return null;
		}
		if (ret.size()>1) {
			throw new RuntimeException("Multiple classes!!");
		}
		return ret.get(0);
	}

	public static String featureName(EReference feature) {
		EClass cl = feature.getEContainingClass();
		return (cl==null?"":cl.getName())+"."+feature.getName();
	}


}

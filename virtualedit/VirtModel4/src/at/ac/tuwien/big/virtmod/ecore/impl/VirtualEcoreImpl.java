package at.ac.tuwien.big.virtmod.ecore.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.virtmod.ecore.VClass;
import at.ac.tuwien.big.virtmod.ecore.VirtualECore;

public class VirtualEcoreImpl<A> implements VirtualECore<A> {
	
	private Map<String,EClass> eclasses = new HashMap<>();
	private Map<EClass,List<EClass>> subclasses = new HashMap<>();
	private Map<String,EEnum> eenums = new HashMap<>();
	
	public VirtualEcoreImpl(Resource ecoreResource) {
		for (EObject eobj: (Iterable<EObject>)()->ecoreResource.getAllContents()) {
			if (eobj instanceof EEnum) {
				EEnum eenum = (EEnum)eobj;
				eenums.put(eenum.getName(), eenum);
			} else if (eobj instanceof EClass) {
				EClass cl = (EClass)eobj;
				eclasses.put(cl.getName(), cl);
				for (EClass superClass: cl.getEAllSuperTypes()) {
					List<EClass> cls = subclasses.get(superClass);
					if (cls == null) {
						subclasses.put(superClass, cls = new ArrayList<EClass>());
					}
					cls.add(cl);
				}
			}
		}
	} 

	@Override
	public EClass getEClass(String className) {
		return eclasses.get(className);
	}

	@Override
	public Collection<EClass> getSubclasses(EClass forClass) {
		return subclasses.getOrDefault(forClass, Collections.emptyList());
	}


	@Override
	public Collection<EClass> getEClasses() {
		return eclasses.values();
	}

	@Override
	public Collection<EEnum> getEEnums() {
		return eenums.values();
	}

}

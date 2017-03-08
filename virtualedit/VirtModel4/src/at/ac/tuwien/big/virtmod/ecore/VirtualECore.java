package at.ac.tuwien.big.virtmod.ecore;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;

public interface VirtualECore<A> {
	
	public default String getName(EClass cl) {
		return cl.getName();
	}
		
	public EClass getEClass(String className);
	
	public Collection<EClass> getSubclasses(EClass forClass);
	
	public Collection<EClass> getEClasses();

	public Collection<EEnum> getEEnums();

}

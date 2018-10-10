package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import at.ac.tuwien.big.vfunc.nbasic.constraint.ObjectCreatorGenerator;
import at.ac.tuwien.big.virtlang.virtLang.ObjectCreator;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource;
import at.ac.tuwien.big.xmlintelledit.intelledit.ecore.util.MyResource.EcoreInfo;
import at.ac.tuwien.big.xtext.util.MyEcoreUtil;

public class IdentifierGenerator {
	
	private Map<EClass, List<ObjectCreatorCreator>> creators = new HashMap<>();
	private EObjectManager emanager;
	private Map<EClass, List<ObjectCreatorCreator>> allCreators = new HashMap<>();
	
	public IdentifierGenerator(EObjectManager emanager) {
		this.emanager = emanager;
		for (EObjectCreator creator: this.emanager.getECreators()) {
			if (creator instanceof ObjectCreatorCreator) {
				ObjectCreatorCreator occ = (ObjectCreatorCreator)creator;
				EClass targetClass = occ.getTargetClass();
				this.creators.computeIfAbsent(targetClass, x->new ArrayList<>()).add(occ);
			}
		}
	}
	
	public List<ObjectCreatorCreator> getAllCreators(EClass targetType) {
		return this.allCreators.computeIfAbsent(targetType, (tt)->{
		List<EClass> everything = new ArrayList<>(tt.getEAllSuperTypes());
		everything.add(tt);
		List<ObjectCreatorCreator> ret = new ArrayList<>();
		for (EClass et: everything) {
			ret.addAll(this.creators.getOrDefault(et, Collections.emptyList()));
		}
		return ret;}
		);
	}
	
	public void knowPackage(EPackage epkg) {
		EcoreInfo einfo = MyResource.getOrBuildEcoreInfo(epkg);
		for (EClass cl: einfo.getKnownClasses()) {
			
		}
		einfo.getInstanciableTypes(from)
	}

}

package at.ac.tuwien.big.vfunc.nbasic.wrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vfunc.nbasic.ecore.EObjectManager;
import at.ac.tuwien.big.vfunc.nbasic.xtext.CompleteFileHandler;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.structure.VContainer;
import at.ac.tuwien.big.virtmod.structure.VObjectProxy;
import at.ac.tuwien.big.virtmod.structure.impl.VDeltaContainer;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.EcoreFuncUtil;
import at.ac.tuwien.big.vmod.ecore.VFeatureValues;
import at.ac.tuwien.big.vmod.ecore.VMEObject;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.VObjectValues;
import at.ac.tuwien.big.vmod.impl.EcoreModelResourceUtil;
import at.ac.tuwien.big.xtext.annotation.SourcedEObject;

public class SimpleModelView implements VModelView {
	
	private CompleteFileHandler cfh;
	
	public SimpleModelView(CompleteFileHandler cfh) {
		this.cfh = cfh;		
		initModelForEdit();
	}

	@Override
	public EReference getContainingFeature(Symbol uuid) {
		String featName = getInstances().getContainingFeature(uuid);
		return (EReference)getEcore().getFeature(featName);
	}	

	@Override
	public Symbol getContainingObjectUuid(Symbol uuid) {
		return getInstances().getContainingObject(uuid);
	}
	
	
	@Override
	public VMEObject getEObject(Symbol uuid) {
		VMEObject ret = this.containedObjects.get(uuid);
		if (ret == null) {
			this.containedObjects.put(uuid, ret = new SimpleVMEObject(this,uuid));
		}
		return ret;
	}
	
	

	@Override
	public ModelProvider getMainProvider() {
		return this.prov;
	}

	@Override
	public void reload() {
		this.instances = null;
		this.featureValuesCache = new HashMap<>();
	}

	@Override
	public void selfClear() {
		Set<Symbol> allInstances = new HashSet<>();
		for (Symbol str: getInstances()) {
			allInstances.add(str);
		}
		for (EStructuralFeature feat: this.ecoreFile.getAllFeatures()) {
			getFeatureValues(feat).clear();
		}
		getInstances().nullifyClear();
	}

	@Override
	public String toString() {
		return printModel();
	}

	

}

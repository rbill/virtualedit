package at.ac.tuwien.big.vmod.registry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import at.ac.tuwien.big.autoedit.test.OclExtractor;
import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmod.impl.EcoreModelResource;
import at.ac.tuwien.big.vmod.provider.DerivationModelProvider;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.provider.SimpleModelProvider;
import at.ac.tuwien.big.vmod.provider.impl.SimpleDeltaModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.SimpleEcoreModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl;
import at.ac.tuwien.big.vmod.provider.impl.TransformationModelProviderImpl.TransformationExecutor;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;
import at.ac.tuwien.big.vmod.type.impl.ModelProviderTypeImpl;
import at.ac.tuwien.big.vmod.type.impl.SymbolRegistryTypeImpl;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;
import at.ac.tuwien.big.vmodel.ecore.impl.VEcoreFileImpl;
import at.ac.tuwien.big.xtext.equalizer.InstanceCreator;
import at.ac.tuwien.big.xtext.equalizer.ModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelCorrespondance;
import at.ac.tuwien.big.xtext.equalizer.impl.SimpleModelEqualizer;
import at.ac.tuwien.big.xtext.util.IteratorUtils;

public class MultiResourceSetInfo {
	private MultiLoader loader;
	
	private boolean changeDone;
	
	public ResourceSet getResourceSet() {
		return loader.getResourceSet();
	}
	

	
	public Collection<ModelResource> userInfoResources() {
		return loader.getModelResources();
	}
	
	
	
	/**A change is done: If a resource is saved or a resource has been changed on disk (?)*/
	public void setChangeDone(boolean changeDone) {
		this.changeDone = changeDone;
	}
	
	public Resource getEcoreResource() {
		return loader.getEcoreResource();
	}
	
	private static WeakHashMap<MultiLoader,MultiResourceSetInfo> resourceSetMap = new WeakHashMap<>();
	
	public static MultiResourceSetInfo getResourceSetInfo(MultiLoader loader) {
		MultiResourceSetInfo ret = resourceSetMap.get(loader);
		if (ret != null) {
			if (!Objects.equals(ret.getEcoreResource(), loader.getEcoreResource())) {
				System.err.println("Non-matching ecore resource for resource info: "+ret.getEcoreResource()+" VS "+loader.getEcoreResource());
			}
		} else {
			resourceSetMap.put(loader, ret = new MultiResourceSetInfo(loader));
		}
		return ret;
	}
	
	public MultiResourceSetInfo(MultiLoader loader) {
		this.loader = loader;
		this.viewState = createDefaultViewState();
	}
	
	
	public ViewState createDefaultViewState() {
		ViewStateImpl ret = new ViewStateImpl();
		for (ModelProvider prov: loader.getProviders()) {
			ret.addToView(loader.getResource(prov));
		}
		return ret;
	}
	
	public void setShownResources(List<Resource> res) {
		viewState.setShownViews(res);
	}
	
	public ViewState getContainedViewState() {
		return viewState;
	}
	
	private ViewState viewState;
	
	
	
	public List<Resource> getAllViews() {
		List<Resource> ret  = new ArrayList<Resource>();
		for (ModelProvider prov: loader.getProviders()) {
			Resource r = loader.getResource(prov);
			if (r != null) {
				ret.add(r);
			}
		}
		return ret;
	}

	

}

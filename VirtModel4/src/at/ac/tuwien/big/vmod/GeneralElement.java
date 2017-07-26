package at.ac.tuwien.big.vmod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.eclipse.emf.ecore.resource.Resource;

import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.SymbolRegistry;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolRegistryType;

public interface GeneralElement  {
	
	public GeneralType getType();
	
	public Object getMetaInfo(String key);
	
	public default Object get(String key) {
		return getMetaInfo(key);
	}
	
	public default String getPath() {
		ParentLocation pl = getParentLoc();
		if (pl == null) {
			return "";
		}
		return pl.getParent().getPath()+"##"+pl.getValue();
	}
	

	
	public default ExactDerivationStatus getDerivationStatus(Collection<ModelResource> userModelResources) {
		ExactDerivationStatus ret = new ExactDerivationStatus();
		getDerivationStatus(userModelResources,ret);
		return ret;
	}
	
	public default GeneralElement getParent() {
		ParentLocation pl = getParentLoc();
		if (pl == null) {
			return null;
		}
		return pl.getParent();
	}
	
	public ParentLocation getParentLoc();
	
	public void setParentLoc(ParentLocation parent);
	
	public default List<Symbol> getAllSymbols() {
		List<Symbol> ret = new ArrayList<Symbol>();
		GeneralElement cur = this;
		while (cur != null) {
			ParentLocation pl = cur.getParentLoc();
			if (pl == null) {break;}
			Object o = pl.getValue();
			if (o instanceof Symbol) {
				ret.add((Symbol)o);
			}
			cur = pl.getParent();
		}
		return ret;
	}
	
	public default Resource getFakeResource() {
		ModelProvider prov= getProvider();
		if (prov == null) {
			return null;
		}
		return prov.getFakeResource();
	}
	
	public default ModelProvider getUserEditProvider() {
		return getUserEditProvider(Collections.emptyList());
	}
	
	public default ModelProvider getUserEditProvider(Iterable<? extends GeneralElement> additionalElements) {
		List<Symbol> allUsedObjects = new ArrayList<>();
		allUsedObjects.addAll(getAllSymbols());
		for (GeneralElement el: additionalElements) {
			allUsedObjects.addAll(el.getAllSymbols());
		}
		SymbolRegistry registry = getRegistry();
		List<ModelProvider> allProvs = new ArrayList<>();
		for (Symbol sb: allUsedObjects) {
			ModelProvider prov = registry.getProvider(sb);
			if (prov != null) {
				allProvs.add(prov);
			}
		}
		ModelProvider userEdit = ModelProvider.getTopmostOrNull(allProvs);
		if (userEdit == null) {
			//Hier muss man was tun ... nimm überhaupt das letzte
			System.err.println("Cannot find topmost provider");
			userEdit = ModelProvider.getBottommostOrNull(allProvs);
		}
		if (userEdit == null) {
			//Assume you are in this!
			return getProvider();
		}
		return userEdit;
	}
	
	public default ModelProvider getTransformationEditProvider() {
		return getProvider();
	}
	
	public default boolean isUserEditObject(ModelProvider prov) {
		ModelResource res = getResource();
		/*ModelProvider provider = res.getProvider();
				
		if (!prov.equals(provider)) {
			return false;
		}*/
		ModelResource userEdit = prov.getUserEditModel();
		if (!userEdit.equals(res)) {
			return false;
		}
		return true;
	}
	
	public default ModelResource getResource() {
		GeneralElement parent = getParent();
		if (parent == null) {
			return null;
		}
		return getParent().getResource();
	}
	
	public default ModelProvider getProvider() {
		ModelResource res = getResource();
		if (res == null) {
			return null;
		}
		return res.getProvider();
	}
	
	public default ModelResource getEditModel() {
		ModelProvider provider = getProvider();
		if (provider == null) {
			return null;
		}
		return provider.getEditModel();
	}
	
	public default SymbolRegistry getRegistry() {
		ModelProvider provider = getProvider();
		if (provider == null) {
			return null;
		}
		return provider.getRegistry();
	}
	
	public void clear();
	
	public static final GeneralElement NO_ELEMENT = new GeneralElement() {
		
		@Override
		public GeneralType getType() {
			return GeneralType.NO_TYPE;
		}
		
		@Override
		public Object getMetaInfo(String key) {
			return NO_ELEMENT;
		}
		
		@Override
		public ParentLocation getParentLoc() {
			return null;
		}
		
		@Override 
		public ModelResource getResource() {
			return ModelResource.DEFAULT_ELEMENTS;
		}
		
		@Override
		public void setParentLoc(ParentLocation parent) {
			//do nothing
		}
		
		@Override
		public void clear() {
			
		}

		public void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status){}

		@Override
		public boolean setValue(GeneralElement e) {
			return this==e;
		}
	};

	public void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status);
	
	/**Return: successful?*/
	public boolean setValue(GeneralElement e);


}

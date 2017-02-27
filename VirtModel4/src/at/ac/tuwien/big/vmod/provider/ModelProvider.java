package at.ac.tuwien.big.vmod.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ecore.VModelView;
import at.ac.tuwien.big.vmod.ecore.impl.SimpleModelView;
import at.ac.tuwien.big.vmod.registry.SymbolRegistry;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.ModelProviderType;
import at.ac.tuwien.big.vmod.type.ModelResourceType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;
import at.ac.tuwien.big.vmod.type.SymbolRegistryType;
import at.ac.tuwien.big.vmodel.ecore.VEcoreFile;

public interface ModelProvider extends GeneralElement {
	
	public ModelResource getResultModel();
	
	public ModelResource getUserEditModel();
	
	public List<ModelProvider> getPrevious();
	
	public default List<ModelResource> getUserEditModels() {
		List<ModelResource> ret = new ArrayList<>();
		priv_getUserEditResources(new HashSet<>(), ret);
		return ret;
	}
	
	public default void priv_getUserEditResources(Collection<ModelProvider> parsed, Collection<ModelResource> userEditModel) {
		if (parsed.add(this)) {
			userEditModel.add(getUserEditModel());
		}
		for (ModelProvider prev: getPrevious()) {
			prev.priv_getUserEditResources(parsed, userEditModel);
		}
	}
	
	public default VModelView simpleModelView(VEcoreFile ecore) {
		return new SimpleModelView(this, ecore);
	}
	
	public default void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status) {
		//Do ntohing
	}
	
	/**This function does also change the output resource! Only "Simple" inputs stay the same*/
	public ModelProvider withRedirectedInput(List<ModelProvider> newInputs);
	
	public static int[] index = new int[1];
	
	public default Symbol newSymbol() {
		SymbolImpl ret = new SymbolImpl();
		ret.setName(getSymbolName());
		ret.subObjects().add(Symbol.from("Object"+(++index[0])));
		return ret;
	}
	
	public int getIndex();
	
	public void setIndex(int index);
	
	public default void getAllPreviousAndSame(Set<ModelProvider> prov) {
		if (prov.add(this)) {
			for (ModelProvider prev: getPrevious()) {
				prev.getAllPreviousAndSame(prov);
			}
		}
	}
	
	public default Set<ModelProvider> getAllPreviousAndSame() {
		Set<ModelProvider> ret = new HashSet<>();
		getAllPreviousAndSame(ret);
		return ret;
	}
	
	public static ModelProvider getTopmostOrNull(Iterable<ModelProvider> prov) {
		List<ModelProvider> mustContain = new ArrayList<>();
		for (ModelProvider pr: prov) {
			mustContain.add(pr);
		}
		List<ModelProvider> candidate = new ArrayList<>();
		for (ModelProvider pr: prov) {
			if (pr.getAllPreviousAndSame().containsAll(mustContain)) {
				candidate.add(pr);
			}
		}
		if (!candidate.isEmpty()) {
			return candidate.get(0);
		}
		return null;
	}
	
	public static ModelProvider getBottommostOrNull(Iterable<ModelProvider> prov) {
		List<ModelProvider> mustContain = new ArrayList<>();
		for (ModelProvider pr: prov) {
			mustContain.add(pr);
		}
		List<ModelProvider> candidate = new ArrayList<>(mustContain);
		for (ModelProvider pr: prov) {
			candidate.retainAll(pr.getAllPreviousAndSame());
		}
		if (!candidate.isEmpty()) {
			return candidate.get(0);
		}
		return null;
	}
	
	@Override
	public default void clear() {
		getResultModel().clear();
	}
	
	
	 
	public String getSymbolName();
	
	public SymbolRegistry getParent();
	
	public default SymbolRegistry getRegistry() {
		return getParent();
	}
	
	public ModelProviderType getType();


}

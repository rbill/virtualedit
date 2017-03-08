package at.ac.tuwien.big.vmod.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.impl.ParentLocationImpl;
import at.ac.tuwien.big.vmod.impl.SimpleGeneralElement;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolRegistryType;

public class SymbolRegistryImpl extends SimpleGeneralElement<SymbolRegistryType> implements SymbolRegistry {

	public SymbolRegistryImpl(SymbolRegistryType type) {
		super(type);
	}
	
	private Map<String,ModelProvider> modelProviders = new HashMap<>();
	private List<ModelProvider> provider = new ArrayList<ModelProvider>();

	@Override
	public void clear() {
		//TODO: ??? or: Delete every content
		modelProviders.clear();
	}
	
	@Override
	public void removeProviders(Iterable<? extends ModelProvider> providers) {
		for (ModelProvider prov: providers) {
			provider.remove(prov);
			modelProviders.remove(prov.getSymbolName(), prov);
		}
	}

	@Override
	public ModelProvider getProvider(Symbol forSymbol) {
		String key = forSymbol.getName();
		return modelProviders.get(key);
	}

	@Override
	public void addProvider(ModelProvider res) {
		
		ModelProvider untilNow = modelProviders.put(res.getSymbolName(), res);
		if (untilNow != res) {
			provider.remove(res);
			provider.add(res);
		}
		res.setParentLoc(new ParentLocationImpl(this, res.getSymbolName(), res));
	}

	@Override
	public int getIndexFor(ModelProvider provider) {
		int ret = this.provider.indexOf(provider);
		if (ret == -1) {
			System.err.println("Provider not found! Please add provider before setting parent?!");
			ret = this.provider.size(); //Assume provider will be added next
		}
		return ret;
	}
	
	

}

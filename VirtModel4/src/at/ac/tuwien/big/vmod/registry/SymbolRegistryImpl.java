package at.ac.tuwien.big.vmod.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import at.ac.tuwien.big.vmod.GeneralElement;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.impl.ParentLocationImpl;
import at.ac.tuwien.big.vmod.impl.SimpleGeneralElement;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.GeneralType;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;
import at.ac.tuwien.big.vmod.type.SymbolRegistryType;

public class SymbolRegistryImpl extends SimpleGeneralElement<SymbolRegistryType> implements SymbolRegistry {

	public SymbolRegistryImpl(SymbolRegistryType type) {
		super(type);
	}
	
	private Map<Symbol,ModelProvider> modelProviders = new HashMap<>();
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
			modelProviders.remove(prov.getMainSymbol(), prov);
		}
	}

	@Override
	public ModelProvider getProvider(Symbol forSymbol) {
		//TODO: Irgendwie muss ich das mit dem Main-symbol anders lösen ...
		SymbolImpl fakeSymbol = new SymbolImpl();
		fakeSymbol.setName(forSymbol.getName());
		fakeSymbol.subObjects().addAll(forSymbol.subObjects());
		ModelProvider ret = modelProviders.get(forSymbol);
		if (ret != null) {
			return ret;
		}
		for (int j = fakeSymbol.subObjects().size()-1; j >= 0; --j) {
			fakeSymbol.subObjects().remove(j);
			ret = modelProviders.get(forSymbol);
			if (ret != null) {
				return ret;
			}
		}
		return null;
	}

	@Override
	public void addProvider(ModelProvider res) {
		
		ModelProvider untilNow = modelProviders.put(res.getMainSymbol(), res);
		if (untilNow != res) {
			provider.remove(res);
			provider.add(res);
		}
		res.setParentLoc(new ParentLocationImpl(this, res.getMainSymbol(), res));
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

	@Override
	public boolean setValue(GeneralElement e) {
		System.err.println("Cant't set value of Symbol Registry");
		return false;
	}
	
	

}

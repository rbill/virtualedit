package at.ac.tuwien.big.vmod.impl;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.DeltaBuilt;
import at.ac.tuwien.big.vmod.ModelResource;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.type.CountType;

public class UnionCounter extends SimpleUnionGeneralElement<CountType, Counter, Counter> implements Counter, DeltaBuilt<Counter,Counter> {
	
	public UnionCounter(CountType type, Counter base, Counter edit, boolean isUserEdit) {
		super(type,base,edit,isUserEdit);
	}
	
	public Counter getLastPositive() {
		int val = getValue();
		Counter edit = getEdit();
		if (edit instanceof UnionCounter) {
			UnionCounter uc = (UnionCounter)edit;
			Counter ret = uc.getLastPositive();
			if (ret != null) {
				return ret;
			}
		} else {
			if (edit.getValue() > 0) {
				return edit;
			}
		}
		Counter base = getBase();
		if (base instanceof UnionCounter) {
			UnionCounter uc = (UnionCounter)base;
			return uc.getLastPositive();
		} else {
			if (base.getValue() > 0) {
				return base;
			}
		}
		if (val > 0) {
			return this;
		}
		return null;
	}

	public Counter getLastNegative() {
		int val = getValue();

		Counter edit = getEdit();
		if (edit instanceof UnionCounter) {
			UnionCounter uc = (UnionCounter)edit;
			Counter ret = uc.getLastNegative();
			if (ret != null) {
				return ret;
			}
		} else {
			if (edit.getValue() < 0) {
				return edit;
			}
		}
		Counter base = getBase();
		if (base instanceof UnionCounter) {
			UnionCounter uc = (UnionCounter)base;
			return uc.getLastNegative();
		} else {
			if (base.getValue() < 0) {
				return base;
			}
		}
		if (val < 0) {
			return this;
		}
		return null;
	}
	
	@Override
	public void editAdd(int value) {
		if (value != 0) {
			if (isUserEdit()) {
				List<Counter> toAdd = new ArrayList<>();
				if (value < 0) {
					//If you delete an object, you must be later than the last addition
					Counter add = getLastPositive();
					if (add != null && add != this) {
						toAdd.add(add);
					}
				} else {
					//If you add an object, you must be later than the last deletion
					Counter add = getLastNegative();
					if (add != null && add != this) {
						toAdd.add(add);
					}
				}
				ModelProvider prov = getUserEditProvider(toAdd);
				Counter editO = (Counter)getObjectInProvider(prov);
				System.out.println("Adding "+value+" in " + getParentLoc().getValue()+" to counter "+getPath()+" in editProvider "+editO.getProvider().getSymbolName());
				editO.editAdd(value);
			} else {
				Counter editO = getEditObject();
				System.out.println("Adding "+value+" in " + getParentLoc().getValue()+" to counter "+getPath()+" in editProvider "+editO.getProvider().getSymbolName());
				editO.editAdd(value);
			}
		}
	}

	@Override
	public int getValue() {
		return getBase().getValue()+getEdit().getValue();
	}

	@Override
	public void priv_getNonnullProvider(List<ModelProvider> prov) {
		getBase().priv_getNonnullProvider(prov);
		getEdit().priv_getNonnullProvider(prov);
	}

	@Override
	public void priv_getNonnullResources(List<ModelResource> prov) {
		if (getValue() != 0) {
			//?? don't know whether it should add it or not if this has 0, but the bottom elements maybe not
			//I think I should add it
		}
		getBase().priv_getNonnullResources(prov);
		getEdit().priv_getNonnullResources(prov);
	}

}

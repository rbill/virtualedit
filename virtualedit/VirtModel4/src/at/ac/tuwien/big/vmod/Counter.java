package at.ac.tuwien.big.vmod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import at.ac.tuwien.big.vmod.provider.ModelProvider;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;
import at.ac.tuwien.big.vmod.type.CountType;

/**Im wesentlichen IntegerValueElement*/
public interface Counter extends GeneralElement {
	

	public default void getDerivationStatus(Collection<ModelResource> userModelResources, ExactDerivationStatus status) {
		List<ModelResource> myResources = getNonnullResources();
		for (ModelResource my: myResources) {
			if (userModelResources.contains(my)) {
				status.addUserProvider(my, null); //TODO: What is the value?
			} else {
				status.addTransformationProvider(my, null); //TODO: What is the value?
			}
		}
	}
	
	@Override
	public CountType getType();
	
	public void editAdd(int value);
	
	public int getValue();
	
	public default boolean exists() {
		return getValue()>0;
	}
	
	
	public default void clear() {
		set(0);
	}
	

	public default void nullify() {
		set(0);
	}
	
	public default void set(int value) {
		editAdd(value-getValue());
	}

	public default boolean setMax(int i) {
		if (getValue()>i) {
			set(i);
			return true;
		} else {
			return false;
		}
	}
	
	public default boolean setMin(int i) {
		if (getValue()<i) {
			set(i);
			return true;
		}
		return false;
	}
	

	public default List<ModelResource> getNonnullResources() {
		List<ModelResource> ret = new ArrayList<ModelResource>();
		priv_getNonnullResources(ret);
		return ret;
	}
	
	public default List<ModelProvider> getNonnullProvider() {
		List<ModelProvider> ret = new ArrayList<ModelProvider>();
		priv_getNonnullProvider(ret);
		return ret;
	}
	
	public void priv_getNonnullProvider(List<ModelProvider> prov);
	
	public void priv_getNonnullResources(List<ModelResource> prov);

}

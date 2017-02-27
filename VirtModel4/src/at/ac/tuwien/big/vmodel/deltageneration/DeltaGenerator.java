package at.ac.tuwien.big.vmodel.deltageneration;

import at.ac.tuwien.big.vmodel.ecore.VModelView;

public interface DeltaGenerator {
	
	public void applyChanges(VModelView baseModel, VModelView editModel, VModelView deltaModel);
	
	public default void regenerateDelta(VModelView baseModel, VModelView editModel, VModelView deltaModel) {
		System.out.println("Model before clearing: "+deltaModel);
		System.out.println("Edit model before clearing: "+editModel);
		editModel.selfClear();
		System.out.println("Model after clearing: "+deltaModel);
		System.out.println("Edit model after clearing: "+editModel+"\nEND");
		applyChanges(baseModel,editModel,deltaModel);
		System.out.println("Model after change application: "+deltaModel);
	}

}

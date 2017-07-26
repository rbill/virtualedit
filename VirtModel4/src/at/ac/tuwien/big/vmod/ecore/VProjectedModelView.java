package at.ac.tuwien.big.vmod.ecore;

import at.ac.tuwien.big.verocl.parameterdesc.MultiModelPoint;
import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;

public interface VProjectedModelView extends VModelView, Projected<VProjectedModelView, MultiPoint> {

	public MultiModelPoint getProjection();
}

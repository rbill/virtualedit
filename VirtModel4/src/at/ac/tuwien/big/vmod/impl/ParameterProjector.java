package at.ac.tuwien.big.vmod.impl;

import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.Points;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;

public class ParameterProjector implements Projector<MultiPoint, SinglePoint> {

	@Override
	public MultiPoint project(MultiPoint src, MultiPoint add) {
		MultiPoint ret = src.intersectWithOrSame(add);
		return ret;
	}

}

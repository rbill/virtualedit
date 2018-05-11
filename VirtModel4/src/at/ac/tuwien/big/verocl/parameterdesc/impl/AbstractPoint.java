package at.ac.tuwien.big.verocl.parameterdesc.impl;

import at.ac.tuwien.big.verocl.parameterdesc.MultiPoint;
import at.ac.tuwien.big.verocl.parameterdesc.PointDesc;
import at.ac.tuwien.big.verocl.parameterdesc.Points;
import at.ac.tuwien.big.verocl.parameterdesc.SinglePoint;

public abstract class AbstractPoint implements Points {
	
	private PointDesc desc;
	
	public AbstractPoint(PointDesc desc) {
		this.desc = desc;
	}

	@Override
	public PointDesc getDesc() {
		return desc;
	}
	


	@Override
	public abstract boolean contains(Object[] pointValues);
	
	
	

}

package at.ac.tuwien.big.vfunc.nbasic;

import at.ac.tuwien.big.vfunc.basic.Value;

public interface QueryResult<Source,Target> extends  WeakObject<Source>, Value<Target> {

	public MetaInfo getMetaInfo();
}

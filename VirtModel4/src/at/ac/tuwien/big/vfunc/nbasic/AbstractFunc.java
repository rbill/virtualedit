package at.ac.tuwien.big.vfunc.nbasic;

import java.util.function.Function;

public class AbstractFunc<Src,Target> {

	
	private QueryResultCache<Src,QueryResult<Src,Target>> cache;
	private Function<Src,Target> func;
	
	public AbstractFunc(Function<Src,Target> func) {
		this.func = func;
		this.cache = new QueryResultCache<Src,QueryResult<Src,Target>>(func);
	}
	
}

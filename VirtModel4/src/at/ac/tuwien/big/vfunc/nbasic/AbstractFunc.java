package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Objects;
import java.util.function.Function;

public class AbstractFunc<Src,Target, QR extends QueryResult<Src, Target>> {

	
	private QueryResultCache<Src,QueryResult<Src,Target>> cache;
	private Function<Src,BasicResult<Target>> func;
	
	
	public AbstractFunc(Function<Src,BasicResult<Target>> func) {
		this.func = func;
		Function<Src, BasicQueryResult<Src, Target>> sfunc = (src)->{
			BasicResult<Target> result = this.func.apply(src);
			BasicQueryResult<Src, Target> queryResult = new BasicQueryResult<>(this.cache, src, result);
			return queryResult;
		};
		this.cache = new QueryResultCache<Src,QueryResult<Src,Target>>(sfunc);
	}
	
	protected void updateCache(Src src, Target newValue) {
		QueryResult<Src, Target> result = cache.getIfExists(src);
		if (result instanceof BasicQueryResult) {
			BasicQueryResult<Src, Target> bqr = (BasicQueryResult)result;
			BasicResult<Target> br = bqr.getResult();
			Target oldValue = br.value();
			if (!Objects.equals(oldValue, newValue)) {
				br.setValueRaw(newValue);
				br.notifyChanged(oldValue, newValue);
			}
		} 
	}
	
	public QueryResult<Src, Target> evaluate(Src src) {
		return this.cache.get(src);
	}
	
}

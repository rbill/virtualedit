package at.ac.tuwien.big.vfunc.nbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Scope;

public class TransformedFilteredFunction<Src, Target, BaseTarget, QR extends QueryResult<Src, Target>> extends AbstractFunc<Src, Target, QR> {

	public TransformedFilteredFunction(AbstractFunc<Src, BaseTarget, QueryResult<Src,BaseTarget>> base, Function<BaseTarget, Target> conversion) {
		
		Function<List<Src>, Target> tfunc = (srcList)->{
			Src theSrc = srcList.isEmpty()?null:srcList.get(0);
			BaseTarget trg = base.apply(theSrc);
			if (trg == null) {
				return null;
			}
			return conversion.apply(trg);
		} ;
		
		Function<Src, BasicResult<Target>> func = (src)->{
			QueryResult<Src, BaseTarget> basicTarget = base.evaluate(src);			
			
			List<? extends BasicValuedChangeNotifyer<? extends Src>> sources = new ArrayList<>();
			BasicResult<Target> result = new OperationBasedResult<Src, Target>(tfunc, sources , basicTarget.getMetaInfo());
			QueryResultCache<Src, ? extends WeakObject<Src>> container;
			//I can we copy the meta-info?
			BasicQueryResult<Src, Target> bqr = new BasicQueryResult<Src, Target>(container, src, result);
		};
		
		init(func, null);
	}
	
	@Override
	public Scope<Src> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

}

package at.ac.tuwien.big.vfunc.nbasic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.basic.impl.AbstractFiniteScope;

public class BasicMapFunc<Src, Target> extends AbstractFunc<Src, Target, QueryResult<Src,Target>> {

	private Map<Src, BasicResult<Target>> resultMap = new HashMap<>();
	private Class<Src> sourceClass;
	
	public BasicMapFunc(Class<Src> sourceClass) {
		this.sourceClass = sourceClass;
		init((src)->{
			BasicResult<Target> basicResult = resultMap.get(src);
			if (basicResult == null) {
				return createResult(src);
			} else {
				return basicResult;
			}
		},null); //a direct initialization is possible
	}
	
	private FixedFinitScope<Src> myScope = new AbstractFiniteScope<Src>() {

		@Override
		public Iterator<Src> iterator() {
			return resultMap.keySet().iterator();
		}

		@Override
		public boolean contains(Src src) {
			return resultMap.containsKey(src);
		}

		@Override
		public Class<Src> getSourceClass() {
			return sourceClass;
		}
	};
	
	private BasicResult<Target> createResult(Src src) {
		MetaInfo mi = new BasicMetaInfo();
		ConstantBasicResult<Target> br = new ConstantBasicResult<Target>(mi);
		//br.setValue(target);
		return br;
	}
	
	public void putBasic(Src src, Target trg) {
		BasicResult<Target> curResult = resultMap.get(src);
		if (curResult != null) {
			curResult.setValue(trg);
			if (trg == null) {
				resultMap.remove(src);
				myScope.notifyDeleted(src);
			}
		} else {
			if (trg == null) {
				//Ignore - we don't have anything and don't want anything
			} else {
				//Check if there is something in the cache
				curResult = createResult(src);
				resultMap.put(src, curResult);
				curResult.setValue(trg);
				QueryResult<Src, Target> qr = getCacheIfExists(src);
				if (qr != null) {
					if (qr instanceof BasicQueryResult) {
						BasicQueryResult<Src, Target> bqr = (BasicQueryResult)qr;
						bqr.setResult(curResult);
					} else {
						throw new RuntimeException("Strange QueryResult!");
					}
				}
				myScope.notifyAdded(src);
				
			}
		}
	}
 
	@Override
	public Scope<Src> getScope() {
		return myScope;
	}


	public SetValueModificator<AbstractFunc<Src,Target,?>, Src, Target> getModificator() {
		return new SetValueModificator<AbstractFunc<Src,Target,?>, Src, Target>() {

			@Override
			public void setValue(AbstractFunc<Src, Target, ?> func, Src src, Target newValue) {
				putBasic(src, newValue);
			}
		};
	}
}

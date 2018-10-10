package at.ac.tuwien.big.vfunc.nbasic;

import java.util.Collections;
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
	
	private FixedFinitScope<Src> myScope = new AbstractFiniteScope<Src>() {

		@Override
		public boolean contains(Src src) {
			return BasicMapFunc.this.resultMap.containsKey(src);
		}

		@Override
		public Class<Src> getSourceClass() {
			return BasicMapFunc.this.sourceClass;
		}

		@Override
		public Iterator<Src> iterator() {
			return BasicMapFunc.this.resultMap.keySet().iterator();
		}
	};
	
	public BasicMapFunc(Class<Src> sourceClass) {
		this.sourceClass = sourceClass;
		init((src)->{
			BasicResult<Target> basicResult = this.resultMap.get(src);
			if (basicResult == null) {
				return createResult(src);
			} else {
				return basicResult;
			}
		},null); //a direct initialization is possible
	}
	
	private BasicResult<Target> createResult(Src src) {
		MetaInfo mi = createMetaInfo(src);
		ConstantBasicResult<Target> br = new ConstantBasicResult<>(mi);
		//br.setValue(target);
		return br;
	}
	
	@Override
	public SetValueModificator<AbstractFunc<Src,Target,?>, Src, Target> getModificator() {
		return new SetValueModificator<AbstractFunc<Src,Target,?>, Src, Target>() {

			@Override
			public void setValue(AbstractFunc<Src, Target, ?> func, Src src, Target newValue) {
				putBasic(src, newValue);
			}

			@Override
			public void unsetValue(AbstractFunc<Src, Target, ?> func, Src src) {
				putBasic(src, null);
			}
		};
	}
 
	@Override
	public Scope<Src> getScope() {
		return this.myScope;
	}


	public void putBasic(Src src, Target trg) {
		BasicResult<Target> curResult = this.resultMap.get(src);
		if (curResult != null) {
			curResult.setValue(trg);
			if (trg == null) {
				this.resultMap.remove(src);
				this.myScope.notifyDeleted(src);
			}
		} else {
			if (trg == null) {
				//Ignore - we don't have anything and don't want anything
			} else {
				//Check if there is something in the cache
				curResult = createResult(src);
				this.resultMap.put(src, curResult);
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
				this.myScope.notifyAdded(src);
				
			}
		}
	}

}

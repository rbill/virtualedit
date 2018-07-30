package at.ac.tuwien.big.vfunc.nbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.nbasic.DependentResultDesc.DependentResult;
import at.ac.tuwien.big.vfunc.nbasic.DependentResultDesc.ResultSlot;

public class FixPointFunc<Src,  QR extends QueryResult<Src, Src>> extends AbstractFunc<Src, Src, QR> {

	private AbstractFunc<Src, Src, QueryResult<Src,Src>> baseFunc;
	
	
	
	
	public FixPointFunc(AbstractFunc<Src, Src, QueryResult<Src,Src>> baseFunc) {
		this.baseFunc = baseFunc;
		
		//Problem: Actually the second parameter is dependent on the first ...
		DependentResultDesc<Src> dpd = new DependentResultDesc<Src>();
		List<DependentResultDesc.ResultSlot<?>> dependentSlots = new ArrayList<>();
		DependentResultDesc.ResultSlot<Src> inputSlot = DependentResultDesc.createInputSlot();
		dependentSlots.add(inputSlot);
		Function<Object[], QueryResult<Src,Src>> calculationFunc = (src)->this.baseFunc.evaluate((Src)src[0]);
		ResultSlot<Src> evaluationSlot = dpd.createIntermediateDesc(dependentSlots, calculationFunc);
		List<DependentResultDesc.ResultSlot<?>> resultSlots = new ArrayList<>();
		resultSlots.add(inputSlot);
		resultSlots.add(evaluationSlot);
		//Das QueryResult muss mein eigenes sein
		
		Function<Object[], Src> resultFunc = (objs)->{
			
			QueryResult<Src,Src> prev = this.evaluate((Src)objs[1]);
			if (prev == null || prev.value() == null) {
				//Hier brauche ich eigentlich das QueryResult, das dazu gefuehrt hat
				return (Src)objs[1];
			} else {
				return prev.value();
			}
		};
		ResultSlot<Src> targetSlot = dpd.createFinalDesc(resultSlots, resultFunc);
		dpd.finish(targetSlot);
		
		
		Function<Src, BasicResult<Src>> func = (src)->dpd.getResult(baseFunc.evaluate(src).getMetaInfo(), src, false);
		
		BiFunction<? super Src, ? super QueryResult<Src, Src>, ? extends Src> valueUpdater = (src,qr)-> {
			if (qr instanceof BasicQueryResult) {
				BasicQueryResult<Src,Src> bqr = (BasicQueryResult<Src, Src>)qr;
				BasicResult<Src> result = bqr.getResult();
				if (result instanceof DependentResult ) {
					DependentResultDesc<Src>.DependentResult<Src> bri = (DependentResultDesc<Src>.DependentResult<Src>)result;
					return bri.calcValue();
				} else {
					throw new RuntimeException("Excepted DependentResult, got " + result+"!");
				}
			} else {
				new Exception().printStackTrace();
				throw new UnsupportedOperationException();
			}
			
		};
		
		init(func , valueUpdater);
	}
	
	@Override
	public Scope<Src> getScope() {
		return baseFunc.getScope();
	}

}

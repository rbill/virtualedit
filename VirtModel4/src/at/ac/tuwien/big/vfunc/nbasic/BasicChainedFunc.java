package at.ac.tuwien.big.vfunc.nbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.nbasic.DependentResultDesc.ResultSlot;

//Assumes that Second function is total
public class BasicChainedFunc<Src, Mid, Target, QR extends QueryResult<Src,Target>> extends AbstractFunc<Src, Target, QR> {

	private AbstractFunc<Src, Mid,  ? extends QueryResult<Src, Mid>> first;
	private AbstractFunc<Mid, Target, ? extends QueryResult<Mid,Target>> second;
	
	
	public BasicChainedFunc(AbstractFunc<Src, Mid,  ? extends QueryResult<Src, Mid>> first, AbstractFunc<Mid, Target, ? extends QueryResult<Mid,Target>> totalSecond) {
		this.first = first;
		this.second = totalSecond;
		DependentResultDesc<Target> dpd = new DependentResultDesc<Target>();
		ResultSlot<Src> inputSlot = DependentResultDesc.<Src>createInputSlot();
		
		List<ResultSlot<?>> dependentSlot = new ArrayList<>();
		dependentSlot.add(inputSlot);
		Function<Object[],BasicValuedChangeNotifyer<Mid>> calculationFunc = (objects)->{
			Src src = (Src)objects[0];
			return this.first.evaluate(src);
		};
		ResultSlot<Mid> intermediateSlot = dpd.createIntermediateDesc(dependentSlot, calculationFunc);
		List<ResultSlot<?>> totalDependentSlot = new ArrayList<>();
		totalDependentSlot.add(inputSlot);
		totalDependentSlot.add(intermediateSlot);;
		Function<Object[], Target> finalCalc = (objs)->{
			if (objs[1] == null) {
				return null;
			}
			return this.second.evaluateBasic((Mid)objs[1]);
		};
		ResultSlot<Target> finalSlot = dpd.createFinalDesc(totalDependentSlot, finalCalc );
		dpd.finish(finalSlot);
		
		Function<Src, BasicResult<Target>> func = (src)->{
			BasicMetaInfo mi = new BasicMetaInfo();
			//TODO: Fill ...
			return  dpd.getResult(mi, src, true);
		};
		init(func, null);
	}
	
	@Override
	public Scope<Src> getScope() {
		return first.getScope();
	}

}

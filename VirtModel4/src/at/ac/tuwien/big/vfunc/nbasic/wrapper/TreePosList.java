package at.ac.tuwien.big.vfunc.nbasic.wrapper;

import java.util.Comparator;
import java.util.function.BiFunction;

import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.FunctionListWrapper;
import at.ac.tuwien.big.vfunc.nbasic.FunctionModificator;
import at.ac.tuwien.big.vfunc.nbasic.SetValueModificator;
import at.ac.tuwien.big.vfunc.nbasic.TriConsumer;
import at.ac.tuwien.big.virtmod.basic.Treepos;

public class TreePosList<Trg> extends FunctionListWrapper<AbstractFunc<Treepos,Trg,?>, Treepos, Trg> {
	
	private static<Trg> TriConsumer<? super AbstractFunc<Treepos, Trg, ?>, ? super Treepos, ? super Trg> VALUE_SETTER(Trg nothing) {
		return new TriConsumer<AbstractFunc<Treepos, Trg, ?>, Treepos, Trg>() {

			@Override
			public void consume(AbstractFunc<Treepos, Trg, ?> a, Treepos b, Trg c) {
				FunctionModificator mod = a.getModificator();
				if (mod instanceof SetValueModificator) {
					SetValueModificator<AbstractFunc<Treepos, Trg, ?>, Treepos, Trg> svm = (SetValueModificator)mod;
					svm.setValue(a, b, c);
				} else {
					throw new UnsupportedOperationException("Function used which cannot be modified!");
				}
			}		
		};
		
	}

	private static BiFunction<Treepos, Treepos, Treepos> NEW_SOURCE_CALCULATOR = (left,right)->{
		if (left == null) {
			if (right == null) {
				return Treepos.ROOT();
			} else {
				return right.before();
			}
		} else if (right == null) {
			return left.after();
		}
		return left.middle(right, 1);
	};
	
	
	public TreePosList(AbstractFunc<Treepos, Trg, ?> func) {
		super(func, (x,y)->x.compareTo(y), NEW_SOURCE_CALCULATOR, VALUE_SETTER(null));
	}

}

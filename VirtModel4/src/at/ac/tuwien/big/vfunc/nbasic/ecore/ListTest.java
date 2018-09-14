package at.ac.tuwien.big.vfunc.nbasic.ecore;

import at.ac.tuwien.big.vfunc.nbasic.FunctionListWrapper;

public class ListTest {
	
	public static void main(String[] args) {
		FunctionListWrapper<AbstractFunc<Src,Trg,?>, Src, Trg> flw = new FunctionListWrapper<AbstractFunc<Src,Trg,?>, Src, Trg>(func, comparator, newSourceCalculator, valueSetter);
	}

}

package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicResult;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;
import at.ac.tuwien.big.virtmod.basic.Treepos;

public class ReverseListWrapper<T> extends AbstractFunc<Treepos, T, QueryResult<Treepos,T>>{

	//Assume no change!
	private List<T> baseList;
	
	
	public ReverseListWrapper(List<T> baseList) {
		this.baseList = baseList;
		 
		Function<Treepos, BasicResult<T>> func
			;
		BiFunction<? super Treepos, ? super QueryResult<Treepos, T>, ? extends T> valueUpdater;
		// TODO Auto-generated constructor stub
		init(func, valueUpdater);
	}
	
	@Override
	public Scope<Treepos> getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

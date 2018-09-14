package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocalImpl;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.FunctionListWrapper;
import at.ac.tuwien.big.vfunc.nbasic.FunctionModificator;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;
import at.ac.tuwien.big.vfunc.nbasic.TriConsumer;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.TreePosList;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class FunctionMultiAttributeHandler<Src,Target> extends BasicChangeNotifyerWithLocalImpl implements MultiAttributeHandler<Target> {
	
	AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>> func;
	private EList<Target> list;
	private ChangeListenable changeListenable = new ChangeListenable() {

		@Override
		public void changed(Change change) {
			FunctionMultiAttributeHandler.this.changed();
		}
	};
	
	public FunctionMultiAttributeHandler(AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>> func, 
			Comparator<Src> comparator, BiFunction<Src, Src, Src> newSourceCalculator, TriConsumer<
			? super AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>>, ? super Src, ? super Target> valueSetter
			
			
			) {
		this.func = func;
		func.getChangeNotifyer().addChangeListener(changeListenable);
		this.list = new FunctionListWrapper<>(func, comparator, newSourceCalculator, valueSetter );
	}
	
	private FunctionMultiAttributeHandler(AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>> func, EList<Target> list) {
		this.func = func;
		this.list = list;
	}
	
	public static<Target> FunctionMultiAttributeHandler<Treepos,Target> 
			getTreeposHandler(AbstractFunc<Treepos, Target, ? extends QueryResult<Treepos,Target>> func) {
		return new FunctionMultiAttributeHandler<Treepos, Target>(func, new TreePosList<Target>(func));
	}
	
	@Override
	public void unset() {
		list.clear();
	}
	
	@Override
	public void setValues(Collection<Target> newValues) {
		List<Target> newValuesList;
		if (newValues instanceof List) {
			newValuesList = (List<Target>)newValues;
		} else {
			newValuesList = new ArrayList<>(newValues);
		}
		PatchUtil.applyPatch(this.list, newValuesList);
	}
	
	@Override
	public EList<Target> exposeList() {
		return list;
	}



}

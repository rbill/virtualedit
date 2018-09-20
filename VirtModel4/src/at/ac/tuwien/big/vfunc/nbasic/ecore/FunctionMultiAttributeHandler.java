package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

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
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class FunctionMultiAttributeHandler<Src,Target,RealTarget> extends BasicChangeNotifyerWithLocalImpl implements MultiAttributeHandler<RealTarget> {
	
	public static<Target,RealTarget> FunctionMultiAttributeHandler<Treepos,Target,RealTarget> 
			getTreeposHandler(AbstractFunc<Treepos, Target, ? extends QueryResult<Treepos,Target>> func, Function<Target,RealTarget> convertTo, Function<RealTarget,Target> convertFrom) {
		return new FunctionMultiAttributeHandler<>(func, new ConvertingListImpl<>(new TreePosList<>(func), convertFrom, convertTo));
	}
	AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>> func;
	private EList<RealTarget> list;
	
	private ChangeListenable changeListenable = new ChangeListenable() {

		@Override
		public void changed(Change change) {
			FunctionMultiAttributeHandler.this.changed();
		}
	};
	
	public FunctionMultiAttributeHandler(AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>> func, 
			Comparator<Src> comparator, BiFunction<Src, Src, Src> newSourceCalculator, TriConsumer<
			? super AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>>, ? super Src, ? super Target> valueSetter, Function<Target,RealTarget> convertTo, Function<RealTarget,Target> convertFrom
			
			
			) {
		this.func = func;
		func.getChangeNotifyer().addChangeListener(this.changeListenable);
		this.list = new ConvertingListImpl<>(new FunctionListWrapper<>(func, comparator, newSourceCalculator, valueSetter ), convertFrom, convertTo);
	}
	
	private FunctionMultiAttributeHandler(AbstractFunc<Src, Target, ? extends QueryResult<Src,Target>> func, EList<RealTarget> list) {
		this.func = func;
		this.list = list;
		func.getChangeNotifyer().addChangeListener(this.changeListenable);
	}
	
	@Override
	public EList<RealTarget> exposeList() {
		return this.list;
	}
	
	@Override
	public AbstractFunc<?, ?, ? extends QueryResult<?, ?>> getTreeposFuncOrNull() {
		return this.func;
	}
	
	@Override
	public void setValues(Collection<RealTarget> newValues) {
		List<RealTarget> newValuesList;
		if (newValues instanceof List) {
			newValuesList = (List<RealTarget>)newValues;
		} else {
			newValuesList = new ArrayList<>(newValues);
		}
		PatchUtil.applyPatch(this.list, newValuesList);
	}

	@Override
	public void unset() {
		this.list.clear();
	}



}

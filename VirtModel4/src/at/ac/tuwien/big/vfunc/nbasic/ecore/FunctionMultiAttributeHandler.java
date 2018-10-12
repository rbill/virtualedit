package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.basic.Change;
import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocalImpl;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicMetaInfo;
import at.ac.tuwien.big.vfunc.nbasic.BasicValuedChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.ComposedReason;
import at.ac.tuwien.big.vfunc.nbasic.FunctionListWrapper;
import at.ac.tuwien.big.vfunc.nbasic.FunctionListWrapper.BasicEntry;
import at.ac.tuwien.big.vfunc.nbasic.FunctionModificator;
import at.ac.tuwien.big.vfunc.nbasic.MetaInfo;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;
import at.ac.tuwien.big.vfunc.nbasic.Reason;
import at.ac.tuwien.big.vfunc.nbasic.TriConsumer;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatus;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatusImpl;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.TreePosList;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;
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
	
	private BasicMetaInfo bmi = new BasicMetaInfo(new ComposedReason(()->{
		List<BasicValuedChangeNotifyer<?>> ret = new ArrayList<>();
		ret.addAll(getQueryResults());
		return ret;
	}));
	
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
	
	public List<MetaInfo> getAllMetaInfos() {
		List<MetaInfo> ret = new ArrayList<>();
		for (QueryResult<Src, Target> qr: getQueryResults()) {
			ret.add(qr.getMetaInfo());
		}
		return ret;
	}
	
	@Override
	public Collection<? extends BasicDerivationStatus> getDerivationStatus() {
		List<BasicDerivationStatus> ret = new ArrayList<>();
		for (MetaInfo mi: getAllMetaInfos()) {
			DerivationStatus retAdd = mi.getTotalDerivationStatus();
			ret.add(new BasicDerivationStatusImpl(retAdd));
		}
		return ret;
	}
	
	@Override
	public MetaInfo getMetaInfo() {
		return this.bmi;
	}

	public List<QueryResult<Src, Target>> getQueryResults() {
		if (this.list instanceof ConvertingListImpl) {
			//Overridden --> nonderived
			//OCL-expression used --> derived
			List<QueryResult<Src, Target>> ret = new ArrayList<>();
			ConvertingListImpl<RealTarget,Target> cvi = (ConvertingListImpl<RealTarget,Target>)this.list;
			List<Target> delegate = cvi.getDelegate();
			if (delegate instanceof FunctionListWrapper) {
				FunctionListWrapper<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>>, Src, Target> flw = (FunctionListWrapper<? extends AbstractFunc<Src, Target, ? extends QueryResult<Src, Target>>, Src, Target>)delegate;
				List<? extends BasicEntry<Src, Target>> entries = flw.getEntries();
				for (BasicEntry<Src, Target> be: entries) {
					QueryResult<Src, Target> result = be.getResult();
					ret.add(result);
				}
			}
			return ret;
		}
		return Collections.emptyList();
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

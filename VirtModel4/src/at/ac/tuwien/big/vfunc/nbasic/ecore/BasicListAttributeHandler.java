package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocalImpl;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicMetaInfo;
import at.ac.tuwien.big.vfunc.nbasic.MetaInfo;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatus;
import at.ac.tuwien.big.virtmod.basic.col.Converter;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.virtmod.basic.wrapper.impl.BasicEditableListWrapper;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class BasicListAttributeHandler<T,U> extends BasicChangeNotifyerWithLocalImpl implements MultiAttributeHandler<T> {
	
	private static Function IDENTITY = (x)->x;
	
	private static<T> List<T> asList(Collection<T> col) {
		if (col instanceof List) {
			return (List)col;
		} else {
			return new ArrayList<>(col);
		}
	}
	
	public static<T> BasicListAttributeHandler<T, T> fromList(List<T> list) {
		return new BasicListAttributeHandler<>(list);
	}
	
	public static<T> Function<T,T> IDENTIY() {
		return IDENTITY;
	}
	
	EList<T> list;
	

	private BasicListenable  listenable = new BasicListenable() {

		@Override
		public void changed(BasicChangeNotifyer bcm) {
			BasicListAttributeHandler.this.changed();
		}
		
	};

	private BasicMetaInfo bmi = new BasicMetaInfo();
	
	public BasicListAttributeHandler(List<T> list) {
		BasicEditableListWrapper<T> bew = new BasicEditableListWrapper<>(list);
		this.list = bew;
		bew.addBasicChangeListener(this.listenable);
		
	}
	
	

	public BasicListAttributeHandler(List<U> list, Function<U,T> convertThere, Function<T,U> convertBack) {
		if (convertBack == IDENTITY && convertThere == IDENTITY) {
			BasicEditableListWrapper<T> bew = new BasicEditableListWrapper<>((List<T>)list);
			this.list = bew;
			bew.addBasicChangeListener(this.listenable);
		} else {
			ConvertingListImpl<T, U> cli = new ConvertingListImpl<>(list, convertBack, convertThere);
			cli.addBasicChangeListener(this.listenable);
			this.list = cli;
		}
	}

	@Override
	public EList<T> exposeList() {
		return this.list;
	}

	@Override
	public Collection<? extends BasicDerivationStatus> getDerivationStatus() {
		return Collections.emptyList();
	}

	@Override
	public MetaInfo getMetaInfo() {
		return this.bmi;
	}

	@Override
	public AbstractFunc<?, T, ? extends QueryResult<?, T>> getTreeposFuncOrNull() {
		return null;
	}
	
	@Override
	public void setValues(Collection<T> newValues) {
		PatchUtil.applyPatch(this.list, asList(newValues));
	}

	@Override
	public void unset() {
		this.list.clear();
	}
}

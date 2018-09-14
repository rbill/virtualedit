package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;

import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocalImpl;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.virtmod.basic.col.Converter;
import at.ac.tuwien.big.virtmod.basic.col.impl.ConvertingListImpl;
import at.ac.tuwien.big.virtmod.basic.wrapper.impl.BasicEditableListWrapper;
import at.ac.tuwien.big.xtext.equalizer.impl.PatchUtil;

public class BasicListAttributeHandler<T,U> extends BasicChangeNotifyerWithLocalImpl implements MultiAttributeHandler<T> {
	
	EList<T> list;
	
	private static Function IDENTITY = (x)->x;
	
	private BasicListenable  listenable = new BasicListenable() {

		@Override
		public void changed(BasicChangeNotifyer bcm) {
			BasicListAttributeHandler.this.changed();
		}
		
	};
	
	public BasicListAttributeHandler(List<T> list) {
		BasicEditableListWrapper<T> bew = new BasicEditableListWrapper<>(list);
		this.list = bew;
		bew.addBasicChangeListener(listenable);
		
	}
	
	public static<T> BasicListAttributeHandler<T, T> fromList(List<T> list) {
		return new BasicListAttributeHandler<T, T>(list);
	}
	

	public BasicListAttributeHandler(List<U> list, Function<U,T> convertThere, Function<T,U> convertBack) {
		if (convertBack == IDENTITY && convertThere == IDENTITY) {
			BasicEditableListWrapper<T> bew = new BasicEditableListWrapper<>((List<T>)list);
			this.list = bew;
			bew.addBasicChangeListener(listenable);
		} else {
			ConvertingListImpl<T, U> cli = new ConvertingListImpl<T,U>(list, convertBack, convertThere);
			cli.addBasicChangeListener(listenable);
			this.list = cli;
		}
	}

	private static<T> List<T> asList(Collection<T> col) {
		if (col instanceof List) {
			return (List)col;
		} else {
			return new ArrayList<>(col);
		}
	}
	
	@Override
	public void setValues(Collection<T> newValues) {
		PatchUtil.applyPatch(list, asList(newValues));
	}
	
	

	@Override
	public void unset() {
		list.clear();
	}

	@Override
	public EList<T> exposeList() {
		return list;
	}
}

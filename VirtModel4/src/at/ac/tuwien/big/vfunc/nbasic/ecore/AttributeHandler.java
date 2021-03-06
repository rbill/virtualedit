package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.util.Collection;

import at.ac.tuwien.big.vfunc.basic.ChangeListenable;
import at.ac.tuwien.big.vfunc.nbasic.AbstractFunc;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.BasicChangeNotifyerWithLocal;
import at.ac.tuwien.big.vfunc.nbasic.BasicListenable;
import at.ac.tuwien.big.vfunc.nbasic.BasicValuedChangeNotifyer;
import at.ac.tuwien.big.vfunc.nbasic.QueryResult;
import at.ac.tuwien.big.vfunc.nbasic.wrapper.BasicDerivationStatus;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ExactDerivationStatus;

public interface AttributeHandler<T,U> extends BasicChangeNotifyerWithLocal, BasicValuedChangeNotifyer<U> {
	
	public Collection<? extends BasicDerivationStatus> getDerivationStatus();

	public Object getObject();

	public AbstractFunc<?, ?, ? extends QueryResult<?, ?>> getTreeposFuncOrNull();

	public boolean isSet();
	
	public Collection<? extends T> readOnlyValues();

	public void unset();

}

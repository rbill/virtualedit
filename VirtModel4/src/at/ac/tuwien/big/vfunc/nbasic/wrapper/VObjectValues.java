package at.ac.tuwien.big.vfunc.nbasic.wrapper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.impl.VObjectValuesImpl;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.xtext.util.IteratorUtils;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;


public interface VObjectValues extends Iterable<Identifier> {

	public void add(Identifier objectId);

	public default boolean contExists(Symbol objectId) {
		if (!exists(objectId)) {
			return false;
		}
		Symbol cont = getContainingObject(objectId);
		return cont == null || VObjectValuesImpl.MODEL_ROOT.equals(cont) || contExists(cont);
	}
	
	
	public default Iterable<Symbol> existing() {
		return ()->IteratorUtils.filterType(this.iterator(), (x)->contExists(x));
	}
	
	public boolean exists(Identifier objectId);
	
	public EClass getClass(Identifier objectId);
	
	public Function<String, ? extends Counter> getClassFunc(Symbol id);
	
	public Symbol getContainerFull(Symbol objectId);

	public default String getContainingFeature(Symbol objectId) {
		Symbol cf = getContainerFull(objectId);
		if (cf == null) {
			return null;
		}
		return String.valueOf(cf.subObjects().get(1));
	}
	
	public default Symbol getContainingObject(Symbol objectId) {
		Symbol cf = getContainerFull(objectId);
		if (cf == null || VObjectValuesImpl.MODEL_ROOT.equals(cf)) {
			return null;
		}
		return (Symbol)cf.subObjects().get(0);
	}
	
	public default Iterable<Symbol> getInstances(String eclass) {
		return ()->IteratorUtils.<Symbol>filterType(iterator(), (x)->(hasClass(x,eclass) && contExists(x)));
	}
	
	public Iterable<Symbol> getRootObjects();
	
	public default boolean hasClass(Symbol id, String eclass) {
		Counter c = getClassFunc(id).getValueOrNull(eclass);
		return c != null && c.exists();
	}
	
	public void informContainer(Symbol myValue, EReference feature, Symbol key);

	public void informNoContainer(Symbol myValue, EReference feature, Symbol key);

	void makeContainedInRoot(Symbol containedObject);
	
	void makeUncontainedInRoot(Symbol containedObject);

	public void nullifyClear();
	
	public default Filter<Symbol> objectExistsEcoreFilter() {
		return (x)->contExists(x);
	}
	
	public default Filter<Symbol> objectExistsFilter() {
		return (x)->exists(x);
	}

	public void remove(Identifier objectId);
	
	

	public void setClass(Identifier objectId, EClass classId);

	public void setContainer(Symbol containedObject, Symbol containingObject, String featureName);
}
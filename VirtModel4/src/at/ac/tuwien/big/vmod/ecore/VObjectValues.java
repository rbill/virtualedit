package at.ac.tuwien.big.vmod.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import at.ac.tuwien.big.virtmod.structure.ElementSourceInfo;
import at.ac.tuwien.big.vmod.Counter;
import at.ac.tuwien.big.vmod.Function;
import at.ac.tuwien.big.vmod.ecore.impl.VObjectValuesImpl;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.xtext.util.IteratorUtils;
import at.ac.tuwien.big.xtext.util.IteratorUtils.Filter;


public interface VObjectValues extends Iterable<Symbol> {

	public EClass getClass(Symbol objectId);

	public void setClass(Symbol objectId, EClass classId);
	
	
	public boolean exists(Symbol objectId);
	
	public void add(Symbol objectId);
	
	public void remove(Symbol objectId);
	
	public default Filter<Symbol> objectExistsFilter() {
		return (x)->exists(x);
	}
	
	public default boolean contExists(Symbol objectId) {
		if (!exists(objectId)) {
			return false;
		}
		Symbol cont = getContainerFull(objectId);
		return cont == null || contExists(cont);
	}

	public default Filter<Symbol> objectExistsEcoreFilter() {
		return (x)->contExists(x);
	}
	
	public void nullifyClear();
	
	public void setContainer(Symbol containedObject, Symbol containingObject, String featureName);
	
	public Symbol getContainerFull(Symbol objectId);
	
	public default Symbol getContainingObject(Symbol objectId) {
		Symbol cf = getContainerFull(objectId);
		if (cf == null || VObjectValuesImpl.MODEL_ROOT.equals(cf)) {
			return null;
		}
		return (Symbol)cf.subObjects().get(0);
	}
	
	public default String getContainingFeature(Symbol objectId) {
		Symbol cf = getContainerFull(objectId);
		if (cf == null) {
			return null;
		}
		return String.valueOf(cf.subObjects().get(1));
	}

	public Function<String, ? extends Counter> getClassFunc(Symbol id);

	public void informContainer(Symbol myValue, EReference feature, Symbol key);
	
	public void informNoContainer(Symbol myValue, EReference feature, Symbol key);

	void makeContainedInRoot(Symbol containedObject);
	
	void makeUncontainedInRoot(Symbol containedObject);
	
	public default boolean hasClass(Symbol id, String eclass) {
		Counter c = getClassFunc(id).getValueOrNull(eclass);
		return c != null && c.exists();
	}

	public default Iterable<Symbol> getInstances(String eclass) {
		return ()->IteratorUtils.<Symbol>filterType(iterator(), (x)->hasClass(x,eclass));
	}

	public Iterable<Symbol> getRootObjects();
}
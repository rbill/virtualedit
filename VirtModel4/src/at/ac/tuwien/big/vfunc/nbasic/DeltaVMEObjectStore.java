package at.ac.tuwien.big.vfunc.nbasic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

import javax.swing.event.TreeSelectionEvent;

import org.eclipse.emf.ecore.EStructuralFeature;

import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.BasicFunction;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.DeltaStore;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.FeatureFunc;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.Identifier;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.StoredFuncs;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.VObjectModelFactory;
import at.ac.tuwien.big.vom.vobjectmodel.vobjectmodel.ValuePair;
import at.ac.tuwien.big.vfunc.basic.FixedFinitScope;
import at.ac.tuwien.big.vfunc.basic.Scope;
import at.ac.tuwien.big.vfunc.nbasic.ecore.AttributeHandler;
import at.ac.tuwien.big.vfunc.nbasic.ecore.MultiAttributeHandler;
import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.DerivationStatus;

public class DeltaVMEObjectStore {

	private static class BasicFeatureFunc implements Comparable<BasicFeatureFunc> {
		private String name;
		private String classref;
		private String nsref;
		private int hashCode;

		public BasicFeatureFunc(EStructuralFeature k) {
			this.name = k.getName();
			this.classref = k.getEContainingClass().getName();
			this.nsref = k.eResource().getURI().toString();
		}

		public BasicFeatureFunc(FeatureFunc ff) {
			this(ff.getName(), ff.getClassref(), ff.getNsref());
		}

		public BasicFeatureFunc(String name, String classref, String nsref) {
			this.name = name;
			this.classref = classref;
			this.nsref = nsref;
		}

		@Override
		public int compareTo(BasicFeatureFunc o) {
			int ret = (this.nsref == null ? "" : this.nsref).compareTo(o.nsref == null ? "" : o.nsref);
			if (ret == 0) {
				ret = (this.classref == null ? "" : this.classref).compareTo(o.classref == null ? "" : o.classref);
			}
			if (ret == 0) {
				ret = (this.name == null ? "" : this.name).compareTo(o.name == null ? "" : o.name);
			}
			return ret;
		}

		public boolean equals(BasicFeatureFunc bff) {
			return this.hashCode == bff.hashCode && Objects.equals(this.name, bff.name)
					&& Objects.equals(this.classref, bff.classref) && Objects.equals(this.nsref, bff.nsref);
		}

		@Override
		public boolean equals(Object o) {
			return (o instanceof BasicFeatureFunc) && equals((BasicFeatureFunc) o);
		}

		@Override
		public int hashCode() {
			return this.hashCode;
		}

		@Override
		public String toString() {
			return this.nsref + "::" + this.classref + "." + this.name;
		}

	}

	public static class DeltaStoreInfo<T> {

		BasicMapFunc<Treepos, T> valueFunc = new BasicMapFunc<>(Treepos.class);
		BasicMapFunc<Treepos, Boolean> scopeFunc = new BasicMapFunc<>(Treepos.class);
		{
			this.valueFunc.setBasicMetaInfoCreater((src)->new BasicMetaInfo(new BasicDerivationReason(DerivationStatus.NONDERIVED)));
			this.scopeFunc.setBasicMetaInfoCreater((src)->new BasicMetaInfo(new BasicDerivationReason(DerivationStatus.NONDERIVED)));
		}

		public BasicMapFunc<Treepos, Boolean> getScopeFunc() {
			return this.scopeFunc;
		}

		public BasicMapFunc<Treepos, T> getValueFunc() {
			return this.valueFunc;
		}

	}

	private Map<BasicFeatureFunc, DeltaStore> storedDeltas = new HashMap<>();

	private Map<EStructuralFeature, DeltaStoreInfo<?>> dsiMap = new HashMap<>();

	public void augmentStoredFuncs(StoredFuncs funcs) {
		Map<BasicFeatureFunc, Map<Treepos, Object>> existingValuesVal = new HashMap<>();
		Map<BasicFeatureFunc, Map<Treepos, Object>> existingValuesScope = new HashMap<>();
		funcs.getFeaturefunc().forEach(x -> {
			// Check whether something does not exist any more
			DeltaStore ds = x.getDeltastore();
			if (ds == null || ds.getAddMap() == null || ds.getFilterScope() == null) {
				return;
			}
			BasicFeatureFunc bff = new BasicFeatureFunc(x);
			Map<Treepos, Object> existingVals = existingValuesVal.computeIfAbsent(bff, y -> new HashMap<>());
			Map<Treepos, Object> existingScopes = existingValuesScope.computeIfAbsent(bff, y -> new HashMap<>());
			for (ValuePair vp : ds.getAddMap().getValues()) {
				if (!(vp.getKey() instanceof Treepos)) {
					System.err.println("Illegal key: " + vp.getKey());
					continue;
				}
				existingVals.put((Treepos) vp.getKey(), getValue(vp));
			}
			for (ValuePair vp : ds.getFilterScope().getValues()) {
				if (!(vp.getKey() instanceof Treepos)) {
					System.err.println("Illegal key: " + vp.getKey());
					continue;
				}
				existingScopes.put((Treepos) vp.getKey(), getValue(vp));
			}
		});
		// Now augment it with existing
		this.dsiMap.forEach((k, v) -> {
			BasicFeatureFunc bff = new BasicFeatureFunc(k);
			{
				Map<Treepos, Boolean> createScopeMap = v.getScopeFunc().createValuesMap();
				existingValuesScope.computeIfAbsent(bff, x -> new HashMap<>()).putAll(createScopeMap);
			}
			{
				Map<Treepos, ?> createValuesMap = v.getValueFunc().createValuesMap();
				existingValuesVal.computeIfAbsent(bff, x -> new HashMap<>()).putAll(createValuesMap);
			}
		});
		// Now you can delete all existing and put it back
		funcs.getFeaturefunc().clear();
		TreeSet<BasicFeatureFunc> ts = new TreeSet<>();
		ts.addAll(existingValuesScope.keySet());
		ts.addAll(existingValuesVal.keySet());
		for (BasicFeatureFunc bff : ts) {
			Map<Treepos, Object> scopeMap = existingValuesScope.get(bff);
			Map<Treepos, Object> valMap = existingValuesVal.get(bff);
			FeatureFunc ff = VObjectModelFactory.eINSTANCE.createFeatureFunc();
			funcs.getFeaturefunc().add(ff);
			ff.setName(bff.name);
			ff.setNsref(bff.nsref);
			ff.setClassref(bff.classref);
			DeltaStore ds = VObjectModelFactory.eINSTANCE.createDeltaStore();
			ff.setDeltastore(ds);
			;
			BasicFunction addMap = VObjectModelFactory.eINSTANCE.createBasicFunction();
			ds.setAddMap(addMap);
			BasicFunction filterMap = VObjectModelFactory.eINSTANCE.createBasicFunction();
			ds.setFilterScope(filterMap);
			scopeMap.forEach((k, v) -> {
				ValuePair pair = getPair(k, v);
				if (pair != null) {
					filterMap.getValues().add(pair);
				}
			});
			valMap.forEach((k, v) -> {
				ValuePair pair = getPair(k, v);
				if (pair != null) {
					addMap.getValues().add(getPair(k, v));
				}
			});

		}
	}

	private void fill(BasicMapFunc valueFunc, BasicFunction addMap) {
		addMap.getValues().forEach(vp -> {
			Object key = vp.getKey();
			Object value = vp.getValue();
			if (value == null) {
				value = vp.getIdentifierValue();
			}
			if (value != null) {
				valueFunc.putBasic(key, value);
			}
		});
	}

	public DeltaStoreInfo<?> getInfo(EStructuralFeature feat) {
		return this.dsiMap.computeIfAbsent(feat, x -> {
			BasicFeatureFunc bff = new BasicFeatureFunc(feat.getName(), feat.getEContainingClass().getName(),
					feat.eResource().getURI().toString());
			DeltaStore retStore = this.storedDeltas.get(bff);
			DeltaStoreInfo<?> ret = new DeltaStoreInfo<>();
			if (retStore != null) {
				fill(ret.valueFunc, retStore.getAddMap());
				fill(ret.scopeFunc, retStore.getFilterScope());
			}
			return ret;
		});
	}

	private ValuePair getPair(Object src, Object trg) {
		ValuePair vp = VObjectModelFactory.eINSTANCE.createValuePair();
		if (!(src instanceof Serializable)) {
			System.err.println("Source not serializable: " + src);
			return null;
		}
		vp.setKey(src);
		;
		if (trg instanceof Serializable) {
			vp.setValue(trg);
		} else if (trg instanceof Identifier) {
			vp.setIdentifierValue((Identifier) trg);
		} else {
			System.err.println("Target neither identifier nor Serializable!");
		}
		return vp;
	}

	private Object getValue(ValuePair vp) {
		if (vp.getValue() != null) {
			return vp.getValue();
		}
		return vp.getIdentifierValue();
	}

	public void loadFrom(StoredFuncs sf) {
		for (FeatureFunc ff : sf.getFeaturefunc()) {
			BasicFeatureFunc bff = new BasicFeatureFunc(ff);
			this.storedDeltas.put(bff, ff.getDeltastore());
		}
	}

	public void storeIn(BasicMapFunc from, BasicFunction to) {
		Scope scope = from.getScope();
		if (scope instanceof FixedFinitScope) {
			FixedFinitScope ffs = (FixedFinitScope) scope;
			for (Object src : ffs) {
				Object trg = from.evaluateBasic(src);
				ValuePair vp = getPair(src, trg);
				if (vp == null) {
					continue;
				}
				to.getValues().add(vp);
			}
		} else {
			System.err.println("Cannot do it ...");
		}
	}

}

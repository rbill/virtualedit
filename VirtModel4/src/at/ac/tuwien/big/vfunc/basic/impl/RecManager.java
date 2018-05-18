package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RecManager<S,T,U> {
	
	protected Map<S,T> map = new HashMap<>();
	private final Function<S, T> function;
	private final Function<T, U> extractor;
	private final BiConsumer<T, U> writer;
	protected RecManager<S, T, U> parent;
	protected Set<S> usedVariables = new HashSet<>();
	protected Set<RecManager<S, T, U>> subManagers = new HashSet<RecManager<S,T,U>>();
	protected S returnName;
	
	public RecManager(RecManager<S, T, U> parent, Function<S, T> func, Function<T, U> extractor, BiConsumer<T, U> writer, S returnName) {
		this.parent = parent;
		if (parent != null) {
			parent.subManagers.add(this);
		}
		this.returnName = returnName;
		this.function = func;
		this.extractor = extractor;
		this.writer = writer;
		createDirect(returnName);
	}
	
	public  RecManager<S, T, U> getParent() {
		return parent;
	}
	
	public RecManager(Function<S, T> func, Function<T, U> extractor, BiConsumer<T, U> writer, S returnName) {
		this(null,func,extractor,writer, returnName);
	}
	

	public RecManager(RecManager<S, T, U> parent, Supplier<T> func, Function<T, U> extractor, BiConsumer<T, U> writer, S returnName) {
		this(parent,(x)->func.get(),extractor,writer, returnName);
	}
	public RecManager(Supplier<T> func, Function<T, U> extractor, BiConsumer<T, U> writer, S returnName) {
		this(null,func,extractor,writer, returnName);
	}
	
	public T getOrCreate(S variable) {
		T ret = get(variable);
		if (ret == null) {
			map.put(variable, ret = function.apply(variable));
		}
		return ret;
	}
	

	public T createDirect(S variable) {
		T ret = map.get(variable);
		if (ret != null) {
			throw new RuntimeException("Cannot create direct variable: does already exist "+variable);
		}
		map.put(variable, ret = function.apply(variable));
		return ret;
	}
	
	//Get without making the variable used
	private T getPriv(S variable) {
		T ret = map.get(variable);
		if (ret == null && parent != null) {
			return parent.getPriv(variable);
		}
		return ret;
	}
	
	public Set<S> getUsedVariables() {
		return usedVariables;
	}
	
	public List<S> getAllUsedVariables() {
		Set<S> usedVars = new HashSet<S>();
		List<S> usedVarsList = new ArrayList<>();
		getAllUsedVariables(usedVars,usedVarsList);
		return usedVarsList;
	}
	
	public static<S> List<S> getSingletonListA(Collection<S>... from) {
		return getSingletonList(Arrays.asList(from));
	}
	
	public static<S> List<S> getSingletonList(Collection<? extends Collection<S>> from) {
		List<S> ret = new ArrayList<S>();
		Set<S> retSet = new HashSet<S>();
		for (Collection<S> list: from) {
			for (S s: list) {
				if (retSet.add(s)) {
					ret.add(s);
				}
			}
		}
		return ret;
	}
	
	public static<S> List<S> getUsedVariables(Collection<? extends RecManager<S,?,?>> managers) {
		List<List<S>> usedVariables = new ArrayList<>();
		managers.forEach(x->{
			usedVariables.add(x.getAllUsedVariables());
		});
		return getSingletonList(usedVariables);
	}
	
	private void getAllUsedVariables(Set<S> variables, List<S> variablesList) {
		Set<S> add = new HashSet<S>(usedVariables);
		List<S> subList = new ArrayList<>();
		subManagers.forEach(x->x.getAllUsedVariables(add,subList));
		add.removeAll(map.keySet());
		subList.forEach(x->{
			if (add.contains(x) && variables.add(x)) {
				variablesList.add(x);
			}
		});
	}
	
	public T getReturn() {
		return map.get(returnName);
	}
	
	public U getReturnValue() {
		T ret = getReturn();
		if (ret != null) {
			return extractor.apply(ret);
		}
		throw new RuntimeException("Return variable not found!");
	}
	
	//Also track variables
	public T get(S variable) {
		usedVariables.add(variable);
		return getPriv(variable);
	}
	

	private U getValuePriv(S variable)  {
		T ret = getPriv(variable);
		if (ret != null) {
			return extractor.apply(ret);
		}
		throw new RuntimeException("Variable " + variable+" not found!");
	}
	
	public U getValue(S variable)  {
		T ret = get(variable);
		if (ret != null) {
			return extractor.apply(ret);
		}
		throw new RuntimeException("Variable " + variable+" not found!");
	}
	
	public T getIfDirect(S variable) {
		return map.get(variable);
	}
	
	public U getValueIfDirect(S variable) {
		T ret = getIfDirect(variable);
		if (ret != null) {
			return extractor.apply(ret);
		}
		return null;
	}
	
	/**Values may only be set for directly created variables*/
	public void setValue(S variable, U value) {
		T ret = getIfDirect(variable);
		if (ret != null) {
			writer.accept(ret, value);
		}
		throw new RuntimeException("Variable " + variable+" not found for writing!");
	}

	public RecManager<S, T, U> push() {
		return new RecManager<>(this, function, extractor, writer, returnName);
	}
	
	public RecManager<S, T, U> push(S variable, U value) {
		RecManager<S, T, U> ret = push();
		ret.createDirect(variable);
		setValue(variable, value);
		return ret;
	}
	
	public RecManager<S, T, U> pop() {
		return parent;
	}
}

package at.ac.tuwien.big.vfunc.nbasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class Opdesc<T> {
	
	private Supplier<Function<List<Object>, T>> supplier;
	private List<Opdesc<T>> parameters = new ArrayList<>();
	
	public Opdesc() {
	}
	
	public void init(Supplier<Function<List<Object>, T>> supplier, List<Opdesc<T>> pars) {
		this.supplier = supplier;
		this.parameters = pars;
		this.hashCode = calcHash();
	}
	
	private int calcHash() {
		Object[] ar = new Object[parameters.size()+1];
		for (int i = 0; i < parameters.size(); ++i) {
			ar[i] = parameters.get(i);
		}
		ar[ar.length-1] = supplier;
		return Arrays.hashCode(ar);
	}
	
	private int hashCode;
	
	public int hashCode() {
		return hashCode;
	}
	
	public boolean equals(Opdesc<T> opdesc) {
		if (this == opdesc) {
			return true;
		}
		if (hashCode != opdesc.hashCode) {
			return false;
		}
		if (parameters.size() != opdesc.parameters.size()) {
			return false;
		}
		for (int i = 0; i < parameters.size(); ++i) {
			if (!Objects.equals(parameters.get(i), opdesc.parameters.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Object o) {
		return (o instanceof Opdesc) && equals((Opdesc)o);
	}

}

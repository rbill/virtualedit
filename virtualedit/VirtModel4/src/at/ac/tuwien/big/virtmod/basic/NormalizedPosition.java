package at.ac.tuwien.big.virtmod.basic;

import java.util.Map.Entry;
import java.util.Set;

public class NormalizedPosition implements Treepos {
	
	private Treepos delegate;
	
	public NormalizedPosition(Treepos delegate) {
		this.delegate = delegate;
	}

	@Override
	public int compareTo(Treepos o) {
		return delegate.compareTo(o);
	}

	@Override
	public Iterable<Entry<Integer, TreeposValue>> getEntries() {
		return delegate.getEntries();
	}

	@Override
	public TreeposValue getValueOrNull(Integer i) {
		return delegate.getValueOrNull(i);
	}

	@Override
	public void setValue(Integer i, TreeposValue val) {
		delegate.setValue(i, val);
	}
	
	@Override
	public Treepos positionNormalize() {
		return this;
	} 

	public Treepos positionUnnormalized() {
		return delegate.positionUnnormalized();
	}
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof Treepos && equalTreeposValue(((Treepos)other)));
	}
	
	@Override
	public int hashCode() {
		int ret = 0;
		for (Entry<Integer,TreeposValue> entr: getEntries()) {
			if (entr.getValue().type() == TreeposType.UNSPECIFIED) {
				continue;
			}
			int subHash = (entr.getKey()+65)*entr.getKey()+entr.getValue().hashCodeV();
			ret+= subHash;
		}
		return ret;
	}

}

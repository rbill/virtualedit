package at.ac.tuwien.big.virtmod.basic.impl;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.VListEntry;

public class VListEntryImpl<T> implements VListEntry<T> {
	
	private long editId;
	private T value;
	private Treepos treepos;
	
	public VListEntryImpl(long editId, Treepos pos, T value) {
		this.editId = editId;
		this.treepos = pos;
		this.value = value;
	}

	@Override
	public long editId() {
		return editId;
	}

	@Override
	public T value() {
		return value;
	}

	@Override
	public Treepos treepos() {
		return treepos;
	}

}

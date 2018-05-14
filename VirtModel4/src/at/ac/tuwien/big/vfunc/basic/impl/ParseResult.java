package at.ac.tuwien.big.vfunc.basic.impl;

import at.ac.tuwien.big.vfunc.basic.Expression;

public interface ParseResult {

	public Expression<?, ?> toValue();
}

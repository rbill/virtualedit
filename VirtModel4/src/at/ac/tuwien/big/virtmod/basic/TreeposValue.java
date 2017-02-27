package at.ac.tuwien.big.virtmod.basic;

import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreeposValue;

public interface TreeposValue {

	public int value();
		
	public default boolean equalsTo(TreeposValue other) {
		return value() == other.value();
	 }
	
	
	/**You may only compare the same indices against each other!*/
	public default int compareTo(TreeposValue other) {
		return Integer.compare(value(), other.value());
	}
	
	public default int hashCodeV() {
		return value();
	}

	public default TreeposValue simpleMiddle(TreeposValue neighborSub) {
		int cmp = compareTo(neighborSub);
		if (cmp == 0) {
			return this;
		}
		int myValue = value();
		int neighborValue = neighborSub.value();
		if (Math.abs(myValue-neighborValue)>1) {
			return new SimpleTreeposValue((myValue+neighborValue)/2);
		} 
		return null;
		
	}
}

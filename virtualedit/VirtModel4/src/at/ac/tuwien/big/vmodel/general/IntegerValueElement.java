package at.ac.tuwien.big.vmodel.general;

public interface IntegerValueElement extends StaticElement {
	
	public int getValue();
	
	public default boolean exists() {
		return getValue()>0;
	}
	
}

package at.ac.tuwien.big.verocl.parameterdesc;

public class SingleParameterDesc {

	public SingleParameterDesc(String name, Class<?> type) {
		this.name = name;
		this.type = type;
	}
	
	private final String name;
	private final Class<?> type;
	
	public String getName() {
		return name;
	}
	
	public Class<?> getType() {
		return type;
	}
}

package at.ac.tuwien.big.verocl;

public interface ParameterDesc {
	
	public ParameterDesc union(ParameterDesc other);
	
	public ParameterDesc intersection(ParameterDesc other);
	
	public ParameterDesc without(ParameterDesc other);
	
	/**Tries to reduce count of unionParameterValues*/
	public ParameterDesc shortify();
	
	public boolean isEmpty();
	
	public boolean equals(ParameterDesc other);
	
	
	/**Irgendwas für das implode ...*/

}

package at.ac.tuwien.big.virtmod.basic;

public interface TreeposState extends ValueState<Treepos>{
	
	public Treepos treepos();
	
	public default Treepos value() {
		return  treepos();
	}
	
}

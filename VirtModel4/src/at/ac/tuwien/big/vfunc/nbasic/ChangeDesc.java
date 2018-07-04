package at.ac.tuwien.big.vfunc.nbasic;

public abstract class ChangeDesc {

	private String name;
	
	public ChangeDesc(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void perform();
	
}

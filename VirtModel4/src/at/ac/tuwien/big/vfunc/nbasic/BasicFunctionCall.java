package at.ac.tuwien.big.vfunc.nbasic;

public class BasicFunctionCall<Source,Target> implements FunctionCall<Source, Target> {
	
	private AbstractFunc<Source, Target, ? extends QueryResult<Source, Target>> function;
	private Source source;
	
	public boolean equals(BasicFunctionCall<Source, Target> fc) {
		
	}
	
	@Override
	public boolean equals(Object o) {
		
	}

	@Override
	public AbstractFunc<Source, Target, ? extends QueryResult<Source, Target>> function() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Source source() {
		// TODO Auto-generated method stub
		return null;
	}

}

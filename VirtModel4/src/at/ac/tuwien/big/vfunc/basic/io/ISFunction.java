package at.ac.tuwien.big.vfunc.basic.io;

import java.util.ArrayList;
import java.util.List;

import at.ac.tuwien.big.vfunc.basic.impl.VariableRecManager;
import at.ac.tuwien.big.vmod.IterablePosition;
import at.ac.tuwien.big.vmod.ParentLocation;
import at.ac.tuwien.big.vmod.type.FunctionType;

public class ISFunction implements java.util.function.Function<Object[], Object> {
	
	private List<? extends BasicStatement> body;
	private String[] parameterNames;
	private InterpretationState state;
	private List<BasicStatement> completeBody;
	
	public ISFunction(InterpretationState state, List<? extends BasicStatement> body, String[] parameterNames) {
		this.state = state.cloneNew();
		this.parameterNames = parameterNames;
		this.body = body;
	}

	@Override
	public Object apply(Object[] t) {
		int paramLength = Math.min(t.length,  parameterNames.length);
		completeBody = new ArrayList<BasicStatement>();
		for (int i = 0; i < parameterNames.length; ++i) {
			final String thisPn = parameterNames[i]; 
			final int thisI = i;
			completeBody.add((state)->{
				state.createDirectVar(thisPn);
				state.set(thisPn, t[thisI]);
			});
		}
		completeBody.add((state)->{
			state.createDirectVar("$funresult");
		});
		List<BasicStatement> fakeBody = new ArrayList<>(body);
		fakeBody.add(new BasicStatement.SuperMovStatement("$funresult", VariableRecManager.RETURN_VAR));
		BasicStatement.insertSub(completeBody, fakeBody);
		
		Object[] ret = state.executeNow(completeBody, "$funresult");
		return ret.length<1?null:ret[0];
	}

}

package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import at.ac.tuwien.big.vfunc.basic.AssignmentSourceInfo;
import at.ac.tuwien.big.vfunc.basic.CompleteResult;
import at.ac.tuwien.big.vfunc.basic.Expression;
import at.ac.tuwien.big.vfunc.basic.FourParameterModifier;
import at.ac.tuwien.big.vfunc.basic.FunctionApplicator;
import at.ac.tuwien.big.vfunc.basic.FunctionNotifyer;
import at.ac.tuwien.big.vfunc.basic.OneParameterModifier;
import at.ac.tuwien.big.vfunc.basic.ThreeParameterModifier;
import at.ac.tuwien.big.vfunc.basic.TwoParameterModifier;

public class EEModifier implements Expression<BasicEE, BasicEE> {

	private final BiFunction<BasicEE, List<Supplier<?>>, BasicEE> eeModifier;
	
	public EEModifier(BiFunction<BasicEE, List<Supplier<?>>, BasicEE> eeModifier) {
		this.eeModifier = eeModifier;
	}
	
	@Override
	public BasicEE calcResult(AssignmentSourceInfo<BasicEE, BasicEE> src, List<FunctionNotifyer<?, ?, ?>> subResultInfos) {
		return eeModifier.apply(src.source(), subResultInfos);
	}
	

}

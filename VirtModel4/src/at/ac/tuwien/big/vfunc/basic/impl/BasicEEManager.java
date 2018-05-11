package at.ac.tuwien.big.vfunc.basic.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import at.ac.tuwien.big.vfunc.basic.FunctionApplicator;
import at.ac.tuwien.big.vfunc.basic.VFunction;
import at.ac.tuwien.big.vfunc.basic.impl.ExpressionExpression.EEExtraction;

//Der allgemeine funktionstyp
public class BasicEEManager<Source,Target> {
	//Implicit input and output
	//Three types: Input/Output/Local
	private Map<String,Integer> indices = new HashMap<>();
	
	private interface SomeResult<T> {
		
	}
	
	private Map<String, SomeResult<?>> funcMap = new HashMap<>();
	
	{
		addParam("$ret");
	}
	
	private Source source;
	
	private void setSource(Source source) {
		this.source = source;
	}
	
	public void addParam(String par) {
		if (indices.putIfAbsent(par, indices.size()) != null) {
			throw new RuntimeException("Duplicate parameter "+par);
		}
	}
	
	public void let(String varName, SomeResult<?> someFunction, String... functionParameters) {
		
	}
	
	public<From,To> VFunction<BasicEE,To> result(Function<From, To> function, VFunction<BasicEE,From> parameter, Class<From> sourceClass) {
		SingleParameterHandlerObject<From, To, BasicEE> spho = SingleParameterHandlerObject.getUnaryOp(function, sourceClass);
		List<FunctionApplicator<? super BasicEE, ?, ?>> functionApplicators = new ArrayList<FunctionApplicator<? super BasicEE,?,?>>();
		functionApplicators.add(new BasicFunctionApplicator<>(function, extractor));
		ExpressionExpression<BasicEE,To> expr = new ExpressionExpression<BasicEE,To>(functionApplicators, spho);
		BasicAssignment<BasicEE, To> bas = BasicAssignment.getSoftAssignment(expr);
		SingleFunction<BasicEE, To> sf = bas.getSingleFunction();
		return sf;
	}
	
	public<From,From2,To> SomeResult<To> result(BiFunction<From, From2, To> function, SomeResult<From> parameter, SomeResult<From> parameter2) {
		
	}
	
	public SomeResult result(SomeFunction function, SomeResult... parameters) {
		
	}
	
	public SomeResult value(Object constant) {
		
	}
	
	public SomeResult param(String parName) {
		
	}

}

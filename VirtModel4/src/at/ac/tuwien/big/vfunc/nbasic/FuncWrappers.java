package at.ac.tuwien.big.vfunc.nbasic;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public interface FuncWrappers {
	
	public static<A> A ensureClass(Object obj, Class<A> cl) {
		if (obj == null || cl.isInstance(obj)) {
			return (A)obj;
		} else {
			throw new RuntimeException("Wrong class: Wanted " + cl+", got: " + obj);
		}
	}
	
	public static<A,B,T> Function<List<Object>, T> biFunction(BiFunction<A,B,T> func, Class<A> cl, Class<B> cl2) {
		return (list)->{
			A first = null;
			B second = null;
			if (list.size()<2) {
				throw new RuntimeException("Incorrect parameter number: required 2 parameters!");
			}
			first = ensureClass(list.get(0), cl);
			second = ensureClass(list.get(1), cl2);
			return func.apply(first, second);
		};
	}


	
	public static<A,T> Function<List<Object>, T> unaryFunction(Function<A,T> func, Class<A> cl) {
		return (list)->{
			A first = null;
			if (list.size()<1) {
				throw new RuntimeException("Incorrect parameter number: required 2 parameters!");
			}
			first = ensureClass(list.get(0), cl);
			return func.apply(first);
		};
	}
	
	public static <T> Function<List<Object>, T> reduceFunction(BinaryOperator<T> operator, Supplier<T> init, Class<T> cl) {
		return (list)->{
			T ret = init.get();
			for (Object o: list) {
				ret = operator.apply(ret, ensureClass(o, cl));
			}
			return ret;
		};
	}
	
	public static <T> Function<List<Object>, T> log(Function<List<Object>,T> func, BiFunction<List<Object>, T, String> logOutput) {
		return (list)->{
			T ret = func.apply(list);
			try {
				System.out.println(logOutput.apply(list,ret));
			} catch (Exception e) {
				System.err.println("Could not output log: "+e.getMessage());
			}
			return ret;
		};
		
	}

}

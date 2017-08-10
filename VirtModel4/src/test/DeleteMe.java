import java.util.Iterator;

public class DeleteMe {
	
	public interface SimpleFunction<X,Y> {
		public Y applyTo(X x);
	}

	
	public static<X,Y> java.util.Iterator<Y> flatten(Iterator<? extends X> x, SimpleFunction<? super X, ? extends Iterator<Y>> func) {
		return shallowUnionColIter(convert(x, (y)->func.applyTo(y))).iterator();
	}
	
	public static<X,Y> Iterator<Y> convert(Iterator<? extends X> x, SimpleFunction<? super X, ? extends Y> func) {
		return null; //Not relevant
	}
	
	public static<X> Iterable<X> shallowUnionColIter(Iterator<? extends Iterator<? extends X>> values) {
		return null; //Not relevant
	}
}
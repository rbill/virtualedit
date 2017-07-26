package test;

public class Test {
	
	public interface Delegate<T> {
		public T getDelegate();
	}
	
	public interface C {
		
	}

	public interface B {
		
	}
	
	public static class ParametizedGeneral<This extends ParametizedGeneral<This>>  {
		private Delegate<?> del;
		public ParametizedGeneral(Delegate<?> delegate)  {
			this.del = delegate;
		}
		
		//I know I can return C for ParametizedC, B for ParametizedB
		//public <R super This> R getSubValue() {
		public <R> R getSubValue() {
			return (R)del.getDelegate();
		}
		
	}
	
	public static class SimpleC implements C{
		
	}
	
	public static class SimpleB implements B {
		
	}
	
	public static class ParametizedC extends ParametizedGeneral<ParametizedC> implements C {
		
		public ParametizedC(Delegate<C> delegate) {
			super(delegate);
		}	
		
		public  void generatePC() {
			new ParametizedC(()->new SimpleC());
		}
	}

	
	public static class ParametizedB extends ParametizedGeneral<ParametizedB> implements B {
		
		public ParametizedB(Delegate<B> delegate) {
			super(delegate);
		}
		
		public void generatePC() {
			new ParametizedB(()->new SimpleB());
		}
	}
	
	public static void main(String[] bla) {
		ParametizedC c = new ParametizedC(()->new SimpleC());
		B b2 = c.getSubValue();
		C c2 = c.getSubValue();
	}
	

}

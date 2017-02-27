package at.ac.tuwien.big.vmod.type.parser;

import java.util.Arrays;
import java.util.Stack;

import at.ac.tuwien.big.virtmod.basic.Treepos;
import at.ac.tuwien.big.virtmod.basic.impl.SimpleTreepos;
import at.ac.tuwien.big.vmod.type.Symbol;
import at.ac.tuwien.big.vmod.type.SymbolImpl;

public interface Parser<T> {
	
	public T unmarshal(String str);
	
	public String marshal(T value);
	
	public static final Parser<Integer> INT_PARSER = new Parser<Integer>() {

		@Override
		public Integer unmarshal(String str) {
			return Integer.valueOf(str);
		}

		@Override
		public String marshal(Integer value) {
			return String.valueOf(value);
		}
		
	};
	
	public static final Parser<String> STRING_PARSER = new Parser<String>() {

		@Override
		public String unmarshal(String str) {
			return str;
		}

		@Override
		public String marshal(String value) {
			return value;
		}
		
	};

	public static Object parseSimple(String str) {
		if (str.startsWith(".")) {
			return TREEPOS_PARSER.unmarshal(str);
		} else {
			try {
				return Integer.valueOf(str);
			} catch (Exception e) {
				return str;
			}
		}
	}
	

	public static final Parser<Object> SYMBOL_PARSER = new Parser<Object>() {

		@Override
		public Object unmarshal(String str) {
			Stack<Object> curObjects = new Stack<>();
			int curPos = 0;
			StringBuilder curStr = new StringBuilder();
			SymbolImpl curSymbol = new SymbolImpl();
			loop: for(; curPos < str.length(); ++curPos) {
				char c = str.charAt(curPos);
				sw: switch(c) {
				case '(':
					curSymbol = new SymbolImpl();
					curSymbol.setName(curStr.toString());
					curObjects.push(curSymbol);
					curStr = new StringBuilder();
					break;
				case ')':
					{String cstr = curStr.toString();
					if (!cstr.isEmpty()) {
						curObjects.push(parseSimple(curStr.toString()));
						curStr = new StringBuilder();
					} 
					curSymbol.addObject(curObjects.pop());}
					Object parAdd = curObjects.pop();
					if (!curObjects.isEmpty()) {
						curSymbol = (SymbolImpl)curObjects.peek();
					}
					curObjects.push(parAdd);
					break;
				case ',':
					{String cstr = curStr.toString();
					if (!cstr.isEmpty()) {
						curObjects.push(parseSimple(curStr.toString()));
						curStr = new StringBuilder();
					} 
					curSymbol.addObject(curObjects.pop());}
					break;
				case ' ':
				case '\t':
				case '\n':
					continue loop;
				case '\'':
					for (; curPos < str.length(); ++curPos) {
						c = str.charAt(curPos);
						if (c == '\'') {
							break sw;
						}
						if (c == '\\' && ++curPos < str.length()) {
							c = str.charAt(curPos);
						}
						curSymbol.addObject(c);
					}
					break;
				default:
					curStr.append(c);
				}
			}
			String cstr = curStr.toString();
			if (!cstr.isEmpty()) {
				curObjects.push(parseSimple(cstr));
				curStr = new StringBuilder();
			}
			return curObjects.pop();
		}

		@Override
		public String marshal(Object value) {
			if (value instanceof Treepos) {
				return TREEPOS_PARSER.marshal((Treepos)value);
			} else if (value instanceof Integer) {
				return INT_PARSER.marshal((Integer)value);
			} else if (value instanceof String) {
				return STRING_PARSER.marshal((String)value);
			} else if (value instanceof Symbol) {
				Symbol symbol = (Symbol)value;
				StringBuilder ret = new StringBuilder();
				ret.append(symbol.getName());
				ret.append("(");
				{
					boolean first = true;
					for (Object o: symbol.subObjects()) {
						if (first) {first =false;} else {ret.append(",");}
						ret.append(SYMBOL_PARSER.marshal(o));
					}
				}
				ret.append(")");
				return ret.toString();
			}
			throw new RuntimeException("Symbol_parser cannot parse "+ value);
		}
		
	};

	public static final Parser<Treepos> TREEPOS_PARSER = new Parser<Treepos>() {

		@Override
		public Treepos unmarshal(String str) {
			String[] spl = str.split("\\.");
			int[] val = new int[spl.length];
			int j = 0;
			for (int i = 0; i < val.length; ++i) {
				if (spl[i].trim().isEmpty()) {
					continue;
				}
				val[j] = Integer.valueOf(spl[i]);
				++j;
			}
			val = Arrays.copyOf(val, j);
			return new SimpleTreepos(val);
		}

		@Override
		public String marshal(Treepos value) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < value.getLevelSize(); ++i) {
				builder.append(".");
				builder.append(value.getLevelValue(i).value());
			}
			return builder.toString();
		}
		
	};

	
	public static final Parser<Object> NOTHING_PARSER = new Parser<Object>() {

		@Override
		public Object unmarshal(String str) {
			throw new UnsupportedOperationException();
		}

		@Override
		public String marshal(Object value) {
			throw new UnsupportedOperationException();
		}
		
	};

	
	public static void main(String[] args) {
		Symbol symb = (Symbol)Parser.SYMBOL_PARSER.unmarshal("f(a,1,g(1,f(r),2),b)");
		System.out.println(symb.debugString());
	}

}

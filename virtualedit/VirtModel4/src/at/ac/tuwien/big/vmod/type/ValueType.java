package at.ac.tuwien.big.vmod.type;

import java.util.Collections;

import at.ac.tuwien.big.vmod.type.parser.Parser;

public class ValueType implements GeneralType {
	public static ValueType Nothing = new ValueType("Nothing",Parser.NOTHING_PARSER);
	public static ValueType Symbol = new ValueType("Symbol",Parser.SYMBOL_PARSER);
	public static ValueType String = new ValueType("String",Parser.STRING_PARSER);
	public static ValueType Integer = new ValueType("Integer",Parser.INT_PARSER);
	public static ValueType Treepos = new ValueType("Treepos",Parser.TREEPOS_PARSER);
	public static ValueType Unspecified = new ValueType("Unspecified",Parser.NOTHING_PARSER);
	
	private Parser<?> parser;
	private String name;
	
	private ValueType(String name,Parser<?> parser) {
		this.parser = parser;
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public Parser<?> parser() {
		return parser;
	}

	@Override
	public Iterable<java.lang.String> getSupportedMetaInfo() {
		return Collections.emptyList();
	}

	@Override
	public GeneralType getType(java.lang.String metainfoElement) {
		return NO_TYPE;
	}
}

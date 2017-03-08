package at.ac.tuwien.big.vmod.type;

import java.util.Collections;

public interface SymbolRegistryType extends GeneralType {

	public static final SymbolRegistryType INSTANCE = new SymbolRegistryType() {
		
		@Override
		public Iterable<String> getSupportedMetaInfo() {
			return Collections.emptyList();
		}

		@Override
		public GeneralType getType(String metainfoElement) {
			return NO_TYPE;
		}
	};
}

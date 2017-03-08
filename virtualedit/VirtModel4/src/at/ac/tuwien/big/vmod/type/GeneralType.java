package at.ac.tuwien.big.vmod.type;

import java.util.Collections;

public interface GeneralType {
	
	public Iterable<String> getSupportedMetaInfo();
	

	public GeneralType getType(String metainfoElement);
	
	

	
	public static final GeneralType NO_TYPE = new GeneralType() {
		
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

package at.ac.tuwien.big.vmod.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ModelResourceType extends ContainerType {
	
	public static ModelResourceType SIMPLE_INSTANCE = new ModelResourceType() {
		
		@Override
		public Iterable<String> getSupportedMetaInfo() {
			return Arrays.asList("uri");
		}

		@Override
		public GeneralType getType(String metainfoElement) {
			if ("uri".equals(metainfoElement)) {
				return ValueType.String;
			} else {
				return NO_TYPE; 
			}
		}
	};
		

}

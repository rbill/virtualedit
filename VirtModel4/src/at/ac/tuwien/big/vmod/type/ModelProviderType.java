package at.ac.tuwien.big.vmod.type;

import java.util.Arrays;

public interface ModelProviderType extends GeneralType {

	/*public static ModelProviderType BASIC_INSTANCE = new ModelProviderType() {
		
		@Override
		public Iterable<String> getSupportedMetaInfo() {
			return Arrays.asList("userModel","resultModel");
		}

		@Override
		public GeneralType getType(String metainfoElement) {
			if ("userModel".equals(metainfoElement)) {
				return ModelResourceType.MODEL_INSTANCE;
			} else if ("resultModel".equals(metainfoElement)) {
				return ModelResourceType.MODEL_INSTANCE;
			}
			return GeneralType.NO_TYPE;
		}
	};*/
	

}

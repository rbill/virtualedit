package at.ac.tuwien.big.virtmod.basic;

public interface Source {
	
	public boolean isGenerated();
	
	static class UnspecifiedSource implements Source {
		
		private boolean isGenerated;
		
		public UnspecifiedSource(boolean isGenerated) {
			this.isGenerated = isGenerated;
		}

		@Override
		public boolean isGenerated() {
			return isGenerated;
		}
		
	}
	
	public static final UnspecifiedSource UNSPECIFIED_GENERATED = new UnspecifiedSource(true);
	public static final UnspecifiedSource UNSPECIFIED_NOnGENERATED = new UnspecifiedSource(false);

}

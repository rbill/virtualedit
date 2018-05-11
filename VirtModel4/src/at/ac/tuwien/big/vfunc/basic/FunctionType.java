package at.ac.tuwien.big.vfunc.basic;

public interface FunctionType<Src,Target> {
	
	public Class<Src> getSourceType();
	
	public Class<Target> getTargetType();

	public default boolean doesMatch(Object srcObj) {
		return srcObj != null && getSourceType().isAssignableFrom(srcObj.getClass());
	}
}

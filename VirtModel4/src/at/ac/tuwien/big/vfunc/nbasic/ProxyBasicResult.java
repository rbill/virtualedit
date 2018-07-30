package at.ac.tuwien.big.vfunc.nbasic;

public class ProxyBasicResult<Target> extends BasicResultImpl<Target> {

	QueryResult<?, Target> proxy;
	private BasicListenable bl;
	
	public ProxyBasicResult(MetaInfo mi, QueryResult<?, Target> proxy) {
		super(mi);
		this.proxy = proxy;
		this.bl = new BasicListenable() {
			
			@Override
			public void changed(BasicChangeNotifyer bcm) {
				ProxyBasicResult.this.refresh();
			}
		};
		this.proxy.addBasicChangeListener(bl);
	}

	@Override
	public Object evaluateNew(Replacer replacer, boolean[] changed) {
		return proxy.evaluateNew(replacer, changed);
	}

	@Override
	public Target calcValue() {
		return proxy.value();
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		proxy.removeBasicChangeListener(bl);
	}
}

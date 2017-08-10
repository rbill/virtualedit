/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.multimodeldesc.ui;

import at.ac.tuwien.big.multimodeldesc.ui.internal.MultimodeldescActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MMDescExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MultimodeldescActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MultimodeldescActivator.getInstance().getInjector(MultimodeldescActivator.AT_AC_TUWIEN_BIG_MULTIMODELDESC_MMDESC);
	}
	
}

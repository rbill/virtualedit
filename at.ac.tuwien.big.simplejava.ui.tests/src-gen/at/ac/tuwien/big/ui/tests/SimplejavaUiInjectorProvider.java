/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.ui.tests;

import at.ac.tuwien.big.simplejava.ui.internal.SimplejavaActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;

public class SimplejavaUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return SimplejavaActivator.getInstance().getInjector("at.ac.tuwien.big.Simplejava");
	}

}

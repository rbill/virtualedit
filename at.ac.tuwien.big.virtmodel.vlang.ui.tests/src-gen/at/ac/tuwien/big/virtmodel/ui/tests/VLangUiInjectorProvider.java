/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.virtmodel.ui.tests;

import at.ac.tuwien.big.virtmodel.vlang.ui.internal.VlangActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;

public class VLangUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return VlangActivator.getInstance().getInjector("at.ac.tuwien.big.virtmodel.VLang");
	}

}

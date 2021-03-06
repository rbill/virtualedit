/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.multimodeldesc.ide

import at.ac.tuwien.big.multimodeldesc.MMDescRuntimeModule
import at.ac.tuwien.big.multimodeldesc.MMDescStandaloneSetup
import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class MMDescIdeSetup extends MMDescStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new MMDescRuntimeModule, new MMDescIdeModule))
	}
	
}

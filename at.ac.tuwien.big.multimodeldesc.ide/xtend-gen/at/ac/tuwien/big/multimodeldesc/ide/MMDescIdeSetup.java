/**
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.multimodeldesc.ide;

import at.ac.tuwien.big.multimodeldesc.MMDescRuntimeModule;
import at.ac.tuwien.big.multimodeldesc.MMDescStandaloneSetup;
import at.ac.tuwien.big.multimodeldesc.ide.MMDescIdeModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class MMDescIdeSetup extends MMDescStandaloneSetup {
  @Override
  public Injector createInjector() {
    MMDescRuntimeModule _mMDescRuntimeModule = new MMDescRuntimeModule();
    MMDescIdeModule _mMDescIdeModule = new MMDescIdeModule();
    return Guice.createInjector(Modules2.mixin(_mMDescRuntimeModule, _mMDescIdeModule));
  }
}
/*
 * generated by Xtext 2.11.0
 */
package at.ac.tuwien.big.school


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class SchoolTextStandaloneSetup extends SchoolTextStandaloneSetupGenerated {

	def static void doSetup() {
		new SchoolTextStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}

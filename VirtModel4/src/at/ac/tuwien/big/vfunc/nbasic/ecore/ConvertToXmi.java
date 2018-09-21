package at.ac.tuwien.big.vfunc.nbasic.ecore;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import at.ac.tuwien.big.virtlang.VirtLangStandaloneSetup;


public class ConvertToXmi {
	

	public static Resource getEcoreResource(File ecsslFile) throws IOException {
		Injector injector = new VirtLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		Resource ecsslResource = rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
		return ecsslResource; 
	} 

	public static Resource getOrCreateXmiResource(File file) throws IOException {
		Injector injector = new VirtLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		if (file.exists()) {
			Resource ecsslResource = rs.getResource(URI.createFileURI(file.getCanonicalPath()), true);
			return ecsslResource;
		} else {
			Resource ecsslResource = rs.createResource(URI.createFileURI(file.getCanonicalPath()));
			return ecsslResource;
		}
	} 
	
	public static Resource getVirtLangResource(File ecsslFile) throws IOException {
		Injector injector = new VirtLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		Resource ecsslResource = rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
		return ecsslResource; 
	}
	
	public static Resource getXmiResource(File ecsslFile) throws IOException {
		Injector injector = new VirtLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet rs = injector.getInstance(XtextResourceSet.class);
		Resource ecsslResource = rs.getResource(URI.createFileURI(ecsslFile.getCanonicalPath()), true);
		return ecsslResource; 
	}

}

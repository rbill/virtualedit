package at.ac.tuwien.big.virtualxtext;

import org.eclipse.ui.plugin.*;
import org.eclipse.core.runtime.*;
import org.eclipse.core.resources.*;

/**
 * The main plugin class to be used in the desktop.
 */
public class ResourceListPlugin extends AbstractUIPlugin {
	//The shared instance.
	private static ResourceListPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public ResourceListPlugin(IPluginDescriptor descriptor) {
		super(descriptor);
		plugin = this;
	}

	/**
	 * Returns the shared instance.
	 */
	public static ResourceListPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the workspace instance.
	 */
	public static IWorkspace getWorkspace() {
		return ResourcesPlugin.getWorkspace();
	}
}

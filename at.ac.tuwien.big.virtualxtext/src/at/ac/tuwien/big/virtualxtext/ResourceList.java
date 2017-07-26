package at.ac.tuwien.big.virtualxtext;

import java.awt.Color;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.*;
import java.util.*;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;
import org.eclipse.ui.part.ViewPart;

import at.ac.tuwien.big.vmod.registry.ResourceSetInfo;
import at.ac.tuwien.big.vmod.registry.ViewState;
import at.ac.tuwien.big.vmod.registry.ResourceSetInfo.ResourceInfo;

/**
 * A WordView shows a bunch of words.
 */
public class ResourceList extends ViewPart implements ISelectionListener, IPartListener2
{
	ResourceSetInfo info;
	//ListViewer viewer;
	TableViewer viewer;
	//Action addItemAction, deleteItemAction, selectAllAction;
	IMemento memento;
	WeakReference<IWorkbenchPage> page;
	Set<Resource> lastDisabled = new HashSet<>();
	
	/**
	 * Constructor
	 */
	public ResourceList() {
		super();
	}


	public ResourceRef getResource(String uri) {
		Resource res = info.getResourceSet().getResource(URI.createURI(uri),false);
		if (res == null) {
			return null;
		}
		return ResourceListContentProvider.getRef(res);
	}
	/**
	 * @see IViewPart.init(IViewSite)
	 */
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
	}

	/**
	 * Initializes this view with the given view site.  A memento is passed to
 	 * the view which contains a snapshot of the views state from a previous
	 * session.  	
	 */
	public void init(IViewSite site,IMemento memento) throws PartInitException {
		init(site);
		this.memento = memento;	
		IWorkbenchPage wpage = site.getPage();
		page = new WeakReference<IWorkbenchPage>(wpage);
		wpage.addPartListener(this);
		for (IEditorReference part: wpage.getEditorReferences()) {
			IEditorPart editor = part.getEditor(false);
			if (editor instanceof VMXtextEditor) {
				setEditor((VMXtextEditor)editor);
			}
		}
	}
	
	/**
	 * @see IWorkbenchPart#createPartControl(Composite)
	 */
	public void createPartControl(Composite parent) {
		// Create viewer.
		TableViewer tviewer = new TableViewer(parent);
		Table table = tviewer.getTable();
		//TableColumn iconColumn = new TableColumn(table, 0, 1);
		
		viewer = tviewer;
		viewer.setContentProvider(new ResourceListContentProvider());
		IBaseLabelProvider prov;
		/*viewer.setLabelProvider(
				new LabelProvider());*/
		viewer.setLabelProvider(new ITableLabelProvider() {
			

			static final int IMAGE_WIDTH = 16
					, IMAGE_HEIGHT=16;
			
			@Override
			public void removeListener(ILabelProviderListener listener) {
				
			}
			
			@Override
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}
			
			@Override
			public void dispose() {				
			}
			
			@Override
			public void addListener(ILabelProviderListener listener) {
						}
			
			@Override
			public String getColumnText(Object element, int columnIndex) {
				if (element instanceof ResourceRef) {
					return String.valueOf(element);
				}
				return null;
			}
			
			private Image[] images = null;
			
			int[] imageRewrite = new int[]{0,9,5,2,7,1,3,6,8,4};
			
			private int getPixelValue(int red, int green, int blue) {
				return (red<<16)|(green<<8)|blue; //???
			}
			
			private int getPixelValue(int index) {
				if (index == 0) {
					return 0xDDDDDDDD; //grey ...
				}
				index = index-1;
				if (index < imageRewrite.length) {
					index = imageRewrite[index];
				}
				int maxHueue = 220;
				int minHueue = 40;
				float h = (float)((minHueue+index*(maxHueue-minHueue)/(VMXtextEditor.MAX_ANNOTATION_COLORS-1.0))/255.0f);
				float s = 1.f;
				float b = 255.f/255.f;
				Color color = Color.getHSBColor(h, s, b);
				return color.getRGB();
			}
			
			private void calcImages() {
				images = new Image[11];
				PaletteData palette = new PaletteData(0x00FF0000 , 0x0000FF00 , 0x000000FF);
				for (int i = 0; i <= VMXtextEditor.MAX_ANNOTATION_COLORS; ++i) {
					ImageData data = new ImageData(IMAGE_WIDTH, IMAGE_HEIGHT, 24, palette);
					int pixelValue = getPixelValue(i);
					for (int y = 0; y < IMAGE_HEIGHT; ++y) {
						for (int x = 0; x < IMAGE_HEIGHT; ++x) {
							data.setPixel(x, y, pixelValue);
						}
					}
					Image newImage = new Image(null, data);
					images[i] = newImage;
				}
			}
			
			private Image getImage(int index) {
				if (images == null) {
					calcImages();
				}
				index=index+1;
				if (index >= images.length) {
					index = 0;
				}
				return images[index];
			}
			
			@Override
			public Image getColumnImage(Object element, int columnIndex) {
				if (columnIndex == 0) {
					if (!(element instanceof ResourceRef)) {
						System.err.println("Wrong element type: "+element+"!");
						new Exception().printStackTrace();
					} else {
						ResourceRef el = (ResourceRef)element;
						int imageIndex = editor.getImageIndex(el.getResource());
						System.out.println("ResourceRef "+element+" with index "+imageIndex);
						return getImage(imageIndex);
					}
				}
				return null;
			}
		});
		viewer.setInput(this);
		if (getResourceInfo() != null) {
			viewer.setSelection(getSelection());
		}
		
		getSite().setSelectionProvider(viewer);

		// Create menu and toolbars.
		createActions();
//		createMenu();
//		createToolbar();
//		createContextMenu();
		hookGlobalActions();
		
		// Restore state from the previous session.
		restoreState();
	}
	
	/**
	 * @see WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * Create the actions.
	 */
	public void createActions() {
		// Add selection listener.
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				//Update everything
				ISelection newSelection = event.getSelection();
				ResourceList.this.selectionChanged(newSelection);
			}
		});
	}

	/**
	 * Returns the image descriptor with the given relative path.
	 */
	private ImageDescriptor getImageDescriptor(String relativePath) {
		String iconPath = "icons/";
		try {
			ResourceListPlugin plugin = ResourceListPlugin.getDefault();
			URL installURL = plugin.getDescriptor().getInstallURL();
			URL url = new URL(installURL, iconPath + relativePath);
			return ImageDescriptor.createFromURL(url);
		}
		catch (MalformedURLException e) {
			// should not happen
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
	
//	/**
//	 * Create menu.
//	 */
//	private void createMenu() {
//		IMenuManager mgr = getViewSite().getActionBars().getMenuManager();
//		mgr.add(selectAllAction);
//	}
//	
//	/**
//	 * Create toolbar.
//	 */
//	private void createToolbar() {
//		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
//		mgr.add(addItemAction);
//		mgr.add(deleteItemAction);
//	}
		
	/**
	 * Create context menu.
	 */
	private void createContextMenu() {
		// Create menu manager.
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillContextMenu(mgr);
			}
		});
		
		// Create menu.
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		
		// Register menu for extension.
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/**
	 * Hook global actions
	 */
	private void hookGlobalActions() {
		IActionBars bars = getViewSite().getActionBars();
//		bars.setGlobalActionHandler(IWorkbenchActionConstants.SELECT_ALL, selectAllAction);
//		bars.setGlobalActionHandler(IWorkbenchActionConstants.DELETE, deleteItemAction);
//		viewer.getControl().addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent event) {
//				if (event.character == SWT.DEL && 
//					event.stateMask == 0 && 
//					deleteItemAction.isEnabled()) 
//				{
//					deleteItemAction.run();
//				}
//			}
//		});
	}
		
	private void fillContextMenu(IMenuManager mgr) {
//		mgr.add(addItemAction);
//		mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
//		mgr.add(deleteItemAction);
//		mgr.add(new Separator());
//		mgr.add(selectAllAction);
	}
	private void updateActionEnablement() {
		IStructuredSelection sel = 
			(IStructuredSelection)viewer.getSelection();
		//deleteItemAction.setEnabled(sel.size() > 0);
	}
			
	/**
	 * Ask user for value.
	 */
	private String promptForValue(String text, String oldValue) {
		InputDialog dlg = new InputDialog(getSite().getShell(), 
			"List View", text, oldValue, null);
		if (dlg.open() != Window.OK)
			return null;
		return dlg.getValue();
	}
	
	/**
	 * Saves the object state within a memento.
	 */
	public void saveState(IMemento memento){
		IStructuredSelection sel = (IStructuredSelection)viewer.getSelection();
		if (sel.isEmpty())
			return;
		memento = memento.createChild("selection");
		Iterator iter = sel.iterator();
		while (iter.hasNext()) {
			ResourceRef word = (ResourceRef)iter.next();
			memento.createChild("descriptor", word.getResource().getURI().toString());
		}
	}

	/**
	 * Restores the viewer state from the memento.
	 */
	private void restoreState() {
		if (memento == null || memento != null)
			return;
		memento = memento.getChild("selection");
		if (memento != null) {
			IMemento descriptors [] = memento.getChildren("descriptor");
			if (descriptors.length > 0) {
				ArrayList<ResourceRef> objList = new ArrayList<>(descriptors.length);
				for (int nX = 0; nX < descriptors.length; nX ++) {
					String uri = descriptors[nX].getID();
					ResourceRef ref = getResource(uri);
					if (ref != null)
						objList.add(ref);		
				}
				viewer.setSelection(new StructuredSelection(objList));
			}
		}
		memento = null;
		updateActionEnablement();
	}
	
	public StructuredSelection getSelection() {
		List<ResourceRef> elements = new ArrayList<>();
		ViewState state = getResourceInfo().getContainedViewState();
		state.setTotalViews(getResourceInfo().getAllViews());
		for (Resource res: state.enabledViews()) {
			elements.add(ResourceListContentProvider.getRef(res));
		}
		return new StructuredSelection(elements);
	}

	public void updatedInfo() {		
		StructuredSelection selection = getSelection();
		if (viewer != null) {
			viewer.setInput(this);
			viewer.refresh(false);
			viewer.setSelection(selection);
		}
	}
	
	VMXtextEditor editor;
	
	public void update(IWorkbenchPartReference ref) {
		if (ref instanceof IEditorReference) {
			IEditorReference eref = (IEditorReference)ref;
			IEditorPart edpart = eref.getEditor(false);
			if (edpart instanceof VMXtextEditor) {
				//TODO: Vorher war das setEditor(editor)
				setEditor((VMXtextEditor)edpart);
			}
		}
	}
	
	private void setEditor(VMXtextEditor edpart) {
		editor = edpart;
		if (editor == null) {
			return;
		}
		ResourceSetInfo newInfo = editor.getResourceInfo();
		boolean updateInfo = false;
		if (!Objects.equals(info, newInfo)) {
			info = newInfo;
			updateInfo = true;
		}
		if (updateInfo) {
			updatedInfo();
		}
	}
	
	/**
	 * @see ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		selectionChanged(selection);
	}
	
	public void selectionChanged(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection)selection;
			List<Resource> disabled = new ArrayList<Resource>(info.getAllViews());
			List<Resource> enabled = new ArrayList<Resource>();
			for (Object o: (Iterable)()->iss.iterator()) {
				if (o instanceof ResourceRef) {
					ResourceRef rr = (ResourceRef)o;
					Resource r = rr.getResource();
					disabled.remove(r);
					enabled.add(r);
				}
			}
			ViewState state = info.getContainedViewState();
			boolean update = state.addToView(enabled);
			update|= state.deleteFromView(disabled);
			//Update XtextEditor ...
			if (update) {
				System.out.println("Updated view state!");
				if (editor == null || editor.getSuperDocument() == null) {
					//Select new editor
					IWorkbenchPage wpage = page.get();
					for (IEditorReference part: wpage.getEditorReferences()) {
						IEditorPart editor = part.getEditor(false);
						if (editor instanceof VMXtextEditor) {
							VMXtextEditor vme = (VMXtextEditor)editor;
							setEditor(vme);
							if (wpage.getActiveEditor() == vme) {
								break;
							}
						}
					}
				}
				if (editor != null && editor.getSuperDocument() != null) {
					editor.recalculateFile(false);
				}
			}
		}
	}

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		update(partRef);
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		update(partRef);
	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		
	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		update(partRef);
	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
		update(partRef);
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
		update(partRef);
	}

	public ViewState getViewState() {
		return info.getContainedViewState();
	}

	public ResourceSetInfo getResourceInfo() {
		return info;
	}	
	
	@Override
	public void dispose() {
		if (page != null) {
			IWorkbenchPage wp = page.get();
			if (wp != null) {
				wp.removePartListener(this);
			}
		}
		super.dispose();
	}


	
}

/**
 */
package simplejava.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import simplejava.PointcutMethodFilter;
import simplejava.SimplejavaFactory;
import simplejava.SimplejavaPackage;

/**
 * This is the item provider adapter for a {@link simplejava.PointcutMethodFilter} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PointcutMethodFilterItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointcutMethodFilterItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIsPublicPropertyDescriptor(object);
			addIsPrivatePropertyDescriptor(object);
			addIsStaticPropertyDescriptor(object);
			addAnyReturnPropertyDescriptor(object);
			addAnyClassPropertyDescriptor(object);
			addClassTypePropertyDescriptor(object);
			addAnyMethodPropertyDescriptor(object);
			addMethodNamePropertyDescriptor(object);
			addAnyParameterPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Public feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsPublicPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_isPublic_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_isPublic_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__IS_PUBLIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Private feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsPrivatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_isPrivate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_isPrivate_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__IS_PRIVATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Static feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsStaticPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_isStatic_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_isStatic_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__IS_STATIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Any Return feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnyReturnPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_anyReturn_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_anyReturn_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__ANY_RETURN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Any Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnyClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_anyClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_anyClass_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__ANY_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Class Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_classType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_classType_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__CLASS_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Any Method feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnyMethodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_anyMethod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_anyMethod_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__ANY_METHOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Method Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMethodNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_methodName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_methodName_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__METHOD_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Any Parameter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnyParameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PointcutMethodFilter_anyParameter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PointcutMethodFilter_anyParameter_feature", "_UI_PointcutMethodFilter_type"),
				 SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__ANY_PARAMETER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__RETURN_TYPE);
			childrenFeatures.add(SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__PARAMETER);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns PointcutMethodFilter.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PointcutMethodFilter"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PointcutMethodFilter)object).getMethodName();
		return label == null || label.length() == 0 ?
			getString("_UI_PointcutMethodFilter_type") :
			getString("_UI_PointcutMethodFilter_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PointcutMethodFilter.class)) {
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__IS_PUBLIC:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__IS_PRIVATE:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__IS_STATIC:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__ANY_RETURN:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__ANY_CLASS:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__ANY_METHOD:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__METHOD_NAME:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__ANY_PARAMETER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__RETURN_TYPE:
			case SimplejavaPackage.POINTCUT_METHOD_FILTER__PARAMETER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__RETURN_TYPE,
				 SimplejavaFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__PARAMETER,
				 SimplejavaFactory.eINSTANCE.createType()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__RETURN_TYPE ||
			childFeature == SimplejavaPackage.Literals.POINTCUT_METHOD_FILTER__PARAMETER;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SimplejavaEditPlugin.INSTANCE;
	}

}

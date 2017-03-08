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

import simplejava.Advice;
import simplejava.SimplejavaFactory;
import simplejava.SimplejavaPackage;

/**
 * This is the item provider adapter for a {@link simplejava.Advice} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AdviceItemProvider 
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
	public AdviceItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Advice_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Advice_type_feature", "_UI_Advice_type"),
				 SimplejavaPackage.Literals.ADVICE__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(SimplejavaPackage.Literals.ADVICE__PARAMETER);
			childrenFeatures.add(SimplejavaPackage.Literals.ADVICE__POINTCUT);
			childrenFeatures.add(SimplejavaPackage.Literals.ADVICE__CODE);
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
	 * This returns Advice.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Advice"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Advice)object).getType();
		return label == null || label.length() == 0 ?
			getString("_UI_Advice_type") :
			getString("_UI_Advice_type") + " " + label;
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

		switch (notification.getFeatureID(Advice.class)) {
			case SimplejavaPackage.ADVICE__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SimplejavaPackage.ADVICE__PARAMETER:
			case SimplejavaPackage.ADVICE__POINTCUT:
			case SimplejavaPackage.ADVICE__CODE:
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
				(SimplejavaPackage.Literals.ADVICE__PARAMETER,
				 SimplejavaFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createSimpleJava()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createAspect()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createForeignAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createPointcut()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createPointcutCondition()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createUnaryPointcutCondition()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createBinaryPointcutCondition()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createSimplePointcutCondition()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createPointcutMethodFilter()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createPointcutTypeFilter()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createAdvice()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createPointcutRef()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createPackageDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createImport()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createClassDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createMethodBlock()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createSimpleStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createSimpleVariableDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createVariableDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createForInStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createReturnStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createMethodCall()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createGenericExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createConstantExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createNullExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createIntegerExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createBooleanExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createStringExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__POINTCUT,
				 SimplejavaFactory.eINSTANCE.createParanthesisOrBinaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.ADVICE__CODE,
				 SimplejavaFactory.eINSTANCE.createMethodBlock()));
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
			childFeature == SimplejavaPackage.Literals.ADVICE__PARAMETER ||
			childFeature == SimplejavaPackage.Literals.ADVICE__POINTCUT ||
			childFeature == SimplejavaPackage.Literals.ADVICE__CODE;

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

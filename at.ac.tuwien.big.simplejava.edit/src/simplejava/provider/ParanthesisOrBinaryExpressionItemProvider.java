/**
 */
package simplejava.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import simplejava.ParanthesisOrBinaryExpression;
import simplejava.SimplejavaFactory;
import simplejava.SimplejavaPackage;

/**
 * This is the item provider adapter for a {@link simplejava.ParanthesisOrBinaryExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ParanthesisOrBinaryExpressionItemProvider extends GenericExpressionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParanthesisOrBinaryExpressionItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_ParanthesisOrBinaryExpression_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParanthesisOrBinaryExpression_type_feature", "_UI_ParanthesisOrBinaryExpression_type"),
				 SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__TYPE,
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
			childrenFeatures.add(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE);
			childrenFeatures.add(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT);
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
	 * This returns ParanthesisOrBinaryExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ParanthesisOrBinaryExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ParanthesisOrBinaryExpression)object).getType();
		return label == null || label.length() == 0 ?
			getString("_UI_ParanthesisOrBinaryExpression_type") :
			getString("_UI_ParanthesisOrBinaryExpression_type") + " " + label;
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

		switch (notification.getFeatureID(ParanthesisOrBinaryExpression.class)) {
			case SimplejavaPackage.PARANTHESIS_OR_BINARY_EXPRESSION__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SimplejavaPackage.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE:
			case SimplejavaPackage.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT:
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
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createMethodCall()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createGenericExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createConstantExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createNullExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createIntegerExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createBooleanExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createStringExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE,
				 SimplejavaFactory.eINSTANCE.createParanthesisOrBinaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createMethodCall()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createGenericExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createConstantExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createNullExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createIntegerExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createBooleanExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createStringExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT,
				 SimplejavaFactory.eINSTANCE.createParanthesisOrBinaryExpression()));
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
			childFeature == SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__SOURCE ||
			childFeature == SimplejavaPackage.Literals.PARANTHESIS_OR_BINARY_EXPRESSION__ARGUMENT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}

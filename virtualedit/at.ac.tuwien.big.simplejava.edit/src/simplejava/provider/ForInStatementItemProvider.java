/**
 */
package simplejava.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import simplejava.ForInStatement;
import simplejava.SimplejavaFactory;
import simplejava.SimplejavaPackage;

/**
 * This is the item provider adapter for a {@link simplejava.ForInStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForInStatementItemProvider extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForInStatementItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(SimplejavaPackage.Literals.FOR_IN_STATEMENT__SUBPARAMETER);
			childrenFeatures.add(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION);
			childrenFeatures.add(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY);
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
	 * This returns ForInStatement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ForInStatement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ForInStatement_type");
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

		switch (notification.getFeatureID(ForInStatement.class)) {
			case SimplejavaPackage.FOR_IN_STATEMENT__SUBPARAMETER:
			case SimplejavaPackage.FOR_IN_STATEMENT__EXPRESSION:
			case SimplejavaPackage.FOR_IN_STATEMENT__BODY:
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
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__SUBPARAMETER,
				 SimplejavaFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createMethodCall()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createGenericExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createConstantExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createNullExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createIntegerExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createBooleanExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createStringExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION,
				 SimplejavaFactory.eINSTANCE.createParanthesisOrBinaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createMethodBlock()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createVariableDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createIfStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createForStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createForInStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createWhileStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createReturnStatement()));

		newChildDescriptors.add
			(createChildParameter
				(SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY,
				 SimplejavaFactory.eINSTANCE.createMethodCall()));
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
			childFeature == SimplejavaPackage.Literals.FOR_IN_STATEMENT__EXPRESSION ||
			childFeature == SimplejavaPackage.Literals.FOR_IN_STATEMENT__BODY;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}

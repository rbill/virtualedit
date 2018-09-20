/**
 */
package VObjectModel.impl;

import VObjectModel.AnyValue;
import VObjectModel.CreatorId;
import VObjectModel.Identifier;
import VObjectModel.IdentifierCmp;
import VObjectModel.IdentifierRef;
import VObjectModel.IdentifierRefOrCmp;
import VObjectModel.JavaValue;
import VObjectModel.VObjectModelPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link VObjectModel.impl.IdentifierImpl#getIdentifierreforcmp <em>Identifierreforcmp</em>}</li>
 *   <li>{@link VObjectModel.impl.IdentifierImpl#getName <em>Name</em>}</li>
 *   <li>{@link VObjectModel.impl.IdentifierImpl#getCreatorid <em>Creatorid</em>}</li>
 *   <li>{@link VObjectModel.impl.IdentifierImpl#getHc <em>Hc</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifierImpl extends MinimalEObjectImpl.Container implements Identifier {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getHc() <em>Hc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHc()
	 * @generated
	 * @ordered
	 */
	protected static final int HC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIdentifierreforcmp() <em>Identifierreforcmp</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierreforcmp()
	 * @generated
	 * @ordered
	 */
	protected EList<AnyValue> identifierreforcmp;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCreatorid() <em>Creatorid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatorid()
	 * @generated
	 * @ordered
	 */
	protected CreatorId creatorid;

	/**
	 * The cached value of the '{@link #getHc() <em>Hc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHc()
	 * @generated
	 * @ordered
	 */
	protected int hc = HC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreatorid(CreatorId newCreatorid, NotificationChain msgs) {
		CreatorId oldCreatorid = this.creatorid;
		this.creatorid = newCreatorid;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER__CREATORID, oldCreatorid, newCreatorid);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER__IDENTIFIERREFORCMP:
				return getIdentifierreforcmp();
			case VObjectModelPackage.IDENTIFIER__NAME:
				return getName();
			case VObjectModelPackage.IDENTIFIER__CREATORID:
				return getCreatorid();
			case VObjectModelPackage.IDENTIFIER__HC:
				return getHc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER__IDENTIFIERREFORCMP:
				return ((InternalEList<?>)getIdentifierreforcmp()).basicRemove(otherEnd, msgs);
			case VObjectModelPackage.IDENTIFIER__CREATORID:
				return basicSetCreatorid(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case VObjectModelPackage.IDENTIFIER___HASH_CODE:
				return hashCode();
			case VObjectModelPackage.IDENTIFIER___EQUALS__IDENTIFIER:
				return equals((Identifier)arguments.get(0));
			case VObjectModelPackage.IDENTIFIER___INIT:
				init();
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER__IDENTIFIERREFORCMP:
				return this.identifierreforcmp != null && !this.identifierreforcmp.isEmpty();
			case VObjectModelPackage.IDENTIFIER__NAME:
				return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
			case VObjectModelPackage.IDENTIFIER__CREATORID:
				return this.creatorid != null;
			case VObjectModelPackage.IDENTIFIER__HC:
				return this.hc != HC_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean equals(Identifier id) {
		if (this == id) {return true;}
		if (this.hc != id.getHc()) {
			return false;
		}
		if (this.creatorid != null) {
			CreatorId otherId = id.getCreatorid();
			if (otherId == null) {
				return false;
			}
			if (!Objects.equals(this.creatorid.getName(), otherId.getName()) || !Objects.equals(this.creatorid.getNamespace(), otherId.getNamespace())) {
				return false;
			}
		} else if (id.getCreatorid() != null) {
			return false;
		}
		if (this.identifierreforcmp.size() != id.getIdentifierreforcmp().size()) {
			return false;
		}
		Iterator<AnyValue> thisIter = this.identifierreforcmp.iterator();
		Iterator<AnyValue> otherIter = id.getIdentifierreforcmp().iterator();
		while (thisIter.hasNext() && otherIter.hasNext()) {
			AnyValue av = thisIter.next();
			AnyValue ov = otherIter.next();
			if (av instanceof JavaValue) {
				if (!(ov instanceof JavaValue)) {
					return false;
				}
				if (!Objects.equals(((JavaValue)av).getValue(), ((JavaValue)ov).getValue())) {
					return false;
				}
			} else if (av instanceof IdentifierRefOrCmp) {
				if (!(ov instanceof IdentifierRefOrCmp)) {
					return false;
				}
				Identifier first = null;
				Identifier second = null;
				if (av instanceof IdentifierRef) {
					first = ((IdentifierRef)av).getS_identifier();
				} else if (av instanceof IdentifierCmp) {
					first = ((IdentifierCmp)av).getS_identifier();
				} else {
					throw new UnsupportedOperationException("Don't know roc type "+ av);
				}
				if (ov instanceof IdentifierRef) {
					second = ((IdentifierRef)ov).getS_identifier();
				} else if (ov instanceof IdentifierCmp) {
					second = ((IdentifierCmp)ov).getS_identifier();
				} else {
					throw new UnsupportedOperationException("Don't know roc type "+ av);
				}
				if (first == null || second == null) {
					if (first != second) {return false;}
				} else {
					if (!first.equals(second)) {
						return false;
					}
				}
			} else {
				throw new UnsupportedOperationException("Don't know type "+ av);
			}
		}
		return true;
	}

	@Override
	/**
	 * @generated NOT
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Identifier) {
			return equals((Identifier)obj);
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER__IDENTIFIERREFORCMP:
				getIdentifierreforcmp().clear();
				getIdentifierreforcmp().addAll((Collection<? extends AnyValue>)newValue);
				return;
			case VObjectModelPackage.IDENTIFIER__NAME:
				setName((String)newValue);
				return;
			case VObjectModelPackage.IDENTIFIER__CREATORID:
				setCreatorid((CreatorId)newValue);
				return;
			case VObjectModelPackage.IDENTIFIER__HC:
				setHc((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VObjectModelPackage.Literals.IDENTIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VObjectModelPackage.IDENTIFIER__IDENTIFIERREFORCMP:
				getIdentifierreforcmp().clear();
				return;
			case VObjectModelPackage.IDENTIFIER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VObjectModelPackage.IDENTIFIER__CREATORID:
				setCreatorid((CreatorId)null);
				return;
			case VObjectModelPackage.IDENTIFIER__HC:
				setHc(HC_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreatorId getCreatorid() {
		return this.creatorid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHc() {
		return this.hc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AnyValue> getIdentifierreforcmp() {
		if (this.identifierreforcmp == null) {
			this.identifierreforcmp = new EObjectContainmentEList<>(AnyValue.class, this, VObjectModelPackage.IDENTIFIER__IDENTIFIERREFORCMP);
		}
		return this.identifierreforcmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int hashCode() {
		return this.hc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void init() {
		if (this.creatorid != null) {
			this.hc = Objects.hash(this.creatorid.getNamespace(),this.creatorid.getName(),this.identifierreforcmp);
		} else {
			this.hc = Objects.hash(this.identifierreforcmp);
		}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreatorid(CreatorId newCreatorid) {
		if (newCreatorid != this.creatorid) {
			NotificationChain msgs = null;
			if (this.creatorid != null)
				msgs = ((InternalEObject)this.creatorid).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.IDENTIFIER__CREATORID, null, msgs);
			if (newCreatorid != null)
				msgs = ((InternalEObject)newCreatorid).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VObjectModelPackage.IDENTIFIER__CREATORID, null, msgs);
			msgs = basicSetCreatorid(newCreatorid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER__CREATORID, newCreatorid, newCreatorid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHc(int newHc) {
		int oldHc = this.hc;
		this.hc = newHc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER__HC, oldHc, this.hc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = this.name;
		this.name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VObjectModelPackage.IDENTIFIER__NAME, oldName, this.name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(this.creatorid);
		result.append("(");
		{
			boolean first = true;
			for (AnyValue s: getIdentifierreforcmp()) {
				if (first) {first=false;} else {result.append(",");}
				result.append(s);
			}
		}
		result.append(")");
		return result.toString();
	}

} //IdentifierImpl

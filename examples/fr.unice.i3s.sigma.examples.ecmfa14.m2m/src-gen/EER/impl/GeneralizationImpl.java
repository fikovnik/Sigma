/**
 */
package EER.impl;

import EER.Attribute;
import EER.EERPackage;
import EER.Generalization;
import EER.GeneralizationRelationship;
import EER.GeneralizationType;
import EER.SpecializationRelationship;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.GeneralizationImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link EER.impl.GeneralizationImpl#getChilds <em>Childs</em>}</li>
 *   <li>{@link EER.impl.GeneralizationImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link EER.impl.GeneralizationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationImpl extends AttributedNodeImpl implements Generalization
{
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected SpecializationRelationship parent;

	/**
	 * The cached value of the '{@link #getChilds() <em>Childs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChilds()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralizationRelationship> childs;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected Attribute attribute;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final GeneralizationType TYPE_EDEFAULT = GeneralizationType.TOTAL_OVERLAPPING;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected GeneralizationType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralizationImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return EERPackage.Literals.GENERALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationRelationship getParent()
	{
		if (parent != null && parent.eIsProxy())
		{
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (SpecializationRelationship)eResolveProxy(oldParent);
			if (parent != oldParent)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EERPackage.GENERALIZATION__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationRelationship basicGetParent()
	{
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(SpecializationRelationship newParent, NotificationChain msgs)
	{
		SpecializationRelationship oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(SpecializationRelationship newParent)
	{
		if (newParent != parent)
		{
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP, SpecializationRelationship.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP, SpecializationRelationship.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationRelationship> getChilds()
	{
		if (childs == null)
		{
			childs = new EObjectWithInverseResolvingEList<GeneralizationRelationship>(GeneralizationRelationship.class, this, EERPackage.GENERALIZATION__CHILDS, EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP);
		}
		return childs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAttribute()
	{
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttribute(Attribute newAttribute, NotificationChain msgs)
	{
		Attribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION__ATTRIBUTE, oldAttribute, newAttribute);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(Attribute newAttribute)
	{
		if (newAttribute != attribute)
		{
			NotificationChain msgs = null;
			if (attribute != null)
				msgs = ((InternalEObject)attribute).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EERPackage.GENERALIZATION__ATTRIBUTE, null, msgs);
			if (newAttribute != null)
				msgs = ((InternalEObject)newAttribute).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EERPackage.GENERALIZATION__ATTRIBUTE, null, msgs);
			msgs = basicSetAttribute(newAttribute, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION__ATTRIBUTE, newAttribute, newAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(GeneralizationType newType)
	{
		GeneralizationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EERPackage.GENERALIZATION__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP, SpecializationRelationship.class, msgs);
				return basicSetParent((SpecializationRelationship)otherEnd, msgs);
			case EERPackage.GENERALIZATION__CHILDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChilds()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EERPackage.GENERALIZATION__PARENT:
				return basicSetParent(null, msgs);
			case EERPackage.GENERALIZATION__CHILDS:
				return ((InternalEList<?>)getChilds()).basicRemove(otherEnd, msgs);
			case EERPackage.GENERALIZATION__ATTRIBUTE:
				return basicSetAttribute(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case EERPackage.GENERALIZATION__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case EERPackage.GENERALIZATION__CHILDS:
				return getChilds();
			case EERPackage.GENERALIZATION__ATTRIBUTE:
				return getAttribute();
			case EERPackage.GENERALIZATION__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case EERPackage.GENERALIZATION__PARENT:
				setParent((SpecializationRelationship)newValue);
				return;
			case EERPackage.GENERALIZATION__CHILDS:
				getChilds().clear();
				getChilds().addAll((Collection<? extends GeneralizationRelationship>)newValue);
				return;
			case EERPackage.GENERALIZATION__ATTRIBUTE:
				setAttribute((Attribute)newValue);
				return;
			case EERPackage.GENERALIZATION__TYPE:
				setType((GeneralizationType)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case EERPackage.GENERALIZATION__PARENT:
				setParent((SpecializationRelationship)null);
				return;
			case EERPackage.GENERALIZATION__CHILDS:
				getChilds().clear();
				return;
			case EERPackage.GENERALIZATION__ATTRIBUTE:
				setAttribute((Attribute)null);
				return;
			case EERPackage.GENERALIZATION__TYPE:
				setType(TYPE_EDEFAULT);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case EERPackage.GENERALIZATION__PARENT:
				return parent != null;
			case EERPackage.GENERALIZATION__CHILDS:
				return childs != null && !childs.isEmpty();
			case EERPackage.GENERALIZATION__ATTRIBUTE:
				return attribute != null;
			case EERPackage.GENERALIZATION__TYPE:
				return type != TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //GeneralizationImpl

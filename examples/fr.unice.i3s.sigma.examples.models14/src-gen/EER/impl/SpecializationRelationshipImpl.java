/**
 */
package EER.impl;

import EER.EERPackage;
import EER.Entity;
import EER.Generalization;
import EER.SpecializationRelationship;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialization Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.SpecializationRelationshipImpl#getSource <em>Source</em>}</li>
 *   <li>{@link EER.impl.SpecializationRelationshipImpl#getRelationship <em>Relationship</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecializationRelationshipImpl extends MinimalEObjectImpl.Container implements SpecializationRelationship
{
	/**
	 * The cached value of the '{@link #getRelationship() <em>Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationship()
	 * @generated
	 * @ordered
	 */
	protected Generalization relationship;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializationRelationshipImpl()
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
		return EERPackage.Literals.SPECIALIZATION_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getSource()
	{
		if (eContainerFeatureID() != EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE) return null;
		return (Entity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Entity newSource, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newSource, EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Entity newSource)
	{
		if (newSource != eInternalContainer() || (eContainerFeatureID() != EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE && newSource != null))
		{
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EERPackage.ENTITY__IS_SPECIALIZED_BY, Entity.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generalization getRelationship()
	{
		if (relationship != null && relationship.eIsProxy())
		{
			InternalEObject oldRelationship = (InternalEObject)relationship;
			relationship = (Generalization)eResolveProxy(oldRelationship);
			if (relationship != oldRelationship)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP, oldRelationship, relationship));
			}
		}
		return relationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generalization basicGetRelationship()
	{
		return relationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationship(Generalization newRelationship, NotificationChain msgs)
	{
		Generalization oldRelationship = relationship;
		relationship = newRelationship;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP, oldRelationship, newRelationship);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationship(Generalization newRelationship)
	{
		if (newRelationship != relationship)
		{
			NotificationChain msgs = null;
			if (relationship != null)
				msgs = ((InternalEObject)relationship).eInverseRemove(this, EERPackage.GENERALIZATION__PARENT, Generalization.class, msgs);
			if (newRelationship != null)
				msgs = ((InternalEObject)newRelationship).eInverseAdd(this, EERPackage.GENERALIZATION__PARENT, Generalization.class, msgs);
			msgs = basicSetRelationship(newRelationship, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP, newRelationship, newRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSource((Entity)otherEnd, msgs);
			case EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP:
				if (relationship != null)
					msgs = ((InternalEObject)relationship).eInverseRemove(this, EERPackage.GENERALIZATION__PARENT, Generalization.class, msgs);
				return basicSetRelationship((Generalization)otherEnd, msgs);
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
			case EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE:
				return basicSetSource(null, msgs);
			case EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP:
				return basicSetRelationship(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE:
				return eInternalContainer().eInverseRemove(this, EERPackage.ENTITY__IS_SPECIALIZED_BY, Entity.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE:
				return getSource();
			case EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP:
				if (resolve) return getRelationship();
				return basicGetRelationship();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE:
				setSource((Entity)newValue);
				return;
			case EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP:
				setRelationship((Generalization)newValue);
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
			case EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE:
				setSource((Entity)null);
				return;
			case EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP:
				setRelationship((Generalization)null);
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
			case EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE:
				return getSource() != null;
			case EERPackage.SPECIALIZATION_RELATIONSHIP__RELATIONSHIP:
				return relationship != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecializationRelationshipImpl

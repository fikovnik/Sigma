/**
 */
package EER.impl;

import EER.EERPackage;
import EER.Entity;
import EER.Generalization;
import EER.GeneralizationRelationship;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.GeneralizationRelationshipImpl#getRelationship <em>Relationship</em>}</li>
 *   <li>{@link EER.impl.GeneralizationRelationshipImpl#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationRelationshipImpl extends MinimalEObjectImpl.Container implements GeneralizationRelationship
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
	protected GeneralizationRelationshipImpl()
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
		return EERPackage.Literals.GENERALIZATION_RELATIONSHIP;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP, oldRelationship, relationship));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP, oldRelationship, newRelationship);
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
				msgs = ((InternalEObject)relationship).eInverseRemove(this, EERPackage.GENERALIZATION__CHILDS, Generalization.class, msgs);
			if (newRelationship != null)
				msgs = ((InternalEObject)newRelationship).eInverseAdd(this, EERPackage.GENERALIZATION__CHILDS, Generalization.class, msgs);
			msgs = basicSetRelationship(newRelationship, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP, newRelationship, newRelationship));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getChild()
	{
		if (eContainerFeatureID() != EERPackage.GENERALIZATION_RELATIONSHIP__CHILD) return null;
		return (Entity)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChild(Entity newChild, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newChild, EERPackage.GENERALIZATION_RELATIONSHIP__CHILD, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChild(Entity newChild)
	{
		if (newChild != eInternalContainer() || (eContainerFeatureID() != EERPackage.GENERALIZATION_RELATIONSHIP__CHILD && newChild != null))
		{
			if (EcoreUtil.isAncestor(this, newChild))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newChild != null)
				msgs = ((InternalEObject)newChild).eInverseAdd(this, EERPackage.ENTITY__SPECIALIZES, Entity.class, msgs);
			msgs = basicSetChild(newChild, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.GENERALIZATION_RELATIONSHIP__CHILD, newChild, newChild));
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
			case EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP:
				if (relationship != null)
					msgs = ((InternalEObject)relationship).eInverseRemove(this, EERPackage.GENERALIZATION__CHILDS, Generalization.class, msgs);
				return basicSetRelationship((Generalization)otherEnd, msgs);
			case EERPackage.GENERALIZATION_RELATIONSHIP__CHILD:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetChild((Entity)otherEnd, msgs);
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
			case EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP:
				return basicSetRelationship(null, msgs);
			case EERPackage.GENERALIZATION_RELATIONSHIP__CHILD:
				return basicSetChild(null, msgs);
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
			case EERPackage.GENERALIZATION_RELATIONSHIP__CHILD:
				return eInternalContainer().eInverseRemove(this, EERPackage.ENTITY__SPECIALIZES, Entity.class, msgs);
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
			case EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP:
				if (resolve) return getRelationship();
				return basicGetRelationship();
			case EERPackage.GENERALIZATION_RELATIONSHIP__CHILD:
				return getChild();
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
			case EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP:
				setRelationship((Generalization)newValue);
				return;
			case EERPackage.GENERALIZATION_RELATIONSHIP__CHILD:
				setChild((Entity)newValue);
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
			case EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP:
				setRelationship((Generalization)null);
				return;
			case EERPackage.GENERALIZATION_RELATIONSHIP__CHILD:
				setChild((Entity)null);
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
			case EERPackage.GENERALIZATION_RELATIONSHIP__RELATIONSHIP:
				return relationship != null;
			case EERPackage.GENERALIZATION_RELATIONSHIP__CHILD:
				return getChild() != null;
		}
		return super.eIsSet(featureID);
	}

} //GeneralizationRelationshipImpl

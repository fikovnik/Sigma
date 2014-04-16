/**
 */
package EER.impl;

import EER.AbstractRelationship;
import EER.EERPackage;
import EER.Entity;
import EER.Exclusive;
import EER.Inclusiveness;
import EER.Participant;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.ParticipantImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link EER.impl.ParticipantImpl#getSource <em>Source</em>}</li>
 *   <li>{@link EER.impl.ParticipantImpl#getExclusiveConstraint <em>Exclusive Constraint</em>}</li>
 *   <li>{@link EER.impl.ParticipantImpl#getInclusivenessConstraint <em>Inclusiveness Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParticipantImpl extends AbstractParticipantImpl implements Participant
{
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Entity target;

	/**
	 * The cached value of the '{@link #getExclusiveConstraint() <em>Exclusive Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExclusiveConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Exclusive> exclusiveConstraint;

	/**
	 * The cached value of the '{@link #getInclusivenessConstraint() <em>Inclusiveness Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInclusivenessConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<Inclusiveness> inclusivenessConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParticipantImpl()
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
		return EERPackage.Literals.PARTICIPANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity getTarget()
	{
		if (target != null && target.eIsProxy())
		{
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Entity)eResolveProxy(oldTarget);
			if (target != oldTarget)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EERPackage.PARTICIPANT__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity basicGetTarget()
	{
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Entity newTarget)
	{
		Entity oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.PARTICIPANT__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractRelationship getSource()
	{
		if (eContainerFeatureID() != EERPackage.PARTICIPANT__SOURCE) return null;
		return (AbstractRelationship)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(AbstractRelationship newSource, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newSource, EERPackage.PARTICIPANT__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(AbstractRelationship newSource)
	{
		if (newSource != eInternalContainer() || (eContainerFeatureID() != EERPackage.PARTICIPANT__SOURCE && newSource != null))
		{
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EERPackage.ABSTRACT_RELATIONSHIP__PARTICIPANTS, AbstractRelationship.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.PARTICIPANT__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Exclusive> getExclusiveConstraint()
	{
		if (exclusiveConstraint == null)
		{
			exclusiveConstraint = new EObjectContainmentWithInverseEList<Exclusive>(Exclusive.class, this, EERPackage.PARTICIPANT__EXCLUSIVE_CONSTRAINT, EERPackage.EXCLUSIVE__SOURCE);
		}
		return exclusiveConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Inclusiveness> getInclusivenessConstraint()
	{
		if (inclusivenessConstraint == null)
		{
			inclusivenessConstraint = new EObjectContainmentWithInverseEList<Inclusiveness>(Inclusiveness.class, this, EERPackage.PARTICIPANT__INCLUSIVENESS_CONSTRAINT, EERPackage.INCLUSIVENESS__SOURCE);
		}
		return inclusivenessConstraint;
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
			case EERPackage.PARTICIPANT__SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSource((AbstractRelationship)otherEnd, msgs);
			case EERPackage.PARTICIPANT__EXCLUSIVE_CONSTRAINT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExclusiveConstraint()).basicAdd(otherEnd, msgs);
			case EERPackage.PARTICIPANT__INCLUSIVENESS_CONSTRAINT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInclusivenessConstraint()).basicAdd(otherEnd, msgs);
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
			case EERPackage.PARTICIPANT__SOURCE:
				return basicSetSource(null, msgs);
			case EERPackage.PARTICIPANT__EXCLUSIVE_CONSTRAINT:
				return ((InternalEList<?>)getExclusiveConstraint()).basicRemove(otherEnd, msgs);
			case EERPackage.PARTICIPANT__INCLUSIVENESS_CONSTRAINT:
				return ((InternalEList<?>)getInclusivenessConstraint()).basicRemove(otherEnd, msgs);
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
			case EERPackage.PARTICIPANT__SOURCE:
				return eInternalContainer().eInverseRemove(this, EERPackage.ABSTRACT_RELATIONSHIP__PARTICIPANTS, AbstractRelationship.class, msgs);
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
			case EERPackage.PARTICIPANT__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case EERPackage.PARTICIPANT__SOURCE:
				return getSource();
			case EERPackage.PARTICIPANT__EXCLUSIVE_CONSTRAINT:
				return getExclusiveConstraint();
			case EERPackage.PARTICIPANT__INCLUSIVENESS_CONSTRAINT:
				return getInclusivenessConstraint();
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
			case EERPackage.PARTICIPANT__TARGET:
				setTarget((Entity)newValue);
				return;
			case EERPackage.PARTICIPANT__SOURCE:
				setSource((AbstractRelationship)newValue);
				return;
			case EERPackage.PARTICIPANT__EXCLUSIVE_CONSTRAINT:
				getExclusiveConstraint().clear();
				getExclusiveConstraint().addAll((Collection<? extends Exclusive>)newValue);
				return;
			case EERPackage.PARTICIPANT__INCLUSIVENESS_CONSTRAINT:
				getInclusivenessConstraint().clear();
				getInclusivenessConstraint().addAll((Collection<? extends Inclusiveness>)newValue);
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
			case EERPackage.PARTICIPANT__TARGET:
				setTarget((Entity)null);
				return;
			case EERPackage.PARTICIPANT__SOURCE:
				setSource((AbstractRelationship)null);
				return;
			case EERPackage.PARTICIPANT__EXCLUSIVE_CONSTRAINT:
				getExclusiveConstraint().clear();
				return;
			case EERPackage.PARTICIPANT__INCLUSIVENESS_CONSTRAINT:
				getInclusivenessConstraint().clear();
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
			case EERPackage.PARTICIPANT__TARGET:
				return target != null;
			case EERPackage.PARTICIPANT__SOURCE:
				return getSource() != null;
			case EERPackage.PARTICIPANT__EXCLUSIVE_CONSTRAINT:
				return exclusiveConstraint != null && !exclusiveConstraint.isEmpty();
			case EERPackage.PARTICIPANT__INCLUSIVENESS_CONSTRAINT:
				return inclusivenessConstraint != null && !inclusivenessConstraint.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ParticipantImpl

/**
 */
package EER.impl;

import EER.Aggregation;
import EER.AggregationParticipant;
import EER.EERPackage;
import EER.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregation Participant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.AggregationParticipantImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link EER.impl.AggregationParticipantImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregationParticipantImpl extends AbstractParticipantImpl implements AggregationParticipant
{
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregationParticipantImpl()
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
		return EERPackage.Literals.AGGREGATION_PARTICIPANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget()
	{
		if (target != null && target.eIsProxy())
		{
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node)eResolveProxy(oldTarget);
			if (target != oldTarget)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EERPackage.AGGREGATION_PARTICIPANT__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget()
	{
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget)
	{
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.AGGREGATION_PARTICIPANT__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aggregation getSource()
	{
		if (eContainerFeatureID() != EERPackage.AGGREGATION_PARTICIPANT__SOURCE) return null;
		return (Aggregation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Aggregation newSource, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newSource, EERPackage.AGGREGATION_PARTICIPANT__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Aggregation newSource)
	{
		if (newSource != eInternalContainer() || (eContainerFeatureID() != EERPackage.AGGREGATION_PARTICIPANT__SOURCE && newSource != null))
		{
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EERPackage.AGGREGATION__PARTICIPANTS, Aggregation.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.AGGREGATION_PARTICIPANT__SOURCE, newSource, newSource));
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
			case EERPackage.AGGREGATION_PARTICIPANT__SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSource((Aggregation)otherEnd, msgs);
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
			case EERPackage.AGGREGATION_PARTICIPANT__SOURCE:
				return basicSetSource(null, msgs);
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
			case EERPackage.AGGREGATION_PARTICIPANT__SOURCE:
				return eInternalContainer().eInverseRemove(this, EERPackage.AGGREGATION__PARTICIPANTS, Aggregation.class, msgs);
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
			case EERPackage.AGGREGATION_PARTICIPANT__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case EERPackage.AGGREGATION_PARTICIPANT__SOURCE:
				return getSource();
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
			case EERPackage.AGGREGATION_PARTICIPANT__TARGET:
				setTarget((Node)newValue);
				return;
			case EERPackage.AGGREGATION_PARTICIPANT__SOURCE:
				setSource((Aggregation)newValue);
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
			case EERPackage.AGGREGATION_PARTICIPANT__TARGET:
				setTarget((Node)null);
				return;
			case EERPackage.AGGREGATION_PARTICIPANT__SOURCE:
				setSource((Aggregation)null);
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
			case EERPackage.AGGREGATION_PARTICIPANT__TARGET:
				return target != null;
			case EERPackage.AGGREGATION_PARTICIPANT__SOURCE:
				return getSource() != null;
		}
		return super.eIsSet(featureID);
	}

} //AggregationParticipantImpl

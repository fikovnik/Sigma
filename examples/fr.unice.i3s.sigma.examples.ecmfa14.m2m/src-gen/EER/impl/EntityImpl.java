/**
 */
package EER.impl;

import EER.CandidateKey;
import EER.DependencyRelationship;
import EER.EERPackage;
import EER.Entity;
import EER.GeneralizationRelationship;
import EER.SpecializationRelationship;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.EntityImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link EER.impl.EntityImpl#getCandidateKey <em>Candidate Key</em>}</li>
 *   <li>{@link EER.impl.EntityImpl#getDependencyRelationships <em>Dependency Relationships</em>}</li>
 *   <li>{@link EER.impl.EntityImpl#getIsSpecializedBy <em>Is Specialized By</em>}</li>
 *   <li>{@link EER.impl.EntityImpl#getSpecializes <em>Specializes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntityImpl extends NodeImpl implements Entity
{
	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected CandidateKey primaryKey;

	/**
	 * The cached value of the '{@link #getCandidateKey() <em>Candidate Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCandidateKey()
	 * @generated
	 * @ordered
	 */
	protected EList<CandidateKey> candidateKey;

	/**
	 * The cached value of the '{@link #getDependencyRelationships() <em>Dependency Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyRelationship> dependencyRelationships;

	/**
	 * The cached value of the '{@link #getIsSpecializedBy() <em>Is Specialized By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSpecializedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecializationRelationship> isSpecializedBy;

	/**
	 * The cached value of the '{@link #getSpecializes() <em>Specializes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializes()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralizationRelationship> specializes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl()
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
		return EERPackage.Literals.ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CandidateKey getPrimaryKey()
	{
		if (primaryKey != null && primaryKey.eIsProxy())
		{
			InternalEObject oldPrimaryKey = (InternalEObject)primaryKey;
			primaryKey = (CandidateKey)eResolveProxy(oldPrimaryKey);
			if (primaryKey != oldPrimaryKey)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EERPackage.ENTITY__PRIMARY_KEY, oldPrimaryKey, primaryKey));
			}
		}
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CandidateKey basicGetPrimaryKey()
	{
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKey(CandidateKey newPrimaryKey)
	{
		CandidateKey oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.ENTITY__PRIMARY_KEY, oldPrimaryKey, primaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CandidateKey> getCandidateKey()
	{
		if (candidateKey == null)
		{
			candidateKey = new EObjectContainmentEList<CandidateKey>(CandidateKey.class, this, EERPackage.ENTITY__CANDIDATE_KEY);
		}
		return candidateKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependencyRelationship> getDependencyRelationships()
	{
		if (dependencyRelationships == null)
		{
			dependencyRelationships = new EObjectContainmentEList<DependencyRelationship>(DependencyRelationship.class, this, EERPackage.ENTITY__DEPENDENCY_RELATIONSHIPS);
		}
		return dependencyRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecializationRelationship> getIsSpecializedBy()
	{
		if (isSpecializedBy == null)
		{
			isSpecializedBy = new EObjectContainmentWithInverseEList<SpecializationRelationship>(SpecializationRelationship.class, this, EERPackage.ENTITY__IS_SPECIALIZED_BY, EERPackage.SPECIALIZATION_RELATIONSHIP__SOURCE);
		}
		return isSpecializedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationRelationship> getSpecializes()
	{
		if (specializes == null)
		{
			specializes = new EObjectContainmentWithInverseEList<GeneralizationRelationship>(GeneralizationRelationship.class, this, EERPackage.ENTITY__SPECIALIZES, EERPackage.GENERALIZATION_RELATIONSHIP__CHILD);
		}
		return specializes;
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
			case EERPackage.ENTITY__IS_SPECIALIZED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedBy()).basicAdd(otherEnd, msgs);
			case EERPackage.ENTITY__SPECIALIZES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializes()).basicAdd(otherEnd, msgs);
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
			case EERPackage.ENTITY__CANDIDATE_KEY:
				return ((InternalEList<?>)getCandidateKey()).basicRemove(otherEnd, msgs);
			case EERPackage.ENTITY__DEPENDENCY_RELATIONSHIPS:
				return ((InternalEList<?>)getDependencyRelationships()).basicRemove(otherEnd, msgs);
			case EERPackage.ENTITY__IS_SPECIALIZED_BY:
				return ((InternalEList<?>)getIsSpecializedBy()).basicRemove(otherEnd, msgs);
			case EERPackage.ENTITY__SPECIALIZES:
				return ((InternalEList<?>)getSpecializes()).basicRemove(otherEnd, msgs);
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
			case EERPackage.ENTITY__PRIMARY_KEY:
				if (resolve) return getPrimaryKey();
				return basicGetPrimaryKey();
			case EERPackage.ENTITY__CANDIDATE_KEY:
				return getCandidateKey();
			case EERPackage.ENTITY__DEPENDENCY_RELATIONSHIPS:
				return getDependencyRelationships();
			case EERPackage.ENTITY__IS_SPECIALIZED_BY:
				return getIsSpecializedBy();
			case EERPackage.ENTITY__SPECIALIZES:
				return getSpecializes();
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
			case EERPackage.ENTITY__PRIMARY_KEY:
				setPrimaryKey((CandidateKey)newValue);
				return;
			case EERPackage.ENTITY__CANDIDATE_KEY:
				getCandidateKey().clear();
				getCandidateKey().addAll((Collection<? extends CandidateKey>)newValue);
				return;
			case EERPackage.ENTITY__DEPENDENCY_RELATIONSHIPS:
				getDependencyRelationships().clear();
				getDependencyRelationships().addAll((Collection<? extends DependencyRelationship>)newValue);
				return;
			case EERPackage.ENTITY__IS_SPECIALIZED_BY:
				getIsSpecializedBy().clear();
				getIsSpecializedBy().addAll((Collection<? extends SpecializationRelationship>)newValue);
				return;
			case EERPackage.ENTITY__SPECIALIZES:
				getSpecializes().clear();
				getSpecializes().addAll((Collection<? extends GeneralizationRelationship>)newValue);
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
			case EERPackage.ENTITY__PRIMARY_KEY:
				setPrimaryKey((CandidateKey)null);
				return;
			case EERPackage.ENTITY__CANDIDATE_KEY:
				getCandidateKey().clear();
				return;
			case EERPackage.ENTITY__DEPENDENCY_RELATIONSHIPS:
				getDependencyRelationships().clear();
				return;
			case EERPackage.ENTITY__IS_SPECIALIZED_BY:
				getIsSpecializedBy().clear();
				return;
			case EERPackage.ENTITY__SPECIALIZES:
				getSpecializes().clear();
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
			case EERPackage.ENTITY__PRIMARY_KEY:
				return primaryKey != null;
			case EERPackage.ENTITY__CANDIDATE_KEY:
				return candidateKey != null && !candidateKey.isEmpty();
			case EERPackage.ENTITY__DEPENDENCY_RELATIONSHIPS:
				return dependencyRelationships != null && !dependencyRelationships.isEmpty();
			case EERPackage.ENTITY__IS_SPECIALIZED_BY:
				return isSpecializedBy != null && !isSpecializedBy.isEmpty();
			case EERPackage.ENTITY__SPECIALIZES:
				return specializes != null && !specializes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EntityImpl

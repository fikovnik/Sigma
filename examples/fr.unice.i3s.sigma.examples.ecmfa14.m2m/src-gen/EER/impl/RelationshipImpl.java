/**
 */
package EER.impl;

import EER.EERPackage;
import EER.Exclusion;
import EER.Inclusion;
import EER.Relationship;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.RelationshipImpl#getExclusionConstraints <em>Exclusion Constraints</em>}</li>
 *   <li>{@link EER.impl.RelationshipImpl#getInclusionConstraints <em>Inclusion Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationshipImpl extends AbstractRelationshipImpl implements Relationship
{
	/**
	 * The cached value of the '{@link #getExclusionConstraints() <em>Exclusion Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExclusionConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Exclusion> exclusionConstraints;

	/**
	 * The cached value of the '{@link #getInclusionConstraints() <em>Inclusion Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInclusionConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Inclusion> inclusionConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipImpl()
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
		return EERPackage.Literals.RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Exclusion> getExclusionConstraints()
	{
		if (exclusionConstraints == null)
		{
			exclusionConstraints = new EObjectContainmentWithInverseEList<Exclusion>(Exclusion.class, this, EERPackage.RELATIONSHIP__EXCLUSION_CONSTRAINTS, EERPackage.EXCLUSION__SOURCE);
		}
		return exclusionConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Inclusion> getInclusionConstraints()
	{
		if (inclusionConstraints == null)
		{
			inclusionConstraints = new EObjectContainmentWithInverseEList<Inclusion>(Inclusion.class, this, EERPackage.RELATIONSHIP__INCLUSION_CONSTRAINTS, EERPackage.INCLUSION__SOURCE);
		}
		return inclusionConstraints;
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
			case EERPackage.RELATIONSHIP__EXCLUSION_CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExclusionConstraints()).basicAdd(otherEnd, msgs);
			case EERPackage.RELATIONSHIP__INCLUSION_CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInclusionConstraints()).basicAdd(otherEnd, msgs);
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
			case EERPackage.RELATIONSHIP__EXCLUSION_CONSTRAINTS:
				return ((InternalEList<?>)getExclusionConstraints()).basicRemove(otherEnd, msgs);
			case EERPackage.RELATIONSHIP__INCLUSION_CONSTRAINTS:
				return ((InternalEList<?>)getInclusionConstraints()).basicRemove(otherEnd, msgs);
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
			case EERPackage.RELATIONSHIP__EXCLUSION_CONSTRAINTS:
				return getExclusionConstraints();
			case EERPackage.RELATIONSHIP__INCLUSION_CONSTRAINTS:
				return getInclusionConstraints();
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
			case EERPackage.RELATIONSHIP__EXCLUSION_CONSTRAINTS:
				getExclusionConstraints().clear();
				getExclusionConstraints().addAll((Collection<? extends Exclusion>)newValue);
				return;
			case EERPackage.RELATIONSHIP__INCLUSION_CONSTRAINTS:
				getInclusionConstraints().clear();
				getInclusionConstraints().addAll((Collection<? extends Inclusion>)newValue);
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
			case EERPackage.RELATIONSHIP__EXCLUSION_CONSTRAINTS:
				getExclusionConstraints().clear();
				return;
			case EERPackage.RELATIONSHIP__INCLUSION_CONSTRAINTS:
				getInclusionConstraints().clear();
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
			case EERPackage.RELATIONSHIP__EXCLUSION_CONSTRAINTS:
				return exclusionConstraints != null && !exclusionConstraints.isEmpty();
			case EERPackage.RELATIONSHIP__INCLUSION_CONSTRAINTS:
				return inclusionConstraints != null && !inclusionConstraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelationshipImpl

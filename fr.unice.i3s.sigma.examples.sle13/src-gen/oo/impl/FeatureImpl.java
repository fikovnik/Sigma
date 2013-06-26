/**
 */
package oo.impl;

import oo.Feature;
import oo.OOPackage;
import oo.ScopeKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link oo.impl.FeatureImpl#getOwnerScope <em>Owner Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureImpl extends ModelElementImpl implements Feature
{
	/**
	 * The default value of the '{@link #getOwnerScope() <em>Owner Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerScope()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeKind OWNER_SCOPE_EDEFAULT = ScopeKind.SK_INSTANCE;

	/**
	 * The cached value of the '{@link #getOwnerScope() <em>Owner Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerScope()
	 * @generated
	 * @ordered
	 */
	protected ScopeKind ownerScope = OWNER_SCOPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl()
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
		return OOPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeKind getOwnerScope()
	{
		return ownerScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerScope(ScopeKind newOwnerScope)
	{
		ScopeKind oldOwnerScope = ownerScope;
		ownerScope = newOwnerScope == null ? OWNER_SCOPE_EDEFAULT : newOwnerScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OOPackage.FEATURE__OWNER_SCOPE, oldOwnerScope, ownerScope));
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
			case OOPackage.FEATURE__OWNER_SCOPE:
				return getOwnerScope();
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
			case OOPackage.FEATURE__OWNER_SCOPE:
				setOwnerScope((ScopeKind)newValue);
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
			case OOPackage.FEATURE__OWNER_SCOPE:
				setOwnerScope(OWNER_SCOPE_EDEFAULT);
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
			case OOPackage.FEATURE__OWNER_SCOPE:
				return ownerScope != OWNER_SCOPE_EDEFAULT;
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
		result.append(" (ownerScope: ");
		result.append(ownerScope);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl

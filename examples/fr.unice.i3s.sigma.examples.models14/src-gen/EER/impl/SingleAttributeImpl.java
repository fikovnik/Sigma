/**
 */
package EER.impl;

import EER.Domain;
import EER.EERPackage;
import EER.SingleAttribute;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.SingleAttributeImpl#isDerivate <em>Derivate</em>}</li>
 *   <li>{@link EER.impl.SingleAttributeImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link EER.impl.SingleAttributeImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleAttributeImpl extends AttributeImpl implements SingleAttribute
{
	/**
	 * The default value of the '{@link #isDerivate() <em>Derivate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerivate() <em>Derivate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivate()
	 * @generated
	 * @ordered
	 */
	protected boolean derivate = DERIVATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain domain;

	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int MULTIPLICITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int multiplicity = MULTIPLICITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleAttributeImpl()
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
		return EERPackage.Literals.SINGLE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerivate()
	{
		return derivate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivate(boolean newDerivate)
	{
		boolean oldDerivate = derivate;
		derivate = newDerivate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.SINGLE_ATTRIBUTE__DERIVATE, oldDerivate, derivate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain()
	{
		if (domain != null && domain.eIsProxy())
		{
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (Domain)eResolveProxy(oldDomain);
			if (domain != oldDomain)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EERPackage.SINGLE_ATTRIBUTE__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetDomain()
	{
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Domain newDomain)
	{
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.SINGLE_ATTRIBUTE__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMultiplicity()
	{
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(int newMultiplicity)
	{
		int oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EERPackage.SINGLE_ATTRIBUTE__MULTIPLICITY, oldMultiplicity, multiplicity));
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
			case EERPackage.SINGLE_ATTRIBUTE__DERIVATE:
				return isDerivate();
			case EERPackage.SINGLE_ATTRIBUTE__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case EERPackage.SINGLE_ATTRIBUTE__MULTIPLICITY:
				return getMultiplicity();
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
			case EERPackage.SINGLE_ATTRIBUTE__DERIVATE:
				setDerivate((Boolean)newValue);
				return;
			case EERPackage.SINGLE_ATTRIBUTE__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case EERPackage.SINGLE_ATTRIBUTE__MULTIPLICITY:
				setMultiplicity((Integer)newValue);
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
			case EERPackage.SINGLE_ATTRIBUTE__DERIVATE:
				setDerivate(DERIVATE_EDEFAULT);
				return;
			case EERPackage.SINGLE_ATTRIBUTE__DOMAIN:
				setDomain((Domain)null);
				return;
			case EERPackage.SINGLE_ATTRIBUTE__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
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
			case EERPackage.SINGLE_ATTRIBUTE__DERIVATE:
				return derivate != DERIVATE_EDEFAULT;
			case EERPackage.SINGLE_ATTRIBUTE__DOMAIN:
				return domain != null;
			case EERPackage.SINGLE_ATTRIBUTE__MULTIPLICITY:
				return multiplicity != MULTIPLICITY_EDEFAULT;
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
		result.append(" (derivate: ");
		result.append(derivate);
		result.append(", multiplicity: ");
		result.append(multiplicity);
		result.append(')');
		return result.toString();
	}

} //SingleAttributeImpl

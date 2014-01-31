/**
 */
package EER.impl;

import EER.Attribute;
import EER.CompositeAttribute;
import EER.EERPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EER.impl.CompositeAttributeImpl#getSinglesAttributes <em>Singles Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeAttributeImpl extends AttributeImpl implements CompositeAttribute
{
	/**
	 * The cached value of the '{@link #getSinglesAttributes() <em>Singles Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinglesAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> singlesAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeAttributeImpl()
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
		return EERPackage.Literals.COMPOSITE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getSinglesAttributes()
	{
		if (singlesAttributes == null)
		{
			singlesAttributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, EERPackage.COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES);
		}
		return singlesAttributes;
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
			case EERPackage.COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES:
				return ((InternalEList<?>)getSinglesAttributes()).basicRemove(otherEnd, msgs);
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
			case EERPackage.COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES:
				return getSinglesAttributes();
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
			case EERPackage.COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES:
				getSinglesAttributes().clear();
				getSinglesAttributes().addAll((Collection<? extends Attribute>)newValue);
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
			case EERPackage.COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES:
				getSinglesAttributes().clear();
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
			case EERPackage.COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES:
				return singlesAttributes != null && !singlesAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeAttributeImpl

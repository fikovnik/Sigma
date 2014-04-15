/**
 */
package fr.unice.i3s.sigma.examples.simpleoo.impl;

import fr.unice.i3s.sigma.examples.simpleoo.Classifier;
import fr.unice.i3s.sigma.examples.simpleoo.SimpleooPackage;
import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.PackageImpl#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.PackageImpl#getOwnedStereotypes <em>Owned Stereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends ModelElementImpl implements fr.unice.i3s.sigma.examples.simpleoo.Package
{
	/**
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> ownedElements;

	/**
	 * The cached value of the '{@link #getOwnedStereotypes() <em>Owned Stereotypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Stereotype> ownedStereotypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImpl()
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
		return SimpleooPackage.Literals.PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getOwnedElements()
	{
		if (ownedElements == null)
		{
			ownedElements = new EObjectContainmentWithInverseEList<Classifier>(Classifier.class, this, SimpleooPackage.PACKAGE__OWNED_ELEMENTS, SimpleooPackage.CLASSIFIER__PKG);
		}
		return ownedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stereotype> getOwnedStereotypes()
	{
		if (ownedStereotypes == null)
		{
			ownedStereotypes = new EObjectContainmentEList<Stereotype>(Stereotype.class, this, SimpleooPackage.PACKAGE__OWNED_STEREOTYPES);
		}
		return ownedStereotypes;
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
			case SimpleooPackage.PACKAGE__OWNED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElements()).basicAdd(otherEnd, msgs);
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
			case SimpleooPackage.PACKAGE__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
			case SimpleooPackage.PACKAGE__OWNED_STEREOTYPES:
				return ((InternalEList<?>)getOwnedStereotypes()).basicRemove(otherEnd, msgs);
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
			case SimpleooPackage.PACKAGE__OWNED_ELEMENTS:
				return getOwnedElements();
			case SimpleooPackage.PACKAGE__OWNED_STEREOTYPES:
				return getOwnedStereotypes();
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
			case SimpleooPackage.PACKAGE__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends Classifier>)newValue);
				return;
			case SimpleooPackage.PACKAGE__OWNED_STEREOTYPES:
				getOwnedStereotypes().clear();
				getOwnedStereotypes().addAll((Collection<? extends Stereotype>)newValue);
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
			case SimpleooPackage.PACKAGE__OWNED_ELEMENTS:
				getOwnedElements().clear();
				return;
			case SimpleooPackage.PACKAGE__OWNED_STEREOTYPES:
				getOwnedStereotypes().clear();
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
			case SimpleooPackage.PACKAGE__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
			case SimpleooPackage.PACKAGE__OWNED_STEREOTYPES:
				return ownedStereotypes != null && !ownedStereotypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PackageImpl

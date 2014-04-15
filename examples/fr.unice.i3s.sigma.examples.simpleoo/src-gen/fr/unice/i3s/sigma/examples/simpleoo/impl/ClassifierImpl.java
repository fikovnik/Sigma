/**
 */
package fr.unice.i3s.sigma.examples.simpleoo.impl;

import fr.unice.i3s.sigma.examples.simpleoo.Classifier;
import fr.unice.i3s.sigma.examples.simpleoo.SimpleooPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.ClassifierImpl#getPkg <em>Pkg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassifierImpl extends ModelElementImpl implements Classifier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierImpl()
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
		return SimpleooPackage.Literals.CLASSIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.unice.i3s.sigma.examples.simpleoo.Package getPkg()
	{
		if (eContainerFeatureID() != SimpleooPackage.CLASSIFIER__PKG) return null;
		return (fr.unice.i3s.sigma.examples.simpleoo.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPkg(fr.unice.i3s.sigma.examples.simpleoo.Package newPkg, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newPkg, SimpleooPackage.CLASSIFIER__PKG, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPkg(fr.unice.i3s.sigma.examples.simpleoo.Package newPkg)
	{
		if (newPkg != eInternalContainer() || (eContainerFeatureID() != SimpleooPackage.CLASSIFIER__PKG && newPkg != null))
		{
			if (EcoreUtil.isAncestor(this, newPkg))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPkg != null)
				msgs = ((InternalEObject)newPkg).eInverseAdd(this, SimpleooPackage.PACKAGE__OWNED_ELEMENTS, fr.unice.i3s.sigma.examples.simpleoo.Package.class, msgs);
			msgs = basicSetPkg(newPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleooPackage.CLASSIFIER__PKG, newPkg, newPkg));
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
			case SimpleooPackage.CLASSIFIER__PKG:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPkg((fr.unice.i3s.sigma.examples.simpleoo.Package)otherEnd, msgs);
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
			case SimpleooPackage.CLASSIFIER__PKG:
				return basicSetPkg(null, msgs);
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
			case SimpleooPackage.CLASSIFIER__PKG:
				return eInternalContainer().eInverseRemove(this, SimpleooPackage.PACKAGE__OWNED_ELEMENTS, fr.unice.i3s.sigma.examples.simpleoo.Package.class, msgs);
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
			case SimpleooPackage.CLASSIFIER__PKG:
				return getPkg();
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
			case SimpleooPackage.CLASSIFIER__PKG:
				setPkg((fr.unice.i3s.sigma.examples.simpleoo.Package)newValue);
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
			case SimpleooPackage.CLASSIFIER__PKG:
				setPkg((fr.unice.i3s.sigma.examples.simpleoo.Package)null);
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
			case SimpleooPackage.CLASSIFIER__PKG:
				return getPkg() != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassifierImpl

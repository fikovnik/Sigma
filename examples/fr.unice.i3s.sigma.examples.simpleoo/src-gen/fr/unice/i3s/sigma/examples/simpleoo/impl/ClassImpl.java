/**
 */
package fr.unice.i3s.sigma.examples.simpleoo.impl;

import fr.unice.i3s.sigma.examples.simpleoo.Feature;
import fr.unice.i3s.sigma.examples.simpleoo.Operation;
import fr.unice.i3s.sigma.examples.simpleoo.Property;
import fr.unice.i3s.sigma.examples.simpleoo.SimpleooPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.ClassImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.ClassImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.ClassImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.ClassImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.impl.ClassImpl#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends ClassifierImpl implements fr.unice.i3s.sigma.examples.simpleoo.Class
{
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected fr.unice.i3s.sigma.examples.simpleoo.Class superClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl()
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
		return SimpleooPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract()
	{
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract)
	{
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleooPackage.CLASS__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties()
	{
		// TODO: implement this method to return the 'Properties' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOperations()
	{
		// TODO: implement this method to return the 'Operations' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures()
	{
		if (features == null)
		{
			features = new EObjectContainmentEList<Feature>(Feature.class, this, SimpleooPackage.CLASS__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.unice.i3s.sigma.examples.simpleoo.Class getSuperClass()
	{
		if (superClass != null && superClass.eIsProxy())
		{
			InternalEObject oldSuperClass = (InternalEObject)superClass;
			superClass = (fr.unice.i3s.sigma.examples.simpleoo.Class)eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimpleooPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
			}
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.unice.i3s.sigma.examples.simpleoo.Class basicGetSuperClass()
	{
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClass(fr.unice.i3s.sigma.examples.simpleoo.Class newSuperClass)
	{
		fr.unice.i3s.sigma.examples.simpleoo.Class oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleooPackage.CLASS__SUPER_CLASS, oldSuperClass, superClass));
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
			case SimpleooPackage.CLASS__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
			case SimpleooPackage.CLASS__ABSTRACT:
				return isAbstract();
			case SimpleooPackage.CLASS__PROPERTIES:
				return getProperties();
			case SimpleooPackage.CLASS__OPERATIONS:
				return getOperations();
			case SimpleooPackage.CLASS__FEATURES:
				return getFeatures();
			case SimpleooPackage.CLASS__SUPER_CLASS:
				if (resolve) return getSuperClass();
				return basicGetSuperClass();
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
			case SimpleooPackage.CLASS__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case SimpleooPackage.CLASS__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case SimpleooPackage.CLASS__SUPER_CLASS:
				setSuperClass((fr.unice.i3s.sigma.examples.simpleoo.Class)newValue);
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
			case SimpleooPackage.CLASS__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case SimpleooPackage.CLASS__FEATURES:
				getFeatures().clear();
				return;
			case SimpleooPackage.CLASS__SUPER_CLASS:
				setSuperClass((fr.unice.i3s.sigma.examples.simpleoo.Class)null);
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
			case SimpleooPackage.CLASS__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case SimpleooPackage.CLASS__PROPERTIES:
				return !getProperties().isEmpty();
			case SimpleooPackage.CLASS__OPERATIONS:
				return !getOperations().isEmpty();
			case SimpleooPackage.CLASS__FEATURES:
				return features != null && !features.isEmpty();
			case SimpleooPackage.CLASS__SUPER_CLASS:
				return superClass != null;
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //ClassImpl

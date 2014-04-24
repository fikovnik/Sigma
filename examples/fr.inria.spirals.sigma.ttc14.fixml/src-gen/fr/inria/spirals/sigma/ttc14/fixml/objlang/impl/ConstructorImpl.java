/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang.impl;

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorImpl#getInitialisations <em>Initialisations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstructorImpl extends MemberImpl implements Constructor
{
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getInitialisations() <em>Initialisations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialisations()
	 * @generated
	 * @ordered
	 */
	protected EList<FieldInitialisiation> initialisations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstructorImpl()
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
		return ObjLangPackage.Literals.CONSTRUCTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters()
	{
		if (parameters == null)
		{
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, ObjLangPackage.CONSTRUCTOR__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FieldInitialisiation> getInitialisations()
	{
		if (initialisations == null)
		{
			initialisations = new EObjectContainmentEList<FieldInitialisiation>(FieldInitialisiation.class, this, ObjLangPackage.CONSTRUCTOR__INITIALISATIONS);
		}
		return initialisations;
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
			case ObjLangPackage.CONSTRUCTOR__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case ObjLangPackage.CONSTRUCTOR__INITIALISATIONS:
				return ((InternalEList<?>)getInitialisations()).basicRemove(otherEnd, msgs);
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
			case ObjLangPackage.CONSTRUCTOR__PARAMETERS:
				return getParameters();
			case ObjLangPackage.CONSTRUCTOR__INITIALISATIONS:
				return getInitialisations();
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
			case ObjLangPackage.CONSTRUCTOR__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case ObjLangPackage.CONSTRUCTOR__INITIALISATIONS:
				getInitialisations().clear();
				getInitialisations().addAll((Collection<? extends FieldInitialisiation>)newValue);
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
			case ObjLangPackage.CONSTRUCTOR__PARAMETERS:
				getParameters().clear();
				return;
			case ObjLangPackage.CONSTRUCTOR__INITIALISATIONS:
				getInitialisations().clear();
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
			case ObjLangPackage.CONSTRUCTOR__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case ObjLangPackage.CONSTRUCTOR__INITIALISATIONS:
				return initialisations != null && !initialisations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConstructorImpl

/**
 */
package Relational.impl;

import Relational.Attribute;
import Relational.CandidateKey;
import Relational.ForeignKey;
import Relational.RelationalPackage;
import Relational.Table;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Relational.impl.TableImpl#getName <em>Name</em>}</li>
 *   <li>{@link Relational.impl.TableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link Relational.impl.TableImpl#getCandidateKey <em>Candidate Key</em>}</li>
 *   <li>{@link Relational.impl.TableImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link Relational.impl.TableImpl#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends MinimalEObjectImpl.Container implements Table
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getForeignKey() <em>Foreign Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForeignKey()
	 * @generated
	 * @ordered
	 */
	protected EList<ForeignKey> foreignKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl()
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
		return RelationalPackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalPackage.TABLE__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationalPackage.TABLE__PRIMARY_KEY, oldPrimaryKey, primaryKey));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalPackage.TABLE__PRIMARY_KEY, oldPrimaryKey, primaryKey));
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
			candidateKey = new EObjectContainmentEList<CandidateKey>(CandidateKey.class, this, RelationalPackage.TABLE__CANDIDATE_KEY);
		}
		return candidateKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes()
	{
		if (attributes == null)
		{
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, RelationalPackage.TABLE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForeignKey> getForeignKey()
	{
		if (foreignKey == null)
		{
			foreignKey = new EObjectContainmentEList<ForeignKey>(ForeignKey.class, this, RelationalPackage.TABLE__FOREIGN_KEY);
		}
		return foreignKey;
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
			case RelationalPackage.TABLE__CANDIDATE_KEY:
				return ((InternalEList<?>)getCandidateKey()).basicRemove(otherEnd, msgs);
			case RelationalPackage.TABLE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case RelationalPackage.TABLE__FOREIGN_KEY:
				return ((InternalEList<?>)getForeignKey()).basicRemove(otherEnd, msgs);
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
			case RelationalPackage.TABLE__NAME:
				return getName();
			case RelationalPackage.TABLE__PRIMARY_KEY:
				if (resolve) return getPrimaryKey();
				return basicGetPrimaryKey();
			case RelationalPackage.TABLE__CANDIDATE_KEY:
				return getCandidateKey();
			case RelationalPackage.TABLE__ATTRIBUTES:
				return getAttributes();
			case RelationalPackage.TABLE__FOREIGN_KEY:
				return getForeignKey();
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
			case RelationalPackage.TABLE__NAME:
				setName((String)newValue);
				return;
			case RelationalPackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((CandidateKey)newValue);
				return;
			case RelationalPackage.TABLE__CANDIDATE_KEY:
				getCandidateKey().clear();
				getCandidateKey().addAll((Collection<? extends CandidateKey>)newValue);
				return;
			case RelationalPackage.TABLE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case RelationalPackage.TABLE__FOREIGN_KEY:
				getForeignKey().clear();
				getForeignKey().addAll((Collection<? extends ForeignKey>)newValue);
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
			case RelationalPackage.TABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RelationalPackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((CandidateKey)null);
				return;
			case RelationalPackage.TABLE__CANDIDATE_KEY:
				getCandidateKey().clear();
				return;
			case RelationalPackage.TABLE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case RelationalPackage.TABLE__FOREIGN_KEY:
				getForeignKey().clear();
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
			case RelationalPackage.TABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RelationalPackage.TABLE__PRIMARY_KEY:
				return primaryKey != null;
			case RelationalPackage.TABLE__CANDIDATE_KEY:
				return candidateKey != null && !candidateKey.isEmpty();
			case RelationalPackage.TABLE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case RelationalPackage.TABLE__FOREIGN_KEY:
				return foreignKey != null && !foreignKey.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TableImpl

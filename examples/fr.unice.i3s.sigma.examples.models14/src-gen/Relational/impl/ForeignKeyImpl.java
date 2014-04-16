/**
 */
package Relational.impl;

import Relational.ForeignKey;
import Relational.RelationalPackage;
import Relational.Table;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Relational.impl.ForeignKeyImpl#getReferencedTable <em>Referenced Table</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeignKeyImpl extends CandidateKeyImpl implements ForeignKey
{
	/**
	 * The cached value of the '{@link #getReferencedTable() <em>Referenced Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedTable()
	 * @generated
	 * @ordered
	 */
	protected Table referencedTable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForeignKeyImpl()
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
		return RelationalPackage.Literals.FOREIGN_KEY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getReferencedTable()
	{
		if (referencedTable != null && referencedTable.eIsProxy())
		{
			InternalEObject oldReferencedTable = (InternalEObject)referencedTable;
			referencedTable = (Table)eResolveProxy(oldReferencedTable);
			if (referencedTable != oldReferencedTable)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationalPackage.FOREIGN_KEY__REFERENCED_TABLE, oldReferencedTable, referencedTable));
			}
		}
		return referencedTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetReferencedTable()
	{
		return referencedTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedTable(Table newReferencedTable)
	{
		Table oldReferencedTable = referencedTable;
		referencedTable = newReferencedTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalPackage.FOREIGN_KEY__REFERENCED_TABLE, oldReferencedTable, referencedTable));
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
			case RelationalPackage.FOREIGN_KEY__REFERENCED_TABLE:
				if (resolve) return getReferencedTable();
				return basicGetReferencedTable();
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
			case RelationalPackage.FOREIGN_KEY__REFERENCED_TABLE:
				setReferencedTable((Table)newValue);
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
			case RelationalPackage.FOREIGN_KEY__REFERENCED_TABLE:
				setReferencedTable((Table)null);
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
			case RelationalPackage.FOREIGN_KEY__REFERENCED_TABLE:
				return referencedTable != null;
		}
		return super.eIsSet(featureID);
	}

} //ForeignKeyImpl

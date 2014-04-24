/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl;

import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute;
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMPackage;
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode;

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
 * An implementation of the model object '<em><b>XML Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLNodeImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLNodeImpl#getSubnodes <em>Subnodes</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLNodeImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XMLNodeImpl extends MinimalEObjectImpl.Container implements XMLNode
{
	/**
	 * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected static final String TAG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected String tag = TAG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubnodes() <em>Subnodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubnodes()
	 * @generated
	 * @ordered
	 */
	protected EList<XMLNode> subnodes;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<XMLAttribute> attributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLNodeImpl()
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
		return XMLMMPackage.Literals.XML_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTag()
	{
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(String newTag)
	{
		String oldTag = tag;
		tag = newTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XMLMMPackage.XML_NODE__TAG, oldTag, tag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMLNode> getSubnodes()
	{
		if (subnodes == null)
		{
			subnodes = new EObjectContainmentEList<XMLNode>(XMLNode.class, this, XMLMMPackage.XML_NODE__SUBNODES);
		}
		return subnodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMLAttribute> getAttributes()
	{
		if (attributes == null)
		{
			attributes = new EObjectContainmentEList<XMLAttribute>(XMLAttribute.class, this, XMLMMPackage.XML_NODE__ATTRIBUTES);
		}
		return attributes;
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
			case XMLMMPackage.XML_NODE__SUBNODES:
				return ((InternalEList<?>)getSubnodes()).basicRemove(otherEnd, msgs);
			case XMLMMPackage.XML_NODE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case XMLMMPackage.XML_NODE__TAG:
				return getTag();
			case XMLMMPackage.XML_NODE__SUBNODES:
				return getSubnodes();
			case XMLMMPackage.XML_NODE__ATTRIBUTES:
				return getAttributes();
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
			case XMLMMPackage.XML_NODE__TAG:
				setTag((String)newValue);
				return;
			case XMLMMPackage.XML_NODE__SUBNODES:
				getSubnodes().clear();
				getSubnodes().addAll((Collection<? extends XMLNode>)newValue);
				return;
			case XMLMMPackage.XML_NODE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends XMLAttribute>)newValue);
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
			case XMLMMPackage.XML_NODE__TAG:
				setTag(TAG_EDEFAULT);
				return;
			case XMLMMPackage.XML_NODE__SUBNODES:
				getSubnodes().clear();
				return;
			case XMLMMPackage.XML_NODE__ATTRIBUTES:
				getAttributes().clear();
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
			case XMLMMPackage.XML_NODE__TAG:
				return TAG_EDEFAULT == null ? tag != null : !TAG_EDEFAULT.equals(tag);
			case XMLMMPackage.XML_NODE__SUBNODES:
				return subnodes != null && !subnodes.isEmpty();
			case XMLMMPackage.XML_NODE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
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
		result.append(" (tag: ");
		result.append(tag);
		result.append(')');
		return result.toString();
	}

} //XMLNodeImpl

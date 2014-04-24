/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl;

import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XMLMMFactoryImpl extends EFactoryImpl implements XMLMMFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XMLMMFactory init()
	{
		try
		{
			XMLMMFactory theXMLMMFactory = (XMLMMFactory)EPackage.Registry.INSTANCE.getEFactory(XMLMMPackage.eNS_URI);
			if (theXMLMMFactory != null)
			{
				return theXMLMMFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XMLMMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLMMFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case XMLMMPackage.XML_NODE: return createXMLNode();
			case XMLMMPackage.XML_ATTRIBUTE: return createXMLAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLNode createXMLNode()
	{
		XMLNodeImpl xmlNode = new XMLNodeImpl();
		return xmlNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLAttribute createXMLAttribute()
	{
		XMLAttributeImplDelegate xmlAttribute = new XMLAttributeImplDelegate();
		return xmlAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLMMPackage getXMLMMPackage()
	{
		return (XMLMMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XMLMMPackage getPackage()
	{
		return XMLMMPackage.eINSTANCE;
	}

} //XMLMMFactoryImpl

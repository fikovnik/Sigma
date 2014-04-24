/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.xmlmm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMFactory
 * @model kind="package"
 * @generated
 */
public interface XMLMMPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmlmm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://spirals.inria.fr/sigma/ttc14/fixml/xmlmm/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mmxml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XMLMMPackage eINSTANCE = fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLMMPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLNodeImpl <em>XML Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLNodeImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLMMPackageImpl#getXMLNode()
	 * @generated
	 */
	int XML_NODE = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_NODE__TAG = 0;

	/**
	 * The feature id for the '<em><b>Subnodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_NODE__SUBNODES = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_NODE__ATTRIBUTES = 2;

	/**
	 * The number of structural features of the '<em>XML Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_NODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>XML Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLAttributeImpl <em>XML Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLAttributeImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLMMPackageImpl#getXMLAttribute()
	 * @generated
	 */
	int XML_ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_ATTRIBUTE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>XML Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_ATTRIBUTE___TO_STRING = 0;

	/**
	 * The number of operations of the '<em>XML Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XML_ATTRIBUTE_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode <em>XML Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XML Node</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode
	 * @generated
	 */
	EClass getXMLNode();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getTag()
	 * @see #getXMLNode()
	 * @generated
	 */
	EAttribute getXMLNode_Tag();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getSubnodes <em>Subnodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subnodes</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getSubnodes()
	 * @see #getXMLNode()
	 * @generated
	 */
	EReference getXMLNode_Subnodes();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getAttributes()
	 * @see #getXMLNode()
	 * @generated
	 */
	EReference getXMLNode_Attributes();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute <em>XML Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XML Attribute</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute
	 * @generated
	 */
	EClass getXMLAttribute();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute#getName()
	 * @see #getXMLAttribute()
	 * @generated
	 */
	EAttribute getXMLAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute#getValue()
	 * @see #getXMLAttribute()
	 * @generated
	 */
	EAttribute getXMLAttribute_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute#toString()
	 * @generated
	 */
	EOperation getXMLAttribute__ToString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XMLMMFactory getXMLMMFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLNodeImpl <em>XML Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLNodeImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLMMPackageImpl#getXMLNode()
		 * @generated
		 */
		EClass XML_NODE = eINSTANCE.getXMLNode();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XML_NODE__TAG = eINSTANCE.getXMLNode_Tag();

		/**
		 * The meta object literal for the '<em><b>Subnodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_NODE__SUBNODES = eINSTANCE.getXMLNode_Subnodes();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XML_NODE__ATTRIBUTES = eINSTANCE.getXMLNode_Attributes();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLAttributeImpl <em>XML Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLAttributeImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLMMPackageImpl#getXMLAttribute()
		 * @generated
		 */
		EClass XML_ATTRIBUTE = eINSTANCE.getXMLAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XML_ATTRIBUTE__NAME = eINSTANCE.getXMLAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XML_ATTRIBUTE__VALUE = eINSTANCE.getXMLAttribute_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation XML_ATTRIBUTE___TO_STRING = eINSTANCE.getXMLAttribute__ToString();

	}

} //XMLMMPackage

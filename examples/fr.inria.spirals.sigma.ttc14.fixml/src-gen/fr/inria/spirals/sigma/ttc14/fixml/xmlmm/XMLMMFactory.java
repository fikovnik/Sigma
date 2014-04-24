/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.xmlmm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMPackage
 * @generated
 */
public interface XMLMMFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XMLMMFactory eINSTANCE = fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl.XMLMMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XML Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XML Node</em>'.
	 * @generated
	 */
	XMLNode createXMLNode();

	/**
	 * Returns a new object of class '<em>XML Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XML Attribute</em>'.
	 * @generated
	 */
	XMLAttribute createXMLAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XMLMMPackage getXMLMMPackage();

} //XMLMMFactory

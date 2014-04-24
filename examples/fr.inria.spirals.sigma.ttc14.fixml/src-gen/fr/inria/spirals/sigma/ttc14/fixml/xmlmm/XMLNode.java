/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.xmlmm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XML Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getTag <em>Tag</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getSubnodes <em>Subnodes</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMPackage#getXMLNode()
 * @model
 * @generated
 */
public interface XMLNode extends EObject
{
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see #setTag(String)
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMPackage#getXMLNode_Tag()
	 * @model required="true"
	 * @generated
	 */
	String getTag();

	/**
	 * Sets the value of the '{@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see #getTag()
	 * @generated
	 */
	void setTag(String value);

	/**
	 * Returns the value of the '<em><b>Subnodes</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subnodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subnodes</em>' containment reference list.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMPackage#getXMLNode_Subnodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<XMLNode> getSubnodes();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMPackage#getXMLNode_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<XMLAttribute> getAttributes();

} // XMLNode

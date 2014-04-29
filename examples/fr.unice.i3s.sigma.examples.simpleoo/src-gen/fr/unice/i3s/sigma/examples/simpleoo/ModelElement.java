/**
 */
package fr.unice.i3s.sigma.examples.simpleoo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.ModelElement#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.ModelElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.unice.i3s.sigma.examples.simpleoo.SimpleOOPackage#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends EObject
{
	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' reference list.
	 * The list contents are of type {@link fr.unice.i3s.sigma.examples.simpleoo.Stereotype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' reference list.
	 * @see fr.unice.i3s.sigma.examples.simpleoo.SimpleOOPackage#getModelElement_Stereotypes()
	 * @model
	 * @generated
	 */
	EList<Stereotype> getStereotypes();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.unice.i3s.sigma.examples.simpleoo.SimpleOOPackage#getModelElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.simpleoo.ModelElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ModelElement

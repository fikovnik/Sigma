/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link testmodel.TestClass#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link testmodel.TestClass#getDerivedAttribute <em>Derived Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see testmodel.TmPackage#getTestClass()
 * @model annotation="http://www.i3s.unice.fr/Sigma delegate='testmodel.delegates.TestClassDelegate' A='' B='' C='' D='' E='' F=''"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='A B C D E F'"
 * @generated
 */
public interface TestClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see testmodel.TmPackage#getTestClass_Attribute()
	 * @model ordered="false"
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link testmodel.TestClass#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Derived Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Attribute</em>' attribute.
	 * @see testmodel.TmPackage#getTestClass_DerivedAttribute()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getDerivedAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String method();

} // TestClass

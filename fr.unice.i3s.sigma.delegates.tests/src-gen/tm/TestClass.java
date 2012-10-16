/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tm.TestClass#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link tm.TestClass#getDerivedAttribute <em>Derived Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see tm.TmPackage#getTestClass()
 * @model annotation="http://www.i3s.unice.fr/Sigma delegate='tm.delegates.TestClassDelegate' NonZero='' SmallerThan100='' Divides64='' WithMessage='' WithQuickFix=''"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NonZero SmallerThan100 Divides64 WithMessage WithQuickFix'"
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
	 * @see #setAttribute(int)
	 * @see tm.TmPackage#getTestClass_Attribute()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getAttribute();

	/**
	 * Sets the value of the '{@link tm.TestClass#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(int value);

	/**
	 * Returns the value of the '<em><b>Derived Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Attribute</em>' attribute.
	 * @see tm.TmPackage#getTestClass_DerivedAttribute()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getDerivedAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getSquare();

} // TestClass

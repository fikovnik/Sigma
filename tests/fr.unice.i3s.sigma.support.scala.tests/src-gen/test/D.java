/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.D#getAttr1 <em>Attr1</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.TestPackage#getD()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AlwaysTrueInvariant AlwaysFalseInvariant'"
 *        annotation="http://www.i3s.unice.fr/Sigma/Scala delegate='test.delegates.DDelegate' AlwaysTrueInvariant='' AlwaysFalseInvariant=''"
 * @generated
 */
public interface D extends EObject {
	/**
	 * Returns the value of the '<em><b>Attr1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attr1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr1</em>' attribute.
	 * @see test.TestPackage#getD_Attr1()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getAttr1();

} // D

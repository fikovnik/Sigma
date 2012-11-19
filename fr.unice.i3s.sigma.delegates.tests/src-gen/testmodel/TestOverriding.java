/**
 */
package testmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Overriding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link testmodel.TestOverriding#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link testmodel.TestOverriding#getNormalAttribute <em>Normal Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see testmodel.TmPackage#getTestOverriding()
 * @model annotation="http://www.i3s.unice.fr/Sigma delegate='testmodel.delegates.OverrideClassDelegate' constraint='testmodel.delegates.OverrideConstraintDelegate.checkA' normalConstraint=''"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='constraint normalConstraint'"
 * @generated
 */
public interface TestOverriding extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see testmodel.TmPackage#getTestOverriding_Attribute()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.i3s.unice.fr/Sigma delegate='testmodel.delegates.OverridePropertyDelegate.attribute'"
	 * @generated
	 */
	String getAttribute();

	/**
	 * Returns the value of the '<em><b>Normal Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Normal Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Normal Attribute</em>' attribute.
	 * @see testmodel.TmPackage#getTestOverriding_NormalAttribute()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getNormalAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.i3s.unice.fr/Sigma delegate='testmodel.delegates.OverrideMethodDelegate.method'"
	 * @generated
	 */
	String method();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String normalMethod();

} // TestOverriding

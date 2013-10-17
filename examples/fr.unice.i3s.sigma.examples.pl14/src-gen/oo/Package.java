/**
 */
package oo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link oo.Package#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link oo.Package#getOwnedStereotypes <em>Owned Stereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see oo.OOPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends ModelElement
{
	/**
	 * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
	 * The list contents are of type {@link oo.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Elements</em>' containment reference list.
	 * @see oo.OOPackage#getPackage_OwnedElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Classifier> getOwnedElements();

	/**
	 * Returns the value of the '<em><b>Owned Stereotypes</b></em>' containment reference list.
	 * The list contents are of type {@link oo.Stereotype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Stereotypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Stereotypes</em>' containment reference list.
	 * @see oo.OOPackage#getPackage_OwnedStereotypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Stereotype> getOwnedStereotypes();

} // Package

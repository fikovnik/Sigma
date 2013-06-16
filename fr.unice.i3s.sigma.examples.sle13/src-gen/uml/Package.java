/**
 */
package uml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uml.Package#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see uml.UMLPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends ModelElement
{
	/**
	 * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
	 * The list contents are of type {@link uml.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Elements</em>' containment reference list.
	 * @see uml.UMLPackage#getPackage_OwnedElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Classifier> getOwnedElements();

} // Package

/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Member#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getMember()
 * @model abstract="true"
 * @generated
 */
public interface Member extends EObject
{
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(fr.inria.spirals.sigma.ttc14.fixml.objlang.Class)
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getMember_Parent()
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getMembers
	 * @model opposite="members" required="true" transient="false"
	 * @generated
	 */
	fr.inria.spirals.sigma.ttc14.fixml.objlang.Class getParent();

	/**
	 * Sets the value of the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Member#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(fr.inria.spirals.sigma.ttc14.fixml.objlang.Class value);

} // Member

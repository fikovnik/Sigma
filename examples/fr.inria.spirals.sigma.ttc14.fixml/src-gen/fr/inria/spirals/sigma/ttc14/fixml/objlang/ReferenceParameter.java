/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getReferenceParameter()
 * @model
 * @generated
 */
public interface ReferenceParameter extends Parameter
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(fr.inria.spirals.sigma.ttc14.fixml.objlang.Class)
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getReferenceParameter_Type()
	 * @model required="true"
	 * @generated
	 */
	fr.inria.spirals.sigma.ttc14.fixml.objlang.Class getType();

	/**
	 * Sets the value of the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(fr.inria.spirals.sigma.ttc14.fixml.objlang.Class value);

} // ReferenceParameter

/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral#getType <em>Type</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getArrayLiteral()
 * @model
 * @generated
 */
public interface ArrayLiteral extends Expression
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
	 * @see #setType(Classifier)
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getArrayLiteral_Type()
	 * @model required="true"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getArrayLiteral_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getElements();

} // ArrayLiteral

/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#getType <em>Type</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#isMany <em>Many</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getTypedElement()
 * @model
 * @generated
 */
public interface TypedElement extends NamedElement
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
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getTypedElement_Type()
	 * @model required="true"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many</em>' attribute.
	 * @see #setMany(boolean)
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getTypedElement_Many()
	 * @model required="true"
	 * @generated
	 */
	boolean isMany();

	/**
	 * Sets the value of the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#isMany <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Many</em>' attribute.
	 * @see #isMany()
	 * @generated
	 */
	void setMany(boolean value);

} // TypedElement

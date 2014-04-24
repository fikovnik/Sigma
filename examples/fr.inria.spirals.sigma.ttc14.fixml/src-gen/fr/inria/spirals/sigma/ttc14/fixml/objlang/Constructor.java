/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor#getInitialisations <em>Initialisations</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getConstructor()
 * @model
 * @generated
 */
public interface Constructor extends Member
{
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getConstructor_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Initialisations</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialisations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialisations</em>' containment reference list.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage#getConstructor_Initialisations()
	 * @model containment="true"
	 * @generated
	 */
	EList<FieldInitialisiation> getInitialisations();

} // Constructor

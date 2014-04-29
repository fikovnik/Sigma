/**
 */
package fr.unice.i3s.sigma.examples.simpleoo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.Classifier#getPkg <em>Pkg</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.unice.i3s.sigma.examples.simpleoo.SimpleOOPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends ModelElement
{
	/**
	 * Returns the value of the '<em><b>Pkg</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.unice.i3s.sigma.examples.simpleoo.Package#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pkg</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pkg</em>' container reference.
	 * @see #setPkg(fr.unice.i3s.sigma.examples.simpleoo.Package)
	 * @see fr.unice.i3s.sigma.examples.simpleoo.SimpleOOPackage#getClassifier_Pkg()
	 * @see fr.unice.i3s.sigma.examples.simpleoo.Package#getOwnedElements
	 * @model opposite="ownedElements" required="true" transient="false"
	 * @generated
	 */
	fr.unice.i3s.sigma.examples.simpleoo.Package getPkg();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.simpleoo.Classifier#getPkg <em>Pkg</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pkg</em>' container reference.
	 * @see #getPkg()
	 * @generated
	 */
	void setPkg(fr.unice.i3s.sigma.examples.simpleoo.Package value);

} // Classifier

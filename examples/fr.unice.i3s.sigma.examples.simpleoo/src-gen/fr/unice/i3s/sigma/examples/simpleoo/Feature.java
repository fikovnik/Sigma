/**
 */
package fr.unice.i3s.sigma.examples.simpleoo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.simpleoo.Feature#getOwnerScope <em>Owner Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.unice.i3s.sigma.examples.simpleoo.SimpleOOPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends ModelElement
{
	/**
	 * Returns the value of the '<em><b>Owner Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.unice.i3s.sigma.examples.simpleoo.ScopeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Scope</em>' attribute.
	 * @see fr.unice.i3s.sigma.examples.simpleoo.ScopeKind
	 * @see #setOwnerScope(ScopeKind)
	 * @see fr.unice.i3s.sigma.examples.simpleoo.SimpleOOPackage#getFeature_OwnerScope()
	 * @model required="true"
	 * @generated
	 */
	ScopeKind getOwnerScope();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.simpleoo.Feature#getOwnerScope <em>Owner Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Scope</em>' attribute.
	 * @see fr.unice.i3s.sigma.examples.simpleoo.ScopeKind
	 * @see #getOwnerScope()
	 * @generated
	 */
	void setOwnerScope(ScopeKind value);

} // Feature

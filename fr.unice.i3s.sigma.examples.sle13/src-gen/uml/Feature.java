/**
 */
package uml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link uml.Feature#getOwnerScope <em>Owner Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see uml.UmlPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends ModelElement
{
	/**
	 * Returns the value of the '<em><b>Owner Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link uml.ScopeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Scope</em>' attribute.
	 * @see uml.ScopeKind
	 * @see #setOwnerScope(ScopeKind)
	 * @see uml.UmlPackage#getFeature_OwnerScope()
	 * @model required="true"
	 * @generated
	 */
	ScopeKind getOwnerScope();

	/**
	 * Sets the value of the '{@link uml.Feature#getOwnerScope <em>Owner Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Scope</em>' attribute.
	 * @see uml.ScopeKind
	 * @see #getOwnerScope()
	 * @generated
	 */
	void setOwnerScope(ScopeKind value);

} // Feature

/**
 */
package Relational;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Relational.EnumerationType#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see Relational.RelationalPackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends Domain
{
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link Relational.EnumeratedLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see Relational.RelationalPackage#getEnumerationType_Literals()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EnumeratedLiteral> getLiterals();

} // EnumerationType

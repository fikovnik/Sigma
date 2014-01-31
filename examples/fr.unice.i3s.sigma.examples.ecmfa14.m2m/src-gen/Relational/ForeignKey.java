/**
 */
package Relational;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Relational.ForeignKey#getReferencedTable <em>Referenced Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see Relational.RelationalPackage#getForeignKey()
 * @model
 * @generated
 */
public interface ForeignKey extends CandidateKey
{
	/**
	 * Returns the value of the '<em><b>Referenced Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Table</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Table</em>' reference.
	 * @see #setReferencedTable(Table)
	 * @see Relational.RelationalPackage#getForeignKey_ReferencedTable()
	 * @model required="true"
	 * @generated
	 */
	Table getReferencedTable();

	/**
	 * Sets the value of the '{@link Relational.ForeignKey#getReferencedTable <em>Referenced Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Table</em>' reference.
	 * @see #getReferencedTable()
	 * @generated
	 */
	void setReferencedTable(Table value);

} // ForeignKey

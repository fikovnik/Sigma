/**
 */
package Relational;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Relational.Table#getName <em>Name</em>}</li>
 *   <li>{@link Relational.Table#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link Relational.Table#getCandidateKey <em>Candidate Key</em>}</li>
 *   <li>{@link Relational.Table#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link Relational.Table#getForeignKey <em>Foreign Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see Relational.RelationalPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Relational.RelationalPackage#getTable_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Relational.Table#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' reference.
	 * @see #setPrimaryKey(CandidateKey)
	 * @see Relational.RelationalPackage#getTable_PrimaryKey()
	 * @model required="true"
	 * @generated
	 */
	CandidateKey getPrimaryKey();

	/**
	 * Sets the value of the '{@link Relational.Table#getPrimaryKey <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(CandidateKey value);

	/**
	 * Returns the value of the '<em><b>Candidate Key</b></em>' containment reference list.
	 * The list contents are of type {@link Relational.CandidateKey}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidate Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidate Key</em>' containment reference list.
	 * @see Relational.RelationalPackage#getTable_CandidateKey()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<CandidateKey> getCandidateKey();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link Relational.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see Relational.RelationalPackage#getTable_Attributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Foreign Key</b></em>' containment reference list.
	 * The list contents are of type {@link Relational.ForeignKey}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Key</em>' containment reference list.
	 * @see Relational.RelationalPackage#getTable_ForeignKey()
	 * @model containment="true"
	 * @generated
	 */
	EList<ForeignKey> getForeignKey();

} // Table

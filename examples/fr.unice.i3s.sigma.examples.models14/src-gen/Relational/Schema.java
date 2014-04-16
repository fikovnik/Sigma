/**
 */
package Relational;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Relational.Schema#getName <em>Name</em>}</li>
 *   <li>{@link Relational.Schema#getTables <em>Tables</em>}</li>
 *   <li>{@link Relational.Schema#getDomains <em>Domains</em>}</li>
 *   <li>{@link Relational.Schema#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see Relational.RelationalPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends EObject
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
	 * @see Relational.RelationalPackage#getSchema_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Relational.Schema#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link Relational.Table}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see Relational.RelationalPackage#getSchema_Tables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Table> getTables();

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' containment reference list.
	 * The list contents are of type {@link Relational.Domain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domains</em>' containment reference list.
	 * @see Relational.RelationalPackage#getSchema_Domains()
	 * @model containment="true"
	 * @generated
	 */
	EList<Domain> getDomains();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link Relational.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see Relational.RelationalPackage#getSchema_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

} // Schema

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library;

import java.lang.CharSequence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Library#getName <em>Name</em>}</li>
 *   <li>{@link library.Library#getBooks <em>Books</em>}</li>
 *   <li>{@link library.Library#getLoans <em>Loans</em>}</li>
 *   <li>{@link library.Library#getMembers <em>Members</em>}</li>
 *   <li>{@link library.Library#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getLibrary()
 * @model annotation="http://www.i3s.unice.fr/Sigma delegate='library.delegate.LibraryDelegate'"
 * @generated
 */
public interface Library extends EObject {
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
	 * @see library.LibraryPackage#getLibrary_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link library.Library#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link library.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see library.LibraryPackage#getLibrary_Books()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Loans</b></em>' containment reference list.
	 * The list contents are of type {@link library.Loan}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loans</em>' containment reference list.
	 * @see library.LibraryPackage#getLibrary_Loans()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Loan> getLoans();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link library.Member}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see library.LibraryPackage#getLibrary_Members()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Member> getMembers();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see library.LibraryPackage#getLibrary_Description()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameDataType="library.ECharSequence"
	 * @generated
	 */
	Book getBookByName(CharSequence name);

} // Library

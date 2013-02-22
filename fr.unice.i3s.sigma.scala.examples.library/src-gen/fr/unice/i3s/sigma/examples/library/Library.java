/**
 */
package fr.unice.i3s.sigma.examples.library;

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
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Library#getName <em>Name</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Library#getBooks <em>Books</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Library#getLoans <em>Loans</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Library#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLibrary()
 * @model
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
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLibrary_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.library.Library#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link fr.unice.i3s.sigma.examples.library.Book}.
	 * It is bidirectional and its opposite is '{@link fr.unice.i3s.sigma.examples.library.Book#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLibrary_Books()
	 * @see fr.unice.i3s.sigma.examples.library.Book#getLibrary
	 * @model opposite="library" containment="true" ordered="false"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Loans</b></em>' containment reference list.
	 * The list contents are of type {@link fr.unice.i3s.sigma.examples.library.Loan}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loans</em>' containment reference list.
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLibrary_Loans()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Loan> getLoans();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link fr.unice.i3s.sigma.examples.library.Member}.
	 * It is bidirectional and its opposite is '{@link fr.unice.i3s.sigma.examples.library.Member#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLibrary_Members()
	 * @see fr.unice.i3s.sigma.examples.library.Member#getLibrary
	 * @model opposite="library" containment="true" ordered="false"
	 * @generated
	 */
	EList<Member> getMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Book getBookByName(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String toString();

} // Library

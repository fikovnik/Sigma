/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package library;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link library.Book#getName <em>Name</em>}</li>
 *   <li>{@link library.Book#getCopies <em>Copies</em>}</li>
 *   <li>{@link library.Book#getLibrary <em>Library</em>}</li>
 *   <li>{@link library.Book#getLoans <em>Loans</em>}</li>
 * </ul>
 * </p>
 *
 * @see library.LibraryPackage#getBook()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SufficientCopies'"
 *        annotation="http://www.i3s.unice.fr/Sigma SufficientCopies='' delegate='library.delegate.BookDelegate'"
 * @generated
 */
public interface Book extends EObject {
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
	 * @see library.LibraryPackage#getBook_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link library.Book#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Copies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copies</em>' attribute.
	 * @see #setCopies(BigInteger)
	 * @see library.LibraryPackage#getBook_Copies()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BigInteger getCopies();

	/**
	 * Sets the value of the '{@link library.Book#getCopies <em>Copies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copies</em>' attribute.
	 * @see #getCopies()
	 * @generated
	 */
	void setCopies(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Library</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' reference.
	 * @see #setLibrary(Library)
	 * @see library.LibraryPackage#getBook_Library()
	 * @model required="true" transient="true" derived="true" ordered="false"
	 * @generated
	 */
	Library getLibrary();

	/**
	 * Sets the value of the '{@link library.Book#getLibrary <em>Library</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library</em>' reference.
	 * @see #getLibrary()
	 * @generated
	 */
	void setLibrary(Library value);

	/**
	 * Returns the value of the '<em><b>Loans</b></em>' reference list.
	 * The list contents are of type {@link library.Loan}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loans</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loans</em>' reference list.
	 * @see library.LibraryPackage#getBook_Loans()
	 * @model volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Loan> getLoans();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	boolean isAvailable();

} // Book

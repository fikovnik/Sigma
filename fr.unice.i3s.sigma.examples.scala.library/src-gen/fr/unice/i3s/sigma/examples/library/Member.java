/**
 */
package fr.unice.i3s.sigma.examples.library;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Member#getName <em>Name</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Member#getLibrary <em>Library</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Member#getLoans <em>Loans</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Member#getBooks <em>Books</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Member#getMembershipType <em>Membership Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getMember()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AtMostTwoLoans UniqueLoans'"
 *        annotation="http://www.i3s.unice.fr/Sigma AtMostTwoLoans='' UniqueLoans=''"
 * @generated
 */
public interface Member extends EObject {
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
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getMember_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.library.Member#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Library</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.unice.i3s.sigma.examples.library.Library#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library</em>' container reference.
	 * @see #setLibrary(Library)
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getMember_Library()
	 * @see fr.unice.i3s.sigma.examples.library.Library#getMembers
	 * @model opposite="members" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Library getLibrary();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.library.Member#getLibrary <em>Library</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library</em>' container reference.
	 * @see #getLibrary()
	 * @generated
	 */
	void setLibrary(Library value);

	/**
	 * Returns the value of the '<em><b>Loans</b></em>' reference list.
	 * The list contents are of type {@link fr.unice.i3s.sigma.examples.library.Loan}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loans</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loans</em>' reference list.
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getMember_Loans()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Loan> getLoans();

	/**
	 * Returns the value of the '<em><b>Books</b></em>' reference list.
	 * The list contents are of type {@link fr.unice.i3s.sigma.examples.library.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' reference list.
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getMember_Books()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Membership Type</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.unice.i3s.sigma.examples.library.MembershipType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Membership Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Membership Type</em>' attribute.
	 * @see fr.unice.i3s.sigma.examples.library.MembershipType
	 * @see #setMembershipType(MembershipType)
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getMember_MembershipType()
	 * @model required="true"
	 * @generated
	 */
	MembershipType getMembershipType();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.library.Member#getMembershipType <em>Membership Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Membership Type</em>' attribute.
	 * @see fr.unice.i3s.sigma.examples.library.MembershipType
	 * @see #getMembershipType()
	 * @generated
	 */
	void setMembershipType(MembershipType value);

} // Member

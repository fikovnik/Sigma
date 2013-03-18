/**
 */
package fr.unice.i3s.sigma.examples.library;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Loan#getBook <em>Book</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Loan#getMember <em>Member</em>}</li>
 *   <li>{@link fr.unice.i3s.sigma.examples.library.Loan#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLoan()
 * @model
 * @generated
 */
public interface Loan extends EObject {
	/**
	 * Returns the value of the '<em><b>Book</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Book</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Book</em>' reference.
	 * @see #setBook(Book)
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLoan_Book()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Book getBook();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.library.Loan#getBook <em>Book</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Book</em>' reference.
	 * @see #getBook()
	 * @generated
	 */
	void setBook(Book value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' reference.
	 * @see #setMember(Member)
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLoan_Member()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Member getMember();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.library.Loan#getMember <em>Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(Member value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage#getLoan_Date()
	 * @model dataType="fr.unice.i3s.sigma.examples.library.Date" ordered="false"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link fr.unice.i3s.sigma.examples.library.Loan#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // Loan

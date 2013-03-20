/**
 */
package fr.unice.i3s.sigma.examples.library.util;

import fr.unice.i3s.sigma.examples.library.*;

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see fr.unice.i3s.sigma.examples.library.LibraryPackage
 * @generated
 */
public class LibraryValidator extends EObjectValidator
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final LibraryValidator INSTANCE = new LibraryValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "fr.unice.i3s.sigma.examples.library";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryValidator()
	{
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage()
	{
	  return LibraryPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		switch (classifierID)
		{
			case LibraryPackage.LIBRARY:
				return validateLibrary((Library)value, diagnostics, context);
			case LibraryPackage.BOOK:
				return validateBook((Book)value, diagnostics, context);
			case LibraryPackage.MEMBER:
				return validateMember((Member)value, diagnostics, context);
			case LibraryPackage.LOAN:
				return validateLoan((Loan)value, diagnostics, context);
			case LibraryPackage.MEMBERSHIP_TYPE:
				return validateMembershipType((MembershipType)value, diagnostics, context);
			case LibraryPackage.DATE:
				return validateDate((Date)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibrary(Library library, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(library, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBook(Book book, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(book, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(book, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(book, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(book, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(book, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(book, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(book, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(book, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(book, diagnostics, context);
		if (result || diagnostics != null) result &= validateBook_SufficientCopies(book, diagnostics, context);
		if (result || diagnostics != null) result &= validateBook_AtLeastOneCopy(book, diagnostics, context);
		return result;
	}

	/**
	 * Validates the SufficientCopies constraint of '<em>Book</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBook_SufficientCopies(Book book, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "SufficientCopies", getObjectLabel(book, context) },
						 new Object[] { book },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the AtLeastOneCopy constraint of '<em>Book</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBook_AtLeastOneCopy(Book book, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "AtLeastOneCopy", getObjectLabel(book, context) },
						 new Object[] { book },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMember(Member member, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(member, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(member, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(member, diagnostics, context);
		if (result || diagnostics != null) result &= validateMember_AtMostTwoLoans(member, diagnostics, context);
		if (result || diagnostics != null) result &= validateMember_UniqueLoans(member, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AtMostTwoLoans constraint of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMember_AtMostTwoLoans(Member member, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "AtMostTwoLoans", getObjectLabel(member, context) },
						 new Object[] { member },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the UniqueLoans constraint of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMember_UniqueLoans(Member member, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "UniqueLoans", getObjectLabel(member, context) },
						 new Object[] { member },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoan(Loan loan, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(loan, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMembershipType(MembershipType membershipType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDate(Date date, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //LibraryValidator

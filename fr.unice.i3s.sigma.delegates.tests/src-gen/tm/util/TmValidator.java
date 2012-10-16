/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tm.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import tm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see tm.TmPackage
 * @generated
 */
public class TmValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TmValidator INSTANCE = new TmValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "tm";

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
	public TmValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return TmPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case TmPackage.TEST_CLASS:
				return validateTestClass((TestClass)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestClass(TestClass testClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(testClass, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateTestClass_NonZero(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateTestClass_SmallerThan100(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateTestClass_Divides64(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateTestClass_WithMessage(testClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateTestClass_WithQuickFix(testClass, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the NonZero constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TEST_CLASS__NON_ZERO__EEXPRESSION = "";

	/**
	 * Validates the NonZero constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestClass_NonZero(TestClass testClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TmPackage.Literals.TEST_CLASS,
				 testClass,
				 diagnostics,
				 context,
				 "http://www.i3s.unice.fr/Sigma",
				 "NonZero",
				 TEST_CLASS__NON_ZERO__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the SmallerThan100 constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TEST_CLASS__SMALLER_THAN100__EEXPRESSION = "";

	/**
	 * Validates the SmallerThan100 constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestClass_SmallerThan100(TestClass testClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TmPackage.Literals.TEST_CLASS,
				 testClass,
				 diagnostics,
				 context,
				 "http://www.i3s.unice.fr/Sigma",
				 "SmallerThan100",
				 TEST_CLASS__SMALLER_THAN100__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the Divides64 constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TEST_CLASS__DIVIDES64__EEXPRESSION = "";

	/**
	 * Validates the Divides64 constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestClass_Divides64(TestClass testClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TmPackage.Literals.TEST_CLASS,
				 testClass,
				 diagnostics,
				 context,
				 "http://www.i3s.unice.fr/Sigma",
				 "Divides64",
				 TEST_CLASS__DIVIDES64__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the WithMessage constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TEST_CLASS__WITH_MESSAGE__EEXPRESSION = "";

	/**
	 * Validates the WithMessage constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestClass_WithMessage(TestClass testClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TmPackage.Literals.TEST_CLASS,
				 testClass,
				 diagnostics,
				 context,
				 "http://www.i3s.unice.fr/Sigma",
				 "WithMessage",
				 TEST_CLASS__WITH_MESSAGE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the WithQuickFix constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String TEST_CLASS__WITH_QUICK_FIX__EEXPRESSION = "";

	/**
	 * Validates the WithQuickFix constraint of '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTestClass_WithQuickFix(TestClass testClass, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TmPackage.Literals.TEST_CLASS,
				 testClass,
				 diagnostics,
				 context,
				 "http://www.i3s.unice.fr/Sigma",
				 "WithQuickFix",
				 TEST_CLASS__WITH_QUICK_FIX__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //TmValidator

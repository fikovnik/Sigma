/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import fr.unice.i3s.sigma.delegate.*;

import test.A;
import test.B;
import test.C;
import test.D;
import test.TestPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see test.TestPackage
 * @generated
 */
public class TestValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TestValidator INSTANCE = new TestValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "test";

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
	public TestValidator() {
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
	  return TestPackage.eINSTANCE;
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
			case TestPackage.A:
				return validateA((A)value, diagnostics, context);
			case TestPackage.B:
				return validateB((B)value, diagnostics, context);
			case TestPackage.C:
				return validateC((C)value, diagnostics, context);
			case TestPackage.D:
				return validateD((D)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateA(A a, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(a, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateB(B b, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(b, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateC(C c, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(c, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateD(D d, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(d, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(d, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(d, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(d, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(d, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(d, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(d, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(d, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(d, diagnostics, context);
		if (result || diagnostics != null) result &= validateD_AlwaysTrueInvariant(d, diagnostics, context);
		if (result || diagnostics != null) result &= validateD_AlwaysFalseInvariant(d, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the AlwaysTrueInvariant constraint of '<em>D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String D__ALWAYS_TRUE_INVARIANT__EEXPRESSION = "";

	/**
	 * Validates the AlwaysTrueInvariant constraint of '<em>D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateD_AlwaysTrueInvariant(D d, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TestPackage.Literals.D,
				 d,
				 diagnostics,
				 context,
				 "http://www.i3s.unice.fr/Sigma/Scala",
				 "AlwaysTrueInvariant",
				 D__ALWAYS_TRUE_INVARIANT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the AlwaysFalseInvariant constraint of '<em>D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String D__ALWAYS_FALSE_INVARIANT__EEXPRESSION = "";

	/**
	 * Validates the AlwaysFalseInvariant constraint of '<em>D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateD_AlwaysFalseInvariant(D d, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(TestPackage.Literals.D,
				 d,
				 diagnostics,
				 context,
				 "http://www.i3s.unice.fr/Sigma/Scala",
				 "AlwaysFalseInvariant",
				 D__ALWAYS_FALSE_INVARIANT__EEXPRESSION,
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

} //TestValidator

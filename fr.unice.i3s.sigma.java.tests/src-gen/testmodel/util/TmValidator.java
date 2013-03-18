/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testmodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;

import testmodel.*;
import fr.unice.i3s.sigma.java.delegates.SigmaEObjectValidator;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 * 
 * @see testmodel.TmPackage
 * @generated
 */
public class TmValidator extends SigmaEObjectValidator {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final TmValidator INSTANCE = new TmValidator();

	/**
	 * A constant for the
	 * {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
	 * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes}
	 * from this package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "testmodel";

	/**
	 * A constant with a fixed name that can be used as the base value for
	 * additional hand written constants. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for
	 * additional hand written constants in a derived class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public TmValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return TmPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the
	 * model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case TmPackage.TEST_CLASS:
			return validateTestClass((TestClass) value, diagnostics, context);
		case TmPackage.TEST_OVERRIDING:
			return validateTestOverriding((TestOverriding) value, diagnostics,
					context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestClass(TestClass testClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(testClass, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(testClass,
				diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(testClass, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(testClass,
					diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(testClass,
					diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(testClass, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(testClass, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(testClass, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(testClass, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validateTestClass_A(testClass, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateTestClass_B(testClass, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateTestClass_C(testClass, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateTestClass_D(testClass, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateTestClass_E(testClass, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateTestClass_F(testClass, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the A constraint of '
	 * <em>Test Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_CLASS__A__EEXPRESSION = "";

	/**
	 * Validates the A constraint of '<em>Test Class</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestClass_A(TestClass testClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_CLASS, testClass, diagnostics,
				context, "http://www.i3s.unice.fr/Sigma", "A",
				TEST_CLASS__A__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the B constraint of '
	 * <em>Test Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_CLASS__B__EEXPRESSION = "";

	/**
	 * Validates the B constraint of '<em>Test Class</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestClass_B(TestClass testClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_CLASS, testClass, diagnostics,
				context, "http://www.i3s.unice.fr/Sigma", "B",
				TEST_CLASS__B__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the C constraint of '
	 * <em>Test Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_CLASS__C__EEXPRESSION = "";

	/**
	 * Validates the C constraint of '<em>Test Class</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestClass_C(TestClass testClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_CLASS, testClass, diagnostics,
				context, "http://www.i3s.unice.fr/Sigma", "C",
				TEST_CLASS__C__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the D constraint of '
	 * <em>Test Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_CLASS__D__EEXPRESSION = "";

	/**
	 * Validates the D constraint of '<em>Test Class</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestClass_D(TestClass testClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_CLASS, testClass, diagnostics,
				context, "http://www.i3s.unice.fr/Sigma", "D",
				TEST_CLASS__D__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the E constraint of '
	 * <em>Test Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_CLASS__E__EEXPRESSION = "";

	/**
	 * Validates the E constraint of '<em>Test Class</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestClass_E(TestClass testClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_CLASS, testClass, diagnostics,
				context, "http://www.i3s.unice.fr/Sigma", "E",
				TEST_CLASS__E__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the F constraint of '
	 * <em>Test Class</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_CLASS__F__EEXPRESSION = "";

	/**
	 * Validates the F constraint of '<em>Test Class</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestClass_F(TestClass testClass,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_CLASS, testClass, diagnostics,
				context, "http://www.i3s.unice.fr/Sigma", "F",
				TEST_CLASS__F__EEXPRESSION, Diagnostic.ERROR,
				DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestOverriding(TestOverriding testOverriding,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(testOverriding, diagnostics,
				context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(testOverriding,
				diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(testOverriding,
					diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(testOverriding,
					diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(
					testOverriding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(testOverriding, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(testOverriding, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(testOverriding, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(testOverriding, diagnostics,
					context);
		}
		if (result || diagnostics != null) {
			result &= validateTestOverriding_constraint(testOverriding,
					diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateTestOverriding_normalConstraint(testOverriding,
					diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the constraint constraint of '
	 * <em>Test Overriding</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_OVERRIDING__CONSTRAINT__EEXPRESSION = "testmodel.delegates.OverrideConstraintDelegate.checkA";

	/**
	 * Validates the constraint constraint of '<em>Test Overriding</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestOverriding_constraint(
			TestOverriding testOverriding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_OVERRIDING, testOverriding,
				diagnostics, context, "http://www.i3s.unice.fr/Sigma",
				"constraint", TEST_OVERRIDING__CONSTRAINT__EEXPRESSION,
				Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the normalConstraint constraint of '
	 * <em>Test Overriding</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TEST_OVERRIDING__NORMAL_CONSTRAINT__EEXPRESSION = "";

	/**
	 * Validates the normalConstraint constraint of '<em>Test Overriding</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTestOverriding_normalConstraint(
			TestOverriding testOverriding, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(TmPackage.Literals.TEST_OVERRIDING, testOverriding,
				diagnostics, context, "http://www.i3s.unice.fr/Sigma",
				"normalConstraint",
				TEST_OVERRIDING__NORMAL_CONSTRAINT__EEXPRESSION,
				Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this
	 * validator's diagnostics. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to
		// this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // TmValidator

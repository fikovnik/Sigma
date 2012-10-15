package fr.unice.i3s.sigma.delegates;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

import static fr.unice.i3s.sigma.core.Assert.notNull;

import fr.unice.i3s.sigma.core.ValidationResult;
import fr.unice.i3s.sigma.ui.ide.validation.ISigmaQuickFixManager;
import fr.unice.i3s.sigma.ui.ide.validation.SigmaQuickFixManager;

/**
 * An enhancement of the standard {@link EObjectValidator} to allow validation
 * failures to obtain a corresponding diagnostic from the validation delegate
 * rather using the default delegate exception message.
 * 
 * It roughly follows the idea from {@code OCLInEcoreEObjectValidator} and bug
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=337792">33792</a>.
 * 
 * @author E.D.Willink - {@code OCLInEcoreEObjectValidator} code.
 * @author Filip Krikava - Adapted to Sigma
 * 
 */
public class SigmaEObjectValidator extends EObjectValidator {

	private ISigmaQuickFixManager resolutionManager;
	private boolean isQuckFixManagerAvailable = false;

	public SigmaEObjectValidator() {
		super();

		try {
			resolutionManager = SigmaQuickFixManager.getInstance();
			isQuckFixManagerAvailable = true;
		} catch (NoClassDefFoundError e) {
			isQuckFixManagerAvailable = false;
		}
	}

	public SigmaEObjectValidator(ISigmaQuickFixManager resolutionManager) {
		super();

		this.resolutionManager = notNull(resolutionManager);
		this.isQuckFixManagerAvailable = true;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context,
			String validationDelegate, String constraint, String expression,
			int severity, String source, int code) {

		ValidationDelegate delegate = getValidationDelegateRegistry(context)
				.getValidationDelegate(validationDelegate);

		if (delegate instanceof SigmaValidationDelegateFactory) {

			return validateUsingSigmaDelegate(eClass, eObject, diagnostics,
					context, constraint, expression, severity, source, code,
					((SigmaValidationDelegateFactory) delegate).getDelegate(
							eClass, constraint));
		} else if (delegate != null) {

			return validateUsingDefaultDelegate(eClass, eObject, diagnostics,
					context, validationDelegate, constraint, expression,
					severity, source, code, delegate);
		} else {

			if (diagnostics != null) {
				reportConstraintDelegateNotFound(eClass, eObject, diagnostics,
						context, constraint, severity, source, code,
						validationDelegate);
			}

			return true;
		}
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context,
			String validationDelegate, String constraint, String expression,
			int severity, String source, int code) {

		ValidationDelegate delegate = getValidationDelegateRegistry(context)
				.getValidationDelegate(validationDelegate);

		if (delegate instanceof SigmaValidationDelegateFactory) {

			return validateUsingSigmaDelegate(eDataType, value, diagnostics,
					context, constraint, expression, severity, source, code,
					((SigmaValidationDelegateFactory) delegate).getDelegate(
							eDataType, constraint));
		} else if (delegate != null) {

			return validateUsingDefaultDelegate(eDataType, value, diagnostics,
					context, validationDelegate, constraint, expression,
					severity, source, code, delegate);
		} else {

			if (diagnostics != null) {
				reportConstraintDelegateNotFound(eDataType, value, diagnostics,
						context, constraint, severity, source, code,
						validationDelegate);
			}

			return true;
		}
	}

	private boolean validateUsingDefaultDelegate(EDataType eDataType,
			Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context, String validationDelegate,
			String constraint, String expression, int severity, String source,
			int code, ValidationDelegate delegate) {
		try {
			if (!delegate.validate(eDataType, value, context, constraint,
					expression)) {
				if (diagnostics != null) {
					reportConstraintDelegateViolation(eDataType, value,
							diagnostics, context, constraint, severity, source,
							code);
				}

				return false;
			}
		} catch (Throwable e) {
			if (diagnostics != null) {
				reportConstraintDelegateException(eDataType, value,
						diagnostics, context, constraint, severity, source,
						code, e);
			}
		}

		return true;
	}

	private boolean validateUsingSigmaDelegate(EDataType eDataType,
			Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context, String constraint, String expression,
			int severity, String source, int code,
			SigmaValidationDelegate delegate) {

		try {
			ValidationResult result = delegate.validate(eDataType, value,
					constraint, expression);
			if (!result.isValidOrCanceled()) {
				diagnostics.add(new BasicDiagnostic(result.getSeverity(),
						source, code, NLS
								.bind(Messages.Sigma_GenericConstraintViolated,
										new Object[] {
												constraint,
												getValueLabel(eDataType, value,
														context),
												result.getMessage() }),
						new Object[] { eDataType }));

				return false;
			}
		} catch (SigmaDelegateNotFoundException e) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								severity,
								source,
								code,
								NLS.bind(
										Messages.Sigma_NoValidationDelegate,
										new Object[] {
												getValueLabel(eDataType, value,
														context),
												delegate.getExpectedMethodSignature(),
												expression }),
								new Object[] { value }));
			}
		} catch (Throwable e) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								severity,
								source,
								code,
								NLS.bind(
										Messages.Sigma_ValidationDelegateException,
										new Object[] {
												constraint,
												getValueLabel(eDataType, value,
														context), delegate, e }),
								new Object[] { value }));
			}
		}

		return true;
	}

	private boolean validateUsingDefaultDelegate(EClass eClass,
			EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context, String validationDelegate,
			String constraint, String expression, int severity, String source,
			int code, ValidationDelegate delegate) {

		try {
			if (!delegate.validate(eClass, eObject, context, constraint,
					expression)) {
				if (diagnostics != null) {
					reportConstraintDelegateViolation(eClass, eObject,
							diagnostics, context, constraint, severity, source,
							code);
				}
				return false;
			}
		} catch (Throwable throwable) {
			if (diagnostics != null) {
				reportConstraintDelegateException(eClass, eObject, diagnostics,
						context, constraint, severity, source, code, throwable);
			}
		}

		return true;
	}

	private boolean validateUsingSigmaDelegate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context,
			String constraint, String expression, int severity, String source,
			int code, SigmaValidationDelegate delegate) {

		try {
			ValidationResult result = delegate.validate(eClass, eObject,
					constraint, expression);
			if (!result.isValidOrCanceled()) {
				diagnostics.add(SigmaDiagnostic.fromResult(eObject, constraint,
						source, code, result));

				// add the result to the maker resolution
				addToQuickFixes(eObject, result);

				return false;
			}
		} catch (SigmaDelegateNotFoundException e) {
			if (diagnostics != null) {
				String message = NLS.bind(Messages.Sigma_NoValidationDelegate,
						new Object[] { getObjectLabel(eObject, context),
								delegate.getExpectedMethodSignature(),
								expression });

				diagnostics.add(SigmaDiagnostic.fromException(constraint,
						eObject, source, code, message, e));
			}
		} catch (Throwable e) {
			if (diagnostics != null) {
				String message = NLS
						.bind(Messages.Sigma_ValidationDelegateException,
								new Object[] { constraint,
										getObjectLabel(eObject, context),
										delegate, e });

				diagnostics.add(SigmaDiagnostic.fromException(constraint,
						eObject, source, code, message, e));
			}
		}

		return true;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			removeQuickFixes(eObject);
		}

		return super.validate(eClass, eObject, diagnostics, context);
	}

	private void addToQuickFixes(EObject eObject, ValidationResult result) {
		if (!isQuckFixManagerAvailable || result.getQuickFixes().isEmpty()) {
			return;
		}

		URI eObjectURI = getEObjectURI(eObject);
		resolutionManager.addAll(eObjectURI, result.getMessage(),
				result.getQuickFixes());
	}

	private void removeQuickFixes(EObject eObject) {
		if (!isQuckFixManagerAvailable) {
			return;
		}

		URI eObjectURI = getEObjectURI(eObject);
		resolutionManager.removeAll(eObjectURI);
	}

	private URI getEObjectURI(EObject eObject) {
		return EcoreUtil.getURI(eObject);
	}
}

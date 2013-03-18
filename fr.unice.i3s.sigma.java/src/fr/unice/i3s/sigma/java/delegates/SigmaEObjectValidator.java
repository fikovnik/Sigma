package fr.unice.i3s.sigma.java.delegates;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

import com.google.common.base.Predicate;

import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Maps.filterKeys;
import static com.google.common.collect.Maps.newHashMap;
import static fr.unice.i3s.sigma.core.Assert.notNull;

import fr.unice.i3s.sigma.core.Utils;
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

	static class PartialValidationResults {
		private final Map<String, ValidationResult> results = newHashMap();

		public boolean hasExecuted(String constraint) {
			notNull(constraint);
			return results.containsKey(constraint);
		}

		public ValidationResult getResult(String contraint) {
			notNull(contraint);
			return results.get(contraint);
		}

		public Map<String, ValidationResult> getResults(
				final Collection<String> constraints) {

			notNull(constraints);
			return filterKeys(results, new Predicate<String>() {
				@Override
				public boolean apply(String input) {
					return constraints.contains(input);
				}
			});
		}

		public static Integer key(Object object) {
			notNull(object);
			return Integer.valueOf(31 + object.hashCode());

		}

		public void setResult(String constraint, ValidationResult result) {
			notNull(constraint);
			notNull(result);
			results.put(constraint, result);
		}

		@Override
		public String toString() {
			return results.toString();
		}

	}

	/**
	 * @param validationDelegate
	 *            URI of the validation delegate defined in the EMF model in the
	 *            Ecore annotation at the package level
	 */
	@Override
	// @formatter:off
	public boolean validate(
			EClass eClass, 
			EObject eObject,
			DiagnosticChain diagnostics, 
			Map<Object, Object> context,
			String validationDelegate, 
			String constraint, 
			String expression,
			int severity, 
			String source, 
			int code) {
	// @formatter:on

		ValidationDelegate delegate = getValidationDelegateRegistry(context)
				.getValidationDelegate(validationDelegate);

		if (delegate instanceof JSigmaValidationDelegateFactory) {

			JSigmaValidationDelegateFactory delegateFactory = (JSigmaValidationDelegateFactory) delegate;
			JSigmaValidationDelegate sigmaDelegate = null;

			try {
				sigmaDelegate = delegateFactory.getDelegate(eClass, constraint);
			} catch (SigmaDelegateNotFoundException e) {
				String message = NLS
						.bind(Messages.Sigma_NoValidationDelegate,
								new Object[] {
										getObjectLabel(eObject, context),
										sigmaDelegate.getMethodSignature(),
										expression });

				diagnostics.add(SigmaDiagnostic.fromException(constraint,
						eObject, source, code, message, e));

				return false;
			}

			// @formatter:off
			return validate(
					eObject, 
					diagnostics,
					context, 
					sigmaDelegate, 
					source, 
					code);
			// @formatter:on
		} else {
			return super.validate(eClass, eObject, diagnostics, context,
					validationDelegate, constraint, expression, severity,
					source, code);
		}
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			removeQuickFixes(eObject);
		}

		return super.validate(eClass, eObject, diagnostics, context);
	}

	public static boolean validate(EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context,
			ISigmaValidationDelegate delegate, String source, int code) {

		final EClass eClass = delegate.getEClass();
		final String constraint = delegate.getConstraint();
		// 0. try to get partial results
		final Integer key = PartialValidationResults.key(eObject);
		final PartialValidationResults partialResults = getParticalResults(
				context, key);

		// 1. has this constraint been already executed on this object?
		if (partialResults.hasExecuted(constraint)) {
			// they were so we just return the result value since it has already
			// been reported in the chain
			return partialResults.getResult(constraint).isValidOrCanceled();
		}

		List<String> deps = delegate.getDependencies();

		// System.out.println("----");
		// System.out.println("EObject: " + eObject);
		// System.out.println("Evaluating constraint: " + constraint);
		// System.out.println("Partial results: " + partialResults);
		// System.out.println("Dependencies: " + deps);
		// System.out.println("----");

		// 2. has this constraint dependencies that has not yet been executed on
		// this object? This has to run in the loop and we need to do the checks
		// every time since one constraint validation might in turn trigger
		// another constraints validations
		while (true) {
			// get the results of the so far evaluated dependent constraints
			Map<String, ValidationResult> depsSoFar = partialResults
					.getResults(deps);

			// has any dependent constraint already failed
			boolean failure = any(depsSoFar.values(),
					new Predicate<ValidationResult>() {
						@Override
						public boolean apply(ValidationResult input) {
							return !input.isValidOrCanceled();
						}
					});

			if (failure) {
				// there has been already a constraint that has failed
				// we return true, because effectively this constraint has not
				// been
				// violated, it has only not been evaluated. The failure is
				// already
				// in the diagnostics chain.
				partialResults.setResult(constraint, ValidationResult.cancel());
				return true;
			}

			// get the first one that has not been executed
			String nextUnchecked = find(deps, new Predicate<String>() {
				@Override
				public boolean apply(String input) {
					return !partialResults.hasExecuted(input);
				}
			}, null);

			if (nextUnchecked == null) {
				break;
			} else {
				ISigmaValidationDelegate nextDelegate = delegate.getDomain()
						.getValidationDelegateFactory()
						.getDelegate(eClass, nextUnchecked);

				validate(eObject, diagnostics, context, nextDelegate, source,
						code);
			}
		}

		// 3. execute - ok so far so good - all dependencies has been satisfied
		Object status = null;
		ValidationResult result = null;

		try {
			// here is the actual validation
			status = delegate.validate(eObject);
			result = delegate.getDomain().toSigmaValidationResult(status,
					delegate, eObject);
		} catch (Throwable e) {
			// an exception during the delegate validation
			if (diagnostics != null) {
				String message = Utils.bind(
						Messages.Sigma_ValidationDelegateException, constraint,
						EObjectValidator.getObjectLabel(eObject, context),
						delegate, e);

				diagnostics.add(SigmaDiagnostic.fromException(constraint,
						eObject, source, code, message, e));

				result = ValidationResult
						.error("Evaluation failed with exception: "
								+ e.getMessage());
			}
		} finally {
			// regardless how it went, we did execute
			partialResults.setResult(constraint, result);
		}

		assert result != null;

		switch (result.getSeverity()) {
		case ValidationResult.INFO:
		case ValidationResult.WARNING:
		case ValidationResult.ERROR:
			// report
			diagnostics.add(SigmaDiagnostic.fromResult(eObject, constraint,
					source, code, result));

			// add the result to the maker resolution
			addToQuickFixes(eObject, result);
			break;
		case ValidationResult.CANCEL:
			// report
			diagnostics.add(SigmaDiagnostic.fromResult(eObject, constraint,
					source, code, result));
			break;
		}

		return result.isValidOrCanceled();
	}

	private static PartialValidationResults getParticalResults(
			Map<Object, Object> context, Integer key) {
		PartialValidationResults partialResults = (PartialValidationResults) context
				.get(key);
		if (partialResults == null) {
			partialResults = new PartialValidationResults();
			context.put(key, partialResults);
		}
		return partialResults;
	}

	public static void addToQuickFixes(EObject eObject, ValidationResult result) {
		ISigmaQuickFixManager manager = getResolutionManager();
		if (manager == null || result.getQuickFixes().isEmpty()) {
			return;
		}

		URI eObjectURI = getEObjectURI(eObject);
		manager.addAll(eObjectURI, result.getMessage(), result.getQuickFixes());
	}

	public static ISigmaQuickFixManager getResolutionManager() {
		try {
			return SigmaQuickFixManager.getInstance();
		} catch (NoClassDefFoundError e) {
			return null;
		}
	}

	public static void removeQuickFixes(EObject eObject) {
		ISigmaQuickFixManager manager = getResolutionManager();
		if (manager == null) {
			return;
		}

		URI eObjectURI = getEObjectURI(eObject);
		manager.removeAll(eObjectURI);
	}

	public static URI getEObjectURI(EObject eObject) {
		return EcoreUtil.getURI(eObject);
	}

}

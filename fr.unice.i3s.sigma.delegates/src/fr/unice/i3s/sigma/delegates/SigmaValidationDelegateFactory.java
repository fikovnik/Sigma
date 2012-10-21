package fr.unice.i3s.sigma.delegates;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EValidator.ValidationDelegate;

import fr.unice.i3s.sigma.core.ValidationResult;

public class SigmaValidationDelegateFactory implements ValidationDelegate {

	private final Map<String, SigmaValidationDelegate> delegates = new HashMap<String, SigmaValidationDelegate>();

	private final SigmaDelegateDomain domain = SigmaDelegateDomain
			.getDefaultInstance();

	public SigmaValidationDelegate getDelegate(EClassifier eClassifier,
			String constraint) {
		String delegateId = eClassifier.getInstanceClass().getCanonicalName()
				+ "#" + constraint;
		SigmaValidationDelegate delegate = null;

		synchronized (delegates) {
			delegate = delegates.get(delegateId);
			if (delegate == null) {
				delegate = createDelegate(eClassifier, constraint);
				delegates.put(delegateId, delegate);
			}
		}

		return delegate;
	}

	protected SigmaValidationDelegate createDelegate(EClassifier eClassifier,
			String constraint) {
		return new SigmaValidationDelegate(eClassifier, domain, constraint);
	}

	// following methods are used from the plain EObjectValidator

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		return doValidate(eClass, eObject, context, invariant.getName(),
				expression).isValidOrCanceled();
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraint, String expression) {
		return doValidate(eClass, eObject, context, constraint, expression)
				.isValidOrCanceled();
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraint, String expression) {
		return doValidate(eDataType, value, context, constraint, expression)
				.isValidOrCanceled();
	}

	/**
	 * This method is consequently used by the {@link SigmaEObjectValidator} so
	 * it has access to the full results.
	 */
	private ValidationResult doValidate(EClassifier eClassifier, Object object,
			Map<Object, Object> context, String constraint, String expression) {
		SigmaValidationDelegate delegate = getDelegate(eClassifier, constraint);
		return delegate.validate(eClassifier, object, constraint, expression);
	}

}

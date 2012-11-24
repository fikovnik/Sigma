package fr.unice.i3s.sigma.delegates;

import static fr.unice.i3s.sigma.core.Utils.fmt;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EValidator.ValidationDelegate;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

import fr.unice.i3s.sigma.core.ValidationResult;

public class SigmaValidationDelegateFactory extends
		AbstractSigmaDelegateFactory implements ValidationDelegate {

	private final Map<String, SigmaValidationDelegate> delegates = new HashMap<String, SigmaValidationDelegate>();

	@Override
	public SigmaDelegateDomain getDomain() {
		return SigmaDelegateDomain.getDefaultInstance();
	}

	protected SigmaValidationDelegate getDelegate(EClassifier eClassifier,
			String constraint) {
		String delegateId = eClassifier.getInstanceClass().getCanonicalName()
				+ "#" + constraint;
		SigmaValidationDelegate delegate = null;

		synchronized (delegates) {
			delegate = delegates.get(delegateId);
			if (delegate == null) {
				if (hasBeenDelegated(eClassifier, constraint)) {
					delegate = doCreateValidationDelegate(eClassifier,
							constraint);
				} else {
					throw new SigmaDelegateNotFoundException(
							fmt("No Sigma delegate reistered for constraint `%s` in `%s`",
									constraint, eClassifier.getName()));
				}
				delegates.put(delegateId, delegate);
			}
		}

		return delegate;
	}

	protected SigmaValidationDelegate doCreateValidationDelegate(
			EClassifier target, String constraint) {
		return new SigmaValidationDelegate(target, getDomain(), constraint);
	}

	protected boolean hasBeenDelegated(EClassifier target, String constraint) {
		return EcoreUtil
				.getAnnotation(target, getDomain().getURI(), constraint) != null;
	}

	// following methods are used from the plain EObjectValidator

	/**
	 * This method is consequently used by the {@link SigmaEObjectValidator} so
	 * it has access to the full results.
	 */
	private ValidationResult doValidate(EClassifier eClassifier, Object object,
			Map<Object, Object> context, String constraint, String expression) {

		try {
			SigmaValidationDelegate delegate = getDelegate(eClassifier,
					constraint);
			return delegate.validate(eClassifier, object, constraint,
					expression);
		} catch (SigmaDelegateNotFoundException e) {
			// TODO log
			e.printStackTrace();

			String message = NLS.bind(
					Messages.Sigma_NoSigmaRegisteredValidationDelegate,
					new Object[] { constraint,
							getLabel(eClassifier, object, context) });

			return ValidationResult.error(message);
		}
	}

	private static String getLabel(EClassifier eClassifier, Object value,
			Map<Object, Object> context) {
		if (value instanceof EObject) {
			return EObjectValidator.getObjectLabel(eClassifier, context);
		} else {
			return EObjectValidator.getValueLabel((EDataType) eClassifier,
					value, context);
		}
	}

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

}

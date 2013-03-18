package fr.unice.i3s.sigma.java.delegates;

import static fr.unice.i3s.sigma.core.Utils.fmt;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EValidator.ValidationDelegate;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

import fr.unice.i3s.sigma.core.ValidationResult;

public class JSigmaValidationDelegateFactory extends
		AbstractSigmaDelegateFactory implements ValidationDelegate {

	private final Map<String, JSigmaValidationDelegate> delegates = new HashMap<String, JSigmaValidationDelegate>();

	@Override
	public JSigmaDelegateDomain getDomain() {
		return JSigmaDelegateDomain.getDefaultInstance();
	}

	/**
	 * 
	 * @param eClassifier
	 * @param constraint
	 * @return
	 * @throws SigmaDelegateNotFoundException
	 *             in case no such a delegate exists. This means that it has not
	 *             been correctly specified in the model (missing the Sigma
	 *             delegate annotation).
	 */
	protected JSigmaValidationDelegate getDelegate(EClass clazz,
			String constraint) {
		String delegateId = clazz.getInstanceClass().getCanonicalName() + "#"
				+ constraint;
		JSigmaValidationDelegate delegate = null;

		synchronized (delegates) {
			delegate = delegates.get(delegateId);
			if (delegate == null) {
				// not in cache
				delegate = createValidationDelegate(clazz, constraint);
				if (delegate == null) {
					// does not exist
					throw new SigmaDelegateNotFoundException(
							fmt("No Sigma delegate registered for constraint `%s` in `%s`",
									constraint, clazz.getName()));
				}
				delegates.put(delegateId, delegate);
			}
		}

		return delegate;
	}

	public JSigmaValidationDelegate createValidationDelegate(EClass target,
			String constraint) {
		JSigmaValidationDelegate delegate = null;

		if (hasBeenDelegated(target, constraint)) {
			delegate = doCreateValidationDelegate(target, constraint);
		}

		return delegate;
	}

	protected JSigmaValidationDelegate doCreateValidationDelegate(EClass target,
			String constraint) {
		return new JSigmaValidationDelegate(target, getDomain(), constraint);
	}

	protected boolean hasBeenDelegated(EClass target, String constraint) {
		return EcoreUtil
				.getAnnotation(target, getDomain().getURI(), constraint) != null;
	}

	// following methods are used from the plain EObjectValidator

	/**
	 * This method is consequently used by the regular {@link EObjectValidator}
	 * so it has access to the full results.
	 */
	private ValidationResult doValidate(EClass clazz, EObject object,
			Map<Object, Object> context, String constraint) {

		try {
			ISigmaValidationDelegate delegate = getDelegate(clazz, constraint);
			Object status = delegate.validate(object);

			return getDomain()
					.toSigmaValidationResult(status, delegate, object);
		} catch (SigmaDelegateNotFoundException e) {
			// TODO log
			e.printStackTrace();

			String message = NLS.bind(
					Messages.Sigma_NoSigmaRegisteredValidationDelegate,
					new Object[] { constraint,
							EObjectValidator.getObjectLabel(clazz, context) });

			return ValidationResult.error(message);
		}
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, EOperation invariant, String expression) {
		return doValidate(eClass, eObject, context, invariant.getName())
				.isValidOrCanceled();
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			Map<Object, Object> context, String constraint, String expression) {
		return doValidate(eClass, eObject, context, constraint)
				.isValidOrCanceled();
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			Map<Object, Object> context, String constraint, String expression) {
		// TODO: better exeception
		throw new RuntimeException();
	}
}

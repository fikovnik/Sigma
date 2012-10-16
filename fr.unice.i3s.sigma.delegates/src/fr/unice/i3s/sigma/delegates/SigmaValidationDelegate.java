package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EClassifier;

import fr.unice.i3s.sigma.core.Utils;
import fr.unice.i3s.sigma.core.ValidationResult;

public class SigmaValidationDelegate extends AbstractSigmaDelegate<EClassifier> {

	public SigmaValidationDelegate(EClassifier target,
			SigmaDelegateDomain domain, String constraint) {
		super(target, domain, constraint);
	}

	public ValidationResult validate(EClassifier eClassifier, Object object,
			String constraint, String expression) {
		Method delegate = getDelegateChecked(object);

		try {
			Object status = delegate.invoke(null, object);

			if (status instanceof ValidationResult) {
				return (ValidationResult) status;
			} else {
				return domain.toSigmaValidationResult(status, delegate,
						constraint, object);
			}
		} catch (IllegalArgumentException e) {
			throw domain.handleIllegalArgumentException(delegate, object, e);
		} catch (IllegalAccessException e) {
			throw domain.handleIllegalAccessException(delegate, object, e);
		} catch (InvocationTargetException e) {
			throw domain.handleInvocationTargetException(delegate, object, e);
		}
	}

	public String getConstraint() {
		return annotationDetailKey;
	}

	@Override
	protected String getDelegateMethodName() {
		return "validate" + Utils.capitalize(annotationDetailKey);
	}

	@Override
	protected boolean checkDelegateMethod(Method input) {
		// must have compatible return type
		if (!(input.getReturnType().isAssignableFrom(ValidationResult.class)
				|| !input.getReturnType().isAssignableFrom(boolean.class) || !input
				.getReturnType().isAssignableFrom(Boolean.class))) {
			return false;
		}

		Class<?>[] delegateParams = input.getParameterTypes();

		// must have first argument of type of itself
		if (!(delegateParams.length == 1 && target.getInstanceClass()
				.isAssignableFrom(delegateParams[0]))) {
			return false;
		}

		return true;
	}

	@Override
	protected String getExpectedMethodSignature() {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(ValidationResult.class.getCanonicalName());
		sb.append(" ");
		sb.append(getDelegateMethodName());
		sb.append("(");

		// add self
		sb.append(domain.classifierTypeName(target));
		sb.append(" self");

		sb.append(");");

		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(getClass().getName());
		sb.append(" for ");
		sb.append(annotationDetailKey);
		sb.append(" on ");
		sb.append(target);
		sb.append(" [" + getExpectedMethodSignature() + "]");

		return sb.toString();
	}
}

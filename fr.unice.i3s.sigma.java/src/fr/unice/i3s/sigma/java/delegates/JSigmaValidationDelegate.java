package fr.unice.i3s.sigma.java.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.unice.i3s.sigma.core.Utils;
import fr.unice.i3s.sigma.core.ValidationResult;
import fr.unice.i3s.sigma.core.annotations.Satisfies;

public class JSigmaValidationDelegate extends AbstractSigmaDelegate<EClass>
		implements ISigmaValidationDelegate {

	private final String constraint;

	public JSigmaValidationDelegate(EClass target, JSigmaDelegateDomain domain,
			String constraint) {
		super(target, domain);
		this.constraint = constraint;
	}

	@Override
	public Object validate(EObject object) {
		Method delegate = getDelegateMethodChecked();

		Object status = null;
		try {
			status = delegate.invoke(null, object);
		} catch (IllegalArgumentException e) {
			throw domain.handleIllegalArgumentException(delegate, object, e);
		} catch (IllegalAccessException e) {
			throw domain.handleIllegalAccessException(delegate, object, e);
		} catch (InvocationTargetException e) {
			throw domain.handleInvocationTargetException(delegate, object, e);
		}

		return status;
	}

	protected Method getDelegateMethodChecked() {
		Method delegate = null;

		try {
			delegate = getDelegate();
		} catch (SigmaDelegateNotFoundException e) {
			handleDelegateNotFoundException(e);
		}

		return delegate;
	}

	@Override
	public String getConstraint() {
		return constraint;
	}

	@Override
	public List<String> getDependencies() {
		Method delegate = getDelegateMethodChecked();

		Satisfies satisfies = delegate.getAnnotation(Satisfies.class);
		if (satisfies == null) {
			return Collections.emptyList();
		}

		return Arrays.asList(satisfies.value());
	}

	@Override
	public String getName() {
		return "delegate for constraint " + constraint + " at "
				+ target.getName();
	}

	@Override
	protected String getDelegateOverride() {
		return EcoreUtil.getAnnotation(target, domain.getURI(), constraint);
	}

	@Override
	public String getMethodSignature() {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(ValidationResult.class.getCanonicalName());
		sb.append(" ");
		sb.append(getExpectedMethodName());
		sb.append("(");

		// add self
		sb.append(domain.classifierTypeName(target));
		sb.append(" self");

		sb.append(");");

		return sb.toString();
	}

	@Override
	public String getExpectedMethodName() {
		return "validate" + Utils.capitalize(constraint);
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
	protected EClassifier getContainingEClass() {
		return target;
	}

	@Override
	public Class<?> getDelegateReturnType() {
		Method delegate = getDelegateMethodChecked();
		return delegate.getReturnType();
	}

	@Override
	public JSigmaDelegateDomain getDomain() {
		return domain;
	}

	@Override
	public EClass getEClass() {
		return target;
	}
}

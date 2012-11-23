package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import fr.unice.i3s.sigma.core.ValidationResult;
import fr.unice.i3s.sigma.core.annotations.Satisfies;

public class SigmaValidationDelegate extends AbstractSigmaDelegate<EClassifier> {

	private final String constraint;

	public SigmaValidationDelegate(Method delegate, EClassifier target,
			SigmaDelegateDomain domain, String constraint) {
		super(delegate, target, domain);
		this.constraint = constraint;
	}

	public ValidationResult validate(EClassifier eClassifier, Object object,
			String constraint, String expression) {

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
		return constraint;
	}

	public List<String> getDependencies(Object object) {
		Satisfies satisfies = delegate.getAnnotation(Satisfies.class);
		if (satisfies == null) {
			return Collections.emptyList();
		}

		return Arrays.asList(satisfies.value());
	}
}

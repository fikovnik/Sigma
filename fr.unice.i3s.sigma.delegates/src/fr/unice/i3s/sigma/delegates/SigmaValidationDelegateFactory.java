package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.Method;
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

import fr.unice.i3s.sigma.core.Utils;
import fr.unice.i3s.sigma.core.ValidationResult;

public class SigmaValidationDelegateFactory extends
		AbstractSigmaDelegateFactory implements ValidationDelegate {

	private final class ValidationDelegateInfo implements ISigmaDelegateInfo {
		private final EClassifier target;
		private final String constraint;

		private ValidationDelegateInfo(EClassifier target, String constraint) {
			this.target = target;
			this.constraint = constraint;
		}

		@Override
		public String getExpectedMethodSignature() {
			return SigmaValidationDelegateFactory.this
					.getExpectedMethodSignature(target, constraint);
		}

		@Override
		public String getExpectedMethodName() {
			return SigmaValidationDelegateFactory.this
					.getExpectedMethodName(constraint);
		}

		@Override
		public String getName() {
			return constraint;
		}

		@Override
		public EClassifier getContainingEClass() {
			return target;
		}

		@Override
		public String getDelegateOverride() {
			return EcoreUtil.getAnnotation(target, getDomain().getURI(),
					constraint);
		}

		@Override
		public boolean checkDelegateMethod(Method input) {
			return SigmaValidationDelegateFactory.this.checkDelegateMethod(
					target, input);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((constraint == null) ? 0 : constraint.hashCode());
			result = prime * result
					+ ((target == null) ? 0 : target.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof ValidationDelegateInfo)) {
				return false;
			}
			ValidationDelegateInfo other = (ValidationDelegateInfo) obj;
			if (constraint == null) {
				if (other.constraint != null) {
					return false;
				}
			} else if (!constraint.equals(other.constraint)) {
				return false;
			}
			if (target == null) {
				if (other.target != null) {
					return false;
				}
			} else if (!target.equals(other.target)) {
				return false;
			}
			return true;
		}

	}

	private final Map<String, SigmaValidationDelegate> delegates = new HashMap<String, SigmaValidationDelegate>();

	public SigmaValidationDelegateFactory() {
		this(SigmaDelegateDomain.getDefaultInstance());
	}

	public SigmaValidationDelegateFactory(SigmaDelegateDomain domain) {
		super(domain);
	}

	protected SigmaValidationDelegate getDelegate(EClassifier eClassifier,
			String constraint) throws SigmaDelegateNotFoundException {
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

	protected SigmaValidationDelegate createDelegate(EClassifier target,
			String constraint) throws SigmaDelegateNotFoundException {
		ISigmaDelegateInfo info = createDelegateInfo(target, constraint);

		Method method = getDelegateChecked(info);
		return new SigmaValidationDelegate(method, target, getDomain(),
				constraint);
	}

	private ISigmaDelegateInfo createDelegateInfo(EClassifier target,
			String constraint) {
		return new ValidationDelegateInfo(target, constraint);
	}

	public boolean checkDelegateMethod(EClassifier target, Method input) {
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

	public String getExpectedMethodName(String constraint) {
		return "validate" + Utils.capitalize(constraint);
	}

	public String getExpectedMethodSignature(EClassifier target,
			String constraint) {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(ValidationResult.class.getCanonicalName());
		sb.append(" ");
		sb.append(getExpectedMethodName(constraint));
		sb.append("(");

		// add self
		sb.append(getDomain().classifierTypeName(target));
		sb.append(" self");

		sb.append(");");

		return sb.toString();
	}

	// following methods are used from the plain EObjectValidator

	/**
	 * This method is consequently used by the {@link SigmaEObjectValidator} so
	 * it has access to the full results.
	 */
	private ValidationResult doValidate(EClassifier eClassifier, Object object,
			Map<Object, Object> context, String constraint, String expression) {
		SigmaValidationDelegate delegate;
		try {
			delegate = getDelegate(eClassifier, constraint);
			return delegate.validate(eClassifier, object, constraint,
					expression);
		} catch (SigmaDelegateNotFoundException e) {
			// TODO log
			e.printStackTrace();

			String message = NLS
					.bind(Messages.Sigma_NoValidationDelegate,
							new Object[] {
									getLabel(eClassifier, object, context),
									getExpectedMethodSignature(eClassifier,
											constraint), expression });

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

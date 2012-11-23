package fr.unice.i3s.sigma.delegates;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Iterables.find;
import static fr.unice.i3s.sigma.delegates.SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.core.Assert;

public abstract class AbstractSigmaDelegateFactory {

	public interface ISigmaDelegateInfo {
		public String getExpectedMethodSignature();

		public String getExpectedMethodName();

		public String getName();

		public EClassifier getContainingEClass();

		public String getDelegateOverride();

		public boolean checkDelegateMethod(Method input);
	}

	public static final class DelegateMethod {
		public final String className;
		public final String methodName;

		public DelegateMethod(String className, String methodName) {
			this.className = className;
			this.methodName = methodName;
		}
	}

	/**
	 * Maps an {@code EClass} to a {@code Method} delegate.
	 */
	private final Map<ISigmaDelegateInfo, Method> delegates = new HashMap<ISigmaDelegateInfo, Method>();

	private final SigmaDelegateDomain domain;

	public AbstractSigmaDelegateFactory(SigmaDelegateDomain domain) {
		this.domain = domain;
	}

	public SigmaDelegateDomain getDomain() {
		return domain;
	}

	protected synchronized Method getDelegateChecked(ISigmaDelegateInfo target)
			throws SigmaDelegateNotFoundException {
		// consult the cache
		Method candidate = delegates.get(target);
		if (candidate != null) {
			return candidate;
		}

		candidate = lookupDelegateChecked(target);

		// put to the cache
		delegates.put(target, candidate);

		return candidate;
	}

	protected Method lookupDelegateChecked(ISigmaDelegateInfo target)
			throws SigmaDelegateNotFoundException {
		String override = target.getDelegateOverride();

		DelegateMethod candidate = null;
		if (!isNullOrEmpty(override)) {
			try {
				candidate = parseDelegateOverride(override,
						target.getContainingEClass());
			} catch (ParseException e) {
				throw new SigmaDelegateNotFoundException(
						"Invalid delegate specification of " + target.getName(),
						e);
			}

			Method method = lookupDelegateMethod(target, candidate);
			if (method == null) {
				throw new SigmaDelegateNotFoundException(
						"Unable to find a delegate method for "
								+ target.getName() + ". Found annotation: `"
								+ override
								+ "`, but could not find expected method: `"
								+ candidate.methodName + "` in the class: `"
								+ candidate.className + "`.");
			}
			return method;
		}

		candidate = getDelegateMethod(target);
		Method method = lookupDelegateMethod(target, candidate);
		if (method == null) {
			throw new SigmaDelegateNotFoundException(
					"Unable to find a delegate method for " + target.getName()
							+ ". Could not find expected method: `"
							+ target.getExpectedMethodSignature()
							+ "` in the class: `" + candidate.className + "`.");
		}
		return method;
	}

	protected DelegateMethod getDelegateMethod(ISigmaDelegateInfo target) {
		String className = getClassifierDelegateName(target
				.getContainingEClass());
		String methodName = target.getExpectedMethodName();

		return new DelegateMethod(className, methodName);
	}

	protected Method lookupDelegateMethod(final ISigmaDelegateInfo target,
			final DelegateMethod candidate) {
		Class<?> clazz = domain.loadDelegateClass(candidate.className);
		if (clazz == null) {
			return null;
		}

		List<Method> methods = Arrays.asList(clazz.getMethods());
		Method method = find(methods, new Predicate<Method>() {
			@Override
			public boolean apply(Method input) {
				// must have a correct name
				if (!input.getName().equals(candidate.methodName)) {
					return false;
				}
				// must be static
				if (!Modifier.isStatic(input.getModifiers())) {
					return false;
				}

				// must be public
				if (!Modifier.isPublic(input.getModifiers())) {
					return false;
				}

				return target.checkDelegateMethod(input);
			}
		}, null);

		return method;
	}

	public DelegateMethod parseDelegateOverride(String override,
			EClassifier classifier) throws ParseException {
		Assert.notNull(override, "Delegate string must not be null");

		override = override.trim();

		if (override.isEmpty()) {
			throw new ParseException("Delegate string must not be empty", 0);
		}

		String className = null;
		String methodName = null;

		int methodSep = override.lastIndexOf('.');
		if (methodSep == -1) {
			methodName = override;
			className = getClassifierDelegateName(classifier);
		} else {
			className = override.substring(0, methodSep);
			methodName = override.substring(methodSep + 1);
		}

		if (isNullOrEmpty(methodName)) {
			throw new ParseException(
					"Method name part of the delegate specification must not be empty",
					0);
		}

		if (isNullOrEmpty(className)) {
			throw new ParseException(
					"Class name part of the delegate specification must not be empty when including the dot operator",
					0);
		}

		return new DelegateMethod(className, methodName);
	}

	protected String getPackageDelegateName(EPackage pkg) {
		String delegateName = EcoreUtil.getAnnotation(pkg, domain.getURI(),
				DELEGATE_CONSTRAINT_KEY);
		if (delegateName != null) {
			return delegateName;
		}

		EPackage superPkg = pkg.getESuperPackage();
		if (superPkg != null) {
			delegateName = getPackageDelegateName(superPkg);
			if (delegateName != null) {
				delegateName += "." + pkg.getName();
			}
		}

		return delegateName;
	}

	public String getClassifierDelegateName(EClassifier classifier) {
		// try the classifier
		String delegateName = EcoreUtil.getAnnotation(classifier,
				domain.getURI(), DELEGATE_CONSTRAINT_KEY);

		if (delegateName != null) {
			return delegateName;
		}

		// try package hierarchy
		delegateName = getPackageDelegateName(classifier.getEPackage());
		if (delegateName != null) {
			delegateName += "." + getDefaultClassDelegateName(classifier);
		}

		return delegateName;
	}

	protected String getDefaultClassDelegateName(EClassifier classifier) {
		return classifier.getName() + "Delegate";
	}
}

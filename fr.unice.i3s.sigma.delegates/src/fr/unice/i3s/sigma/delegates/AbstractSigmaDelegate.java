package fr.unice.i3s.sigma.delegates;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Iterables.find;
import static fr.unice.i3s.sigma.core.Utils.fmt;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.core.Assert;

public abstract class AbstractSigmaDelegate<T extends ENamedElement> {

	protected final SigmaDelegateDomain domain;

	protected final T target;

	private String[] method;

	private Method delegate;

	public AbstractSigmaDelegate(T target, SigmaDelegateDomain domain) {
		this.target = Assert.notNull(target, "Target must not be null");

		this.domain = Assert
				.notNull(domain, "Delegate domain must not be null");
	}

	public abstract String getMethodSignature();

	public abstract String getExpectedMethodName();

	protected abstract boolean checkDelegateMethod(Method input);

	public String getName() {
		return "delegate for " + target.getName();
	}

	protected String getDelegateOverride() {
		return EcoreUtil.getAnnotation(target, domain.getURI(),
				domain.getDelegateConstraintKey());
	}

	public String getMethodName() {
		// consult cache
		if (method == null) {
			method = lookupMethod();
		}

		return method[1];
	}

	public String getMethodClassName() {
		// consult cache
		if (method == null) {
			method = lookupMethod();
		}

		return method[0];
	}

	public Method getDelegate() throws SigmaDelegateNotFoundException {
		// consult local cache
		if (delegate != null) {
			return delegate;
		}

		delegate = lookupDelegate();

		return delegate;
	}

	public T getTarget() {
		return target;
	}

	protected abstract EClassifier getContainingEClass();

	/**
	 * Looks up a delegate method.
	 * 
	 * @return a delegate method that represents a Sigma delegate.
	 * @throws SigmaDelegateNotFoundException
	 *             in case no such a method could be found
	 */
	protected Method lookupDelegate() throws SigmaDelegateNotFoundException {
		final String className = getMethodClassName();
		final String methodName = getMethodName();

		Class<?> clazz = domain.loadDelegateClass(className);
		if (clazz == null) {
			throw new SigmaDelegateNotFoundException(
					fmt("Unable to find a delegate method for %s. Could not find expected class: `%s`.",
							getName(), className));
		}

		List<Method> methods = Arrays.asList(clazz.getMethods());
		Method method = find(methods, new Predicate<Method>() {
			@Override
			public boolean apply(Method input) {
				// must have a correct name
				if (!input.getName().equals(methodName)) {
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

				return checkDelegateMethod(input);
			}
		}, null);

		if (method == null) {
			throw new SigmaDelegateNotFoundException(
					fmt("Unable to find a delegate method for %s. Could not find expected method: `%s` in the class: `%s`.",
							getName(), getMethodSignature(), className));
		}
		return method;
	}

	protected String[] lookupMethod() {
		String override = getDelegateOverride();

		if (!isNullOrEmpty(override)) {
			try {
				return parseDelegateOverride(override);
			} catch (ParseException e) {
				throw new RuntimeException("Invalid delegate specification of "
						+ getName(), e);
			}
		}

		String className = getClassifierDelegateName();
		String methodName = getExpectedMethodName();

		return new String[] { className, methodName };
	}

	protected String[] parseDelegateOverride(String override)
			throws ParseException {

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
			className = getClassifierDelegateName();
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

		return new String[] { className, methodName };
	}

	protected String getPackageDelegateName(EPackage pkg) {
		String delegateName = EcoreUtil.getAnnotation(pkg, domain.getURI(),
				SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY);
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

	protected String getClassifierDelegateName() {
		// try the classifier
		String delegateName = EcoreUtil.getAnnotation(getContainingEClass(),
				domain.getURI(), SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY);

		if (delegateName != null) {
			return delegateName;
		}

		// try package hierarchy
		delegateName = getPackageDelegateName(getContainingEClass()
				.getEPackage());
		if (delegateName != null) {
			delegateName += "." + getExpectedClassDelegateName();
		} else {
			delegateName = "";
			for (EPackage pkg = getContainingEClass().getEPackage(); pkg != null; pkg = pkg
					.getESuperPackage()) {
				delegateName = pkg.getName() + "." + delegateName;
			}
			delegateName += getExpectedClassDelegateName();
		}

		return delegateName;
	}

	protected String getExpectedClassDelegateName() {
		return getContainingEClass().getName() + "Delegate";
	}

	protected boolean exists() {
		try {
			getDelegate();
			return true;
		} catch (SigmaDelegateNotFoundException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return getName();
	}

	protected void handleDelegateNotFoundException(
			SigmaDelegateNotFoundException e)
			throws SigmaDelegateNotFoundException {
		throw e;
	}
}

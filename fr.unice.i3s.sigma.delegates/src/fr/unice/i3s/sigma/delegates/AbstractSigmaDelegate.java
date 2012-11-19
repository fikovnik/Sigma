package fr.unice.i3s.sigma.delegates;

import static com.google.common.base.Joiner.on;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Iterables.transform;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import static fr.unice.i3s.sigma.core.Utils.getAnnotationDetail;
import static fr.unice.i3s.sigma.delegates.SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY;

public abstract class AbstractSigmaDelegate<T extends ENamedElement> {

	/**
	 * Maps an {@code EClass} to a {@code Method} delegate.
	 */
	private final Map<EClass, Method> delegates = new HashMap<EClass, Method>();

	protected final SigmaDelegateDomain domain;
	protected final T target;
	protected final String annotationDetailKey;

	public AbstractSigmaDelegate(T target, SigmaDelegateDomain domain,
			String annotationDetailKey) {
		this.target = target;
		this.domain = domain;
		this.annotationDetailKey = annotationDetailKey;
	}

	protected synchronized Method getDelegateChecked(Object targetObject) {
		Method candidate = null;

		EObject targetEObject = null;
		EClass targetEClass = null;

		if (targetObject instanceof EObject) {
			targetEObject = (EObject) targetObject;
			targetEClass = targetEObject.eClass();
		} else {
			// targetObject is an instance of a regular java object
			// because it comes from EDataType
			targetEClass = (EClass) target.eContainer();
		}

		// 1. consult the cache
		candidate = delegates.get(targetEClass);
		if (candidate != null) {
			return candidate;
		}

		// 2. try to find the delegate

		// 2.1 try the feature annotation (structural
		// feature/operation/constraint)
		String delegateName = getAnnotationDetail(target, domain.getURI(),
				annotationDetailKey);
		if (!isNullOrEmpty(delegateName)) {
			int methodSep = delegateName.lastIndexOf('.');

			if (methodSep == -1) {
				throw new SigmaDelegateNotFoundException(
						"Unable to find a delegate method for "
								+ target.getName()
								+ ". Found annotation: `"
								+ delegateName
								+ "` is missing method name. In this case it has"
								+ " to be in a for of a <fully qualified class "
								+ "name>.<method name>");
			}

			String className = delegateName.substring(0, methodSep);
			String methodName = delegateName.substring(methodSep + 1);
			candidate = findDelegateMethod(className, methodName);

			if (candidate == null) {
				throw new SigmaDelegateNotFoundException(
						"Unable to find a delegate method for "
								+ target.getName() + ". Found annotation: `"
								+ delegateName
								+ "`, but could not find expected method: "
								+ getExpectedMethodSignature()
								+ " in the class: " + className);
			}
		}

		// 2.2 try the class / package annotation
		if (candidate == null) {
			Iterable<EClass> hierarchy = null;
			if (targetEObject != null && target.eContainer() != targetEClass) {
				hierarchy = getClassHierarchy(targetEClass);
			} else {
				hierarchy = ImmutableList.<EClass> of(targetEClass);
			}

			for (EClass e : hierarchy) {
				String className = getClassDelegateName(e);

				if (className != null) {
					candidate = findDelegateMethod(className,
							getDelegateMethodName());

					if (candidate != null) {
						break;
					} else {
						throw new SigmaDelegateNotFoundException(
								"Unable to find a delegate method for "
										+ target.getName()
										+ ". Found superclass "
										+ e.getName()
										+ " annotation: `"
										+ delegateName
										+ ", but could not find expected method: "
										+ getExpectedMethodSignature()
										+ " in the class: " + className);
					}
				}
			}

			if (candidate == null) {
				throw new SigmaDelegateNotFoundException(
						"Unable to find a delegate method for "
								+ target.getName()
								+ " expected: "
								+ getExpectedMethodSignature()
								+ ". Consulted following class hierarchy: "
								+ on(",").join(
										transform(hierarchy,
												new Function<EClass, String>() {
													@Override
													public String apply(
															EClass input) {
														return input.getName();
													}
												})));
			}
		}

		delegates.put(targetEClass, candidate);
		return candidate;

	}

	private String getClassDelegateName(EClass e) {
		// 1. try the class itself
		String delegateName = getAnnotationDetail(e, domain.getURI(),
				DELEGATE_CONSTRAINT_KEY);

		if (delegateName != null) {
			return delegateName;
		}

		// 2. try the package
		// TODO: support multiple packages
		delegateName = getAnnotationDetail(e.getEPackage(), domain.getURI(),
				DELEGATE_CONSTRAINT_KEY);

		if (delegateName != null) {
			delegateName = getClassDelegateNameBasedOnPackageDelegate(
					delegateName, e);
		}

		return delegateName;
	}

	private String getClassDelegateNameBasedOnPackageDelegate(
			String delegateName, EClass clazz) {
		return delegateName + "." + clazz.getName() + "Delegate";
	}

	private Collection<EClass> getClassHierarchy(EClass clazz) {
		LinkedHashSet<EClass> hierarchy = new LinkedHashSet<EClass>();
		hierarchy.add(clazz);

		for (EClass c : clazz.getESuperTypes()) {
			hierarchy.addAll(getClassHierarchy(c));
		}

		return hierarchy;
	}

	protected Method findDelegateMethod(String delegateClassName,
			final String methodName) {
		Class<?> clazz = domain.loadDelegateClass(delegateClassName);
		if (clazz == null) {
			return null;
		}

		List<Method> methods = Arrays.asList(clazz.getMethods());
		Method candidate = find(methods, new Predicate<Method>() {
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

		return candidate;
	}

	public T getTarget() {
		return target;
	}

	protected abstract String getDelegateMethodName();

	protected abstract boolean checkDelegateMethod(Method input);

	protected abstract String getExpectedMethodSignature();
}

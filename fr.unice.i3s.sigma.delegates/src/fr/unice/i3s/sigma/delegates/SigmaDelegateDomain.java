package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.reflect.TypeUtils;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EValidator;

import com.google.common.collect.ImmutableList;

import fr.unice.i3s.sigma.core.Utils;
import fr.unice.i3s.sigma.core.ValidationResult;

public class SigmaDelegateDomain {

	protected static final String DELEGATE_URI = "http://www.i3s.unice.fr/Sigma";

	public static final String DELEGATE_CONSTRAINT_KEY = "delegate"; //$NON-NLS-1$

	/**
	 * Registers globally Java version of the Sigma delegates for the
	 * {@link #DELEGATE_URI} URI. This includes:
	 * <ul>
	 * <li>Invocation delegate {@link SigmaInvocationDelegate}
	 * <li>Setting delegate {@link SettingDelegate}
	 * <li>Validation delegate {@link ValidationDelegate}
	 * </ul>
	 * 
	 * In order to fully leverage the extended return type of the Sigma
	 * validation delegate a {@link SigmaEObjectValidation} must be registered
	 * as the package validator. Normally, this is not the case and it has to be
	 * done explicitly by changing the generate {@code <PackageName>Validator}
	 * super class to be {@link SigmaEObjectValidator}.
	 */
	public static void installGlobally() {
		EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(
				DELEGATE_URI, new SigmaInvocationDelegateFactory());

		EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE
				.put(DELEGATE_URI, new SigmaSettingDelegateFactory());

		EValidator.ValidationDelegate.Registry.INSTANCE.put(DELEGATE_URI,
				new SigmaValidationDelegateFactory());

	}

	public static <E> EList<E> delegatingEList(final List<E> underlyingList) {
		return new DelegatingEList<E>() {
			private static final long serialVersionUID = -8004643740120935908L;

			@Override
			protected List<E> delegateList() {
				return underlyingList;
			}
		};
	}

	protected SigmaDelegateDomain() {

	}

	public String getURI() {
		return DELEGATE_URI;
	}

	protected String classifierName(EClassifier classifier) {
		String name = classifier.getName();
		if (name == null) {
			name = classifier.getInstanceTypeName();
		}
		return name;
	}

	protected String classifierTypeName(EClassifier classifier) {
		// FIXME: support generics
		return classifierName(classifier);
	}

	protected String elementTypeName(ETypedElement element) {
		String clazzName = element.getEType().getInstanceClass()
				.getCanonicalName();
		if (element.isMany()) {
			return Collection.class.getCanonicalName() + "<" + clazzName + ">";
		} else {
			return clazzName;
		}
	}

	protected boolean checkClassifierType(EClassifier eType, Type type) {
		// FIXME: this only work for simple cases without bounds and arrays
		return TypeUtils.isAssignable(type, eType.getInstanceClass());
		// if (type instanceof Class<?>) {
		// return eType.getInstanceClass().isAssignableFrom((Class<?>) type);
		// } else if (type instanceof ParameterizedType) {
		// return checkClassifierType(eType,
		// ((ParameterizedType) type).getRawType());
		// } else {
		// return false;
		// }
	}

	protected boolean checkElementType(ETypedElement eType, Type type) {
		if (eType.isMany()) {
			// FIXME: this only work for simple cases without bounds and arrays
			if (type instanceof ParameterizedType) {
				ParameterizedType ptype = (ParameterizedType) type;
				return getCollectionType().isAssignableFrom(
						(Class<?>) ptype.getRawType())
						&& checkClassifierType(eType.getEType(),
								ptype.getActualTypeArguments()[0]);
			} else {
				return false;
			}
		} else {
			// FIXME: Option<T> and others like that are not supported
			return checkClassifierType(eType.getEType(), type);
		}
	}

	protected Class<?> getCollectionType() {
		return Collection.class;
	}

	protected Object processResult(ETypedElement target, Object value) {

		// if the element is multi-reference / multi-attribute it has to be
		// converted to EList
		if (target.isMany() && !(value instanceof EList<?>)) {

			if (!(value instanceof List<?>) && value instanceof Collection<?>) {
				value = ImmutableList.copyOf((Collection<?>) value);
			}

			return delegatingEList((List<?>) value);
		} else {
			return value;
		}
	}

	protected Class<?> loadDelegateClass(String delegateClassName) {
		try {
			return Class.forName(delegateClassName);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public Object processArgument(ETypedElement element, Object value) {
		return value;
	}

	public SigmaDelegateException handleIllegalArgumentException(
			Method delegate, Object object, IllegalArgumentException e) {
		e.printStackTrace();

		// FIXME: if the problem is in implementation of the toString() method
		// this will keep failing
		return new SigmaDelegateException("Unable to invoke delegate method: '"
				+ delegate.toString() + "' on '" + object + "'", e);
	}

	public SigmaDelegateException handleIllegalAccessException(Method delegate,
			Object object, IllegalAccessException e) {
		e.printStackTrace();

		// FIXME: if the problem is in implementation of the toString() method
		// this will keep failing
		return new SigmaDelegateException("Unable to invoke delegate method: '"
				+ delegate.toString() + "' on '" + object + "'", e);
	}

	public SigmaDelegateException handleInvocationTargetException(
			Method delegate, Object object, InvocationTargetException e) {
		e.getTargetException().printStackTrace();

		// FIXME: if the problem is in implementation of the toString() method
		// this will keep failing
		return new SigmaDelegateException("Unable to invoke delegate method: '"
				+ delegate.toString() + "' on '" + object + "': "
				+ e.getTargetException(), e.getTargetException());
	}

	public ValidationResult toSigmaValidationResult(Object status,
			Method delegate, String constraint, Object object) {
		boolean result = false;
		String message = null;

		// the other types that are supported are
		if (status instanceof Boolean) {
			// booleans
			result = ((Boolean) status).booleanValue();
		} else if ((status instanceof String)
				|| String.class.isAssignableFrom(delegate.getReturnType())) {
			// string
			result = status == null ? true : false;
			message = (String) status;
		}

		if (message == null) {
			// FIXME: if the problem is in implementation of the toString()
			// method this will keep failing
			message = Utils.bind(
					Messages.Sigma_GenericConstraintViolatedNoMessage,
					constraint, object.toString());
		}

		if (result) {
			return ValidationResult.ok();
		} else {
			return ValidationResult.error(message);
		}
	}

	// FIXME: get rid of this with Guice!
	private static final SigmaDelegateDomain instance = new SigmaDelegateDomain();

	public static SigmaDelegateDomain getDefaultInstance() {
		return instance;
	}
}

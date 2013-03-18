package fr.unice.i3s.sigma.java.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.reflect.TypeUtils;
import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EValidator;
import com.google.common.collect.ImmutableList;

import fr.unice.i3s.sigma.core.Utils;
import fr.unice.i3s.sigma.core.ValidationResult;

public class JSigmaDelegateDomain extends SigmaDelegateDomain {

	public static void installGlobally() {
		EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(
				instance.getURI(), instance.getInvocationDelegateFactory());

		EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE
				.put(instance.getURI(), instance.getSettingDelegateFactory());

		EValidator.ValidationDelegate.Registry.INSTANCE.put(instance.getURI(),
				instance.getValidationDelegateFactory());

	}

	private static final JSigmaDelegateDomain instance = new JSigmaDelegateDomain();

	public static JSigmaDelegateDomain getDefaultInstance() {
		return instance;
	}

	private JSigmaValidationDelegateFactory validationFactory;
	private JSigmaInvocationDelegateFactory invocationFactory;
	private JSigmaSettingDelegateFactory settingFactory;

	public String getURI() {
		return super.getURI + "/Java";
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
		String clazzName = element.getEType().getName();
		if (element.isMany()) {
			return Collection.class.getCanonicalName() + "<" + clazzName + ">";
		} else {
			return clazzName;
		}
	}

	protected boolean checkClassifierType(EClassifier eType, Type type) {
		// FIXME: this only work for simple cases without bounds and arrays
		return TypeUtils.isAssignable(type, eType.getInstanceClass());
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
			ISigmaValidationDelegate delegate, EObject eObject) {
		boolean result = false;
		String message = null;

		if (status instanceof ValidationResult) {
			return (ValidationResult) status;
		} else if (status instanceof Boolean) {
			// booleans
			result = ((Boolean) status).booleanValue();
		} else if ((status instanceof String)
				|| String.class.isAssignableFrom(delegate
						.getDelegateReturnType())) {
			// string
			result = status == null ? true : false;
			message = (String) status;
		}

		if (!result && message == null) {
			// FIXME: if the problem is in implementation of the toString()
			// method this will keep failing
			message = Utils.bind(
					Messages.Sigma_GenericConstraintViolatedNoMessage,
					delegate.getConstraint(), eObject.toString());
		}

		if (result) {
			return ValidationResult.ok();
		} else {
			return ValidationResult.error(message);
		}
	}

	public String getDelegateConstraintKey() {
		return DELEGATE_CONSTRAINT_KEY;
	}

	public JSigmaInvocationDelegateFactory getInvocationDelegateFactory() {
		if (invocationFactory == null) {
			invocationFactory = new JSigmaInvocationDelegateFactory();
		}
		return invocationFactory;
	}

	public JSigmaSettingDelegateFactory getSettingDelegateFactory() {
		if (settingFactory == null) {
			settingFactory = new JSigmaSettingDelegateFactory();
		}

		return settingFactory;
	}

	public JSigmaValidationDelegateFactory getValidationDelegateFactory() {
		if (validationFactory == null) {
			validationFactory = new JSigmaValidationDelegateFactory();
		}

		return validationFactory;
	}

	public static <T> EList<T> asEList(Collection<T> input) {
		return delegatingEList(ImmutableList.<T> copyOf(input));
	}

	public static <T> EList<T> asEList(Iterable<T> input) {
		return delegatingEList(ImmutableList.<T> copyOf(input));
	}

	public static <T> EList<T> asEList(Iterator<T> input) {
		return delegatingEList(ImmutableList.<T> copyOf(input));
	}
}

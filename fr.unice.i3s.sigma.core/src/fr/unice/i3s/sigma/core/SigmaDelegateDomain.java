package fr.unice.i3s.sigma.core;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EValidator;

import com.google.common.collect.ImmutableList;

public class SigmaDelegateDomain {

	public static final String DELEGATE_URI = "http://www.i3s.unice.fr/Sigma";

	public static final String DELEGATE_CONSTRAINT_KEY = "delegate"; //$NON-NLS-1$

	public static final String INVOCATION_CONSTRAINT_KEY = "body"; //$NON-NLS-1$

	public static final String SETTER_CONSTRAINT_KEY = "derivation"; //$NON-NLS-1$

	public static void installGlobally() {
		EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(
				DELEGATE_URI, new SigmaInvocationDelegateFactory());

		EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE
				.put(DELEGATE_URI, new SigmaSettingDelegateFactory());

		EValidator.ValidationDelegate.Registry.INSTANCE.put(DELEGATE_URI,
				new SigmaValidationDelegateFactory());

	}

	public static void installSigmaObjectValidator(EPackage... pkgs) {
		if (pkgs != null) {
			for (EPackage pkg : pkgs) {
				EValidator.Registry.INSTANCE.put(pkg,
						new SigmaEObjectValidator());
			}
		}
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

	public SigmaDelegateException handleIllegalArgumentException(Method delegate, Object object,
			IllegalArgumentException e) {
		e.printStackTrace();
		return new SigmaDelegateException(
				"Unable to invoke delegate method: '"
						+ delegate.toString() + "' on '" + object + "'", e);
	}

	public SigmaDelegateException handleIllegalAccessException(Method delegate, Object object,
			IllegalAccessException e) {
		e.printStackTrace();
		return new SigmaDelegateException(
				"Unable to invoke delegate method: '"
						+ delegate.toString() + "' on '" + object + "'", e);
	}

	public SigmaDelegateException handleInvocationTargetException(Method delegate, Object object,
			InvocationTargetException e) {
		e.getTargetException().printStackTrace();
		return new SigmaDelegateException(
				"Unable to invoke delegate method: '"
						+ delegate.toString() + "' on '" + object + "': "
						+ e.getTargetException(),
				e.getTargetException());
	}

	public SigmaValidationResult toSigmaValidationResult(Object status, String constraint, Object object) {
		boolean s = false;
		
		if (status instanceof Boolean) {
			s = ((Boolean) status).booleanValue();
		}

		if (s) {
			return SigmaValidationResult.ok();
		} else {
			return SigmaValidationResult.error("The '" + constraint
					+ "' constraint is violated on'" + object.toString() + "'");
		}
	}

	private static final SigmaDelegateDomain instance = new SigmaDelegateDomain();
	
	public static SigmaDelegateDomain getDefaultInstance() {
		return instance;
	}
}

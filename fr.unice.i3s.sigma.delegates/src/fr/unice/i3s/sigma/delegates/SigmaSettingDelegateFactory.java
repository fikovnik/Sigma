package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.unice.i3s.sigma.core.Utils;

public class SigmaSettingDelegateFactory extends AbstractSigmaDelegateFactory
		implements Factory {

	private final class SettingDelegateInfo implements ISigmaDelegateInfo {
		private final EStructuralFeature target;

		private SettingDelegateInfo(EStructuralFeature target) {
			this.target = target;
		}

		@Override
		public String getExpectedMethodSignature() {
			return SigmaSettingDelegateFactory.this
					.getExpectedMethodSignature(target);
		}

		@Override
		public String getExpectedMethodName() {
			return SigmaSettingDelegateFactory.this
					.getExpectedMethodName(target);
		}

		@Override
		public String getName() {
			return target.getName();
		}

		@Override
		public EClassifier getContainingEClass() {
			return target.getEContainingClass();
		}

		@Override
		public String getDelegateOverride() {
			return EcoreUtil.getAnnotation(target, getDomain().getURI(),
					SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY);
		}

		@Override
		public boolean checkDelegateMethod(Method input) {
			return SigmaSettingDelegateFactory.this.checkDelegateMethod(target,
					input);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			if (!(obj instanceof SettingDelegateInfo)) {
				return false;
			}
			SettingDelegateInfo other = (SettingDelegateInfo) obj;
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

	public SigmaSettingDelegateFactory() {
		this(SigmaDelegateDomain.getDefaultInstance());
	}

	public SigmaSettingDelegateFactory(SigmaDelegateDomain domain) {
		super(domain);
	}

	@Override
	public SettingDelegate createSettingDelegate(EStructuralFeature target) {
		ISigmaDelegateInfo info = createDelegateInfo(target);
		SettingDelegate delegate = null;

		try {
			Method method = getDelegateChecked(info);
			delegate = new SigmaSettingDelegate(method, target, getDomain());
		} catch (SigmaDelegateNotFoundException e) {
			// FIXME: log
			e.printStackTrace();
		}

		return delegate;
	}

	protected ISigmaDelegateInfo createDelegateInfo(EStructuralFeature target) {
		return new SettingDelegateInfo(target);
	}

	public String getExpectedMethodName(EStructuralFeature target) {
		EClassifier retType = target.getEType();

		if (retType == EcorePackage.eINSTANCE.getEBoolean()
				|| retType == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return "is" + Utils.capitalize(target.getName());
		} else {
			return "get" + Utils.capitalize(target.getName());
		}
	}

	public String getExpectedMethodSignature(EStructuralFeature target) {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(getDomain().elementTypeName(target));
		sb.append(" ");
		sb.append(getExpectedMethodName(target));
		sb.append("(");

		// add self
		sb.append(getDomain().classifierTypeName(target.getEContainingClass()));
		sb.append(" self");

		sb.append(");");

		return sb.toString();
	}

	public boolean checkDelegateMethod(EStructuralFeature target, Method input) {
		// must have compatible return type
		if (!getDomain().checkElementType(target, input.getGenericReturnType())) {
			return false;
		}

		Class<?>[] delegateParams = input.getParameterTypes();

		// must have first argument of type of the setter container
		if (!(delegateParams.length == 1 && getDomain().checkClassifierType(
				target.getEContainingClass(), delegateParams[0]))) {
			return false;
		}

		return true;
	}

}

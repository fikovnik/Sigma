package fr.unice.i3s.sigma.delegates;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Iterables.isEmpty;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

import fr.unice.i3s.sigma.core.Utils;

public class SigmaInvocationDelegateFactory extends
		AbstractSigmaDelegateFactory implements Factory {

	private final class OperationDelegateInfo implements ISigmaDelegateInfo {
		private final EOperation target;

		private OperationDelegateInfo(EOperation target) {
			this.target = target;
		}

		@Override
		public String getExpectedMethodSignature() {
			return SigmaInvocationDelegateFactory.this
					.getExpectedMethodSignature(target);
		}

		@Override
		public String getExpectedMethodName() {
			return SigmaInvocationDelegateFactory.this
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
			return SigmaInvocationDelegateFactory.this.checkDelegateMethod(
					target, input);
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
			if (!(obj instanceof OperationDelegateInfo)) {
				return false;
			}
			OperationDelegateInfo other = (OperationDelegateInfo) obj;
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

	public SigmaInvocationDelegateFactory() {
		this(SigmaDelegateDomain.getDefaultInstance());
	}

	public SigmaInvocationDelegateFactory(SigmaDelegateDomain domain) {
		super(domain);
	}

	@Override
	public InvocationDelegate createInvocationDelegate(EOperation target) {
		ISigmaDelegateInfo info = createDelegateInfo(target);
		InvocationDelegate delegate = null;

		try {
			Method method = getDelegateChecked(info);
			delegate = new SigmaInvocationDelegate(method, target, getDomain());
		} catch (SigmaDelegateNotFoundException e) {
			// FIXME: log
			e.printStackTrace();
		}

		return delegate;
	}

	protected ISigmaDelegateInfo createDelegateInfo(EOperation target) {
		return new OperationDelegateInfo(target);
	}

	protected String getExpectedMethodSignature(EOperation target) {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(getDomain().elementTypeName(target));
		sb.append(" ");
		sb.append(getExpectedMethodName(target));
		sb.append("(");

		// add self
		sb.append(getDomain().classifierTypeName(target.getEContainingClass()));
		sb.append(" self");

		// add parameters
		Iterable<EParameter> params = target.getEParameters();
		if (!isEmpty(params)) {
			sb.append(", ");
		}

		Joiner.on(", ").appendTo(
				sb,
				transform(target.getEParameters(),
						new Function<EParameter, String>() {
							@Override
							public String apply(EParameter input) {
								return getDomain().elementTypeName(input) + " "
										+ input.getName();
							}
						}));

		sb.append(");");

		// TODO: EOperation exception

		return sb.toString();
	}

	protected boolean checkDelegateMethod(EOperation target, Method input) {
		// must have compatible return type
		if (!getDomain().checkElementType(target, input.getGenericReturnType())) {
			return false;
		}

		Type[] delegateParams = input.getGenericParameterTypes();

		// must have first argument of type of the operation container
		if (!(delegateParams.length >= 1 && getDomain().checkClassifierType(
				target.getEContainingClass(), delegateParams[0]))) {
			return false;
		}

		EList<EParameter> params = target.getEParameters();

		// must have the same number of arguments
		if (params.size() != delegateParams.length - 1) {
			return false;
		}

		// must have compatible types
		boolean compArgs = true;
		for (int i = 1; i < delegateParams.length; i++) {
			if (!getDomain().checkElementType(params.get(i - 1),
					delegateParams[i])) {
				compArgs = false;
				break;
			}
		}
		if (!compArgs) {
			return false;
		}

		// TODO: EOperation exception

		return true;
	}

	public String getExpectedMethodName(EOperation target) {
		return "invoke" + Utils.capitalize(target.getName());
	}
}

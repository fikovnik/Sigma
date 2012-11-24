package fr.unice.i3s.sigma.delegates;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Iterables.isEmpty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

import fr.unice.i3s.sigma.core.SigmaConstants;
import fr.unice.i3s.sigma.core.Utils;

public class SigmaInvocationDelegate extends AbstractSigmaDelegate<EOperation>
		implements EOperation.Internal.InvocationDelegate {

	public SigmaInvocationDelegate(EOperation target, SigmaDelegateDomain domain) {
		super(target, domain);
	}

	@Override
	public Object dynamicInvoke(InternalEObject targetObject, EList<?> arguments)
			throws InvocationTargetException {

		Method delegate = null;
		try {
			delegate = getDelegate();
		} catch (SigmaDelegateNotFoundException e) {
			handleDelegateNotFoundException(e);
		}

		try {
			Object[] args = new Object[1 + (arguments == null ? 0 : arguments
					.size())];
			args[0] = targetObject;
			for (int i = 0; i < args.length - 1; i++) {
				args[i + 1] = domain.processArgument(target.getEParameters()
						.get(i), arguments.get(i));
			}

			Object value = delegate.invoke(null, args);
			return domain.processResult(target, value);
		} catch (IllegalArgumentException e) {
			throw domain.handleIllegalArgumentException(delegate, targetObject,
					e);
		} catch (IllegalAccessException e) {
			throw domain
					.handleIllegalAccessException(delegate, targetObject, e);
		} catch (InvocationTargetException e) {
			throw domain.handleInvocationTargetException(delegate,
					targetObject, e);
		}
	}

	@Override
	public String getMethodSignature() {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(domain.elementTypeName(target));
		sb.append(" ");
		sb.append(getMethodName());
		sb.append("(");

		// add self
		sb.append(domain.classifierTypeName(target.getEContainingClass()));
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
								return domain.elementTypeName(input) + " "
										+ input.getName();
							}
						}));

		sb.append(");");

		// TODO: EOperation exception

		return sb.toString();
	}

	@Override
	public String getExpectedMethodName() {
		return SigmaConstants.EOPERATION_DELEGATE_METHOD_PREFIX
				+ Utils.capitalize(target.getName());
	}

	@Override
	protected boolean checkDelegateMethod(Method input) {
		// must have compatible return type
		if (!domain.checkElementType(target, input.getGenericReturnType())) {
			return false;
		}

		Type[] delegateParams = input.getGenericParameterTypes();

		// must have first argument of type of the operation container
		if (!(delegateParams.length >= 1 && domain.checkClassifierType(
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
			if (!domain.checkElementType(params.get(i - 1), delegateParams[i])) {
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

	@Override
	protected EClassifier getContainingEClass() {
		return target.getEContainingClass();
	}
}

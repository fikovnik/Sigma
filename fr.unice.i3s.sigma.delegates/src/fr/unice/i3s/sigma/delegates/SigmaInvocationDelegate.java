package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

public class SigmaInvocationDelegate extends AbstractSigmaDelegate<EOperation>
		implements EOperation.Internal.InvocationDelegate {

	public SigmaInvocationDelegate(Method method, EOperation target,
			SigmaDelegateDomain domain) {
		super(method, target, domain);
	}

	@Override
	public Object dynamicInvoke(InternalEObject targetObject, EList<?> arguments)
			throws InvocationTargetException {

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
}

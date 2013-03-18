package fr.unice.i3s.sigma.java.delegates;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory;

public class JSigmaInvocationDelegateFactory extends
		AbstractSigmaDelegateFactory implements Factory {

	@Override
	public JSigmaInvocationDelegate createInvocationDelegate(EOperation target) {
		JSigmaInvocationDelegate delegate = null;

		if (hasBeenDelegated(target)) {
			delegate = doCreateInvocationDelegate(target);
		}

		return delegate;
	}

	@Override
	public JSigmaDelegateDomain getDomain() {
		return JSigmaDelegateDomain.getDefaultInstance();
	}

	protected JSigmaInvocationDelegate doCreateInvocationDelegate(
			EOperation target) {
		return new JSigmaInvocationDelegate(target, getDomain());
	}

	protected boolean hasBeenDelegated(EOperation target) {
		return target.getEAnnotation(getDomain().getURI()) != null;
	}

}

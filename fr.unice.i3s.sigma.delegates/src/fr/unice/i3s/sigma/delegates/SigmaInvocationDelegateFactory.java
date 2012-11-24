package fr.unice.i3s.sigma.delegates;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory;

public class SigmaInvocationDelegateFactory extends
		AbstractSigmaDelegateFactory implements Factory {

	@Override
	public SigmaInvocationDelegate createInvocationDelegate(EOperation target) {
		SigmaInvocationDelegate delegate = null;

		if (hasBeenDelegated(target)) {
			delegate = doCreateInvocationDelegate(target);
		}

		return delegate;
	}

	@Override
	public SigmaDelegateDomain getDomain() {
		return SigmaDelegateDomain.getDefaultInstance();
	}

	protected SigmaInvocationDelegate doCreateInvocationDelegate(
			EOperation target) {
		return new SigmaInvocationDelegate(target, getDomain());
	}

	protected boolean hasBeenDelegated(EOperation target) {
		return target.getEAnnotation(getDomain().getURI()) != null;
	}

}

package fr.unice.i3s.sigma.core;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory;

public final class SigmaInvocationDelegateFactory implements Factory {

	private final SigmaDelegateDomain domain = SigmaDelegateDomain.getDefaultInstance();
	
	@Override
	public InvocationDelegate createInvocationDelegate(EOperation operation) {
		return new SigmaInvocationDelegate(operation, domain);
	}

}

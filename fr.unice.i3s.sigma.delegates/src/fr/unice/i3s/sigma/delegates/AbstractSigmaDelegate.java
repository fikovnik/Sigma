package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.Method;
import org.eclipse.emf.ecore.ENamedElement;

import fr.unice.i3s.sigma.core.Assert;

public abstract class AbstractSigmaDelegate<T extends ENamedElement> {

	protected final SigmaDelegateDomain domain;
	protected final T target;
	protected final Method delegate;

	public AbstractSigmaDelegate(Method delegate, T target,
			SigmaDelegateDomain domain) {

		this.delegate = Assert.notNull(delegate,
				"Delegate method must not be null");

		this.target = Assert
				.notNull(target, "Delegate target must not be null");

		this.domain = Assert
				.notNull(domain, "Delegate domain must not be null");
	}

}

package fr.unice.i3s.sigma.delegates;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public abstract class StaticValidationDelegate<T extends EObject> implements
		ISigmaValidationDelegate {

	private final SigmaDelegateDomain domain;
	private final EClass clazz;
	private final String constraint;

	public StaticValidationDelegate(SigmaDelegateDomain domain, EClass clazz,
			String constraint) {
		this.domain = domain;
		this.clazz = clazz;
		this.constraint = constraint;
	}

	@Override
	public Object validate(EObject object) {
		return doValidate((T) object);
	}

	public abstract Object doValidate(T object);

	@Override
	public String getConstraint() {
		return constraint;
	}

	@Override
	public EClass getEClass() {
		return clazz;
	}

	@Override
	public List<String> getDependencies() {
		return domain.getValidationDelegateFactory()
				.getDelegate(clazz, constraint).getDependencies();
	}

	@Override
	public Class<?> getDelegateReturnType() {
		return domain.getValidationDelegateFactory()
				.getDelegate(clazz, constraint).getDelegateReturnType();
	}

	@Override
	public SigmaDelegateDomain getDomain() {
		return domain;
	}

}

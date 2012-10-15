package fr.unice.i3s.sigma.delegates;

import org.eclipse.emf.ecore.EObject;

import fr.unice.i3s.sigma.core.ISigmaQuickFix;
import fr.unice.i3s.sigma.core.SigmaQuickFixExecutionException;

public abstract class AbstractSigmaQuickFix implements ISigmaQuickFix {

	private final Class<? extends EObject> clazz;
	private final String label;
	private final String description;

	public AbstractSigmaQuickFix(Class<? extends EObject> clazz, String label) {
		this(clazz, label, null);
	}

	public AbstractSigmaQuickFix(Class<? extends EObject> clazz, String label,
			String description) {
		this.clazz = clazz;
		this.label = label;
		this.description = description;
	}

	@Override
	public Class<? extends EObject> getContextClass() {
		return clazz;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean validate(EObject self)
			throws SigmaQuickFixExecutionException {
		return clazz.isAssignableFrom(self.getClass());
	}

	@Override
	public String toString() {
		return label;
	}

}

package fr.unice.i3s.sigma.delegates;

import org.eclipse.emf.ecore.EObject;

import fr.unice.i3s.sigma.core.ISigmaQuickFix;
import fr.unice.i3s.sigma.core.SigmaQuickFixExecutionException;

public class SigmaQuickFix<T extends EObject> implements ISigmaQuickFix {

	public interface IFix<T> {
		public void execute(T self) throws SigmaQuickFixExecutionException;
	}

	private final Class<T> clazz;
	private final String label;
	private final String description;
	private final IFix<T> fix;

	public SigmaQuickFix(Class<T> clazz, String label, IFix<T> fix) {
		this(clazz, label, null, fix);
	}

	public SigmaQuickFix(Class<T> clazz, String label, String description,
			IFix<T> fix) {
		this.clazz = clazz;
		this.label = label;
		this.description = description;
		this.fix = fix;
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
	public void execute(EObject self) throws SigmaQuickFixExecutionException {
		fix.execute(clazz.cast(self));
	}

	@Override
	public String toString() {
		return label;
	}

}

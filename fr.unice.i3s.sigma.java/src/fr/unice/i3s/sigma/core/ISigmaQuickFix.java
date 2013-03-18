package fr.unice.i3s.sigma.core;

import org.eclipse.emf.ecore.EObject;

public interface ISigmaQuickFix {

	public Class<? extends EObject> getContextClass();

	public String getLabel();

	/**
	 * Optional description of this quick fix.
	 * 
	 * @return description of this quick fix on {@code null} in case no
	 *         description has been given.
	 */
	public String getDescription();

	/**
	 * Part of the validation should be making sure that the actual instance
	 * {@code self} is of a valid type.
	 * 
	 * Important: This should be <b>side-effect</b> free. This means that the
	 * state of {@code self} nor of any other object should change.
	 * 
	 * @param self
	 * @return
	 */
	public boolean validate(EObject self)
			throws SigmaQuickFixExecutionException;

	public void execute(EObject self) throws SigmaQuickFixExecutionException;

}
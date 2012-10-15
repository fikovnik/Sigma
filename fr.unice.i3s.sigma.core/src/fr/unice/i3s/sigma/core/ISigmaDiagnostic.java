package fr.unice.i3s.sigma.core;

import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;

public interface ISigmaDiagnostic extends Diagnostic {
	public String getConstraint();

	public Collection<ISigmaQuickFix> getQuickFixes();
}
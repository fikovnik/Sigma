package fr.unice.i3s.sigma.delegates;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;

import fr.unice.i3s.sigma.core.ISigmaQuickFix;

public class SigmaValidator implements EValidator {

	private final SigmaDelegateDomain domain;

	public SigmaValidator(SigmaDelegateDomain domain) {
		this.domain = domain;
	}

	// here I need to find all the constraints myself
	// and the corresponding delegate

	// validate(TmPackage.Literals.TEST_CLASS, testClass, diagnostics,
	// context, "http://www.i3s.unice.fr/Sigma", "D",
	// TEST_CLASS__D__EEXPRESSION, Diagnostic.ERROR,
	// DIAGNOSTIC_SOURCE, 0);

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {

		System.out.println(eClass.getName());
		diagnostics.add(new SigmaDiagnostic(eObject, "Singleton", "here", 0,
				Diagnostic.ERROR, "Must be singleton", null, Collections
						.<ISigmaQuickFix> emptyList()));

		return false;
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}

}

package fr.unice.i3s.sigma.delegates;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;

public class SigmaValidator implements EValidator {

	private final SigmaDelegateDomain domain;

	public SigmaValidator(SigmaDelegateDomain domain) {
		this.domain = domain;
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {

		// if(diagnostics != null) {
		// // A complete validation is performed, so clear old fixes
		// EvlMarkerResolutionGenerator.INSTANCE.removeFixesFor(eObject);
		// }

		// ValidationDelegate delegate = getValidationDelegateRegistry(context)
		// .getValidationDelegate(validationDelegate);
		// if (delegate != null) {
		// try {
		// if (!delegate.validate(eClass, eObject, context, constraint,
		// expression)) {
		// if (diagnostics != null) {
		// reportConstraintDelegateViolation(eClass, eObject,
		// diagnostics, context, constraint, severity,
		// source, code);
		// }
		// return false;
		// }
		// } catch (Throwable throwable) {
		// if (diagnostics != null) {
		// reportConstraintDelegateException(eClass, eObject,
		// diagnostics, context, constraint, severity, source,
		// code, throwable);
		// }
		// }
		// } else {
		// if (diagnostics != null) {
		// reportConstraintDelegateNotFound(eClass, eObject, diagnostics,
		// context, constraint, severity, source, code,
		// validationDelegate);
		// }
		// }
		// return true;

		System.out.println(eClass.getName());

		return false;
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}

}

package fr.unice.i3s.sigma.delegates;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;

import com.google.common.collect.ImmutableList;

public class ValidatorChain implements EValidator {

	private final List<EValidator> validatorChain;

	public ValidatorChain(EValidator... chain) {
		this(Arrays.asList(chain));
	}

	public ValidatorChain(List<EValidator> chain) {
		this.validatorChain = ImmutableList.<EValidator> copyOf(chain);
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		for (EValidator validator : validatorChain) {
			if (!validator.validate(eObject, diagnostics, context)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (EValidator validator : validatorChain) {
			if (!validator.validate(eClass, eObject, diagnostics, context)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		for (EValidator validator : validatorChain) {
			if (!validator.validate(eDataType, value, diagnostics, context)) {
				return false;
			}
		}
		return true;
	}

}

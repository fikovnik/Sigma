package fr.unice.i3s.sigma.java.delegates;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface ISigmaValidationDelegate {

	public Object validate(EObject object);

	public String getConstraint();

	public List<String> getDependencies();

	public Class<?> getDelegateReturnType();

	public JSigmaDelegateDomain getDomain();

	public EClass getEClass();

}
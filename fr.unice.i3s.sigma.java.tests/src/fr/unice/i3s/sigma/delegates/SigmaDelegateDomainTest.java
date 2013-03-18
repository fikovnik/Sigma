package fr.unice.i3s.sigma.delegates;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import fr.unice.i3s.sigma.core.ValidationResult;
import fr.unice.i3s.sigma.java.delegates.ISigmaValidationDelegate;
import fr.unice.i3s.sigma.java.delegates.JSigmaDelegateDomain;

public class SigmaDelegateDomainTest {

	@Test
	public void testValidationResultToSigmaValidationResult() throws Exception {
		JSigmaDelegateDomain domain = JSigmaDelegateDomain.getDefaultInstance();

		ISigmaValidationDelegate delegate = mock(ISigmaValidationDelegate.class);
		EObject eObject = mock(EObject.class);

		ValidationResult vr = ValidationResult.ok();
		ValidationResult r = domain.toSigmaValidationResult(vr, delegate,
				eObject);

		assertEquals(vr, r);

		verifyZeroInteractions(delegate, eObject);
	}

	@Test
	public void testBooleanToSigmaValidationResult() throws Exception {

		JSigmaDelegateDomain domain = JSigmaDelegateDomain.getDefaultInstance();

		ISigmaValidationDelegate delegate = mock(ISigmaValidationDelegate.class);
		when(delegate.getConstraint()).thenReturn("MyConstraint");

		EObject eObject = mock(EObject.class);
		when(eObject.toString()).thenReturn("MyObject");

		ValidationResult r = domain.toSigmaValidationResult(true, delegate,
				eObject);

		assertEquals(ValidationResult.OK, r.getSeverity());
		assertEquals("", r.getMessage());

		r = domain.toSigmaValidationResult(false, delegate, eObject);
		assertEquals(ValidationResult.ERROR, r.getSeverity());
		assertEquals("The `MyConstraint` constraint is violated on `MyObject`",
				r.getMessage());

	}

	@Test
	public void testStringToSigmaValidationResult() throws Exception {

		JSigmaDelegateDomain domain = JSigmaDelegateDomain.getDefaultInstance();

		ISigmaValidationDelegate delegate = mock(ISigmaValidationDelegate.class);
		when(delegate.getDelegateReturnType()).thenReturn((Class) String.class);
		EObject eObject = mock(EObject.class);

		ValidationResult r = domain.toSigmaValidationResult(null, delegate,
				eObject);

		assertEquals(ValidationResult.OK, r.getSeverity());
		assertEquals("", r.getMessage());

		verify(delegate).getDelegateReturnType();
		verifyNoMoreInteractions(delegate);
		verifyZeroInteractions(eObject);

		r = domain.toSigmaValidationResult("Custom message", delegate, eObject);
		assertEquals(ValidationResult.ERROR, r.getSeverity());
		assertEquals("Custom message", r.getMessage());

		verify(delegate).getDelegateReturnType();
		verifyNoMoreInteractions(delegate);
		verifyZeroInteractions(eObject);
	}

}

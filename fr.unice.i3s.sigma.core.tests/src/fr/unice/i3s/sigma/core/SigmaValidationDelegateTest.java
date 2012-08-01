package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;

import java.util.List;

import library.Library;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.Test;

public final class SigmaValidationDelegateTest extends AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testDelegate() throws Exception {
		final Library library = load("model/Library.xmi");
		Diagnostic diagnostics =  Diagnostician.INSTANCE.validate(library);

		List<Diagnostic> problems = diagnostics.getChildren();
		System.out.println(problems);

		assertEquals(3, problems.size());
	}
	
}

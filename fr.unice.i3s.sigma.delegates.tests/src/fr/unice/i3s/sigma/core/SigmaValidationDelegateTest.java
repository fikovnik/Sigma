package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import tm.TestClass;
import tm.TmFactory;
import tm.TmPackage;

public final class SigmaValidationDelegateTest extends
		AbstractSigmaStandaloneDelegateTest {

	private final TmFactory tm = TmPackage.eINSTANCE.getTmFactory();

	@Test
	public void testNoConstraintViloation() {
		TestClass tc = tm.createTestClass();
		tc.setAttribute(8);

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(tc);
		System.out.println(diagnostics);
		assertEquals(Diagnostic.OK, diagnostics.getSeverity());

		List<Diagnostic> problems = diagnostics.getChildren();
		assertEquals(0, problems.size());
	}

	@Test
	public void testSimpleConstraintViloation() {
		TestClass tc = tm.createTestClass();
		tc.setAttribute(0);

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(tc);
		assertEquals(Diagnostic.ERROR, diagnostics.getSeverity());

		List<Diagnostic> problems = diagnostics.getChildren();
		assertEquals(1, problems.size());
		// check message
		assertEquals(
				"The 'NonZero' constraint is violated on '"
						+ EcoreUtil.getIdentification(tc) + "'", problems
						.get(0).getMessage());
		// check the data entry
		assertEquals(1, problems.get(0).getData().size());
		assertEquals(tc, problems.get(0).getData().get(0));
	}

}

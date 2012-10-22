package fr.unice.i3s.sigma.core;

import static fr.unice.i3s.sigma.core.Utils.bind;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.BeforeClass;
import org.junit.Test;

import testmodel.TestClass;
import testmodel.util.TmValidator;
import fr.unice.i3s.sigma.delegates.Messages;
import fr.unice.i3s.sigma.delegates.SigmaEObjectValidator;

public final class SigmaValidationDelegateTest extends
		AbstractSigmaStandaloneDelegateTest {

	@BeforeClass
	public static void checkSigmaValidator() {
		assertTrue(
				"Validator must be a "
						+ SigmaEObjectValidator.class.getSimpleName(),
				TmValidator.INSTANCE instanceof SigmaEObjectValidator);
	}

	@Test
	public void testNoConstraintViolation() {
		TestClass self = createTestClass("ABCDEF");

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(self);
		// System.out.println(diagnostics);
		assertEquals(Diagnostic.OK, diagnostics.getSeverity());

		List<Diagnostic> problems = diagnostics.getChildren();
		assertEquals(0, problems.size());
	}

	@Test
	public void testAConstraintViolated() {
		TestClass self = createTestClass("BCDEF");

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(self);
		// System.out.println(diagnostics);
		assertEquals(Diagnostic.ERROR, diagnostics.getSeverity());

		List<Diagnostic> problems = diagnostics.getChildren();
		assertEquals(1, problems.size());
		assertEquals(
				bind(Messages.Sigma_GenericConstraintViolatedNoMessage, "A",
						self), problems.get(0).getMessage());
		assertEquals(self, problems.get(0).getData().get(0));
	}

	/**
	 * Tests custom message used by having String return type
	 */
	@Test
	public void testEConstraintViolation() {
		TestClass self = createTestClass("ABCDF");

		Diagnostic diagnostics = Diagnostician.INSTANCE.validate(self);
		// System.out.println(diagnostics);
		assertEquals(Diagnostic.ERROR, diagnostics.getSeverity());

		List<Diagnostic> problems = diagnostics.getChildren();
		assertEquals(1, problems.size());
		assertEquals("E is missing", problems.get(0).getMessage());
		assertEquals(self, problems.get(0).getData().get(0));
	}

	// /**
	// * This test should check the behavior of a constraint that returns
	// String:
	// *
	// * <ol>
	// * <li>{@code null} - constraint holds
	// * <li>an instance of {@code String} - constraint is violated
	// * </ol>
	// */
	// @Test
	// public void testConstraintWithMessage() throws Exception {
	// TestClass tc = tm.createTestClass();
	//
	// // violate
	// tc.setAttribute(2);
	// Diagnostic diagnostics = Diagnostician.INSTANCE.validate(tc);
	// assertEquals(Diagnostic.ERROR, diagnostics.getSeverity());
	//
	// List<Diagnostic> problems = diagnostics.getChildren();
	// System.out.println(problems);
	// assertEquals(1, problems.size());
	// // check message
	// assertEquals("The 'WithMessage' constraint is violated on '"
	// + EcoreUtil.getIdentification(tc) + "'", problems.get(0)
	// .getMessage());
	//
	// // not violate
	// tc.setAttribute(8);
	// diagnostics = Diagnostician.INSTANCE.validate(tc);
	// assertEquals(Diagnostic.OK, diagnostics.getSeverity());
	// System.out.println(diagnostics);
	// }
	//
	// @Test
	// public void testSimpleConstraintViloation() {
	// TestClass tc = tm.createTestClass();
	// tc.setAttribute(0);
	//
	// Diagnostic diagnostics = Diagnostician.INSTANCE.validate(tc);
	// assertEquals(Diagnostic.ERROR, diagnostics.getSeverity());
	//
	// List<Diagnostic> problems = diagnostics.getChildren();
	// assertEquals(1, problems.size());
	// // check message
	// assertEquals(
	// "The 'NonZero' constraint is violated on '"
	// + EcoreUtil.getIdentification(tc) + "'", problems
	// .get(0).getMessage());
	// // check the data entry
	// assertEquals(1, problems.get(0).getData().size());
	// assertEquals(tc, problems.get(0).getData().get(0));
	// }

}

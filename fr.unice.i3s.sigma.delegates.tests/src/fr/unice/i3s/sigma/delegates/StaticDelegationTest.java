package fr.unice.i3s.sigma.delegates;

import static fr.unice.i3s.sigma.delegates.SampleEcoreBuilder.createEAnnotation;
import static fr.unice.i3s.sigma.delegates.SampleEcoreBuilder.hashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.Test;

public class StaticDelegationTest {

	public static class TestClassDelegate {
		public static String validateConstraint1(TestClass clazz) {
			return "not satisfied";
		}
	}

	public class TestClass extends EObjectImpl {

		public TestClass() {
			createEAnnotation(eClass(), EcorePackage.eNS_URI,
					hashMap("constraints", "constraint1"));

			createEAnnotation(
					eClass(),
					SigmaDelegateDomain.getDefaultInstance().getURI(),
					hashMap("delegate", TestClassDelegate.class.getName(),
							"constraint1", ""));
		}

		public boolean constraint1(DiagnosticChain diagnostics,
				Map<Object, Object> context) {

			return SigmaEObjectValidator.validate(
					this,
					diagnostics,
					context,
					new StaticValidationDelegate<TestClass>(SigmaDelegateDomain
							.getDefaultInstance(), eClass(), "constraint1") {
						@Override
						public Object doValidate(TestClass object) {
							return TestClassDelegate
									.validateConstraint1(object);
						}
					}, "A", 0);
		}

	}

	@Test
	public void testName() throws Exception {
		TestClass eObject = new TestClass();
		BasicDiagnostic diagnostics = Diagnostician.INSTANCE
				.createDefaultDiagnostic(eObject);
		Map<Object, Object> context = Diagnostician.INSTANCE
				.createDefaultContext();

		assertFalse(eObject.constraint1(diagnostics, context));

		Diagnostic problem = diagnostics.getChildren().get(0);

		assertEquals(Diagnostic.ERROR, problem.getSeverity());
		assertEquals("not satisfied", problem.getMessage());
		assertEquals(eObject, problem.getData().get(0));
	}

}

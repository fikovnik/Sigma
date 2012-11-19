package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.Test;

import testmodel.TestOverriding;

public class DelegateLookupTest extends AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testDefaultLookup() throws Exception {
		TestOverriding clazz = tmFactory.createTestOverriding();
		assertEquals("normalAttribute", clazz.getNormalAttribute());
		assertEquals("normalMethod", clazz.normalMethod());
	}

	@Test
	public void testOverridenLookup() throws Exception {
		TestOverriding clazz = tmFactory.createTestOverriding();
		assertEquals("attribute", clazz.getAttribute());
		assertEquals("method", clazz.method());
		assertEquals("attribute", clazz.getAttribute());
		assertEquals("method", clazz.method());
	}

	@Test
	public void testValidationLookup() throws Exception {
		TestOverriding clazz = tmFactory.createTestOverriding();

		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(clazz);
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
	}

}

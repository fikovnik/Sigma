package test;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScalaEcoreGeneratedExtensionsTest {

	@Test
	public void testGeneratedMethods() {
		SampleClass clazz = TestFactory.eINSTANCE.createSampleClass();
		clazz.setRequiredAttribute("value2");
		clazz.getManyAttribute().add("value3");
			
		assertEquals(clazz.getRequiredAttribute(), clazz.requiredAttribute());
		assertEquals(clazz.getRequiredAttribute(), clazz.requiredAttribute());
		
		clazz.setOptionalAttribute("value1");
		assertTrue(clazz.optionalAttribute().isDefined());
		assertEquals(clazz.getOptionalAttribute(), clazz.optionalAttribute().get());

		clazz.setOptionalAttribute(null);
		assertTrue(clazz.optionalAttribute().isEmpty());
	}
	
}

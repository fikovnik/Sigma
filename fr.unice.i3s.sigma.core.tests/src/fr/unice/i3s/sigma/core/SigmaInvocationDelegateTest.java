package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;
import library.Library;

import org.junit.Test;

public class SigmaInvocationDelegateTest extends AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testDelegation() {
		Library library = load("model/Library.xmi");
		
		assertEquals("b1", library.getBookByName("b1").getName());
		assertEquals("b2", library.getBookByName("b2").getName());
	}

}

package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;


import library.Library;

import org.junit.Test;

public class SigmaSettingDelegateTest extends AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testDelegation() {
		Library library = load("model/Library.xmi");
		assertEquals("My Library (lib)", library.getDescription());
	}

}

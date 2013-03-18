/*******************************************************************************
 * Copyright (c) 2012 Filip Krikava.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Filip Krikava - initial API and implementation
 ******************************************************************************/
package fr.unice.i3s.sigma.examples.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.unice.i3s.sigma.core.ISigmaQuickFix;
import fr.unice.i3s.sigma.examples.library.util.LibraryValidator;
import fr.unice.i3s.sigma.java.delegates.JSigmaDelegateDomain;
import fr.unice.i3s.sigma.java.delegates.SigmaDiagnostic;
import fr.unice.i3s.sigma.java.delegates.SigmaEObjectValidator;
import fr.unice.i3s.sigma.ui.ide.validation.ExecuteSigmaQuickFixCommand;

/**
 * <b>NOTE</b>: It seems that to be able to run this test standalone (i.e.
 * without Eclipse platform running) all plug-in's transitive dependencies have
 * to be actually declared explicitly in the dependency list. That is why there
 * is the dependency to {@code org.apache.commons.lang3}. It will run without
 * just fine in the Plug-in JUnit test configuration.
 * 
 * Since I'm not sure I asked in the <a
 * href="http://www.eclipse.org/forums/index
 * .php/m/986519/#msg_986519">forum</a>.
 * 
 */
public class LibraryTest {

	/**
	 * Proves that the delegates works.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelegation() throws Exception {

		Resource resource = loadLibrary("example-library.xmi");
		Library library = (Library) resource.getContents().get(0);

		Book book1 = library.getBookByName("Book1");
		assertNotNull(book1);
		assertEquals("Book1", book1.getName());
		assertEquals(library, book1.getLibrary());
		assertEquals(0, book1.getCopies());
		assertFalse(book1.isAvailable());

		Book book2 = library.getBookByName("Book2");
		assertNotNull(book2);
		assertEquals("Book2", book2.getName());
		assertEquals(library, book2.getLibrary());
		assertEquals(1, book2.getCopies());
		assertTrue(book2.isAvailable());

		assertNull(library.getBookByName("Book that does not exist"));

		Book book3 = library.getBookByName("Book3");
		assertNotNull(book3);
		assertEquals("Book3", book3.getName());
		assertEquals(library, book3.getLibrary());
		assertEquals(2, book3.getCopies());
		assertFalse(book3.isAvailable());
		assertEquals(2, book3.getLoans().size());
		assertEquals("Member1", book3.getLoans().get(0).getMember().getName());
		assertEquals("Member2", book3.getLoans().get(1).getMember().getName());

		Member member1 = library.getMembers().get(0);
		assertEquals("Member1", member1.getName());
		assertEquals(1, member1.getLoans().size());
		assertEquals(1, member1.getBooks().size());
		assertEquals("Book3", member1.getBooks().get(0).getName());

		Member member2 = library.getMembers().get(1);
		assertEquals("Member2", member2.getName());
		assertEquals(1, member2.getLoans().size());
		assertEquals(1, member2.getBooks().size());
		assertEquals("Book3", member2.getBooks().get(0).getName());
	}

	/**
	 * Proves that the validation delegation works.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testValidation() throws Exception {

		Resource resource = loadLibrary("example-library.xmi");
		Library library = (Library) resource.getContents().get(0);

		// run the diagnostics
		Diagnostic diag = Diagnostician.INSTANCE.validate(library);

		assertEquals(Diagnostic.ERROR, diag.getSeverity());
		assertEquals(1, diag.getChildren().size());

		Diagnostic error = diag.getChildren().get(0);
		// check custom message
		assertEquals("There has to be at lest one copy", error.getMessage());
		assertEquals(1, error.getData().size());

		Book book1 = library.getBookByName("Book1");
		assertEquals(book1, error.getData().get(0));

		// we have extended diagnostic information
		assertTrue(error instanceof SigmaDiagnostic);

		SigmaDiagnostic sdiag = (SigmaDiagnostic) error;
		// with quickfixes
		assertEquals(1, sdiag.getQuickFixes().size());
		ISigmaQuickFix fix = sdiag.getQuickFixes().iterator().next();
		assertEquals("Add a copy", fix.getLabel());

		// we can run it
		fix.execute(book1);

		// and check the results
		assertEquals(1, book1.getCopies());

		diag = Diagnostician.INSTANCE.validate(library);
		assertEquals(Diagnostic.OK, diag.getSeverity());
	}

	/**
	 * Demonstrates the undo functionality
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCommandStackExecution() throws Exception {

		Resource resource = loadLibrary("example-library.xmi");
		Library library = (Library) resource.getContents().get(0);

		Book book1 = library.getBookByName("Book1");

		Diagnostic diag = Diagnostician.INSTANCE.validate(library);
		Diagnostic error = diag.getChildren().get(0);
		SigmaDiagnostic sdiag = (SigmaDiagnostic) error;
		ISigmaQuickFix fix = sdiag.getQuickFixes().iterator().next();

		AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(
				new AdapterFactoryImpl(), new BasicCommandStack());

		assertEquals(0, book1.getCopies());
		assertFalse(resource.isModified());

		domain.getCommandStack().execute(
				new ExecuteSigmaQuickFixCommand(fix, book1));

		assertEquals(1, book1.getCopies());

		domain.getCommandStack().undo();

		assertEquals(0, book1.getCopies());
		assertFalse(resource.isModified());

	}

	@BeforeClass
	public static void init() {
		// make sure the validator is of type SigmaEObjectValidator
		// otherwise the custom messages won't work
		assertTrue(LibraryValidator.INSTANCE instanceof SigmaEObjectValidator);

		// load package
		LibraryPackage.eINSTANCE.eClass();

		// register Sigma delegate
		JSigmaDelegateDomain.installGlobally();

		// register XMI
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
	}

	private Resource loadLibrary(String fname) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createFileURI(fname), true);

		return r;
	}

}

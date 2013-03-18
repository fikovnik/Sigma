package fr.unice.i3s.sigma.core;

import org.junit.Test;

public final class SigmaValidatorTest {

	@Test
	public void testHowItWorks() throws Exception {
		// EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put(
		// SigmaDelegateDomain.DELEGATE_URI,
		// new SigmaInvocationDelegateFactory());
		//
		// EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE
		// .put(SigmaDelegateDomain.DELEGATE_URI,
		// new SigmaSettingDelegateFactory());
		//
		// EValidator.ValidationDelegate.Registry.INSTANCE.put(
		// SigmaDelegateDomain.DELEGATE_URI,
		// new SigmaValidationDelegateFactory());
		//
		// // SigmaValidator validator = new SigmaValidator(domain);
		// // EValidator.Registry.INSTANCE.put(LibraryPackage.eINSTANCE,
		// // validator);
		// // EValidator.Registry.INSTANCE.put
		// // (theLibraryPackage,
		// // new EValidator.Descriptor() {
		// // public EValidator getEValidator() {
		// // return LibraryValidator.INSTANCE;
		// // }
		// // });
		//
		// LibraryFactory factory = LibraryFactory.eINSTANCE;
		// Library library = factory.createLibrary();
		// library.setName("Library");
		//
		// Book book = factory.createBook();
		// book.setName("Book");
		// book.setCopies(0);
		// library.getBooks().add(book);
		//
		// Diagnostic diagnostics = Diagnostician.INSTANCE.validate(book);
		// System.out.println(diagnostics);
		//
		// ISigmaDiagnostic diag = (ISigmaDiagnostic) diagnostics.getChildren()
		// .get(0);
		// ISigmaQuickFix quickFix = diag.getQuickFixes().iterator().next();
		// assertTrue(quickFix.validate(book));
		// quickFix.execute(book);
		// assertTrue(book.getCopies() > 0);
	}
}

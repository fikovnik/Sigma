package fr.unice.i3s.sigma.examples.library.delegate;

import static com.google.common.collect.Collections2.filter;
import static fr.unice.i3s.sigma.delegates.SigmaDelegateDomain.asEList;

import org.eclipse.emf.common.util.EList;

import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.core.ValidationResult;
import fr.unice.i3s.sigma.delegates.SigmaQuickFix;
import fr.unice.i3s.sigma.delegates.SigmaQuickFix.IFix;
import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Loan;

public class BookDelegate {

	private BookDelegate() {
	}

	public static ValidationResult validateAtLeastOneCopy(final Book self) {
		if (self.getCopies() >= 1) {
			return ValidationResult.ok();
		}

		return ValidationResult.error("There has to be at lest one copy",
				new SigmaQuickFix<Book>(Book.class, "Add a copy",
						new IFix<Book>() {
							@Override
							public void execute(Book self) {
								self.setCopies(1);
							}
						}));
	}

	public static ValidationResult validateSufficientCopies(final Book self) {
		int loans = filter(self.getLibrary().getLoans(), new Predicate<Loan>() {
			@Override
			public boolean apply(Loan input) {
				return input.getBook().equals(self);
			}
		}).size();

		int copies = self.getCopies();

		if (loans > copies) {
			return ValidationResult.error("Too many loans of book: " + self
					+ " (copies: " + copies + ", loans: " + loans + ")");
		} else {
			return ValidationResult.ok();
		}
	}

	public static EList<Loan> getLoans(final Book self) {
		return asEList(filter(self.getLibrary().getLoans(), new Predicate<Loan>() {
			@Override
			public boolean apply(Loan input) {
				return input.getBook() == self;
			}
		}));
	}

	public static boolean invokeIsAvailable(Book self) {
		return self.getLoans().size() < self.getCopies();
	}

}
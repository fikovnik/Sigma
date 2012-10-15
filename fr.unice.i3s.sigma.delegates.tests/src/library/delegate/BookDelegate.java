package library.delegate;

import static com.google.common.collect.Collections2.filter;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import library.Book;
import library.Library;
import library.Loan;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import fr.unice.i3s.sigma.core.ISigmaQuickFix;
import fr.unice.i3s.sigma.core.SigmaQuickFixExecutionException;
import fr.unice.i3s.sigma.core.ValidationResult;
import fr.unice.i3s.sigma.delegates.AbstractSigmaQuickFix;

public class BookDelegate {

	private BookDelegate() {
	}

	public static ValidationResult validateAtLeastOneCopy(final Book self) {
		if (self.getCopies() >= 1) {
			return ValidationResult.ok();
		}

		return new ValidationResult(ValidationResult.ERROR,
				"There has to be at lest one copy",
				ImmutableList.<ISigmaQuickFix> of(new AbstractSigmaQuickFix(
						Book.class, "Add a copy") {

					@Override
					public void execute(EObject self)
							throws SigmaQuickFixExecutionException {
						Book book = (Book) self;
						book.setCopies(1);
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

	public static Library getLibrary(Book self) {
		return Library.class.cast(self.eContainer());
	}

	public static Collection<Loan> getLoans(final Book self) {
		return filter(self.getLibrary().getLoans(), new Predicate<Loan>() {
			@Override
			public boolean apply(Loan input) {
				return input.getBook() == self;
			}
		});
	}

	public static boolean invokeIsAvailable(Book self) {
		return self.getLoans().size() < self.getCopies();
	}

}
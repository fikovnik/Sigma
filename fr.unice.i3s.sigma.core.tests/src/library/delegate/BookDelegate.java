package library.delegate;

import static com.google.common.collect.Collections2.filter;

import java.util.Collection;

import library.Book;
import library.Library;
import library.Loan;

import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.core.SigmaValidationResult;

public class BookDelegate {

	private BookDelegate() {
	}

	public static SigmaValidationResult validateSufficientCopies(final Book self) {
		int loans = filter(self.getLibrary().getLoans(), new Predicate<Loan>() {
			@Override
			public boolean apply(Loan input) {
				return input.getBook().equals(self);
			}
		}).size();
		
		int copies = self.getCopies().intValue();
		
		if (loans > copies) {
			return SigmaValidationResult.error("Too many loans of book: "+self+" (copies: "+copies+", loans: "+loans+")");
		} else {
			return SigmaValidationResult.ok();
		}
	}

	public static Library getLibrary(Book self) {
		return Library.class.cast(self.eContainer());
	}
	
	public static Collection<Loan> getLoans(final Book self) {
		return filter(self.getLibrary().getLoans(),
				new Predicate<Loan>() {
					@Override
					public boolean apply(Loan input) {
						return input.getBook() == self;
					}
				});
	}

	public static boolean invokeIsAvailable(Book self) {
		return self.getLoans().size() < self.getCopies().intValue();
	}

}
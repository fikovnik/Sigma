package fr.unice.i3s.sigma.examples.library.delegate;

import static com.google.common.collect.Iterables.find;

import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Library;

public class LibraryDelegate {

	private LibraryDelegate() {
	}

	public static String getDescription(Library self) {
		return "My Library (" + self.getName() + ")";
	}

	public static Book invokeGetBookByName(Library self, final CharSequence name) {
		Book book = find(self.getBooks(), new Predicate<Book>() {
			@Override
			public boolean apply(Book input) {
				return input.getName().equals(name);
			};
		}, null);

		return book;
	}

}
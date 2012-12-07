package fr.unice.i3s.sigma.examples.library.delegate;

import static com.google.common.collect.Iterables.find;

import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.core.Assert;
import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Library;

public class LibraryDelegate {

	private LibraryDelegate() {
	}

	public static String invokeToString(Library self) {
		StringBuilder sb = new StringBuilder();
		sb.append("Library ");
		sb.append(self.getName());
		sb.append(" (members: ");
		sb.append(self.getMembers().size());
		sb.append(" books: ");
		sb.append(self.getBooks().size());
		sb.append(" loans: ");
		sb.append(self.getLoans().size());
		sb.append(")");
		return sb.toString();
	}

	public static Book invokeGetBookByName(Library self, final String name) {
		Assert.notNull(name, "Parameter name must not be null");
		
		return find(self.getBooks(), new Predicate<Book>() {
			@Override
			public boolean apply(Book input) {
				return input.getName().equals(name);
			};
		}, null);
	}

}
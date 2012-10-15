package library.delegate;

import static com.google.common.collect.Iterables.find;
import library.Book;
import library.Library;

import com.google.common.base.Predicate;

public class LibraryDelegate {
	
	private LibraryDelegate() {
	}
	
	public static String getDescription(Library self) {
		return "My Library ("+self.getName()+")";
	}
	
	public static Book invokeGetBookByName(Library self, final CharSequence name) {
		Book book = find(self.getBooks(), new Predicate<Book>() {
			public boolean apply(Book input) {
				return input.getName().equals(name);
			};
		}, null);
		
		return book;
	}	
	
}
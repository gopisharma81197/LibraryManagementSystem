package LibrarySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
	private List<Book> listOfBooks;

	public Library() {
		this.listOfBooks = new ArrayList<Book>();
	}

	public List<Book> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

	/* Add the book */
	public void addBook(Book book) {
		Optional<Book> bookisPresent = listOfBooks.stream().filter(b -> b.getiSBN().equalsIgnoreCase(book.getiSBN()))
				.findFirst();
		if (bookisPresent.isPresent()) {
			System.out.println("Book with ISBN " + book.getiSBN() + " is already present");
		}
		listOfBooks.add(book);
	}

	/* Remove the book with particular ISBN */
	public boolean removeBook(String iSBN) {
		Optional<Book> bookisPresent = listOfBooks.stream().filter(b -> b.getiSBN().equalsIgnoreCase(iSBN)).findFirst();
		if (bookisPresent.isPresent()) {
			listOfBooks.remove(bookisPresent.get());
			return true;
		}
		System.out.println("Book with ISBN " + iSBN + " is not present");
		return false;
	}

	/*
	 * List of All books with title as searching criteria and non-case sensitive
	 * search
	 */
	public List<Book> findBookByTitle(String title) {
		List<Book> bookisPresentWithTitle = listOfBooks.stream().filter(b -> b.getTitle().equalsIgnoreCase(title))
				.collect(Collectors.toList());
		return bookisPresentWithTitle;
	}

	/*
	 * List of All books with author as searching criteria and non-case sensitive
	 * search
	 */
	public List<Book> findBookByAuthor(String author) {
		List<Book> bookisPresentWithAuthor = listOfBooks.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author))
				.collect(Collectors.toList());
		return bookisPresentWithAuthor;
	}

	/* List of All books irrespective if availability true or false */
	public List<Book> listAllBooks() {
		List<Book> books = listOfBooks.stream().collect(Collectors.toList());
		return books;
	}

	/* List of All books that is available means 'true' */
	public List<Book> listAvailableBooks() {
		List<Book> bookisAvailable = listOfBooks.stream().filter(b -> b.isAvailability()).collect(Collectors.toList());
		return bookisAvailable;
	}

}

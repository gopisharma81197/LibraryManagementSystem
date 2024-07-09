package Librarysystemtestcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import LibrarySystem.Book;
import LibrarySystem.Library;

public class LibraryTest {
	private Library library;
	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;

	@Before
	public void setUp() {
		library = new Library();
		book4 = new Book();
		book1 = new Book("Title1", "Author1", "ISBN1", "Genre1", 2021, "Department1", true);
		book2 = new Book("Title2", "Author2", "ISBN2", "Genre2", 2022, "Department2", false);
		book3 = new Book("Title3", "Author3", "ISBN3", "Genre3", 2023, "Department3", true);
		book4.setTitle("Title4");
		book4.setAuthor("Author4");
		book4.setiSBN("ISBN4");
		book4.setGenre("Genre4");
		book4.setPublicationYear(2024);
		book4.setDepartment("Department4");
		book4.setAvailability(false);
	}

	@Test
	public void testAddBook() {
		library.addBook(book1);
		List<Book> books = library.listAllBooks();
		assertEquals(1, books.size());
		assertEquals(book1, books.get(0));
		assertEquals("Department1", book1.getDepartment());
		assertEquals(2021, book1.getPublicationYear());
		assertEquals("Genre1", book1.getGenre());

		// Test adding a duplicate book
		library.addBook(book1);
		books = library.listAllBooks();
		assertEquals(2, books.size());
	}

	@Test
	public void testRemoveBook() {
		library.addBook(book3);
		library.removeBook("ISBN3");
		List<Book> books = library.listAllBooks();
		assertTrue(books.isEmpty());

		// Test removing a non-existing book
		boolean result = library.removeBook("ISBN3");
		assertFalse(result);
	}

	@Test
	public void testFindBookByTitle() {
		library.addBook(book1);
		List<Book> books = library.findBookByTitle("Title1");
		assertEquals(1, books.size());
		assertEquals(book1, books.get(0));

		// Test case-insensitive search
		books = library.findBookByTitle("title1");
		assertEquals(1, books.size());
		assertEquals(book1, books.get(0));

		// Test non-existing title
		books = library.findBookByTitle("NonExistingTitle");
		assertTrue(books.isEmpty());
	}

	@Test
	public void testFindBookByAuthor() {
		library.addBook(book1);
		List<Book> books = library.findBookByAuthor("Author1");
		assertEquals(1, books.size());
		assertEquals(book1, books.get(0));

		// Test case-insensitive search
		books = library.findBookByAuthor("author1");
		assertEquals(1, books.size());
		assertEquals(book1, books.get(0));

		// Test non-existing author
		books = library.findBookByAuthor("NonExistingAuthor");
		assertTrue(books.isEmpty());
	}

	@Test
	public void testListAllBooks() {
		library.addBook(book1);
		library.addBook(book2);
		List<Book> books = library.listAllBooks();
		assertEquals(2, books.size());
	}

	@Test
	public void testListAvailableBooks() {
		library.addBook(book1);
		library.addBook(book2);
		List<Book> books = library.listAvailableBooks();
		assertEquals(1, books.size());
		assertEquals(book1, books.get(0));
	}

	@Test
	public void testListOfBooks() {
		library.addBook(book1);
		library.addBook(book2);
		List<Book> books = library.getListOfBooks();

		/* verify both can be fetched successfully with list of books */
		assertEquals(2, books.size());
	}

	@Test
	public void testsetListOfBooks() {
		List<Book> book = new ArrayList<Book>();
		book.add(book1);
		book.add(book2);
		library.setListOfBooks(book);

		/* verify both book are added successfully */
		assertEquals(2, book.size());
	}
}

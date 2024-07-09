package LibrarySystem;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {

	public static void main(String[] args) {

		Library library = new Library();
		Scanner in = new Scanner(System.in);
		drawLines();
		System.out.println("Library Mangement System ");
		while (true) {
			menu();
			Integer process = in.nextInt();
			in.nextLine();
			switch (process) {
			case 0:
				System.exit(0);
				break;
			case 1:
				addingBookProcess(in, library);
				break;
			case 2:
				removeBookProcess(in, library);
				break;
			case 3:
				findBookByAuthorProcess(in, library);
				break;
			case 4:
				findBookByTitleProcess(in, library);
				break;
			case 5:
				findAvailableBooks(library);
				break;
			case 6:
				findAllBooks(library);
				break;
			default:
				System.out.println("Please choose the correct number fromm above list.");
				break;
			}

		}

	}

	public static void drawLines() {
		System.out.println("===========================");
	}

	public static void menu() {
		drawLines();
		System.out.println("Menu");
		drawLines();
		System.out.println("0. Exit");
		System.out.println("1. Add Book");
		System.out.println("2. Remove Book");
		System.out.println("3. Search by author");
		System.out.println("4. Search by title");
		System.out.println("5. List all available books");
		System.out.println("6. List all books");
		drawLines();
		System.out.println("Enter the number i.e, 1,2,3 etc from above list to process the function and '0' to Exit.");
	}

	public static void addingBookProcess(Scanner in, Library library) {

		System.out.print("Enter title: ");
		String title = in.nextLine();
		System.out.print("Enter author: ");
		String author = in.nextLine();
		System.out.print("Enter ISBN: ");
		String ISBN = in.nextLine();

		System.out.print("Enter genre: ");
		String genre = in.nextLine();
		int publicationYear=0;
		while(true){
			try {
				 System.out.print("Enter publication year 4 digit(numeric only): ");
				 publicationYear= Integer.parseInt(in.nextLine());
				 break;
			} catch(Exception e) {
				System.out.println("Please add only numeric number");
			}
			
		}
		System.out.print("Enter department: ");
		String department = in.nextLine();
		System.out.print("Is the book available (true/false): ");
		boolean availability = Boolean.parseBoolean(in.nextLine());
		try {
			Book book = new Book(title, author, ISBN, genre, publicationYear, department, availability);
			library.addBook(book);
			System.out.println("Book is added.");
		} catch (Exception e) {
			System.out.println("Book is not added due to some exception occur.");
		}

	}

	public static void removeBookProcess(Scanner in, Library library) {

		System.out.print("Enter ISBN: ");
		String ISBN = in.nextLine();

		if (library.removeBook(ISBN)) {
			System.out.println("Book with ISBN" + ISBN + "+is successfully removed.");
		}
	}

	public static void findBookByTitleProcess(Scanner in, Library library) {

		System.out.print("Enter title: ");
		String title = in.nextLine();

		List<Book> bookByTitle = library.findBookByTitle(title.trim());
		if (bookByTitle.isEmpty()) {
			System.out.println("Book with title " + title + " is not present.");
		} else {
			bookByTitle.stream().forEach(a -> System.out
					.println("Book Details : { Title : " + a.getTitle() + " , Author " + a.getAuthor() + " }"));
		}
	}

	public static void findBookByAuthorProcess(Scanner in, Library library) {

		System.out.print("Enter author: ");
		String author = in.nextLine();

		List<Book> bookByAuthor = library.findBookByAuthor(author.trim());
		if (bookByAuthor.isEmpty()) {
			System.out.println("Book with author " + author + " is not present.");
		} else {
			bookByAuthor.stream().forEach(a -> System.out
					.println("Book Details : { Title : " + a.getTitle() + " , Author " + a.getAuthor() + " }"));
		}
	}

	public static void findAllBooks(Library library) {
		List<Book> books = library.listAllBooks();
		if (books.isEmpty()) {
			System.out.println("No books are present.");
		} else {
			books.stream()
					.forEach(a -> System.out.println("Book Details : { Title : " + a.getTitle() + ", Author : "
							+ a.getAuthor() + " , ISBN : " + a.getiSBN() + " , Genre :" + a.getGenre()
							+ ",  Publication year : " + a.getAuthor() + " }"));
		}
	}

	public static void findAvailableBooks(Library library) {
		List<Book> booksAvailable = library.listAvailableBooks();
		if (booksAvailable.isEmpty()) {
			System.out.println("No books are present.");
		} else {
			booksAvailable.stream()
			.forEach(a -> System.out.println("Book Details : { Title : " + a.getTitle() + ", Author : "
					+ a.getAuthor() + " , ISBN : " + a.getiSBN() + " , Genre :" + a.getGenre()
					+ ",  Publication year : " + a.getAuthor() + " }"));
		}
	}

}

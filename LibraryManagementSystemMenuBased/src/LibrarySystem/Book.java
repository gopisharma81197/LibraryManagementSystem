package LibrarySystem;

public class Book {
	private String title;
	private String author;
	private String iSBN;
	private String genre;
	private int publicationYear;
	private String department;
	private boolean availability;

	/* parameterized Constructor */
	public Book(String title, String author, String iSBN, String genre, int publicationYear, String department,
			boolean availability) {
		this.title = title;
		this.author = author;
		this.iSBN = iSBN;
		this.genre = genre;
		this.publicationYear = publicationYear;
		this.department = department;
		this.availability = availability;
	}

	/* non-parameterized Constructor */
	public Book() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}

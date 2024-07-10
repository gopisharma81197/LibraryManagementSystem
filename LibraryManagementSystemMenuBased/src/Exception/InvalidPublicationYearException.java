package Exception;

public class InvalidPublicationYearException extends Exception {

	public InvalidPublicationYearException() {
		super("Please enter 4 digit numeric only.");
	}
}

package db.exceptions;

/**
 * An exception that provides information on a database access error.
 * 
 * @author A.Yegorov
 *
 */

public class DBException extends AppException {

	private static final long serialVersionUID = -1872071709799492684L;

	public DBException() {
		super();
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}
}

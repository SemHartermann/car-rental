package db.exceptions;

/**
 * An exception that provides information on an application error.
 * 
 * @author A.Yegorov
 *
 */

public class AppException extends Exception{

	private static final long serialVersionUID = -2068317733482791596L;
	
	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

}

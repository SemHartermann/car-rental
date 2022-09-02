package exception;

import db.exceptions.AppException;
import org.junit.Test;

public class AppExceptionTest {

	@Test(expected = AppException.class)
	public final void testAppException() throws AppException {
		throw new AppException();
	}

	@Test(expected = AppException.class)
	public void testAppExceptionStringThrowable() throws AppException {
		AppException ex = new AppException();
		throw new AppException("ERROR", ex);
	}

	@Test(expected = AppException.class)
	public void testAppExceptionString() throws AppException {
		throw new AppException("ERROR");
	}

}

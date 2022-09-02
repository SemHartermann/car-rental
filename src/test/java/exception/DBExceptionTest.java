package exception;

import db.exceptions.DBException;
import org.junit.Test;

public class DBExceptionTest {

	@Test
	public void testDBException() {
		new DBException();
	}

	@Test
	public void testDBExceptionStringThrowable() {
		NullPointerException ex = new NullPointerException();
		new DBException("Error", ex);
	}

}

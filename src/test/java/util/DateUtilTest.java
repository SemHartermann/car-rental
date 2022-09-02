package util;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testGetDateFromString() {
		DateUtil dateUtil = new DateUtil();
		String actual = dateUtil.getDateFromString("2016-08-25", "yyyy-MM-dd")
				.toString();
		String expected = "2016-08-25";
		assertEquals(expected, actual);
	}

	@Test
	public void testFullDaysBetweenDates() {
		DateUtil dateUtil = new DateUtil();
		Date d1 = dateUtil.getDateFromString("2016-08-25", "yyyy-MM-dd");
		Date d2 = dateUtil.getDateFromString("2016-08-28", "yyyy-MM-dd");
		int actual = (int) dateUtil.fullDaysBetweenDates(d1, d2);
		int expected = 3;
		assertEquals(expected, actual);
	}

}

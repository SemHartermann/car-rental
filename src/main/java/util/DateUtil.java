package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class DateUtil {

	public static final long MILLISECONDS_IN_YEAR = 1000 * 60 * 60 * 24 * 365L;
	public static final long MILLISECONDS_IN_DAY = 1000 * 60 * 60 * 24L;
	public static final String DATE_FORMAT = "yyyy-MM-dd";


	public static Date getDateFromString(String stringDate, String dateFormat) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			date = new Date(sdf.parse(stringDate).getTime());
		} catch (ParseException e) {
		}
		return date;
	}



	public static long fullDaysBetweenDates(Date orderDate, Date returnDate) {
		return (returnDate.getTime() - orderDate.getTime())
				/ MILLISECONDS_IN_DAY;
	}


	public static Date getCurrentDate() {
		return new Date(Calendar.getInstance().getTimeInMillis());
	}



	public static Date afterOneYearDate(Date currentDate) {
		Date date = new Date(currentDate.getTime() + MILLISECONDS_IN_YEAR);
		return date;
	}

}

package util;

import java.util.Date;
import java.util.GregorianCalendar;

public class OnlyDate extends Date {
    
    public Date getOnlyDate() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(this);
        cal.set(GregorianCalendar.HOUR_OF_DAY, 0);
        cal.set(GregorianCalendar.MINUTE, 0);
        cal.set(GregorianCalendar.SECOND, 0);
        cal.set(GregorianCalendar.MILLISECOND, 0);
        return cal.getTime();
    }
}

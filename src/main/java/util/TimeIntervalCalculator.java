package util;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeIntervalCalculator {

    private static final Logger LOG = Logger.getLogger(TimeIntervalCalculator.class);
    public static int getDays(Date startDate, Date endDate) {

        LOG.info("Start date = "+startDate);
        LOG.info("Start date = "+startDate);

        return (int) TimeUnit.MILLISECONDS.toDays(endDate.getTime()
                - startDate.getTime());
    }


}

package abolfazli.mahdi.weather.utils;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String calculateWeekdayFromTimestamp(long timestampLong) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        Date dateFormat = new java.util.Date(timestampLong * 1000);
        return sdf.format(dateFormat );
    }

    public static String calculateHourFromTimestamp(long timestampLong) {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(timestampLong * 1000);
        return DateFormat.format("h a", calendar).toString();
    }
}

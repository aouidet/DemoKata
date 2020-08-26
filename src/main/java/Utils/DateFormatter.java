package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

    public static Date date(String date){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        try {
            Date dateReturned = formatter.parse(date);
            return dateReturned;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
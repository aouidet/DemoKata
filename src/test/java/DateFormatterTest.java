import Utils.DateFormatter;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class DateFormatterTest {

    @Test
    public void date_ShouldCreateDateFromString(){

        String EXPECTED_STRING_DATE = "Mon Aug 24 00:00:00 CEST 2020" ;
        Date date = DateFormatter.date("24/08/2020");
        assertEquals(date.toString(), EXPECTED_STRING_DATE);
    }
}
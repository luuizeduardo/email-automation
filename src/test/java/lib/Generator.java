package lib;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    public static String dateToFile(){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(ts);
    }

    public static String dateToScreenshot(){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(ts);
    }
}

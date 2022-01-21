package main.java.mpti.time;

import java.util.Date;

public class TimeAndDate {
    public static void main(String[] args) {

        long miliseconsSince1yan1970 = System.currentTimeMillis(); // минус число високосных секунд
        System.out.println(miliseconsSince1yan1970/1000/(86400));

        Date date = new Date(miliseconsSince1yan1970); // перегруженный

    }
}
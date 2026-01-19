package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static final String DATE = "yyyy年MM月dd日";

    public static final String TIME = "HH时mm分ss秒";

    public static final String DATE_TIME = "yyyy年MM月dd日 HH时mm分ss秒";


    public static String getNowDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE);
        return dateTimeFormatter.format(LocalDate.now());
    }
    public static String getNowTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME);
        return dateTimeFormatter.format(LocalTime.now());
    }
    public static String getNowDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME);
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}

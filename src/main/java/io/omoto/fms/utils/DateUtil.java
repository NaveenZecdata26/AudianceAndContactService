package io.omoto.fms.utils;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

import static io.omoto.fms.commons.constants.Constants.EMPTY_STRING;
import static io.omoto.fms.commons.constants.Constants.FREE_TRIAL_DAYS;


/**
 * Created by Venkatesh Gowda on 12/1/18.
 */
public class DateUtil {

    public static final String YYMMDD="yyyy-MM-dd";
    public static final String YYMMDDHHMMSS="yyyy-MM-dd HH:mm:ss";
    public static final String HHMM="HH:mm";
    public static final String ddmmmyyyyhhmm = "dd-MMM-yyyy HH:mm";

    private DateUtil() {
    }

    public static Date getExpiryDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, FREE_TRIAL_DAYS);
        return calendar.getTime();
    }

    public static Date convertEpochToDate(int epoch) {
        return epoch != 0 ?
                Timestamp.valueOf(Instant.ofEpochMilli(epoch).atZone(ZoneId.systemDefault()).toLocalDateTime())
                : null;
    }

    public static Date getDateByTimeZone(Long epoch,String timezone) {
        return epoch != 0 ?
                Timestamp.valueOf(Instant.ofEpochMilli(epoch).atZone(ZoneId.of(timezone)).toLocalDateTime())
                : null;
    }

    public static Long getEpochDateByTimeZone(Long epoch,String timezone) {
        Date date = new Date(epoch);
        ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.of(timezone));
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        return  (localDateTime.getLong(ChronoField.EPOCH_DAY) * 86400000) + localDateTime.getLong(ChronoField.MILLI_OF_DAY);
    }

    public static Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat(YYMMDD);
        return dateFormat.format(yesterday());
    }

    public static LocalDateTime getDateByTimeZone(LocalDateTime localDateTime, String timeZone) {
        return localDateTime  // "2018-01-23T01:23:45.123456789"Parse string, lacking an offset-from-UTC and lacking a time zone, as a `LocalDateTime`.
                .atZone(ZoneId.of(timeZone)).toLocalDateTime();        // "Africa/Tunis" ,Assign the time zone for which you are certain this date-time was intended. Instantiates a `ZonedDateTime` object.
    }

    public static ZonedDateTime getDateByTimeZone(String localDateTime, String timeZone) {
        return LocalDateTime.parse( localDateTime)  // "2018-01-23T01:23:45.123456789"Parse string, lacking an offset-from-UTC and lacking a time zone, as a `LocalDateTime`.
                .atZone(ZoneId.of(timeZone));        // "Africa/Tunis" ,Assign the time zone for which you are certain this date-time was intended. Instantiates a `ZonedDateTime` object.
    }

    public static LocalDateTime getDateByTimeZone(Object date, String timeZone) {
        Date date1 = (Date) date;
        return date1.toInstant().atZone(ZoneId.of(timeZone)).toLocalDateTime();
    }

    public static LocalDateTime getDateByTimeZone(Date date, String timeZone) {
        return date.toInstant().atZone(ZoneId.of(timeZone)).toLocalDateTime();
    }


    public static LocalDateTime getLocalDateTime(String localDateTime) {
        if(!localDateTime.contains(":")){
            localDateTime=localDateTime+" 00:00:00";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYMMDDHHMMSS);
        return LocalDateTime.parse( localDateTime,formatter);
    }

    public static Date getDate(String dateString) {
        /*if(!dateString.contains(":")){
            dateString=dateString+" 00:00:00";
        }*/
        SimpleDateFormat formatter=new SimpleDateFormat(YYMMDD);
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }

    public static Date getDateWithEndTime(String dateString) {
        dateString= dateString+" 11:59:59";
        SimpleDateFormat formatter=new SimpleDateFormat(YYMMDDHHMMSS);
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }

    public static String getMongoDBFromDateString(String fromDate) {
        return fromDate+"T00:00:00.000Z";//2012-01-01T15:00:00.000Z
    }

    public static String getMongoDBToDateString(String fromDate) {
        return fromDate+"T12:00:00.000Z";//2012-01-01T15:00:00.000Z
    }

    public static LocalDateTime getLocalDateTimeByEpoch(Long epochValue){
        return Instant.ofEpochMilli(epochValue).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date addOneDayToDate(Date date){
        LocalDate localDate = LocalDateTime.from(date.toInstant()).plusDays(1).toLocalDate();
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getDateByAddingOneDay(String date){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYMMDD);
            Calendar c = Calendar.getInstance();
            c.setTime(simpleDateFormat.parse(date));
            c.add(Calendar.DATE, 1);
            return c.getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    public static String getDateInYYMMDDFormat(Date date){
        SimpleDateFormat format = new SimpleDateFormat(YYMMDD);
        return format.format(date);
    }

    public static String getDateInHHMM(Date date){
        SimpleDateFormat format = new SimpleDateFormat(HHMM);
        return format.format(date);
    }


    public static String getHumanReadableDate(Date date) {
        if(date==null)return EMPTY_STRING;
        DateFormat formatter = new SimpleDateFormat(ddmmmyyyyhhmm);
        return formatter.format(date);
    }

    public static String getHumanReadableDate(LocalDate date) {
        if(date==null)return EMPTY_STRING;
        return date.format(DateTimeFormatter.ofPattern(ddmmmyyyyhhmm));
    }

    public static String getHumanReadableDate(LocalDateTime date) {
        if(date==null)return EMPTY_STRING;
        return date.format(DateTimeFormatter.ofPattern(ddmmmyyyyhhmm));
    }

    public static String getHumanReadableDateByTimeZone(Object date, String timeZone) {
        if(date==null)return EMPTY_STRING;
        Date date1 = (Date) date;
        return getHumanReadableDate(date1.toInstant().atZone(ZoneId.of(timeZone)).toLocalDateTime());
    }
}

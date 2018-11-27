package ua.ppankk;

import org.apache.log4j.Logger;

import java.util.*;

public class Helloer {
    private Calendar calendar = new GregorianCalendar();
    private static final Logger logger = Logger.getLogger(Helloer.class);

    public Helloer() {
    }

    void sayHello(String message){

        System.out.println(message);
        logger.info("Printed message: " + message);
    }

    Integer getHour(Date date){

        Integer hour = Integer.parseInt(date.toString().substring(11,13));
        logger.info("Now: " + hour + "hour in date: " + date.toString());

        return hour;
    }

    Date getDate(Calendar calendar){
        return calendar.getTime();
    }

    String dayPartFinder(Integer hour) throws IllegalArgumentException{
        String dayPart;
        if(hour > 23 || hour < 0) throw new IllegalArgumentException("min Hour is 0 and max Hour is 23");
        if(hour == 23)
            dayPart = "night";
        else if(hour >= 19)
            dayPart = "evening";
        else if(hour >= 9)
            dayPart = "day";
        else if(hour >= 6)
            dayPart = "morning";
        else dayPart = "night";

        logger.info("Now: " + dayPart);
        return dayPart;
    }

    Locale getLocale(){
        return Locale.getDefault();
    }

    ResourceBundle getResource(String bundleName, Locale locale){
        return ResourceBundle.getBundle(bundleName, locale);
    }

    void sayHello(){
        sayHello(
                getResource("helloBundle", getLocale()).getString(
                        dayPartFinder(
                                getHour(
                                        getDate(calendar)
                                )
                        )
                )
        );
        logger.info("Time set to: " + calendar.getTime().toString());
        logger.info("Locale is: " + getLocale().toString());
    }

    void sayHello(Locale locale, Date date){
        sayHello(
                getResource("helloBundle", locale).getString(
                        dayPartFinder(
                                getHour(date)
                        )
                )
        );
    }
}

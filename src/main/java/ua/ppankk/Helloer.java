package ua.ppankk;

import java.util.*;

public class Helloer {
    private Calendar calendar = new GregorianCalendar();

    public Helloer() {
    }

    void sayHello(String message){

        System.out.print(message);
    }

    Integer getHour(Date date){

        return Integer.parseInt(date.toString().substring(11,13));
    }

    Date getDate(Calendar calendar){
        return calendar.getTime();
    }

    String dayPartFinder(Integer hour) throws IllegalArgumentException{
        if(hour > 23 || hour < 0) throw new IllegalArgumentException("min Hour is 0 and max Hour is 23");
        if(hour == 23)
            return "night";
        else if(hour >= 19)
            return "evening";
        else if(hour >= 9)
            return "day";
        else if(hour >= 6)
            return "morning";
        else return "night";
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
    }
}

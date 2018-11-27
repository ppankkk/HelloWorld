package ua.ppankk;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class HelloWorld {
    public static void main(String[] args) {
/***************
 * sayHello()
 * method use system time and locale
 * for print localized message to System.out
 *
 * sayHello(String message)
 * prints arbitrary message to System.out
 *
 * sayHello(Locale locale, Date date)
 * prints localized message to System.out
 * using param local for localize messages,
 * available locals is en_US, ru_RU, ru_UA and ukr_UA.
 * param date used for choose message text regarding to the time of day
 * **************/
        Helloer helloer = new Helloer();
        Calendar calendar = new GregorianCalendar();
        calendar.set(12,11,10, 5,0);

        helloer.sayHello();
        helloer.sayHello("My massage");
        helloer.sayHello(new Locale("ukr", "UA"), calendar.getTime());
    }
}

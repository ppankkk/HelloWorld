package ua.ppankk;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class HelloWorld {
    public static void main(String[] args) {

        Helloer helloer = new Helloer();
        Calendar calendar = new GregorianCalendar();
        calendar.set(12,11,10, 5,0);

        helloer.sayHello();
        helloer.sayHello("My massage");
        helloer.sayHello(new Locale("ukr", "UA"), calendar.getTime());
    }
}

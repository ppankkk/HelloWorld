package ua.ppankk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class HelloerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void sayHello() {
        String message = "Hello message";
        new Helloer().sayHello(message);

        assertEquals(message + "\n", outContent.toString());
    }

    @Test
    public void sayHelloWithParams() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(12, 11, 10, 0,8,7);
        Locale locale = new Locale("ukr", "UA");

        String expectedMessage = "Доброї ночі, Мир!\n";
        new Helloer().sayHello(locale, calendar.getTime());

        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void getHour() {
        Calendar calendar = new GregorianCalendar();
        Integer hour = 9;
        calendar.set(12, 11, 10, hour,8,7);
        Date date = calendar.getTime();
        Integer actualHour = new Helloer().getHour(date);

        assertEquals(hour, actualHour);
    }

    @Test
    public void getDate() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(12, 11, 10, 9,8,7);
        Date date = calendar.getTime();
        Date actualDate = new Helloer().getDate(calendar);

        assertEquals(date, actualDate);
    }

    @Test
    public void dayPartFinder() {
        Helloer helloer = new Helloer();
        String exceptionMessage = "";
        Boolean thrown = false;
        Integer
                hour = 3;
        assertEquals("night", helloer.dayPartFinder(hour));
                hour = 6;
        assertEquals("morning", helloer.dayPartFinder(hour));
                hour = 9;
        assertEquals("day", helloer.dayPartFinder(hour));
                hour = 19;
        assertEquals("evening", helloer.dayPartFinder(hour));
                hour = 23;
        assertEquals("night", helloer.dayPartFinder(hour));
                hour = 24;
        try{
            helloer.dayPartFinder(hour);
        }catch (IllegalArgumentException e){
            exceptionMessage = e.getMessage();
            thrown = true;
        }finally {
            assertEquals("min Hour is 0 and max Hour is 23", exceptionMessage);
        }
        assertTrue(thrown);
    }

    @Test
    public void getLocale() {
        Locale.setDefault(new Locale("ru", "RU"));
        Locale locale = Locale.getDefault();
        Locale actualLocale = new Helloer().getLocale();

        assertEquals(locale, actualLocale);
    }

    @Test
    public void getResource() {
        Helloer helloer = new Helloer();
        String resName = "helloBundle";
        Locale locale = new Locale("en", "US");
        String[] keys = {"morning", "day", "evening", "night"};
        String[] val = {"Good morning, World!",
                        "Good day, World!",
                        "Good evening, World!",
                        "Good night, World!"};
        ResourceBundle resourceBundle = helloer.getResource(resName, locale);
        for(int i=0; i<keys.length; i++){
            assertEquals(val[i], resourceBundle.getString(keys[i]));
        }
    }
}

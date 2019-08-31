package nl.seiferd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void startsWith(){
        List<String> strings = Arrays.asList("Kotlin", "Java", "Javascript");
        List<String> result = MainKt.startsWith(strings, 'K');

        assertEquals(1, result.size());
        assertEquals("Kotlin", result.get(0));
    }

    @Test
    void furthest(){
        Point expected = new Point(6, 7);
        Point result = MainKt.furthest(Arrays.asList(new Point(6, 5), new Point(2, 7), new Point(6, 7)));

        assertEquals(expected, result);
    }

    @Test
    void closest(){
        Point expected = new Point(2, 2);
        Point result = MainKt.closest(Arrays.asList(new Point(2, 5), new Point(2, 2), new Point(6, 2)));

        assertEquals(expected, result);
    }

    @Test
    void operatorOverloading(){
        Point expected = new Point(10, 10);

        Point pointOne = new Point(5, 5);
        Point pointTwo = new Point(5, 5);

        Point newPoint = pointOne.plus(pointTwo); // Not able to use + as java does not get this

        assertEquals(expected, newPoint);
    }

}
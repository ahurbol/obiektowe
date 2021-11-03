package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(9,2);
        Vector2d position3 = new Vector2d(1, 2);
        String string = "test";
        assertFalse(position1.equals(null));
        assertTrue(position1.equals(position1));
        assertFalse(position1.equals(position2));
        assertTrue(position1.equals(position3));
        assertFalse(position1.equals(string));
    }

    @Test
    public void toStringTest() {
        assertNotEquals((new Vector2d(1, 2)).toString(), "(1,1)");
        assertEquals((new Vector2d(1, 1)).toString(), "(1,1)");
    }

    @Test
    public void precedesTest() {
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);
        Vector2d position3 = new Vector2d(1, 2);
        Vector2d position4 = new Vector2d(3, 5);
        Vector2d position5 = new Vector2d(3, 2);

        assertFalse(position1.precedes(position2));
        assertTrue(position1.precedes(position3));
        assertTrue(position1.precedes(position4));
        assertFalse(position5.precedes(position3));
        assertTrue(position5.precedes(position4));
        assertFalse(position4.precedes(position2));
        assertTrue(position2.precedes(position4));
        assertFalse(position1.precedes(position2));
    }

    @Test
    public void followsTest() {
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);
        Vector2d position3 = new Vector2d(1, 2);
        Vector2d position4 = new Vector2d(3, 5);
        Vector2d position5 = new Vector2d(3, 2);
        assertTrue(position1.follows(position2));
        assertTrue(position1.follows(position3));
        assertFalse(position1.follows(position4));
        assertFalse(position5.follows(position4));
        assertTrue(position4.follows(position5));
        assertTrue(position4.follows(position3));
        assertTrue(position5.follows(position3));
        assertFalse(position2.follows(position1));
        assertFalse(position2.follows(position5));
    }

    @Test
    public void upperRightTest() {
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);
        Vector2d position3 = new Vector2d(2, 0);
        Vector2d position4 = new Vector2d(3, 5);
        assertEquals(position1.upperRight(position2), new Vector2d(1, 2));
        assertEquals(position1.upperRight(position3), new Vector2d(2, 2));
        assertEquals(position1.upperRight(position4), new Vector2d(3, 5));
    }

    @Test
    public void lowerLeftTest() {
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);
        Vector2d position3 = new Vector2d(2, 0);
        Vector2d position4 = new Vector2d(3, 5);
        assertEquals(position1.lowerLeft(position2), new Vector2d(-2, 1));
        assertEquals(position1.lowerLeft(position3), new Vector2d(1, 0));
        assertEquals(position1.lowerLeft(position4), new Vector2d(1, 2));
    }

    @Test
    public void addTest() {
        assertEquals((new Vector2d(1, -1)).add(new Vector2d(-1, 1)), new Vector2d(0, 0));
        assertEquals((new Vector2d(1, 3)).add(new Vector2d(1, -10)), new Vector2d(2, -7));
    }

    @Test
    public void subtractTest() {
        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);
        Vector2d position3 = new Vector2d(2, 0);
        Vector2d position4 = new Vector2d(3, 5);
        assertEquals(position1.subtract(position2), new Vector2d(3, 1));
        assertEquals(position1.subtract(position3), new Vector2d(-1, 2));
        assertEquals(position1.subtract(position4), new Vector2d(-2, -3));
    }

    @Test
    public void oppositeTest() {
        Vector2d position1 = new Vector2d(1,-1);
        Vector2d position2 = new Vector2d(0,0);
        assertEquals(position1.opposite(), new Vector2d(-1, 1));
        assertEquals(position2.opposite(), new Vector2d(0, 0));
    }
}

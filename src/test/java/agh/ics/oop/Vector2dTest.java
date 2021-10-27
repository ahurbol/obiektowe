package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        assertTrue((new Vector2d(1, 1)).equals(new Vector2d(1, 1)));
        assertFalse((new Vector2d(1, 1)).equals(new Vector2d(2, 1)));
    }

    @Test
    public void toStringTest() {
        assertNotEquals((new Vector2d(1, 2)).toString(), "(1,1)");
        assertEquals((new Vector2d(1, 1)).toString(), "(1,1)");
    }

    @Test
    public void precedesTest() {
        assertTrue((new Vector2d(1, 1)).precedes(new Vector2d(2, 2)));
        assertTrue((new Vector2d(1, 1)).precedes(new Vector2d(1, 2)));
    }

    @Test
    public void followsTest() {
        assertTrue((new Vector2d(2, 2)).follows(new Vector2d(1, 1)));
        assertTrue((new Vector2d(1, 1)).follows(new Vector2d(1, 0)));
    }

    @Test
    public void upperRightTest() {
        assertEquals((new Vector2d(10, 3)).upperRight(new Vector2d(2, 8)), new Vector2d(10, 8));
        assertEquals((new Vector2d(1, 3)).upperRight(new Vector2d(8, 8)), new Vector2d(8, 8));
    }

    @Test
    public void lowerLeftTest() {
        assertEquals((new Vector2d(10, 3)).lowerLeft(new Vector2d(2, 8)), new Vector2d(2, 3));
        assertEquals((new Vector2d(1, 3)).lowerLeft(new Vector2d(8, 8)), new Vector2d(1, 3));
    }

    @Test
    public void addTest() {
        assertEquals((new Vector2d(1, -1)).add(new Vector2d(-1, 1)), new Vector2d(0, 0));
        assertEquals((new Vector2d(1, 3)).add(new Vector2d(1, -10)), new Vector2d(2, -7));
    }

    @Test
    public void substractTest() {
        assertEquals((new Vector2d(1, -1)).subtract(new Vector2d(-1, -1)), new Vector2d(2, 0));
        assertEquals((new Vector2d(1, 3)).subtract(new Vector2d(-2, 4)), new Vector2d(3, -1));
    }

    @Test
    public void oppositeTest() {
        assertEquals((new Vector2d(1, -1)).opposite(), new Vector2d(-1, 1));
        assertEquals((new Vector2d(0, 0)).opposite(), new Vector2d(0, 0));
    }
}

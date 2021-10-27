package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapDirectionTest {
    @Test
    public void nextTest() {
        assertTrue((MapDirection.NORTH.next() == MapDirection.EAST));
        assertTrue((MapDirection.EAST.next() == MapDirection.SOUTH));
        assertTrue((MapDirection.SOUTH.next() == MapDirection.WEST));
        assertTrue((MapDirection.WEST.next() == MapDirection.NORTH));
    }

    @Test
    public void previousTest() {
        assertTrue((MapDirection.NORTH.previous() == MapDirection.WEST));
        assertTrue((MapDirection.EAST.previous() == MapDirection.NORTH));
        assertTrue((MapDirection.SOUTH.previous() == MapDirection.EAST));
        assertTrue((MapDirection.WEST.previous() == MapDirection.SOUTH));
    }
}


package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void testCanMoveTo(){
        AbstractWorldMap rectangularMap = new RectangularMap(6, 6);

        Vector2d[] initPos = {new Vector2d(0, 0), new Vector2d(2, 3)};
        Animal[] animals = {new Animal(rectangularMap, initPos[0]), new Animal(rectangularMap, initPos[1])};

        for (Animal animal : animals) {
            rectangularMap.place(animal);
        }

        assertFalse(rectangularMap.canMoveTo(new Vector2d(0, 0)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(1, 1)));

        assertFalse(rectangularMap.canMoveTo(new Vector2d(6, 6)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(5, 5)));

        assertFalse(rectangularMap.canMoveTo(new Vector2d(2, 3)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(1, 2)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(3, 2)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(-1, 1)));

        animals[0].move(MoveDirection.FORWARD);
        animals[1].move(MoveDirection.BACKWARD);
        assertFalse(rectangularMap.canMoveTo(new Vector2d(0, 1)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(0, 0)));
        assertFalse(rectangularMap.canMoveTo(new Vector2d(2, 2)));
        assertTrue(rectangularMap.canMoveTo(new Vector2d(2, 3)));
    }

    @Test
    public void testIsOccupied(){
        AbstractWorldMap rectangularMap = new RectangularMap(6, 6);

        Vector2d[] initPos = {new Vector2d(0, 0), new Vector2d(2, 3)};
        Animal[] animals = {new Animal(rectangularMap, initPos[0]), new Animal(rectangularMap, initPos[1])};

        for (Animal animal : animals) {
            rectangularMap.place(animal);
        }

        assertTrue(rectangularMap.isOccupied(new Vector2d(0, 0)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(4, 4)));
        assertTrue(rectangularMap.isOccupied(new Vector2d(2, 3)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(1, 1)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(123, -123)));

        assertFalse(rectangularMap.isOccupied(new Vector2d(1, 1)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(2, 2)));

        animals[0].move(MoveDirection.FORWARD);
        animals[1].move(MoveDirection.BACKWARD);
        assertFalse(rectangularMap.isOccupied(new Vector2d(0, 0)));
        assertFalse(rectangularMap.isOccupied(new Vector2d(2, 3)));
        assertTrue(rectangularMap.isOccupied(new Vector2d(0, 1)));
        assertTrue(rectangularMap.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void testObjectAt(){
        AbstractWorldMap rectangularMap = new RectangularMap(6, 6);

        Vector2d[] initPos = {new Vector2d(0, 0), new Vector2d(2, 3)};
        Animal[] animals = {new Animal(rectangularMap, initPos[0]), new Animal(rectangularMap, initPos[1])};

        for (Animal animal : animals) {
            rectangularMap.place(animal);
        }

        assertNull(rectangularMap.objectAt(new Vector2d(1, 1)));
        assertNull(rectangularMap.objectAt(new Vector2d(2, 2)));
        assertNull(rectangularMap.objectAt(new Vector2d(3, 4)));
        assertEquals(animals[0], rectangularMap.objectAt(new Vector2d(0, 0)));
        assertEquals(animals[1], rectangularMap.objectAt(new Vector2d(2, 3)));

        animals[0].move(MoveDirection.FORWARD);
        animals[1].move(MoveDirection.BACKWARD);
        assertNull(rectangularMap.objectAt(new Vector2d(0, 0)));
        assertNull(rectangularMap.objectAt(new Vector2d(2, 3)));

        assertEquals(animals[0], rectangularMap.objectAt(new Vector2d(0, 1)));
        assertEquals(animals[1], rectangularMap.objectAt(new Vector2d(2, 2)));
    }
}
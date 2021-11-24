package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GrassFieldTest {
    @Test
    public void testCanMoveTo(){
        IWorldMap grassField = new GrassField(6);

        Vector2d[] initPos = {new Vector2d(0, 0), new Vector2d(2, 3)};
        Animal[] animals = {new Animal(grassField, initPos[0]), new Animal(grassField, initPos[1])};

        for (Animal animal : animals) {
            grassField.place(animal);
        }

        assertFalse(grassField.canMoveTo(new Vector2d(0, 0)));
        assertTrue(grassField.canMoveTo(new Vector2d(1, 1)));

        assertTrue(grassField.canMoveTo(new Vector2d(6, 6)));
        assertTrue(grassField.canMoveTo(new Vector2d(5, 5)));

        assertFalse(grassField.canMoveTo(new Vector2d(2, 3)));
        assertTrue(grassField.canMoveTo(new Vector2d(1, 2)));
        assertTrue(grassField.canMoveTo(new Vector2d(3, 2)));
        assertTrue(grassField.canMoveTo(new Vector2d(-1, 1)));

        animals[0].move(MoveDirection.FORWARD);
        animals[1].move(MoveDirection.BACKWARD);
        assertFalse(grassField.canMoveTo(new Vector2d(0, 1)));
        assertTrue(grassField.canMoveTo(new Vector2d(0, 0)));
        assertFalse(grassField.canMoveTo(new Vector2d(2, 2)));
        assertTrue(grassField.canMoveTo(new Vector2d(2, 3)));
    }

    @Test
    public void testIsOccupied(){
        IWorldMap grassField = new GrassField(6);

        Vector2d[] initPos = {new Vector2d(0, 0), new Vector2d(2, 3)};
        Animal[] animals = {new Animal(grassField, initPos[0]), new Animal(grassField, initPos[1])};

        for (Animal animal : animals) {
            grassField.place(animal);
        }

        assertTrue(grassField.isOccupied(new Vector2d(0, 0)));
        assertFalse(grassField.isOccupied(new Vector2d(10, 10)));
        assertTrue(grassField.isOccupied(new Vector2d(2, 3)));
        assertFalse(grassField.isOccupied(new Vector2d(-1, -1)));
        assertFalse(grassField.isOccupied(new Vector2d(123, -123)));

        assertFalse(grassField.isOccupied(new Vector2d(8, 1)));
        assertFalse(grassField.isOccupied(new Vector2d(-2, 2)));

        animals[0].move(MoveDirection.FORWARD);
        animals[1].move(MoveDirection.BACKWARD);
        assertFalse(grassField.isOccupied(new Vector2d(0, 0)));
        assertFalse(grassField.isOccupied(new Vector2d(2, 3)));
    }

    @Test
    public void testObjectAt(){
        IWorldMap grassField = new GrassField(6);

        Vector2d[] initPos = {new Vector2d(0, 0), new Vector2d(2, 3)};
        Animal[] animals = {new Animal(grassField, initPos[0]), new Animal(grassField, initPos[1])};

        for (Animal animal : animals) {
            grassField.place(animal);
        }

        assertNull(grassField.objectAt(new Vector2d(8, 8)));
        assertNull(grassField.objectAt(new Vector2d(-1, -1)));
        assertNull(grassField.objectAt(new Vector2d(14, 12)));
        assertEquals(animals[0], grassField.objectAt(new Vector2d(0, 0)));
        assertEquals(animals[1], grassField.objectAt(new Vector2d(2, 3)));

        animals[0].move(MoveDirection.FORWARD);
        animals[1].move(MoveDirection.BACKWARD);
        assertEquals(animals[0], grassField.objectAt(new Vector2d(0, 1)));
        assertEquals(animals[1], grassField.objectAt(new Vector2d(2, 2)));
    }
}
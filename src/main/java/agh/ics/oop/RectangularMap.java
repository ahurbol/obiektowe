package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    private final ArrayList<Animal> animals;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x < 0 || position.x > this.width || position.y < 0 || position.y > this.height) {
            return false;
        }
        return !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.animals.contains(animal)) {
            return false;
        }
        if (canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public  boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        Vector2d firstVector = new Vector2d(0,0);
        Vector2d secondVector = new Vector2d(width, height);
        return mapVisualizer.draw(firstVector.lowerLeft(secondVector), firstVector.upperRight(secondVector));
    }

}

package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    private final ArrayList<Animal> animals;
    private final Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0,0);

    public RectangularMap(int width, int height) {
        this.animals = new ArrayList<>();
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!position.precedes(upperRight) || !position.follows(lowerLeft)) {
            return false;
        }
        return !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {

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
        return mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }

}

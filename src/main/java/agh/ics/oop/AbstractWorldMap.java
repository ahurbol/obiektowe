package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, AbstractWorldMapElement> list = new LinkedHashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    protected final MapBoundary mapBoundary = new MapBoundary();

    public abstract Vector2d findLowerLeft();

    public abstract Vector2d findUpperRight();

    public Map<Vector2d, AbstractWorldMapElement> getAnimals() {
        return this.list;
    }

    public AbstractWorldMapElement getElement(Vector2d position){
        return this.list.get(position);
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            this.list.put(position, animal);
            mapBoundary.positionChanged(new Vector2d(0,0), position);
            animal.addObserver(this);
            animal.addObserver(mapBoundary);
            return true;
        } else {
            throw new IllegalArgumentException(position + " - this position is occupied");
        }
    }

    public boolean isOccupied(Vector2d position) {
        return this.list.containsKey(position);
    }

    public Object objectAt(Vector2d position) {
        return this.list.get(position);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement animal = list.get(oldPosition);
        this.list.remove(oldPosition);
        this.list.put(newPosition, animal);
    }

    public String toString() {
        return visualizer.draw(findLowerLeft(), findUpperRight());
    }
}

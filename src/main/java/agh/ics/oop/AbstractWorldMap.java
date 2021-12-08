package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, AbstractWorldMapElement> list = new LinkedHashMap<>();  // dziwna nazwa dla mapy
    final MapVisualizer visualizer; // czemu nie private?

    protected abstract Vector2d findLowerLeft();    // polecam getLowerLeft

    protected abstract Vector2d findUpperRight();

    public AbstractWorldMap() {
        visualizer = new MapVisualizer(this);
    }

    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            this.list.put(position, animal);
            return true;
        }
        return false;
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

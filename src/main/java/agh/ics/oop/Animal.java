package agh.ics.oop;


import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement {

    private MapDirection orient = MapDirection.NORTH;
    private final AbstractWorldMap map;
    private final ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
        map.place(this);
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public String toString() {
        return this.orient.symbols();
    }

    public MapDirection getOrient() {
        return this.orient;
    }


    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
    }

    public void move(MoveDirection direction) {
        Vector2d oldPos = this.position;
        Vector2d newPos;
        switch (direction) {
            case RIGHT -> {this.orient = this.orient.next(); return;}
            case LEFT -> {this.orient = this.orient.previous(); return;}
            case FORWARD -> {
                 newPos = this.position.add(this.orient.toUnitVector());
            }
            case BACKWARD -> {
                newPos = this.position.subtract(this.orient.toUnitVector());
            }
            default -> {return;}
        }
        if (this.map.canMoveTo(newPos)) {
            this.position = newPos;
            this.positionChanged(oldPos, newPos);
        }
    }
}

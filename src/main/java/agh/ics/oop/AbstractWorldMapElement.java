package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;
    protected List<IPositionChangeObserver> observers = new ArrayList<>();

    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
    }
    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    abstract public String getPath();

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    protected void positionChanged(Vector2d oldPos,Vector2d newPos) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPos, newPos);
        }
    }



}

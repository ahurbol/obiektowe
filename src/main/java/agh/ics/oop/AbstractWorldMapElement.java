package agh.ics.oop;

public class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }
}

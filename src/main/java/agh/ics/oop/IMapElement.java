package agh.ics.oop;

public interface IMapElement {
    public Vector2d getPosition();
    String toString();
    int compareX(IMapElement a);
    int compareY(IMapElement a);
}

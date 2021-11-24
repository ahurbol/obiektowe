package agh.ics.oop;

public interface IMapElement {

    public Vector2d getPosition();

    @Override
    public boolean equals(Object o);

    @Override
    public String toString();
}

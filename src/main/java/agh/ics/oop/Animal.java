package agh.ics.oop;


public class Animal implements IMapElement {

    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orient = MapDirection.NORTH;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }

    public String toString() {
        return this.orient.symbols();
    }

    public MapDirection getOrient() {
        return this.orient;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orient = this.orient.next();
            case LEFT -> this.orient = this.orient.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orient.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orient.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }

            }
        }
    }
}

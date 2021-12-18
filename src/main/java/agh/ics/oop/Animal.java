package agh.ics.oop;

public class Animal extends AbstractWorldMapElement {

    private MapDirection orient = MapDirection.NORTH;
    private final AbstractWorldMap map;

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
        map.place(this);
    }

    @Override
    public String getPath() {
        return switch (((Animal) this).getOrient()) {
            case EAST -> "src/main/resources/right.png";
            case WEST -> "src/main/resources/left.png";
            case NORTH -> "src/main/resources/up.png";
            case SOUTH -> "src/main/resources/down.png";
        };
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
            map.positionChanged(oldPos, newPos);
        }
    }
}

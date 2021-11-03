package agh.ics.oop;


public class Animal {
    private MapDirection orient = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString() {
        return "[" + this.position + " " + this.orient + "]";
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public MapDirection getOrient() {
        return this.orient;
    }

    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orient = this.orient.next();
            case LEFT -> this.orient = this.orient.previous();
            case FORWARD -> {
                switch (this.orient) {
                    case SOUTH -> this.position = this.position.add(MapDirection.SOUTH.toUnitVector());
                    case NORTH -> this.position = this.position.add(MapDirection.NORTH.toUnitVector());
                    case EAST -> this.position = this.position.add(MapDirection.EAST.toUnitVector());
                    case WEST -> this.position = this.position.add(MapDirection.WEST.toUnitVector());
                }
            }
            case BACKWARD -> {
                switch (this.orient) {
                    case SOUTH -> this.position = this.position.subtract(MapDirection.SOUTH.toUnitVector());
                    case NORTH -> this.position = this.position.subtract(MapDirection.NORTH.toUnitVector());
                    case EAST -> this.position = this.position.subtract(MapDirection.EAST.toUnitVector());
                    case WEST -> this.position = this.position.subtract(MapDirection.WEST.toUnitVector());
                }
            }
        }
        int size = 5;
        if (this.position.x >= size) {
            this.position = this.position.add(MapDirection.WEST.toUnitVector());
        } else if (this.position.x < 0) {
            this.position = this.position.add(MapDirection.EAST.toUnitVector());
        }
        if (this.position.y >= size) {
            this.position = this.position.add(MapDirection.SOUTH.toUnitVector());
        } else if (this.position.y < 0) {
            this.position = this.position.add(MapDirection.NORTH.toUnitVector());
        }
    }
}

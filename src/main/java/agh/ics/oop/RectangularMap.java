package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRight;
    private final Vector2d lowerLeft = new Vector2d(0,0);

    public RectangularMap(int width, int height) {
        this.upperRight = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!position.precedes(upperRight) || !position.follows(lowerLeft)) {
            return false;
        }
        return !this.isOccupied(position);
    }

    public String toString() {
        return visualizer.draw(this.lowerLeft, this.upperRight);
    }

}

package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final int grassAmount;

    public GrassField(int amount) {
        this.grassAmount = amount;
        placeGrass(this.grassAmount);
    }

    public void placeGrass(int amount) {
        Random random = new Random();
        int i = 0;
        int max = (int) Math.sqrt(10 * grassAmount);
        while (i < amount) {
            int x = random.nextInt(max);
            int y = random.nextInt(max);
            Vector2d pos = new Vector2d(x, y);
            if (!isOccupied(pos)) {
                Grass grass = new Grass(pos);
                list.put(pos, grass);
                mapBoundary.positionChanged(new Vector2d(0,0), pos);
                grass.addObserver(mapBoundary);
                i++;
            }
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement grass = list.get(newPosition);
        super.positionChanged(oldPosition, newPosition);
        if (grass instanceof Grass) {
            this.placeGrass(1);
        }
    }

    public Vector2d findLowerLeft() {
        if(mapBoundary.xx.isEmpty())
            return new Vector2d(0, 0);
        return new Vector2d (mapBoundary.xx.first().x, mapBoundary.yy.first().y);
    }

    public Vector2d findUpperRight() {
        if (mapBoundary.xx.isEmpty())
            return new Vector2d(0, 0);
        return new Vector2d(mapBoundary.xx.last().x, mapBoundary.yy.last().y);
    }
}

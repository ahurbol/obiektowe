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
                i++;
            }
        }
    }


    public Vector2d findLowerLeft() {
        int inf = (int) Double.POSITIVE_INFINITY;
        Vector2d lowerLeft = new Vector2d(inf, inf);

        for (Vector2d key : list.keySet()) {
            lowerLeft = lowerLeft.lowerLeft(key);
        }
        return lowerLeft;
    }

    public Vector2d findUpperRight() {
        int inf = (int) Double.POSITIVE_INFINITY;
        Vector2d upperRight = new Vector2d(-inf, -inf);

        for (Vector2d key : list.keySet()) {
            upperRight = upperRight.upperRight(key);
        }
        return upperRight;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement grass = list.get(newPosition);
        super.positionChanged(oldPosition, newPosition);
        if (grass instanceof Grass) {
            this.placeGrass(1);
        }
    }

}

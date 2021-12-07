package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final int grassAmount;
    private MapBoundary mapBoundary = new MapBoundary();

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
                mapBoundary.addElement(grass);
                i++;
            }
        }
    }
    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        animal.addObserver(this.mapBoundary);
        this.mapBoundary.addElement(animal);
        return true;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement grass = list.get(newPosition);
        super.positionChanged(oldPosition, newPosition);
        if (grass instanceof Grass) {
            this.placeGrass(1);
            this.mapBoundary.removeElement(grass);
        }
    }

    public Vector2d findLowerLeft() {
        return this.mapBoundary.findLowerLeft();
    }

    public Vector2d findUpperRight() {
        return this.mapBoundary.findUpperRight();
    }


}

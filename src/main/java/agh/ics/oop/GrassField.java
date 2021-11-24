package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap{

    public GrassField(int countOfGrassField) {
        Random random = new Random();
        int i = 0;
        int max = (int) Math.sqrt(10*countOfGrassField);
        while (i < countOfGrassField) {
            Vector2d vec = new Vector2d(random.nextInt(max), random.nextInt(max));
            if (!isOccupied(vec)) {
                i++;
                super.list.add(new Grass(vec));
            }
        }
    }
}

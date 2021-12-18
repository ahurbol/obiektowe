package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable {
    private MoveDirection[] moves;
    private final AbstractWorldMap map;
    private final ArrayList<Animal> animals;
    private final int moveDelay;

    public SimulationEngine(AbstractWorldMap map, Vector2d[] initialPositions, int moveDelay) {
        this.moveDelay = moveDelay;
        this.map = map;
        this.animals = new ArrayList<>();
        for (Vector2d pos : initialPositions) {
            Animal animal = new Animal(map, pos);
            this.animals.add(animal);
        }
    }

    public void getMoves(MoveDirection[] moves) {
        this.moves = moves;
    }


    public void run() {
        int movesSize = this.moves.length;
        int animalsSize = this.animals.size();
        for (int i = 0; i < movesSize; i++) {
            int animalIdx = i % animalsSize;
            Animal animal = this.animals.get(animalIdx);
            animal.move(this.moves[i]);
            try {
                Thread.sleep(this.moveDelay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}

package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final IWorldMap map;
    private final Vector2d[] initialPositions;
    private final ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;
        this.initialPositions = initialPositions;
        this.animals = new ArrayList<>();
        for (Vector2d pos : initialPositions) {
            this.animals.add(new Animal(map, pos));
        }
    }

    public void run() {
        int movesSize = this.moves.length;
        int animalsSize = this.animals.size();
        for (int i = 0; i < movesSize; i++) {
            int animalIdx = i % animalsSize;
            Animal animal = this.animals.get(animalIdx);
            animal.move(this.moves[i]);
        }
    }
}

package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final AbstractWorldMap map;
    private final ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;
        this.animals = new ArrayList<>();
        for (Vector2d pos : initialPositions) {
            Animal animal = new Animal(map, pos);
            this.animals.add(animal);
            map.place(animal);
        }
    }

    public void run() {
        int movesSize = this.moves.length;
        int animalsSize = this.animals.size();
        for (int i = 0; i < movesSize; i++) {
            int animalIdx = i % animalsSize;
            Animal animal = this.animals.get(animalIdx);
            animal.move(this.moves[i]);
            System.out.println(map);
        }
    }
}

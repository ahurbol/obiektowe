package agh.ics.oop;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    final List<IMapElement> list;
    final MapVisualizer visualizer;

    public AbstractWorldMap() {
        list = new LinkedList<>();
        visualizer = new MapVisualizer(this);
    }

    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) || objectAt(position).getClass() != Animal.class;
    }

    public boolean place(Animal animal) {
        Vector2d vec = animal.getPosition();
        if (canMoveTo(vec)) {
            this.list.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return this.list.stream().anyMatch(o -> o.getPosition().equals(position));
    }

    public Object objectAt(Vector2d position) {
        IMapElement elem = null;
        for (IMapElement animal : this.list) {
            if (animal.getPosition().equals(position)) {
                if (animal.getClass() == Animal.class) {
                    return animal;
                } else elem = animal;
            }
        }
        return elem;
    }

    public String toString() {
        int minX = this.list.stream().min(Comparator.comparingInt(o -> o.getPosition().x)).orElse(new Grass(new Vector2d(2,2))).getPosition().x;
        int maxX = this.list.stream().max(Comparator.comparingInt(o -> o.getPosition().x)).orElse(new Grass(new Vector2d(2,2))).getPosition().x;

        int minY = this.list.stream().min(Comparator.comparingInt(o -> o.getPosition().y)).orElse(new Grass(new Vector2d(2,2))).getPosition().y;
        int maxY = this.list.stream().max(Comparator.comparingInt(o -> o.getPosition().y)).orElse(new Grass(new Vector2d(2,2))).getPosition().y;

        return visualizer.draw(new Vector2d(minX, minY), new Vector2d(maxX, maxY));
    }
}

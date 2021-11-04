package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    private final IWorldMap map = new RectangularMap(5, 5);
    private final Vector2d[] positions1 = new Vector2d[] {new Vector2d(0,0), new Vector2d(1,1) };
    private final Vector2d[] positions2 = new Vector2d[] {new Vector2d(0,0), new Vector2d(1,1), new Vector2d(1,2) };
    private final Vector2d[] positions3 = new Vector2d[] {new Vector2d(0,0), new Vector2d(0,1), new Vector2d(1,1) };

    @Test
    public void simulationEngineTest1() {
        String[] args = new String[] {"f", "f", "r"};
        MoveDirection[] directions = OptionsParser.parse(args);
        SimulationEngine engine = new SimulationEngine(directions, this.map, this.positions1);
        Animal animal1 = (Animal) this.map.objectAt(new Vector2d(0,0));
        Animal animal2 = (Animal) this.map.objectAt(new Vector2d(1,1));

        engine.run();
        assertEquals(new Vector2d(0,1), animal1.getPosition());
        assertEquals(new Vector2d(1,2), animal2.getPosition());
        assertEquals(MapDirection.EAST, animal1.getOrient());
    }

    @Test
    public void simulationEngineTest2() {
        String[] args = new String[] {"f", "f", "r"};
        MoveDirection[] directions = OptionsParser.parse(args);
        SimulationEngine engine = new SimulationEngine(directions, this.map, this.positions2);
        Animal animal1 = (Animal) this.map.objectAt(new Vector2d(0,0));
        Animal animal2 = (Animal) this.map.objectAt(new Vector2d(1,1));
        Animal animal3 = (Animal) this.map.objectAt(new Vector2d(1,2));

        engine.run();
        assertEquals(new Vector2d(0,1), animal1.getPosition());
        assertEquals(new Vector2d(1,1), animal2.getPosition());
        assertEquals(MapDirection.EAST, animal3.getOrient());
    }

    @Test
    public void simulationEngineTest3() {
        String[] args = new String[] {"f", "f", "r", "f", "l","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        SimulationEngine engine = new SimulationEngine(directions, this.map, this.positions3);
        Animal animal1 = (Animal) this.map.objectAt(new Vector2d(0,0));
        Animal animal2 = (Animal) this.map.objectAt(new Vector2d(0,1));
        Animal animal3 = (Animal) this.map.objectAt(new Vector2d(1,1));

        engine.run();
        assertEquals(new Vector2d(0,1), animal1.getPosition());
        assertEquals(new Vector2d(0,2), animal2.getPosition());
        assertEquals(MapDirection.WEST, animal2.getOrient());
        assertEquals(new Vector2d(2,1), animal3.getPosition());
        assertEquals(MapDirection.EAST, animal3.getOrient());
    }

}

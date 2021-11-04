package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationEngineTest {

    private final IWorldMap rectangularMap = new RectangularMap(5, 5);
    private final Vector2d[] positions = new Vector2d[] {new Vector2d(0,0), new Vector2d(1,1) };
    private final Vector2d[] positions2 = new Vector2d[] {new Vector2d(0,0), new Vector2d(1,1), new Vector2d(1,2) };

    @Test
    public void simulationEngineTest() {
        String[] args = new String[] {"f", "f", "r"};
        MoveDirection[] directions = new ArrayList<MoveDirection>(OptionsParser.parse(args)).toArray(new MoveDirection[0]);
        SimulationEngine engine = new SimulationEngine(directions, this.rectangularMap, this.positions);
        Animal animal1 = (Animal) this.rectangularMap.objectAt(new Vector2d(0,0));
        Animal animal2 = (Animal) this.rectangularMap.objectAt(new Vector2d(1,1));

        engine.run();
        assertEquals(new Vector2d(0,1), animal1.getPosition());
        assertEquals(new Vector2d(1,2), animal2.getPosition());
        assertEquals(MapDirection.EAST, animal1.getOrient());
    }

    @Test
    public void simulationEngineTest2() {
        String[] args = new String[] {"f", "f", "r"};
        MoveDirection[] directions = new ArrayList<MoveDirection>(OptionsParser.parse(args)).toArray(new MoveDirection[0]);
        SimulationEngine engine = new SimulationEngine(directions, this.rectangularMap, this.positions2);
        Animal animal1 = (Animal) this.rectangularMap.objectAt(new Vector2d(0,0));
        Animal animal2 = (Animal) this.rectangularMap.objectAt(new Vector2d(1,1));
        Animal animal3 = (Animal) this.rectangularMap.objectAt(new Vector2d(1,2));

        engine.run();
        assertEquals(new Vector2d(0,1), animal1.getPosition());
        assertEquals(new Vector2d(1,1), animal2.getPosition());
        assertEquals(MapDirection.EAST, animal3.getOrient());
    }
}

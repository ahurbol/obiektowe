package agh.ics.oop;

import java.util.ArrayList;

public class World {


    public static void main(String[] args) {
        System.out.println("system wystartował");
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            AbstractWorldMap map = new GrassField(5);
            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            System.out.println(map);
            engine.run();
            System.out.println(map);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        System.out.println("system zatrzymał się");
    }
}


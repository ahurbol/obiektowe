package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public static ArrayList<MoveDirection> parse(String[] args) {
        ArrayList<MoveDirection> dir = new ArrayList<MoveDirection>();
        for (String arg : args) {
            switch (arg) {
                case "forward", "f" -> dir.add(MoveDirection.FORWARD);
                case "backward", "b" -> dir.add(MoveDirection.BACKWARD);
                case "right", "r" -> dir.add(MoveDirection.RIGHT);
                case "left", "l" -> dir.add(MoveDirection.LEFT);
            }
        }
        return dir;
    }
}

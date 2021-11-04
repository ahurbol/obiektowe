package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        int size = 0;
        for (String arg : args) {
            switch (arg) {
                case "forward", "f", "backward", "b", "right", "r", "left", "l" -> size++;            }
        }
        int it = 0;
        MoveDirection[] dir = new MoveDirection[size];
        for (String arg : args) {
            switch (arg) {
                case "forward", "f" -> { dir[it] = (MoveDirection.FORWARD); it++; }
                case "backward", "b" -> { dir[it] = (MoveDirection.BACKWARD); it++; }
                case "right", "r" -> { dir[it] = (MoveDirection.RIGHT); it++; }
                case "left", "l" -> { dir[it] = (MoveDirection.LEFT); it++; }
            }
        }
        return dir;
    }
}

package agh.ics.oop;

import java.util.ArrayList;

public class World {
    public static void run(Direction[] dir) {
        for (Direction x : dir) {
            if (x != null) {
                String choice = switch (x) {
                    case F -> "Do przodu";
                    case B -> "Do tyłu";
                    case L -> "W lewo";
                    case R -> "W prawo";
                };
                System.out.println(choice);
            }
        }
    }

    public static Direction[] changeToDirection(String[] args) {
        int newSize = args.length;
        Direction[] dir = new Direction[newSize];
        int ind = 0;
        for (String x : args) {
            Direction newX = switch (x) {
                case "f" -> Direction.F;
                case "b" -> Direction.B;
                case "l" -> Direction.L;
                case "r" -> Direction.R;
                default -> null;
            };
            dir[ind] = newX;
            ind++;
        }
        return dir;
    }

    public static void main(String[] args) {
        System.out.println("system wystartował");
//        Direction[] dir = changeToDirection(args);
//        run(dir);
        Animal dog = new Animal();
        System.out.println(dog.toString());
        ArrayList<MoveDirection> dir = new ArrayList<MoveDirection>(OptionsParser.parse(args));
        for (MoveDirection arg : dir) {
            dog.move(arg);
        }
        System.out.println(dog.toString());
        System.out.println("system zatrzymał się");
    }
}


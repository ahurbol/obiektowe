package agh.ics.oop;

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
        Direction[] dir = changeToDirection(args);
        run(dir);

        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println("system zatrzymał się");
    }
}


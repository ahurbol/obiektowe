package agh.ics.oop;

public class World {
    public static void run(Direction[] dir) {
        for (Direction x : dir) {
            String choice = switch (x) {
                case F -> "Do przodu";
                case B -> "Do tyłu";
                case L -> "W lewo";
                case R -> "W prawo";
            };
            System.out.println(choice);
        }
    }

    public static void run(String[] dir) {
        for (String x : dir) {
            String choice = switch (x) {
                case "f" -> "Do przodu";
                case "b" -> "Do tyłu";
                case "l" -> "W lewo";
                case "r" -> "W prawo";
                default -> null;
            };
            if (choice != null) {
                System.out.println(choice);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("system wystartował");
        String[] moves = new String[]{"f", "b", "l", "r"};
        int newSize = 0;
        for (String x : args) {
            for (String move : moves) {
                if (x.equals(move)) {
                    newSize += 1;
                }
            }
        }
        Direction[] dir = new Direction[newSize];
        int ind = 0;
        for (String x : args) {
            switch (x) {
                case "f" -> {
                    dir[ind] = Direction.F;
                    ind++;
                }
                case "b" -> {
                    dir[ind] = Direction.B;
                    ind++;
                }
                case "l" -> {
                    dir[ind] = Direction.L;
                    ind++;
                }
                case "r" -> {
                    dir[ind] = Direction.R;
                    ind++;
                }
                default -> {
                }
            }
        }
        run(dir);
        System.out.println("system zatrzymał się");
    }
}

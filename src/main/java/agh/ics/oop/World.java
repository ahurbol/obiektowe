package agh.ics.oop;
import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        Scanner x = new Scanner(System.in);
        String lett = x.nextLine();
        System.out.println(lett);
        run();
        System.out.println("system zatrzymał się");

    }
    public static void run() {
        System.out.println("zwierzak idzie do przodu");

    }
}

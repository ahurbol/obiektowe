package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    Animal Rick = new Animal();
    Animal Morty = new Animal();

    @Test
    public void everythingTest() {
        String[] listRick = new String[]{"f", "forward", "r", "right", "ooo"};
        ArrayList<MoveDirection> dirRick = new ArrayList<MoveDirection>(OptionsParser.parse(listRick));
        for (MoveDirection arg : dirRick) {
            Rick.move(arg);
        }
        assertEquals(new Vector2d(2, 4), Rick.getPosition());
        assertEquals(MapDirection.SOUTH, Rick.getOrient());

        String[] listMorty = new String[]{"b", "backward", "b", "l", "f", "l"};
        ArrayList<MoveDirection> dirMorty = new ArrayList<MoveDirection>(OptionsParser.parse(listMorty));
        for (MoveDirection arg : dirMorty) {
            Morty.move(arg);
        }
        assertEquals(new Vector2d(1, 0), Morty.getPosition());
        assertEquals(MapDirection.SOUTH, Morty.getOrient());
    }

}

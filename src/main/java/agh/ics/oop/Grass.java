package agh.ics.oop;

public class Grass extends AbstractWorldMapElement {

    public Grass(Vector2d position) {
        this.position = position;
    }

    @Override
    public String getPath() {
        return "src/main/resources/grass.png";
    }
    @Override
    public String toString() {
        return "*";
    }

}

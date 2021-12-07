package agh.ics.oop;

public class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    public int compareX(IMapElement element) {
        Vector2d a = this.getPosition();
        Vector2d b = element.getPosition();
        if (a.x < b.x) return -1;
        if (a.x > b.x) return 1;

        if (a.y < b.y) return -1;
        if (a.y > b.y) return 1;

        if (element instanceof Animal) return -1;
        else return 1;

    };
    public int compareY(IMapElement element) {
        Vector2d a = this.getPosition();
        Vector2d b = element.getPosition();

        if(a.y < b.y) return -1;
        if(a.y > b.y) return 1;

        if(a.x < b.x) return -1;
        if(a.x > b.x) return 1;

        if(element instanceof Animal) return -1;
        else return 1;
    };

}

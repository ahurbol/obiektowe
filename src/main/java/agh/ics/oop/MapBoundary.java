package agh.ics.oop;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<IMapElement> xx = new TreeSet<>(IMapElement::compareX);
    private final SortedSet<IMapElement> yy = new TreeSet<>(IMapElement::compareY);

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        Iterator<IMapElement> itX = xx.iterator();

        while (itX.hasNext()) {
            IMapElement a = itX.next();
            System.out.printf(a.toString());
            System.out.printf(" " + a.getPosition().toString() + " ");
            if (a.getPosition().equals(newPos) ){
                itX.remove();
                xx.add(a);
                break;
            }
        }
        Iterator<IMapElement> itY = yy.iterator();
        System.out.println();
        while (itY.hasNext()) {
            IMapElement a = itY.next();
            System.out.printf(a.toString());
            System.out.printf(" " + a.getPosition().toString() + " ");
            if (a.getPosition().equals(newPos) ) {
                itY.remove();
                yy.add(a);
                break;
            }
        }
        System.out.println();
    }

    public Vector2d findLowerLeft() {

        for (IMapElement a : xx) {
            System.out.printf(a.toString());
        }
        System.out.println();
        for (IMapElement a : yy) {
            System.out.printf(a.toString());
        }
        System.out.println();
        return new Vector2d(xx.first().getPosition().x, yy.first().getPosition().y);
    }

    public Vector2d findUpperRight() {
        return new Vector2d(xx.last().getPosition().x, yy.last().getPosition().y);
    }

    public void addElement(IMapElement a) {
        xx.add(a);
        yy.add(a);
    }

    public void removeElement(IMapElement a){
        xx.remove(a);
        yy.remove(a);
    }
}

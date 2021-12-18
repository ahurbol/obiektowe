package agh.ics.oop;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> xx = new TreeSet<>((Comparator<Vector2d>) (u, v) -> {
        if (u.x == v.x) {
            return u.y - v.y;
        }
        return u.x - v.x;
    });
    SortedSet<Vector2d> yy = new TreeSet<>((Comparator<Vector2d>) (u, v) -> {
        if (u.y == v.y) {
            return u.x - v.x;
        }
        return u.y - v.y;
    });

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        if (!xx.isEmpty()) {
            xx.remove(oldPos);
            yy.remove(oldPos);
        }
        xx.add(newPos);
        yy.add(newPos);
    }

}

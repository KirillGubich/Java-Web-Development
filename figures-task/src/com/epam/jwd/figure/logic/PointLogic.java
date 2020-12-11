package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.model.impl.PointFactory;
import java.util.ArrayList;
import java.util.List;

public class PointLogic {

    public static double getDistance(Point a, Point b) {
        double distance;
        distance = Math.hypot((a.getX() - b.getX()), (a.getY() - b.getY()));

        return distance;
    }

    public static List<Point> createList(int count) {
        List<Point> points = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            points.add(PointFactory.createPoint((int) (Math.random() * 11), (int) (Math.random() * 11)));
        }

        return points;
    }

    public static boolean hasSamePoints(Point... points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {

                if (points[i].equals(points[j])) {
                    return true;
                }
            }
        }

        return false;
    }

}

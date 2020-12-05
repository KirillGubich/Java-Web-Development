package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.PointFactory;

public class PointLogic {

    public static double getDistance(Point a, Point b) {
        double distance;
        distance = Math.hypot((a.getX() - b.getX()), (a.getY() - b.getY()));

        return distance;
    }

    public static Point[] createArray(int count) {
        Point[] points = new Point[count];

        for (int i = 0; i < count; i++) {
            points[i] = PointFactory.createPoint((int) (Math.random() * 11), (int) (Math.random() * 11));
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

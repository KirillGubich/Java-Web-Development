package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.Point;

public class PointLogic {

    public Point createPoint(double x, double y) {

        return new Point(x, y);
    }

    public static double getDistance(Point a, Point b) {
        double distance;
        distance = Math.hypot((a.getX() - b.getX()), (a.getY() - b.getY()));

        return distance;
    }

    public Point[] createArray(int count) {
        Point[] points = new Point[count];

        for (int i = 0; i < count; i++) {
            points[i] = createPoint(i + 2, 5 - i);
        }

        return points;
    }
}

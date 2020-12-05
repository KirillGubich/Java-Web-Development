package com.epam.jwd.figure.model;

public class PointFactory {

    private static final int MAX_AMOUNT_OF_POINTS = 128;
    private static final Point[] ALL_CREATED_POINTS = new Point[MAX_AMOUNT_OF_POINTS];
    private static int amountOfPoints;

    public static Point createPoint(double x, double y) {

        return fetchPointFromCacheOrCreate(x, y);
    }

    private static void addPointToCache(Point point) {
        amountOfPoints++;
        ALL_CREATED_POINTS[amountOfPoints - 1] = point;
    }

    private static Point fetchPointFromCacheOrCreate(double x, double y) {

        for (int i = 0; i < amountOfPoints; i++) {
            if (ALL_CREATED_POINTS[i].getX() == x && ALL_CREATED_POINTS[i].getY() == y) {
                return ALL_CREATED_POINTS[i];
            }
        }

        if (amountOfPoints == MAX_AMOUNT_OF_POINTS) {
            return null;
        }

        Point point = new Point(x, y);
        addPointToCache(point);
        return point;
    }

}

package main.java.com.epam.jwd.figure.model.impl;

public class PointFactory {

    private static final int MAX_AMOUNT_OF_POINTS = 128;
    private static final Point[] allCreatedPoints = new Point[MAX_AMOUNT_OF_POINTS];
    private static int amountOfPoints;

    public static Point createPoint(double x, double y) {

        return fetchPointFromCacheOrCreate(x, y);
    }

    private static void addPointToCache(Point point) {
        amountOfPoints++;
        allCreatedPoints[amountOfPoints - 1] = point;
    }

    private static Point fetchPointFromCacheOrCreate(double x, double y) {

        for (int i = 0; i < amountOfPoints; i++) {
            if (allCreatedPoints[i].getX() == x && allCreatedPoints[i].getY() == y) {
                return allCreatedPoints[i];
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

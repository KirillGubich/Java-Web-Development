package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.Triangle;

public class TriangleLogic {

    private final PointLogic POINT_LOGIC;

    public TriangleLogic(PointLogic POINT_LOGIC) {
        this.POINT_LOGIC = POINT_LOGIC;
    }

    private Triangle createTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        Point a = POINT_LOGIC.createPoint(x1, y1);
        Point b = POINT_LOGIC.createPoint(x2, y2);
        Point c = POINT_LOGIC.createPoint(x3, y3);

        return new Triangle(a, b, c);
    }

    public Triangle[] createArray(int count) {
        Triangle[] triangles = new Triangle[count];

        for (int i = 0; i < count; i++) {
            triangles[i] = createTriangle(2 * i, 4 * i, 1 + i, i - 1, 2 + i, i - 2);
        }

        return triangles;
    }

    public boolean isExist(Triangle triangle) {

        double[] sides;
        sides = fetchTriangleSides(triangle);

        return sides[0] < sides[1] + sides[2] && sides[1] < sides[0] + sides[2] && sides[2] < sides[0] + sides[1];
    }

    public boolean hasSamePoints(Triangle triangle) {

        return triangle.getA().equals(triangle.getB()) ||
               triangle.getA().equals(triangle.getC()) ||
               triangle.getB().equals(triangle.getC());

    }

    private static double[] fetchTriangleSides(Triangle triangle) {

        final int SIDE_COUNT = 3;
        double[] triangleSides = new double[SIDE_COUNT];

        triangleSides[0] = PointLogic.getDistance(triangle.getA(), triangle.getB());
        triangleSides[1] = PointLogic.getDistance(triangle.getB(), triangle.getC());
        triangleSides[2] = PointLogic.getDistance(triangle.getA(), triangle.getC());

        return triangleSides;
    }
}

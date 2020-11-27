package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.PointFactory;
import com.epam.jwd.figure.model.Triangle;
import com.epam.jwd.figure.model.TriangleFactory;

public class TriangleLogic {

    public static Triangle[] createArray(int count) {
        Triangle[] triangles = new Triangle[count];

        for (int i = 0; i < count; i++) {
            Point a = PointFactory.createPoint(2 * i, 4 * i);
            Point b = PointFactory.createPoint(1 + i, i - 1);
            Point c = PointFactory.createPoint(2 + i, i - 2);
            triangles[i] = TriangleFactory.createTriangle(a, b, c);
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

    public static double[] fetchTriangleSides(Triangle triangle) {

        final int SIDE_COUNT = 3;
        double[] triangleSides = new double[SIDE_COUNT];

        triangleSides[0] = PointLogic.getDistance(triangle.getA(), triangle.getB());
        triangleSides[1] = PointLogic.getDistance(triangle.getB(), triangle.getC());
        triangleSides[2] = PointLogic.getDistance(triangle.getA(), triangle.getC());

        return triangleSides;
    }
}

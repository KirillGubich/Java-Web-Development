package com.epam.jwd.figure.model;

public class TriangleFactory {

    private static final int MAX_AMOUNT_OF_TRIANGLES = 16;
    private static final Triangle[] ALL_CREATED_TRIANGLES = new Triangle[MAX_AMOUNT_OF_TRIANGLES];
    private static int amountOfTriangles;

    public static Triangle createTriangle(Point a, Point b, Point c) {

        return fetchTriangleFromCacheOrCreate(a, b, c);
    }

    private static void addTriangleToCache(Triangle triangle) {
        amountOfTriangles++;
        ALL_CREATED_TRIANGLES[amountOfTriangles - 1] = triangle;
    }

    private static Triangle fetchTriangleFromCacheOrCreate(Point a, Point b, Point c) {

        for (int i = 0; i < amountOfTriangles; i++) {
            if (ALL_CREATED_TRIANGLES[i].getA().equals(a) && ALL_CREATED_TRIANGLES[i].getB().equals(b) &&
                    ALL_CREATED_TRIANGLES[i].getC().equals(c)) {
                return ALL_CREATED_TRIANGLES[i];
            }
        }

        if (amountOfTriangles == MAX_AMOUNT_OF_TRIANGLES) {
            return null;
        }

        Triangle triangle = new Triangle(a, b, c);
        addTriangleToCache(triangle);
        return triangle;
    }

}

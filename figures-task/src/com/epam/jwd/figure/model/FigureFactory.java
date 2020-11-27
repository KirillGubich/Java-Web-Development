package com.epam.jwd.figure.model;

import java.util.Arrays;

public class FigureFactory {

    private static final int MAX_AMOUNT_OF_LINES = 32;
    private static final Line[] ALL_CREATED_LINES = new Line[MAX_AMOUNT_OF_LINES];
    private static int amountOfLines;

    private static final int MAX_AMOUNT_OF_TRIANGLES = 16;
    private static final Triangle[] ALL_CREATED_TRIANGLES = new Triangle[MAX_AMOUNT_OF_TRIANGLES];
    private static int amountOfTriangles;

    private static final int MAX_AMOUNT_OF_SQUARES = 8;
    private static final Square[] ALL_CREATED_SQUARES = new Square[MAX_AMOUNT_OF_SQUARES];
    private static int amountOfSquares;

    private static final int MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES = 8;
    private static final MultiAngleFigure[] ALL_CREATED_MULTI_ANGLE_FIGURES =
            new MultiAngleFigure[MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES];
    private static int amountOfMultiAngleFigures;


    public static Figure createFigure(String figureName, Point... figurePoints) {
        switch (figureName) {
            case "Line":
                return fetchLineFromCacheOrCreate(figurePoints[0], figurePoints[1]);
            case "Triangle":
                return fetchTriangleFromCacheOrCreate(figurePoints[0], figurePoints[1], figurePoints[2]);
            case "Square":
                return fetchSquareFromCacheOrCreate(figurePoints[0], figurePoints[1], figurePoints[2], figurePoints[3]);
            case "MultiAngleFigure":
                return fetchMultiAngleFigureFromCacheOrCreate(figurePoints);
            default:
                return null;
        }
    }

    private static void addLineToCache(Line line) {
        amountOfLines++;
        ALL_CREATED_LINES[amountOfLines - 1] = line;
    }

    private static Line fetchLineFromCacheOrCreate(Point a, Point b) {

        for (int i = 0; i < amountOfLines; i++) {
            if (ALL_CREATED_LINES[i].getA().equals(a) && ALL_CREATED_LINES[i].getB().equals(b)) {
                return ALL_CREATED_LINES[i];
            }
        }

        if (amountOfLines == MAX_AMOUNT_OF_LINES) {
            return null;
        }

        Line line = new Line(a, b);
        addLineToCache(line);
        return line;
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

    private static void addSquareToCache(Square square) {
        amountOfSquares++;
        ALL_CREATED_SQUARES[amountOfSquares - 1] = square;
    }

    private static Square fetchSquareFromCacheOrCreate(Point a, Point b, Point c, Point d) {

        for (int i = 0; i < amountOfSquares; i++) {
            if (ALL_CREATED_SQUARES[i].getA().equals(a) && ALL_CREATED_SQUARES[i].getB().equals(b) &&
                    ALL_CREATED_SQUARES[i].getC().equals(c) && ALL_CREATED_SQUARES[i].getD().equals(d)) {
                return ALL_CREATED_SQUARES[i];
            }
        }

        if (amountOfSquares == MAX_AMOUNT_OF_SQUARES) {
            return null;
        }

        Square square = new Square(a, b, c, d);
        addSquareToCache(square);
        return square;
    }

    private static void addMultiAngleFigureToCache(MultiAngleFigure multiAngleFigure) {
        amountOfMultiAngleFigures++;
        ALL_CREATED_MULTI_ANGLE_FIGURES[amountOfMultiAngleFigures - 1] = multiAngleFigure;
    }

    private static MultiAngleFigure fetchMultiAngleFigureFromCacheOrCreate(Point[] points) {

        for (int i = 0; i < amountOfMultiAngleFigures; i++) {
            if (Arrays.equals(ALL_CREATED_MULTI_ANGLE_FIGURES[i].getPoints(), points)) {
                return ALL_CREATED_MULTI_ANGLE_FIGURES[i];
            }
        }

        if (amountOfMultiAngleFigures == MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES) {
            return null;
        }

        MultiAngleFigure multiAngleFigure = new MultiAngleFigure(points);
        addMultiAngleFigureToCache(multiAngleFigure);
        return multiAngleFigure;
    }

}

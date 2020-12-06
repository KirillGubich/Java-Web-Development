package com.epam.jwd.figure.model;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.exception.NumberOfFiguresExceededException;
import com.epam.jwd.figure.service.FigurePostProcessor;
import com.epam.jwd.figure.service.FigurePreProcessor;
import com.epam.jwd.figure.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.figure.service.impl.FigureHasSamePointsPreProcessor;

import java.util.Arrays;

public class FigureFactory {

    private static final FigurePreProcessor[] FIGURE_PRE_PROCESSORS = {FigureHasSamePointsPreProcessor.getInstance()};
    private static final FigurePostProcessor[] FIGURE_POST_PROCESSORS = {FigureExistencePostProcessor.getInstance()};

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

    public static Figure createFigure(String figureName, Point... figurePoints) throws FigureException {

        for (FigurePreProcessor figurePreProcessor : FIGURE_PRE_PROCESSORS) {
            figurePoints = figurePreProcessor.process(figurePoints);
        }

        Figure figure;
        figure = fetchFigureFromCache(figureName, figurePoints);

        if (figure == null) {
            figure = createNewFigure(figureName, figurePoints);
        }

        for (FigurePostProcessor figurePostProcessor : FIGURE_POST_PROCESSORS) {
            figure = figurePostProcessor.process(figure);
        }

        addFigureToCache(figureName, figure);
        return figure;
    }

    private static Figure fetchFigureFromCache(String figureName, Point... figurePoints) throws FigureException {
        Figure figure;

        switch (figureName) {
            case "Line":
                figure = fetchLineFromCache(figurePoints[0], figurePoints[1]);
                break;
            case "Triangle":
                figure = fetchTriangleFromCache(figurePoints[0], figurePoints[1], figurePoints[2]);
                break;
            case "Square":
                figure = fetchSquareFromCache(figurePoints[0], figurePoints[1], figurePoints[2], figurePoints[3]);
                break;
            case "MultiAngleFigure":
                figure = fetchMultiAngleFigureFromCache(figurePoints);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    private static Figure createNewFigure(String figureName, Point... figurePoints) throws FigureException {
        Figure figure;

        switch (figureName) {
            case "Line":
                figure = new Line(figurePoints[0], figurePoints[1]);
                break;
            case "Triangle":
                figure = new Triangle(figurePoints[0], figurePoints[1], figurePoints[2]);
                break;
            case "Square":
                figure = new Square(figurePoints[0], figurePoints[1], figurePoints[2], figurePoints[3]);
                break;
            case "MultiAngleFigure":
                figure = new MultiAngleFigure(figurePoints);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    private static void addFigureToCache(String figureName, Figure figure) throws FigureException {

        switch (figureName) {
            case "Line":
                addLineToCache((Line) figure);
                break;
            case "Triangle":
                addTriangleToCache((Triangle) figure);
                break;
            case "Square":
                addSquareToCache((Square) figure);
                break;
            case "MultiAngleFigure":
                addMultiAngleFigureToCache((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }

    private static void addLineToCache(Line line) throws FigureException {

        if (amountOfLines == MAX_AMOUNT_OF_LINES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfLines++;
        ALL_CREATED_LINES[amountOfLines - 1] = line;
    }

    private static Line fetchLineFromCache(Point a, Point b) {

        for (int i = 0; i < amountOfLines; i++) {
            if (ALL_CREATED_LINES[i].getA().equals(a) && ALL_CREATED_LINES[i].getB().equals(b)) {
                return ALL_CREATED_LINES[i];
            }
        }

        return null;
    }

    private static void addTriangleToCache(Triangle triangle) throws FigureException {

        if (amountOfTriangles == MAX_AMOUNT_OF_TRIANGLES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfTriangles++;
        ALL_CREATED_TRIANGLES[amountOfTriangles - 1] = triangle;
    }

    private static Triangle fetchTriangleFromCache(Point a, Point b, Point c) throws FigureException {

        for (int i = 0; i < amountOfTriangles; i++) {
            if (ALL_CREATED_TRIANGLES[i].getA().equals(a) && ALL_CREATED_TRIANGLES[i].getB().equals(b) &&
                    ALL_CREATED_TRIANGLES[i].getC().equals(c)) {
                return ALL_CREATED_TRIANGLES[i];
            }
        }

        return null;
    }

    private static void addSquareToCache(Square square) throws FigureException {

        if (amountOfSquares == MAX_AMOUNT_OF_SQUARES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfSquares++;
        ALL_CREATED_SQUARES[amountOfSquares - 1] = square;
    }

    private static Square fetchSquareFromCache(Point a, Point b, Point c, Point d) {

        for (int i = 0; i < amountOfSquares; i++) {
            if (ALL_CREATED_SQUARES[i].getA().equals(a) && ALL_CREATED_SQUARES[i].getB().equals(b) &&
                    ALL_CREATED_SQUARES[i].getC().equals(c) && ALL_CREATED_SQUARES[i].getD().equals(d)) {
                return ALL_CREATED_SQUARES[i];
            }
        }

        return null;
    }

    private static void addMultiAngleFigureToCache(MultiAngleFigure multiAngleFigure) throws FigureException {

        if (amountOfMultiAngleFigures == MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfMultiAngleFigures++;
        ALL_CREATED_MULTI_ANGLE_FIGURES[amountOfMultiAngleFigures - 1] = multiAngleFigure;
    }

    private static MultiAngleFigure fetchMultiAngleFigureFromCache(Point[] points) {

        for (int i = 0; i < amountOfMultiAngleFigures; i++) {
            if (Arrays.equals(ALL_CREATED_MULTI_ANGLE_FIGURES[i].getPOINTS(), points)) {
                return ALL_CREATED_MULTI_ANGLE_FIGURES[i];
            }
        }

        return null;
    }

}

package com.epam.jwd.figure.storage;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.NumberOfFiguresExceededException;
import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.model.impl.MultiAngleFigure;
import com.epam.jwd.figure.model.impl.Square;
import com.epam.jwd.figure.model.impl.Triangle;

public class FigureStorage {

    private static FigureStorage instance;

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

    private FigureStorage() {
    }

    public static FigureStorage getInstance() {
        if (instance == null) {
            instance = new FigureStorage();
        }

        return instance;
    }

    public void addLineToStorage(Line line) throws FigureException {

        if (amountOfLines == MAX_AMOUNT_OF_LINES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfLines++;
        ALL_CREATED_LINES[amountOfLines - 1] = line;
    }

    public Line fetchLineFromStorage(Line line) {

        for (int i = 0; i < amountOfLines; i++) {
            if (ALL_CREATED_LINES[i].equals(line)) {
                return ALL_CREATED_LINES[i];
            }
        }

        return null;
    }

    public void addTriangleToStorage(Triangle triangle) throws FigureException {

        if (amountOfTriangles == MAX_AMOUNT_OF_TRIANGLES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfTriangles++;
        ALL_CREATED_TRIANGLES[amountOfTriangles - 1] = triangle;
    }

    public Triangle fetchTriangleFromStorage(Triangle triangle) throws FigureException {

        for (int i = 0; i < amountOfTriangles; i++) {
            if (ALL_CREATED_TRIANGLES[i].equals(triangle)) {
                return ALL_CREATED_TRIANGLES[i];
            }
        }

        return null;
    }

    public void addSquareToStorage(Square square) throws FigureException {

        if (amountOfSquares == MAX_AMOUNT_OF_SQUARES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfSquares++;
        ALL_CREATED_SQUARES[amountOfSquares - 1] = square;
    }

    public Square fetchSquareFromStorage(Square square) {

        for (int i = 0; i < amountOfSquares; i++) {
            if (ALL_CREATED_SQUARES[i].equals(square)) {
                return ALL_CREATED_SQUARES[i];
            }
        }

        return null;
    }

    public void addMultiAngleFigureToStorage(MultiAngleFigure multiAngleFigure) throws FigureException {

        if (amountOfMultiAngleFigures == MAX_AMOUNT_OF_MULTI_ANGLE_FIGURES) {
            throw new NumberOfFiguresExceededException("Number of figures exceeded");
        }

        amountOfMultiAngleFigures++;
        ALL_CREATED_MULTI_ANGLE_FIGURES[amountOfMultiAngleFigures - 1] = multiAngleFigure;
    }

    public MultiAngleFigure fetchMultiAngleFigureFromStorage(MultiAngleFigure multiAngleFigure) {

        for (int i = 0; i < amountOfMultiAngleFigures; i++) {
            if (ALL_CREATED_MULTI_ANGLE_FIGURES[i].equals(multiAngleFigure)) {
                return ALL_CREATED_MULTI_ANGLE_FIGURES[i];
            }
        }

        return null;
    }

}

package com.epam.jwd.figure.storage;

import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.model.impl.MultiAngleFigure;
import com.epam.jwd.figure.model.impl.Square;
import com.epam.jwd.figure.model.impl.Triangle;
import java.util.ArrayList;
import java.util.List;

public class FigureStorage {

    private static FigureStorage instance;

    private static final List<Line> ALL_CREATED_LINES = new ArrayList<>();
    private static final List<Triangle> ALL_CREATED_TRIANGLES = new ArrayList<>();
    private static final List<Square> ALL_CREATED_SQUARES = new ArrayList<>();
    private static final List<MultiAngleFigure> ALL_CREATED_MULTI_ANGLE_FIGURES = new ArrayList<>();

    private FigureStorage() {
    }

    public static FigureStorage getInstance() {
        if (instance == null) {
            instance = new FigureStorage();
        }

        return instance;
    }

    public void addLineToStorage(Line line) {
        ALL_CREATED_LINES.add(line);
    }

    public Line fetchLineFromStorage(Line line) {
        for (Line storageLine : ALL_CREATED_LINES) {
            if (storageLine.equals(line)) {
                return storageLine;
            }
        }

        return null;
    }

    public void addTriangleToStorage(Triangle triangle){
        ALL_CREATED_TRIANGLES.add(triangle);
    }

    public Triangle fetchTriangleFromStorage(Triangle triangle) {
        for (Triangle storageTriangle : ALL_CREATED_TRIANGLES) {
            if (storageTriangle.equals(triangle)) {
                return storageTriangle;
            }
        }

        return null;
    }

    public void addSquareToStorage(Square square) {
        ALL_CREATED_SQUARES.add(square);
    }

    public Square fetchSquareFromStorage(Square square) {
        for (Square storageSquare : ALL_CREATED_SQUARES) {
            if (storageSquare.equals(square)) {
                return storageSquare;
            }
        }

        return null;
    }

    public void addMultiAngleFigureToStorage(MultiAngleFigure multiAngleFigure) {
        ALL_CREATED_MULTI_ANGLE_FIGURES.add(multiAngleFigure);
    }

    public MultiAngleFigure fetchMultiAngleFigureFromStorage(MultiAngleFigure multiAngleFigure) {
        for (MultiAngleFigure storageMultiAngleFigure : ALL_CREATED_MULTI_ANGLE_FIGURES) {
            if (storageMultiAngleFigure.equals(multiAngleFigure)) {
                return storageMultiAngleFigure;
            }
        }

        return null;
    }

}

package com.epam.jwd.figure.app;

import com.epam.jwd.figure.logic.LineLogic;
import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.logic.SquareLogic;
import com.epam.jwd.figure.model.Line;
import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.Square;
import com.epam.jwd.figure.model.Triangle;
import com.epam.jwd.figure.logic.TriangleLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        PointLogic pointLogic = new PointLogic();
        LineLogic lineLogic = new LineLogic(pointLogic);
        TriangleLogic triangleLogic = new TriangleLogic(pointLogic);
        SquareLogic squareLogic = new SquareLogic(pointLogic);

        Point[] points = pointLogic.createArray(4);
        Line[] lines = lineLogic.createArray(2);
        Triangle[] triangles = triangleLogic.createArray(2);
        Square[] squares = squareLogic.createArray(1);

        outputPoints(points);
        outputLines(lines, lineLogic);
        OutputTriangles(triangles, triangleLogic);
        OutputSquares(squares, squareLogic);
    }

    private static void outputPoints(Point[] points) {
        int i = 0;
        do {
            LOGGER.info(points[i]);
            i++;
        } while (i < points.length);
    }

    private static void outputLines(Line[] lines, LineLogic lineLogic) {
        for (Line line : lines) {
            if (!lineLogic.hasSamePoints(line)) {
                LOGGER.info(line);

            } else {
                LOGGER.error("Object " + line + " is not a line");
            }
        }
    }

    private static void OutputTriangles(Triangle[] triangles, TriangleLogic triangleLogic) {
        for (Triangle triangle : triangles) {
            if (triangleLogic.isExist(triangle)) {
                LOGGER.info(triangle);
            } else if (triangleLogic.hasSamePoints(triangle)) {
                LOGGER.error("Object " + triangle + " is not a triangle shape");
            } else {
                LOGGER.error(triangle + " can not exist");
            }
        }
    }

    private static void OutputSquares(Square[] squares, SquareLogic squareLogic) {
        for (Square square : squares) {
            if (squareLogic.isExist(square)) {
                LOGGER.info(square);
            } else if (squareLogic.hasSamePoints(square)) {
                LOGGER.error("Object " + square + " is not a square shape");
            } else {
                LOGGER.error("Объект " + square + " is not a square");
            }
        }
    }

}

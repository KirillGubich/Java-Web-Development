package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.Square;

public class SquareLogic {

    private final PointLogic POINT_LOGIC;

    public SquareLogic(PointLogic POINT_LOGIC) {
        this.POINT_LOGIC = POINT_LOGIC;
    }

    private Square createSquare(double x1, double y1, double x2, double y2,
                                double x3, double y3, double x4, double y4) {

        Point a = POINT_LOGIC.createPoint(x1, y1);
        Point b = POINT_LOGIC.createPoint(x2, y2);
        Point c = POINT_LOGIC.createPoint(x3, y3);
        Point d = POINT_LOGIC.createPoint(x4, y4);

        return new Square(a, b, c, d);
    }

    public Square[] createArray(int count) {
        Square[] squares = new Square[count];

        for (int i = 0; i < count; i++) {
            squares[i] = createSquare(i, 0, i + 2, 0, i + 2, i + 2, 0, i + 2);
        }

        return squares;
    }

    public boolean isExist(Square square) {

        double[] sides;
        sides = fetchSquareSides(square);

        for (int i = 0; i < sides.length - 1; i++) {
            if (sides[i] != sides[i+1]) {
                return false;
            }
        }

        double firstDiagonal;
        double secondDiagonal;

        firstDiagonal = PointLogic.getDistance(square.getA(), square.getC());
        secondDiagonal = PointLogic.getDistance(square.getB(), square.getD());

        return firstDiagonal == secondDiagonal;
    }

    public boolean hasSamePoints(Square square) {

        return square.getA().equals(square.getB()) ||
               square.getA().equals(square.getC()) ||
               square.getB().equals(square.getC()) ||
               square.getD().equals(square.getA()) ||
               square.getD().equals(square.getB()) ||
               square.getD().equals(square.getC());
    }

    private static double[] fetchSquareSides(Square square) {

        final int SIDE_COUNT = 4;
        double[] sqrSides = new double[SIDE_COUNT];

        sqrSides[0] = PointLogic.getDistance(square.getA(), square.getB());
        sqrSides[1] = PointLogic.getDistance(square.getB(), square.getC());
        sqrSides[2] = PointLogic.getDistance(square.getC(), square.getD());
        sqrSides[3] = PointLogic.getDistance(square.getD(), square.getA());

        return sqrSides;
    }

}

package com.epam.jwd.figure.logic;

import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.model.PointFactory;
import com.epam.jwd.figure.model.Square;
import com.epam.jwd.figure.model.SquareFactory;

public class SquareLogic {

    public static Square[] createArray(int count) {
        Square[] squares = new Square[count];

        for (int i = 0; i < count; i++) {
            Point a = PointFactory.createPoint(i, 0);
            Point b = PointFactory.createPoint(i + 2, 0);
            Point c = PointFactory.createPoint(i + 2, i + 2);
            Point d = PointFactory.createPoint(0, i + 2);

            squares[i] = SquareFactory.createSquare(a, b, c, d);
        }

        return squares;
    }

    public boolean isExist(Square square) {

        double[] sides;
        sides = fetchSquareSides(square);

        for (int i = 0; i < sides.length - 1; i++) {
            if (sides[i] != sides[i + 1]) {
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

package com.epam.jwd.figure.model;

public class SquareFactory {

    private static final int MAX_AMOUNT_OF_SQUARES = 8;
    private static final Square[] ALL_CREATED_SQUARES = new Square[MAX_AMOUNT_OF_SQUARES];
    private static int amountOfSquares;

    public static Square createSquare(Point a, Point b, Point c, Point d) {

        return fetchSquareFromCacheOrCreate(a, b, c, d);
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
}

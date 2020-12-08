package com.epam.jwd.figure.model.impl;

import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.logic.SquareLogic;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.strategy.SquarePropertiesStrategy;

import java.util.Objects;

public class Square extends Figure {

    private final Point A;
    private final Point B;
    private final Point C;
    private final Point D;

    Square(Point a, Point b, Point c, Point d) {
        super(SquarePropertiesStrategy.getInstance(), FigureType.SQUARE);
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public Point getC() {
        return C;
    }

    public Point getD() {
        return D;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(A, square.A) &&
                Objects.equals(B, square.B) &&
                Objects.equals(C, square.C) &&
                Objects.equals(D, square.D);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C, D);
    }

    @Override
    public String toString() {
        return "Square: a = " + A + ", b = " + B + ", c = " + C + ", d = " + D;
    }

    @Override
    public boolean isExist() {

        double[] sides;
        sides = SquareLogic.getInstance().fetchSquareSides(this);

        for (int i = 0; i < sides.length - 1; i++) {
            if (sides[i] != sides[i + 1]) {
                return false;
            }
        }

        return PointLogic.getDistance(A, C) == PointLogic.getDistance(B, D);
    }
}

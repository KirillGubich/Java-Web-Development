package main.java.com.epam.jwd.figure.model.impl;

import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.logic.SquareLogic;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.strategy.SquarePropertiesStrategy;

import java.util.Objects;

public class Square extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    Square(Point a, Point b, Point c, Point d) {
        super(SquarePropertiesStrategy.getInstance(), FigureType.SQUARE);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(a, square.a) &&
                Objects.equals(b, square.b) &&
                Objects.equals(c, square.c) &&
                Objects.equals(d, square.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Square: a = " + a + ", b = " + b + ", c = " + c + ", d = " + d;
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

        return PointLogic.getDistance(a, c) == PointLogic.getDistance(b, d);
    }
}

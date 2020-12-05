package com.epam.jwd.figure.model;

import com.epam.jwd.figure.logic.TriangleLogic;
import com.epam.jwd.figure.strategy.TrianglePropertiesStrategy;

import java.util.Objects;

public class Triangle extends Figure {

    private final Point A;
    private final Point B;
    private final Point C;

    Triangle(Point a, Point b, Point c) {
        super(TrianglePropertiesStrategy.getInstance());
        this.A = a;
        this.B = b;
        this.C = c;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(A, triangle.A) &&
                Objects.equals(B, triangle.B) &&
                Objects.equals(C, triangle.C);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C);
    }

    @Override
    public String toString() {
        return "Triangle: a = " + A + ", b = " + B + ", c = " + C;
    }

    @Override
    public boolean isExist() {

        double[] sides;
        sides = TriangleLogic.getInstance().fetchTriangleSides(this);

        return sides[0] < sides[1] + sides[2] && sides[1] < sides[0] + sides[2] && sides[2] < sides[0] + sides[1];
    }
}

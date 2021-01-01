package main.java.com.epam.jwd.figure.model.impl;

import main.java.com.epam.jwd.figure.logic.TriangleLogic;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.strategy.TrianglePropertiesStrategy;

import java.util.Objects;

public class Triangle extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;

    Triangle(Point a, Point b, Point c) {
        super(TrianglePropertiesStrategy.getInstance(), FigureType.TRIANGLE);
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(a, triangle.a) &&
                Objects.equals(b, triangle.b) &&
                Objects.equals(c, triangle.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Triangle: a = " + a + ", b = " + b + ", c = " + c;
    }

    @Override
    public boolean isExist() {

        double[] sides;
        sides = TriangleLogic.getInstance().fetchTriangleSides(this);

        return sides[0] < sides[1] + sides[2] && sides[1] < sides[0] + sides[2] && sides[2] < sides[0] + sides[1];
    }
}

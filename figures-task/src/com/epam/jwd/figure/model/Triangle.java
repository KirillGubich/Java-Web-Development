package com.epam.jwd.figure.model;

import com.epam.jwd.figure.strategy.FigurePropertiesStrategy;
import com.epam.jwd.figure.strategy.TrianglePropertiesStrategy;

import java.util.Objects;

public class Triangle extends Figure{

    private Point a;
    private Point b;
    private Point c;

    Triangle(Point a, Point b, Point c) {
        super(TrianglePropertiesStrategy.getInstance());
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
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
}

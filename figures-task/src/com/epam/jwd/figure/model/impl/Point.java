package com.epam.jwd.figure.model.impl;

import java.util.Objects;

public class Point {

    private final double X;
    private final double Y;

    Point(double x, double y) {
        this.X = x;
        this.Y = y;
    }

    Point() {
        X = 0.0;
        Y = 0.0;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.X, X) == 0 &&
                Double.compare(point.Y, Y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }

    @Override
    public String toString() {
        return "("+ X + ", " + Y + ")";
    }
}

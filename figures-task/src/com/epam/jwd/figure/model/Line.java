package com.epam.jwd.figure.model;

import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.strategy.LinePropertiesStrategy;

import java.util.Objects;

public class Line extends Figure {

    private final Point A;
    private final Point B;

    Line(Point a, Point b) {
        super(LinePropertiesStrategy.INSTANCE);
        this.A = a;
        this.B = b;
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(A, line.A) &&
                Objects.equals(B, line.B);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B);
    }

    @Override
    public String toString() {
        return "Line: a = " + A + ", b = " + B;
    }

    @Override
    public boolean isExist() {

        return !(PointLogic.hasSamePoints(this.getA(), this.getB()));
    }
}

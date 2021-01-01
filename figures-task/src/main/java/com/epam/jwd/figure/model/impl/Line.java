package main.java.com.epam.jwd.figure.model.impl;

import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.strategy.LinePropertiesStrategy;

import java.util.Objects;

public class Line extends Figure {

    private final Point a;
    private final Point b;

    Line(Point a, Point b) {
        super(LinePropertiesStrategy.INSTANCE, FigureType.LINE);
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(a, line.a) && Objects.equals(b, line.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Line: a = " + a + ", b = " + b;
    }

    @Override
    public boolean isExist() {

        return !(PointLogic.hasSamePoints(this.getA(), this.getB()));
    }
}

package com.epam.jwd.figure.model;

import com.epam.jwd.figure.strategy.FigurePropertiesStrategy;
import com.epam.jwd.figure.strategy.LinePropertiesStrategy;

import java.util.Objects;

public class Line extends Figure{

    private Point a;
    private Point b;

    Line(Point a, Point b) {
        super(LinePropertiesStrategy.INSTANCE);
        this.a = a;
        this.b = b;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(a, line.a) &&
                Objects.equals(b, line.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return  "Line: a = " + a + ", b = " + b;
    }
}

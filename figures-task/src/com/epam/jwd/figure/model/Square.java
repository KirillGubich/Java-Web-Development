package com.epam.jwd.figure.model;

import com.epam.jwd.figure.strategy.FigurePropertiesStrategy;
import com.epam.jwd.figure.strategy.SquarePropertiesStrategy;

import java.util.Objects;

public class Square extends Figure{

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    Square(Point a, Point b, Point c, Point d) {
        super(SquarePropertiesStrategy.getInstance());
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
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
}

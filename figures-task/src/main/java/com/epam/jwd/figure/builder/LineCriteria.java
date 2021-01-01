package main.java.com.epam.jwd.figure.builder;

import main.java.com.epam.jwd.figure.model.impl.Point;

import java.util.Objects;

public class LineCriteria extends FigureCriteria {

    private final Point a;
    private final Point b;

    public LineCriteria(double perimeter, double area, double minPerimeter, double maxPerimeter, double minArea, double maxArea, Point a, Point b) {
        super(perimeter, area, minPerimeter, maxPerimeter, minArea, maxArea);
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
        LineCriteria that = (LineCriteria) o;
        return Objects.equals(a, that.a) && Objects.equals(b, that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "LineCriteria{" +
                "A=" + a +
                ", B=" + b +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Point a;
        private Point b;
        private double length;
        private double minLength;
        private double maxLength;


        public Builder pointAEquals(Point a) {
            this.a = a;
            return this;
        }

        public Builder pointBEquals(Point b) {
            this.b = b;
            return this;
        }

        public Builder lengthEquals(double length) {
            this.length = length;
            return this;
        }

        public Builder lengthGreaterThen(double minLength) {
            this.minLength = minLength;
            return this;
        }

        public Builder lengthLessThen(double maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public LineCriteria build() {
            return new LineCriteria(this.length,
                    0,
                    this.minLength,
                    this.maxLength,
                    0,
                    0,
                    this.a,
                    this.b);
        }
    }
}

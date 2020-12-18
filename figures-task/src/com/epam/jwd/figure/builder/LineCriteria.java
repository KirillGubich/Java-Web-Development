package com.epam.jwd.figure.builder;

import com.epam.jwd.figure.model.impl.Point;

import java.util.Objects;

public class LineCriteria extends FigureCriteria {

    private final Point A;
    private final Point B;

    public LineCriteria(double PERIMETER, double AREA, double MIN_PERIMETER, double MAX_PERIMETER, double MIN_AREA, double MAX_AREA, Point a, Point b) {
        super(PERIMETER, AREA, MIN_PERIMETER, MAX_PERIMETER, MIN_AREA, MAX_AREA);
        A = a;
        B = b;
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
        LineCriteria that = (LineCriteria) o;
        return Objects.equals(A, that.A) && Objects.equals(B, that.B);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B);
    }

    @Override
    public String toString() {
        return "LineCriteria{" +
                "A=" + A +
                ", B=" + B +
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

package com.epam.jwd.figure.builder;

import com.epam.jwd.figure.model.impl.Point;

import java.util.Objects;

public class SquareCriteria extends FigureCriteria {

    private final Point A;
    private final Point B;
    private final Point C;
    private final Point D;

    public SquareCriteria(double PERIMETER, double AREA, double MIN_PERIMETER, double MAX_PERIMETER, double MIN_AREA, double MAX_AREA, Point a, Point b, Point c, Point d) {
        super(PERIMETER, AREA, MIN_PERIMETER, MAX_PERIMETER, MIN_AREA, MAX_AREA);
        A = a;
        B = b;
        C = c;
        D = d;
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

    public Point getD() {
        return D;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareCriteria that = (SquareCriteria) o;
        return Objects.equals(A, that.A) && Objects.equals(B, that.B) && Objects.equals(C, that.C) && Objects.equals(D, that.D);
    }

    @Override
    public int hashCode() {
        return Objects.hash(A, B, C, D);
    }

    @Override
    public String toString() {
        return "SquareCriteria{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                ", D=" + D +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Point a;
        private Point b;
        private Point c;
        private Point d;
        private double perimeter;
        private double area;
        private double minPerimeter;
        private double maxPerimeter;
        private double minArea;
        private double maxArea;

        public Builder pointAEquals(Point a) {
            this.a = a;
            return this;
        }

        public Builder pointBEquals(Point b) {
            this.b = b;
            return this;
        }

        public Builder pointCEquals(Point c) {
            this.c = c;
            return this;
        }

        public Builder pointDEquals(Point d) {
            this.d = d;
            return this;
        }

        public Builder perimeterEquals(double perimeter) {
            this.perimeter = perimeter;
            return this;
        }

        public Builder perimeterGreaterThen(double minPerimeter) {
            this.minPerimeter = minPerimeter;
            return this;
        }

        public Builder perimeterLessThen(double maxPerimeter) {
            this.maxPerimeter = maxPerimeter;
            return this;
        }

        public Builder areaEquals(double area) {
            this.area = area;
            return this;
        }

        public Builder AreaGreaterThen(double minArea) {
            this.minArea = minArea;
            return this;
        }

        public Builder AreaLessThen(double maxArea) {
            this.maxArea = maxArea;
            return this;
        }

        public SquareCriteria build() {
            return new SquareCriteria(this.perimeter,
                    this.area,
                    this.minPerimeter,
                    this.maxPerimeter,
                    this.minArea,
                    this.maxArea,
                    this.a,
                    this.b,
                    this.c,
                    this.d);
        }
    }
}

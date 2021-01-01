package main.java.com.epam.jwd.figure.builder;

import main.java.com.epam.jwd.figure.model.impl.Point;

import java.util.Objects;

public class SquareCriteria extends FigureCriteria {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public SquareCriteria(double perimeter, double area, double minPerimeter, double maxPerimeter, double minArea, double maxArea, Point a, Point b, Point c, Point d) {
        super(perimeter, area, minPerimeter, maxPerimeter, minArea, maxArea);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Point getD() {
        return d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareCriteria that = (SquareCriteria) o;
        return Objects.equals(a, that.a) && Objects.equals(b, that.b) && Objects.equals(c, that.c) && Objects.equals(d, that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "SquareCriteria{" +
                "A=" + a +
                ", B=" + b +
                ", C=" + c +
                ", D=" + d +
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

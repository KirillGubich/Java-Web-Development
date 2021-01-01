package main.java.com.epam.jwd.figure.builder;

import java.util.Objects;

public class MultiAngleFigureCriteria extends FigureCriteria {

    private final int amountOfAngles;
    private final int minAmountOfAngles;
    private final int maxAmountOfAngles;

    public MultiAngleFigureCriteria(double perimeter, double area, double minPerimeter, double maxPerimeter, double minArea, double maxArea, int amountOfAngles, int minAmountOfAngles, int maxAmountOfAngles) {
        super(perimeter, area, minPerimeter, maxPerimeter, minArea, maxArea);
        this.amountOfAngles = amountOfAngles;
        this.minAmountOfAngles = minAmountOfAngles;
        this.maxAmountOfAngles = maxAmountOfAngles;
    }

    public int getAmountOfAngles() {
        return amountOfAngles;
    }

    public int getMinAmountOfAngles() {
        return minAmountOfAngles;
    }

    public int getMaxAmountOfAngles() {
        return maxAmountOfAngles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigureCriteria that = (MultiAngleFigureCriteria) o;
        return amountOfAngles == that.amountOfAngles && minAmountOfAngles == that.minAmountOfAngles && maxAmountOfAngles == that.maxAmountOfAngles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountOfAngles, minAmountOfAngles, maxAmountOfAngles);
    }

    @Override
    public String toString() {
        return "MultiAngleFigureCriteria{" +
                "AMOUNT_OF_ANGLES=" + amountOfAngles +
                ", MIN_AMOUNT_OF_ANGLES=" + minAmountOfAngles +
                ", MAX_AMOUNT_OF_ANGLES=" + maxAmountOfAngles +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int amountOfAngles;
        private double perimeter;
        private double area;
        private int minAmountOfAngles;
        private int maxAmountOfAngles;
        private double minPerimeter;
        private double maxPerimeter;
        private double minArea;
        private double maxArea;

        public Builder amountOfAnglesEquals(int amountOfAngles) {
            this.amountOfAngles = amountOfAngles;
            return this;
        }

        public Builder amountOfAnglesGreaterThen(int minAmountOfAngles) {
            this.minAmountOfAngles = minAmountOfAngles;
            return this;
        }

        public Builder amountOfAnglesLessThan(int maxAmountOfAngles) {
            this.maxAmountOfAngles = maxAmountOfAngles;
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

        public MultiAngleFigureCriteria build() {
            return new MultiAngleFigureCriteria(
                    this.perimeter,
                    this.area,
                    this.minPerimeter,
                    this.maxPerimeter,
                    this.minArea,
                    this.maxArea,
                    this.amountOfAngles,
                    this.minAmountOfAngles,
                    this.maxAmountOfAngles);
        }
    }
}

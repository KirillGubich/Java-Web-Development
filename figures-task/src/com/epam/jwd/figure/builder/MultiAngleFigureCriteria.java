package com.epam.jwd.figure.builder;

import java.util.Objects;

public class MultiAngleFigureCriteria extends FigureCriteria {

    private final int AMOUNT_OF_ANGLES;
    private final int MIN_AMOUNT_OF_ANGLES;
    private final int MAX_AMOUNT_OF_ANGLES;

    public MultiAngleFigureCriteria(double PERIMETER, double AREA, double MIN_PERIMETER, double MAX_PERIMETER, double MIN_AREA, double MAX_AREA, int AMOUNT_OF_ANGLES, int MIN_AMOUNT_OF_ANGLES, int MAX_AMOUNT_OF_ANGLES) {
        super(PERIMETER, AREA, MIN_PERIMETER, MAX_PERIMETER, MIN_AREA, MAX_AREA);
        this.AMOUNT_OF_ANGLES = AMOUNT_OF_ANGLES;
        this.MIN_AMOUNT_OF_ANGLES = MIN_AMOUNT_OF_ANGLES;
        this.MAX_AMOUNT_OF_ANGLES = MAX_AMOUNT_OF_ANGLES;
    }

    public int getAMOUNT_OF_ANGLES() {
        return AMOUNT_OF_ANGLES;
    }

    public int getMIN_AMOUNT_OF_ANGLES() {
        return MIN_AMOUNT_OF_ANGLES;
    }

    public int getMAX_AMOUNT_OF_ANGLES() {
        return MAX_AMOUNT_OF_ANGLES;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigureCriteria that = (MultiAngleFigureCriteria) o;
        return AMOUNT_OF_ANGLES == that.AMOUNT_OF_ANGLES && MIN_AMOUNT_OF_ANGLES == that.MIN_AMOUNT_OF_ANGLES && MAX_AMOUNT_OF_ANGLES == that.MAX_AMOUNT_OF_ANGLES;
    }

    @Override
    public int hashCode() {
        return Objects.hash(AMOUNT_OF_ANGLES, MIN_AMOUNT_OF_ANGLES, MAX_AMOUNT_OF_ANGLES);
    }

    @Override
    public String toString() {
        return "MultiAngleFigureCriteria{" +
                "AMOUNT_OF_ANGLES=" + AMOUNT_OF_ANGLES +
                ", MIN_AMOUNT_OF_ANGLES=" + MIN_AMOUNT_OF_ANGLES +
                ", MAX_AMOUNT_OF_ANGLES=" + MAX_AMOUNT_OF_ANGLES +
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

package com.epam.jwd.figure.builder;

import java.util.Objects;

public abstract class FigureCriteria {

    private final double PERIMETER;
    private final double AREA;
    private final double MIN_PERIMETER;
    private final double MAX_PERIMETER;
    private final double MIN_AREA;
    private final double MAX_AREA;

    public FigureCriteria(double PERIMETER, double AREA, double MIN_PERIMETER, double MAX_PERIMETER, double MIN_AREA, double MAX_AREA) {
        this.PERIMETER = PERIMETER;
        this.AREA = AREA;
        this.MIN_PERIMETER = MIN_PERIMETER;
        this.MAX_PERIMETER = MAX_PERIMETER;
        this.MIN_AREA = MIN_AREA;
        this.MAX_AREA = MAX_AREA;
    }

    public double getPERIMETER() {
        return PERIMETER;
    }

    public double getAREA() {
        return AREA;
    }

    public double getMIN_PERIMETER() {
        return MIN_PERIMETER;
    }

    public double getMAX_PERIMETER() {
        return MAX_PERIMETER;
    }

    public double getMIN_AREA() {
        return MIN_AREA;
    }

    public double getMAX_AREA() {
        return MAX_AREA;
    }
}

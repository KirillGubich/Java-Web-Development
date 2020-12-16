package com.epam.jwd.figure.builder;

import com.epam.jwd.figure.model.FigureType;

public class FigureCriteriaDirector {

    private Builder builder;

    private FigureCriteriaDirector(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void constructLineCriteria(double perimeter) {
        builder.reset();
        builder.setFigureType(FigureType.LINE);
        builder.setPerimeter(perimeter);
        builder.setArea(0);
    }

    public void constructTriangleCriteria(double perimeter, double area) {
        builder.reset();
        builder.setFigureType(FigureType.TRIANGLE);
        builder.setPerimeter(perimeter);
        builder.setArea(area);
    }

    public void constructSquareCriteria(double perimeter, double area) {
        builder.reset();
        builder.setFigureType(FigureType.SQUARE);
        builder.setPerimeter(perimeter);
        builder.setArea(area);
    }

    public void constructMultiAngleFigureCriteria(double perimeter, double area) {
        builder.reset();
        builder.setFigureType(FigureType.MULTI_ANGLE_FIGURE);
        builder.setPerimeter(perimeter);
        builder.setArea(area);
    }

}

package com.epam.jwd.figure.builder;

import com.epam.jwd.figure.model.FigureType;

public class FigureCriteria {

    private FigureType figureType;
    private double perimeter;
    private double area;

    public FigureCriteria() {
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}

package com.epam.jwd.figure.builder;

import com.epam.jwd.figure.model.FigureType;

public class FigureCriteria {

    private FigureType figureType;
    private int amountOfAngles;

    public FigureCriteria() {
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public int getAmountOfAngles() {
        return amountOfAngles;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public void setAmountOfAngles(int amountOfAngles) {
        this.amountOfAngles = amountOfAngles;
    }

}

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

    public void constructPentagon() {
        builder.reset();
        builder.setFigureType(FigureType.MULTI_ANGLE_FIGURE);
        builder.setAmountOfAngles(5);
    }

    public void constructHexagon() {
        builder.reset();
        builder.setFigureType(FigureType.MULTI_ANGLE_FIGURE);
        builder.setAmountOfAngles(6);
    }


}

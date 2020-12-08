package com.epam.jwd.figure.model;

import com.epam.jwd.figure.strategy.FigurePropertiesStrategy;

public abstract class Figure {

    private FigurePropertiesStrategy figurePropertiesStrategy;
    private final FigureType FIGURE_TYPE;

    public Figure(FigurePropertiesStrategy figurePropertiesStrategy, FigureType FIGURE_TYPE) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.FIGURE_TYPE = FIGURE_TYPE;
    }

    public FigureType getFIGURE_TYPE() {
        return FIGURE_TYPE;
    }

    public void setStrategy(FigurePropertiesStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public FigurePropertiesStrategy executeStrategy() {
        return figurePropertiesStrategy;
    }

    public abstract boolean isExist();
}

package com.epam.jwd.figure.model;

import com.epam.jwd.figure.strategy.FigurePropertiesStrategy;

public class Figure {

    private FigurePropertiesStrategy figurePropertiesStrategy;

    public Figure(FigurePropertiesStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public void setStrategy(FigurePropertiesStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public FigurePropertiesStrategy executeStrategy() {
        return figurePropertiesStrategy;
    }
}
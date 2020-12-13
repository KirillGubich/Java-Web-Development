package com.epam.jwd.figure.model;

import com.epam.jwd.figure.strategy.FigurePropertiesStrategy;

public abstract class Figure {

    private FigurePropertiesStrategy figurePropertiesStrategy;
    private final FigureType FIGURE_TYPE;
    private final long ID;
    private static long nextID = 1;

    public Figure(FigurePropertiesStrategy figurePropertiesStrategy, FigureType FIGURE_TYPE) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.FIGURE_TYPE = FIGURE_TYPE;
        ID = nextID++;
    }

    public FigureType getFIGURE_TYPE() {
        return FIGURE_TYPE;
    }

    public long getID() {
        return ID;
    }

    public void setStrategy(FigurePropertiesStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public FigurePropertiesStrategy executeStrategy() {
        return figurePropertiesStrategy;
    }

    public abstract boolean isExist();
}

package main.java.com.epam.jwd.figure.model;

import main.java.com.epam.jwd.figure.strategy.FigurePropertiesStrategy;

public abstract class Figure {

    private FigurePropertiesStrategy figurePropertiesStrategy;
    private final FigureType figureType;
    private final long ID;
    private static long nextID = 1;

    public Figure(FigurePropertiesStrategy figurePropertiesStrategy, FigureType figureType) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
        this.figureType = figureType;
        ID = nextID++;
    }

    public FigureType getFigureType() {
        return figureType;
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

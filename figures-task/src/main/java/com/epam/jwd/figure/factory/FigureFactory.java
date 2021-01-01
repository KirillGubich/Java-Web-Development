package main.java.com.epam.jwd.figure.factory;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;

public interface FigureFactory {

    Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException;

}

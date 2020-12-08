package com.epam.jwd.figure.factory;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Point;

public interface FigureFactory {

    Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException;

}

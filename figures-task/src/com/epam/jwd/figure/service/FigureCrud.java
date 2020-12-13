package com.epam.jwd.figure.service;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Point;

import java.util.List;
import java.util.Map;

public interface FigureCrud {

    Figure createFigure(FigureType type, Point... points) throws FigureException;
    List<Figure> multiCreateFigure(Map<FigureType, List<Point[]>> figureCreateInfo) throws FigureException;
    void deleteFigure(Figure figure) throws FigureException;
    Figure findFigure(Figure figure) throws FigureException;
    void updateFigure(Figure oldFigure, Figure newFigure) throws FigureException;
    Figure findFigureByID(long id) throws FigureException;
    Figure findFigureByCriterion(Figure figure);

}

package com.epam.jwd.figure.service.impl;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.model.impl.MultiAngleFigure;
import com.epam.jwd.figure.model.impl.Square;
import com.epam.jwd.figure.model.impl.Triangle;
import com.epam.jwd.figure.storage.FigureStorage;

public class FigureStorageService {

    private static FigureStorageService instance;

    private FigureStorageService() {
    }

    public static FigureStorageService getInstance() {
        if (instance == null) {
            instance = new FigureStorageService();
        }

        return instance;
    }

    public Figure fetchFigureFromStorage(Figure figure) throws FigureException {
        FigureStorage figureStorage = FigureStorage.getInstance();

        switch (figure.getFIGURE_TYPE()) {
            case LINE:
                figure = figureStorage.fetchLineFromStorage((Line) figure);
                break;
            case TRIANGLE:
                figure = figureStorage.fetchTriangleFromStorage((Triangle) figure);
                break;
            case SQUARE:
                figure = figureStorage.fetchSquareFromStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = figureStorage.fetchMultiAngleFigureFromStorage((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    public void addFigureToStorage(Figure figure) throws FigureException {
        FigureStorage figureStorage = FigureStorage.getInstance();

        switch (figure.getFIGURE_TYPE()) {
            case LINE:
                figureStorage.addLineToStorage((Line) figure);
                break;
            case TRIANGLE:
                figureStorage.addTriangleToStorage((Triangle) figure);
                break;
            case SQUARE:
                figureStorage.addSquareToStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                figureStorage.addMultiAngleFigureToStorage((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }
}

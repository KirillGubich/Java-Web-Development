package com.epam.jwd.figure.service.impl;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.model.impl.MultiAngleFigure;
import com.epam.jwd.figure.model.impl.Square;
import com.epam.jwd.figure.model.impl.Triangle;
import com.epam.jwd.figure.service.FigureStorageService;
import com.epam.jwd.figure.storage.FigureStorage;

public class FigureCacheStorageService implements FigureStorageService {

    private static FigureCacheStorageService instance;
    private static final FigureStorage FIGURE_STORAGE = FigureStorage.getInstance();

    private FigureCacheStorageService() {
    }

    public static FigureCacheStorageService getInstance() {
        if (instance == null) {
            instance = new FigureCacheStorageService();
        }

        return instance;
    }

    @Override
    public Figure fetchFigureFromStorage(Figure figure) throws FigureException {
        switch (figure.getFIGURE_TYPE()) {
            case LINE:
                figure = FIGURE_STORAGE.fetchLineFromStorage((Line) figure);
                break;
            case TRIANGLE:
                figure = FIGURE_STORAGE.fetchTriangleFromStorage((Triangle) figure);
                break;
            case SQUARE:
                figure = FIGURE_STORAGE.fetchSquareFromStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = FIGURE_STORAGE.fetchMultiAngleFigureFromStorage((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    @Override
    public void addFigureToStorage(Figure figure) throws FigureException {
        switch (figure.getFIGURE_TYPE()) {
            case LINE:
                FIGURE_STORAGE.addLineToStorage((Line) figure);
                break;
            case TRIANGLE:
                FIGURE_STORAGE.addTriangleToStorage((Triangle) figure);
                break;
            case SQUARE:
                FIGURE_STORAGE.addSquareToStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                FIGURE_STORAGE.addMultiAngleFigureToStorage((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }

    @Override
    public void removeFigureFromStorage(Figure figure) throws FigureException {
        switch (figure.getFIGURE_TYPE()) {
            case LINE:
                FIGURE_STORAGE.removeLineFromStorage((Line) figure);
                break;
            case TRIANGLE:
                FIGURE_STORAGE.removeTriangleFromStorage((Triangle) figure);
                break;
            case SQUARE:
                FIGURE_STORAGE.removeSquareFromStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                FIGURE_STORAGE.removeMultiAngleFigureFromStorage((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }

    @Override
    public Figure fetchFigureByIDFromStorage(FigureType type, long id) throws FigureException {
        Figure figure;

        switch (type) {
            case LINE:
                figure = FIGURE_STORAGE.fetchLineFromStorageByID(id);
                break;
            case TRIANGLE:
                figure = FIGURE_STORAGE.fetchTriangleFromStorageByID(id);
                break;
            case SQUARE:
                figure = FIGURE_STORAGE.fetchSquareFromStorageByID(id);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = FIGURE_STORAGE.fetchMultiAngleFigureFromStorageByID(id);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }
}

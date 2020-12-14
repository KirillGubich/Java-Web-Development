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
import com.epam.jwd.figure.storage.impl.LineStorage;
import com.epam.jwd.figure.storage.impl.MultiAngleFigureStorage;
import com.epam.jwd.figure.storage.impl.SquareStorage;
import com.epam.jwd.figure.storage.impl.TriangleStorage;

public class FigureCacheStorageService implements FigureStorageService {

    private static FigureCacheStorageService instance;

    private static final FigureStorage<Line> LINE_STORAGE = LineStorage.getInstance();
    private static final FigureStorage<Triangle> TRIANGLE_STORAGE = TriangleStorage.getInstance();
    private static final FigureStorage<Square> SQUARE_STORAGE = SquareStorage.getInstance();
    private static final FigureStorage<MultiAngleFigure> MULTI_ANGLE_FIGURE_STORAGE = MultiAngleFigureStorage.getInstance();

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
                figure = LINE_STORAGE.fetchFromStorage((Line) figure);
                break;
            case TRIANGLE:
                figure = TRIANGLE_STORAGE.fetchFromStorage((Triangle) figure);
                break;
            case SQUARE:
                figure = SQUARE_STORAGE.fetchFromStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = MULTI_ANGLE_FIGURE_STORAGE.fetchFromStorage((MultiAngleFigure) figure);
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
                LINE_STORAGE.addToStorage((Line) figure);
                break;
            case TRIANGLE:
                TRIANGLE_STORAGE.addToStorage((Triangle) figure);
                break;
            case SQUARE:
                SQUARE_STORAGE.addToStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                MULTI_ANGLE_FIGURE_STORAGE.addToStorage((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }

    @Override
    public void removeFigureFromStorage(Figure figure) throws FigureException {
        switch (figure.getFIGURE_TYPE()) {
            case LINE:
                LINE_STORAGE.removeFromStorage((Line) figure);
                break;
            case TRIANGLE:
                TRIANGLE_STORAGE.removeFromStorage((Triangle) figure);
                break;
            case SQUARE:
                SQUARE_STORAGE.removeFromStorage((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                MULTI_ANGLE_FIGURE_STORAGE.removeFromStorage((MultiAngleFigure) figure);
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
                figure = LINE_STORAGE.fetchFromStorageByID(id);
                break;
            case TRIANGLE:
                figure = TRIANGLE_STORAGE.fetchFromStorageByID(id);
                break;
            case SQUARE:
                figure = SQUARE_STORAGE.fetchFromStorageByID(id);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = MULTI_ANGLE_FIGURE_STORAGE.fetchFromStorageByID(id);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }
}

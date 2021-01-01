package main.java.com.epam.jwd.figure.service.impl;

import main.java.com.epam.jwd.figure.builder.LineCriteria;
import main.java.com.epam.jwd.figure.builder.MultiAngleFigureCriteria;
import main.java.com.epam.jwd.figure.builder.SquareCriteria;
import main.java.com.epam.jwd.figure.builder.TriangleCriteria;
import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.exception.FigureNotExistException;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.impl.Line;
import main.java.com.epam.jwd.figure.model.impl.MultiAngleFigure;
import main.java.com.epam.jwd.figure.model.impl.Square;
import main.java.com.epam.jwd.figure.model.impl.Triangle;
import main.java.com.epam.jwd.figure.service.FigureCrud;
import main.java.com.epam.jwd.figure.service.FigureStorageService;

public class FigureCacheStorageService implements FigureStorageService {

    private static FigureCacheStorageService instance;

    private static final FigureCrud<Line, LineCriteria> LINE_CRUD = LineCrud.getInstance();
    private static final FigureCrud<Triangle, TriangleCriteria> TRIANGLE_CRUD = TriangleCrud.getInstance();
    private static final FigureCrud<Square, SquareCriteria> SQUARE_CRUD = SquareCrud.getInstance();
    private static final FigureCrud<MultiAngleFigure, MultiAngleFigureCriteria> MULTI_ANGLE_FIGURE_CRUD = MultiAngleFigureCrud.getInstance();

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
        switch (figure.getFigureType()) {
            case LINE:
                figure = LINE_CRUD.find((Line) figure);
                break;
            case TRIANGLE:
                figure = TRIANGLE_CRUD.find((Triangle) figure);
                break;
            case SQUARE:
                figure = SQUARE_CRUD.find((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = MULTI_ANGLE_FIGURE_CRUD.find((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    @Override
    public void addFigureToStorage(Figure figure) throws FigureException {
        switch (figure.getFigureType()) {
            case LINE:
                LINE_CRUD.add((Line) figure);
                break;
            case TRIANGLE:
                TRIANGLE_CRUD.add((Triangle) figure);
                break;
            case SQUARE:
                SQUARE_CRUD.add((Square) figure);
                break;
            case MULTI_ANGLE_FIGURE:
                MULTI_ANGLE_FIGURE_CRUD.add((MultiAngleFigure) figure);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }
    }


}

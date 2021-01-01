package main.java.com.epam.jwd.figure.service.impl;

import main.java.com.epam.jwd.figure.storage.impl.SquareStorage;
import main.java.com.epam.jwd.figure.builder.SquareCriteria;
import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.ApplicationContext;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.model.impl.SimpleApplicationContext;
import main.java.com.epam.jwd.figure.model.impl.Square;
import main.java.com.epam.jwd.figure.service.FigureCrud;
import main.java.com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SquareCrud implements FigureCrud<Square, SquareCriteria> {

    private static final ApplicationContext APPLICATION_CONTEXT = SimpleApplicationContext.getInstance();
    private static final FigureStorage<Square> SQUARE_STORAGE = SquareStorage.getInstance();
    private static final FigureFactory FIGURE_FACTORY = APPLICATION_CONTEXT.createFigureFactory();
    private static final FigureSearchService<Square, SquareCriteria> FIGURE_SEARCH_SERVICE = new FigureSearchService<>();
    private static SquareCrud instance;

    private SquareCrud() {
    }

    public static SquareCrud getInstance() {
        if (instance == null) {
            instance = new SquareCrud();
        }
        return instance;
    }

    @Override
    public void add(Square figure) {
        SQUARE_STORAGE.addToStorage(figure);
    }

    @Override
    public Square create(Point... points) throws FigureException {
        return (Square) FIGURE_FACTORY.createFigure(FigureType.SQUARE, points);
    }

    @Override
    public List<Square> multiCreate(List<Point[]> figureCreateInfo) throws FigureException {
        List<Square> squares = new ArrayList<>();

        for (Point[] points : figureCreateInfo) {
            squares.add(create(points));
        }

        return squares;
    }

    @Override
    public void save(List<Square> figures) {
        SQUARE_STORAGE.saveToStorage(figures);
    }

    @Override
    public void delete(Square figure) {
        SQUARE_STORAGE.removeFromStorage(figure);
    }

    @Override
    public Square find(Square figure) {
        List<Square> squares = SQUARE_STORAGE.getStorage();
        return FIGURE_SEARCH_SERVICE.search(squares, figure);
    }

    @Override
    public void update(Square oldFigure, Square newFigure) {
        SQUARE_STORAGE.removeFromStorage(oldFigure);
        SQUARE_STORAGE.addToStorage(newFigure);
    }

    @Override
    public Square findByID(long id) {
        List<Square> squares = SQUARE_STORAGE.getStorage();
        return FIGURE_SEARCH_SERVICE.searchByID(squares, id);
    }

    @Override
    public List<Square> findByCriteria(SquareCriteria figureCriteria) {
        if (FIGURE_SEARCH_SERVICE.criteriaAreIncorrect(figureCriteria)) {
            return Collections.emptyList();
        }

        List<Square> suitableSquares = SQUARE_STORAGE.getStorage();
        if (figureCriteria.getA() != null) {
            suitableSquares = searchByPointA(suitableSquares, figureCriteria.getA());
        }
        if (figureCriteria.getB() != null) {
            suitableSquares = searchByPointB(suitableSquares, figureCriteria.getB());
        }
        if (figureCriteria.getC() != null) {
            suitableSquares = searchByPointC(suitableSquares, figureCriteria.getC());
        }
        if (figureCriteria.getD() != null) {
            suitableSquares = searchByPointD(suitableSquares, figureCriteria.getD());
        }
        suitableSquares = FIGURE_SEARCH_SERVICE.processCriteria(suitableSquares, figureCriteria);

        return suitableSquares;
    }

    private static List<Square> searchByPointA(List<Square> squares, Point a) {
        return squares.stream()
                .filter(Objects::nonNull)
                .filter(square -> square.getA().equals(a))
                .collect(Collectors.toList());
    }

    private static List<Square> searchByPointB(List<Square> squares, Point b) {
        return squares.stream()
                .filter(Objects::nonNull)
                .filter(square -> square.getB().equals(b))
                .collect(Collectors.toList());
    }

    private static List<Square> searchByPointC(List<Square> squares, Point c) {
        return squares.stream()
                .filter(Objects::nonNull)
                .filter(square -> square.getC().equals(c))
                .collect(Collectors.toList());
    }

    private static List<Square> searchByPointD(List<Square> squares, Point d) {
        return squares.stream()
                .filter(Objects::nonNull)
                .filter(square -> square.getD().equals(d))
                .collect(Collectors.toList());
    }
}

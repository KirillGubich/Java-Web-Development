package com.epam.jwd.figure.service.impl;

import com.epam.jwd.figure.builder.LineCriteria;
import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.ApplicationContext;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.model.impl.SimpleApplicationContext;
import com.epam.jwd.figure.service.FigureCrud;
import com.epam.jwd.figure.storage.FigureStorage;
import com.epam.jwd.figure.storage.impl.LineStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineCrud implements FigureCrud<Line, LineCriteria> {

    private static final FigureStorage<Line> LINE_STORAGE = LineStorage.getInstance();
    private static final ApplicationContext APPLICATION_CONTEXT = SimpleApplicationContext.getInstance();
    private static final FigureFactory FIGURE_FACTORY = APPLICATION_CONTEXT.createFigureFactory();
    private static final FigureSearchService<Line, LineCriteria> FIGURE_SEARCH_SERVICE = new FigureSearchService<>();
    private static LineCrud instance;

    private LineCrud() {
    }

    public static LineCrud getInstance() {
        if (instance == null) {
            instance = new LineCrud();
        }
        return instance;
    }

    @Override
    public void add(Line figure) {
        LINE_STORAGE.addToStorage(figure);
    }

    @Override
    public Line create(Point... points) throws FigureException {
        return (Line) FIGURE_FACTORY.createFigure(FigureType.LINE, points);
    }

    @Override
    public List<Line> multiCreate(List<Point[]> figureCreateInfo) throws FigureException {
        List<Line> lines = new ArrayList<>();

        for (Point[] points : figureCreateInfo) {
            lines.add(create(points));
        }
        return lines;
    }

    @Override
    public void save(List<Line> figures) {
        LINE_STORAGE.saveToStorage(figures);
    }

    @Override
    public void delete(Line figure) {
        LINE_STORAGE.removeFromStorage(figure);
    }

    @Override
    public Line find(Line figure) {
        List<Line> lines = LINE_STORAGE.getStorage();

        return FIGURE_SEARCH_SERVICE.search(lines, figure);
    }

    @Override
    public void update(Line oldFigure, Line newFigure) {
        LINE_STORAGE.removeFromStorage(oldFigure);
        LINE_STORAGE.addToStorage(newFigure);
    }

    @Override
    public Line findByID(long id) {
        List<Line> lines = LINE_STORAGE.getStorage();
        return FIGURE_SEARCH_SERVICE.searchByID(lines, id);
    }

    @Override
    public List<Line> findByCriteria(LineCriteria figureCriteria) {

        if (FIGURE_SEARCH_SERVICE.criteriaAreIncorrect(figureCriteria)) {
            return Collections.emptyList();
        }

        List<Line> suitableLines = LINE_STORAGE.getStorage();
        if (figureCriteria.getA() != null) {
            suitableLines = searchByPointA(suitableLines, figureCriteria.getA());
        }
        if (figureCriteria.getB() != null) {
            suitableLines = searchByPointB(suitableLines, figureCriteria.getB());
        }
        suitableLines = FIGURE_SEARCH_SERVICE.processCriteria(suitableLines, figureCriteria);

        return suitableLines;
    }

    private static List<Line> searchByPointA(List<Line> lines, Point a) {
        return lines.stream()
                .filter(Objects::nonNull)
                .filter(line -> line.getA().equals(a))
                .collect(Collectors.toList());
    }

    private static List<Line> searchByPointB(List<Line> lines, Point b) {
        return lines.stream()
                .filter(Objects::nonNull)
                .filter(line -> line.getB().equals(b))
                .collect(Collectors.toList());
    }
}

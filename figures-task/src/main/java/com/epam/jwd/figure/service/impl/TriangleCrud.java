package main.java.com.epam.jwd.figure.service.impl;

import main.java.com.epam.jwd.figure.storage.impl.TriangleStorage;
import main.java.com.epam.jwd.figure.builder.TriangleCriteria;
import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.ApplicationContext;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.model.impl.SimpleApplicationContext;
import main.java.com.epam.jwd.figure.model.impl.Triangle;
import main.java.com.epam.jwd.figure.service.FigureCrud;
import main.java.com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TriangleCrud implements FigureCrud<Triangle, TriangleCriteria> {

    private static final ApplicationContext APPLICATION_CONTEXT = SimpleApplicationContext.getInstance();
    private static final FigureFactory FIGURE_FACTORY = APPLICATION_CONTEXT.createFigureFactory();
    private static final FigureStorage<Triangle> TRIANGLE_STORAGE = TriangleStorage.getInstance();
    private static final FigureSearchService<Triangle, TriangleCriteria> FIGURE_SEARCH_SERVICE = new FigureSearchService<>();
    private static TriangleCrud instance;

    private TriangleCrud() {
    }

    public static TriangleCrud getInstance() {
        if (instance == null) {
            instance = new TriangleCrud();
        }
        return instance;
    }

    @Override
    public void add(Triangle figure) {
        TRIANGLE_STORAGE.addToStorage(figure);
    }

    @Override
    public Triangle create(Point... points) throws FigureException {
        return (Triangle) FIGURE_FACTORY.createFigure(FigureType.TRIANGLE, points);
    }

    @Override
    public List<Triangle> multiCreate(List<Point[]> figureCreateInfo) throws FigureException {
        List<Triangle> triangles = new ArrayList<>();

        for (Point[] points : figureCreateInfo) {
            triangles.add(create(points));
        }

        return triangles;
    }

    @Override
    public void save(List<Triangle> figures) {
        TRIANGLE_STORAGE.saveToStorage(figures);
    }

    @Override
    public void delete(Triangle figure) {
        TRIANGLE_STORAGE.removeFromStorage(figure);
    }

    @Override
    public Triangle find(Triangle figure) {
        List<Triangle> triangles = TRIANGLE_STORAGE.getStorage();
        return FIGURE_SEARCH_SERVICE.search(triangles, figure);
    }

    @Override
    public void update(Triangle oldFigure, Triangle newFigure) {
        TRIANGLE_STORAGE.removeFromStorage(oldFigure);
        TRIANGLE_STORAGE.addToStorage(newFigure);
    }

    @Override
    public Triangle findByID(long id) {
        List<Triangle> triangles = TRIANGLE_STORAGE.getStorage();
        return FIGURE_SEARCH_SERVICE.searchByID(triangles, id);
    }

    @Override
    public List<Triangle> findByCriteria(TriangleCriteria figureCriteria) {
        if (FIGURE_SEARCH_SERVICE.criteriaAreIncorrect(figureCriteria)) {
            return Collections.emptyList();
        }

        List<Triangle> suitableTriangles = TRIANGLE_STORAGE.getStorage();
        if (figureCriteria.getA() != null) {
            suitableTriangles = searchByPointA(suitableTriangles, figureCriteria.getA());
        }
        if (figureCriteria.getB() != null) {
            suitableTriangles = searchByPointB(suitableTriangles, figureCriteria.getB());
        }
        if (figureCriteria.getC() != null) {
            suitableTriangles = searchByPointC(suitableTriangles, figureCriteria.getC());
        }
        suitableTriangles = FIGURE_SEARCH_SERVICE.processCriteria(suitableTriangles, figureCriteria);

        return suitableTriangles;
    }

    private static List<Triangle> searchByPointA(List<Triangle> triangles, Point a) {
        return triangles.stream()
                .filter(Objects::nonNull)
                .filter(triangle -> triangle.getA().equals(a))
                .collect(Collectors.toList());
    }

    private static List<Triangle> searchByPointB(List<Triangle> triangles, Point b) {
        return triangles.stream()
                .filter(Objects::nonNull)
                .filter(triangle -> triangle.getB().equals(b))
                .collect(Collectors.toList());
    }

    private static List<Triangle> searchByPointC(List<Triangle> triangles, Point c) {
        return triangles.stream()
                .filter(Objects::nonNull)
                .filter(triangle -> triangle.getC().equals(c))
                .collect(Collectors.toList());
    }
}

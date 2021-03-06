package main.java.com.epam.jwd.figure.service.impl;

import main.java.com.epam.jwd.figure.storage.impl.MultiAngleFigureStorage;
import main.java.com.epam.jwd.figure.builder.MultiAngleFigureCriteria;
import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.ApplicationContext;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.model.impl.MultiAngleFigure;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.model.impl.SimpleApplicationContext;
import main.java.com.epam.jwd.figure.service.FigureCrud;
import main.java.com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MultiAngleFigureCrud implements FigureCrud<MultiAngleFigure, MultiAngleFigureCriteria> {

    private static final FigureStorage<MultiAngleFigure> MULTI_ANGLE_FIGURE_STORAGE = MultiAngleFigureStorage.getInstance();
    private static final ApplicationContext APPLICATION_CONTEXT = SimpleApplicationContext.getInstance();
    private static final FigureFactory FIGURE_FACTORY = APPLICATION_CONTEXT.createFigureFactory();
    private static final FigureSearchService<MultiAngleFigure, MultiAngleFigureCriteria> FIGURE_SEARCH_SERVICE = new FigureSearchService<>();
    private static MultiAngleFigureCrud instance;

    private MultiAngleFigureCrud() {
    }

    public static MultiAngleFigureCrud getInstance() {
        if (instance == null) {
            instance = new MultiAngleFigureCrud();
        }
        return instance;
    }

    @Override
    public void add(MultiAngleFigure figure) {
        MULTI_ANGLE_FIGURE_STORAGE.addToStorage(figure);
    }

    @Override
    public MultiAngleFigure create(Point... points) throws FigureException {
        return (MultiAngleFigure) FIGURE_FACTORY.createFigure(FigureType.MULTI_ANGLE_FIGURE, points);
    }

    @Override
    public List<MultiAngleFigure> multiCreate(List<Point[]> figureCreateInfo) throws FigureException {
        List<MultiAngleFigure> multiAngleFigures = new ArrayList<>();

        for (Point[] points : figureCreateInfo) {
            multiAngleFigures.add(create(points));
        }

        return multiAngleFigures;
    }

    @Override
    public void save(List<MultiAngleFigure> figures) {
        MULTI_ANGLE_FIGURE_STORAGE.saveToStorage(figures);
    }

    @Override
    public void delete(MultiAngleFigure figure) {
        MULTI_ANGLE_FIGURE_STORAGE.removeFromStorage(figure);
    }

    @Override
    public MultiAngleFigure find(MultiAngleFigure figure) {
        List<MultiAngleFigure> multiAngleFigures = MULTI_ANGLE_FIGURE_STORAGE.getStorage();

        return multiAngleFigures.stream()
                .filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage
                        .equals(figure))
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(MultiAngleFigure oldFigure, MultiAngleFigure newFigure) {
        MULTI_ANGLE_FIGURE_STORAGE.removeFromStorage(oldFigure);
        MULTI_ANGLE_FIGURE_STORAGE.addToStorage(newFigure);
    }

    @Override
    public MultiAngleFigure findByID(long id) {
        List<MultiAngleFigure> multiAngleFigures = MULTI_ANGLE_FIGURE_STORAGE.getStorage();

        return multiAngleFigures.stream()
                .filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage.getID() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<MultiAngleFigure> findByCriteria(MultiAngleFigureCriteria figureCriteria) {
        if (FIGURE_SEARCH_SERVICE.criteriaAreIncorrect(figureCriteria)) {
            return Collections.emptyList();
        }

        List<MultiAngleFigure> suitableFigures = MULTI_ANGLE_FIGURE_STORAGE.getStorage();
        if ((figureCriteria.getAmountOfAngles() != 0)) {
            suitableFigures = searchByAmountOfAngles(suitableFigures, figureCriteria.getAmountOfAngles());
        }
        if ((figureCriteria.getMinAmountOfAngles() != 0)) {
            suitableFigures = searchByMinAmountOfAngles(suitableFigures, figureCriteria.getMinAmountOfAngles());
        }
        if ((figureCriteria.getMaxAmountOfAngles() != 0)) {
            suitableFigures = searchByMaxAmountOfAngles(suitableFigures, figureCriteria.getMaxAmountOfAngles());
        }
        suitableFigures = FIGURE_SEARCH_SERVICE.processCriteria(suitableFigures, figureCriteria);

        return suitableFigures;
    }

    private static List<MultiAngleFigure> searchByAmountOfAngles(List<MultiAngleFigure> multiAngleFigures, int amountOfFigures) {
        return multiAngleFigures.stream()
                .filter(Objects::nonNull)
                .filter(multiAngleFigure -> multiAngleFigure.getAmountOfAngles() == amountOfFigures)
                .collect(Collectors.toList());
    }

    private static List<MultiAngleFigure> searchByMinAmountOfAngles(List<MultiAngleFigure> multiAngleFigures, int minAmountOfFigures) {
        return multiAngleFigures.stream()
                .filter(Objects::nonNull)
                .filter(multiAngleFigure -> multiAngleFigure.getAmountOfAngles() > minAmountOfFigures)
                .collect(Collectors.toList());
    }

    private static List<MultiAngleFigure> searchByMaxAmountOfAngles(List<MultiAngleFigure> multiAngleFigures, int maxAmountOfFigures) {
        return multiAngleFigures.stream()
                .filter(Objects::nonNull)
                .filter(multiAngleFigure -> multiAngleFigure.getAmountOfAngles() < maxAmountOfFigures)
                .collect(Collectors.toList());
    }

}

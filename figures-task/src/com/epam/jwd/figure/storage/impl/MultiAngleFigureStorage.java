package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.builder.FigureCriteria;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.MultiAngleFigure;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiAngleFigureStorage implements FigureStorage<MultiAngleFigure> {

    private static MultiAngleFigureStorage instance;
    private static final List<MultiAngleFigure> ALL_CREATED_MULTI_ANGLE_FIGURES = new ArrayList<>();

    private MultiAngleFigureStorage() {
    }

    public static MultiAngleFigureStorage getInstance() {
        if (instance == null) {
            instance = new MultiAngleFigureStorage();
        }
        return instance;
    }

    @Override
    public void addToStorage(MultiAngleFigure figure) {
        ALL_CREATED_MULTI_ANGLE_FIGURES.add(figure);
    }

    @Override
    public void removeFromStorage(MultiAngleFigure figure) {
        ALL_CREATED_MULTI_ANGLE_FIGURES.remove(figure);
    }

    @Override
    public MultiAngleFigure fetchFromStorage(MultiAngleFigure figure) {
        return ALL_CREATED_MULTI_ANGLE_FIGURES.stream()
                .filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage
                .equals(figure))
                .findAny()
                .orElse(null);
    }

    @Override
    public MultiAngleFigure fetchFromStorageByID(long id) {
        return ALL_CREATED_MULTI_ANGLE_FIGURES.stream()
                .filter(multiAngleFigureFromStorage -> multiAngleFigureFromStorage.getID() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void saveToStorage(List<MultiAngleFigure> figures) {
        ALL_CREATED_MULTI_ANGLE_FIGURES.addAll(figures);
    }

    @Override
    public List<Figure> fetchFromStorageByCriteria(FigureCriteria figureCriteria) {
        return ALL_CREATED_MULTI_ANGLE_FIGURES.stream()
                .filter(multiAngleFigure -> multiAngleFigure.executeStrategy()
                        .calculatePerimeter(multiAngleFigure) == figureCriteria.getPerimeter()
                        && multiAngleFigure.executeStrategy().
                        calculateArea(multiAngleFigure) == figureCriteria.getArea())
                .collect(Collectors.toList());
    }
}

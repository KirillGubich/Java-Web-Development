package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.model.impl.MultiAngleFigure;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

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
}

package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

public class LineStorage implements FigureStorage<Line> {

    private static LineStorage instance;
    private static final List<Line> ALL_CREATED_LINES = new ArrayList<>();

    private LineStorage() {
    }

    public static LineStorage getInstance() {
        if (instance == null) {
            instance = new LineStorage();
        }
        return instance;
    }

    @Override
    public void addToStorage(Line figure) {
        ALL_CREATED_LINES.add(figure);
    }

    @Override
    public void removeFromStorage(Line figure) {
        ALL_CREATED_LINES.remove(figure);
    }

    @Override
    public Line fetchFromStorage(Line figure) {
        return ALL_CREATED_LINES.stream()
                .filter(lineFromStorage -> lineFromStorage.equals(figure))
                .findAny()
                .orElse(null);
    }

    @Override
    public Line fetchFromStorageByID(long id) {
        return ALL_CREATED_LINES.stream()
                .filter(lineFromStorage -> lineFromStorage.getID() == id)
                .findAny()
                .orElse(null);
    }
}

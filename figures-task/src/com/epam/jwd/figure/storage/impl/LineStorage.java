package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.builder.FigureCriteria;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.Line;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LineStorage implements FigureStorage<Line> {

    @Override
    public void saveToStorage(List<Line> figures) {
        ALL_CREATED_LINES.addAll(figures);
    }

    @Override
    public List<Figure> fetchFromStorageByCriteria(FigureCriteria figureCriteria) {
        return ALL_CREATED_LINES.stream()
                .filter(line -> line.executeStrategy()
                        .calculatePerimeter(line) == figureCriteria.getPerimeter())
                .collect(Collectors.toList());
    }

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

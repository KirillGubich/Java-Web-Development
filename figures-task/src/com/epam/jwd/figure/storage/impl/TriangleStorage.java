package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.model.impl.Triangle;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

public class TriangleStorage implements FigureStorage<Triangle> {

    private static TriangleStorage instance;
    private static final List<Triangle> ALL_CREATED_TRIANGLES = new ArrayList<>();

    private TriangleStorage() {
    }

    @Override
    public void saveToStorage(List<Triangle> figures) {
        ALL_CREATED_TRIANGLES.addAll(figures);
    }

    @Override
    public List<Triangle> getStorage() {
        return ALL_CREATED_TRIANGLES;
    }

    public static TriangleStorage getInstance() {
        if (instance == null) {
            instance = new TriangleStorage();
        }
        return instance;
    }

    @Override
    public void addToStorage(Triangle figure) {
        ALL_CREATED_TRIANGLES.add(figure);
    }

    @Override
    public void removeFromStorage(Triangle figure) {
        ALL_CREATED_TRIANGLES.remove(figure);
    }
}

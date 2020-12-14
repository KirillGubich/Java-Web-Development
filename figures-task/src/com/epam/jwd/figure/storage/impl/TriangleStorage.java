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

    @Override
    public Triangle fetchFromStorage(Triangle figure) {
        return ALL_CREATED_TRIANGLES.stream()
                .filter(triangleFromStorage -> triangleFromStorage.equals(figure))
                .findAny()
                .orElse(null);
    }

    @Override
    public Triangle fetchFromStorageByID(long id) {
        return ALL_CREATED_TRIANGLES.stream()
                .filter(triangleFromStorage -> triangleFromStorage.getID() == id)
                .findAny()
                .orElse(null);
    }
}

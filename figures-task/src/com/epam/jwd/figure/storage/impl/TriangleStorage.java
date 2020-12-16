package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.builder.FigureCriteria;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.Triangle;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Figure> fetchFromStorageByCriteria(FigureCriteria figureCriteria) {
        return ALL_CREATED_TRIANGLES.stream()
                .filter(triangle -> triangle.executeStrategy()
                        .calculatePerimeter(triangle) == figureCriteria.getPerimeter()
                        && triangle.executeStrategy()
                        .calculateArea(triangle) == figureCriteria.getArea())
                .collect(Collectors.toList());
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

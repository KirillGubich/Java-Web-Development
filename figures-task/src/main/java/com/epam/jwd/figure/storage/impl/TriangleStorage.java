package main.java.com.epam.jwd.figure.storage.impl;

import main.java.com.epam.jwd.figure.model.impl.Triangle;
import main.java.com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

public class TriangleStorage implements FigureStorage<Triangle> {

    private static TriangleStorage instance;
    private static final List<Triangle> allCreatedTriangles = new ArrayList<>();

    private TriangleStorage() {
    }

    @Override
    public void saveToStorage(List<Triangle> figures) {
        allCreatedTriangles.addAll(figures);
    }

    @Override
    public List<Triangle> getStorage() {
        return allCreatedTriangles;
    }

    public static TriangleStorage getInstance() {
        if (instance == null) {
            instance = new TriangleStorage();
        }
        return instance;
    }

    @Override
    public void addToStorage(Triangle figure) {
        allCreatedTriangles.add(figure);
    }

    @Override
    public void removeFromStorage(Triangle figure) {
        allCreatedTriangles.remove(figure);
    }
}

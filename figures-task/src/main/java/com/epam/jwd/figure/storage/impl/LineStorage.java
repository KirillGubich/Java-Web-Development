package main.java.com.epam.jwd.figure.storage.impl;

import main.java.com.epam.jwd.figure.model.impl.Line;
import main.java.com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

public class LineStorage implements FigureStorage<Line> {

    private static LineStorage instance;
    private static final List<Line> allCreatedLines = new ArrayList<>();

    private LineStorage() {
    }

    public static LineStorage getInstance() {
        if (instance == null) {
            instance = new LineStorage();
        }
        return instance;
    }

    @Override
    public void saveToStorage(List<Line> figures) {
        allCreatedLines.addAll(figures);
    }

    @Override
    public List<Line> getStorage() {
        return allCreatedLines;
    }

    @Override
    public void addToStorage(Line figure) {
        allCreatedLines.add(figure);
    }

    @Override
    public void removeFromStorage(Line figure) {
        allCreatedLines.remove(figure);
    }
}

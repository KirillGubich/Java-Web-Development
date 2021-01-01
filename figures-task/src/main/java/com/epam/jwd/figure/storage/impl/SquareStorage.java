package main.java.com.epam.jwd.figure.storage.impl;

import main.java.com.epam.jwd.figure.model.impl.Square;
import main.java.com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

public class SquareStorage implements FigureStorage<Square> {

    private static SquareStorage instance;
    private static final List<Square> allCreatedSquares = new ArrayList<>();

    @Override
    public void saveToStorage(List<Square> figures) {
        allCreatedSquares.addAll(figures);
    }

    @Override
    public List<Square> getStorage() {
        return allCreatedSquares;
    }

    private SquareStorage() {
    }

    public static SquareStorage getInstance() {
        if (instance == null) {
            instance = new SquareStorage();
        }
        return instance;
    }

    @Override
    public void addToStorage(Square figure) {
        allCreatedSquares.add(figure);
    }

    @Override
    public void removeFromStorage(Square figure) {
        allCreatedSquares.remove(figure);
    }
}

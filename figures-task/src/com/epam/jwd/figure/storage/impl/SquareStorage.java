package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.model.impl.Square;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;

public class SquareStorage implements FigureStorage<Square> {

    private static SquareStorage instance;
    private static final List<Square> ALL_CREATED_SQUARES = new ArrayList<>();

    @Override
    public void saveToStorage(List<Square> figures) {
        ALL_CREATED_SQUARES.addAll(figures);
    }

    @Override
    public List<Square> getStorage() {
        return ALL_CREATED_SQUARES;
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
        ALL_CREATED_SQUARES.add(figure);
    }

    @Override
    public void removeFromStorage(Square figure) {
        ALL_CREATED_SQUARES.remove(figure);
    }
}

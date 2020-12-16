package com.epam.jwd.figure.storage.impl;

import com.epam.jwd.figure.builder.FigureCriteria;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.Square;
import com.epam.jwd.figure.storage.FigureStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SquareStorage implements FigureStorage<Square> {

    private static SquareStorage instance;
    private static final List<Square> ALL_CREATED_SQUARES = new ArrayList<>();

    @Override
    public void saveToStorage(List<Square> figures) {
        ALL_CREATED_SQUARES.addAll(figures);
    }

    @Override
    public List<Figure> fetchFromStorageByCriteria(FigureCriteria figureCriteria) {
        return ALL_CREATED_SQUARES.stream()
                .filter(square -> square.executeStrategy()
                        .calculatePerimeter(square) == figureCriteria.getPerimeter()
                        && square.executeStrategy().calculateArea(square) == figureCriteria.getArea())
                .collect(Collectors.toList());
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

    @Override
    public Square fetchFromStorage(Square figure) {
        return ALL_CREATED_SQUARES.stream()
                .filter(squareFromStorage -> squareFromStorage.equals(figure))
                .findAny()
                .orElse(null);
    }

    @Override
    public Square fetchFromStorageByID(long id) {
        return ALL_CREATED_SQUARES.stream().
                filter(squareFromStorage -> squareFromStorage.getID() == id).findAny().orElse(null);
    }
}

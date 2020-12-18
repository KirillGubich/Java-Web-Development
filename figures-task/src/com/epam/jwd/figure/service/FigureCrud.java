package com.epam.jwd.figure.service;

import com.epam.jwd.figure.builder.FigureCriteria;
import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.Point;

import java.util.List;

public interface FigureCrud<T extends Figure, V extends FigureCriteria> {

    T create(Point... points) throws FigureException;

    List<T> multiCreate(List<Point[]> figureCreateInfo) throws FigureException;

    void add(T figure);

    void save(List<T> figures);

    void delete(T figure);

    T find(T figure);

    void update(T oldFigure, T newFigure);

    T findByID(long id);

    List<T> findByCriteria(V figureCriteria);
}

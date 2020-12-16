package com.epam.jwd.figure.storage;

import com.epam.jwd.figure.builder.FigureCriteria;
import com.epam.jwd.figure.model.Figure;

import java.util.List;

public interface FigureStorage<T extends Figure> {

    void addToStorage(T figure);

    void saveToStorage(List<T> figures);

    void removeFromStorage(T figure);

    T fetchFromStorage(T figure);

    T fetchFromStorageByID(long id);

    List<Figure> fetchFromStorageByCriteria(FigureCriteria figureCriteria);
}

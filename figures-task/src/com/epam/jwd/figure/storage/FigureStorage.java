package com.epam.jwd.figure.storage;

import com.epam.jwd.figure.model.Figure;

public interface FigureStorage<T extends Figure> {

    void addToStorage(T figure);

    void removeFromStorage(T figure);

    T fetchFromStorage(T figure);

    T fetchFromStorageByID(long id);
}

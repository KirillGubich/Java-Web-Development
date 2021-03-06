package main.java.com.epam.jwd.figure.storage;

import main.java.com.epam.jwd.figure.model.Figure;

import java.util.List;

public interface FigureStorage<T extends Figure> {

    void addToStorage(T figure);

    void saveToStorage(List<T> figures);

    void removeFromStorage(T figure);

    List<T> getStorage();
}

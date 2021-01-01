package main.java.com.epam.jwd.figure.service;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.model.Figure;

public interface FigureStorageService {

    Figure fetchFigureFromStorage(Figure figure) throws FigureException;

    void addFigureToStorage(Figure figure) throws FigureException;
}

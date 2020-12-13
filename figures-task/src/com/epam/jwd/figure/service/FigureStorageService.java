package com.epam.jwd.figure.service;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;

public interface FigureStorageService {

    Figure fetchFigureFromStorage(Figure figure) throws FigureException;
    void addFigureToStorage(Figure figure) throws FigureException;
    void removeFigureFromStorage(Figure figure) throws FigureException;
    Figure fetchFigureByIDFromStorage(FigureType type, long id) throws FigureException;
}

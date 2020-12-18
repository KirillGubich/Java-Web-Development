package com.epam.jwd.figure.service;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Figure;

public interface FigureStorageService {

    Figure fetchFigureFromStorage(Figure figure) throws FigureException;

    void addFigureToStorage(Figure figure) throws FigureException;
}

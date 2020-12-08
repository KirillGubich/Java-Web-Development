package com.epam.jwd.figure.service.impl;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.service.FigurePostProcessor;

public class FigureStoragePostProcessor implements FigurePostProcessor {

    private static FigureStoragePostProcessor instance;

    private FigureStoragePostProcessor() {
    }

    public static FigureStoragePostProcessor getInstance() {
        if (instance == null) {
            instance = new FigureStoragePostProcessor();
        }

        return instance;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {

        Figure figureFromStorage;
        figureFromStorage = FigureStorageService.getInstance().fetchFigureFromStorage(figure);

        if (figureFromStorage == null) {
            FigureStorageService.getInstance().addFigureToStorage(figure);
        } else {
            figure = figureFromStorage;
        }

        return figure;
    }
}

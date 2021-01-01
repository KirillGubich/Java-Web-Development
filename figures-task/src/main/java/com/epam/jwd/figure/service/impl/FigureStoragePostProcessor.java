package main.java.com.epam.jwd.figure.service.impl;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.service.FigurePostProcessor;
import main.java.com.epam.jwd.figure.service.FigureStorageService;

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
        FigureStorageService figureStorageService = FigureCacheStorageService.getInstance();
        figureFromStorage = figureStorageService.fetchFigureFromStorage(figure);

        if (figureFromStorage == null) {
            figureStorageService.addFigureToStorage(figure);
        } else {
            figure = figureFromStorage;
        }

        return figure;
    }
}

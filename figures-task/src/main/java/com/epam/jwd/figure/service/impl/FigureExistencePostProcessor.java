package main.java.com.epam.jwd.figure.service.impl;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.exception.FigureNotExistException;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    private static FigureExistencePostProcessor instance;

    private FigureExistencePostProcessor() {
    }

    public static FigureExistencePostProcessor getInstance() {
        if (instance == null) {
            instance = new FigureExistencePostProcessor();
        }
        return instance;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {

        if (!exists(figure)) {
            throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

    private boolean exists(Figure figure) {

        return figure.isExist();
    }
}

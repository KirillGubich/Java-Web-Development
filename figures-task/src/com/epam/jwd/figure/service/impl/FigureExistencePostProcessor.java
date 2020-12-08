package com.epam.jwd.figure.service.impl;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureNotExistException;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.service.FigurePostProcessor;

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

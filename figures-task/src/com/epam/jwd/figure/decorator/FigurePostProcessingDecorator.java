package com.epam.jwd.figure.decorator;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.service.FigurePostProcessor;
import com.epam.jwd.figure.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.figure.service.impl.FigureStoragePostProcessor;

public class FigurePostProcessingDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private static final FigurePostProcessor[] FIGURE_POST_PROCESSORS = {FigureExistencePostProcessor.getInstance(),
            FigureStoragePostProcessor.getInstance()};

    public FigurePostProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {

        Figure figure;
        figure = figureFactory.createFigure(type, figureConstituents);
        for (FigurePostProcessor figurePostProcessor : FIGURE_POST_PROCESSORS) {
            figure = figurePostProcessor.process(figure);
        }

        return figure;
    }
}

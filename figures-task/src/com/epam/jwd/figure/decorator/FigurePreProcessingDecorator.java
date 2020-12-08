package com.epam.jwd.figure.decorator;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.service.FigurePreProcessor;
import com.epam.jwd.figure.service.impl.DuplicatePointsPreProcessor;

public class FigurePreProcessingDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private static final FigurePreProcessor[] FIGURE_PRE_PROCESSORS = {DuplicatePointsPreProcessor.getInstance()};

    public FigurePreProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        for (FigurePreProcessor figurePreProcessor : FIGURE_PRE_PROCESSORS) {
            figurePreProcessor.preProcess(figureConstituents);
        }

        return figureFactory.createFigure(type, figureConstituents);
    }
}

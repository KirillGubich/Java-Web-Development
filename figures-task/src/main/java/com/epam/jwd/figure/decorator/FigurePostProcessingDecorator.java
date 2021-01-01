package main.java.com.epam.jwd.figure.decorator;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.service.FigurePostProcessor;

import java.util.ArrayList;
import java.util.List;

public class FigurePostProcessingDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private static final List<FigurePostProcessor> figurePostProcessors = new ArrayList<>();

    public FigurePostProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    public void addPostProcessor(FigurePostProcessor figurePostProcessor) {
        figurePostProcessors.add(figurePostProcessor);
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        Figure figure;
        figure = figureFactory.createFigure(type, figureConstituents);
        for (FigurePostProcessor figurePostProcessor : figurePostProcessors) {
            figure = figurePostProcessor.process(figure);
        }

        return figure;
    }
}

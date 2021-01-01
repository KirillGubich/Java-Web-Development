package main.java.com.epam.jwd.figure.decorator;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.model.impl.Point;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.service.FigurePreProcessor;

import java.util.ArrayList;
import java.util.List;

public class FigurePreProcessingDecorator implements FigureFactory {

    private final FigureFactory figureFactory;
    private static final List<FigurePreProcessor> figurePreProcessors = new ArrayList<>();

    public FigurePreProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    public void addPreProcessor(FigurePreProcessor figurePreProcessor) {
        figurePreProcessors.add(figurePreProcessor);
    }


    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        for (FigurePreProcessor figurePreProcessor : figurePreProcessors) {
            figurePreProcessor.preProcess(figureConstituents);
        }

        return figureFactory.createFigure(type, figureConstituents);
    }
}

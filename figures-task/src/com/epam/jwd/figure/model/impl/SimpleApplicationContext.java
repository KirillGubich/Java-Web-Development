package com.epam.jwd.figure.model.impl;

import com.epam.jwd.figure.decorator.FigurePostProcessingDecorator;
import com.epam.jwd.figure.decorator.FigurePreProcessingDecorator;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.ApplicationContext;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.service.impl.DuplicatePointsPreProcessor;
import com.epam.jwd.figure.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.figure.service.impl.FigureStoragePostProcessor;

public class SimpleApplicationContext implements ApplicationContext {

    private static FigureFactory figureFactory;
    private static SimpleApplicationContext instance;

    private SimpleApplicationContext() {
    }

    public static SimpleApplicationContext getInstance() {
        if (instance == null) {
            instance = new SimpleApplicationContext();
        }

        return instance;
    }

    @Override
    public FigureFactory createFigureFactory() {
        if (figureFactory == null) {
            figureFactory = createPostProcessingDecorator(createPreProcessingDecorator(SimpleFigureFactory.getInstance()));
        }
        return figureFactory;
    }

    private FigurePreProcessingDecorator createPreProcessingDecorator(FigureFactory figureFactory) {
        FigurePreProcessingDecorator figurePreProcessingDecorator =
                new FigurePreProcessingDecorator(figureFactory);
        figurePreProcessingDecorator.addPreProcessor(DuplicatePointsPreProcessor.getInstance());

        return figurePreProcessingDecorator;
    }

    private FigureFactory createPostProcessingDecorator(FigurePreProcessingDecorator figurePreProcessingDecorator) {
        FigurePostProcessingDecorator figurePostProcessingDecorator =
                new FigurePostProcessingDecorator(figurePreProcessingDecorator);
        figurePostProcessingDecorator.addPostProcessor(FigureExistencePostProcessor.getInstance());
        figurePostProcessingDecorator.addPostProcessor(FigureStoragePostProcessor.getInstance());

        return figurePostProcessingDecorator;
    }
}

package main.java.com.epam.jwd.figure.model.impl;

import main.java.com.epam.jwd.figure.service.impl.DuplicatePointsPreProcessor;
import main.java.com.epam.jwd.figure.service.impl.FigureExistencePostProcessor;
import main.java.com.epam.jwd.figure.service.impl.FigureStoragePostProcessor;
import main.java.com.epam.jwd.figure.decorator.FigurePostProcessingDecorator;
import main.java.com.epam.jwd.figure.decorator.FigurePreProcessingDecorator;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.ApplicationContext;

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

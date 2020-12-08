package com.epam.jwd.figure.model.impl;

import com.epam.jwd.figure.decorator.FigurePostProcessingDecorator;
import com.epam.jwd.figure.decorator.FigurePreProcessingDecorator;
import com.epam.jwd.figure.factory.FigureFactory;
import com.epam.jwd.figure.model.ApplicationContext;

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
            figureFactory = new FigurePostProcessingDecorator(new FigurePreProcessingDecorator(SimpleFigureFactory.getInstance()));
        }
        return figureFactory;
    }
}

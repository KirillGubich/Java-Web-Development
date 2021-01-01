package main.java.com.epam.jwd.figure.model.impl;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.exception.FigureNotExistException;
import main.java.com.epam.jwd.figure.factory.FigureFactory;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;

public class SimpleFigureFactory implements FigureFactory {

    public static SimpleFigureFactory instance;

    private SimpleFigureFactory() {
    }

    public static SimpleFigureFactory getInstance() {
        if (instance == null) {
            instance = new SimpleFigureFactory();
        }

        return instance;
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        Figure figure;

        switch (type) {
            case LINE:
                figure = new Line(figureConstituents[0], figureConstituents[1]);
                break;
            case TRIANGLE:
                figure = new Triangle(figureConstituents[0], figureConstituents[1], figureConstituents[2]);
                break;
            case SQUARE:
                figure = new Square(figureConstituents[0], figureConstituents[1], figureConstituents[2], figureConstituents[3]);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = new MultiAngleFigure(figureConstituents);
                break;
            default:
                throw new FigureNotExistException("Figure not exist");
        }

        return figure;
    }

}

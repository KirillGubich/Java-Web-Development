package main.java.com.epam.jwd.figure.service;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.model.impl.Point;

public interface FigurePreProcessor {

    void preProcess(Point... points) throws FigureException;

}

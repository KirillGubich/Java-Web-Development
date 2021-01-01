package main.java.com.epam.jwd.figure.service;

import main.java.com.epam.jwd.figure.exception.FigureException;
import main.java.com.epam.jwd.figure.model.Figure;

public interface FigurePostProcessor {

    Figure process(Figure figure) throws FigureException;
}

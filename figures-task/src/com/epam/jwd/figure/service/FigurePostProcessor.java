package com.epam.jwd.figure.service;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Figure;

public interface FigurePostProcessor {

    Figure process(Figure figure) throws FigureException;
}

package com.epam.jwd.figure.service;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.impl.Point;

public interface FigurePreProcessor {

    void preProcess(Point... points) throws FigureException;

}

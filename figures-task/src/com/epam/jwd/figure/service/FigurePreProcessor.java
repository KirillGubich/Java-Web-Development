package com.epam.jwd.figure.service;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.model.Point;

public interface FigurePreProcessor {

    Point[] process(Point... points) throws FigureException;

}

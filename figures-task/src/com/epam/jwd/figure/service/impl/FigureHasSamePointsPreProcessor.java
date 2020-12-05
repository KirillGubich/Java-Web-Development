package com.epam.jwd.figure.service.impl;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureHasSamePointsException;
import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.model.Point;
import com.epam.jwd.figure.service.FigurePreProcessor;

public class FigureHasSamePointsPreProcessor implements FigurePreProcessor {

    private static FigureHasSamePointsPreProcessor instance;

    private FigureHasSamePointsPreProcessor() {
    }

    public static FigureHasSamePointsPreProcessor getInstance() {
        if (instance == null) {
            instance = new FigureHasSamePointsPreProcessor();
        }
        return instance;
    }

    @Override
    public Point[] process(Point... points) throws FigureException {

        if (PointLogic.hasSamePoints(points)) {
            throw new FigureHasSamePointsException("Figure has same points");
        }

        return points;
    }
}

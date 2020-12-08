package com.epam.jwd.figure.service.impl;

import com.epam.jwd.figure.exception.FigureException;
import com.epam.jwd.figure.exception.FigureHasSamePointsException;
import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.model.impl.Point;
import com.epam.jwd.figure.service.FigurePreProcessor;

public class DuplicatePointsPreProcessor implements FigurePreProcessor {

    private static DuplicatePointsPreProcessor instance;

    private DuplicatePointsPreProcessor() {
    }

    public static DuplicatePointsPreProcessor getInstance() {
        if (instance == null) {
            instance = new DuplicatePointsPreProcessor();
        }
        return instance;
    }

    @Override
    public void preProcess(Point... points) throws FigureException {
        if (PointLogic.hasSamePoints(points)) {
            throw new FigureHasSamePointsException("Figure has same points");
        }
    }
}

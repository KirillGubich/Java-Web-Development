package com.epam.jwd.figure.strategy;

import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.impl.Line;

public enum LinePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double calculateArea(Figure figure) {
        return 0;
    }

    @Override
    public double calculatePerimeter(Figure figure) {

        Line line = (Line) figure;
        return PointLogic.getDistance(line.getA(), line.getB());
    }
}

package com.epam.jwd.figure.model.impl;

import com.epam.jwd.figure.logic.PointLogic;
import com.epam.jwd.figure.model.Figure;
import com.epam.jwd.figure.model.FigureType;
import com.epam.jwd.figure.strategy.MultiAngleFigurePropertiesStrategy;

import java.util.Arrays;
import java.util.Objects;

public class MultiAngleFigure extends Figure {

    private final int AMOUNT_OF_ANGLES;
    private final Point[] POINTS;

    MultiAngleFigure(Point[] POINTS) {
        super(MultiAngleFigurePropertiesStrategy.INSTANCE, FigureType.MULTI_ANGLE_FIGURE);
        AMOUNT_OF_ANGLES = POINTS.length;
        this.POINTS = POINTS;
    }

    public int getAMOUNT_OF_ANGLES() {
        return AMOUNT_OF_ANGLES;
    }

    public Point[] getPOINTS() {
        return POINTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return AMOUNT_OF_ANGLES == that.AMOUNT_OF_ANGLES &&
                Arrays.equals(POINTS, that.POINTS);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(AMOUNT_OF_ANGLES);
        result = 31 * result + Arrays.hashCode(POINTS);
        return result;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure: " +
                "AMOUNT_OF_ANGLES: " + AMOUNT_OF_ANGLES +
                ", points: " + Arrays.toString(POINTS);
    }

    @Override
    public boolean isExist() {

        return !(PointLogic.hasSamePoints(this.getPOINTS()));
    }
}

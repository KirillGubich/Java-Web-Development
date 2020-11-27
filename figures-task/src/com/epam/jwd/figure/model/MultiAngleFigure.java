package com.epam.jwd.figure.model;

import com.epam.jwd.figure.strategy.FigurePropertiesStrategy;
import com.epam.jwd.figure.strategy.MultiAngleFigurePropertiesStrategy;

import java.util.Arrays;
import java.util.Objects;

public class MultiAngleFigure extends Figure {

    private final int AMOUNT_OF_ANGLES;
    private Point[] points;

    MultiAngleFigure(Point[] points) {
        super(MultiAngleFigurePropertiesStrategy.INSTANCE);
        AMOUNT_OF_ANGLES = points.length;
        this.points = points;
    }

    public int getAMOUNT_OF_ANGLES() {
        return AMOUNT_OF_ANGLES;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return AMOUNT_OF_ANGLES == that.AMOUNT_OF_ANGLES &&
                Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(AMOUNT_OF_ANGLES);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure: " +
                "AMOUNT_OF_ANGLES: " + AMOUNT_OF_ANGLES +
                ", points: " + Arrays.toString(points);
    }
}

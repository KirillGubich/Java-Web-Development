package main.java.com.epam.jwd.figure.model.impl;

import main.java.com.epam.jwd.figure.logic.PointLogic;
import main.java.com.epam.jwd.figure.model.Figure;
import main.java.com.epam.jwd.figure.model.FigureType;
import main.java.com.epam.jwd.figure.strategy.MultiAngleFigurePropertiesStrategy;

import java.util.Arrays;
import java.util.Objects;

public class MultiAngleFigure extends Figure {

    private final int amountOfAngles;
    private final Point[] points;

    MultiAngleFigure(Point[] points) {
        super(MultiAngleFigurePropertiesStrategy.INSTANCE, FigureType.MULTI_ANGLE_FIGURE);
        amountOfAngles = points.length;
        this.points = points;
    }

    public int getAmountOfAngles() {
        return amountOfAngles;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return amountOfAngles == that.amountOfAngles &&
                Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(amountOfAngles);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure: " +
                "AMOUNT_OF_ANGLES: " + amountOfAngles +
                ", points: " + Arrays.toString(points);
    }

    @Override
    public boolean isExist() {
        return !(PointLogic.hasSamePoints(this.getPoints()));
    }
}
